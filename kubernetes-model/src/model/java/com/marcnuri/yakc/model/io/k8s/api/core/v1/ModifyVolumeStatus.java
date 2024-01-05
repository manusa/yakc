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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ModifyVolumeStatus represents the status object of ControllerModifyVolume operation
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ModifyVolumeStatus implements Model {


  /**
   * status is the status of the ControllerModifyVolume operation. It can be in any of following states:<br><p>  - Pending<br><p>    Pending indicates that the PersistentVolumeClaim cannot be modified due to unmet requirements, such as<br><p>    the specified VolumeAttributesClass not existing.<br><p>  - InProgress<br><p>    InProgress indicates that the volume is being modified.<br><p>  - Infeasible<br><p>   Infeasible indicates that the request has been rejected as invalid by the CSI driver. To<br><p> 	  resolve the error, a valid VolumeAttributesClass needs to be specified.<br><p> Note: New statuses can be added in the future. Consumers should check for unknown statuses and fail appropriately.
   */
  @NonNull
  @JsonProperty("status")
  private String status;

  /**
   * targetVolumeAttributesClassName is the name of the VolumeAttributesClass the PVC currently being reconciled
   */
  @JsonProperty("targetVolumeAttributesClassName")
  private String targetVolumeAttributesClassName;

}

