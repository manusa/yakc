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
import lombok.Singular;
import lombok.ToString;

/**
 * status holds the information about the state of an operator.  It is consistent with status information across the kube ecosystem.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterOperatorStatus implements Model {


  /**
   * conditions describes the state of the operator's reconciliation functionality.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ClusterOperatorStatusConditions> conditions;

  /**
   * extension contains any additional status information specific to the operator which owns this status object.
   */
  @JsonProperty("extension")
  private Object extension;

  /**
   * relatedObjects is a list of objects that are "interesting" or related to this operator.  Common uses are: 1. the detailed resource driving the operator 2. operator namespaces 3. operand namespaces
   */
  @JsonProperty("relatedObjects")
  @Singular(value = "addToRelatedObjects", ignoreNullCollections = true)
  private List<ClusterOperatorStatusRelatedObjects> relatedObjects;

  /**
   * versions is a slice of operand version tuples.  Operators which manage multiple operands will have multiple entries in the array.  If an operator is Available, it must have at least one entry.  You must report the version of the operator itself with the name "operator".
   */
  @JsonProperty("versions")
  @Singular(value = "addToVersions", ignoreNullCollections = true)
  private List<ClusterOperatorStatusVersions> versions;

}

