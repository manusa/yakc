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
import com.marcnuri.yakc.model.dev.knative.eventing.v1.BrokerSpecDeliveryDeadLetterSink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * DeliverySpec contains options controlling the event delivery
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ChannelSpecDelivery implements Model {


  /**
   * BackoffDelay is the delay before retrying. More information on Duration format: - https://www.iso.org/iso-8601-date-and-time-format.html - https://en.wikipedia.org/wiki/ISO_8601  For linear policy, backoff delay is backoffDelay&#42;&lt;numberOfRetries&gt;. For exponential policy, backoff delay is backoffDelay&#42;2^&lt;numberOfRetries&gt;.
   */
  @JsonProperty("backoffDelay")
  private String backoffDelay;

  /**
   * BackoffPolicy is the retry backoff policy (linear, exponential).
   */
  @JsonProperty("backoffPolicy")
  private String backoffPolicy;

  @JsonProperty("deadLetterSink")
  private BrokerSpecDeliveryDeadLetterSink deadLetterSink;

  /**
   * Retry is the minimum number of retries the sender should attempt when sending an event before moving it to the dead letter sink.
   */
  @JsonProperty("retry")
  private Number retry;

}

