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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * AzureFile represents an Azure File Service mount on the host and bind mount to the pod.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleSpecWorkflowTaskAzureFile implements Model {


  /**
   * Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  /**
   * the name of secret that contains Azure Storage Account Name and Key
   */
  @NonNull
  @JsonProperty("secretName")
  private String secretName;

  /**
   * Share Name
   */
  @NonNull
  @JsonProperty("shareName")
  private String shareName;

}

