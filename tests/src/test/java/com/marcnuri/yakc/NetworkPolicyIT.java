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
 * Created on 2020-05-02, 19:52
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.networking.v1.NetworkingV1Api;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.NetworkPolicy;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.NetworkPolicySpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.LabelSelector;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-05-02.
 */
@TestMethodOrder(OrderAnnotation.class)
class NetworkPolicyIT {

  private static final String NAMESPACE = "default";

  private static KubernetesClient kc;
  private static String networkPolicyName;

  @BeforeAll
  static void setUp() {
    kc = new KubernetesClient();
    networkPolicyName = UUID.randomUUID().toString();
  }

  @AfterAll
  static void tearDown() {
//    kc.close(); // TODO: Enable when isolated OkHttp dispatchers and pools are available
    kc = null;
  }

  @Test
  @Order(1)
  @DisplayName("createNamespacedNetworkPolicy, should create network policy in default namespace")
  void createNamespacedNetworkPolicy() throws IOException {
    // When
    final NetworkPolicy networkPolicy = kc.create(NetworkingV1Api.class)
      .createNamespacedNetworkPolicy("default", NetworkPolicy
        .builder()
        .metadata(ObjectMeta.builder()
          .name(networkPolicyName)
          .build())
        .spec(NetworkPolicySpec.builder()
          .podSelector(LabelSelector.builder().putInMatchLabels("app", "yakc").build())
          .build())
        .build()
      ).get();
    // Then
    assertThat(networkPolicy).isNotNull();
    assertThat(networkPolicy.getMetadata().getName()).isEqualTo(networkPolicyName);
    assertThat(networkPolicy.getMetadata().getCreationTimestamp()).isNotNull();
    assertThat(networkPolicy.getSpec().getPodSelector().getMatchLabels()).hasSize(1);
    assertThat(networkPolicy.getSpec().getPodSelector().getMatchLabels()).containsEntry("app", "yakc");
  }

  @Test
  @Order(2)
  @DisplayName("listNamespacedNetworkPolicy.stream, should list newly created NetworkPolicy")
  void listNamespacedNetworkPolicy() throws IOException {
    // When
    final boolean result = kc.create(NetworkingV1Api.class).listNamespacedNetworkPolicy(NAMESPACE)
      .stream().anyMatch(pod -> pod.getMetadata().getName().equals(networkPolicyName));
    // Then
    assertThat(result).as("Created NetworkPolicy was not found").isTrue();
  }

  @Test
  @Order(3)
  @DisplayName("deleteNamespacedNetworkPolicy, should delete existing NetworkPolicy")
  void deleteNamespacedPod() throws IOException {
    // When
    final Status result = kc.create(NetworkingV1Api.class)
      .deleteNamespacedNetworkPolicy(networkPolicyName, NAMESPACE,
        DeleteOptions.builder().gracePeriodSeconds(1).build()).get();
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getStatus()).isEqualTo("Success");
  }
}
