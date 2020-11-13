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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * RecreateDeploymentStrategyParams are the input to the Recreate deployment strategy.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RecreateDeploymentStrategyParams implements Model {


  @JsonProperty("mid")
  private LifecycleHook mid;

  @JsonProperty("post")
  private LifecycleHook post;

  @JsonProperty("pre")
  private LifecycleHook pre;

  /**
   * TimeoutSeconds is the time to wait for updates before giving up. If the value is nil, a default will be used.
   */
  @JsonProperty("timeoutSeconds")
  private Number timeoutSeconds;

}

