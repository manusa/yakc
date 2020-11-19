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

package com.marcnuri.yakc.model.io.istio.networking.v1alpha3;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Configuration affecting VMs onboarded into the mesh. See more details at: https://istio.io/docs/reference/config/networking/workload-entry.html
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WorkloadEntrySpec implements Model {


  @JsonProperty("address")
  private String address;

  /**
   * One or more labels associated with the endpoint.
   */
  @JsonProperty("labels")
  @Singular(value = "putInLabels", ignoreNullCollections = true)
  private Map<String, String> labels;

  /**
   * The locality associated with the endpoint.
   */
  @JsonProperty("locality")
  private String locality;

  @JsonProperty("network")
  private String network;

  /**
   * Set of ports associated with the endpoint.
   */
  @JsonProperty("ports")
  @Singular(value = "putInPorts", ignoreNullCollections = true)
  private Map<String, Number> ports;

  @JsonProperty("serviceAccount")
  private String serviceAccount;

  /**
   * The load balancing weight associated with the endpoint.
   */
  @JsonProperty("weight")
  private Number weight;

}

