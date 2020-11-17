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
 * tokenConfig contains options for authorization and access tokens
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthSpecTokenConfig implements Model {


  /**
   * accessTokenInactivityTimeoutSeconds defines the default token inactivity timeout for tokens granted by any client. The value represents the maximum amount of time that can occur between consecutive uses of the token. Tokens become invalid if they are not used within this temporal window. The user will need to acquire a new token to regain access once a token times out. Valid values are integer values:   x &lt; 0  Tokens time out is enabled but tokens never timeout unless configured per client (e.g. `-1`)   x = 0  Tokens time out is disabled (default)   x &gt; 0  Tokens time out if there is no activity for x seconds The current minimum allowed value for X is 300 (5 minutes)
   */
  @JsonProperty("accessTokenInactivityTimeoutSeconds")
  private Number accessTokenInactivityTimeoutSeconds;

  /**
   * accessTokenMaxAgeSeconds defines the maximum age of access tokens
   */
  @JsonProperty("accessTokenMaxAgeSeconds")
  private Number accessTokenMaxAgeSeconds;

}

