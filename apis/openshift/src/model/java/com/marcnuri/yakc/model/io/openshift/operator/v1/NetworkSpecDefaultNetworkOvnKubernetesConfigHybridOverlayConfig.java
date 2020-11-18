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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

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
 * HybridOverlayConfig configures an additional overlay network for peers that are not using OVN.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecDefaultNetworkOvnKubernetesConfigHybridOverlayConfig implements Model {


  /**
   * HybridClusterNetwork defines a network space given to nodes on an additional overlay network.
   */
  @JsonProperty("hybridClusterNetwork")
  @Singular(value = "addToHybridClusterNetwork", ignoreNullCollections = true)
  private List<NetworkSpecDefaultNetworkOvnKubernetesConfigHybridOverlayConfigHybridClusterNetwork> hybridClusterNetwork;

}

