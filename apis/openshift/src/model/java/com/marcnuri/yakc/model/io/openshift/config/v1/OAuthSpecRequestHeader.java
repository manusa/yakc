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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * requestHeader enables user authentication using request header credentials
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthSpecRequestHeader implements Model {


  @JsonProperty("ca")
  private OAuthSpecRequestHeaderCa ca;

  /**
   * challengeURL is a URL to redirect unauthenticated /authorize requests to Unauthenticated requests from OAuth clients which expect WWW-Authenticate challenges will be redirected here. ${url} is replaced with the current URL, escaped to be safe in a query parameter   https://www.example.com/sso-login?then=${url} ${query} is replaced with the current query string   https://www.example.com/auth-proxy/oauth/authorize?${query} Required when challenge is set to true.
   */
  @JsonProperty("challengeURL")
  private String challengeURL;

  /**
   * clientCommonNames is an optional list of common names to require a match from. If empty, any client certificate validated against the clientCA bundle is considered authoritative.
   */
  @JsonProperty("clientCommonNames")
  @Singular(value = "addToClientCommonNames", ignoreNullCollections = true)
  private List<String> clientCommonNames;

  /**
   * emailHeaders is the set of headers to check for the email address
   */
  @JsonProperty("emailHeaders")
  @Singular(value = "addToEmailHeaders", ignoreNullCollections = true)
  private List<String> emailHeaders;

  /**
   * headers is the set of headers to check for identity information
   */
  @JsonProperty("headers")
  @Singular(value = "addToHeaders", ignoreNullCollections = true)
  private List<String> headers;

  /**
   * loginURL is a URL to redirect unauthenticated /authorize requests to Unauthenticated requests from OAuth clients which expect interactive logins will be redirected here ${url} is replaced with the current URL, escaped to be safe in a query parameter   https://www.example.com/sso-login?then=${url} ${query} is replaced with the current query string   https://www.example.com/auth-proxy/oauth/authorize?${query} Required when login is set to true.
   */
  @JsonProperty("loginURL")
  private String loginURL;

  /**
   * nameHeaders is the set of headers to check for the display name
   */
  @JsonProperty("nameHeaders")
  @Singular(value = "addToNameHeaders", ignoreNullCollections = true)
  private List<String> nameHeaders;

  /**
   * preferredUsernameHeaders is the set of headers to check for the preferred username
   */
  @JsonProperty("preferredUsernameHeaders")
  @Singular(value = "addToPreferredUsernameHeaders", ignoreNullCollections = true)
  private List<String> preferredUsernameHeaders;

}

