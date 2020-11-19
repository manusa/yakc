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

package com.marcnuri.yakc.model.dev.knative.flows.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class ParallelStatusConditions implements Model {


  /**
   * A human readable message indicating details about the transition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * The reason for the condition's last transition.
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * Severity with which to treat failures of this type of condition. When this is not specified, it defaults to Error.
   */
  @JsonProperty("severity")
  private String severity;

  /**
   * Status of the condition, one of True, False, Unknown.
   */
  @JsonProperty("status")
  private String status;

  /**
   * Type of condition.
   */
  @JsonProperty("type")
  private String type;

}

