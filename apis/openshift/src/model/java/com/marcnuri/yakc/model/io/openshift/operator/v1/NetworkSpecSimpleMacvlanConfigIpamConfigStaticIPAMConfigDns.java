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
 * DNS configures DNS for the interface
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecSimpleMacvlanConfigIpamConfigStaticIPAMConfigDns implements Model {


  /**
   * Domain configures the domainname the local domain used for short hostname lookups
   */
  @JsonProperty("domain")
  private String domain;

  /**
   * Nameservers points DNS servers for IP lookup
   */
  @JsonProperty("nameservers")
  @Singular(value = "addToNameservers", ignoreNullCollections = true)
  private List<String> nameservers;

  /**
   * Search configures priority ordered search domains for short hostname lookups
   */
  @JsonProperty("search")
  @Singular(value = "addToSearch", ignoreNullCollections = true)
  private List<String> search;

}

