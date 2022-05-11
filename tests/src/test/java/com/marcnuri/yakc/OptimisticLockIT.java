/*
 * Copyright 2022 Marc Nuri
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
 * Created on 2022-05-11, 6:55
 */
package com.marcnuri.yakc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcnuri.yakc.ClusterExecutionCondition.ClusterVersion;
import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.policy.v1.PolicyV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Service;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ServiceSpec;
import com.marcnuri.yakc.model.io.k8s.api.policy.v1.PodDisruptionBudget;
import com.marcnuri.yakc.model.io.k8s.api.policy.v1.PodDisruptionBudgetSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.UUID;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static com.marcnuri.yakc.PodDisruptionBudgetIT.createPodDisruptionBudgetForTest;
import static com.marcnuri.yakc.PodDisruptionBudgetIT.deletePodDisruptionBudgetForTest;
import static com.marcnuri.yakc.PodIT.awaitPodReady;
import static com.marcnuri.yakc.PodIT.createPodForTest;
import static com.marcnuri.yakc.PodIT.deletePodForTest;
import static com.marcnuri.yakc.ServiceIT.createServiceForTest;
import static com.marcnuri.yakc.ServiceIT.deleteServiceForTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test suite to verify the Kubernetes API when dealing with the metadata.resourceVersion field.
 *
 * <p> The K8s API doesn't provide an idempotent behavior when performing PUT requests (however, it does for
 * certain resources).
 *
 * <p> The following resources have tests that prove idempotency doesn't work:
 * <ul>
 *   <li>PodDisruptionPolicy</li>
 * </ul>
 *
 * <p> The following issues are related:
 * <ul>
 *   <li><a href="https://github.com/kubernetes/kubernetes/issues/70674">#70674</a></li>
 *   <li><a href="https://github.com/kubernetes/kubernetes/pull/5690">
 *     PR #5690 Give better error message for PUTs with no resource version</a></li>
 *   <li><a href="https://github.com/kubernetes/kubernetes/issues/3112#issuecomment-69142275">
 *     #3112 Document that PUT doesn't support partial updates</a></li>
 * </ul>
 *
 * <p> <a href="https://github.com/kubernetes/community/blob/00e50166cc289d5afb22c2159640134fd8d72c58/contributors/devel/sig-architecture/api-conventions.md">api-conventions.md</a>
 * <blockquote>
 *   Otherwise, PUT expects the whole object to be specified. Therefore, if a field is omitted it is assumed that the client wants to clear that field's value. The PUT verb does not accept partial updates. Modification of just part of an object may be achieved by GETting the resource, modifying part of the spec, labels, or annotations, and then PUTting it back. See concurrency control, below, regarding read-modify-write consistency when using this pattern. Some objects may expose alternative resource representations that allow mutation of the status, or performing custom actions on the object.
 * </blockquote>
 *
 * <p> This suite was implemented as a follow-up to a conversation with <a href="https://github.com/shawkins">Steven Hawkins</a>.
 */
@ExtendWith(KubernetesClientExtension.class)
@DisplayName("Optimistic Locking scenarios")
class OptimisticLockIT {

  private static final String NAMESPACE = "default";

  private static final ObjectMapper MAPPER = new ObjectMapper();

  @Nested
  @DisplayName("Pod")
  class PodTests {

    private String podName;

    @BeforeEach
    void setUp() throws IOException {
      podName = "a" + UUID.randomUUID();
      createPodForTest(NAMESPACE, podName);
    }

    @AfterEach
    void tearDown() throws IOException {
      deletePodForTest(NAMESPACE, podName);
    }

    @Test
    @DisplayName("replace prevented with a different resourceVersion")
    void optimisticLockWorksForReplace() throws IOException {
      // Given
      awaitPodReady(NAMESPACE, podName);
      final Pod pod = KC.create(CoreV1Api.class).readNamespacedPod(podName, NAMESPACE).get();
      pod.getMetadata().setResourceVersion("1337");
      pod.setMetadata(pod.getMetadata().toBuilder().putInAnnotations("replaced", "true").build());
      // When
      final KubernetesException result = assertThrows(KubernetesException.class, () ->
        KC.create(CoreV1Api.class).replaceNamespacedPod(podName, NAMESPACE, pod).get());
      // Then
      assertThat(result)
        .isInstanceOf(ClientErrorException.class)
        .asInstanceOf(InstanceOfAssertFactories.type(ClientErrorException.class))
        .hasFieldOrPropertyWithValue("code", 409)
        .asInstanceOf(asStatus())
        .hasFieldOrPropertyWithValue("reason", "Conflict");
    }

    @Test
    @DisplayName("patch prevented with a different resourceVersion")
    void optimisticLockWorksForPatch() throws IOException {
      // Given
      awaitPodReady(NAMESPACE, podName);
      final Pod toPatch = Pod.builder()
        .metadata(ObjectMeta.builder().resourceVersion("1337").putInAnnotations("replaced", "true").build())
        .build();
      // When
      final KubernetesException result = assertThrows(KubernetesException.class, () ->
        KC.create(CoreV1Api.class).patchNamespacedPod(podName, NAMESPACE, toPatch).get());
      // Then
      assertThat(result)
        .isInstanceOf(ClientErrorException.class)
        .asInstanceOf(InstanceOfAssertFactories.type(ClientErrorException.class))
        .hasFieldOrPropertyWithValue("code", 409)
        .asInstanceOf(asStatus())
        .hasFieldOrPropertyWithValue("reason", "Conflict");
    }

    @Test
    @DisplayName("replace allowed with a null resourceVersion")
    void idempotencyWorks() throws IOException {
      // Given
      awaitPodReady(NAMESPACE, podName);
      final Pod pod = KC.create(CoreV1Api.class).readNamespacedPod(podName, NAMESPACE).get();
      pod.getMetadata().setResourceVersion(null);
      pod.setMetadata(pod.getMetadata().toBuilder().putInAnnotations("replaced", "true").build());
      // When
      final Pod result = KC.create(CoreV1Api.class).replaceNamespacedPod(podName, NAMESPACE, pod).get();
      // Then
      assertThat(result)
        .extracting(Pod::getMetadata)
        .hasFieldOrPropertyWithValue("name", podName)
        .hasFieldOrPropertyWithValue("annotations.replaced", "true")
        .extracting(ObjectMeta::getResourceVersion)
        .asInstanceOf(InstanceOfAssertFactories.STRING)
        .isNotBlank()
        .isNotEqualTo(pod.getMetadata().getResourceVersion());
    }
  }

  @Nested
  @DisplayName("Service")
  @ClusterVersion(minVersion = "1.23.0")
  class ServiceTests {

    private String serviceName;

    @BeforeEach
    void setUp() throws IOException {
      serviceName = "a" + UUID.randomUUID();
      createServiceForTest(NAMESPACE, serviceName);
    }

    @AfterEach
    void tearDown() throws IOException {
      deleteServiceForTest(NAMESPACE, serviceName);
    }

    @Test
    @DisplayName("replace prevented with a different resourceVersion")
    void optimisticLockWorksForReplace() throws IOException {
      // Given
      final Service service = KC.create(CoreV1Api.class).readNamespacedService(serviceName, NAMESPACE).get();
      service.getMetadata().setResourceVersion("1337");
      service.getSpec().getPorts().get(0).setTargetPort("http");
      // When
      final KubernetesException result = assertThrows(KubernetesException.class, () ->
        KC.create(CoreV1Api.class).replaceNamespacedService(serviceName, NAMESPACE, service).get());
      // Then
      assertThat(result)
        .isInstanceOf(ClientErrorException.class)
        .asInstanceOf(InstanceOfAssertFactories.type(ClientErrorException.class))
        .hasFieldOrPropertyWithValue("code", 409)
        .asInstanceOf(asStatus())
        .hasFieldOrPropertyWithValue("reason", "Conflict");
    }

    @Test
    @DisplayName("replace allowed with a null resourceVersion")
    void idempotencyWorks() throws IOException {
      // Given
      final Service service = KC.create(CoreV1Api.class).readNamespacedService(serviceName, NAMESPACE).get();
      service.getMetadata().setResourceVersion(null);
      service.getSpec().getPorts().get(0).setTargetPort("http");
      // When
      final Service result = KC.create(CoreV1Api.class)
        .replaceNamespacedService(serviceName, NAMESPACE, service).get();
      // Then
      assertThat(result)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", serviceName)
        .extracting(Service::getSpec).extracting(ServiceSpec::getPorts).asList()
        .hasSize(2)
        .element(0)
        .hasFieldOrPropertyWithValue("targetPort", "http");
    }
  }

  @Nested
  @DisplayName("PodDisruptionBudget")
  @ClusterVersion(minVersion = "1.21.0")
  class PodDisruptionBudgetTests {

    private String podDisruptionBudgetName;

    @BeforeEach
    void setUp() throws IOException {
      podDisruptionBudgetName = "a" + UUID.randomUUID();
      createPodDisruptionBudgetForTest(NAMESPACE, podDisruptionBudgetName);
    }

    @AfterEach
    void tearDown() throws IOException {
      deletePodDisruptionBudgetForTest(NAMESPACE, podDisruptionBudgetName);
    }

    @Test
    @DisplayName("replace prevented with a different resourceVersion")
    void optimisticLockWorksForReplace() throws IOException {
      // Given
      final PodDisruptionBudget podDisruptionBudget = KC.create(PolicyV1Api.class)
        .readNamespacedPodDisruptionBudget(podDisruptionBudgetName, NAMESPACE).get();
      podDisruptionBudget.getMetadata().setResourceVersion("1337");
      podDisruptionBudget.getSpec().setMinAvailable("2");
      // When
      final KubernetesException result = assertThrows(KubernetesException.class, () -> KC.create(PolicyV1Api.class)
        .replaceNamespacedPodDisruptionBudget(podDisruptionBudgetName, NAMESPACE, podDisruptionBudget).get());
      // Then
      assertThat(result)
        .isInstanceOf(ClientErrorException.class)
        .asInstanceOf(InstanceOfAssertFactories.type(ClientErrorException.class))
        .hasFieldOrPropertyWithValue("code", 409)
        .asInstanceOf(asStatus())
        .hasFieldOrPropertyWithValue("reason", "Conflict");
    }

    // K8s
    // - https://github.com/kubernetes/kubernetes/blob/b74d023e70d6064c7f3f77031e7d26ec38497fc9/pkg/registry/policy/poddisruptionbudget/strategy.go
    // - https://github.com/kubernetes/kubernetes/blob/b74d023e70d6064c7f3f77031e7d26ec38497fc9/pkg/apis/policy/validation/validation.go
    // - https://github.com/kubernetes/kubernetes/blob/b74d023e70d6064c7f3f77031e7d26ec38497fc9/pkg/apis/core/validation/validation.go#L366
    // - https://github.com/kubernetes/kubernetes/blob/b74d023e70d6064c7f3f77031e7d26ec38497fc9/staging/src/k8s.io/apimachinery/pkg/api/validation/objectmeta.go#L215
    // - https://github.com/kubernetes/kubernetes/blob/b74d023e70d6064c7f3f77031e7d26ec38497fc9/staging/src/k8s.io/apimachinery/pkg/api/validation/objectmeta.go#L240-L243
    //
    @Test
    @DisplayName("replace IS NOT allowed with a null resourceVersion")
    void idempotencyDoesntWork() throws IOException {
      // Given
      final PodDisruptionBudget podDisruptionBudget = KC.create(PolicyV1Api.class)
        .readNamespacedPodDisruptionBudget(podDisruptionBudgetName, NAMESPACE).get();
      podDisruptionBudget.getMetadata().setResourceVersion(null);
      podDisruptionBudget.getSpec().setMinAvailable("2");
      // When
      final KubernetesException result = assertThrows(KubernetesException.class, () -> KC.create(PolicyV1Api.class)
        .replaceNamespacedPodDisruptionBudget(podDisruptionBudgetName, NAMESPACE, podDisruptionBudget).get());
      // Then
      assertThat(result)
        .isInstanceOf(ClientErrorException.class)
        .asInstanceOf(InstanceOfAssertFactories.type(ClientErrorException.class))
        .hasFieldOrPropertyWithValue("code", 422)
        .asInstanceOf(asStatus())
        .hasFieldOrPropertyWithValue("reason", "Invalid")
        .extracting(Status::getMessage).asString()
        .contains("is invalid: metadata.resourceVersion: Invalid value:");
    }

    @Test
    @DisplayName("patch allowed with a null resourceVersion")
    void patchBypassesResourceVersionCheck() throws IOException {
      // Given
      final PodDisruptionBudget podDisruptionBudget = PodDisruptionBudget.builder()
        .spec(PodDisruptionBudgetSpec.builder().minAvailable("2").build())
        .build();
      // When
      final PodDisruptionBudget result = KC.create(PolicyV1Api.class)
        .patchNamespacedPodDisruptionBudget(podDisruptionBudgetName, NAMESPACE, podDisruptionBudget).get();
      // Then
      assertThat(result)
        .hasFieldOrPropertyWithValue("metadata.name", podDisruptionBudgetName)
        .hasFieldOrPropertyWithValue("metadata.generation", 2)
        .hasFieldOrPropertyWithValue("spec.minAvailable", "2");
    }
  }

  private static InstanceOfAssertFactory<ClientErrorException, ObjectAssert<Status>> asStatus() {
    return new InstanceOfAssertFactory<>(ClientErrorException.class, value -> {
      try {
        return assertThat(MAPPER.readValue((value).getMessage(), Status.class));
      } catch (JsonProcessingException e) {
        throw new IllegalArgumentException("The provided argument cannot be converted to Status", e);
      }
    });
  }
}
