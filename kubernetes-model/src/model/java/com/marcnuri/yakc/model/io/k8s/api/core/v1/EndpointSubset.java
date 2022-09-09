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

package com.marcnuri.yakc.model.io.k8s.api.core.v1;

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
 * EndpointSubset is a group of addresses with a common set of ports. The expanded set of endpoints is the Cartesian product of Addresses x Ports. For example, given:<br><p> <br><p> 	{<br><p> 	  Addresses: [{"ip": "10.10.1.1"}, {"ip": "10.10.2.2"}],<br><p> 	  Ports:     [{"name": "a", "port": 8675}, {"name": "b", "port": 309}]<br><p> 	}<br><p> <br><p> The resulting set of endpoints can be viewed as:<br><p> <br><p> 	a: [ 10.10.1.1:8675, 10.10.2.2:8675 ],<br><p> 	b: [ 10.10.1.1:309, 10.10.2.2:309 ]
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EndpointSubset implements Model {


  /**
   * IP addresses which offer the related ports that are marked as ready. These endpoints should be considered safe for load balancers and clients to utilize.
   */
  @JsonProperty("addresses")
  @Singular(value = "addToAddresses", ignoreNullCollections = true)
  private List<EndpointAddress> addresses;

  /**
   * IP addresses which offer the related ports but are not currently marked as ready because they have not yet finished starting, have recently failed a readiness check, or have recently failed a liveness check.
   */
  @JsonProperty("notReadyAddresses")
  @Singular(value = "addToNotReadyAddresses", ignoreNullCollections = true)
  private List<EndpointAddress> notReadyAddresses;

  /**
   * Port numbers available on the related IP addresses.
   */
  @JsonProperty("ports")
  @Singular(value = "addToPorts", ignoreNullCollections = true)
  private List<EndpointPort> ports;

}

