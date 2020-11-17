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
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * NetworkSpec is the top-level network configuration object.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpec implements Model {


  /**
   * additionalNetworks is a list of extra networks to make available to pods when multiple networks are enabled.
   */
  @JsonProperty("additionalNetworks")
  @Singular(value = "addToAdditionalNetworks", ignoreNullCollections = true)
  private List<NetworkSpecAdditionalNetworks> additionalNetworks;

  /**
   * clusterNetwork is the IP address pool to use for pod IPs. Some network providers, e.g. OpenShift SDN, support multiple ClusterNetworks. Others only support one. This is equivalent to the cluster-cidr.
   */
  @JsonProperty("clusterNetwork")
  @Singular(value = "addToClusterNetwork", ignoreNullCollections = true)
  private List<NetworkSpecClusterNetwork> clusterNetwork;

  @NonNull
  @JsonProperty("defaultNetwork")
  private NetworkSpecDefaultNetwork defaultNetwork;

  /**
   * deployKubeProxy specifies whether or not a standalone kube-proxy should be deployed by the operator. Some network providers include kube-proxy or similar functionality. If unset, the plugin will attempt to select the correct value, which is false when OpenShift SDN and ovn-kubernetes are used and true otherwise.
   */
  @JsonProperty("deployKubeProxy")
  private Boolean deployKubeProxy;

  /**
   * disableMultiNetwork specifies whether or not multiple pod network support should be disabled. If unset, this property defaults to 'false' and multiple network support is enabled.
   */
  @JsonProperty("disableMultiNetwork")
  private Boolean disableMultiNetwork;

  @JsonProperty("kubeProxyConfig")
  private NetworkSpecKubeProxyConfig kubeProxyConfig;

  /**
   * logLevel allows configuring the logging level of the components deployed by the operator. Currently only Kuryr SDN is affected by this setting. Please note that turning on extensive logging may affect performance. The default value is "Normal".
   */
  @JsonProperty("logLevel")
  private String logLevel;

  /**
   * serviceNetwork is the ip address pool to use for Service IPs Currently, all existing network providers only support a single value here, but this is an array to allow for growth.
   */
  @JsonProperty("serviceNetwork")
  @Singular(value = "addToServiceNetwork", ignoreNullCollections = true)
  private List<String> serviceNetwork;

}

