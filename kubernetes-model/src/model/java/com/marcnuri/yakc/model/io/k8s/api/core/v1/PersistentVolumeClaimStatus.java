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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * PersistentVolumeClaimStatus is the current status of a persistent volume claim.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PersistentVolumeClaimStatus implements Model {


  /**
   * AccessModes contains the actual access modes the volume backing the PVC has. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
   */
  @JsonProperty("accessModes")
  @Singular(value = "addToAccessModes", ignoreNullCollections = true)
  private List<String> accessModes;

  /**
   * Represents the actual resources of the underlying volume.
   */
  @JsonProperty("capacity")
  @Singular(value = "putInCapacity", ignoreNullCollections = true)
  private Map<String, String> capacity;

  /**
   * Current Condition of persistent volume claim. If underlying persistent volume is being resized then the Condition will be set to 'ResizeStarted'.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<PersistentVolumeClaimCondition> conditions;

  /**
   * Phase represents the current phase of PersistentVolumeClaim.
   */
  @JsonProperty("phase")
  private String phase;

}

