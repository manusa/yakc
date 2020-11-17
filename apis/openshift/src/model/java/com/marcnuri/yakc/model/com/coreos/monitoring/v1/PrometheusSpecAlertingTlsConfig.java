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
import lombok.ToString;

/**
 * TLS Config to use for alertmanager connection.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecAlertingTlsConfig implements Model {


  @JsonProperty("ca")
  private PrometheusSpecAlertingTlsConfigCa ca;

  /**
   * Path to the CA cert in the Prometheus container to use for the targets.
   */
  @JsonProperty("caFile")
  private String caFile;

  @JsonProperty("cert")
  private PrometheusSpecAlertingTlsConfigCert cert;

  /**
   * Path to the client cert file in the Prometheus container for the targets.
   */
  @JsonProperty("certFile")
  private String certFile;

  /**
   * Disable target certificate validation.
   */
  @JsonProperty("insecureSkipVerify")
  private Boolean insecureSkipVerify;

  /**
   * Path to the client key file in the Prometheus container for the targets.
   */
  @JsonProperty("keyFile")
  private String keyFile;

  @JsonProperty("keySecret")
  private PrometheusSpecAlertingTlsConfigKeySecret keySecret;

  /**
   * Used to verify the hostname for the targets.
   */
  @JsonProperty("serverName")
  private String serverName;

}

