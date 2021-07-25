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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * Spec defines the behavior of a pod chaos experiment
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkChaosSpec implements Model {


  /**
   * Action defines the specific network chaos action. Supported action: partition, netem, delay, loss, duplicate, corrupt Default action: delay
   */
  @NonNull
  @JsonProperty("action")
  private String action;

  @JsonProperty("bandwidth")
  private NetworkChaosSpecBandwidth bandwidth;

  @JsonProperty("corrupt")
  private NetworkChaosSpecCorrupt corrupt;

  @JsonProperty("delay")
  private NetworkChaosSpecDelay delay;

  /**
   * Direction represents the direction, this applies on netem and network partition action
   */
  @JsonProperty("direction")
  private String direction;

  @JsonProperty("duplicate")
  private NetworkChaosSpecDuplicate duplicate;

  /**
   * Duration represents the duration of the chaos action
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * ExternalTargets represents network targets outside k8s
   */
  @JsonProperty("externalTargets")
  @Singular(value = "addToExternalTargets", ignoreNullCollections = true)
  private List<String> externalTargets;

  @JsonProperty("loss")
  private NetworkChaosSpecLoss loss;

  /**
   * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
   */
  @NonNull
  @JsonProperty("mode")
  private String mode;

  @NonNull
  @JsonProperty("selector")
  private DNSChaosSpecSelector selector;

  @JsonProperty("target")
  private NetworkChaosSpecTarget target;

  /**
   * Value is required when the mode is set to `FixedPodMode` / `FixedPercentPodMod` / `RandomMaxPercentPodMod`. If `FixedPodMode`, provide an integer of pods to do chaos action. If `FixedPercentPodMod`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentPodMod`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
   */
  @JsonProperty("value")
  private String value;

}

