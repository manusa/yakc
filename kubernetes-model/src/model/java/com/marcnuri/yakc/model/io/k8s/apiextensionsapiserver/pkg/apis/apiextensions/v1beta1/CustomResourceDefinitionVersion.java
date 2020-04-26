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
   * additionalPrinterColumns specifies additional columns returned in Table output. See https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. Top-level and per-version columns are mutually exclusive. Per-version columns must not all be set to identical values (top-level columns should be used instead). If no top-level or per-version columns are specified, a single column displaying the age of the custom resource is used.
   */
  @JsonProperty("additionalPrinterColumns")
  @Singular(value = "addToAdditionalPrinterColumns", ignoreNullCollections = true)
  private List<CustomResourceColumnDefinition> additionalPrinterColumns;

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

