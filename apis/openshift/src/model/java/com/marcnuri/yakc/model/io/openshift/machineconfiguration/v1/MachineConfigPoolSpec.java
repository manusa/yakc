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

package com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * MachineConfigPoolSpec is the spec for MachineConfigPool resource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MachineConfigPoolSpec implements Model {


  @JsonProperty("configuration")
  private MachineConfigPoolSpecConfiguration configuration;

  @JsonProperty("machineConfigSelector")
  private MachineConfigPoolSpecMachineConfigSelector machineConfigSelector;

  /**
   * maxUnavailable specifies the percentage or constant number of machines that can be updating at any given time. default is 1.
   */
  @JsonProperty("maxUnavailable")
  private Object maxUnavailable;

  @JsonProperty("nodeSelector")
  private MachineConfigPoolSpecNodeSelector nodeSelector;

  /**
   * paused specifies whether or not changes to this machine config pool should be stopped. This includes generating new desiredMachineConfig and update of machines.
   */
  @JsonProperty("paused")
  private Boolean paused;

}

