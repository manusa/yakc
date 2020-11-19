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

package com.marcnuri.yakc.model.dev.knative.flows.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Status represents the current state of the Sequence. This data may be out of date.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SequenceStatus implements Model {


  @JsonProperty("address")
  private ParallelStatusAddress address;

  /**
   * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
   */
  @JsonProperty("annotations")
  private Object annotations;

  /**
   * ChannelStatuses is an array of corresponding Channel statuses. Matches the Spec.Steps array in the order.
   */
  @JsonProperty("channelStatuses")
  @Singular(value = "addToChannelStatuses", ignoreNullCollections = true)
  private List<SequenceStatusChannelStatuses> channelStatuses;

  /**
   * Conditions the latest available observations of a resource's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ParallelStatusConditions> conditions;

  /**
   * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * SubscriptionStatuses is an array of corresponding Subscription statuses. Matches the Spec.Steps array in the order.
   */
  @JsonProperty("subscriptionStatuses")
  @Singular(value = "addToSubscriptionStatuses", ignoreNullCollections = true)
  private List<SequenceStatusSubscriptionStatuses> subscriptionStatuses;

}

