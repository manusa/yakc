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
 */

package com.marcnuri.yakc.model.io.k8s.api.apps.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * DeploymentStatus is the most recently observed status of the Deployment.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DeploymentStatus implements Model {


  /**
   * Total number of available pods (ready for at least minReadySeconds) targeted by this deployment.
   */
  @JsonProperty("availableReplicas")
  private Number availableReplicas;

  /**
   * Count of hash collisions for the Deployment. The Deployment controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ReplicaSet.
   */
  @JsonProperty("collisionCount")
  private Number collisionCount;

  /**
   * Represents the latest available observations of a deployment's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<DeploymentCondition> conditions;

  /**
   * The generation observed by the deployment controller.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * Total number of ready pods targeted by this deployment.
   */
  @JsonProperty("readyReplicas")
  private Number readyReplicas;

  /**
   * Total number of non-terminated pods targeted by this deployment (their labels match the selector).
   */
  @JsonProperty("replicas")
  private Number replicas;

  /**
   * Total number of unavailable pods targeted by this deployment. This is the total number of pods that are still required for the deployment to have 100% available capacity. They may either be pods that are running but not yet available or pods that still have not been created.
   */
  @JsonProperty("unavailableReplicas")
  private Number unavailableReplicas;

  /**
   * Total number of non-terminated pods targeted by this deployment that have the desired template spec.
   */
  @JsonProperty("updatedReplicas")
  private Number updatedReplicas;

}

