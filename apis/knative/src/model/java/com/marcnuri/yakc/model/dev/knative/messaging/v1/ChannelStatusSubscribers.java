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

package com.marcnuri.yakc.model.dev.knative.messaging.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ChannelStatusSubscribers implements Model {


  /**
   * A human readable message indicating details of Ready status.
   */
  @JsonProperty("message")
  private String message;

  /**
   * Generation of the origin of the subscriber with uid:UID.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * Status of the subscriber.
   */
  @JsonProperty("ready")
  private String ready;

  /**
   * UID is used to understand the origin of the subscriber.
   */
  @JsonProperty("uid")
  private String uid;

}

