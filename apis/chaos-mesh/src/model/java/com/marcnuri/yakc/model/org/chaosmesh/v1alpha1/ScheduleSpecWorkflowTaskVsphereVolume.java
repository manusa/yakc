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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * VsphereVolume represents a vSphere volume attached and mounted on kubelets host machine
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleSpecWorkflowTaskVsphereVolume implements Model {


  /**
   * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
   */
  @JsonProperty("fsType")
  private String fsType;

  /**
   * Storage Policy Based Management (SPBM) profile ID associated with the StoragePolicyName.
   */
  @JsonProperty("storagePolicyID")
  private String storagePolicyID;

  /**
   * Storage Policy Based Management (SPBM) profile name.
   */
  @JsonProperty("storagePolicyName")
  private String storagePolicyName;

  /**
   * Path that identifies vSphere volume vmdk
   */
  @NonNull
  @JsonProperty("volumePath")
  private String volumePath;

}

