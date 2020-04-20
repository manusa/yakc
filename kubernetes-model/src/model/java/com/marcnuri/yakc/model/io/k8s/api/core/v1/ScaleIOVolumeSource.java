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
 * ScaleIOVolumeSource represents a persistent ScaleIO volume
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScaleIOVolumeSource implements Model {


  /**
   * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Default is "xfs".
   */
  @JsonProperty("fsType")
  private String fsType;

  /**
   * The host address of the ScaleIO API Gateway.
   */
  @NonNull
  @JsonProperty("gateway")
  private String gateway;

  /**
   * The name of the ScaleIO Protection Domain for the configured storage.
   */
  @JsonProperty("protectionDomain")
  private String protectionDomain;

  /**
   * Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  @NonNull
  @JsonProperty("secretRef")
  private LocalObjectReference secretRef;

  /**
   * Flag to enable/disable SSL communication with Gateway, default false
   */
  @JsonProperty("sslEnabled")
  private Boolean sslEnabled;

  /**
   * Indicates whether the storage for a volume should be ThickProvisioned or ThinProvisioned. Default is ThinProvisioned.
   */
  @JsonProperty("storageMode")
  private String storageMode;

  /**
   * The ScaleIO Storage Pool associated with the protection domain.
   */
  @JsonProperty("storagePool")
  private String storagePool;

  /**
   * The name of the storage system as configured in ScaleIO.
   */
  @NonNull
  @JsonProperty("system")
  private String system;

  /**
   * The name of a volume already created in the ScaleIO system that is associated with this volume source.
   */
  @JsonProperty("volumeName")
  private String volumeName;

}

