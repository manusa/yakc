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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Endpoint defines a scrapeable endpoint serving Prometheus metrics.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ServiceMonitorSpecEndpoints implements Model {


  @JsonProperty("basicAuth")
  private ServiceMonitorSpecBasicAuth basicAuth;

  /**
   * File to read bearer token for scraping targets.
   */
  @JsonProperty("bearerTokenFile")
  private String bearerTokenFile;

  @JsonProperty("bearerTokenSecret")
  private ServiceMonitorSpecBearerTokenSecret bearerTokenSecret;

  /**
   * HonorLabels chooses the metric's labels on collisions with target labels.
   */
  @JsonProperty("honorLabels")
  private Boolean honorLabels;

  /**
   * HonorTimestamps controls whether Prometheus respects the timestamps present in scraped data.
   */
  @JsonProperty("honorTimestamps")
  private Boolean honorTimestamps;

  /**
   * Interval at which metrics should be scraped
   */
  @JsonProperty("interval")
  private String interval;

  /**
   * MetricRelabelConfigs to apply to samples before ingestion.
   */
  @JsonProperty("metricRelabelings")
  @Singular(value = "addToMetricRelabelings", ignoreNullCollections = true)
  private List<PodMonitorSpecMetricRelabelings> metricRelabelings;

  /**
   * Optional HTTP URL parameters
   */
  @JsonProperty("params")
  @Singular(value = "putInParams", ignoreNullCollections = true)
  private Map<String, List<String>> params;

  /**
   * HTTP path to scrape for metrics.
   */
  @JsonProperty("path")
  private String path;

  /**
   * Name of the service port this endpoint refers to. Mutually exclusive with targetPort.
   */
  @JsonProperty("port")
  private String port;

  /**
   * ProxyURL eg http://proxyserver:2195 Directs scrapes to proxy through this endpoint.
   */
  @JsonProperty("proxyUrl")
  private String proxyUrl;

  /**
   * RelabelConfigs to apply to samples before scraping. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#relabel_config
   */
  @JsonProperty("relabelings")
  @Singular(value = "addToRelabelings", ignoreNullCollections = true)
  private List<PodMonitorSpecMetricRelabelings> relabelings;

  /**
   * HTTP scheme to use for scraping.
   */
  @JsonProperty("scheme")
  private String scheme;

  /**
   * Timeout after which the scrape is ended
   */
  @JsonProperty("scrapeTimeout")
  private String scrapeTimeout;

  /**
   * Name or number of the target port of the endpoint. Mutually exclusive with port.
   */
  @JsonProperty("targetPort")
  private Object targetPort;

  @JsonProperty("tlsConfig")
  private ServiceMonitorSpecTlsConfig tlsConfig;

}

