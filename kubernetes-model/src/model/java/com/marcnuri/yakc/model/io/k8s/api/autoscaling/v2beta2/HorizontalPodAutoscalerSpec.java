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

package com.marcnuri.yakc.model.io.k8s.api.autoscaling.v2beta2;

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
 * HorizontalPodAutoscalerSpec describes the desired functionality of the HorizontalPodAutoscaler.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HorizontalPodAutoscalerSpec implements Model {


  @JsonProperty("behavior")
  private HorizontalPodAutoscalerBehavior behavior;

  /**
   * maxReplicas is the upper limit for the number of replicas to which the autoscaler can scale up. It cannot be less that minReplicas.
   */
  @NonNull
  @JsonProperty("maxReplicas")
  private Integer maxReplicas;

  /**
   * metrics contains the specifications for which to use to calculate the desired replica count (the maximum replica count across all metrics will be used).  The desired replica count is calculated multiplying the ratio between the target value and the current value by the current number of pods.  Ergo, metrics used must decrease as the pod count is increased, and vice-versa.  See the individual metric source types for more information about how each type of metric must respond. If not set, the default metric will be set to 80% average CPU utilization.
   */
  @JsonProperty("metrics")
  @Singular(value = "addToMetrics", ignoreNullCollections = true)
  private List<MetricSpec> metrics;

  /**
   * minReplicas is the lower limit for the number of replicas to which the autoscaler can scale down.  It defaults to 1 pod.  minReplicas is allowed to be 0 if the alpha feature gate HPAScaleToZero is enabled and at least one Object or External metric is configured.  Scaling is active as long as at least one metric value is available.
   */
  @JsonProperty("minReplicas")
  private Integer minReplicas;

  @NonNull
  @JsonProperty("scaleTargetRef")
  private CrossVersionObjectReference scaleTargetRef;

}

