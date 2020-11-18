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

package com.marcnuri.yakc.model.io.openshift.config.v1;

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
 * spec holds user settable values for configuration. As a general rule, this SHOULD NOT be read directly. Instead, you should consume the NetworkStatus, as it indicates the currently deployed configuration. Currently, most spec fields are immutable after installation. Please view the individual ones for further details on each.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpec implements Model {


  /**
   * IP address pool to use for pod IPs. This field is immutable after installation.
   */
  @JsonProperty("clusterNetwork")
  @Singular(value = "addToClusterNetwork", ignoreNullCollections = true)
  private List<NetworkSpecClusterNetwork> clusterNetwork;

  @JsonProperty("externalIP")
  private NetworkSpecExternalIP externalIP;

  /**
   * NetworkType is the plugin that is to be deployed (e.g. OpenShiftSDN). This should match a value that the cluster-network-operator understands, or else no networking will be installed. Currently supported values are: - OpenShiftSDN This field is immutable after installation.
   */
  @JsonProperty("networkType")
  private String networkType;

  /**
   * IP address pool for services. Currently, we only support a single entry here. This field is immutable after installation.
   */
  @JsonProperty("serviceNetwork")
  @Singular(value = "addToServiceNetwork", ignoreNullCollections = true)
  private List<String> serviceNetwork;

}

