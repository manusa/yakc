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

package com.marcnuri.yakc.model.io.openshift.config.v1;

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
 * openID enables user authentication using OpenID credentials
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthSpecOpenID implements Model {


  @JsonProperty("ca")
  private OAuthSpecBasicAuthCa ca;

  @JsonProperty("claims")
  private OAuthSpecOpenIDClaims claims;

  /**
   * clientID is the oauth client ID
   */
  @JsonProperty("clientID")
  private String clientID;

  @JsonProperty("clientSecret")
  private OAuthSpecGithubClientSecret clientSecret;

  /**
   * extraAuthorizeParameters are any custom parameters to add to the authorize request.
   */
  @JsonProperty("extraAuthorizeParameters")
  @Singular(value = "putInExtraAuthorizeParameters", ignoreNullCollections = true)
  private Map<String, String> extraAuthorizeParameters;

  /**
   * extraScopes are any scopes to request in addition to the standard "openid" scope.
   */
  @JsonProperty("extraScopes")
  @Singular(value = "addToExtraScopes", ignoreNullCollections = true)
  private List<String> extraScopes;

  /**
   * issuer is the URL that the OpenID Provider asserts as its Issuer Identifier. It must use the https scheme with no query or fragment component.
   */
  @JsonProperty("issuer")
  private String issuer;

}

