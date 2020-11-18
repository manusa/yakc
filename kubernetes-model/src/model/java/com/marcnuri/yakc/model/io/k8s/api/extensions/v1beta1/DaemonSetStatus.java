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

package com.marcnuri.yakc.model.io.k8s.api.extensions.v1beta1;

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
 * DaemonSetStatus represents the current status of a daemon set.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DaemonSetStatus implements Model {


  /**
   * Count of hash collisions for the DaemonSet. The DaemonSet controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ControllerRevision.
   */
  @JsonProperty("collisionCount")
  private Number collisionCount;

  /**
   * Represents the latest available observations of a DaemonSet's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<DaemonSetCondition> conditions;

  /**
   * The number of nodes that are running at least 1 daemon pod and are supposed to run the daemon pod. More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
   */
  @NonNull
  @JsonProperty("currentNumberScheduled")
  private Number currentNumberScheduled;

  /**
   * The total number of nodes that should be running the daemon pod (including nodes correctly running the daemon pod). More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
   */
  @NonNull
  @JsonProperty("desiredNumberScheduled")
  private Number desiredNumberScheduled;

  /**
   * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and available (ready for at least spec.minReadySeconds)
   */
  @JsonProperty("numberAvailable")
  private Number numberAvailable;

  /**
   * The number of nodes that are running the daemon pod, but are not supposed to run the daemon pod. More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
   */
  @NonNull
  @JsonProperty("numberMisscheduled")
  private Number numberMisscheduled;

  /**
   * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and ready.
   */
  @NonNull
  @JsonProperty("numberReady")
  private Number numberReady;

  /**
   * The number of nodes that should be running the daemon pod and have none of the daemon pod running and available (ready for at least spec.minReadySeconds)
   */
  @JsonProperty("numberUnavailable")
  private Number numberUnavailable;

  /**
   * The most recent generation observed by the daemon set controller.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * The total number of nodes that are running updated daemon pod
   */
  @JsonProperty("updatedNumberScheduled")
  private Number updatedNumberScheduled;

}

