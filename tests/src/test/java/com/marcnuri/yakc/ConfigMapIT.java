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
 * Created on 2020-06-13, 19:09
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ConfigMap;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import io.reactivex.disposables.Disposable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Created by Marc Nuri on 2020-06-13.
 */
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(KubernetesClientExtension.class)
class ConfigMapIT {

  private static final String NAMESPACE = "default";

  private static String configMapName;

  @BeforeAll
  static void setUp() {
    configMapName = UUID.randomUUID().toString();
  }

  @Test
  @Order(1)
  @DisplayName("createNamespacedConfigMap, should create ConfigMap in default namespace")
  void createNamespacedConfigMap() throws IOException {
    // When
    final ConfigMap result = KC.create(CoreV1Api.class)
      .createNamespacedConfigMap(NAMESPACE, ConfigMap.builder()
        .metadata(ObjectMeta.builder().name(configMapName).build())
        .data(Collections.singletonMap("VAR_1", "VAR_1_VALUE"))
        .putInData("VAR_2", "VAR_2_VALUE")
        .putInData("FOO", "BAR")
        .build()).get();
    // Then
    assertAll(
      "Created expected configMap",
      () -> assertThat(result).isNotNull(),
      () -> assertThat(result.getKind()).isEqualTo("ConfigMap"),
      () -> assertThat(result.getMetadata().getCreationTimestamp()).isNotNull(),
      () -> assertThat(result.getMetadata().getResourceVersion()).isNotNull(),
      () -> assertThat(result.getData()).containsEntry("VAR_1", "VAR_1_VALUE"),
      () -> assertThat(result.getData()).containsEntry("VAR_2", "VAR_2_VALUE")
    );
  }

  @Test
  @Order(2)
  @DisplayName("listNamespacedConfigMap.watch, should await for notification of newly created ConfigMap")
  void awaitCreateWatch() throws IOException {
    // Given
    final AtomicBoolean hasError = new AtomicBoolean(false);
    final AtomicBoolean hasCompleted = new AtomicBoolean(false);
    // When
    final Disposable d = KC.create(CoreV1Api.class).listNamespacedConfigMap(NAMESPACE)
      .watch()
      .filter(we -> we.getObject().getMetadata().getName().equals(configMapName))
      .takeUntil(we -> we.getType() == Type.ADDED)
      .timeout(20, TimeUnit.SECONDS)
      .subscribe(we -> hasCompleted.set(true), we -> hasError.set(true));
    // Then
    assertAll(
      "Watch completed",
      () -> assertThat(d).isNotNull(),
      () -> assertThat(hasError.get()).as("Watch subscribe ended with an error").isFalse(),
      () -> assertThat(hasCompleted.get()).as("Watch subscribe did not complete").isTrue()
    );
  }

  @Test
  @Order(3)
  @DisplayName("listNamespacedConfigMap.stream, should list newly created ConfigMap")
  void listNamespacedConfigMap() throws IOException {
    // When
    final boolean result = KC.create(CoreV1Api.class).listNamespacedConfigMap(NAMESPACE).stream()
      .anyMatch(cm -> cm.getMetadata().getName().equals(configMapName));
    // Then
    assertThat(result).as("Created ConfigMap was not found").isTrue();
  }

  @Test
  @Order(3)
  @DisplayName("readNamespacedConfigMap, should retrieve newly created ConfigMap")
  void readNamespacedConfigMap() throws IOException {
    // When
    final ConfigMap result = KC.create(CoreV1Api.class)
      .readNamespacedConfigMap(configMapName, NAMESPACE).get();
    // Then
    assertAll(
      "Reads expected configMap",
      () -> assertThat(result).isNotNull(),
      () -> assertThat(result.getKind()).isEqualTo("ConfigMap"),
      () -> assertThat(result.getMetadata().getCreationTimestamp()).isNotNull(),
      () -> assertThat(result.getMetadata().getResourceVersion()).isNotNull(),
      () -> assertThat(result.getData()).containsEntry("VAR_1", "VAR_1_VALUE")
    );
  }

  @Test
  @Order(4)
  @DisplayName("patchNamespacedConfigMap, should patch labels of ConfigMap")
  void patchNamespacedConfigMap() throws IOException {
    // When
    final ConfigMap result = KC.create(CoreV1Api.class)
      .patchNamespacedConfigMap(configMapName, NAMESPACE, ConfigMap.builder()
        .metadata(
          ObjectMeta.builder()
            .putInLabels("patched", "label")
            .build()
        )
        .putInData("VAR_2", "VAR_2_VALUE_CHANGED")
        .putInData("VAR_3", "VAR_3_VALUE")
        .build()).get();
    // Then
    assertAll(
      "Patched ConfigMap is as expected",
      () -> assertThat(result).isNotNull(),
      () -> assertThat(result.getMetadata().getLabels()).containsEntry("patched", "label"),
      () -> assertThat(result.getData()).containsEntry("VAR_1", "VAR_1_VALUE"),
      () -> assertThat(result.getData()).containsEntry("VAR_2", "VAR_2_VALUE_CHANGED"),
      () -> assertThat(result.getData()).containsEntry("VAR_3", "VAR_3_VALUE")
    );
  }

  @Test
  @Order(5)
  @DisplayName("replaceNamespacedConfigMap, should replace existing ConfigMap data")
  void replaceNamespacedConfigMap() throws IOException {
    // Given
    final ConfigMap existingConfigMap = KC.create(CoreV1Api.class)
      .readNamespacedConfigMap(configMapName, NAMESPACE).get();
    final String priorResourceVersion = existingConfigMap.getMetadata().getResourceVersion();
    existingConfigMap.getMetadata().setResourceVersion(null);
    existingConfigMap.setData(Collections.singletonMap("VAR_Z", "VAR_Z_VALUE"));
    // When
    final ConfigMap result = KC.create(CoreV1Api.class)
      .replaceNamespacedConfigMap(configMapName, NAMESPACE, existingConfigMap).get();
    // Then
    assertAll(
      "Replaced ConfigMap is as expected",
      () -> assertThat(result).isNotNull(),
      () -> assertThat(result.getMetadata().getResourceVersion()).isNotNull(),
      () -> assertThat(result.getMetadata().getResourceVersion()).isNotEqualTo(priorResourceVersion),
      () -> assertThat(result.getData()).hasSize(1),
      () -> assertThat(result.getData()).containsEntry("VAR_Z", "VAR_Z_VALUE")
    );
  }

  @Test
  @Order(6)
  @DisplayName("deleteNamespacedConfigMap, should delete existing ConfigMap")
  void deleteNamespacedConfigMap() throws IOException {
    // When
    final Status result = KC.create(CoreV1Api.class).deleteNamespacedConfigMap(configMapName, NAMESPACE).get();
    // Then
    assertAll(
      "Created expected configMap",
      () -> assertThat(result).isNotNull(),
      () -> assertThat(result.getStatus()).isEqualTo("Success")
    );
  }
}
