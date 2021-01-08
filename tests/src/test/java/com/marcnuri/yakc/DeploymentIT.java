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
 * Created on 2020-12-03, 6:57
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.Deployment;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.DeploymentSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodTemplateSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.LabelSelector;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.UUID;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(KubernetesClientExtension.class)
class DeploymentIT {

  private static final String NAMESPACE = "default";

  private String deploymentName;
  private Deployment deployment;

  @BeforeEach
  void setUp() throws IOException {
    deploymentName = UUID.randomUUID().toString();
    deployment = createDeploymentForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteDeploymentForTest();
  }

  @Test
  @DisplayName("createNamespacedDeployment, should create Deployment in default namespace")
  void createNamespacedDeployment() {
    // Then
    assertThat(deployment)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", deploymentName)
      .extracting(Deployment::getSpec).extracting(DeploymentSpec::getTemplate).extracting(PodTemplateSpec::getSpec)
      .extracting(PodSpec::getContainers).asList()
      .hasSize(1)
      .element(0)
      .hasFieldOrPropertyWithValue("image", "busybox");
    assertThat(deployment.getMetadata().getCreationTimestamp()).isNotNull();
  }

  @Test
  @DisplayName("listNamespacedDeployment.stream, should list newly created Deployment")
  void listNamespacedPodStream() throws IOException {
    // When
    final boolean result = KC.create(AppsV1Api.class).listNamespacedDeployment(NAMESPACE).stream()
      .anyMatch(deployment -> deployment.getMetadata().getName().equals(deploymentName));
    // Then
    assertThat(result).as("Created Deployment was not found").isTrue();
  }

  @Test
  @DisplayName("readNamespacedDeployment.stream, should read newly created Deployment")
  void readNamespacedDeployment() throws IOException {
    // When
    final Deployment result = KC.create(AppsV1Api.class).readNamespacedDeployment(deploymentName, NAMESPACE).get();
    // Then
    assertThat(result).as("Created Deployment was not found")
      .isNotNull();
  }

  @Test
  @DisplayName("deleteNamespacedDeployment, should delete existing Pod")
  void deleteNamespacedDeployment() throws IOException {
    // When
    final Status result = KC.create(AppsV1Api.class).deleteNamespacedDeployment(deploymentName, NAMESPACE).get();
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("status", "Success");
  }

  Deployment createDeploymentForTest() throws IOException {
    final String appName = "yakc-deployment-it";
    return KC.create(AppsV1Api.class).createNamespacedDeployment(NAMESPACE, Deployment.builder()
      .metadata(ObjectMeta.builder()
        .name(deploymentName)
        .build())
      .spec(DeploymentSpec.builder()
        .replicas(0)
        .selector(LabelSelector.builder()
          .putInMatchLabels("app", appName)
          .build())
        .template(PodTemplateSpec.builder()
          .metadata(ObjectMeta.builder()
            .putInLabels("app", appName)
            .build())
          .spec(PodSpec.builder()
            .addToContainers(Container.builder()
              .image("busybox")
              .addToCommand("/bin/sh")
              .addToCommand("-c")
              .addToCommand("echo 'Busybox for IT started' && sleep 3600")
              .name(appName)
              .build())
            .build())
          .build())
        .build())
      .build()
    ).get();
  }

  private void deleteDeploymentForTest() throws IOException {
    try {
      KC.create(AppsV1Api.class)
        .deleteNamespacedDeployment(deploymentName, NAMESPACE, DeleteOptions.builder().gracePeriodSeconds(0).build()).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }
}
