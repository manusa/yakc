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
 * OAuthAuthorizeToken describes an OAuth authorization token
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthAuthorizeToken implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * ClientName references the client that created this token.
   */
  @JsonProperty("clientName")
  private String clientName;

  /**
   * CodeChallenge is the optional code_challenge associated with this authorization code, as described in rfc7636
   */
  @JsonProperty("codeChallenge")
  private String codeChallenge;

  /**
   * CodeChallengeMethod is the optional code_challenge_method associated with this authorization code, as described in rfc7636
   */
  @JsonProperty("codeChallengeMethod")
  private String codeChallengeMethod;

  /**
   * ExpiresIn is the seconds from CreationTime before this token expires.
   */
  @JsonProperty("expiresIn")
  private Number expiresIn;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  /**
   * RedirectURI is the redirection associated with the token.
   */
  @JsonProperty("redirectURI")
  private String redirectURI;

  /**
   * Scopes is an array of the requested scopes.
   */
  @JsonProperty("scopes")
  @Singular(value = "addToScopes", ignoreNullCollections = true)
  private List<String> scopes;

  /**
   * State data from request
   */
  @JsonProperty("state")
  private String state;

  /**
   * UserName is the user name associated with this token
   */
  @JsonProperty("userName")
  private String userName;

  /**
   * UserUID is the unique UID associated with this token. UserUID and UserName must both match for this token to be valid.
   */
  @JsonProperty("userUID")
  private String userUID;

}

