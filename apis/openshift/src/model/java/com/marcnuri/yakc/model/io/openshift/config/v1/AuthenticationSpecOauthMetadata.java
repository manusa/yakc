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
import lombok.NonNull;
import lombok.ToString;

/**
 * oauthMetadata contains the discovery endpoint data for OAuth 2.0 Authorization Server Metadata for an external OAuth server. This discovery document can be viewed from its served location: oc get --raw '/.well-known/oauth-authorization-server' For further details, see the IETF Draft: https://tools.ietf.org/html/draft-ietf-oauth-discovery-04#section-2 If oauthMetadata.name is non-empty, this value has precedence over any metadata reference stored in status. The key "oauthMetadata" is used to locate the data. If specified and the config map or expected key is not found, no metadata is served. If the specified metadata is not valid, no metadata is served. The namespace for this config map is openshift-config.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthenticationSpecOauthMetadata implements Model {


  /**
   * name is the metadata.name of the referenced config map
   */
  @NonNull
  @JsonProperty("name")
  private String name;

}

