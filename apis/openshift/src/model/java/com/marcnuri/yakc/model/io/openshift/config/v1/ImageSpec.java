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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * spec holds user settable values for configuration
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageSpec implements Model {


  @JsonProperty("additionalTrustedCA")
  private ImageSpecAdditionalTrustedCA additionalTrustedCA;

  /**
   * allowedRegistriesForImport limits the container image registries that normal users may import images from. Set this list to the registries that you trust to contain valid Docker images and that you want applications to be able to import from. Users with permission to create Images or ImageStreamMappings via the API are not affected by this policy - typically only administrators or system integrations will have those permissions.
   */
  @JsonProperty("allowedRegistriesForImport")
  @Singular(value = "addToAllowedRegistriesForImport", ignoreNullCollections = true)
  private List<ImageSpecAllowedRegistriesForImport> allowedRegistriesForImport;

  /**
   * externalRegistryHostnames provides the hostnames for the default external image registry. The external hostname should be set only when the image registry is exposed externally. The first value is used in 'publicDockerImageRepository' field in ImageStreams. The value must be in "hostname[:port]" format.
   */
  @JsonProperty("externalRegistryHostnames")
  @Singular(value = "addToExternalRegistryHostnames", ignoreNullCollections = true)
  private List<String> externalRegistryHostnames;

  @JsonProperty("registrySources")
  private ImageSpecRegistrySources registrySources;

}

