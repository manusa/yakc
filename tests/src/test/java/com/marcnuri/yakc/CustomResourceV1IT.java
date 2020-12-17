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
 * Created on 2020-09-03, 16:18
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.ClusterExecutionCondition.ClusterMinVersion;
import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.model.ListModel;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinition;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.marcnuri.yakc.CustomResourceDefinitionV1IT.deleteCustomResourceDefinitionForTest;
import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-09-03.
 */
@ExtendWith(KubernetesClientExtension.class)
@ClusterMinVersion(minVersion = "1.17.0")
class CustomResourceV1IT {

  private static final String NAMESPACE = "default";

  private static CustomResourceDefinition customResourceDefinition;

  private String mountainName;
  private Mountain mountain;

  @BeforeAll
  static void setUpAll() throws IOException {
    customResourceDefinition = CustomResourceDefinitionV1IT.createCustomResourceDefinitionForTest(
      "mountain", "mountains", "yakc.marcnuri.com");
    CustomResourceDefinitionV1IT.awaitCustomResourceDefinitionReady(customResourceDefinition);
  }

  @AfterAll
  static void afterAll() throws IOException {
    deleteCustomResourceDefinitionForTest(customResourceDefinition);
  }

  @BeforeEach
  void setUp() throws IOException {
    mountainName = UUID.randomUUID().toString();
    mountain = createMountainForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteMountainForTest();
  }

  @Test
  @DisplayName("createNamespacedMountain, should create custom Mountain resource")
  void createNamespacedMountain() {
    // Then
    assertThat(mountain)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", mountainName)
      .hasFieldOrPropertyWithValue("name", "Mount Everest")
      .hasFieldOrPropertyWithValue("height", 8848)
      .extracting("metadata.creationTimestamp").isNotNull();
  }

  @Test
  @DisplayName("listNamespacedMountain.stream, should list newly created Mountains")
  void listNamespacedMountain() throws IOException {
    // When
    final boolean result = KC.create(MountainsV1Api.class).listNamespacedMountain(NAMESPACE).stream()
      .filter(mountain -> mountain.getMetadata().getName().equals(mountainName))
      .anyMatch(mountain -> mountain.getName().equals("Mount Everest"));
    // Then
    assertThat(result).as("Created Mountains was not found").isTrue();
  }

  @Test
  @DisplayName("deleteNamespacedMountain, should delete existing Mountain")
  void deleteNamespacedMountain() throws IOException {
    // When
    final Status result = KC.create(MountainsV1Api.class)
      .deleteNamespacedMountain(mountainName, NAMESPACE)
      .get();
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("status", "Success");
  }

  private Mountain createMountainForTest() throws IOException {
    return KC.create(MountainsV1Api.class).createNamespacedMountain(NAMESPACE,
      Mountain.builder()
        .name("Mount Everest")
        .metadata(ObjectMeta.builder()
          .name(mountainName).build())
        .height(8848)
        .build()).get();
  }

  private void deleteMountainForTest() throws IOException {
    try {
      KC.create(MountainsV1Api.class)
        .deleteNamespacedMountain(mountainName, NAMESPACE)
        .get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
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
  private interface MountainsV1Api extends Api {
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
