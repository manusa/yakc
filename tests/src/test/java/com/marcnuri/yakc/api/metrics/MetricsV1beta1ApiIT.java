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
 * Created on 2020-11-12, 18:58
 */
package com.marcnuri.yakc.api.metrics;

import com.marcnuri.yakc.ClusterExecutionCondition;
import com.marcnuri.yakc.KubernetesClientExtension;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.metrics.v1beta1.MetricsV1beta1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Node;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.metrics.pkg.apis.metrics.v1beta1.NodeMetrics;
import com.marcnuri.yakc.model.io.k8s.metrics.pkg.apis.metrics.v1beta1.PodMetrics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

@Timeout(value = 2, unit = TimeUnit.MINUTES)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(KubernetesClientExtension.class)
@ClusterExecutionCondition.ClusterVersion(minVersion = "1.17.0", maxVersion = "1.23.99999")
class MetricsV1beta1ApiIT {

  @Test
  @DisplayName("getAPIResources, cluster contains resources for this API version")
  void getAPIResources() throws IOException {
    // When
    final APIResourceList result = KC.create(MetricsV1beta1Api.class).getAPIResources().get();
    // Then
    assertThat(result)
      .hasFieldOrProperty("apiVersion")
      .hasFieldOrProperty("kind")
      .hasFieldOrPropertyWithValue("groupVersion", "metrics.k8s.io/v1beta1")
      .hasFieldOrPropertyWithValue("apiVersion", "v1")
      .extracting(APIResourceList::getResources).asList().isNotEmpty();
  }

  @Test
  @Order(Integer.MAX_VALUE) // Run last. Other methods will block Suite test execution until metrics are available
  @DisplayName("listNodeMetrics.stream, cluster contains at least a Node with some metrics")
  void listNodeMetricsStream() throws IOException, InterruptedException {
    // When
    final Stream<NodeMetrics> result = getWithRetry(
      () -> KC.create(MetricsV1beta1Api.class).listNodeMetrics().stream()
    );
    // Then
    assertThat(result)
      .hasSizeGreaterThanOrEqualTo(1)
      .allSatisfy(nm -> assertThat(nm)
        .hasFieldOrProperty("usage.cpu")
        .hasFieldOrProperty("usage.memory")
        .hasFieldOrProperty("window")
        .extracting(NodeMetrics::getTimestamp)
        .isNotNull()
      );
  }

  @Test
  @DisplayName("readNodeMetrics, cluster contains at least a Node with some metrics")
  void readNodeMetrics() throws IOException, InterruptedException {
    // Given
    final String node = KC.create(CoreV1Api.class).listNode().stream().findFirst()
      .map(Node::getMetadata).map(ObjectMeta::getName)
      .orElseThrow(() -> new AssertionError("No nodes found"));
    // When
    final NodeMetrics result = getWithRetry(
      () -> KC.create(MetricsV1beta1Api.class).readNodeMetrics(node).get()
    );
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("metadata.name", node)
      .hasFieldOrProperty("usage.cpu")
      .hasFieldOrProperty("usage.memory")
      .hasFieldOrProperty("window")
      .extracting(NodeMetrics::getTimestamp)
      .isNotNull();
  }

  @Test
  @DisplayName("ListPodMetricsForAllNamespaces.stream, cluster contains at least a Pod with some metrics")
  void listPodMetricsForAllNamespacesStream() throws IOException, InterruptedException {
    // When
    final Stream<PodMetrics> result = getWithRetry(() ->KC.create(MetricsV1beta1Api.class)
      .listPodMetricsForAllNamespaces(new MetricsV1beta1Api.ListPodMetricsForAllNamespaces()
        .labelSelector("k8s-app=metrics-server"))
      .stream()
    );
    // Then
    assertThat(result)
      .hasSizeGreaterThanOrEqualTo(1)
      .allSatisfy(pm -> assertThat(pm)
        .hasFieldOrProperty("window")
        .hasFieldOrProperty("timestamp")
        .extracting(PodMetrics::getContainers)
        .asList()
        .hasSizeGreaterThanOrEqualTo(1)
        .allSatisfy(c -> assertThat(c)
          .hasFieldOrProperty("usage.cpu")
          .hasFieldOrProperty("usage.memory")
        )
      );
  }

  @Test
  @DisplayName("readNamespacedPodMetrics, cluster contains a Pod with some metrics")
  void readNamespacedPodMetrics() throws IOException, InterruptedException {
    // Given
    final Pod pod = KC.create(CoreV1Api.class)
      .listPodForAllNamespaces(new CoreV1Api.ListPodForAllNamespaces().labelSelector("k8s-app=metrics-server"))
      .stream().findFirst()
      .orElseThrow(() -> new AssertionError("No Pod found for metrics-server"));
    // When
    final PodMetrics result = getWithRetry(
      () ->  KC.create(MetricsV1beta1Api.class)
        .readNamespacedPodMetrics(pod.getMetadata().getName(), pod.getMetadata().getNamespace()).get()
      );
    // Then
    assertThat(result)
      .hasFieldOrProperty("apiVersion")
      .hasFieldOrProperty("kind")
      .hasFieldOrPropertyWithValue("metadata.name", pod.getMetadata().getName())
      .hasFieldOrPropertyWithValue("metadata.namespace", pod.getMetadata().getNamespace())
      .hasFieldOrProperty("window")
      .hasFieldOrProperty("timestamp")
      .extracting(PodMetrics::getContainers)
      .asList()
      .hasSizeGreaterThanOrEqualTo(1)
      .allSatisfy(c -> assertThat(c)
        .hasFieldOrProperty("usage.cpu")
        .hasFieldOrProperty("usage.memory")
      );
  }

  @FunctionalInterface
  private interface RetryFunction<T> {
    T run() throws IOException;
  }
  private static <T> T getWithRetry(RetryFunction<T> rf) throws IOException, InterruptedException {
    try {
      return rf.run();
    } catch(NotFoundException ex) {
      TimeUnit.SECONDS.sleep(1);
      return getWithRetry(rf);
    }
  }
}
