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

package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1;

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
 * CustomResourceDefinitionVersion describes a version for CRD.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomResourceDefinitionVersion implements Model {


  /**
   * additionalPrinterColumns specifies additional columns returned in Table output. See https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. If no columns are specified, a single column displaying the age of the custom resource is used.
   */
  @JsonProperty("additionalPrinterColumns")
  @Singular(value = "addToAdditionalPrinterColumns", ignoreNullCollections = true)
  private List<CustomResourceColumnDefinition> additionalPrinterColumns;

  /**
   * deprecated indicates this version of the custom resource API is deprecated. When set to true, API requests to this version receive a warning header in the server response. Defaults to false.
   */
  @JsonProperty("deprecated")
  private Boolean deprecated;

  /**
   * deprecationWarning overrides the default warning returned to API clients. May only be set when `deprecated` is true. The default warning indicates this version is deprecated and recommends use of the newest served version of equal or greater stability, if one exists.
   */
  @JsonProperty("deprecationWarning")
  private String deprecationWarning;

  /**
   * name is the version name, e.g. "v1", "v2beta1", etc. The custom resources are served under this version at `/apis/&lt;group&gt;/&lt;version&gt;/...` if `served` is true.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("schema")
  private CustomResourceValidation schema;

  /**
   * served is a flag enabling/disabling this version from being served via REST APIs
   */
  @NonNull
  @JsonProperty("served")
  private Boolean served;

  /**
   * storage indicates this version should be used when persisting custom resources to storage. There must be exactly one version with storage=true.
   */
  @NonNull
  @JsonProperty("storage")
  private Boolean storage;

  @JsonProperty("subresources")
  private CustomResourceSubresources subresources;

}

