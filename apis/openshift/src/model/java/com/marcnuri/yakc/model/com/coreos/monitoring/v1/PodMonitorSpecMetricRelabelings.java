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
import lombok.Singular;
import lombok.ToString;

/**
 * RelabelConfig allows dynamic rewriting of the label set, being applied to samples before ingestion. It defines `&lt;metric_relabel_configs&gt;`-section of Prometheus configuration. More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#metric_relabel_configs
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodMonitorSpecMetricRelabelings implements Model {


  /**
   * Action to perform based on regex matching. Default is 'replace'
   */
  @JsonProperty("action")
  private String action;

  /**
   * Modulus to take of the hash of the source label values.
   */
  @JsonProperty("modulus")
  private Number modulus;

  /**
   * Regular expression against which the extracted value is matched. Default is '(.&#42;)'
   */
  @JsonProperty("regex")
  private String regex;

  /**
   * Replacement value against which a regex replace is performed if the regular expression matches. Regex capture groups are available. Default is '$1'
   */
  @JsonProperty("replacement")
  private String replacement;

  /**
   * Separator placed between concatenated source label values. default is ';'.
   */
  @JsonProperty("separator")
  private String separator;

  /**
   * The source labels select values from existing labels. Their content is concatenated using the configured separator and matched against the configured regular expression for the replace, keep, and drop actions.
   */
  @JsonProperty("sourceLabels")
  @Singular(value = "addToSourceLabels", ignoreNullCollections = true)
  private List<String> sourceLabels;

  /**
   * Label to which the resulting value is written in a replace action. It is mandatory for replace actions. Regex capture groups are available.
   */
  @JsonProperty("targetLabel")
  private String targetLabel;

}

