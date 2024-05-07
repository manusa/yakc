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

package com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1;

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
 * NamedRuleWithOperations is a tuple of Operations and Resources with ResourceNames.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NamedRuleWithOperations implements Model {


  /**
   * APIGroups is the API groups the resources belong to. '&#42;' is all groups. If '&#42;' is present, the length of the slice must be one. Required.
   */
  @JsonProperty("apiGroups")
  @Singular(value = "addToApiGroups", ignoreNullCollections = true)
  private List<String> apiGroups;

  /**
   * APIVersions is the API versions the resources belong to. '&#42;' is all versions. If '&#42;' is present, the length of the slice must be one. Required.
   */
  @JsonProperty("apiVersions")
  @Singular(value = "addToApiVersions", ignoreNullCollections = true)
  private List<String> apiVersions;

  /**
   * Operations is the operations the admission hook cares about - CREATE, UPDATE, DELETE, CONNECT or &#42; for all of those operations and any future admission operations that are added. If '&#42;' is present, the length of the slice must be one. Required.
   */
  @JsonProperty("operations")
  @Singular(value = "addToOperations", ignoreNullCollections = true)
  private List<String> operations;

  /**
   * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.
   */
  @JsonProperty("resourceNames")
  @Singular(value = "addToResourceNames", ignoreNullCollections = true)
  private List<String> resourceNames;

  /**
   * Resources is a list of resources this rule applies to.<br><p> <br><p> For example: 'pods' means pods. 'pods/log' means the log subresource of pods. '&#42;' means all resources, but not subresources. 'pods/&#42;' means all subresources of pods. '&#42;/scale' means all scale subresources. '&#42;/&#42;' means all resources and their subresources.<br><p> <br><p> If wildcard is present, the validation rule will ensure resources do not overlap with each other.<br><p> <br><p> Depending on the enclosing object, subresources might not be allowed. Required.
   */
  @JsonProperty("resources")
  @Singular(value = "addToResources", ignoreNullCollections = true)
  private List<String> resources;

  /**
   * scope specifies the scope of this rule. Valid values are "Cluster", "Namespaced", and "&#42;" "Cluster" means that only cluster-scoped resources will match this rule. Namespace API objects are cluster-scoped. "Namespaced" means that only namespaced resources will match this rule. "&#42;" means that there are no scope restrictions. Subresources match the scope of their parent resource. Default is "&#42;".
   */
  @JsonProperty("scope")
  private String scope;

}

