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

package com.marcnuri.yakc.model.com.github.openshift.api.oauth.v1;

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
 * ClusterRoleScopeRestriction describes restrictions on cluster role scopes
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterRoleScopeRestriction implements Model {


  /**
   * AllowEscalation indicates whether you can request roles and their escalating resources
   */
  @NonNull
  @JsonProperty("allowEscalation")
  private Boolean allowEscalation;

  /**
   * Namespaces is the list of namespaces that can be referenced.  &#42; means any of them (including &#42;)
   */
  @NonNull
  @JsonProperty("namespaces")
  @Singular(value = "addToNamespaces", ignoreNullCollections = true)
  private List<String> namespaces;

  /**
   * RoleNames is the list of cluster roles that can referenced.  &#42; means anything
   */
  @NonNull
  @JsonProperty("roleNames")
  @Singular(value = "addToRoleNames", ignoreNullCollections = true)
  private List<String> roleNames;

}

