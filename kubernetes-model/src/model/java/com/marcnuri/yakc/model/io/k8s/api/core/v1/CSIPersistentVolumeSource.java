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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * Represents storage that is managed by an external CSI volume driver (Beta feature)
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CSIPersistentVolumeSource implements Model {


  @JsonProperty("controllerExpandSecretRef")
  private SecretReference controllerExpandSecretRef;

  @JsonProperty("controllerPublishSecretRef")
  private SecretReference controllerPublishSecretRef;

  /**
   * driver is the name of the driver to use for this volume. Required.
   */
  @NonNull
  @JsonProperty("driver")
  private String driver;

  /**
   * fsType to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs".
   */
  @JsonProperty("fsType")
  private String fsType;

  @JsonProperty("nodePublishSecretRef")
  private SecretReference nodePublishSecretRef;

  @JsonProperty("nodeStageSecretRef")
  private SecretReference nodeStageSecretRef;

  /**
   * readOnly value to pass to ControllerPublishVolumeRequest. Defaults to false (read/write).
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  /**
   * volumeAttributes of the volume to publish.
   */
  @JsonProperty("volumeAttributes")
  @Singular(value = "putInVolumeAttributes", ignoreNullCollections = true)
  private Map<String, String> volumeAttributes;

  /**
   * volumeHandle is the unique volume name returned by the CSI volume plugin’s CreateVolume to refer to the volume on all subsequent calls. Required.
   */
  @NonNull
  @JsonProperty("volumeHandle")
  private String volumeHandle;

}

