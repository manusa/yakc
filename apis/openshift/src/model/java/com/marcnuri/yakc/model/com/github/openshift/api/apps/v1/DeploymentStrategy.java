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

package com.marcnuri.yakc.model.com.github.openshift.api.apps.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ResourceRequirements;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * DeploymentStrategy describes how to perform a deployment.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DeploymentStrategy implements Model {


  /**
   * ActiveDeadlineSeconds is the duration in seconds that the deployer pods for this deployment config may be active on a node before the system actively tries to terminate them.
   */
  @JsonProperty("activeDeadlineSeconds")
  private Number activeDeadlineSeconds;

  /**
   * Annotations is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
   */
  @JsonProperty("annotations")
  @Singular(value = "putInAnnotations", ignoreNullCollections = true)
  private Map<String, String> annotations;

  @JsonProperty("customParams")
  private CustomDeploymentStrategyParams customParams;

  /**
   * Labels is a set of key, value pairs added to custom deployer and lifecycle pre/post hook pods.
   */
  @JsonProperty("labels")
  @Singular(value = "putInLabels", ignoreNullCollections = true)
  private Map<String, String> labels;

  @JsonProperty("recreateParams")
  private RecreateDeploymentStrategyParams recreateParams;

  @JsonProperty("resources")
  private ResourceRequirements resources;

  @JsonProperty("rollingParams")
  private RollingDeploymentStrategyParams rollingParams;

  /**
   * Type is the name of a deployment strategy.
   */
  @JsonProperty("type")
  private String type;

}

