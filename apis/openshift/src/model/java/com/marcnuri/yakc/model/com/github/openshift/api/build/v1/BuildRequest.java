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
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * BuildRequest is the resource used to pass parameters to build generator
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildRequest implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  @JsonProperty("binary")
  private BinaryBuildSource binary;

  @JsonProperty("dockerStrategyOptions")
  private DockerStrategyOptions dockerStrategyOptions;

  /**
   * env contains additional environment variables you want to pass into a builder container.
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<EnvVar> env;

  @JsonProperty("from")
  private ObjectReference from;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  /**
   * lastVersion (optional) is the LastVersion of the BuildConfig that was used to generate the build. If the BuildConfig in the generator doesn't match, a build will not be generated.
   */
  @JsonProperty("lastVersion")
  private Number lastVersion;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  @JsonProperty("revision")
  private SourceRevision revision;

  @JsonProperty("sourceStrategyOptions")
  private SourceStrategyOptions sourceStrategyOptions;

  /**
   * triggeredBy describes which triggers started the most recent update to the build configuration and contains information about those triggers.
   */
  @NonNull
  @JsonProperty("triggeredBy")
  @Singular(value = "addToTriggeredBy", ignoreNullCollections = true)
  private List<BuildTriggerCause> triggeredBy;

  @JsonProperty("triggeredByImage")
  private ObjectReference triggeredByImage;

}

