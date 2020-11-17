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
 * MachineConfigSpec is the spec for MachineConfig
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MachineConfigSpec implements Model {


  /**
   * Config is a Ignition Config object.
   */
  @JsonProperty("config")
  private Object config;

  /**
   * FIPS controls FIPS mode
   */
  @JsonProperty("fips")
  private Boolean fips;

  /**
   * KernelArguments contains a list of kernel arguments to be added
   */
  @JsonProperty("kernelArguments")
  private Object kernelArguments;

  /**
   * Contains which kernel we want to be running like default (traditional), realtime
   */
  @JsonProperty("kernelType")
  private String kernelType;

  /**
   * OSImageURL specifies the remote location that will be used to fetch the OS to fetch the OS.
   */
  @JsonProperty("osImageURL")
  private String osImageURL;

}

