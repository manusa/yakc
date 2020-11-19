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

package com.marcnuri.yakc.model.io.istio.security.v1beta1;

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
public class RequestAuthenticationSpecJwtRules implements Model {


  @JsonProperty("audiences")
  @Singular(value = "addToAudiences", ignoreNullCollections = true)
  private List<String> audiences;

  /**
   * If set to true, the orginal token will be kept for the ustream request.
   */
  @JsonProperty("forwardOriginalToken")
  private Boolean forwardOriginalToken;

  /**
   * List of header locations from which JWT is expected.
   */
  @JsonProperty("fromHeaders")
  @Singular(value = "addToFromHeaders", ignoreNullCollections = true)
  private List<RequestAuthenticationSpecFromHeaders> fromHeaders;

  /**
   * List of query parameters from which JWT is expected.
   */
  @JsonProperty("fromParams")
  @Singular(value = "addToFromParams", ignoreNullCollections = true)
  private List<String> fromParams;

  /**
   * Identifies the issuer that issued the JWT.
   */
  @JsonProperty("issuer")
  private String issuer;

  /**
   * JSON Web Key Set of public keys to validate signature of the JWT.
   */
  @JsonProperty("jwks")
  private String jwks;

  @JsonProperty("jwksUri")
  private String jwksUri;

  @JsonProperty("jwks_uri")
  private String jwks_uri;

  @JsonProperty("outputPayloadToHeader")
  private String outputPayloadToHeader;

}

