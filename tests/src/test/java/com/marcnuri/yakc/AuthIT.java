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
 * Created on 2020-05-02, 16:42
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.config.Configuration;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Node;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Secret;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ServiceAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-05-02.
 */
@TestMethodOrder(OrderAnnotation.class)
class AuthIT {

  private static final String NAMESPACE = "default";

  private static KubernetesClient kc;
  private static String secretName;
  private static String caData;
  private static String token;

  @BeforeAll
  static void setUp() {
    kc = new KubernetesClient();
    secretName = null;
    caData = null;
    token = null;
  }

  @AfterAll
  static void tearDown() {
//    kc.close(); // TODO: Enable when isolated OkHttp dispatchers and pools are available
    kc = null;
  }

  @Test
  @Order(1)
  void retrieveServiceAccount() throws IOException {
    // When
    final ServiceAccount sa = kc.create(CoreV1Api.class).listNamespacedServiceAccount(NAMESPACE)
      .stream().findFirst().orElse(null);
    // Then
    assertThat(sa).isNotNull();
    secretName = sa.getSecrets().stream().findFirst().map(ObjectReference::getName).orElse(null);
  }

  @Test
  @Order(2)
  void retrieveSecretForServiceAccount() throws IOException {
    // When
    final Secret secret = kc.create(CoreV1Api.class).listNamespacedSecret(NAMESPACE)
      .stream()
      .filter(s -> s.getType().equals("kubernetes.io/service-account-token"))
      .filter(s -> s.getMetadata().getName().equals(secretName))
      .findAny().orElse(null);
    // Then
    assertThat(secret).isNotNull();
    assertThat(secret.getData()).containsKeys("ca.crt", "token");
    caData = secret.getData().get("ca.crt");
    token = secret.getData().get("token");
  }

  @Test
  @Order(3)
  void performTokenAuthInNewClient() throws IOException {
    // Given
    final Configuration configuration = Configuration.builder()
      .server(kc.getConfiguration().getServer())
      .certificateAuthorityData(caData)
      .token(token)
      .build();
    final KubernetesClient tokenClient = new KubernetesClient(configuration);
    final String accessibleTokenName = kc.create(CoreV1Api.class).listNode().stream().findFirst()
      .orElseThrow(() -> new IllegalStateException("Node not accessible with default client"))
      .getMetadata().getName();
    // When
    final Node node = tokenClient.create(CoreV1Api.class).listNode().stream().findFirst()
      .orElse(null);
    // Then
    assertThat(node).isNotNull();
    assertThat(node.getMetadata().getName()).isEqualTo(accessibleTokenName);
  }
}
