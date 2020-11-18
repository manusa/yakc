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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * KuryrConfig configures the kuryr plugin
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecDefaultNetworkKuryrConfig implements Model {


  /**
   * The port kuryr-controller will listen for readiness and liveness requests.
   */
  @JsonProperty("controllerProbesPort")
  private Number controllerProbesPort;

  /**
   * The port kuryr-daemon will listen for readiness and liveness requests.
   */
  @JsonProperty("daemonProbesPort")
  private Number daemonProbesPort;

  /**
   * enablePortPoolsPrepopulation when true will make Kuryr prepopulate each newly created port pool with a minimum number of ports. Kuryr uses Neutron port pooling to fight the fact that it takes a significant amount of time to create one. Instead of creating it when pod is being deployed, Kuryr keeps a number of ports ready to be attached to pods. By default port prepopulation is disabled.
   */
  @JsonProperty("enablePortPoolsPrepopulation")
  private Boolean enablePortPoolsPrepopulation;

  /**
   * openStackServiceNetwork contains the CIDR of network from which to allocate IPs for OpenStack Octavia's Amphora VMs. Please note that with Amphora driver Octavia uses two IPs from that network for each loadbalancer - one given by OpenShift and second for VRRP connections. As the first one is managed by OpenShift's and second by Neutron's IPAMs, those need to come from different pools. Therefore `openStackServiceNetwork` needs to be at least twice the size of `serviceNetwork`, and whole `serviceNetwork` must be overlapping with `openStackServiceNetwork`. cluster-network-operator will then make sure VRRP IPs are taken from the ranges inside `openStackServiceNetwork` that are not overlapping with `serviceNetwork`, effectivly preventing conflicts. If not set cluster-network-operator will use `serviceNetwork` expanded by decrementing the prefix size by 1.
   */
  @JsonProperty("openStackServiceNetwork")
  private String openStackServiceNetwork;

  /**
   * poolBatchPorts sets a number of ports that should be created in a single batch request to extend the port pool. The default is 3. For more information about port pools see enablePortPoolsPrepopulation setting.
   */
  @JsonProperty("poolBatchPorts")
  private Number poolBatchPorts;

  /**
   * poolMaxPorts sets a maximum number of free ports that are being kept in a port pool. If the number of ports exceeds this setting, free ports will get deleted. Setting 0 will disable this upper bound, effectively preventing pools from shrinking and this is the default value. For more information about port pools see enablePortPoolsPrepopulation setting.
   */
  @JsonProperty("poolMaxPorts")
  private Number poolMaxPorts;

  /**
   * poolMinPorts sets a minimum number of free ports that should be kept in a port pool. If the number of ports is lower than this setting, new ports will get created and added to pool. The default is 1. For more information about port pools see enablePortPoolsPrepopulation setting.
   */
  @JsonProperty("poolMinPorts")
  private Number poolMinPorts;

}

