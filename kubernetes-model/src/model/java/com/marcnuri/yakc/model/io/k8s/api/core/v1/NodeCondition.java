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
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * NodeCondition contains condition information for a node.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NodeCondition implements Model {


  @JsonProperty("lastHeartbeatTime")
  private OffsetDateTime lastHeartbeatTime;

  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  /**
   * Human readable message indicating details about last transition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * (brief) reason for the condition's last transition.
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * Status of the condition, one of True, False, Unknown.
   */
  @NonNull
  @JsonProperty("status")
  private String status;

  /**
   * Type of node condition.<br><p> <br><p> Possible enum values:<br><p>  - `"DiskPressure"` means the kubelet is under pressure due to insufficient available disk.<br><p>  - `"MemoryPressure"` means the kubelet is under pressure due to insufficient available memory.<br><p>  - `"NetworkUnavailable"` means that network for the node is not correctly configured.<br><p>  - `"PIDPressure"` means the kubelet is under pressure due to insufficient available PID.<br><p>  - `"Ready"` means kubelet is healthy and ready to accept pods.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

