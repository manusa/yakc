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
 * DNSChaosSpec defines the desired state of DNSChaos
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleSpecDnsChaos implements Model {


  /**
   * Action defines the specific DNS chaos action. Supported action: error, random Default action: error
   */
  @NonNull
  @JsonProperty("action")
  private String action;

  /**
   * ContainerNames indicates list of the name of affected container. If not set, all containers will be injected
   */
  @JsonProperty("containerNames")
  @Singular(value = "addToContainerNames", ignoreNullCollections = true)
  private List<String> containerNames;

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

  /**
   * Choose which domain names to take effect, support the placeholder ? and wildcard &#42;, or the Specified domain name. Note:      1. The wildcard &#42; must be at the end of the string. For example, chaos-&#42;.org is invalid.      2. if the patterns is empty, will take effect on all the domain names. For example: 		The value is ["google.com", "github.&#42;", "chaos-mes?.org"], 		will take effect on "google.com", "github.com" and "chaos-mesh.org"
   */
  @JsonProperty("patterns")
  @Singular(value = "addToPatterns", ignoreNullCollections = true)
  private List<String> patterns;

  @NonNull
  @JsonProperty("selector")
  private DNSChaosSpecSelector selector;

  /**
   * Value is required when the mode is set to `FixedPodMode` / `FixedPercentPodMod` / `RandomMaxPercentPodMod`. If `FixedPodMode`, provide an integer of pods to do chaos action. If `FixedPercentPodMod`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentPodMod`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
   */
  @JsonProperty("value")
  private String value;

}

