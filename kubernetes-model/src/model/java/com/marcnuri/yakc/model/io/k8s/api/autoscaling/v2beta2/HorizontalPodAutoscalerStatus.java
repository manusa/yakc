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
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * HorizontalPodAutoscalerStatus describes the current status of a horizontal pod autoscaler.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HorizontalPodAutoscalerStatus implements Model {


  /**
   * conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or not those conditions are met.
   */
  @NonNull
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<HorizontalPodAutoscalerCondition> conditions;

  /**
   * currentMetrics is the last read state of the metrics used by this autoscaler.
   */
  @JsonProperty("currentMetrics")
  @Singular(value = "addToCurrentMetrics", ignoreNullCollections = true)
  private List<MetricStatus> currentMetrics;

  /**
   * currentReplicas is current number of replicas of pods managed by this autoscaler, as last seen by the autoscaler.
   */
  @NonNull
  @JsonProperty("currentReplicas")
  private Integer currentReplicas;

  /**
   * desiredReplicas is the desired number of replicas of pods managed by this autoscaler, as last calculated by the autoscaler.
   */
  @NonNull
  @JsonProperty("desiredReplicas")
  private Integer desiredReplicas;

  @JsonProperty("lastScaleTime")
  private OffsetDateTime lastScaleTime;

  /**
   * observedGeneration is the most recent generation observed by this autoscaler.
   */
  @JsonProperty("observedGeneration")
  private Integer observedGeneration;

}

