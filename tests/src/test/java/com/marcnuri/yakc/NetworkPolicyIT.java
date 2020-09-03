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

import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.networking.v1.NetworkingV1Api;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.NetworkPolicy;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.NetworkPolicySpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.LabelSelector;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import org.assertj.core.api.InstanceOfAssertFactories;
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
 * Created by Marc Nuri on 2020-05-02.
 */
@ExtendWith(KubernetesClientExtension.class)
class NetworkPolicyIT {

  private static final String NAMESPACE = "default";

  private String networkPolicyName;
  private NetworkPolicy networkPolicy;

  @BeforeEach
  void setUp() throws IOException {
    networkPolicyName = UUID.randomUUID().toString();
    networkPolicy = createNetworkPolicyForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteNetworkPolicyForTest();
  }

  @Test
  @DisplayName("createNamespacedNetworkPolicy, should create network policy in default namespace")
  void createNamespacedNetworkPolicy() {
    // Then
    assertThat(networkPolicy)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", networkPolicyName)
      .extracting(NetworkPolicy::getSpec).extracting(NetworkPolicySpec::getPodSelector)
      .extracting(LabelSelector::getMatchLabels).asInstanceOf(InstanceOfAssertFactories.MAP)
      .hasSize(1)
      .containsEntry("app", "yakc");
    assertThat(networkPolicy.getMetadata().getCreationTimestamp()).isNotNull();
  }

  @Test
  @DisplayName("listNamespacedNetworkPolicy.stream, should list newly created NetworkPolicy")
  void listNamespacedNetworkPolicy() throws IOException {
    // When
    final boolean result = KC.create(NetworkingV1Api.class).listNamespacedNetworkPolicy(NAMESPACE)
      .stream().anyMatch(np -> np.getMetadata().getName().equals(networkPolicyName));
    // Then
    assertThat(result).as("Created NetworkPolicy was not found").isTrue();
  }

  @Test
  @DisplayName("deleteNamespacedNetworkPolicy, should delete existing NetworkPolicy")
  void deleteNamespacedNetworkPolicy() throws IOException {
    // When
    final Status result = KC.create(NetworkingV1Api.class)
      .deleteNamespacedNetworkPolicy(networkPolicyName, NAMESPACE,
        DeleteOptions.builder().gracePeriodSeconds(1).build()).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Status::getStatus)
      .isEqualTo("Success");
  }

  private NetworkPolicy createNetworkPolicyForTest() throws IOException {
    return KC.create(NetworkingV1Api.class)
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
  }

  private void deleteNetworkPolicyForTest() throws IOException {
    try {
      KC.create(NetworkingV1Api.class).deleteNamespacedNetworkPolicy(networkPolicyName, NAMESPACE).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }
}
