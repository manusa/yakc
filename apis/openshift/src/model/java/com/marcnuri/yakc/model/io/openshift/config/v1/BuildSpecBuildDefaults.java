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
 * BuildDefaults controls the default information for Builds
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildSpecBuildDefaults implements Model {


  @JsonProperty("defaultProxy")
  private BuildSpecBuildDefaultsDefaultProxy defaultProxy;

  /**
   * Env is a set of default environment variables that will be applied to the build if the specified variables do not exist on the build
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<BuildSpecBuildDefaultsEnv> env;

  @JsonProperty("gitProxy")
  private BuildSpecBuildDefaultsGitProxy gitProxy;

  /**
   * ImageLabels is a list of docker labels that are applied to the resulting image. User can override a default label by providing a label with the same name in their Build/BuildConfig.
   */
  @JsonProperty("imageLabels")
  @Singular(value = "addToImageLabels", ignoreNullCollections = true)
  private List<BuildSpecBuildDefaultsImageLabels> imageLabels;

  @JsonProperty("resources")
  private BuildSpecBuildDefaultsResources resources;

}

