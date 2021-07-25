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
 * Schedule describe the Schedule(describing scheduled chaos) to be injected with chaos nodes. Only used when Type is TypeSchedule.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleSpecWorkflowSchedule implements Model {


  @JsonProperty("awsChaos")
  private AWSChaosSpec awsChaos;

  @JsonProperty("concurrencyPolicy")
  private String concurrencyPolicy;

  @JsonProperty("dnsChaos")
  private ScheduleSpecDnsChaos dnsChaos;

  @JsonProperty("gcpChaos")
  private GCPChaosSpec gcpChaos;

  @JsonProperty("historyLimit")
  private Number historyLimit;

  @JsonProperty("httpChaos")
  private HTTPChaosSpec httpChaos;

  @JsonProperty("ioChaos")
  private IOChaosSpec ioChaos;

  @JsonProperty("jvmChaos")
  private JVMChaosSpec jvmChaos;

  @JsonProperty("kernelChaos")
  private ScheduleSpecKernelChaos kernelChaos;

  @JsonProperty("networkChaos")
  private ScheduleSpecNetworkChaos networkChaos;

  @JsonProperty("podChaos")
  private ScheduleSpecPodChaos podChaos;

  @NonNull
  @JsonProperty("schedule")
  private String schedule;

  @JsonProperty("startingDeadlineSeconds")
  private Object startingDeadlineSeconds;

  @JsonProperty("stressChaos")
  private ScheduleSpecStressChaos stressChaos;

  @JsonProperty("timeChaos")
  private ScheduleSpecTimeChaos timeChaos;

  /**
   * TODO: use a custom type, as `TemplateType` contains other possible values
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

