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
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ReadNamespacedPodLog;
import com.marcnuri.yakc.apiextensions.ExtendedCoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import io.reactivex.disposables.Disposable;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(KubernetesClientExtension.class)
class PodIT {

  private static final String NAMESPACE = "default";

  private String podName;
  private Pod pod;

  @BeforeEach
  void setUp() throws IOException {
    podName = "a" + UUID.randomUUID();
    pod = createPodForTest(NAMESPACE, podName);
  }

  @AfterEach
  void tearDown() throws IOException {
    deletePodForTest(NAMESPACE, podName);
  }

  @Test
  @DisplayName("createNamespacedPod, should create pod in default namespace")
  void createNamespacedPod() {
    // Then
    assertThat(pod)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", podName)
      .extracting(Pod::getSpec).extracting(PodSpec::getContainers).asList()
      .hasSize(1)
      .element(0)
      .hasFieldOrPropertyWithValue("image", "busybox");
    assertThat(pod.getMetadata().getCreationTimestamp()).isNotNull();
  }

  @Test
  @DisplayName("listNamespacedPod.watch, should await for notification of newly created Pod")
  void awaitCreateWatch() throws IOException {
    // Given
    final AtomicBoolean hasError = new AtomicBoolean(false);
    final AtomicBoolean hasCompleted = new AtomicBoolean(false);
    // When
    final Disposable d = KC.create(CoreV1Api.class).listNamespacedPod(NAMESPACE)
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
  @DisplayName("listNamespacedPod.stream, should list newly created Pod")
  void listNamespacedPodStream() throws IOException {
    // When
    final boolean result = KC.create(CoreV1Api.class).listNamespacedPod(NAMESPACE).stream()
      .anyMatch(pod -> pod.getMetadata().getName().equals(podName));
    // Then
    assertThat(result).as("Created Pod was not found").isTrue();
  }

  @Test
  @DisplayName("patchNamespacedPod, should patch labels of Pod")
  void patchNamespacedPod() throws IOException {
    // When
    final Pod result = KC.create(CoreV1Api.class)
      .patchNamespacedPod(podName, NAMESPACE, Pod.builder()
        .metadata(
          ObjectMeta.builder()
            .putInLabels("patched", "label")
            .clearAnnotations()
            .build()
        ).build()).get();
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", podName)
      .extracting(Pod::getMetadata)
      .hasFieldOrPropertyWithValue("name", podName)
      .extracting(ObjectMeta::getLabels).asInstanceOf(InstanceOfAssertFactories.MAP)
      .hasSize(2)
      .containsEntry("patched", "label");
  }

  @Test
  @DisplayName("execInNamespacedPod, with no container param, should stream response in out standard stream")
  void execInNamespacedPodOnlyContainer() throws IOException {
    // Given
    awaitPodReady();
    final AtomicReference<ExecMessage> response = new AtomicReference<>();
    final AtomicReference<Throwable> error = new AtomicReference<>();
    // When
    KC.create(ExtendedCoreV1Api.class)
      .execInNamespacedPod(podName, NAMESPACE, Arrays.asList("/bin/sh", "-c", "echo 'Hello World'"))
      .exec().skip(1).subscribe(response::set, error::set);
    // Then
    assertThat(error.get()).as("Expected error to be null, but was: %s", error.get()).isNull();
    assertThat(response.get())
      .returns(StandardStream.STDOUT, ExecMessage::getStandardStream)
      .returns("Hello World\n", ExecMessage::getMessage);
  }

  @Test
  @DisplayName("execInNamespacedPod, with valid container param, should stream response in out standard stream")
  void execInNamespacedPodValidContainer() throws IOException {
    // Given
    awaitPodReady();
    final AtomicReference<ExecMessage> response = new AtomicReference<>();
    final AtomicReference<Throwable> error = new AtomicReference<>();
    // When
    KC.create(ExtendedCoreV1Api.class)
      .execInNamespacedPod(podName, NAMESPACE, "yakc-pod-it", Arrays.asList("/bin/sh", "-c", "echo 'Hello World for yakc-pod-it'"))
      .exec().skip(1).subscribe(response::set, error::set);
    // Then
    assertThat(error.get()).isNull();
    assertThat(response.get())
      .returns(StandardStream.STDOUT, ExecMessage::getStandardStream)
      .returns("Hello World for yakc-pod-it\n", ExecMessage::getMessage);
  }

  @Test
  @DisplayName("execInNamespacedPod, with invalid container param, should throw exception")
  void execInNamespacedPodInvalidContainer() throws IOException {
    // Given
    awaitPodReady();
    final AtomicReference<ExecMessage> response = new AtomicReference<>();
    final AtomicReference<Throwable> error = new AtomicReference<>();
    // When
    KC.create(ExtendedCoreV1Api.class)
      .execInNamespacedPod(podName, NAMESPACE, "not-valid-container", Arrays.asList("/bin/sh", "-c", "echo 'Hello World for yakc-pod-it'"))
      .exec().skip(1).subscribe(response::set, error::set);
    // Then
    assertThat(response.get()).isNull();
    assertThat(error.get())
      .isInstanceOf(KubernetesException.class)
      .hasFieldOrPropertyWithValue("code", 400)
      .extracting("message").asString()
      .contains(String.format("container not-valid-container is not valid for pod %s", podName));
  }

  @Test
  @DisplayName("execInNamespacedPod, with valid container param, should upgrade to websocket")
  void execInNamespacedPodValidContainerTty() throws IOException, InterruptedException {
    // Given
    awaitPodReady();
    final CountDownLatch openLatch = new CountDownLatch(1);
    final StringBuilder sb = new StringBuilder();
    final CountDownLatch messageLatch = new CountDownLatch(1);
    // When
    final WebSocket ws = KC.create(ExtendedCoreV1Api.class)
      .execInNamespacedPod(podName, NAMESPACE, "yakc-pod-it", Collections.singletonList("/bin/sh"), true, true, true, true)
      .exec(
        new WebSocketListener() {
          @Override
          public void onOpen(WebSocket webSocket, Response response) {
            openLatch.countDown();
          }

          @Override
          public void onMessage(WebSocket webSocket, ByteString bytes) {
            switch (ExecMessage.StandardStream.fromByte(bytes.getByte(0))) {
              case STDOUT:
              case STDERR:
                sb.append(bytes.substring(1).utf8());
            }
            if (sb.toString().matches(".+[\\r\\n]{1,2}hello-world[\\r\\n]{1,2}.+")) {
              messageLatch.countDown();
            }
          }

          @Override
          public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            fail("WebSocket connection failed", t);
          }
        }
      );
    try {
      assertThat(openLatch.await(30, TimeUnit.SECONDS)).isTrue();
      send(ws, "echo hello-world\n");
      // Then
      assertThat(messageLatch.await(30, TimeUnit.SECONDS)).isTrue();
    } finally {
      ws.close(1000, "");
    }
  }

  @Test
  @DisplayName("replaceNamespacedPod, should replace existing Pod's image")
  void replaceNamespacedPod() throws IOException {
    // Given
    awaitPodReady();
    final Pod existingPod = KC.create(CoreV1Api.class).readNamespacedPod(podName, NAMESPACE).get();
    existingPod.getMetadata().setResourceVersion(null);
    existingPod.getSpec().getContainers().get(0).setImage("nginxdemos/hello");
    // When
    final Pod result = KC.create(CoreV1Api.class)
      .replaceNamespacedPod(podName, NAMESPACE, existingPod).get();
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", podName)
      .extracting(Pod::getSpec).extracting(PodSpec::getContainers).asList()
      .hasSize(1)
      .element(0)
      .hasFieldOrPropertyWithValue("image", "nginxdemos/hello");
  }

  @Test
  @DisplayName("readNamespacedPodLog, should wait for pod to start and retrieve logs")
  void readNamespacedPodLog() throws IOException {
    // Given
    awaitPodReady();
    // When
    final String podLog = KC.create(CoreV1Api.class).readNamespacedPodLog(podName, NAMESPACE,
      new ReadNamespacedPodLog().timestamps(true)).get();
    // Then
    assertThat(podLog).contains("Busybox for IT started");
  }

  @Test
  @DisplayName("deleteNamespacedPod, should delete existing Pod")
  void deleteNamespacedPod() throws IOException {
    // When
    final Pod result = KC.create(CoreV1Api.class).deleteNamespacedPod(podName, NAMESPACE).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Pod::getMetadata)
      .hasFieldOrPropertyWithValue("name", podName)
      .extracting(ObjectMeta::getDeletionTimestamp)
      .isNotNull();
  }

  private void awaitPodReady() throws IOException {
    awaitPodReady(NAMESPACE, podName);
  }
  static void awaitPodReady(String namespace, String podName) throws IOException {
    KC.create(CoreV1Api.class).listNamespacedPod(namespace).watch()
      .filter(we -> we.getType() == Type.MODIFIED)
      .filter(we -> we.getObject().getMetadata().getName().equals(podName))
      .takeUntil(we -> (boolean)we.getObject().getStatus().getConditions().stream()
        .anyMatch(pc -> pc.getType().equals("ContainersReady")))
      .timeout(20, TimeUnit.SECONDS)
      .subscribe();
    Awaitility.await()
      .atMost(20, TimeUnit.SECONDS)
      .until(() -> KC.create(CoreV1Api.class).readNamespacedPod(podName, namespace).get()
          .getStatus().getPhase().equals("Running"));
  }

  static Pod createPodForTest(String namespace, String podName) throws IOException {
    return KC.create(CoreV1Api.class).createNamespacedPod(namespace, Pod.builder()
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
  }

  static void deletePodForTest(String namespace, String podName) throws IOException {
    try {
      KC.create(CoreV1Api.class)
        .deleteNamespacedPod(podName, namespace, DeleteOptions.builder().gracePeriodSeconds(0).build()).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }

  private static void send(WebSocket ws, String command) {
    byte[] commandBytes = command.getBytes(StandardCharsets.UTF_8);
    byte[] toSend = new byte[commandBytes.length + 1];
    toSend[0] = (byte) StandardStream.STDIN.getStandardStreamCode();
    System.arraycopy(commandBytes, 0, toSend, 1, commandBytes.length);
    ws.send(ByteString.of(toSend));
  }
}
