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
 * Match a specific filter chain in a listener.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EnvoyFilterSpecMatchListenerFilterChain implements Model {


  /**
   * Applies only to sidecars.
   */
  @JsonProperty("applicationProtocols")
  private String applicationProtocols;

  /**
   * The destination_port value used by a filter chain's match condition.
   */
  @JsonProperty("destinationPort")
  private Number destinationPort;

  @JsonProperty("filter")
  private EnvoyFilterSpecMatchListenerFilterChainFilter filter;

  /**
   * The name assigned to the filter chain.
   */
  @JsonProperty("name")
  private String name;

  /**
   * The SNI value used by a filter chain's match condition.
   */
  @JsonProperty("sni")
  private String sni;

  /**
   * Applies only to `SIDECAR_INBOUND` context.
   */
  @JsonProperty("transportProtocol")
  private String transportProtocol;

}

