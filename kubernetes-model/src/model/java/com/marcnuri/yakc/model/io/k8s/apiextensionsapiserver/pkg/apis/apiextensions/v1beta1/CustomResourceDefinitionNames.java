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

package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1beta1;

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
 * CustomResourceDefinitionNames indicates the names to serve this CustomResourceDefinition
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomResourceDefinitionNames implements Model {


  /**
   * categories is a list of grouped resources this custom resource belongs to (e.g. 'all'). This is published in API discovery documents, and used by clients to support invocations like `kubectl get all`.
   */
  @JsonProperty("categories")
  @Singular(value = "addToCategories", ignoreNullCollections = true)
  private List<String> categories;

  /**
   * kind is the serialized kind of the resource. It is normally CamelCase and singular. Custom resource instances will use this value as the `kind` attribute in API calls.
   */
  @NonNull
  @JsonProperty("kind")
  private String kind;

  /**
   * listKind is the serialized kind of the list for this resource. Defaults to "`kind`List".
   */
  @JsonProperty("listKind")
  private String listKind;

  /**
   * plural is the plural name of the resource to serve. The custom resources are served under `/apis/&lt;group&gt;/&lt;version&gt;/.../&lt;plural&gt;`. Must match the name of the CustomResourceDefinition (in the form `&lt;names.plural&gt;.&lt;group&gt;`). Must be all lowercase.
   */
  @NonNull
  @JsonProperty("plural")
  private String plural;

  /**
   * shortNames are short names for the resource, exposed in API discovery documents, and used by clients to support invocations like `kubectl get &lt;shortname&gt;`. It must be all lowercase.
   */
  @JsonProperty("shortNames")
  @Singular(value = "addToShortNames", ignoreNullCollections = true)
  private List<String> shortNames;

  /**
   * singular is the singular name of the resource. It must be all lowercase. Defaults to lowercased `kind`.
   */
  @JsonProperty("singular")
  private String singular;

}

