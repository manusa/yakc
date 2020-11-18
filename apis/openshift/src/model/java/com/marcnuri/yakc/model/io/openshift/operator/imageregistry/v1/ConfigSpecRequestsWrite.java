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

package com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * write defines limits for image registry's writes.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigSpecRequestsWrite implements Model {


  /**
   * maxInQueue sets the maximum queued api requests to the registry.
   */
  @JsonProperty("maxInQueue")
  private Number maxInQueue;

  /**
   * maxRunning sets the maximum in flight api requests to the registry.
   */
  @JsonProperty("maxRunning")
  private Number maxRunning;

  /**
   * maxWaitInQueue sets the maximum time a request can wait in the queue before being rejected.
   */
  @JsonProperty("maxWaitInQueue")
  private String maxWaitInQueue;

}

