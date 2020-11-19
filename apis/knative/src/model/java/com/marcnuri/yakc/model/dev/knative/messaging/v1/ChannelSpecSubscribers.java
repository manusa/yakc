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
public class ChannelSpecSubscribers implements Model {


  @JsonProperty("delivery")
  private ChannelSpecDelivery delivery;

  /**
   * Generation of the origin of the subscriber with uid:UID.
   */
  @JsonProperty("generation")
  private Number generation;

  /**
   * ReplyURI is the endpoint for the reply
   */
  @JsonProperty("replyUri")
  private String replyUri;

  /**
   * SubscriberURI is the endpoint for the subscriber
   */
  @JsonProperty("subscriberUri")
  private String subscriberUri;

  /**
   * UID is used to understand the origin of the subscriber.
   */
  @JsonProperty("uid")
  private String uid;

}

