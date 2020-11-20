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

package com.marcnuri.yakc.model.io.istio.networking.v1alpha3;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * `ReadinessProbe` describes the configuration the user must provide for healthchecking on their workload.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WorkloadGroupSpecProbe implements Model {


  @JsonProperty("exec")
  private WorkloadGroupSpecProbeExec exec;

  /**
   * Minimum consecutive failures for the probe to be considered failed after having succeeded.
   */
  @JsonProperty("failureThreshold")
  private Number failureThreshold;

  @JsonProperty("httpGet")
  private WorkloadGroupSpecProbeHttpGet httpGet;

  /**
   * Number of seconds after the container has started before readiness probes are initiated.
   */
  @JsonProperty("initialDelaySeconds")
  private Number initialDelaySeconds;

  /**
   * How often (in seconds) to perform the probe.
   */
  @JsonProperty("periodSeconds")
  private Number periodSeconds;

  /**
   * Minimum consecutive successes for the probe to be considered successful after having failed.
   */
  @JsonProperty("successThreshold")
  private Number successThreshold;

  @JsonProperty("tcpSocket")
  private WorkloadGroupSpecProbeTcpSocket tcpSocket;

  /**
   * Number of seconds after which the probe times out.
   */
  @JsonProperty("timeoutSeconds")
  private Number timeoutSeconds;

}

