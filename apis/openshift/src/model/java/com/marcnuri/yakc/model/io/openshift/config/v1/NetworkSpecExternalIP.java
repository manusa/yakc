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

package com.marcnuri.yakc.model.io.openshift.config.v1;

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
 * externalIP defines configuration for controllers that affect Service.ExternalIP. If nil, then ExternalIP is not allowed to be set.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecExternalIP implements Model {


  /**
   * autoAssignCIDRs is a list of CIDRs from which to automatically assign Service.ExternalIP. These are assigned when the service is of type LoadBalancer. In general, this is only useful for bare-metal clusters. In Openshift 3.x, this was misleadingly called "IngressIPs". Automatically assigned External IPs are not affected by any ExternalIPPolicy rules. Currently, only one entry may be provided.
   */
  @JsonProperty("autoAssignCIDRs")
  @Singular(value = "addToAutoAssignCIDRs", ignoreNullCollections = true)
  private List<String> autoAssignCIDRs;

  @JsonProperty("policy")
  private NetworkSpecExternalIPPolicy policy;

}

