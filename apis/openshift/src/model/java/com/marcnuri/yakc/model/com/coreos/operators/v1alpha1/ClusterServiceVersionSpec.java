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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * ClusterServiceVersionSpec declarations tell OLM how to install an operator that can manage apps for a given version.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterServiceVersionSpec implements Model {


  /**
   * Annotations is an unstructured key value map stored with a resource that may be set by external tools to store and retrieve arbitrary metadata.
   */
  @JsonProperty("annotations")
  @Singular(value = "putInAnnotations", ignoreNullCollections = true)
  private Map<String, String> annotations;

  @JsonProperty("apiservicedefinitions")
  private ClusterServiceVersionSpecApiservicedefinitions apiservicedefinitions;

  @JsonProperty("customresourcedefinitions")
  private ClusterServiceVersionSpecCustomresourcedefinitions customresourcedefinitions;

  @JsonProperty("description")
  private String description;

  @NonNull
  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("icon")
  @Singular(value = "addToIcon", ignoreNullCollections = true)
  private List<CatalogSourceSpecIcon> icon;

  @NonNull
  @JsonProperty("install")
  private ClusterServiceVersionSpecInstall install;

  /**
   * InstallModes specify supported installation types
   */
  @JsonProperty("installModes")
  @Singular(value = "addToInstallModes", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecInstallModes> installModes;

  @JsonProperty("keywords")
  @Singular(value = "addToKeywords", ignoreNullCollections = true)
  private List<String> keywords;

  /**
   * Map of string keys and values that can be used to organize and categorize (scope and select) objects.
   */
  @JsonProperty("labels")
  @Singular(value = "putInLabels", ignoreNullCollections = true)
  private Map<String, String> labels;

  @JsonProperty("links")
  @Singular(value = "addToLinks", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecLinks> links;

  @JsonProperty("maintainers")
  @Singular(value = "addToMaintainers", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecMaintainers> maintainers;

  @JsonProperty("maturity")
  private String maturity;

  @JsonProperty("minKubeVersion")
  private String minKubeVersion;

  @JsonProperty("nativeAPIs")
  @Singular(value = "addToNativeAPIs", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecNativeAPIs> nativeAPIs;

  @JsonProperty("provider")
  private ClusterServiceVersionSpecLinks provider;

  /**
   * The name of a CSV this one replaces. Should match the `metadata.Name` field of the old CSV.
   */
  @JsonProperty("replaces")
  private String replaces;

  @JsonProperty("selector")
  private ClusterServiceVersionSpecSelector selector;

  /**
   * OperatorVersion is a wrapper around semver.Version which supports correct marshaling to YAML and JSON.
   */
  @JsonProperty("version")
  private String version;

}

