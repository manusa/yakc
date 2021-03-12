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

package com.marcnuri.yakc.model.dev.kudo.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * There are two ways a plan execution can be triggered:  1) indirectly through update of a corresponding parameter in the InstanceSpec.Parameters map  2) directly through setting of the InstanceSpec.PlanExecution.PlanName field While indirect (1) triggers happens every time a user changes a parameter, a directly (2) triggered plan is reserved for the situations when parameters doesn't change e.g. a periodic backup is triggered overriding the existing backup file. Additionally, this opens room for canceling and overriding currently running plans in the future. Note: PlanExecution field defines plan name and corresponding parameters that IS CURRENTLY executed. Once the instance controller (IC) is done with the execution, this field will be cleared. Each plan execution has a unique UID so should the same plan be re-triggered it will have a new UID
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InstanceSpecPlanExecution implements Model {


  @JsonProperty("planName")
  private String planName;

  /**
   * ExecutionStatus captures the state of the rollout.
   */
  @JsonProperty("status")
  private String status;

  /**
   * UID is a type that holds unique ID values, including UUIDs.  Because we don't ONLY use UUIDs, this is an alias to string.  Being a type captures intent and helps make sure that UIDs and names do not get conflated.
   */
  @JsonProperty("uid")
  private String uid;

}

