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

package com.marcnuri.yakc.model.io.k8s.api.autoscaling.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * current status of a horizontal pod autoscaler
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HorizontalPodAutoscalerStatus implements Model {


  /**
   * current average CPU utilization over all pods, represented as a percentage of requested CPU, e.g. 70 means that an average pod is using now 70% of its requested CPU.
   */
  @JsonProperty("currentCPUUtilizationPercentage")
  private Integer currentCPUUtilizationPercentage;

  /**
   * current number of replicas of pods managed by this autoscaler.
   */
  @NonNull
  @JsonProperty("currentReplicas")
  private Integer currentReplicas;

  /**
   * desired number of replicas of pods managed by this autoscaler.
   */
  @NonNull
  @JsonProperty("desiredReplicas")
  private Integer desiredReplicas;

  @JsonProperty("lastScaleTime")
  private OffsetDateTime lastScaleTime;

  /**
   * most recent generation observed by this autoscaler.
   */
  @JsonProperty("observedGeneration")
  private Integer observedGeneration;

}

