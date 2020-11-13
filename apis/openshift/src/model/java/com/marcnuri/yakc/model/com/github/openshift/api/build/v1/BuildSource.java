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

package com.marcnuri.yakc.model.com.github.openshift.api.build.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.LocalObjectReference;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * BuildSource is the SCM used for the build.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildSource implements Model {


  @JsonProperty("binary")
  private BinaryBuildSource binary;

  /**
   * configMaps represents a list of configMaps and their destinations that will be used for the build.
   */
  @JsonProperty("configMaps")
  @Singular(value = "addToConfigMaps", ignoreNullCollections = true)
  private List<ConfigMapBuildSource> configMaps;

  /**
   * contextDir specifies the sub-directory where the source code for the application exists. This allows to have buildable sources in directory other than root of repository.
   */
  @JsonProperty("contextDir")
  private String contextDir;

  /**
   * dockerfile is the raw contents of a Dockerfile which should be built. When this option is specified, the FROM may be modified based on your strategy base image and additional ENV stanzas from your strategy environment will be added after the FROM, but before the rest of your Dockerfile stanzas. The Dockerfile source type may be used with other options like git - in those cases the Git repo will have any innate Dockerfile replaced in the context dir.
   */
  @JsonProperty("dockerfile")
  private String dockerfile;

  @JsonProperty("git")
  private GitBuildSource git;

  /**
   * images describes a set of images to be used to provide source for the build
   */
  @JsonProperty("images")
  @Singular(value = "addToImages", ignoreNullCollections = true)
  private List<ImageSource> images;

  /**
   * secrets represents a list of secrets and their destinations that will be used only for the build.
   */
  @JsonProperty("secrets")
  @Singular(value = "addToSecrets", ignoreNullCollections = true)
  private List<SecretBuildSource> secrets;

  @JsonProperty("sourceSecret")
  private LocalObjectReference sourceSecret;

  /**
   * type of build input to accept
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

