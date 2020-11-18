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

package com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1;

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
 * APIResource specifies the name of a resource and whether it is namespaced.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class APIResource implements Model {


  /**
   * categories is a list of the grouped resources this resource belongs to (e.g. 'all')
   */
  @JsonProperty("categories")
  @Singular(value = "addToCategories", ignoreNullCollections = true)
  private List<String> categories;

  /**
   * group is the preferred group of the resource.  Empty implies the group of the containing resource list. For subresources, this may have a different value, for example: Scale".
   */
  @JsonProperty("group")
  private String group;

  /**
   * kind is the kind for the resource (e.g. 'Foo' is the kind for a resource 'foo')
   */
  @NonNull
  @JsonProperty("kind")
  private String kind;

  /**
   * name is the plural name of the resource.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * namespaced indicates if a resource is namespaced or not.
   */
  @NonNull
  @JsonProperty("namespaced")
  private Boolean namespaced;

  /**
   * shortNames is a list of suggested short names of the resource.
   */
  @JsonProperty("shortNames")
  @Singular(value = "addToShortNames", ignoreNullCollections = true)
  private List<String> shortNames;

  /**
   * singularName is the singular name of the resource.  This allows clients to handle plural and singular opaquely. The singularName is more correct for reporting status on a single item and both singular and plural are allowed from the kubectl CLI interface.
   */
  @NonNull
  @JsonProperty("singularName")
  private String singularName;

  /**
   * The hash value of the storage version, the version this resource is converted to when written to the data store. Value must be treated as opaque by clients. Only equality comparison on the value is valid. This is an alpha feature and may change or be removed in the future. The field is populated by the apiserver only if the StorageVersionHash feature gate is enabled. This field will remain optional even if it graduates.
   */
  @JsonProperty("storageVersionHash")
  private String storageVersionHash;

  /**
   * verbs is a list of supported kube verbs (this includes get, list, watch, create, update, patch, delete, deletecollection, and proxy)
   */
  @NonNull
  @JsonProperty("verbs")
  @Singular(value = "addToVerbs", ignoreNullCollections = true)
  private List<String> verbs;

  /**
   * version is the preferred version of the resource.  Empty implies the version of the containing resource list For subresources, this may have a different value, for example: v1 (while inside a v1beta1 version of the core resource's group)".
   */
  @JsonProperty("version")
  private String version;

}

