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
 * VolumeMount describes a mounting of a Volume within a container.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VolumeMount implements Model {


  /**
   * Path within the container at which the volume should be mounted.  Must not contain ':'.
   */
  @NonNull
  @JsonProperty("mountPath")
  private String mountPath;

  /**
   * mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10. When RecursiveReadOnly is set to IfPossible or to Enabled, MountPropagation must be None or unspecified (which defaults to None).
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
   * RecursiveReadOnly specifies whether read-only mounts should be handled recursively.<br><p> <br><p> If ReadOnly is false, this field has no meaning and must be unspecified.<br><p> <br><p> If ReadOnly is true, and this field is set to Disabled, the mount is not made recursively read-only.  If this field is set to IfPossible, the mount is made recursively read-only, if it is supported by the container runtime.  If this field is set to Enabled, the mount is made recursively read-only if it is supported by the container runtime, otherwise the pod will not be started and an error will be generated to indicate the reason.<br><p> <br><p> If this field is set to IfPossible or Enabled, MountPropagation must be set to None (or be unspecified, which defaults to None).<br><p> <br><p> If this field is not specified, it is treated as an equivalent of Disabled.
   */
  @JsonProperty("recursiveReadOnly")
  private String recursiveReadOnly;

  /**
   * Path within the volume from which the container's volume should be mounted. Defaults to "" (volume's root).
   */
  @JsonProperty("subPath")
  private String subPath;

  /**
   * Expanded path within the volume from which the container's volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container's environment. Defaults to "" (volume's root). SubPathExpr and SubPath are mutually exclusive.
   */
  @JsonProperty("subPathExpr")
  private String subPathExpr;

}

