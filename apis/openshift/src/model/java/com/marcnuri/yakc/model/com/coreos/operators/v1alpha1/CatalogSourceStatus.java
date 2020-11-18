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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CatalogSourceStatus implements Model {


  @JsonProperty("configMapReference")
  private CatalogSourceStatusConfigMapReference configMapReference;

  @JsonProperty("connectionState")
  private CatalogSourceStatusConnectionState connectionState;

  /**
   * The last time the CatalogSource image registry has been polled to ensure the image is up-to-date
   */
  @JsonProperty("latestImageRegistryPoll")
  private OffsetDateTime latestImageRegistryPoll;

  /**
   * A human readable message indicating details about why the ClusterServiceVersion is in this condition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * Reason is the reason the Subscription was transitioned to its current state.
   */
  @JsonProperty("reason")
  private String reason;

  @JsonProperty("registryService")
  private CatalogSourceStatusRegistryService registryService;

}

