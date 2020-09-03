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
 * Created on 2020-09-03, 15:49
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ServiceAccount;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.UUID;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-09-03.
 */
@ExtendWith(KubernetesClientExtension.class)
class ServiceAccountIT {
  private static final String NAMESPACE = "default";

  private String serviceAccountName;
  private ServiceAccount serviceAccount;

  @BeforeEach
  void setUp() throws IOException {
    serviceAccountName = UUID.randomUUID().toString();
    serviceAccount = createServiceAccountForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteServiceAccountForTest();
  }

  @Test
  @DisplayName("createNamespacedServiceAccount, should create ServiceAccount in default namespace")
  void createNamespacedServiceAccount() {
    // Then
    assertThat(serviceAccount)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", serviceAccountName)
      .extracting(ServiceAccount::getSecrets).asList()
      .hasSize(1)
      .element(0)
      .hasFieldOrPropertyWithValue("name", "doesnt-exist");
    assertThat(serviceAccount.getMetadata().getCreationTimestamp()).isNotNull();
  }

  @Test
  @DisplayName("listNamespacedServiceAccount.stream, should list newly created ServiceAccount")
  void listNamespacedServiceAccount() throws IOException {
    // When
    final boolean result = KC.create(CoreV1Api.class).listNamespacedServiceAccount(NAMESPACE)
      .stream().anyMatch(sa -> sa.getMetadata().getName().equals(serviceAccountName));
    // Then
    assertThat(result).as("Created ServiceAccount was not found").isTrue();
  }

  @Test
  @DisplayName("readNamespacedServiceAccount, should read newly created ServiceAccount")
  void readNamespacedServiceAccount() throws IOException {
    // When
    final ServiceAccount serviceAccountFromServer = KC.create(CoreV1Api.class)
      .readNamespacedServiceAccount(serviceAccountName, NAMESPACE).get();
    // Then
    assertThat(serviceAccountFromServer)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", serviceAccountName)
      .extracting(ServiceAccount::getSecrets).asList()
      .hasSize(1)
      .element(0)
      .hasFieldOrPropertyWithValue("name", "doesnt-exist");
  }

  @Test
  @DisplayName("deleteNamespacedServiceAccount, should delete existing ServiceAccount")
  void deleteNamespacedServiceAccount() throws IOException {
    // When
    final ServiceAccount result = KC.create(CoreV1Api.class)
      .deleteNamespacedServiceAccount(serviceAccountName, NAMESPACE,
        DeleteOptions.builder().propagationPolicy("Background").build()).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(ServiceAccount::getMetadata)
      .hasFieldOrPropertyWithValue("name", serviceAccountName);
  }

  private ServiceAccount createServiceAccountForTest() throws IOException {
    return KC.create(CoreV1Api.class)
      .createNamespacedServiceAccount(NAMESPACE, ServiceAccount.builder()
        .metadata(ObjectMeta.builder().name(serviceAccountName).build())
        .addToSecrets(ObjectReference.builder().name("doesnt-exist").build())
        .build()).get();
  }

  private void deleteServiceAccountForTest() throws IOException {
    try {
      KC.create(CoreV1Api.class).deleteNamespacedServiceAccount(serviceAccountName, NAMESPACE,
        DeleteOptions.builder().gracePeriodSeconds(0).build()).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }
}
