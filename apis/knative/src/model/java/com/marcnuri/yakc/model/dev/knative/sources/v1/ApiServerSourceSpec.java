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

package com.marcnuri.yakc.model.dev.knative.sources.v1;

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
 * ApiServerSourceSpec defines the desired state of ApiServerSource (from the client).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ApiServerSourceSpec implements Model {


  @JsonProperty("ceOverrides")
  private ApiServerSourceSpecCeOverrides ceOverrides;

  /**
   * EventMode controls the format of the event. `Reference` sends a dataref event type for the resource under watch. `Resource` send the full resource lifecycle event. Defaults to `Reference`
   */
  @JsonProperty("mode")
  private String mode;

  @JsonProperty("owner")
  private ApiServerSourceSpecOwner owner;

  /**
   * Resource are the resources this source will track and send related lifecycle events from the Kubernetes ApiServer, with an optional label selector to help filter.
   */
  @NonNull
  @JsonProperty("resources")
  @Singular(value = "addToResources", ignoreNullCollections = true)
  private List<ApiServerSourceSpecResources> resources;

  /**
   * ServiceAccountName is the name of the ServiceAccount to use to run this source. Defaults to default if not set.
   */
  @JsonProperty("serviceAccountName")
  private String serviceAccountName;

  @JsonProperty("sink")
  private ApiServerSourceSpecSink sink;

}

