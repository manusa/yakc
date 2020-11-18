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
 * ResourceQuotaSpec defines the desired hard limits to enforce for Quota.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourceQuotaSpec implements Model {


  /**
   * hard is the set of desired hard limits for each named resource. More info: https://kubernetes.io/docs/concepts/policy/resource-quotas/
   */
  @JsonProperty("hard")
  @Singular(value = "putInHard", ignoreNullCollections = true)
  private Map<String, String> hard;

  @JsonProperty("scopeSelector")
  private ScopeSelector scopeSelector;

  /**
   * A collection of filters that must match each object tracked by a quota. If not specified, the quota matches all objects.
   */
  @JsonProperty("scopes")
  @Singular(value = "addToScopes", ignoreNullCollections = true)
  private List<String> scopes;

}

