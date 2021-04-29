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
 * JVMChaosSpec defines the desired state of JVMChaos
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JVMChaosSpec implements Model {


  /**
   * Action defines the specific jvm chaos action. Supported action: delay;return;script;cfl;oom;ccf;tce;cpf;tde;tpf
   */
  @NonNull
  @JsonProperty("action")
  private String action;

  /**
   * Duration represents the duration of the chaos action
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * Flags represents the flags of action
   */
  @JsonProperty("flags")
  @Singular(value = "putInFlags", ignoreNullCollections = true)
  private Map<String, String> flags;

  /**
   * Matchers represents the matching rules for the target
   */
  @JsonProperty("matchers")
  @Singular(value = "putInMatchers", ignoreNullCollections = true)
  private Map<String, String> matchers;

  /**
   * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
   */
  @NonNull
  @JsonProperty("mode")
  private String mode;

  @JsonProperty("scheduler")
  private AwsChaosSpecScheduler scheduler;

  @NonNull
  @JsonProperty("selector")
  private DNSChaosSpecSelector selector;

  /**
   * Target defines the specific jvm chaos target. Supported target: servlet;psql;jvm;jedis;http;dubbo;rocketmq;tars;mysql;druid;redisson;rabbitmq;mongodb
   */
  @NonNull
  @JsonProperty("target")
  private String target;

  /**
   * Value is required when the mode is set to `FixedPodMode` / `FixedPercentPodMod` / `RandomMaxPercentPodMod`. If `FixedPodMode`, provide an integer of pods to do chaos action. If `FixedPercentPodMod`, provide a number from 0-100 to specify the max % of pods the server can do chaos action. If `RandomMaxPercentPodMod`,  provide a number from 0-100 to specify the % of pods to do chaos action
   */
  @JsonProperty("value")
  private String value;

}

