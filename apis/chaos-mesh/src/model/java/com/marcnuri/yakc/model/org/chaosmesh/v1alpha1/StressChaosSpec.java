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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Spec defines the behavior of a time chaos experiment
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StressChaosSpec implements Model {


  /**
   * ContainerName indicates the target container to inject stress in
   */
  @JsonProperty("containerName")
  private String containerName;

  /**
   * Duration represents the duration of the chaos action
   */
  @JsonProperty("duration")
  private String duration;

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
   * StressngStressors defines plenty of stressors just like `Stressors` except that it's an experimental feature and more powerful. You can define stressors in `stress-ng` (see also `man stress-ng`) dialect, however not all of the supported stressors are well tested. It maybe retired in later releases. You should always use `Stressors` to define the stressors and use this only when you want more stressors unsupported by `Stressors`. When both `StressngStressors` and `Stressors` are defined, `StressngStressors` wins.
   */
  @JsonProperty("stressngStressors")
  private String stressngStressors;

  @JsonProperty("stressors")
  private StressChaosSpecStressors stressors;

  /**
   * Value is required when the mode is set to `FixedPodMode` / `FixedPercentPodMod` / `RandomMaxPercentPodMod`. If `FixedPodMode`, provide an integer of pods to do chaos action. If `FixedPercentPodMod`, provide a number from 0-100 to specify the max % of pods the server can do chaos action. If `RandomMaxPercentPodMod`,  provide a number from 0-100 to specify the % of pods to do chaos action
   */
  @JsonProperty("value")
  private String value;

}

