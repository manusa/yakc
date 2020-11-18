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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * VolumeMount describes a mounting of a Volume within a container.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpecVolumeMounts implements Model {


  /**
   * Path within the container at which the volume should be mounted.  Must not contain ':'.
   */
  @NonNull
  @JsonProperty("mountPath")
  private String mountPath;

  /**
   * mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10.
   */
  @JsonProperty("mountPropagation")
  private String mountPropagation;

  /**
   * This must match the Name of a Volume.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  /**
   * Path within the volume from which the container's volume should be mounted. Defaults to "" (volume's root).
   */
  @JsonProperty("subPath")
  private String subPath;

  /**
   * Expanded path within the volume from which the container's volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container's environment. Defaults to "" (volume's root). SubPathExpr and SubPath are mutually exclusive. This field is beta in 1.15.
   */
  @JsonProperty("subPathExpr")
  private String subPathExpr;

}

