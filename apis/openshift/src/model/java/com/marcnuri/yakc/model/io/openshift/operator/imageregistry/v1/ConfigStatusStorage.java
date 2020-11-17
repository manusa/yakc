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

package com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * storage indicates the current applied storage configuration of the registry.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigStatusStorage implements Model {


  @JsonProperty("azure")
  private ConfigSpecStorageAzure azure;

  /**
   * emptyDir represents ephemeral storage on the pod's host node. WARNING: this storage cannot be used with more than 1 replica and is not suitable for production use. When the pod is removed from a node for any reason, the data in the emptyDir is deleted forever.
   */
  @JsonProperty("emptyDir")
  private Object emptyDir;

  @JsonProperty("gcs")
  private ConfigSpecStorageGcs gcs;

  @JsonProperty("pvc")
  private ConfigSpecStoragePvc pvc;

  @JsonProperty("s3")
  private ConfigSpecStorageS3 s3;

  @JsonProperty("swift")
  private ConfigSpecStorageSwift swift;

}

