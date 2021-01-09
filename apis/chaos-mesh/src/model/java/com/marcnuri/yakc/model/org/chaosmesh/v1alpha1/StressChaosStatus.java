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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * Most recently observed status of the time chaos experiment
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StressChaosStatus implements Model {


  @NonNull
  @JsonProperty("experiment")
  private DNSChaosStatusExperiment experiment;

  @JsonProperty("failedMessage")
  private String failedMessage;

  /**
   * Instances always specifies stressing instances
   */
  @JsonProperty("instances")
  @Singular(value = "putInInstances", ignoreNullCollections = true)
  private Map<String, StressChaosStatusInstances> instances;

  /**
   * Phase is the chaos status.
   */
  @NonNull
  @JsonProperty("phase")
  private String phase;

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("scheduler")
  private DNSChaosStatusScheduler scheduler;

}

