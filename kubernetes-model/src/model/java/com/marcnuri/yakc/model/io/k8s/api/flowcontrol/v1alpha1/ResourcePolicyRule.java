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

package com.marcnuri.yakc.model.io.k8s.api.flowcontrol.v1alpha1;

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
 * ResourcePolicyRule is a predicate that matches some resource requests, testing the request's verb and the target resource. A ResourcePolicyRule matches a resource request if and only if: (a) at least one member of verbs matches the request, (b) at least one member of apiGroups matches the request, (c) at least one member of resources matches the request, and (d) least one member of namespaces matches the request.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourcePolicyRule implements Model {


  /**
   * `apiGroups` is a list of matching API groups and may not be empty. "&#42;" matches all API groups and, if present, must be the only entry. Required.
   */
  @NonNull
  @JsonProperty("apiGroups")
  @Singular("addToApiGroups")
  private List<String> apiGroups;

  /**
   * `clusterScope` indicates whether to match requests that do not specify a namespace (which happens either because the resource is not namespaced or the request targets all namespaces). If this field is omitted or false then the `namespaces` field must contain a non-empty list.
   */
  @JsonProperty("clusterScope")
  private Boolean clusterScope;

  /**
   * `namespaces` is a list of target namespaces that restricts matches.  A request that specifies a target namespace matches only if either (a) this list contains that target namespace or (b) this list contains "&#42;".  Note that "&#42;" matches any specified namespace but does not match a request that _does not specify_ a namespace (see the `clusterScope` field for that). This list may be empty, but only if `clusterScope` is true.
   */
  @JsonProperty("namespaces")
  @Singular("addToNamespaces")
  private List<String> namespaces;

  /**
   * `resources` is a list of matching resources (i.e., lowercase and plural) with, if desired, subresource.  For example, [ "services", "nodes/status" ].  This list may not be empty. "&#42;" matches all resources and, if present, must be the only entry. Required.
   */
  @NonNull
  @JsonProperty("resources")
  @Singular("addToResources")
  private List<String> resources;

  /**
   * `verbs` is a list of matching verbs and may not be empty. "&#42;" matches all verbs and, if present, must be the only entry. Required.
   */
  @NonNull
  @JsonProperty("verbs")
  @Singular("addToVerbs")
  private List<String> verbs;

}

