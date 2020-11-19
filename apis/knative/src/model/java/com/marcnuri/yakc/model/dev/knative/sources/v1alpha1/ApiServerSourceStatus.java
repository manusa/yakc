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

package com.marcnuri.yakc.model.dev.knative.sources.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.dev.knative.eventing.v1.BrokerStatusConditions;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ApiServerSourceStatus defines the observed state of ApiServerSource (from the controller).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ApiServerSourceStatus implements Model {


  /**
   * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
   */
  @JsonProperty("annotations")
  private Object annotations;

  /**
   * CloudEventAttributes are the specific attributes that the Source uses as part of its CloudEvents.
   */
  @JsonProperty("ceAttributes")
  @Singular(value = "addToCeAttributes", ignoreNullCollections = true)
  private List<ApiServerSourceStatusCeAttributes> ceAttributes;

  /**
   * Conditions the latest available observations of a resource's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<BrokerStatusConditions> conditions;

  /**
   * ObservedGeneration is the "Generation" of the Service that was last processed by the controller.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * SinkURI is the current active sink URI that has been configured for the Source.
   */
  @JsonProperty("sinkUri")
  private String sinkUri;

}

