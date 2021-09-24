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

package com.marcnuri.yakc.model.io.istio.networking.v1alpha3;

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
public class DestinationRuleSpecTrafficPolicyOutlierDetection implements Model {


  /**
   * Minimum ejection duration.
   */
  @JsonProperty("baseEjectionTime")
  private String baseEjectionTime;

  /**
   * Number of 5xx errors before a host is ejected from the connection pool.
   */
  @JsonProperty("consecutive5xxErrors")
  private Object consecutive5xxErrors;

  @JsonProperty("consecutiveErrors")
  private Number consecutiveErrors;

  /**
   * Number of gateway errors before a host is ejected from the connection pool.
   */
  @JsonProperty("consecutiveGatewayErrors")
  private Object consecutiveGatewayErrors;

  @JsonProperty("consecutiveLocalOriginFailures")
  private Object consecutiveLocalOriginFailures;

  /**
   * Time interval between ejection sweep analysis.
   */
  @JsonProperty("interval")
  private String interval;

  @JsonProperty("maxEjectionPercent")
  private Number maxEjectionPercent;

  @JsonProperty("minHealthPercent")
  private Number minHealthPercent;

  /**
   * Determines whether to distinguish local origin failures from external errors.
   */
  @JsonProperty("splitExternalLocalOriginErrors")
  private Boolean splitExternalLocalOriginErrors;

}

