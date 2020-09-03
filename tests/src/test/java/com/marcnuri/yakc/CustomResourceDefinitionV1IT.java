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
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.apiextensions.v1.ApiextensionsV1Api;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinition;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionNames;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionSpec;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionVersion;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceValidation;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.JSONSchemaProps;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
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
 * Created by Marc Nuri on 2020-05-03.
 */
@ExtendWith(KubernetesClientExtension.class)
@ClusterMinVersion(minVersion = "1.17.0")
class CustomResourceDefinitionV1IT {

  private String customResourceDefinitionName;
  private CustomResourceDefinition customResourceDefinition;

  @BeforeEach
  void setUp() throws IOException {
    final String singular = "a" + UUID.randomUUID().toString().replace("-", "");
    final String plural = singular + "s";
    final String group = "crd-test.yakc.marcnuri.com";

    customResourceDefinition = createCustomResourceDefinitionForTest(singular, plural, group);
    customResourceDefinitionName = customResourceDefinition.getMetadata().getName();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteCustomResourceDefinitionForTest(customResourceDefinition);
  }

  @Test
  @DisplayName("createCustomResourceDefinition, should create a CustomResourceDefinition for mountains")
  void createCustomResourceDefinition() {
    // Then
    assertThat(customResourceDefinition)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", customResourceDefinitionName)
      .extracting("metadata.creationTimestamp")
      .isNotNull();
    assertThat(customResourceDefinition)
      .extracting(CustomResourceDefinition::getSpec)
      .extracting(CustomResourceDefinitionSpec::getVersions).asList()
      .hasSize(1)
      .element(0)
      .extracting("schema.openAPIV3Schema.properties").asInstanceOf(InstanceOfAssertFactories.MAP)
      .hasSize(2)
      .extractingByKey("name")
      .hasFieldOrPropertyWithValue("type", "string");
  }

  @Test
  @DisplayName("listCustomResourceDefinition.stream, should list newly created CustomResourceDefinition")
  void listCustomResourceDefinition() throws IOException {
    // When
    final boolean result = KC.create(ApiextensionsV1Api.class).listCustomResourceDefinition()
      .stream().anyMatch(sa -> sa.getMetadata().getName().equals(customResourceDefinitionName));
    // Then
    assertThat(result).as("Created CustomResourceDefinition was not found").isTrue();
  }

  @Test
  @DisplayName("deleteCustomResourceDefinition, should delete existing CustomResourceDefinition")
  void deleteCustomResourceDefinition() throws IOException {
    // When
    final CustomResourceDefinition result = KC.create(ApiextensionsV1Api.class)
      .deleteCustomResourceDefinition(customResourceDefinitionName)
      .get(CustomResourceDefinition.class); // Swagger/OpenAPI is wrong
    // Then
    assertThat(result).isNotNull();
    assertThat(result.getMetadata().getDeletionTimestamp()).isNotNull();
  }

  static CustomResourceDefinition createCustomResourceDefinitionForTest(
    String singular, String plural, String group) throws IOException {

    return KC.create(ApiextensionsV1Api.class).createCustomResourceDefinition(
      CustomResourceDefinition.builder()
        .metadata(ObjectMeta.builder()
          .name(String.format("%s.%s", plural, group))
          .build())
        .spec(CustomResourceDefinitionSpec.builder()
          .group(group)
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
            .singular(singular)
            .plural(plural)
            .build())
          .build())
        .build()).get();
  }

  static void deleteCustomResourceDefinitionForTest(
    CustomResourceDefinition customResourceDefinition) throws IOException {

    try {
      KC.create(ApiextensionsV1Api.class)
        .deleteCustomResourceDefinition(customResourceDefinition.getMetadata().getName(),
          DeleteOptions.builder().gracePeriodSeconds(0).build()).get(CustomResourceDefinition.class);
    } catch (
    NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }

}
