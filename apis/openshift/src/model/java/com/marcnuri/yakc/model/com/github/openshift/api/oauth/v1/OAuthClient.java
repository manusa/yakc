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

package com.marcnuri.yakc.model.com.github.openshift.api.oauth.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * OAuthClient describes an OAuth client
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthClient implements Model {


  /**
   * AccessTokenInactivityTimeoutSeconds overrides the default token inactivity timeout for tokens granted to this client. The value represents the maximum amount of time that can occur between consecutive uses of the token. Tokens become invalid if they are not used within this temporal window. The user will need to acquire a new token to regain access once a token times out. This value needs to be set only if the default set in configuration is not appropriate for this client. Valid values are: - 0: Tokens for this client never time out - X: Tokens time out if there is no activity for X seconds The current minimum allowed value for X is 300 (5 minutes)
   */
  @JsonProperty("accessTokenInactivityTimeoutSeconds")
  private Number accessTokenInactivityTimeoutSeconds;

  /**
   * AccessTokenMaxAgeSeconds overrides the default access token max age for tokens granted to this client. 0 means no expiration.
   */
  @JsonProperty("accessTokenMaxAgeSeconds")
  private Number accessTokenMaxAgeSeconds;

  /**
   * AdditionalSecrets holds other secrets that may be used to identify the client.  This is useful for rotation and for service account token validation
   */
  @JsonProperty("additionalSecrets")
  @Singular(value = "addToAdditionalSecrets", ignoreNullCollections = true)
  private List<String> additionalSecrets;

  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * GrantMethod is a required field which determines how to handle grants for this client. Valid grant handling methods are:<br><p>  - auto:   always approves grant requests, useful for trusted clients<br><p>  - prompt: prompts the end user for approval of grant requests, useful for third-party clients
   */
  @JsonProperty("grantMethod")
  private String grantMethod;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  /**
   * RedirectURIs is the valid redirection URIs associated with a client
   */
  @JsonProperty("redirectURIs")
  @Singular(value = "addToRedirectURIs", ignoreNullCollections = true)
  private List<String> redirectURIs;

  /**
   * RespondWithChallenges indicates whether the client wants authentication needed responses made in the form of challenges instead of redirects
   */
  @JsonProperty("respondWithChallenges")
  private Boolean respondWithChallenges;

  /**
   * ScopeRestrictions describes which scopes this client can request.  Each requested scope is checked against each restriction.  If any restriction matches, then the scope is allowed. If no restriction matches, then the scope is denied.
   */
  @JsonProperty("scopeRestrictions")
  @Singular(value = "addToScopeRestrictions", ignoreNullCollections = true)
  private List<ScopeRestriction> scopeRestrictions;

  /**
   * Secret is the unique secret associated with a client
   */
  @JsonProperty("secret")
  private String secret;

}

