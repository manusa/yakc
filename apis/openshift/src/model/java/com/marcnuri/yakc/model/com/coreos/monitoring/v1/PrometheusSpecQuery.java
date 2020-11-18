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
 * QuerySpec defines the query command line flags when starting Prometheus.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecQuery implements Model {


  /**
   * The delta difference allowed for retrieving metrics during expression evaluations.
   */
  @JsonProperty("lookbackDelta")
  private String lookbackDelta;

  /**
   * Number of concurrent queries that can be run at once.
   */
  @JsonProperty("maxConcurrency")
  private Number maxConcurrency;

  /**
   * Maximum number of samples a single query can load into memory. Note that queries will fail if they would load more samples than this into memory, so this also limits the number of samples a query can return.
   */
  @JsonProperty("maxSamples")
  private Number maxSamples;

  /**
   * Maximum time a query may take before being aborted.
   */
  @JsonProperty("timeout")
  private String timeout;

}

