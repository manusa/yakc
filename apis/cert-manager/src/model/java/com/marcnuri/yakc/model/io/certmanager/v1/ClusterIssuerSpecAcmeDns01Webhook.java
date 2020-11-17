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

package com.marcnuri.yakc.model.io.certmanager.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Configure an external webhook based DNS01 challenge solver to manage DNS01 challenge records.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeDns01Webhook implements Model {


  /**
   * Additional configuration that should be passed to the webhook apiserver when challenges are processed. This can contain arbitrary JSON data. Secret values should not be specified in this stanza. If secret values are needed (e.g. credentials for a DNS service), you should use a SecretKeySelector to reference a Secret resource. For details on the schema of this field, consult the webhook provider implementation's documentation.
   */
  @JsonProperty("config")
  private Object config;

  /**
   * The API group name that should be used when POSTing ChallengePayload resources to the webhook apiserver. This should be the same as the GroupName specified in the webhook provider implementation.
   */
  @NonNull
  @JsonProperty("groupName")
  private String groupName;

  /**
   * The name of the solver to use, as defined in the webhook provider implementation. This will typically be the name of the provider, e.g. 'cloudflare'.
   */
  @NonNull
  @JsonProperty("solverName")
  private String solverName;

}

