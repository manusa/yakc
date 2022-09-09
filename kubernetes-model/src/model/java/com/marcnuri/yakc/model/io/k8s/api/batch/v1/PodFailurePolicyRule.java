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

package com.marcnuri.yakc.model.io.k8s.api.batch.v1;

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
 * PodFailurePolicyRule describes how a pod failure is handled when the requirements are met. One of OnExitCodes and onPodConditions, but not both, can be used in each rule.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodFailurePolicyRule implements Model {


  /**
   * Specifies the action taken on a pod failure when the requirements are satisfied. Possible values are: - FailJob: indicates that the pod's job is marked as Failed and all<br><p>   running pods are terminated.<br><p> - Ignore: indicates that the counter towards the .backoffLimit is not<br><p>   incremented and a replacement pod is created.<br><p> - Count: indicates that the pod is handled in the default way - the<br><p>   counter towards the .backoffLimit is incremented.<br><p> Additional values are considered to be added in the future. Clients should react to an unknown action by skipping the rule.<br><p> <br><p> 
   */
  @NonNull
  @JsonProperty("action")
  private String action;

  @JsonProperty("onExitCodes")
  private PodFailurePolicyOnExitCodesRequirement onExitCodes;

  /**
   * Represents the requirement on the pod conditions. The requirement is represented as a list of pod condition patterns. The requirement is satisfied if at least one pattern matches an actual pod condition. At most 20 elements are allowed.
   */
  @NonNull
  @JsonProperty("onPodConditions")
  @Singular(value = "addToOnPodConditions", ignoreNullCollections = true)
  private List<PodFailurePolicyOnPodConditionsPattern> onPodConditions;

}

