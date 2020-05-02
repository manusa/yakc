/*
 * Copyright 2020 Marc Nuri
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created on 2020-04-25, 17:21
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.ExecMessage;
import com.marcnuri.yakc.api.ExecMessage.StandardStream;
import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ReadNamespacedPodLog;
import com.marcnuri.yakc.apiextensions.ExtendedCoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import io.reactivex.disposables.Disposable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-25.
 */
@TestMethodOrder(OrderAnnotation.class)
class PodIT {

  private static final String NAMESPACE = "default";

  private static KubernetesClient kc;
  private static String podName;

  @BeforeAll
  static void setUp() {
    kc = new KubernetesClient();
    podName = UUID.randomUUID().toString();
  }

  @AfterAll
  static void tearDown() {
//    kc.close(); // TODO: Enable when isolated OkHttp dispatchers and pools are available
    kc = null;
  }

  @Test
  @Order(1)
  @DisplayName("createNamespacedPod, should create pod in default namespace")
  void createNamespacedPod() throws IOException {
    // When
    final Pod pod = kc.create(CoreV1Api.class).createNamespacedPod(NAMESPACE, Pod.builder()
      .metadata(ObjectMeta.builder()
        .name(podName)
        .putInLabels("app", "yakc-pod-it")
        .putInAnnotations("com.marcnuri.yakc", "yakc-pod-it")
        .build())
      .spec(PodSpec.builder()
        .addToContainers(Container.builder()
          .image("busybox")
          .addToCommand("/bin/sh")
          .addToCommand("-c")
          .addToCommand("echo 'Busybox for IT started' && sleep 3600")
          .name("yakc-pod-it")
          .build())
        .build())
      .build()).get();
    // Then
    assertThat(pod).isNotNull();
    assertThat(pod.getMetadata().getName()).isEqualTo(podName);
    assertThat(pod.getSpec().getContainers()).hasSize(1);
    assertThat(pod.getSpec().getContainers().get(0).getImage()).isEqualTo("busybox");
  }

  @Test
  @Order(2)
  @DisplayName("listNamespacedPod.watch, should await for notification of newly created Pod")
  void awaitCreateWatch() throws IOException {
    // Given
    final AtomicBoolean hasError = new AtomicBoolean(false);
    final AtomicBoolean hasCompleted = new AtomicBoolean(false);
    // When
    final Disposable d = kc.create(CoreV1Api.class).listNamespacedPod(NAMESPACE)
      .watch()
      .filter(we -> we.getObject().getMetadata().getName().equals(podName))
      .takeUntil(we -> we.getType() == Type.ADDED)
      .timeout(20, TimeUnit.SECONDS)
      .subscribe(we -> hasCompleted.set(true), we -> hasError.set(true));
    // Then
    assertThat(d).isNotNull();
    assertThat(hasError.get()).as("Watch subscribe ended with an error").isFalse();
    assertThat(hasCompleted.get()).as("Watch subscribe did not complete").isTrue();
  }

  @Test
  @Order(3)
  @DisplayName("listNamespacedPod.stream, should await for notification of newly created Pod")
  void listNamespacedPodStream() throws IOException {
    // When
    final boolean result = kc.create(CoreV1Api.class).listNamespacedPod(NAMESPACE).stream()
      .anyMatch(pod -> pod.getMetadata().getName().equals(podName));
    // Then
    assertThat(result).as("Created Pod was not found").isTrue();
  }

  @Test
  @Order(4)
  @DisplayName("patchNamespacedPod, should patch labels of Pod")
  void patchNamespacedPod() throws IOException {
    // When
    final Pod result = kc.create(CoreV1Api.class)
      .patchNamespacedPod(podName, NAMESPACE, Pod.builder()
        .metadata(
          ObjectMeta.builder()
            .putInLabels("patched", "label")
            .build()
        ).build()).get();
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getMetadata().getName()).isEqualTo(podName);
    assertThat(result.getSpec().getContainers()).hasSize(1);
    assertThat(result.getSpec().getContainers().get(0).getImage()).isEqualTo("busybox");
  }

  @Test
  @Order(5)
  @DisplayName("execInNamespacedPod, with no container param, should stream response in out standard stream")
  void execInNamespacedPodOnlyContainer() throws IOException {
    // Given
    kc.create(CoreV1Api.class).listNamespacedPod(NAMESPACE).watch()
      .filter(we -> we.getType() == Type.MODIFIED)
      .filter(we -> we.getObject().getMetadata().getName().equals(podName))
      .takeUntil(we -> (boolean)we.getObject().getStatus().getConditions().stream()
        .anyMatch(pc -> pc.getType().equals("ContainersReady")))
      .timeout(20, TimeUnit.SECONDS)
      .subscribe();
    final AtomicReference<ExecMessage> response = new AtomicReference<>();
    final AtomicReference<Throwable> error = new AtomicReference<>();
    // When
    kc.create(ExtendedCoreV1Api.class)
      .execInNamespacedPod(podName, NAMESPACE, Arrays.asList("/bin/sh", "-c", "echo 'Hello World'"))
      .exec().skip(1).subscribe(response::set, error::set);
    // Then
    assertThat(error.get()).as("Expected error to be null, but was: %s", error.get()).isNull();
    assertThat(response.get().getStandardStream()).isEqualTo(StandardStream.STDOUT);
    assertThat(response.get().getMessage()).isEqualTo("Hello World\n");
  }

  @Test
  @Order(6)
  @DisplayName("execInNamespacedPod, with valid container param, should stream response in out standard stream")
  void execInNamespacedPodValidContainer() {
    // Given
    final AtomicReference<ExecMessage> response = new AtomicReference<>();
    final AtomicReference<Throwable> error = new AtomicReference<>();
    // When
    kc.create(ExtendedCoreV1Api.class)
      .execInNamespacedPod(podName, NAMESPACE, "yakc-pod-it", Arrays.asList("/bin/sh", "-c", "echo 'Hello World for yakc-pod-it'"))
      .exec().skip(1).subscribe(response::set, error::set);
    // Then
    assertThat(error.get()).isNull();
    assertThat(response.get().getStandardStream()).isEqualTo(StandardStream.STDOUT);
    assertThat(response.get().getMessage()).isEqualTo("Hello World for yakc-pod-it\n");
  }

  @Test
  @Order(7)
  @DisplayName("execInNamespacedPod, with invalid container param, should throw exception")
  void execInNamespacedPodInvalidContainer() throws IOException {
    // Given
    final AtomicReference<ExecMessage> response = new AtomicReference<>();
    final AtomicReference<Throwable> error = new AtomicReference<>();
    // When
    kc.create(ExtendedCoreV1Api.class)
      .execInNamespacedPod(podName, NAMESPACE, "not-valid-container", Arrays.asList("/bin/sh", "-c", "echo 'Hello World for yakc-pod-it'"))
      .exec().skip(1).subscribe(response::set, error::set);
    // Then
    assertThat(response.get()).isNull();
    assertThat(error.get().getMessage())
      .contains(String.format("container not-valid-container is not valid for pod %s", podName));
    assertThat(error.get()).isInstanceOf(KubernetesException.class);
    assertThat(((KubernetesException)error.get()).getCode()).isEqualTo(400);
  }

  @Test
  @Order(8)
  @DisplayName("replaceNamespacedPod, should replace existing Pod's image")
  void replaceNamespacedPod() throws IOException {
    // Given
    final Pod existingPod = kc.create(CoreV1Api.class).readNamespacedPod(podName, NAMESPACE).get();
    existingPod.getMetadata().setResourceVersion(null);
    existingPod.getSpec().getContainers().get(0).setImage("nginxdemos/hello");
    // When
    final Pod result = kc.create(CoreV1Api.class)
      .replaceNamespacedPod(podName, NAMESPACE, existingPod).get();
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getMetadata().getName()).isEqualTo(podName);
    assertThat(result.getSpec().getContainers()).hasSize(1);
    assertThat(result.getSpec().getContainers().get(0).getImage()).isEqualTo("nginxdemos/hello");
  }

  @Test
  @Order(9)
  @DisplayName("readNamespacedPodLog, should wait for pod to start and retrieve logs")
  void readNamespacedPodLog() throws IOException {
    // Given
    kc.create(CoreV1Api.class).listNamespacedPod(NAMESPACE).watch()
      .filter(we -> we.getType() == Type.MODIFIED)
      .filter(we -> we.getObject().getMetadata().getName().equals(podName))
      .takeUntil(we -> (boolean)we.getObject().getStatus().getConditions().stream()
        .anyMatch(pc -> pc.getType().equals("ContainersReady")))
      .timeout(20, TimeUnit.SECONDS)
      .subscribe();
    // When
    final String podLog = kc.create(CoreV1Api.class).readNamespacedPodLog(podName, NAMESPACE,
      new ReadNamespacedPodLog().timestamps(true)).get();
    // Then
    assertThat(podLog).contains("Busybox for IT started");
  }

  @Test
  @Order(10)
  @DisplayName("deleteNamespacedPod, should delete existing Pod")
  void deleteNamespacedPod() throws IOException {
    // When
    final Pod result = kc.create(CoreV1Api.class).deleteNamespacedPod(podName, NAMESPACE).get();
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getMetadata().getName()).isEqualTo(podName);
    assertThat(result.getMetadata().getDeletionTimestamp()).isNotNull();
  }
}
