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

package com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * MachineConfigPoolCondition contains condition information for an MachineConfigPool.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MachineConfigPoolStatusConditions implements Model {


  /**
   * lastTransitionTime is the timestamp corresponding to the last status change of this condition.
   */
  @JsonProperty("lastTransitionTime")
  private Object lastTransitionTime;

  /**
   * message is a human readable description of the details of the last transition, complementing reason.
   */
  @JsonProperty("message")
  private String message;

  /**
   * reason is a brief machine readable explanation for the condition's last transition.
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * status of the condition, one of ('True', 'False', 'Unknown').
   */
  @JsonProperty("status")
  private String status;

  /**
   * type of the condition, currently ('Done', 'Updating', 'Failed').
   */
  @JsonProperty("type")
  private String type;

}

