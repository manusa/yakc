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

package com.marcnuri.yakc.model.io.k8s.api.core.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Probe implements Model {


  @JsonProperty("exec")
  private ExecAction exec;

  /**
   * Minimum consecutive failures for the probe to be considered failed after having succeeded. Defaults to 3. Minimum value is 1.
   */
  @JsonProperty("failureThreshold")
  private Number failureThreshold;

  @JsonProperty("httpGet")
  private HTTPGetAction httpGet;

  /**
   * Number of seconds after the container has started before liveness probes are initiated. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
   */
  @JsonProperty("initialDelaySeconds")
  private Number initialDelaySeconds;

  /**
   * How often (in seconds) to perform the probe. Default to 10 seconds. Minimum value is 1.
   */
  @JsonProperty("periodSeconds")
  private Number periodSeconds;

  /**
   * Minimum consecutive successes for the probe to be considered successful after having failed. Defaults to 1. Must be 1 for liveness and startup. Minimum value is 1.
   */
  @JsonProperty("successThreshold")
  private Number successThreshold;

  @JsonProperty("tcpSocket")
  private TCPSocketAction tcpSocket;

  /**
   * Optional duration in seconds the pod needs to terminate gracefully upon probe failure. The grace period is the duration in seconds after the processes running in the pod are sent a termination signal and the time when the processes are forcibly halted with a kill signal. Set this value longer than the expected cleanup time for your process. If this value is nil, the pod's terminationGracePeriodSeconds will be used. Otherwise, this value overrides the value provided by the pod spec. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down). This is a beta field and requires enabling ProbeTerminationGracePeriod feature gate. Minimum value is 1. spec.terminationGracePeriodSeconds is used if unset.
   */
  @JsonProperty("terminationGracePeriodSeconds")
  private Number terminationGracePeriodSeconds;

  /**
   * Number of seconds after which the probe times out. Defaults to 1 second. Minimum value is 1. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
   */
  @JsonProperty("timeoutSeconds")
  private Number timeoutSeconds;

}

