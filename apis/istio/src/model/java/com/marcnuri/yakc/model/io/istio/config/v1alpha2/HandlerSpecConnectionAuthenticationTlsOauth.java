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

package com.marcnuri.yakc.model.io.istio.config.v1alpha2;

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
 * Oauth config to fetch access token from auth provider.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HandlerSpecConnectionAuthenticationTlsOauth implements Model {


  /**
   * OAuth client id for mixer.
   */
  @JsonProperty("clientId")
  private String clientId;

  /**
   * The path to the file holding the client secret for oauth.
   */
  @JsonProperty("clientSecret")
  private String clientSecret;

  /**
   * Additional parameters for requests to the token endpoint.
   */
  @JsonProperty("endpointParams")
  @Singular(value = "putInEndpointParams", ignoreNullCollections = true)
  private Map<String, String> endpointParams;

  /**
   * List of requested permissions.
   */
  @JsonProperty("scopes")
  @Singular(value = "addToScopes", ignoreNullCollections = true)
  private List<String> scopes;

  /**
   * The Resource server's token endpoint URL.
   */
  @JsonProperty("tokenUrl")
  private String tokenUrl;

}

