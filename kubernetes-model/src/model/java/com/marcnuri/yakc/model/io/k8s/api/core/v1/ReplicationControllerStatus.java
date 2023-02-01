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

package com.marcnuri.yakc.model.io.k8s.api.core.v1;

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
 * ReplicationControllerStatus represents the current status of a replication controller.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ReplicationControllerStatus implements Model {


  /**
   * The number of available replicas (ready for at least minReadySeconds) for this replication controller.
   */
  @JsonProperty("availableReplicas")
  private Number availableReplicas;

  /**
   * Represents the latest available observations of a replication controller's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ReplicationControllerCondition> conditions;

  /**
   * The number of pods that have labels matching the labels of the pod template of the replication controller.
   */
  @JsonProperty("fullyLabeledReplicas")
  private Number fullyLabeledReplicas;

  /**
   * ObservedGeneration reflects the generation of the most recently observed replication controller.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * The number of ready replicas for this replication controller.
   */
  @JsonProperty("readyReplicas")
  private Number readyReplicas;

  /**
   * Replicas is the most recently observed number of replicas. More info: https://kubernetes.io/docs/concepts/workloads/controllers/replicationcontroller#what-is-a-replicationcontroller
   */
  @NonNull
  @JsonProperty("replicas")
  private Number replicas;

}

