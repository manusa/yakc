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

package com.marcnuri.yakc.model.io.k8s.api.resource.v1alpha2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ResourceClaimSpec defines how a resource is to be allocated.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourceClaimSpec implements Model {


  /**
   * Allocation can start immediately or when a Pod wants to use the resource. "WaitForFirstConsumer" is the default.
   */
  @JsonProperty("allocationMode")
  private String allocationMode;

  @JsonProperty("parametersRef")
  private ResourceClaimParametersReference parametersRef;

  /**
   * ResourceClassName references the driver and additional parameters via the name of a ResourceClass that was created as part of the driver deployment.
   */
  @NonNull
  @JsonProperty("resourceClassName")
  private String resourceClassName;

}

