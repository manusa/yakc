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
 * HTTP connection pool settings.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DestinationRuleSpecTrafficPolicyConnectionPoolHttp implements Model {


  /**
   * Specify if http1.1 connection should be upgraded to http2 for the associated destination.
   */
  @JsonProperty("h2UpgradePolicy")
  private String h2UpgradePolicy;

  /**
   * Maximum number of pending HTTP requests to a destination.
   */
  @JsonProperty("http1MaxPendingRequests")
  private Number http1MaxPendingRequests;

  /**
   * Maximum number of requests to a backend.
   */
  @JsonProperty("http2MaxRequests")
  private Number http2MaxRequests;

  /**
   * The idle timeout for upstream connection pool connections.
   */
  @JsonProperty("idleTimeout")
  private String idleTimeout;

  /**
   * Maximum number of requests per connection to a backend.
   */
  @JsonProperty("maxRequestsPerConnection")
  private Number maxRequestsPerConnection;

  @JsonProperty("maxRetries")
  private Number maxRetries;

}

