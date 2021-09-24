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
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleSpecWorkflowTemplates implements Model {


  @JsonProperty("awsChaos")
  private AWSChaosSpec awsChaos;

  /**
   * Children describes the children steps of serial or parallel node. Only used when Type is TypeSerial or TypeParallel.
   */
  @JsonProperty("children")
  @Singular(value = "addToChildren", ignoreNullCollections = true)
  private List<String> children;

  /**
   * ConditionalBranches describes the conditional branches of custom tasks. Only used when Type is TypeTask.
   */
  @JsonProperty("conditionalBranches")
  @Singular(value = "addToConditionalBranches", ignoreNullCollections = true)
  private List<ScheduleSpecWorkflowConditionalBranches> conditionalBranches;

  @JsonProperty("deadline")
  private String deadline;

  @JsonProperty("dnsChaos")
  private ScheduleSpecDnsChaos dnsChaos;

  @JsonProperty("gcpChaos")
  private GCPChaosSpec gcpChaos;

  @JsonProperty("httpChaos")
  private HTTPChaosSpec httpChaos;

  @JsonProperty("ioChaos")
  private IOChaosSpec ioChaos;

  @JsonProperty("jvmChaos")
  private JVMChaosSpec jvmChaos;

  @JsonProperty("kernelChaos")
  private ScheduleSpecKernelChaos kernelChaos;

  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("networkChaos")
  private ScheduleSpecNetworkChaos networkChaos;

  @JsonProperty("podChaos")
  private ScheduleSpecPodChaos podChaos;

  @JsonProperty("schedule")
  private ScheduleSpecWorkflowSchedule schedule;

  @JsonProperty("stressChaos")
  private ScheduleSpecStressChaos stressChaos;

  @JsonProperty("task")
  private ScheduleSpecWorkflowTask task;

  @NonNull
  @JsonProperty("templateType")
  private String templateType;

  @JsonProperty("timeChaos")
  private ScheduleSpecTimeChaos timeChaos;

}
