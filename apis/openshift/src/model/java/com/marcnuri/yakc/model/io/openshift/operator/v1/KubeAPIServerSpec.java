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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * spec is the specification of the desired behavior of the Kubernetes API Server
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class KubeAPIServerSpec implements Model {


  /**
   * failedRevisionLimit is the number of failed static pod installer revisions to keep on disk and in the api -1 = unlimited, 0 or unset = 5 (default)
   */
  @JsonProperty("failedRevisionLimit")
  private Number failedRevisionLimit;

  /**
   * forceRedeploymentReason can be used to force the redeployment of the operand by providing a unique string. This provides a mechanism to kick a previously failed deployment and provide a reason why you think it will work this time instead of failing again on the same config.
   */
  @JsonProperty("forceRedeploymentReason")
  private String forceRedeploymentReason;

  /**
   * logLevel is an intent based logging for an overall component.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for their operands.
   */
  @JsonProperty("logLevel")
  private String logLevel;

  /**
   * managementState indicates whether and how the operator should manage the component
   */
  @JsonProperty("managementState")
  private String managementState;

  /**
   * observedConfig holds a sparse config that controller has observed from the cluster state.  It exists in spec because it is an input to the level for the operator
   */
  @JsonProperty("observedConfig")
  private Object observedConfig;

  /**
   * operatorLogLevel is an intent based logging for the operator itself.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for themselves.
   */
  @JsonProperty("operatorLogLevel")
  private String operatorLogLevel;

  /**
   * succeededRevisionLimit is the number of successful static pod installer revisions to keep on disk and in the api -1 = unlimited, 0 or unset = 5 (default)
   */
  @JsonProperty("succeededRevisionLimit")
  private Number succeededRevisionLimit;

  /**
   * unsupportedConfigOverrides holds a sparse config that will override any previously set options.  It only needs to be the fields to override it will end up overlaying in the following order: 1. hardcoded defaults 2. observedConfig 3. unsupportedConfigOverrides
   */
  @JsonProperty("unsupportedConfigOverrides")
  private Object unsupportedConfigOverrides;

}

