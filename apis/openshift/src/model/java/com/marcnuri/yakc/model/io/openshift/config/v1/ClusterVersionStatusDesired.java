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

package com.marcnuri.yakc.model.io.openshift.config.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * desired is the version that the cluster is reconciling towards. If the cluster is not yet fully initialized desired will be set with the information available, which may be an image or a tag.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterVersionStatusDesired implements Model {


  /**
   * force allows an administrator to update to an image that has failed verification, does not appear in the availableUpdates list, or otherwise would be blocked by normal protections on update. This option should only be used when the authenticity of the provided image has been verified out of band because the provided image will run with full administrative access to the cluster. Do not use this flag with images that comes from unknown or potentially malicious sources. <br><p>  This flag does not override other forms of consistency checking that are required before a new update is deployed.
   */
  @JsonProperty("force")
  private Boolean force;

  /**
   * image is a container image location that contains the update. When this field is part of spec, image is optional if version is specified and the availableUpdates field contains a matching version.
   */
  @JsonProperty("image")
  private String image;

  /**
   * version is a semantic versioning identifying the update version. When this field is part of spec, version is optional if image is specified.
   */
  @JsonProperty("version")
  private String version;

}

