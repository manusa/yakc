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
 * IoChaosSpec defines the desired state of IoChaos
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IoChaosSpec implements Model {


  /**
   * Action defines the specific pod chaos action. Supported action: latency / fault / attrOverride / mistake
   */
  @NonNull
  @JsonProperty("action")
  private String action;

  @JsonProperty("attr")
  private IoChaosSpecAttr attr;

  /**
   * ContainerName indicates the target container to inject iochaos in
   */
  @JsonProperty("containerName")
  private String containerName;

  /**
   * Delay defines the value of I/O chaos action delay. A delay string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
   */
  @JsonProperty("delay")
  private String delay;

  /**
   * Duration represents the duration of the chaos action. It is required when the action is `PodFailureAction`. A duration string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "-1.5h" or "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * Errno defines the error code that returned by I/O action. refer to: https://www-numi.fnal.gov/offline_software/srt_public_context/WebDocs/Errors/unix_system_errors.html
   */
  @JsonProperty("errno")
  private Number errno;

  /**
   * Methods defines the I/O methods for injecting I/O chaos action. default: all I/O methods.
   */
  @JsonProperty("methods")
  @Singular(value = "addToMethods", ignoreNullCollections = true)
  private List<String> methods;

  @JsonProperty("mistake")
  private IoChaosSpecMistake mistake;

  /**
   * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
   */
  @NonNull
  @JsonProperty("mode")
  private String mode;

  /**
   * Path defines the path of files for injecting I/O chaos action.
   */
  @JsonProperty("path")
  private String path;

  /**
   * Percent defines the percentage of injection errors and provides a number from 0-100. default: 100.
   */
  @JsonProperty("percent")
  private Number percent;

  @JsonProperty("scheduler")
  private HTTPChaosSpecScheduler scheduler;

  @NonNull
  @JsonProperty("selector")
  private DNSChaosSpecSelector selector;

  /**
   * Value is required when the mode is set to `FixedPodMode` / `FixedPercentPodMod` / `RandomMaxPercentPodMod`. If `FixedPodMode`, provide an integer of pods to do chaos action. If `FixedPercentPodMod`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentPodMod`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
   */
  @JsonProperty("value")
  private String value;

  /**
   * VolumePath represents the mount path of injected volume
   */
  @NonNull
  @JsonProperty("volumePath")
  private String volumePath;

}

