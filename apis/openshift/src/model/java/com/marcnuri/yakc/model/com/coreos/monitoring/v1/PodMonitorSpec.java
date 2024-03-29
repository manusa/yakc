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
 * Specification of desired Pod selection for target discovery by Prometheus.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodMonitorSpec implements Model {


  /**
   * The label to use to retrieve the job name from.
   */
  @JsonProperty("jobLabel")
  private String jobLabel;

  @JsonProperty("namespaceSelector")
  private PodMonitorSpecNamespaceSelector namespaceSelector;

  /**
   * A list of endpoints allowed as part of this PodMonitor.
   */
  @NonNull
  @JsonProperty("podMetricsEndpoints")
  @Singular(value = "addToPodMetricsEndpoints", ignoreNullCollections = true)
  private List<PodMonitorSpecPodMetricsEndpoints> podMetricsEndpoints;

  /**
   * PodTargetLabels transfers labels on the Kubernetes Pod onto the target.
   */
  @JsonProperty("podTargetLabels")
  @Singular(value = "addToPodTargetLabels", ignoreNullCollections = true)
  private List<String> podTargetLabels;

  /**
   * SampleLimit defines per-scrape limit on number of scraped samples that will be accepted.
   */
  @JsonProperty("sampleLimit")
  private Number sampleLimit;

  @NonNull
  @JsonProperty("selector")
  private PodMonitorSpecSelector selector;

}

