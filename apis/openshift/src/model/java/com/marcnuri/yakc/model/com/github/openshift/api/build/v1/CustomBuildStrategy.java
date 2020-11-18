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
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * CustomBuildStrategy defines input parameters specific to Custom build.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomBuildStrategy implements Model {


  /**
   * buildAPIVersion is the requested API version for the Build object serialized and passed to the custom builder
   */
  @JsonProperty("buildAPIVersion")
  private String buildAPIVersion;

  /**
   * env contains additional environment variables you want to pass into a builder container.
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<EnvVar> env;

  /**
   * exposeDockerSocket will allow running Docker commands (and build container images) from inside the container.
   */
  @JsonProperty("exposeDockerSocket")
  private Boolean exposeDockerSocket;

  /**
   * forcePull describes if the controller should configure the build pod to always pull the images for the builder or only pull if it is not present locally
   */
  @JsonProperty("forcePull")
  private Boolean forcePull;

  @NonNull
  @JsonProperty("from")
  private ObjectReference from;

  @JsonProperty("pullSecret")
  private LocalObjectReference pullSecret;

  /**
   * secrets is a list of additional secrets that will be included in the build pod
   */
  @JsonProperty("secrets")
  @Singular(value = "addToSecrets", ignoreNullCollections = true)
  private List<SecretSpec> secrets;

}

