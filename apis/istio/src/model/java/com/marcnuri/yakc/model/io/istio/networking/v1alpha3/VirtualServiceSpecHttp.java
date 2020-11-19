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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
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
public class VirtualServiceSpecHttp implements Model {


  @JsonProperty("corsPolicy")
  private VirtualServiceSpecCorsPolicy corsPolicy;

  @JsonProperty("delegate")
  private VirtualServiceSpecDelegate delegate;

  @JsonProperty("fault")
  private VirtualServiceSpecFault fault;

  @JsonProperty("headers")
  private VirtualServiceSpecHeaders headers;

  @JsonProperty("match")
  @Singular(value = "addToMatch", ignoreNullCollections = true)
  private List<VirtualServiceSpecMatch> match;

  @JsonProperty("mirror")
  private SidecarSpecOutboundTrafficPolicyEgressProxy mirror;

  /**
   * Percentage of the traffic to be mirrored by the `mirror` field.
   */
  @JsonProperty("mirrorPercent")
  private Object mirrorPercent;

  @JsonProperty("mirrorPercentage")
  private VirtualServiceSpecMirrorPercentage mirrorPercentage;

  /**
   * Percentage of the traffic to be mirrored by the `mirror` field.
   */
  @JsonProperty("mirror_percent")
  private Object mirror_percent;

  /**
   * The name assigned to the route for debugging purposes.
   */
  @JsonProperty("name")
  private String name;

  @JsonProperty("redirect")
  private VirtualServiceSpecRedirect redirect;

  @JsonProperty("retries")
  private VirtualServiceSpecRetries retries;

  @JsonProperty("rewrite")
  private VirtualServiceSpecRewrite rewrite;

  /**
   * A HTTP rule can either redirect or forward (default) traffic.
   */
  @JsonProperty("route")
  @Singular(value = "addToRoute", ignoreNullCollections = true)
  private List<VirtualServiceSpecRoute> route;

  /**
   * Timeout for HTTP requests, default is disabled.
   */
  @JsonProperty("timeout")
  private String timeout;

}

