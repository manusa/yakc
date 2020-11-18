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
 * ContainerRuntimeConfiguration defines the tuneables of the container runtime
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ContainerRuntimeConfigSpecContainerRuntimeConfig implements Model {


  /**
   * logLevel specifies the verbosity of the logs based on the level it is set to. Options are fatal, panic, error, warn, info, and debug.
   */
  @JsonProperty("logLevel")
  private String logLevel;

  /**
   * logSizeMax specifies the Maximum size allowed for the container log file. Negative numbers indicate that no size limit is imposed. If it is positive, it must be &gt;= 8192 to match/exceed conmon's read buffer.
   */
  @JsonProperty("logSizeMax")
  private String logSizeMax;

  /**
   * overlaySize specifies the maximum size of a container image. This flag can be used to set quota on the size of container images. (default: 10GB)
   */
  @JsonProperty("overlaySize")
  private String overlaySize;

  /**
   * pidsLimit specifies the maximum number of processes allowed in a container
   */
  @JsonProperty("pidsLimit")
  private Number pidsLimit;

}

