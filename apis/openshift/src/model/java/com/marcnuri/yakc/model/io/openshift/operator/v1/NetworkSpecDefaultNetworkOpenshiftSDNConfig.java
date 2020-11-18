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
 * openShiftSDNConfig configures the openshift-sdn plugin
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecDefaultNetworkOpenshiftSDNConfig implements Model {


  /**
   * enableUnidling controls whether or not the service proxy will support idling and unidling of services. By default, unidling is enabled.
   */
  @JsonProperty("enableUnidling")
  private Boolean enableUnidling;

  /**
   * mode is one of "Multitenant", "Subnet", or "NetworkPolicy"
   */
  @JsonProperty("mode")
  private String mode;

  /**
   * mtu is the mtu to use for the tunnel interface. Defaults to 1450 if unset. This must be 50 bytes smaller than the machine's uplink.
   */
  @JsonProperty("mtu")
  private Number mtu;

  /**
   * useExternalOpenvswitch tells the operator not to install openvswitch, because it will be provided separately. If set, you must provide it yourself.
   */
  @JsonProperty("useExternalOpenvswitch")
  private Boolean useExternalOpenvswitch;

  /**
   * vxlanPort is the port to use for all vxlan packets. The default is 4789.
   */
  @JsonProperty("vxlanPort")
  private Number vxlanPort;

}

