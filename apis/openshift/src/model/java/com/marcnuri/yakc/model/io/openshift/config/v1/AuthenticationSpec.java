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
 * spec holds user settable values for configuration
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthenticationSpec implements Model {


  @JsonProperty("oauthMetadata")
  private AuthenticationSpecOauthMetadata oauthMetadata;

  /**
   * serviceAccountIssuer is the identifier of the bound service account token issuer. The default is auth.openshift.io.
   */
  @JsonProperty("serviceAccountIssuer")
  private String serviceAccountIssuer;

  /**
   * type identifies the cluster managed, user facing authentication mode in use. Specifically, it manages the component that responds to login attempts. The default is IntegratedOAuth.
   */
  @JsonProperty("type")
  private String type;

  /**
   * webhookTokenAuthenticators configures remote token reviewers. These remote authentication webhooks can be used to verify bearer tokens via the tokenreviews.authentication.k8s.io REST API.  This is required to honor bearer tokens that are provisioned by an external authentication service. The namespace for these secrets is openshift-config.
   */
  @JsonProperty("webhookTokenAuthenticators")
  @Singular(value = "addToWebhookTokenAuthenticators", ignoreNullCollections = true)
  private List<AuthenticationSpecWebhookTokenAuthenticators> webhookTokenAuthenticators;

}

