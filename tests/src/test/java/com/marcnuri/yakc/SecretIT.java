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
 * Created on 2020-09-03, 15:18
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Secret;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-09-03.
 */
@ExtendWith(KubernetesClientExtension.class)
class SecretIT {

  private static final String NAMESPACE = "default";

  private String secretName;
  private Secret secret;

  @BeforeEach
  void setUp() throws IOException {
    secretName = UUID.randomUUID().toString();
    secret = createSecretForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteSecretForTest();
  }

  @Test
  @DisplayName("createNamespacedSecret, should create Secret in default namespace")
  void createNamespacedSecret() {
    // Then
    assertThat(secret)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", secretName)
      .extracting(Secret::getData).asInstanceOf(InstanceOfAssertFactories.MAP)
      .hasSize(3)
      .containsEntry("SECRET_1", "U0VDUkVUXzFfVkFMVUU=");
    assertThat(secret.getMetadata().getCreationTimestamp()).isNotNull();
  }

  @Test
  @DisplayName("listNamespacedSecret.stream, should list newly created Secret")
  void listNamespacedSecret() throws IOException {
    // When
    final boolean result = KC.create(CoreV1Api.class).listNamespacedSecret(NAMESPACE)
      .stream().anyMatch(secret -> secret.getMetadata().getName().equals(secretName));
    // Then
    assertThat(result).as("Created Secret was not found").isTrue();
  }

  @Test
  @DisplayName("readNamespacedSecret, should read newly created Secret")
  void readNamespacedSecret() throws IOException {
    // When
    final Secret secretFromServer = KC.create(CoreV1Api.class)
      .readNamespacedSecret(secretName, NAMESPACE).get();
    // Then
    assertThat(secretFromServer)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", secretName)
      .extracting(Secret::getData).asInstanceOf(InstanceOfAssertFactories.MAP)
      .hasSize(3)
      .containsEntry("FOO", "QkFS");
  }

  @Test
  @DisplayName("deleteNamespacedSecret, should delete existing Secret")
  void deleteNamespacedSecret() throws IOException {
    // When
    final Status result = KC.create(CoreV1Api.class)
      .deleteNamespacedSecret(secretName, NAMESPACE,
        DeleteOptions.builder().gracePeriodSeconds(1).build()).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Status::getStatus)
      .isEqualTo("Success");
  }

  private Secret createSecretForTest() throws IOException {
    return KC.create(CoreV1Api.class)
      .createNamespacedSecret(NAMESPACE, Secret.builder()
        .metadata(ObjectMeta.builder().name(secretName).build())
        .stringData(Collections.singletonMap("SECRET_1", "SECRET_1_VALUE"))
        .putInStringData("VAR_2", "VAR_2_VALUE")
        .putInStringData("FOO", "BAR")
        .build()).get();
  }

  private void deleteSecretForTest() throws IOException {
    try {
      KC.create(CoreV1Api.class).deleteNamespacedSecret(secretName, NAMESPACE).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }
}
