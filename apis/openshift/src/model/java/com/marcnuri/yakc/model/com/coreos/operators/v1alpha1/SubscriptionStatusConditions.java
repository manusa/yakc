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

package com.marcnuri.yakc.model.com.coreos.operators.v1alpha1;

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
 * SubscriptionCondition represents the latest available observations of a Subscription's state.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SubscriptionStatusConditions implements Model {


  /**
   * LastHeartbeatTime is the last time we got an update on a given condition
   */
  @JsonProperty("lastHeartbeatTime")
  private OffsetDateTime lastHeartbeatTime;

  /**
   * LastTransitionTime is the last time the condition transit from one status to another
   */
  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  /**
   * Message is a human-readable message indicating details about last transition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * Reason is a one-word CamelCase reason for the condition's last transition.
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * Status is the status of the condition, one of True, False, Unknown.
   */
  @NonNull
  @JsonProperty("status")
  private String status;

  /**
   * Type is the type of Subscription condition.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

