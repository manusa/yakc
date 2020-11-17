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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * RemoteWriteSpec defines the remote_write configuration for prometheus.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecRemoteWrite implements Model {


  @JsonProperty("basicAuth")
  private PrometheusSpecBasicAuth basicAuth;

  /**
   * File to read bearer token for remote write.
   */
  @JsonProperty("bearerToken")
  private String bearerToken;

  /**
   * File to read bearer token for remote write.
   */
  @JsonProperty("bearerTokenFile")
  private String bearerTokenFile;

  /**
   * Optional ProxyURL
   */
  @JsonProperty("proxyUrl")
  private String proxyUrl;

  @JsonProperty("queueConfig")
  private PrometheusSpecQueueConfig queueConfig;

  /**
   * Timeout for requests to the remote write endpoint.
   */
  @JsonProperty("remoteTimeout")
  private String remoteTimeout;

  @JsonProperty("tlsConfig")
  private PrometheusSpecTlsConfig_1 tlsConfig;

  /**
   * The URL of the endpoint to send samples to.
   */
  @NonNull
  @JsonProperty("url")
  private String url;

  /**
   * The list of remote write relabel configurations.
   */
  @JsonProperty("writeRelabelConfigs")
  @Singular(value = "addToWriteRelabelConfigs", ignoreNullCollections = true)
  private List<PodMonitorSpecMetricRelabelings> writeRelabelConfigs;

}

