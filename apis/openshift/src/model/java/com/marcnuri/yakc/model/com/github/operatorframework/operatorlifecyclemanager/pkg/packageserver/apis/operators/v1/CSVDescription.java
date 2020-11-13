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

package com.marcnuri.yakc.model.com.github.operatorframework.operatorlifecyclemanager.pkg.packageserver.apis.operators.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.com.github.operatorframework.operatorlifecyclemanager.pkg.api.apis.operators.v1alpha1.APIServiceDefinitions;
import com.marcnuri.yakc.model.com.github.operatorframework.operatorlifecyclemanager.pkg.api.apis.operators.v1alpha1.CustomResourceDefinitions;
import com.marcnuri.yakc.model.com.github.operatorframework.operatorlifecyclemanager.pkg.api.apis.operators.v1alpha1.InstallMode;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * CSVDescription defines a description of a CSV
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CSVDescription implements Model {


  @JsonProperty("annotations")
  @Singular(value = "putInAnnotations", ignoreNullCollections = true)
  private Map<String, String> annotations;

  @JsonProperty("apiservicedefinitions")
  private APIServiceDefinitions apiservicedefinitions;

  @JsonProperty("customresourcedefinitions")
  private CustomResourceDefinitions customresourcedefinitions;

  /**
   * LongDescription is the CSV's description
   */
  @JsonProperty("description")
  private String description;

  /**
   * DisplayName is the CSV's display name
   */
  @JsonProperty("displayName")
  private String displayName;

  /**
   * Icon is the CSV's base64 encoded icon
   */
  @JsonProperty("icon")
  @Singular(value = "addToIcon", ignoreNullCollections = true)
  private List<Icon> icon;

  /**
   * InstallModes specify supported installation types
   */
  @JsonProperty("installModes")
  @Singular(value = "addToInstallModes", ignoreNullCollections = true)
  private List<InstallMode> installModes;

  @JsonProperty("provider")
  private AppLink provider;

  @JsonProperty("version")
  private String version;

}

