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
 * ControllerConfigStatusCondition contains condition information for ControllerConfigStatus
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ControllerConfigStatusConditions implements Model {


  /**
   * lastTransitionTime is the time of the last update to the current status object.
   */
  @JsonProperty("lastTransitionTime")
  private Object lastTransitionTime;

  /**
   * message provides additional information about the current condition. This is only to be consumed by humans.
   */
  @JsonProperty("message")
  private String message;

  /**
   * reason is the reason for the condition's last transition.  Reasons are PascalCase
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * status of the condition, one of True, False, Unknown.
   */
  @JsonProperty("status")
  private String status;

  /**
   * type specifies the state of the operator's reconciliation functionality.
   */
  @JsonProperty("type")
  private String type;

}

