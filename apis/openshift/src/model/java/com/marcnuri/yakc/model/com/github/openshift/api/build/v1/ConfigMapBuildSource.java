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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ConfigMapBuildSource describes a configmap and its destination directory that will be used only at the build time. The content of the configmap referenced here will be copied into the destination directory instead of mounting.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigMapBuildSource implements Model {


  @NonNull
  @JsonProperty("configMap")
  private LocalObjectReference configMap;

  /**
   * destinationDir is the directory where the files from the configmap should be available for the build time. For the Source build strategy, these will be injected into a container where the assemble script runs. For the container image build strategy, these will be copied into the build directory, where the Dockerfile is located, so users can ADD or COPY them during container image build.
   */
  @JsonProperty("destinationDir")
  private String destinationDir;

}

