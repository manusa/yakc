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
import lombok.NonNull;
import lombok.ToString;

/**
 * Most recent observed status of the Alertmanager cluster. Read-only. Not included when requesting from the apiserver, only from the Prometheus Operator API itself. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerStatus implements Model {


  /**
   * Total number of available pods (ready for at least minReadySeconds) targeted by this Alertmanager cluster.
   */
  @NonNull
  @JsonProperty("availableReplicas")
  private Number availableReplicas;

  /**
   * Represents whether any actions on the underlaying managed objects are being performed. Only delete actions will be performed.
   */
  @NonNull
  @JsonProperty("paused")
  private Boolean paused;

  /**
   * Total number of non-terminated pods targeted by this Alertmanager cluster (their labels match the selector).
   */
  @NonNull
  @JsonProperty("replicas")
  private Number replicas;

  /**
   * Total number of unavailable pods targeted by this Alertmanager cluster.
   */
  @NonNull
  @JsonProperty("unavailableReplicas")
  private Number unavailableReplicas;

  /**
   * Total number of non-terminated pods targeted by this Alertmanager cluster that have the desired version spec.
   */
  @NonNull
  @JsonProperty("updatedReplicas")
  private Number updatedReplicas;

}

