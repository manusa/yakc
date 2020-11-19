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

package com.marcnuri.yakc.model.io.istio.security.v1beta1;

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
 * Source specifies the source of a request.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthorizationPolicySpecSource implements Model {


  /**
   * Optional.
   */
  @JsonProperty("ipBlocks")
  @Singular(value = "addToIpBlocks", ignoreNullCollections = true)
  private List<String> ipBlocks;

  /**
   * Optional.
   */
  @JsonProperty("namespaces")
  @Singular(value = "addToNamespaces", ignoreNullCollections = true)
  private List<String> namespaces;

  /**
   * Optional.
   */
  @JsonProperty("notIpBlocks")
  @Singular(value = "addToNotIpBlocks", ignoreNullCollections = true)
  private List<String> notIpBlocks;

  /**
   * Optional.
   */
  @JsonProperty("notNamespaces")
  @Singular(value = "addToNotNamespaces", ignoreNullCollections = true)
  private List<String> notNamespaces;

  /**
   * Optional.
   */
  @JsonProperty("notPrincipals")
  @Singular(value = "addToNotPrincipals", ignoreNullCollections = true)
  private List<String> notPrincipals;

  /**
   * Optional.
   */
  @JsonProperty("notRequestPrincipals")
  @Singular(value = "addToNotRequestPrincipals", ignoreNullCollections = true)
  private List<String> notRequestPrincipals;

  /**
   * Optional.
   */
  @JsonProperty("principals")
  @Singular(value = "addToPrincipals", ignoreNullCollections = true)
  private List<String> principals;

  /**
   * Optional.
   */
  @JsonProperty("requestPrincipals")
  @Singular(value = "addToRequestPrincipals", ignoreNullCollections = true)
  private List<String> requestPrincipals;

}

