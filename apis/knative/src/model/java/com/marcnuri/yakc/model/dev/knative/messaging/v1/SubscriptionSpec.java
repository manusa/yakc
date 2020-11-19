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
 * Specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Result. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Result.<br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SubscriptionSpec implements Model {


  @JsonProperty("channel")
  private SubscriptionSpecChannel channel;

  @JsonProperty("delivery")
  private SubscriptionSpecDelivery delivery;

  @JsonProperty("reply")
  private SubscriptionSpecReply reply;

  @JsonProperty("subscriber")
  private SubscriptionSpecSubscriber subscriber;

}

