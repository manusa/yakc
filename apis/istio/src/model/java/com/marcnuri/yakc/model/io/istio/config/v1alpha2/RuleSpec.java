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

package com.marcnuri.yakc.model.io.istio.config.v1alpha2;

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
 * Describes the rules used to configure Mixer's policy and telemetry features. See more details at: https://istio.io/docs/reference/config/policy-and-telemetry/istio.policy.v1beta1.html
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RuleSpec implements Model {


  /**
   * The actions that will be executed when match evaluates to `true`.
   */
  @JsonProperty("actions")
  @Singular(value = "addToActions", ignoreNullCollections = true)
  private List<RuleSpecActions> actions;

  /**
   * Match is an attribute based predicate.
   */
  @JsonProperty("match")
  private String match;

  @JsonProperty("requestHeaderOperations")
  @Singular(value = "addToRequestHeaderOperations", ignoreNullCollections = true)
  private List<RuleSpecRequestHeaderOperations> requestHeaderOperations;

  @JsonProperty("responseHeaderOperations")
  @Singular(value = "addToResponseHeaderOperations", ignoreNullCollections = true)
  private List<RuleSpecRequestHeaderOperations> responseHeaderOperations;

  @JsonProperty("sampling")
  private RuleSpecSampling sampling;

}

