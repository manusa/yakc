package com.marcnuri.yakc;

import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.policy.v1.PolicyV1Api;
import com.marcnuri.yakc.model.io.k8s.api.policy.v1.PodDisruptionBudget;
import com.marcnuri.yakc.model.io.k8s.api.policy.v1.PodDisruptionBudgetSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
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
@ClusterExecutionCondition.ClusterVersion(minVersion = "1.21.0")
class PodDisruptionBudgetIT {

  private static final String NAMESPACE = "default";

  private String podDisruptionBudgetName;
  private PodDisruptionBudget podDisruptionBudget;

  @BeforeEach
  void setUp() throws IOException {
    podDisruptionBudgetName = "a" + UUID.randomUUID();
    podDisruptionBudget = createPodDisruptionBudgetForTest(NAMESPACE, podDisruptionBudgetName);
  }

  @AfterEach
  void tearDown() throws IOException {
    deletePodDisruptionBudgetForTest(NAMESPACE, podDisruptionBudgetName);
  }

  @Test
  @DisplayName("createNamespacedPodDisruptionBudget, should create PodDisruptionBudget in default namespace")
  void createNamespacedPodDisruptionBudget() {
    // Then
    assertThat(podDisruptionBudget)
      .isNotNull()
      .hasFieldOrPropertyWithValue("spec.minAvailable", "1")
      .extracting(PodDisruptionBudget::getMetadata)
      .hasFieldOrPropertyWithValue("name", podDisruptionBudgetName)
      .extracting(ObjectMeta::getCreationTimestamp)
      .isNotNull();
  }

  @Test
  @DisplayName("deleteNamespacedPodDisruptionBudget, should delete existing PodDisruptionBudget")
  void deleteNamespacedPodDisruptionBudget() throws IOException {
    // When
    final Status result = KC.create(PolicyV1Api.class)
      .deleteNamespacedPodDisruptionBudget(podDisruptionBudgetName, NAMESPACE).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Status::getStatus)
      .isEqualTo("Success");
  }

  static PodDisruptionBudget createPodDisruptionBudgetForTest(String namespace, String podDisruptionBudgetName)
    throws IOException {

    return KC.create(PolicyV1Api.class).createNamespacedPodDisruptionBudget(namespace, PodDisruptionBudget.builder()
      .metadata(ObjectMeta.builder()
        .name(podDisruptionBudgetName)
        .putInLabels("app", "yakc-pod-disruption-budget-it")
        .putInAnnotations("com.marcnuri.yakc", "yakc-pod-disruption-budget-it")
        .build())
      .spec(PodDisruptionBudgetSpec.builder()
        .minAvailable("1")
        .build())
      .build()).get();
  }

  static void deletePodDisruptionBudgetForTest(String namespace, String podDisruptionBudgetName) throws IOException {
    try {
      KC.create(PolicyV1Api.class)
        .deleteNamespacedPodDisruptionBudget(podDisruptionBudgetName, namespace,
          DeleteOptions.builder().gracePeriodSeconds(0).build()).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
  }
}
