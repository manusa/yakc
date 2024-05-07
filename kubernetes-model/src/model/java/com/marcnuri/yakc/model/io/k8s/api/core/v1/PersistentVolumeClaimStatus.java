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
   * accessModes contains the actual access modes the volume backing the PVC has. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
   */
  @JsonProperty("accessModes")
  @Singular(value = "addToAccessModes", ignoreNullCollections = true)
  private List<String> accessModes;

  /**
   * allocatedResourceStatuses stores status of resource being resized for the given PVC. Key names follow standard Kubernetes label syntax. Valid values are either:<br><p> 	&#42; Un-prefixed keys:<br><p> 		- storage - the capacity of the volume.<br><p> 	&#42; Custom resources must use implementation-defined prefixed names such as "example.com/my-custom-resource"<br><p> Apart from above values - keys that are unprefixed or have kubernetes.io prefix are considered reserved and hence may not be used.<br><p> <br><p> ClaimResourceStatus can be in any of following states:<br><p> 	- ControllerResizeInProgress:<br><p> 		State set when resize controller starts resizing the volume in control-plane.<br><p> 	- ControllerResizeFailed:<br><p> 		State set when resize has failed in resize controller with a terminal error.<br><p> 	- NodeResizePending:<br><p> 		State set when resize controller has finished resizing the volume but further resizing of<br><p> 		volume is needed on the node.<br><p> 	- NodeResizeInProgress:<br><p> 		State set when kubelet starts resizing the volume.<br><p> 	- NodeResizeFailed:<br><p> 		State set when resizing has failed in kubelet with a terminal error. Transient errors don't set<br><p> 		NodeResizeFailed.<br><p> For example: if expanding a PVC for more capacity - this field can be one of the following states:<br><p> 	- pvc.status.allocatedResourceStatus['storage'] = "ControllerResizeInProgress"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "ControllerResizeFailed"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizePending"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizeInProgress"<br><p>      - pvc.status.allocatedResourceStatus['storage'] = "NodeResizeFailed"<br><p> When this field is not set, it means that no resize operation is in progress for the given PVC.<br><p> <br><p> A controller that receives PVC update with previously unknown resourceName or ClaimResourceStatus should ignore the update for the purpose it was designed. For example - a controller that only is responsible for resizing capacity of the volume, should ignore PVC updates that change other valid resources associated with PVC.<br><p> <br><p> This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
   */
  @JsonProperty("allocatedResourceStatuses")
  @Singular(value = "putInAllocatedResourceStatuses", ignoreNullCollections = true)
  private Map<String, String> allocatedResourceStatuses;

  /**
   * allocatedResources tracks the resources allocated to a PVC including its capacity. Key names follow standard Kubernetes label syntax. Valid values are either:<br><p> 	&#42; Un-prefixed keys:<br><p> 		- storage - the capacity of the volume.<br><p> 	&#42; Custom resources must use implementation-defined prefixed names such as "example.com/my-custom-resource"<br><p> Apart from above values - keys that are unprefixed or have kubernetes.io prefix are considered reserved and hence may not be used.<br><p> <br><p> Capacity reported here may be larger than the actual capacity when a volume expansion operation is requested. For storage quota, the larger value from allocatedResources and PVC.spec.resources is used. If allocatedResources is not set, PVC.spec.resources alone is used for quota calculation. If a volume expansion capacity request is lowered, allocatedResources is only lowered if there are no expansion operations in progress and if the actual volume capacity is equal or lower than the requested capacity.<br><p> <br><p> A controller that receives PVC update with previously unknown resourceName should ignore the update for the purpose it was designed. For example - a controller that only is responsible for resizing capacity of the volume, should ignore PVC updates that change other valid resources associated with PVC.<br><p> <br><p> This is an alpha field and requires enabling RecoverVolumeExpansionFailure feature.
   */
  @JsonProperty("allocatedResources")
  @Singular(value = "putInAllocatedResources", ignoreNullCollections = true)
  private Map<String, String> allocatedResources;

  /**
   * capacity represents the actual resources of the underlying volume.
   */
  @JsonProperty("capacity")
  @Singular(value = "putInCapacity", ignoreNullCollections = true)
  private Map<String, String> capacity;

  /**
   * conditions is the current Condition of persistent volume claim. If underlying persistent volume is being resized then the Condition will be set to 'Resizing'.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<PersistentVolumeClaimCondition> conditions;

  /**
   * currentVolumeAttributesClassName is the current name of the VolumeAttributesClass the PVC is using. When unset, there is no VolumeAttributeClass applied to this PersistentVolumeClaim This is an alpha field and requires enabling VolumeAttributesClass feature.
   */
  @JsonProperty("currentVolumeAttributesClassName")
  private String currentVolumeAttributesClassName;

  @JsonProperty("modifyVolumeStatus")
  private ModifyVolumeStatus modifyVolumeStatus;

  /**
   * phase represents the current phase of PersistentVolumeClaim.
   */
  @JsonProperty("phase")
  private String phase;

}

