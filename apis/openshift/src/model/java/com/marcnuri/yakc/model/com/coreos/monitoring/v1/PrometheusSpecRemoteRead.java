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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * RemoteReadSpec defines the remote_read configuration for prometheus.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecRemoteRead implements Model {


  @JsonProperty("basicAuth")
  private PrometheusSpecBasicAuth basicAuth;

  /**
   * bearer token for remote read.
   */
  @JsonProperty("bearerToken")
  private String bearerToken;

  /**
   * File to read bearer token for remote read.
   */
  @JsonProperty("bearerTokenFile")
  private String bearerTokenFile;

  /**
   * Optional ProxyURL
   */
  @JsonProperty("proxyUrl")
  private String proxyUrl;

  /**
   * Whether reads should be made for queries for time ranges that the local storage should have complete data for.
   */
  @JsonProperty("readRecent")
  private Boolean readRecent;

  /**
   * Timeout for requests to the remote read endpoint.
   */
  @JsonProperty("remoteTimeout")
  private String remoteTimeout;

  /**
   * An optional list of equality matchers which have to be present in a selector to query the remote read endpoint.
   */
  @JsonProperty("requiredMatchers")
  @Singular(value = "putInRequiredMatchers", ignoreNullCollections = true)
  private Map<String, String> requiredMatchers;

  @JsonProperty("tlsConfig")
  private PrometheusSpecTlsConfig tlsConfig;

  /**
   * The URL of the endpoint to send samples to.
   */
  @NonNull
  @JsonProperty("url")
  private String url;

}

