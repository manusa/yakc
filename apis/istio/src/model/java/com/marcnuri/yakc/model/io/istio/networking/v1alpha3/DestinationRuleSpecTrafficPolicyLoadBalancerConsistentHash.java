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
public class DestinationRuleSpecTrafficPolicyLoadBalancerConsistentHash implements Model {


  @JsonProperty("httpCookie")
  private DestinationRuleSpecTrafficPolicyLoadBalancerConsistentHashHttpCookie httpCookie;

  /**
   * Hash based on a specific HTTP header.
   */
  @JsonProperty("httpHeaderName")
  private String httpHeaderName;

  /**
   * Hash based on a specific HTTP query parameter.
   */
  @JsonProperty("httpQueryParameterName")
  private String httpQueryParameterName;

  @JsonProperty("minimumRingSize")
  private Number minimumRingSize;

  /**
   * Hash based on the source IP address.
   */
  @JsonProperty("useSourceIp")
  private Boolean useSourceIp;

}

