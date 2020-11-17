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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * StaticIPAMConfig configures the static IP address in case of type:IPAMTypeStatic
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecSimpleMacvlanConfigIpamConfigStaticIPAMConfig implements Model {


  /**
   * Addresses configures IP address for the interface
   */
  @JsonProperty("addresses")
  @Singular(value = "addToAddresses", ignoreNullCollections = true)
  private List<NetworkSpecSimpleMacvlanConfigIpamConfigStaticIPAMConfigAddresses> addresses;

  @JsonProperty("dns")
  private NetworkSpecSimpleMacvlanConfigIpamConfigStaticIPAMConfigDns dns;

  /**
   * Routes configures IP routes for the interface
   */
  @JsonProperty("routes")
  @Singular(value = "addToRoutes", ignoreNullCollections = true)
  private List<NetworkSpecSimpleMacvlanConfigIpamConfigStaticIPAMConfigRoutes> routes;

}

