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
 * Configuration affecting label/content routing, sni routing, etc. See more details at: https://istio.io/docs/reference/config/networking/virtual-service.html
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VirtualServiceSpec implements Model {


  /**
   * A list of namespaces to which this virtual service is exported.
   */
  @JsonProperty("exportTo")
  @Singular(value = "addToExportTo", ignoreNullCollections = true)
  private List<String> exportTo;

  /**
   * The names of gateways and sidecars that should apply these routes.
   */
  @JsonProperty("gateways")
  @Singular(value = "addToGateways", ignoreNullCollections = true)
  private List<String> gateways;

  /**
   * The destination hosts to which traffic is being sent.
   */
  @JsonProperty("hosts")
  @Singular(value = "addToHosts", ignoreNullCollections = true)
  private List<String> hosts;

  /**
   * An ordered list of route rules for HTTP traffic.
   */
  @JsonProperty("http")
  @Singular(value = "addToHttp", ignoreNullCollections = true)
  private List<VirtualServiceSpecHttp> http;

  /**
   * An ordered list of route rules for opaque TCP traffic.
   */
  @JsonProperty("tcp")
  @Singular(value = "addToTcp", ignoreNullCollections = true)
  private List<VirtualServiceSpecTcp> tcp;

  @JsonProperty("tls")
  @Singular(value = "addToTls", ignoreNullCollections = true)
  private List<VirtualServiceSpecTls> tls;

}

