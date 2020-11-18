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
import com.marcnuri.yakc.model.io.k8s.api.core.v1.EnvVar;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * CustomDeploymentStrategyParams are the input to the Custom deployment strategy.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomDeploymentStrategyParams implements Model {


  /**
   * Command is optional and overrides CMD in the container Image.
   */
  @JsonProperty("command")
  @Singular(value = "addToCommand", ignoreNullCollections = true)
  private List<String> command;

  /**
   * Environment holds the environment which will be given to the container for Image.
   */
  @JsonProperty("environment")
  @Singular(value = "addToEnvironment", ignoreNullCollections = true)
  private List<EnvVar> environment;

  /**
   * Image specifies a container image which can carry out a deployment.
   */
  @JsonProperty("image")
  private String image;

}

