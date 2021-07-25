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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

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
 * GCPChaosSpec is the content of the specification for a GCPChaos
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GCPChaosSpec implements Model {


  /**
   * Action defines the specific gcp chaos action. Supported action: node-stop / node-reset / disk-loss Default action: node-stop
   */
  @NonNull
  @JsonProperty("action")
  private String action;

  /**
   * The device name of disks to detach. Needed in disk-loss.
   */
  @JsonProperty("deviceNames")
  @Singular(value = "addToDeviceNames", ignoreNullCollections = true)
  private List<String> deviceNames;

  /**
   * Duration represents the duration of the chaos action.
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * Instance defines the name of the instance
   */
  @NonNull
  @JsonProperty("instance")
  private String instance;

  /**
   * Project defines the name of gcp project.
   */
  @NonNull
  @JsonProperty("project")
  private String project;

  /**
   * SecretName defines the name of kubernetes secret. It is used for GCP credentials.
   */
  @JsonProperty("secretName")
  private String secretName;

  /**
   * Zone defines the zone of gcp project.
   */
  @NonNull
  @JsonProperty("zone")
  private String zone;

}

