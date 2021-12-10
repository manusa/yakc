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
 * Created on 2020-08-30, 7:30
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.ClusterExecutionCondition.ClusterVersion;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.networking.v1.NetworkingV1Api;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.HTTPIngressPath;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.HTTPIngressRuleValue;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.Ingress;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.IngressBackend;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.IngressRule;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.IngressServiceBackend;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.IngressSpec;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.ServiceBackendPort;
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
import java.util.stream.Stream;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(KubernetesClientExtension.class)
@ClusterVersion(minVersion = "1.19.0")
class NetworkingV1IngressIT {

  private static final String NAMESPACE = "default";

  private String ingressName;
  private Ingress ingress;

  @BeforeEach
  void setUp() throws IOException {
    ingressName = UUID.randomUUID().toString();
    ingress = createIngressForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteIngressForTest();
  }

  @Test
  @DisplayName("createNamespacedIngress, should create Ingress in default namespace")
  void createNamespacedIngress() {
    // Then
    assertThat(ingress)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", ingressName)
      .hasFieldOrPropertyWithValue("metadata.namespace", NAMESPACE)
      .extracting("metadata.creationTimestamp").isNotNull();
  }

  @Test
  @DisplayName("listNamespacedIngress.stream, cluster contains created Ingress")
  void listNamespacedIngress() throws IOException {
    // When
    final Stream<Ingress> result = KC.create(NetworkingV1Api.class)
      .listNamespacedIngress(NAMESPACE).stream();
    // Then
    assertThat(result)
      .hasSizeGreaterThanOrEqualTo(1)
      .anySatisfy(e -> assertThat(e)
        .hasFieldOrPropertyWithValue("metadata.name", ingressName)
        .extracting("spec.rules")
        .asList()
        .hasSize(1)
        .flatExtracting("http.paths")
        .asList()
        .hasSize(1)
        .extracting("backend.service.port.number")
        .contains(1337)
      );
  }

  @Test
  @DisplayName("readNamespacedIngress, should read existing Ingress with provided name")
  void readNamespacedIngress() throws IOException {
    // When
    final Ingress result = KC.create(NetworkingV1Api.class).readNamespacedIngress(ingressName, NAMESPACE).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting("metadata")
      .hasFieldOrPropertyWithValue("name", ingressName)
      .hasFieldOrPropertyWithValue("creationTimestamp", ingress.getMetadata().getCreationTimestamp());
  }

  @Test
  @DisplayName("patchNamespacedIngress, should patch labels of Ingress")
  void patchNamespacedIngress() throws IOException {
    // Given
    final Ingress patch = Ingress.builder()
      .metadata(ObjectMeta.builder()
        .putInLabels("patched-label", "1337")
        .build())
      .build();
    // When
    final Ingress result = KC.create(NetworkingV1Api.class)
      .patchNamespacedIngress(ingressName, NAMESPACE, patch).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Ingress::getMetadata)
      .satisfies(m -> assertThat(m).extracting(ObjectMeta::getLabels)
        .asInstanceOf(InstanceOfAssertFactories.MAP)
        .hasSize(1)
        .containsEntry("patched-label", "1337")
      )
      .extracting(ObjectMeta::getResourceVersion).asString()
      .isNotEmpty()
      .isNotEqualTo(ingress.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("deleteNamespacedIngress, should delete existing Ingress")
  void deleteNamespacedIngress() throws IOException {
    // When
    final Status result = deleteIngressForTest();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Status::getStatus)
      .isEqualTo("Success");
  }

  Ingress createIngressForTest() throws IOException {
    return KC.create(NetworkingV1Api.class).createNamespacedIngress(NAMESPACE, Ingress.builder()
      .metadata(ObjectMeta.builder()
        .name(ingressName)
        .build())
      .spec(IngressSpec.builder()
        .addToRules(IngressRule.builder()
          .host("ingress.example.com")
          .http(HTTPIngressRuleValue.builder()
            .addToPaths(HTTPIngressPath.builder()
              .path("/")
              .pathType("Exact")
              .backend(IngressBackend.builder()
                .service(IngressServiceBackend.builder()
                  .name("some-service")
                  .port(ServiceBackendPort.builder()
                    .number(1337)
                    .build())
                  .build())
                .build())
              .build())
            .build())
          .build())
        .build())
      .build()
    ).get();
  }

  Status deleteIngressForTest() throws IOException {
    try {
      return KC.create(NetworkingV1Api.class).deleteNamespacedIngress(ingressName, NAMESPACE).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
    return null;
  }
}
