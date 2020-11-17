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
 * SimpleMacvlanConfig configures the macvlan interface in case of type:NetworkTypeSimpleMacvlan
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecSimpleMacvlanConfig implements Model {


  @JsonProperty("ipamConfig")
  private NetworkSpecSimpleMacvlanConfigIpamConfig ipamConfig;

  /**
   * master is the host interface to create the macvlan interface from. If not specified, it will be default route interface
   */
  @JsonProperty("master")
  private String master;

  /**
   * mode is the macvlan mode: bridge, private, vepa, passthru. The default is bridge
   */
  @JsonProperty("mode")
  private String mode;

  /**
   * mtu is the mtu to use for the macvlan interface. if unset, host's kernel will select the value.
   */
  @JsonProperty("mtu")
  private Number mtu;

}

