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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * StepResource represents the status of a resource to be tracked by an InstallPlan.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InstallPlanStatusResource implements Model {


  @NonNull
  @JsonProperty("group")
  private String group;

  @NonNull
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("manifest")
  private String manifest;

  @NonNull
  @JsonProperty("name")
  private String name;

  @NonNull
  @JsonProperty("sourceName")
  private String sourceName;

  @NonNull
  @JsonProperty("sourceNamespace")
  private String sourceNamespace;

  @NonNull
  @JsonProperty("version")
  private String version;

}

