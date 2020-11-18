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

package com.marcnuri.yakc.model.com.coreos.monitoring.v1;

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
 * CSI (Container Storage Interface) represents storage that is handled by an external CSI driver (Alpha feature).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpecCsi implements Model {


  /**
   * Driver is the name of the CSI driver that handles this volume. Consult with your admin for the correct name as registered in the cluster.
   */
  @NonNull
  @JsonProperty("driver")
  private String driver;

  /**
   * Filesystem type to mount. Ex. "ext4", "xfs", "ntfs". If not provided, the empty value is passed to the associated CSI driver which will determine the default filesystem to apply.
   */
  @JsonProperty("fsType")
  private String fsType;

  @JsonProperty("nodePublishSecretRef")
  private AlertmanagerSpecCsiNodePublishSecretRef nodePublishSecretRef;

  /**
   * Specifies a read-only configuration for the volume. Defaults to false (read/write).
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  /**
   * VolumeAttributes stores driver-specific properties that are passed to the CSI driver. Consult your driver's documentation for supported values.
   */
  @JsonProperty("volumeAttributes")
  @Singular(value = "putInVolumeAttributes", ignoreNullCollections = true)
  private Map<String, String> volumeAttributes;

}

