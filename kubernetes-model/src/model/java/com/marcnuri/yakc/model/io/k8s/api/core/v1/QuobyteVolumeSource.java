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
 * Represents a Quobyte mount that lasts the lifetime of a pod. Quobyte volumes do not support ownership management or SELinux relabeling.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class QuobyteVolumeSource implements Model {


  /**
   * group to map volume access to Default is no group
   */
  @JsonProperty("group")
  private String group;

  /**
   * readOnly here will force the Quobyte volume to be mounted with read-only permissions. Defaults to false.
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  /**
   * registry represents a single or multiple Quobyte Registry services specified as a string as host:port pair (multiple entries are separated with commas) which acts as the central registry for volumes
   */
  @NonNull
  @JsonProperty("registry")
  private String registry;

  /**
   * tenant owning the given Quobyte volume in the Backend Used with dynamically provisioned Quobyte volumes, value is set by the plugin
   */
  @JsonProperty("tenant")
  private String tenant;

  /**
   * user to map volume access to Defaults to serivceaccount user
   */
  @JsonProperty("user")
  private String user;

  /**
   * volume is a string that references an already created Quobyte volume by name.
   */
  @NonNull
  @JsonProperty("volume")
  private String volume;

}

