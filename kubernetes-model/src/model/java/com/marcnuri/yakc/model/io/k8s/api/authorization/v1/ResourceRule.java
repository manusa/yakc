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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * ResourceRule is the list of actions the subject is allowed to perform on resources. The list ordering isn't significant, may contain duplicates, and possibly be incomplete.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourceRule implements Model {


  /**
   * APIGroups is the name of the APIGroup that contains the resources.  If multiple API groups are specified, any action requested against one of the enumerated resources in any API group will be allowed.  "&#42;" means all.
   */
  @JsonProperty("apiGroups")
  @Singular(value = "addToApiGroups", ignoreNullCollections = true)
  private List<String> apiGroups;

  /**
   * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.  "&#42;" means all.
   */
  @JsonProperty("resourceNames")
  @Singular(value = "addToResourceNames", ignoreNullCollections = true)
  private List<String> resourceNames;

  /**
   * Resources is a list of resources this rule applies to.  "&#42;" means all in the specified apiGroups.<br><p>  "&#42;/foo" represents the subresource 'foo' for all resources in the specified apiGroups.
   */
  @JsonProperty("resources")
  @Singular(value = "addToResources", ignoreNullCollections = true)
  private List<String> resources;

  /**
   * Verb is a list of kubernetes resource API verbs, like: get, list, watch, create, update, delete, proxy.  "&#42;" means all.
   */
  @NonNull
  @JsonProperty("verbs")
  @Singular(value = "addToVerbs", ignoreNullCollections = true)
  private List<String> verbs;

}

