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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1.ConfigStatusConditions;
import com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1.ConfigStatusGenerations;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * status is the most recently observed status of the Kubernetes Scheduler
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class KubeSchedulerStatus implements Model {


  /**
   * conditions is a list of conditions and their status
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ConfigStatusConditions> conditions;

  /**
   * generations are used to determine when an item needs to be reconciled or has changed in a way that needs a reaction.
   */
  @JsonProperty("generations")
  @Singular(value = "addToGenerations", ignoreNullCollections = true)
  private List<ConfigStatusGenerations> generations;

  /**
   * latestAvailableRevision is the deploymentID of the most recent deployment
   */
  @JsonProperty("latestAvailableRevision")
  private Number latestAvailableRevision;

  /**
   * latestAvailableRevisionReason describe the detailed reason for the most recent deployment
   */
  @JsonProperty("latestAvailableRevisionReason")
  private String latestAvailableRevisionReason;

  /**
   * nodeStatuses track the deployment values and errors across individual nodes
   */
  @JsonProperty("nodeStatuses")
  @Singular(value = "addToNodeStatuses", ignoreNullCollections = true)
  private List<KubeAPIServerStatusNodeStatuses> nodeStatuses;

  /**
   * observedGeneration is the last generation change you've dealt with
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * readyReplicas indicates how many replicas are ready and at the desired state
   */
  @JsonProperty("readyReplicas")
  private Number readyReplicas;

  /**
   * version is the level this availability applies to
   */
  @JsonProperty("version")
  private String version;

}

