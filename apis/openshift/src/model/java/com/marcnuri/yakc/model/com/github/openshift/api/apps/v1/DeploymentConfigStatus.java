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

package com.marcnuri.yakc.model.com.github.openshift.api.apps.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * DeploymentConfigStatus represents the current deployment state.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DeploymentConfigStatus implements Model {


  /**
   * AvailableReplicas is the total number of available pods targeted by this deployment config.
   */
  @NonNull
  @JsonProperty("availableReplicas")
  private Number availableReplicas;

  /**
   * Conditions represents the latest available observations of a deployment config's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<DeploymentCondition> conditions;

  @JsonProperty("details")
  private DeploymentDetails details;

  /**
   * LatestVersion is used to determine whether the current deployment associated with a deployment config is out of sync.
   */
  @NonNull
  @JsonProperty("latestVersion")
  private Number latestVersion;

  /**
   * ObservedGeneration is the most recent generation observed by the deployment config controller.
   */
  @NonNull
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * Total number of ready pods targeted by this deployment.
   */
  @JsonProperty("readyReplicas")
  private Number readyReplicas;

  /**
   * Replicas is the total number of pods targeted by this deployment config.
   */
  @NonNull
  @JsonProperty("replicas")
  private Number replicas;

  /**
   * UnavailableReplicas is the total number of unavailable pods targeted by this deployment config.
   */
  @NonNull
  @JsonProperty("unavailableReplicas")
  private Number unavailableReplicas;

  /**
   * UpdatedReplicas is the total number of non-terminated pods targeted by this deployment config that have the desired template spec.
   */
  @NonNull
  @JsonProperty("updatedReplicas")
  private Number updatedReplicas;

}

