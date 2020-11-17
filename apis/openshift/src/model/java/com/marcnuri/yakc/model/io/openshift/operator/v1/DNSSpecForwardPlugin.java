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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * forwardPlugin defines a schema for configuring CoreDNS to proxy DNS messages to upstream resolvers.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DNSSpecForwardPlugin implements Model {


  /**
   * upstreams is a list of resolvers to forward name queries for subdomains of Zones. Upstreams are randomized when more than 1 upstream is specified. Each instance of CoreDNS performs health checking of Upstreams. When a healthy upstream returns an error during the exchange, another resolver is tried from Upstreams. Each upstream is represented by an IP address or IP:port if the upstream listens on a port other than 53. <br><p>  A maximum of 15 upstreams is allowed per ForwardPlugin.
   */
  @JsonProperty("upstreams")
  @Singular(value = "addToUpstreams", ignoreNullCollections = true)
  private List<String> upstreams;

}

