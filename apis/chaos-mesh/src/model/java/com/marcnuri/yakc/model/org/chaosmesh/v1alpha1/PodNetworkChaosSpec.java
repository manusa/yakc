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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

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
 * Spec defines the behavior of a pod chaos experiment
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodNetworkChaosSpec implements Model {


  /**
   * The ipset on the pod
   */
  @JsonProperty("ipsets")
  @Singular(value = "addToIpsets", ignoreNullCollections = true)
  private List<PodNetworkChaosSpecIpsets> ipsets;

  /**
   * The iptables rules on the pod
   */
  @JsonProperty("iptables")
  @Singular(value = "addToIptables", ignoreNullCollections = true)
  private List<PodNetworkChaosSpecIptables> iptables;

  /**
   * The tc rules on the pod
   */
  @JsonProperty("tcs")
  @Singular(value = "addToTcs", ignoreNullCollections = true)
  private List<PodNetworkChaosSpecTcs> tcs;

}

