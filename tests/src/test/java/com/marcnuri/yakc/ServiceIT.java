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
 * Created on 2020-10-18, 13:43
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Service;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ServicePort;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ServiceSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import io.reactivex.disposables.Disposable;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(KubernetesClientExtension.class)
class ServiceIT {

  private static final String NAMESPACE = "default";

  private String serviceName;
  private Service service;

  @BeforeEach
  void setUp() throws IOException {
    serviceName = "a" + UUID.randomUUID().toString();
    service = createServiceForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteServiceForTest();
  }

  @Test
  @DisplayName("createNamespacedService, should create Service in default namespace")
  void createNamespacedService() {
    // Then
    assertThat(service)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", serviceName)
      .extracting(Service::getSpec).extracting(ServiceSpec::getPorts).asList()
      .hasSize(2)
      .element(0)
      .hasFieldOrPropertyWithValue("targetPort", "80");
    assertThat(service.getMetadata().getCreationTimestamp()).isNotNull();
  }

  @Test
  @DisplayName("listNamespacedService.watch, should await for notification of newly created Service")
  void awaitCreateWatch() throws IOException {
    // Given
    final AtomicBoolean hasError = new AtomicBoolean(false);
    final AtomicBoolean hasCompleted = new AtomicBoolean(false);
    // When
    final Disposable d = KC.create(CoreV1Api.class).listNamespacedService(NAMESPACE)
      .watch()
      .filter(we -> we.getObject().getMetadata().getName().equals(serviceName))
      .takeUntil(we -> we.getType() == Type.ADDED)
      .timeout(20, TimeUnit.SECONDS)
      .subscribe(we -> hasCompleted.set(true), we -> hasError.set(true));
    // Then
    assertThat(d).isNotNull();
    assertThat(hasError.get()).as("Watch subscribe ended with an error").isFalse();
    assertThat(hasCompleted.get()).as("Watch subscribe did not complete").isTrue();
  }

  @Test
  @DisplayName("listNamespacedService.stream, should list newly created Service")
  void listNamespacedServiceStream() throws IOException {
    // When
    final boolean result = KC.create(CoreV1Api.class).listNamespacedService(NAMESPACE).stream()
      .anyMatch(svc -> svc.getMetadata().getName().equals(serviceName));
    // Then
    assertThat(result).as("Created Service was not found").isTrue();
  }

  @Test
  @DisplayName("patchNamespacedService, should patch labels of Service")
  void patchNamespacedService() throws IOException {
    // When
    final Service result = KC.create(CoreV1Api.class)
      .patchNamespacedService(serviceName, NAMESPACE, Service.builder()
        .metadata(
          ObjectMeta.builder()
            .putInLabels("patched", "label")
            .build()
        ).build()).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Service::getMetadata)
      .hasFieldOrPropertyWithValue("name", serviceName)
      .extracting(ObjectMeta::getLabels).asInstanceOf(InstanceOfAssertFactories.MAP)
      .hasSize(2)
      .containsEntry("patched", "label");
  }

  @Test
  @DisplayName("replaceNamespacedService, should replace existing Service's port")
  void replaceNamespacedService() throws IOException {
    // Given
    final Service existingService = KC.create(CoreV1Api.class).readNamespacedService(serviceName, NAMESPACE).get();
    existingService.getSpec().getPorts().get(0).setTargetPort("http");
    // When
    final Service result = KC.create(CoreV1Api.class)
      .replaceNamespacedService(serviceName, NAMESPACE, existingService).get();
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", serviceName)
      .extracting(Service::getSpec).extracting(ServiceSpec::getPorts).asList()
      .hasSize(2)
      .element(0)
      .hasFieldOrPropertyWithValue("targetPort", "http");
  }

  @Test
  @DisplayName("deleteNamespacedService, should delete existing Service")
  void deleteNamespacedService() throws IOException {
    // When
    final Status result = KC.create(CoreV1Api.class).deleteNamespacedService(serviceName, NAMESPACE).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Status::getStatus)
      .isEqualTo("Success");
  }

  private Service createServiceForTest() throws IOException {
    return KC.create(CoreV1Api.class).createNamespacedService(NAMESPACE, Service.builder()
      .metadata(ObjectMeta.builder()
        .name(serviceName)
        .putInLabels("app", "yakc-service-it")
        .putInAnnotations("com.marcnuri.yakc", "yakc-service-it")
        .build())
      .spec(ServiceSpec.builder()
        .addToPorts(ServicePort.builder()
          .name("port-1")
          .port(80)
          .targetPort("80")
          .build())
        .addToPorts(ServicePort.builder()
          .name("port-2")
          .port(8080)
          .targetPort("http-alt")
          .build())
        .type("ClusterIP")
        .build())
      .build()).get();
  }

  private void deleteServiceForTest() throws IOException {
    try {
      KC.create(CoreV1Api.class)
        .deleteNamespacedService(serviceName, NAMESPACE, DeleteOptions.builder().gracePeriodSeconds(0).build()).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }
}
