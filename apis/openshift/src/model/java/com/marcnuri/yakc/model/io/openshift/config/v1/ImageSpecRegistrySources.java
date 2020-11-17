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
 * registrySources contains configuration that determines how the container runtime should treat individual registries when accessing images for builds+pods. (e.g. whether or not to allow insecure access).  It does not contain configuration for the internal cluster registry.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageSpecRegistrySources implements Model {


  /**
   * allowedRegistries are the only registries permitted for image pull and push actions. All other registries are denied. <br><p>  Only one of BlockedRegistries or AllowedRegistries may be set.
   */
  @JsonProperty("allowedRegistries")
  @Singular(value = "addToAllowedRegistries", ignoreNullCollections = true)
  private List<String> allowedRegistries;

  /**
   * blockedRegistries cannot be used for image pull and push actions. All other registries are permitted. <br><p>  Only one of BlockedRegistries or AllowedRegistries may be set.
   */
  @JsonProperty("blockedRegistries")
  @Singular(value = "addToBlockedRegistries", ignoreNullCollections = true)
  private List<String> blockedRegistries;

  /**
   * insecureRegistries are registries which do not have a valid TLS certificates or only support HTTP connections.
   */
  @JsonProperty("insecureRegistries")
  @Singular(value = "addToInsecureRegistries", ignoreNullCollections = true)
  private List<String> insecureRegistries;

}

