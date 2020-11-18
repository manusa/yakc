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
 * OAuthAccessToken describes an OAuth access token
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthAccessToken implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * AuthorizeToken contains the token that authorized this token
   */
  @JsonProperty("authorizeToken")
  private String authorizeToken;

  /**
   * ClientName references the client that created this token.
   */
  @JsonProperty("clientName")
  private String clientName;

  /**
   * ExpiresIn is the seconds from CreationTime before this token expires.
   */
  @JsonProperty("expiresIn")
  private Number expiresIn;

  /**
   * InactivityTimeoutSeconds is the value in seconds, from the CreationTimestamp, after which this token can no longer be used. The value is automatically incremented when the token is used.
   */
  @JsonProperty("inactivityTimeoutSeconds")
  private Number inactivityTimeoutSeconds;

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
   * RefreshToken is the value by which this token can be renewed. Can be blank.
   */
  @JsonProperty("refreshToken")
  private String refreshToken;

  /**
   * Scopes is an array of the requested scopes.
   */
  @JsonProperty("scopes")
  @Singular(value = "addToScopes", ignoreNullCollections = true)
  private List<String> scopes;

  /**
   * UserName is the user name associated with this token
   */
  @JsonProperty("userName")
  private String userName;

  /**
   * UserUID is the unique UID associated with this token
   */
  @JsonProperty("userUID")
  private String userUID;

}

