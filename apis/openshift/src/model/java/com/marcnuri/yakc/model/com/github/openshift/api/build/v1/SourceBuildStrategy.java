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
 * SourceBuildStrategy defines input parameters specific to an Source build.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SourceBuildStrategy implements Model {


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

  @NonNull
  @JsonProperty("from")
  private ObjectReference from;

  /**
   * incremental flag forces the Source build to do incremental builds if true.
   */
  @JsonProperty("incremental")
  private Boolean incremental;

  @JsonProperty("pullSecret")
  private LocalObjectReference pullSecret;

  /**
   * scripts is the location of Source scripts
   */
  @JsonProperty("scripts")
  private String scripts;

}

