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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * IdentityProvider provides identities for users authenticating using credentials
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthSpecIdentityProviders implements Model {


  @JsonProperty("basicAuth")
  private OAuthSpecBasicAuth basicAuth;

  @JsonProperty("github")
  private OAuthSpecGithub github;

  @JsonProperty("gitlab")
  private OAuthSpecGitlab gitlab;

  @JsonProperty("google")
  private OAuthSpecGoogle google;

  @JsonProperty("htpasswd")
  private OAuthSpecHtpasswd htpasswd;

  @JsonProperty("keystone")
  private OAuthSpecKeystone keystone;

  @JsonProperty("ldap")
  private OAuthSpecLdap ldap;

  /**
   * mappingMethod determines how identities from this provider are mapped to users Defaults to "claim"
   */
  @JsonProperty("mappingMethod")
  private String mappingMethod;

  /**
   * name is used to qualify the identities returned by this provider. - It MUST be unique and not shared by any other identity provider used - It MUST be a valid path segment: name cannot equal "." or ".." or contain "/" or "%" or ":"   Ref: https://godoc.org/github.com/openshift/origin/pkg/user/apis/user/validation#ValidateIdentityProviderName
   */
  @JsonProperty("name")
  private String name;

  @JsonProperty("openID")
  private OAuthSpecOpenID openID;

  @JsonProperty("requestHeader")
  private OAuthSpecRequestHeader requestHeader;

  /**
   * type identifies the identity provider type for this entry.
   */
  @JsonProperty("type")
  private String type;

}

