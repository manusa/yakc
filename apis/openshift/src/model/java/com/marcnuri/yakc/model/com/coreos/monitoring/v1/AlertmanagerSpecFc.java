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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * FC represents a Fibre Channel resource that is attached to a kubelet's host machine and then exposed to the pod.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpecFc implements Model {


  /**
   * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. TODO: how do we prevent errors in the filesystem from compromising the machine
   */
  @JsonProperty("fsType")
  private String fsType;

  /**
   * Optional: FC target lun number
   */
  @JsonProperty("lun")
  private Number lun;

  /**
   * Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  /**
   * Optional: FC target worldwide names (WWNs)
   */
  @JsonProperty("targetWWNs")
  @Singular(value = "addToTargetWWNs", ignoreNullCollections = true)
  private List<String> targetWWNs;

  /**
   * Optional: FC volume world wide identifiers (wwids) Either wwids or combination of targetWWNs and lun must be set, but not both simultaneously.
   */
  @JsonProperty("wwids")
  @Singular(value = "addToWwids", ignoreNullCollections = true)
  private List<String> wwids;

}

