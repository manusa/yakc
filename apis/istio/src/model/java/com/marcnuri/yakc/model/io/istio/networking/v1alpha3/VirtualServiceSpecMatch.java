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
import java.util.Map;
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
public class VirtualServiceSpecMatch implements Model {


  @JsonProperty("authority")
  private VirtualServiceSpecCorsPolicyAllowOrigins authority;

  /**
   * Names of gateways where the rule should be applied.
   */
  @JsonProperty("gateways")
  @Singular(value = "addToGateways", ignoreNullCollections = true)
  private List<String> gateways;

  @JsonProperty("headers")
  @Singular(value = "putInHeaders", ignoreNullCollections = true)
  private Map<String, VirtualServiceSpecCorsPolicyAllowOrigins> headers;

  /**
   * Flag to specify whether the URI matching should be case-insensitive.
   */
  @JsonProperty("ignoreUriCase")
  private Boolean ignoreUriCase;

  @JsonProperty("method")
  private VirtualServiceSpecCorsPolicyAllowOrigins method;

  /**
   * The name assigned to a match.
   */
  @JsonProperty("name")
  private String name;

  /**
   * Specifies the ports on the host that is being addressed.
   */
  @JsonProperty("port")
  private Number port;

  /**
   * Query parameters for matching.
   */
  @JsonProperty("queryParams")
  @Singular(value = "putInQueryParams", ignoreNullCollections = true)
  private Map<String, VirtualServiceSpecCorsPolicyAllowOrigins> queryParams;

  @JsonProperty("scheme")
  private VirtualServiceSpecCorsPolicyAllowOrigins scheme;

  @JsonProperty("sourceLabels")
  @Singular(value = "putInSourceLabels", ignoreNullCollections = true)
  private Map<String, String> sourceLabels;

  /**
   * Source namespace constraining the applicability of a rule to workloads in that namespace.
   */
  @JsonProperty("sourceNamespace")
  private String sourceNamespace;

  @JsonProperty("uri")
  private VirtualServiceSpecCorsPolicyAllowOrigins uri;

  /**
   * withoutHeader has the same syntax with the header, but has opposite meaning.
   */
  @JsonProperty("withoutHeaders")
  @Singular(value = "putInWithoutHeaders", ignoreNullCollections = true)
  private Map<String, VirtualServiceSpecCorsPolicyAllowOrigins> withoutHeaders;

}

