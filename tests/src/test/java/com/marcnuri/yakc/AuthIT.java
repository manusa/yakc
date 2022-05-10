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
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-05-02.
 */
@ExtendWith(KubernetesClientExtension.class)
class AuthIT {

  private static final String NAMESPACE = "default";

  private static String nodeName;

  @BeforeAll
  static void setUp() throws IOException {
    nodeName = KC.create(CoreV1Api.class).listNode().stream().findFirst()
      .orElseThrow(() -> new IllegalStateException("Node not accessible with default client"))
      .getMetadata().getName();
  }

  @Test
  void performTokenAuthInNewClient() throws IOException {
    // Given
    final Secret secret = retrieveSecretForServiceAccount();
    final Configuration configuration = Configuration.builder()
      .server(KC.getConfiguration().getServer())
      .certificateAuthorityData(secret.getData().get("ca.crt"))
      .token(() -> secret.getData().get("token"))
      .build();
    // When
    final Node node = new KubernetesClient(configuration).create(CoreV1Api.class)
      .listNode().stream().findFirst()
      .orElse(null);
    // Then
    assertThat(node)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", nodeName);
  }

  private Secret retrieveSecretForServiceAccount() throws IOException {
    final ServiceAccount sa = KC.create(CoreV1Api.class).listNamespacedServiceAccount(NAMESPACE)
      .stream().findFirst().orElseThrow(() -> new AssertionError("No Service Account found"));
    final String secretName = sa.getSecrets() == null ? null : sa.getSecrets().stream()
      .findFirst().map(ObjectReference::getName)
      .orElse(null);
    if (secretName != null) {
      return KC.create(CoreV1Api.class).listNamespacedSecret(NAMESPACE)
        .stream()
        .filter(s -> s.getType().equals("kubernetes.io/service-account-token"))
        .filter(s -> s.getMetadata().getName().equals(secretName))
        .findAny()
        .orElseThrow(() -> new AssertionError(String.format("Secret %s doesn't exist", secretName)));
    } else {
      // https://kubernetes.io/docs/concepts/configuration/secret/#service-account-token-secrets
      final Secret serviceAccountTokenSecret = Secret.builder()
        .metadata(ObjectMeta.builder()
          .name(sa.getMetadata().getName() + "-token")
          .putInAnnotations("kubernetes.io/service-account.name", sa.getMetadata().getName())
          .build())
        .type("kubernetes.io/service-account-token")
        .putInStringData("token", "my-secret-token")
        .build();
      return KC.create(CoreV1Api.class)
        .createNamespacedSecret(NAMESPACE, serviceAccountTokenSecret).get();
    }
  }

}
