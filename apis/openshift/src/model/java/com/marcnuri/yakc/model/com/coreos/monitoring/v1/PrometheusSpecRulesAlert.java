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
import lombok.ToString;

/**
 * /--rules.alert.&#42;/ command-line arguments
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecRulesAlert implements Model {


  /**
   * Minimum duration between alert and restored 'for' state. This is maintained only for alerts with configured 'for' time greater than grace period.
   */
  @JsonProperty("forGracePeriod")
  private String forGracePeriod;

  /**
   * Max time to tolerate prometheus outage for restoring 'for' state of alert.
   */
  @JsonProperty("forOutageTolerance")
  private String forOutageTolerance;

  /**
   * Minimum amount of time to wait before resending an alert to Alertmanager.
   */
  @JsonProperty("resendDelay")
  private String resendDelay;

}

