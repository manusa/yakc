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
 * InstallPlanStatus represents the information about the status of steps required to complete installation. <br><p>  Status may trail the actual state of a system.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InstallPlanStatus implements Model {


  @JsonProperty("attenuatedServiceAccountRef")
  private InstallPlanStatusAttenuatedServiceAccountRef attenuatedServiceAccountRef;

  /**
   * BundleLookups is the set of in-progress requests to pull and unpackage bundle content to the cluster.
   */
  @JsonProperty("bundleLookups")
  @Singular(value = "addToBundleLookups", ignoreNullCollections = true)
  private List<InstallPlanStatusBundleLookups> bundleLookups;

  @NonNull
  @JsonProperty("catalogSources")
  @Singular(value = "addToCatalogSources", ignoreNullCollections = true)
  private List<String> catalogSources;

  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<InstallPlanStatusConditions_1> conditions;

  /**
   * InstallPlanPhase is the current status of a InstallPlan as a whole.
   */
  @NonNull
  @JsonProperty("phase")
  private String phase;

  @JsonProperty("plan")
  @Singular(value = "addToPlan", ignoreNullCollections = true)
  private List<InstallPlanStatusPlan> plan;

}

