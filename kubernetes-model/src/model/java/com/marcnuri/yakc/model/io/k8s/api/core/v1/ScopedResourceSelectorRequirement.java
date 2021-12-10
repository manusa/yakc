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
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * A scoped-resource selector requirement is a selector that contains values, a scope name, and an operator that relates the scope name and values.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScopedResourceSelectorRequirement implements Model {


  /**
   * Represents a scope's relationship to a set of values. Valid operators are In, NotIn, Exists, DoesNotExist.<br><p> <br><p> Possible enum values:<br><p>  - `"DoesNotExist"`<br><p>  - `"Exists"`<br><p>  - `"In"`<br><p>  - `"NotIn"`
   */
  @NonNull
  @JsonProperty("operator")
  private String operator;

  /**
   * The name of the scope that the selector applies to.<br><p> <br><p> Possible enum values:<br><p>  - `"BestEffort"` Match all pod objects that have best effort quality of service<br><p>  - `"CrossNamespacePodAffinity"` Match all pod objects that have cross-namespace pod (anti)affinity mentioned. This is a beta feature enabled by the PodAffinityNamespaceSelector feature flag.<br><p>  - `"NotBestEffort"` Match all pod objects that do not have best effort quality of service<br><p>  - `"NotTerminating"` Match all pod objects where spec.activeDeadlineSeconds is nil<br><p>  - `"PriorityClass"` Match all pod objects that have priority class mentioned<br><p>  - `"Terminating"` Match all pod objects where spec.activeDeadlineSeconds &gt;=0
   */
  @NonNull
  @JsonProperty("scopeName")
  private String scopeName;

  /**
   * An array of string values. If the operator is In or NotIn, the values array must be non-empty. If the operator is Exists or DoesNotExist, the values array must be empty. This array is replaced during a strategic merge patch.
   */
  @JsonProperty("values")
  @Singular(value = "addToValues", ignoreNullCollections = true)
  private List<String> values;

}

