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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ResourceRequirements describes the compute resource requirements.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourceRequirements implements Model {


  /**
   * Claims lists the names of resources, defined in spec.resourceClaims, that are used by this container.<br><p> <br><p> This is an alpha field and requires enabling the DynamicResourceAllocation feature gate.<br><p> <br><p> This field is immutable. It can only be set for containers.
   */
  @JsonProperty("claims")
  @Singular(value = "addToClaims", ignoreNullCollections = true)
  private List<ResourceClaim> claims;

  /**
   * Limits describes the maximum amount of compute resources allowed. More info: https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/
   */
  @JsonProperty("limits")
  @Singular(value = "putInLimits", ignoreNullCollections = true)
  private Map<String, String> limits;

  /**
   * Requests describes the minimum amount of compute resources required. If Requests is omitted for a container, it defaults to Limits if that is explicitly specified, otherwise to an implementation-defined value. More info: https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/
   */
  @JsonProperty("requests")
  @Singular(value = "putInRequests", ignoreNullCollections = true)
  private Map<String, String> requests;

}

