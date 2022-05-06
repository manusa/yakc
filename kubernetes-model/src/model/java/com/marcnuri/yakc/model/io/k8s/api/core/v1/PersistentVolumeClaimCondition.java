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
 * PersistentVolumeClaimCondition contails details about state of pvc
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PersistentVolumeClaimCondition implements Model {


  @JsonProperty("lastProbeTime")
  private OffsetDateTime lastProbeTime;

  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  /**
   * message is the human-readable message indicating details about last transition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * reason is a unique, this should be a short, machine understandable string that gives the reason for condition's last transition. If it reports "ResizeStarted" that means the underlying persistent volume is being resized.
   */
  @JsonProperty("reason")
  private String reason;

  @NonNull
  @JsonProperty("status")
  private String status;

  @NonNull
  @JsonProperty("type")
  private String type;

}

