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
 * PolicyRule holds information that describes a policy rule, but does not contain information about who the rule applies to or which namespace the rule applies to.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PolicyRule implements Model {


  /**
   * APIGroups is the name of the APIGroup that contains the resources.  If this field is empty, then both kubernetes and origin API groups are assumed. That means that if an action is requested against one of the enumerated resources in either the kubernetes or the origin API group, the request will be allowed
   */
  @NonNull
  @JsonProperty("apiGroups")
  @Singular(value = "addToApiGroups", ignoreNullCollections = true)
  private List<String> apiGroups;

  @JsonProperty("attributeRestrictions")
  private RawExtension attributeRestrictions;

  /**
   * NonResourceURLsSlice is a set of partial urls that a user should have access to.  &#42;s are allowed, but only as the full, final step in the path This name is intentionally different than the internal type so that the DefaultConvert works nicely and because the ordering may be different.
   */
  @JsonProperty("nonResourceURLs")
  @Singular(value = "addToNonResourceURLs", ignoreNullCollections = true)
  private List<String> nonResourceURLs;

  /**
   * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.
   */
  @JsonProperty("resourceNames")
  @Singular(value = "addToResourceNames", ignoreNullCollections = true)
  private List<String> resourceNames;

  /**
   * Resources is a list of resources this rule applies to.  ResourceAll represents all resources.
   */
  @NonNull
  @JsonProperty("resources")
  @Singular(value = "addToResources", ignoreNullCollections = true)
  private List<String> resources;

  /**
   * Verbs is a list of Verbs that apply to ALL the ResourceKinds and AttributeRestrictions contained in this rule.  VerbAll represents all kinds.
   */
  @NonNull
  @JsonProperty("verbs")
  @Singular(value = "addToVerbs", ignoreNullCollections = true)
  private List<String> verbs;

}

