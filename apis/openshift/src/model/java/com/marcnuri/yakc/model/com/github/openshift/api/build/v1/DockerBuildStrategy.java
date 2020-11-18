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
import com.marcnuri.yakc.model.io.k8s.api.core.v1.EnvVar;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.LocalObjectReference;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * DockerBuildStrategy defines input parameters specific to container image build.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DockerBuildStrategy implements Model {


  /**
   * buildArgs contains build arguments that will be resolved in the Dockerfile.  See https://docs.docker.com/engine/reference/builder/#/arg for more details.
   */
  @JsonProperty("buildArgs")
  @Singular(value = "addToBuildArgs", ignoreNullCollections = true)
  private List<EnvVar> buildArgs;

  /**
   * dockerfilePath is the path of the Dockerfile that will be used to build the container image, relative to the root of the context (contextDir).
   */
  @JsonProperty("dockerfilePath")
  private String dockerfilePath;

  /**
   * env contains additional environment variables you want to pass into a builder container.
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<EnvVar> env;

  /**
   * forcePull describes if the builder should pull the images from registry prior to building.
   */
  @JsonProperty("forcePull")
  private Boolean forcePull;

  @JsonProperty("from")
  private ObjectReference from;

  /**
   * imageOptimizationPolicy describes what optimizations the system can use when building images to reduce the final size or time spent building the image. The default policy is 'None' which means the final build image will be equivalent to an image created by the container image build API. The experimental policy 'SkipLayers' will avoid commiting new layers in between each image step, and will fail if the Dockerfile cannot provide compatibility with the 'None' policy. An additional experimental policy 'SkipLayersAndWarn' is the same as 'SkipLayers' but simply warns if compatibility cannot be preserved.
   */
  @JsonProperty("imageOptimizationPolicy")
  private String imageOptimizationPolicy;

  /**
   * noCache if set to true indicates that the container image build must be executed with the --no-cache=true flag
   */
  @JsonProperty("noCache")
  private Boolean noCache;

  @JsonProperty("pullSecret")
  private LocalObjectReference pullSecret;

}

