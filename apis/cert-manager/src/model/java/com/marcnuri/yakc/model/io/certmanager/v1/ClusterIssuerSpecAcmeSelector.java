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

package com.marcnuri.yakc.model.io.certmanager.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Selector selects a set of DNSNames on the Certificate resource that should be solved using this challenge solver. If not specified, the solver will be treated as the 'default' solver with the lowest priority, i.e. if any other solver has a more specific match, it will be used instead.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeSelector implements Model {


  /**
   * List of DNSNames that this solver will be used to solve. If specified and a match is found, a dnsNames selector will take precedence over a dnsZones selector. If multiple solvers match with the same dnsNames value, the solver with the most matching labels in matchLabels will be selected. If neither has more matches, the solver defined earlier in the list will be selected.
   */
  @JsonProperty("dnsNames")
  @Singular(value = "addToDnsNames", ignoreNullCollections = true)
  private List<String> dnsNames;

  /**
   * List of DNSZones that this solver will be used to solve. The most specific DNS zone match specified here will take precedence over other DNS zone matches, so a solver specifying sys.example.com will be selected over one specifying example.com for the domain www.sys.example.com. If multiple solvers match with the same dnsZones value, the solver with the most matching labels in matchLabels will be selected. If neither has more matches, the solver defined earlier in the list will be selected.
   */
  @JsonProperty("dnsZones")
  @Singular(value = "addToDnsZones", ignoreNullCollections = true)
  private List<String> dnsZones;

  /**
   * A label selector that is used to refine the set of certificate's that this challenge solver will apply to.
   */
  @JsonProperty("matchLabels")
  @Singular(value = "putInMatchLabels", ignoreNullCollections = true)
  private Map<String, String> matchLabels;

}

