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

package com.marcnuri.yakc.model.io.istio.networking.v1alpha3;

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
 * Configuration affecting load balancing, outlier detection, etc. See more details at: https://istio.io/docs/reference/config/networking/destination-rule.html
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DestinationRuleSpec implements Model {


  /**
   * A list of namespaces to which this destination rule is exported.
   */
  @JsonProperty("exportTo")
  @Singular(value = "addToExportTo", ignoreNullCollections = true)
  private List<String> exportTo;

  /**
   * The name of a service from the service registry.
   */
  @JsonProperty("host")
  private String host;

  @JsonProperty("subsets")
  @Singular(value = "addToSubsets", ignoreNullCollections = true)
  private List<DestinationRuleSpecSubsets> subsets;

  @JsonProperty("trafficPolicy")
  private DestinationRuleSpecTrafficPolicy_1 trafficPolicy;

}

