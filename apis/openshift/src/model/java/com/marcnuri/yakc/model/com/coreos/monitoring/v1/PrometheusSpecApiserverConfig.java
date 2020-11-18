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

package com.marcnuri.yakc.model.com.coreos.monitoring.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * APIServerConfig allows specifying a host and auth methods to access apiserver. If left empty, Prometheus is assumed to run inside of the cluster and will discover API servers automatically and use the pod's CA certificate and bearer token file at /var/run/secrets/kubernetes.io/serviceaccount/.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecApiserverConfig implements Model {


  @JsonProperty("basicAuth")
  private PrometheusSpecApiserverConfigBasicAuth basicAuth;

  /**
   * Bearer token for accessing apiserver.
   */
  @JsonProperty("bearerToken")
  private String bearerToken;

  /**
   * File to read bearer token for accessing apiserver.
   */
  @JsonProperty("bearerTokenFile")
  private String bearerTokenFile;

  /**
   * Host of apiserver. A valid string consisting of a hostname or IP followed by an optional port number
   */
  @NonNull
  @JsonProperty("host")
  private String host;

  @JsonProperty("tlsConfig")
  private PrometheusSpecApiserverConfigTlsConfig tlsConfig;

}

