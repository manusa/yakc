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
 * Created on 2020-05-03, 7:15
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.ClusterExecutionCondition.ClusterMinVersion;
import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.api.apiextensions.v1.ApiextensionsV1Api;
import com.marcnuri.yakc.model.ListModel;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinition;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionNames;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionSpec;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionVersion;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceValidation;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.JSONSchemaProps;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-05-03.
 */
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(KubernetesClientExtension.class)
@ClusterMinVersion(minVersion = "1.17.0")
class CustomResourceDefinitionV1IT {

  private static final String NAMESPACE = "default";

  @Test
  @Order(1)
  @DisplayName("createCustomResourceDefinition, should create a CustomResourceDefinition for mountains")
  void createCustomResourceDefinition() throws IOException {
    // When
    final CustomResourceDefinition result = KC.create(ApiextensionsV1Api.class).createCustomResourceDefinition(
      CustomResourceDefinition.builder()
        .metadata(ObjectMeta.builder()
          .name("mountains.yakc.marcnuri.com")
          .build())
        .spec(CustomResourceDefinitionSpec.builder()
          .group("yakc.marcnuri.com")
          .addToVersions(CustomResourceDefinitionVersion.builder()
            .name("v1")
            .served(true)
            .storage(true)
            .schema(CustomResourceValidation.builder()
              .openAPIV3Schema(JSONSchemaProps.builder()
                .type("object")
                .addToRequired("name")
                .addToRequired("height")
                .putInProperties("name", JSONSchemaProps.builder()
                  .type("string")
                  .minimum(1)
                  .build())
                .putInProperties("height", JSONSchemaProps.builder()
                  .type("integer")
                  .minimum(1)
                  .build())
                .build())
              .build())
            .build())
          .scope("Namespaced")
          .names(CustomResourceDefinitionNames.builder()
            .kind("Mountain")
            .singular("mountain")
            .plural("mountains")
            .build())
          .build())
        .build()).get();
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getMetadata().getCreationTimestamp()).isNotNull();
    assertThat(result.getMetadata().getName()).isEqualTo("mountains.yakc.marcnuri.com");
  }

  @Test
  @Order(2)
  @DisplayName("createNamespacedMountain, should create custom Mountain resource")
  void createNamespacedMountain() throws IOException {
    // When
    final Mountain mountain = KC.create(MountainsV1Api.class).createNamespacedMountain(NAMESPACE,
      Mountain.builder()
        .name("Mount Everest")
        .metadata(ObjectMeta.builder()
          .name("mount-everest").build())
        .height(8848)
        .build()).get();
    // Then
    assertThat(mountain).isNotNull();
    assertThat(mountain.getMetadata().getCreationTimestamp()).isNotNull();
    assertThat(mountain.getName()).isEqualTo("Mount Everest");
    assertThat(mountain.getHeight()).isEqualTo(8848);
  }

  @Test
  @Order(3)
  @DisplayName("listNamespacedMountain.stream, should list newly created Mountains")
  void listNamespacedMountain() throws IOException {
    // When
    final boolean result = KC.create(MountainsV1Api.class).listNamespacedMountain(NAMESPACE).stream()
      .anyMatch(mountain -> mountain.getName().equals("Mount Everest"));
    // Then
    assertThat(result).as("Created Mountains was not found").isTrue();
  }


  @Test
  @Order(4)
  @DisplayName("deleteNamespacedPod, should delete existing Mountain")
  void deleteNamespacedPod() throws IOException {
    // When
    final Status result = KC.create(MountainsV1Api.class)
      .deleteNamespacedMountain("mount-everest", NAMESPACE)
      .get();
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getStatus()).isEqualTo("Success");
  }

  @Test
  @Order(5)
  @DisplayName("deleteCustomResourceDefinition, should delete existing CustomResourceDefinition")
  void deleteCustomResourceDefinition() throws IOException {
    // When
    final CustomResourceDefinition result = KC.create(ApiextensionsV1Api.class)
      .deleteCustomResourceDefinition("mountains.yakc.marcnuri.com")
      .get(CustomResourceDefinition.class); // Swagger/OpenAPI is wrong
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getMetadata().getDeletionTimestamp()).isNotNull();
  }

  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  @EqualsAndHashCode
  private static final class Mountain implements Model {
    private ObjectMeta metadata;
    private String name;
    private int height;
    public String getApiVersion() {
      return "yakc.marcnuri.com/v1";
    }
    public String getKind() {
      return "Mountain";
    }
  }
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Data
  @EqualsAndHashCode
  private static final class MountainList implements Model, ListModel<Mountain> {
    private List<Mountain> items;
  }
  private  interface MountainsV1Api extends Api {
    @HTTP(
      method = "POST",
      path = "/apis/yakc.marcnuri.com/v1/namespaces/{namespace}/mountains",
      hasBody = true
    )
    @Headers({
      "Content-Type: application/json",
      "Accept: */*"
    })
    KubernetesCall<Mountain> createNamespacedMountain(
      @Path("namespace") String namespace,
      @Body Mountain body);

    @HTTP(
      method = "GET",
      path = "/apis/yakc.marcnuri.com/v1/namespaces/{namespace}/mountains"
    )
    @Headers({
      "Accept: */*"
    })
    KubernetesListCall<MountainList, Mountain> listNamespacedMountain(
      @Path("namespace") String namespace);

    @HTTP(
      method = "DELETE",
      path = "/apis/yakc.marcnuri.com/v1/namespaces/{namespace}/mountains/{name}",
      hasBody = true
    )
    @Headers({
      "Content-Type: application/json",
      "Accept: */*"
    })
    KubernetesCall<Status> deleteNamespacedMountain(
      @Path("name") String name,
      @Path("namespace") String namespace);
  }
}
