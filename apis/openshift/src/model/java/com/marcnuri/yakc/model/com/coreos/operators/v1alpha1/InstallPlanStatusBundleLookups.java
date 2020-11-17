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

package com.marcnuri.yakc.model.com.coreos.operators.v1alpha1;

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
 * BundleLookup is a request to pull and unpackage the content of a bundle to the cluster.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InstallPlanStatusBundleLookups implements Model {


  @NonNull
  @JsonProperty("catalogSourceRef")
  private InstallPlanStatusCatalogSourceRef catalogSourceRef;

  /**
   * Conditions represents the overall state of a BundleLookup.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<InstallPlanStatusConditions> conditions;

  /**
   * Identifier is the catalog-unique name of the operator (the name of the CSV for bundles that contain CSVs)
   */
  @NonNull
  @JsonProperty("identifier")
  private String identifier;

  /**
   * Path refers to the location of a bundle to pull. It's typically an image reference.
   */
  @NonNull
  @JsonProperty("path")
  private String path;

  /**
   * Replaces is the name of the bundle to replace with the one found at Path.
   */
  @NonNull
  @JsonProperty("replaces")
  private String replaces;

}

