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
 * policy is a set of restrictions applied to the ExternalIP field. If nil or empty, then ExternalIP is not allowed to be set.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecExternalIPPolicy implements Model {


  /**
   * allowedCIDRs is the list of allowed CIDRs.
   */
  @JsonProperty("allowedCIDRs")
  @Singular(value = "addToAllowedCIDRs", ignoreNullCollections = true)
  private List<String> allowedCIDRs;

  /**
   * rejectedCIDRs is the list of disallowed CIDRs. These take precedence over allowedCIDRs.
   */
  @JsonProperty("rejectedCIDRs")
  @Singular(value = "addToRejectedCIDRs", ignoreNullCollections = true)
  private List<String> rejectedCIDRs;

}

