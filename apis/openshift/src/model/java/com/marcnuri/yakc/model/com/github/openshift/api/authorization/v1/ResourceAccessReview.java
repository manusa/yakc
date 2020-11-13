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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ResourceAccessReview is a means to request a list of which users and groups are authorized to perform the action specified by spec
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourceAccessReview implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  @JsonProperty("content")
  private RawExtension content;

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
   * Verb is one of: get, list, watch, create, update, delete
   */
  @NonNull
  @JsonProperty("verb")
  private String verb;

}

