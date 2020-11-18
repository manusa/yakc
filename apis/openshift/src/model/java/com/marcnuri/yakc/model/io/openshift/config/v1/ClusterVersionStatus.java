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

package com.marcnuri.yakc.model.io.openshift.config.v1;

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
 * status contains information about the available updates and any in-progress updates.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterVersionStatus implements Model {


  /**
   * availableUpdates contains the list of updates that are appropriate for this cluster. This list may be empty if no updates are recommended, if the update service is unavailable, or if an invalid channel has been specified.
   */
  @JsonProperty("availableUpdates")
  private Object availableUpdates;

  /**
   * conditions provides information about the cluster version. The condition "Available" is set to true if the desiredUpdate has been reached. The condition "Progressing" is set to true if an update is being applied. The condition "Degraded" is set to true if an update is currently blocked by a temporary or permanent error. Conditions are only valid for the current desiredUpdate when metadata.generation is equal to status.generation.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ClusterOperatorStatusConditions> conditions;

  @NonNull
  @JsonProperty("desired")
  private ClusterVersionStatusDesired desired;

  /**
   * history contains a list of the most recent versions applied to the cluster. This value may be empty during cluster startup, and then will be updated when a new update is being applied. The newest update is first in the list and it is ordered by recency. Updates in the history have state Completed if the rollout completed - if an update was failing or halfway applied the state will be Partial. Only a limited amount of update history is preserved.
   */
  @JsonProperty("history")
  @Singular(value = "addToHistory", ignoreNullCollections = true)
  private List<ClusterVersionStatusHistory> history;

  /**
   * observedGeneration reports which version of the spec is being synced. If this value is not equal to metadata.generation, then the desired and conditions fields may represent a previous version.
   */
  @NonNull
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * versionHash is a fingerprint of the content that the cluster will be updated with. It is used by the operator to avoid unnecessary work and is for internal use only.
   */
  @NonNull
  @JsonProperty("versionHash")
  private String versionHash;

}

