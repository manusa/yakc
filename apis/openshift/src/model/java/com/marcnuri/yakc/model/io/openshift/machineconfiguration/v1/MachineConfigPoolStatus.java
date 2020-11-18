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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * MachineConfigPoolStatus is the status for MachineConfigPool resource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MachineConfigPoolStatus implements Model {


  /**
   * conditions represents the latest available observations of current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<MachineConfigPoolStatusConditions> conditions;

  @JsonProperty("configuration")
  private MachineConfigPoolStatusConfiguration configuration;

  /**
   * degradedMachineCount represents the total number of machines marked degraded (or unreconcilable). A node is marked degraded if applying a configuration failed..
   */
  @JsonProperty("degradedMachineCount")
  private Number degradedMachineCount;

  /**
   * machineCount represents the total number of machines in the machine config pool.
   */
  @JsonProperty("machineCount")
  private Number machineCount;

  /**
   * observedGeneration represents the generation observed by the controller.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * readyMachineCount represents the total number of ready machines targeted by the pool.
   */
  @JsonProperty("readyMachineCount")
  private Number readyMachineCount;

  /**
   * unavailableMachineCount represents the total number of unavailable (non-ready) machines targeted by the pool. A node is marked unavailable if it is in updating state or NodeReady condition is false.
   */
  @JsonProperty("unavailableMachineCount")
  private Number unavailableMachineCount;

  /**
   * updatedMachineCount represents the total number of machines targeted by the pool that have the CurrentMachineConfig as their config.
   */
  @JsonProperty("updatedMachineCount")
  private Number updatedMachineCount;

}

