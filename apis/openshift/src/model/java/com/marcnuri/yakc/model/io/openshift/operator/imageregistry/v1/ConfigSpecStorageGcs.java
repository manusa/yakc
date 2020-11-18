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
 * gcs represents configuration that uses Google Cloud Storage.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigSpecStorageGcs implements Model {


  /**
   * bucket is the bucket name in which you want to store the registry's data. Optional, will be generated if not provided.
   */
  @JsonProperty("bucket")
  private String bucket;

  /**
   * keyID is the KMS key ID to use for encryption. Optional, buckets are encrypted by default on GCP. This allows for the use of a custom encryption key.
   */
  @JsonProperty("keyID")
  private String keyID;

  /**
   * projectID is the Project ID of the GCP project that this bucket should be associated with.
   */
  @JsonProperty("projectID")
  private String projectID;

  /**
   * region is the GCS location in which your bucket exists. Optional, will be set based on the installed GCS Region.
   */
  @JsonProperty("region")
  private String region;

}

