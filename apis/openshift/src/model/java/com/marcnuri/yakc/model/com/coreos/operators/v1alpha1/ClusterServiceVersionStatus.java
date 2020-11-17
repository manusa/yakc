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

package com.marcnuri.yakc.model.com.coreos.operators.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ClusterServiceVersionStatus represents information about the status of a pod. Status may trail the actual state of a system.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterServiceVersionStatus implements Model {


  /**
   * Last time the owned APIService certs were updated
   */
  @JsonProperty("certsLastUpdated")
  private OffsetDateTime certsLastUpdated;

  /**
   * Time the owned APIService certs will rotate next
   */
  @JsonProperty("certsRotateAt")
  private OffsetDateTime certsRotateAt;

  /**
   * List of conditions, a history of state transitions
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ClusterServiceVersionStatusConditions> conditions;

  /**
   * Last time the status transitioned from one status to another.
   */
  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  /**
   * Last time we updated the status
   */
  @JsonProperty("lastUpdateTime")
  private OffsetDateTime lastUpdateTime;

  /**
   * A human readable message indicating details about why the ClusterServiceVersion is in this condition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * Current condition of the ClusterServiceVersion
   */
  @JsonProperty("phase")
  private String phase;

  /**
   * A brief CamelCase message indicating details about why the ClusterServiceVersion is in this state. e.g. 'RequirementsNotMet'
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * The status of each requirement for this CSV
   */
  @JsonProperty("requirementStatus")
  @Singular(value = "addToRequirementStatus", ignoreNullCollections = true)
  private List<ClusterServiceVersionStatusRequirementStatus> requirementStatus;

}

