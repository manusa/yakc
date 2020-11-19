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

package com.marcnuri.yakc.model.dev.knative.sources.v1alpha2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.dev.knative.sources.v1.ApiServerSourceSpecSink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * PingSourceSpec defines the desired state of the PingSource (from the client).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PingSourceSpec implements Model {


  @JsonProperty("ceOverrides")
  private PingSourceSpecCeOverrides ceOverrides;

  /**
   * JsonData is json encoded data used as the body of the event posted to the sink. Default is empty. If set, datacontenttype will also be set to "application/json".
   */
  @JsonProperty("jsonData")
  private String jsonData;

  /**
   * Schedule is the cronjob schedule. Defaults to `&#42; &#42; &#42; &#42; &#42;`.
   */
  @JsonProperty("schedule")
  private String schedule;

  @JsonProperty("sink")
  private ApiServerSourceSpecSink sink;

}

