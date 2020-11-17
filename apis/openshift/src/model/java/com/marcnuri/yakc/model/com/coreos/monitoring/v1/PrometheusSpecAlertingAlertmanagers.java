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
 * AlertmanagerEndpoints defines a selection of a single Endpoints object containing alertmanager IPs to fire alerts against.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecAlertingAlertmanagers implements Model {


  /**
   * Version of the Alertmanager API that Prometheus uses to send alerts. It can be "v1" or "v2".
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * BearerTokenFile to read from filesystem to use when authenticating to Alertmanager.
   */
  @JsonProperty("bearerTokenFile")
  private String bearerTokenFile;

  /**
   * Name of Endpoints object in Namespace.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Namespace of Endpoints object.
   */
  @NonNull
  @JsonProperty("namespace")
  private String namespace;

  /**
   * Prefix for the HTTP path alerts are pushed to.
   */
  @JsonProperty("pathPrefix")
  private String pathPrefix;

  /**
   * Port the Alertmanager API is exposed on.
   */
  @NonNull
  @JsonProperty("port")
  private Object port;

  /**
   * Scheme to use when firing alerts.
   */
  @JsonProperty("scheme")
  private String scheme;

  @JsonProperty("tlsConfig")
  private PrometheusSpecAlertingTlsConfig tlsConfig;

}

