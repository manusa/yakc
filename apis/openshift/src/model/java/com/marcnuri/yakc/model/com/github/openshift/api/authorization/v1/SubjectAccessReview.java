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

package com.marcnuri.yakc.model.com.github.openshift.api.authorization.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.runtime.RawExtension;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * SubjectAccessReview is an object for requesting information about whether a user or group can perform an action
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SubjectAccessReview implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  @JsonProperty("content")
  private RawExtension content;

  /**
   * GroupsSlice is optional. Groups is the list of groups to which the User belongs.
   */
  @NonNull
  @JsonProperty("groups")
  @Singular(value = "addToGroups", ignoreNullCollections = true)
  private List<String> groups;

  /**
   * IsNonResourceURL is true if this is a request for a non-resource URL (outside of the resource hierarchy)
   */
  @NonNull
  @JsonProperty("isNonResourceURL")
  private Boolean isNonResourceURL;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  /**
   * Namespace is the namespace of the action being requested.  Currently, there is no distinction between no namespace and all namespaces
   */
  @NonNull
  @JsonProperty("namespace")
  private String namespace;

  /**
   * Path is the path of a non resource URL
   */
  @NonNull
  @JsonProperty("path")
  private String path;

  /**
   * Resource is one of the existing resource types
   */
  @NonNull
  @JsonProperty("resource")
  private String resource;

  /**
   * Group is the API group of the resource Serialized as resourceAPIGroup to avoid confusion with the 'groups' field when inlined
   */
  @NonNull
  @JsonProperty("resourceAPIGroup")
  private String resourceAPIGroup;

  /**
   * Version is the API version of the resource Serialized as resourceAPIVersion to avoid confusion with TypeMeta.apiVersion and ObjectMeta.resourceVersion when inlined
   */
  @NonNull
  @JsonProperty("resourceAPIVersion")
  private String resourceAPIVersion;

  /**
   * ResourceName is the name of the resource being requested for a "get" or deleted for a "delete"
   */
  @NonNull
  @JsonProperty("resourceName")
  private String resourceName;

  /**
   * Scopes to use for the evaluation.  Empty means "use the unscoped (full) permissions of the user/groups". Nil for a self-SAR, means "use the scopes on this request". Nil for a regular SAR, means the same as empty.
   */
  @NonNull
  @JsonProperty("scopes")
  @Singular(value = "addToScopes", ignoreNullCollections = true)
  private List<String> scopes;

  /**
   * User is optional. If both User and Groups are empty, the current authenticated user is used.
   */
  @NonNull
  @JsonProperty("user")
  private String user;

  /**
   * Verb is one of: get, list, watch, create, update, delete
   */
  @NonNull
  @JsonProperty("verb")
  private String verb;

}

