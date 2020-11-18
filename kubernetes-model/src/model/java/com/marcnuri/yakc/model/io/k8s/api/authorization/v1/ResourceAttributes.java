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

package com.marcnuri.yakc.model.io.k8s.api.authorization.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ResourceAttributes includes the authorization attributes available for resource requests to the Authorizer interface
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourceAttributes implements Model {


  /**
   * Group is the API Group of the Resource.  "&#42;" means all.
   */
  @JsonProperty("group")
  private String group;

  /**
   * Name is the name of the resource being requested for a "get" or deleted for a "delete". "" (empty) means all.
   */
  @JsonProperty("name")
  private String name;

  /**
   * Namespace is the namespace of the action being requested.  Currently, there is no distinction between no namespace and all namespaces "" (empty) is defaulted for LocalSubjectAccessReviews "" (empty) is empty for cluster-scoped resources "" (empty) means "all" for namespace scoped resources from a SubjectAccessReview or SelfSubjectAccessReview
   */
  @JsonProperty("namespace")
  private String namespace;

  /**
   * Resource is one of the existing resource types.  "&#42;" means all.
   */
  @JsonProperty("resource")
  private String resource;

  /**
   * Subresource is one of the existing resource types.  "" means none.
   */
  @JsonProperty("subresource")
  private String subresource;

  /**
   * Verb is a kubernetes resource API verb, like: get, list, watch, create, update, delete, proxy.  "&#42;" means all.
   */
  @JsonProperty("verb")
  private String verb;

  /**
   * Version is the API Version of the Resource.  "&#42;" means all.
   */
  @JsonProperty("version")
  private String version;

}

