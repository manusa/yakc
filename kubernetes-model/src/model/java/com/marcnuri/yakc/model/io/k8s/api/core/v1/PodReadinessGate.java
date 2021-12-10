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

package com.marcnuri.yakc.model.io.k8s.api.core.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * PodReadinessGate contains the reference to a pod condition
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodReadinessGate implements Model {


  /**
   * ConditionType refers to a condition in the pod's condition list with matching type.<br><p> <br><p> Possible enum values:<br><p>  - `"ContainersReady"` indicates whether all containers in the pod are ready.<br><p>  - `"Initialized"` means that all init containers in the pod have started successfully.<br><p>  - `"PodScheduled"` represents status of the scheduling process for this pod.<br><p>  - `"Ready"` means the pod is able to service requests and should be added to the load balancing pools of all matching services.
   */
  @NonNull
  @JsonProperty("conditionType")
  private String conditionType;

}

