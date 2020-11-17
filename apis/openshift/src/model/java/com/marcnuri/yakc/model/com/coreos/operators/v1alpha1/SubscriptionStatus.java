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
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SubscriptionStatus implements Model {


  /**
   * CatalogHealth contains the Subscription's view of its relevant CatalogSources' status. It is used to determine SubscriptionStatusConditions related to CatalogSources.
   */
  @JsonProperty("catalogHealth")
  @Singular(value = "addToCatalogHealth", ignoreNullCollections = true)
  private List<SubscriptionStatusCatalogHealth> catalogHealth;

  /**
   * Conditions is a list of the latest available observations about a Subscription's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<SubscriptionStatusConditions> conditions;

  /**
   * CurrentCSV is the CSV the Subscription is progressing to.
   */
  @JsonProperty("currentCSV")
  private String currentCSV;

  /**
   * InstallPlanGeneration is the current generation of the installplan
   */
  @JsonProperty("installPlanGeneration")
  private Number installPlanGeneration;

  @JsonProperty("installPlanRef")
  private SubscriptionStatusInstallPlanRef installPlanRef;

  /**
   * InstalledCSV is the CSV currently installed by the Subscription.
   */
  @JsonProperty("installedCSV")
  private String installedCSV;

  @JsonProperty("installplan")
  private SubscriptionStatusInstallplan installplan;

  /**
   * LastUpdated represents the last time that the Subscription status was updated.
   */
  @NonNull
  @JsonProperty("lastUpdated")
  private OffsetDateTime lastUpdated;

  /**
   * Reason is the reason the Subscription was transitioned to its current state.
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * State represents the current state of the Subscription
   */
  @JsonProperty("state")
  private String state;

}

