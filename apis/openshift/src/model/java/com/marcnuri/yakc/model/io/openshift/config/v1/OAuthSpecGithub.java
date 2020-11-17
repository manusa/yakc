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
 * github enables user authentication using GitHub credentials
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OAuthSpecGithub implements Model {


  @JsonProperty("ca")
  private OAuthSpecGithubCa ca;

  /**
   * clientID is the oauth client ID
   */
  @JsonProperty("clientID")
  private String clientID;

  @JsonProperty("clientSecret")
  private OAuthSpecGithubClientSecret clientSecret;

  /**
   * hostname is the optional domain (e.g. "mycompany.com") for use with a hosted instance of GitHub Enterprise. It must match the GitHub Enterprise settings value configured at /setup/settings#hostname.
   */
  @JsonProperty("hostname")
  private String hostname;

  /**
   * organizations optionally restricts which organizations are allowed to log in
   */
  @JsonProperty("organizations")
  @Singular(value = "addToOrganizations", ignoreNullCollections = true)
  private List<String> organizations;

  /**
   * teams optionally restricts which teams are allowed to log in. Format is &lt;org&gt;/&lt;team&gt;.
   */
  @JsonProperty("teams")
  @Singular(value = "addToTeams", ignoreNullCollections = true)
  private List<String> teams;

}

