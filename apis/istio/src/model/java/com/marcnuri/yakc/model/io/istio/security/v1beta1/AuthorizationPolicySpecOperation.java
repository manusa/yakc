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
 * Operation specifies the operation of a request.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthorizationPolicySpecOperation implements Model {


  /**
   * Optional.
   */
  @JsonProperty("hosts")
  @Singular(value = "addToHosts", ignoreNullCollections = true)
  private List<String> hosts;

  /**
   * Optional.
   */
  @JsonProperty("methods")
  @Singular(value = "addToMethods", ignoreNullCollections = true)
  private List<String> methods;

  /**
   * Optional.
   */
  @JsonProperty("notHosts")
  @Singular(value = "addToNotHosts", ignoreNullCollections = true)
  private List<String> notHosts;

  /**
   * Optional.
   */
  @JsonProperty("notMethods")
  @Singular(value = "addToNotMethods", ignoreNullCollections = true)
  private List<String> notMethods;

  /**
   * Optional.
   */
  @JsonProperty("notPaths")
  @Singular(value = "addToNotPaths", ignoreNullCollections = true)
  private List<String> notPaths;

  /**
   * Optional.
   */
  @JsonProperty("notPorts")
  @Singular(value = "addToNotPorts", ignoreNullCollections = true)
  private List<String> notPorts;

  /**
   * Optional.
   */
  @JsonProperty("paths")
  @Singular(value = "addToPaths", ignoreNullCollections = true)
  private List<String> paths;

  /**
   * Optional.
   */
  @JsonProperty("ports")
  @Singular(value = "addToPorts", ignoreNullCollections = true)
  private List<String> ports;

}

