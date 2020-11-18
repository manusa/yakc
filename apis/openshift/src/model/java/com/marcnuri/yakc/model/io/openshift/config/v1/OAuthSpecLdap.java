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
 * ldap enables user authentication using LDAP credentials
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthSpecLdap implements Model {


  @JsonProperty("attributes")
  private OAuthSpecLdapAttributes attributes;

  /**
   * bindDN is an optional DN to bind with during the search phase.
   */
  @JsonProperty("bindDN")
  private String bindDN;

  @JsonProperty("bindPassword")
  private OAuthSpecLdapBindPassword bindPassword;

  @JsonProperty("ca")
  private OAuthSpecBasicAuthCa ca;

  /**
   * insecure, if true, indicates the connection should not use TLS WARNING: Should not be set to `true` with the URL scheme "ldaps://" as "ldaps://" URLs always          attempt to connect using TLS, even when `insecure` is set to `true` When `true`, "ldap://" URLS connect insecurely. When `false`, "ldap://" URLs are upgraded to a TLS connection using StartTLS as specified in https://tools.ietf.org/html/rfc2830.
   */
  @JsonProperty("insecure")
  private Boolean insecure;

  /**
   * url is an RFC 2255 URL which specifies the LDAP search parameters to use. The syntax of the URL is: ldap://host:port/basedn?attribute?scope?filter
   */
  @JsonProperty("url")
  private String url;

}

