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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Configuration affecting service registry. See more details at: https://istio.io/docs/reference/config/networking/service-entry.html
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ServiceEntrySpec implements Model {


  /**
   * The virtual IP addresses associated with the service.
   */
  @JsonProperty("addresses")
  @Singular(value = "addToAddresses", ignoreNullCollections = true)
  private List<String> addresses;

  /**
   * One or more endpoints associated with the service.
   */
  @JsonProperty("endpoints")
  @Singular(value = "addToEndpoints", ignoreNullCollections = true)
  private List<ServiceEntrySpecEndpoints> endpoints;

  /**
   * A list of namespaces to which this service is exported.
   */
  @JsonProperty("exportTo")
  @Singular(value = "addToExportTo", ignoreNullCollections = true)
  private List<String> exportTo;

  /**
   * The hosts associated with the ServiceEntry.
   */
  @JsonProperty("hosts")
  @Singular(value = "addToHosts", ignoreNullCollections = true)
  private List<String> hosts;

  @JsonProperty("location")
  private String location;

  /**
   * The ports associated with the external service.
   */
  @JsonProperty("ports")
  @Singular(value = "addToPorts", ignoreNullCollections = true)
  private List<GatewaySpecPort> ports;

  /**
   * Service discovery mode for the hosts.
   */
  @JsonProperty("resolution")
  private String resolution;

  @JsonProperty("subjectAltNames")
  @Singular(value = "addToSubjectAltNames", ignoreNullCollections = true)
  private List<String> subjectAltNames;

  @JsonProperty("workloadSelector")
  private ServiceEntrySpecWorkloadSelector workloadSelector;

}

