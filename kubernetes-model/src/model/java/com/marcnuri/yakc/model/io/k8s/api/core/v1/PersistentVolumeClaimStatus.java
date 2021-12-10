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
@Builder(toBuilder = true, builderClassName = "Builder")
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
   * The storage resource within AllocatedResources tracks the capacity allocated to a PVC. It may be larger than the actual capacity when a volume expansion operation is requested. For storage quota, the larger value from allocatedResources and PVC.spec.resources is used. If allocatedResources is not set, PVC.spec.resources alone is used for quota calculation. If a volume expansion capacity request is lowered, allocatedResources is only lowered if there are no expansion operations in progress and if the actual volume capacity is equal or lower than the requested capacity. This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
   */
  @JsonProperty("allocatedResources")
  @Singular(value = "putInAllocatedResources", ignoreNullCollections = true)
  private Map<String, String> allocatedResources;

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
   * Phase represents the current phase of PersistentVolumeClaim.<br><p> <br><p> Possible enum values:<br><p>  - `"Bound"` used for PersistentVolumeClaims that are bound<br><p>  - `"Lost"` used for PersistentVolumeClaims that lost their underlying PersistentVolume. The claim was bound to a PersistentVolume and this volume does not exist any longer and all data on it was lost.<br><p>  - `"Pending"` used for PersistentVolumeClaims that are not yet bound
   */
  @JsonProperty("phase")
  private String phase;

  /**
   * ResizeStatus stores status of resize operation. ResizeStatus is not set by default but when expansion is complete resizeStatus is set to empty string by resize controller or kubelet. This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
   */
  @JsonProperty("resizeStatus")
  private String resizeStatus;

}

