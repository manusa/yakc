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
 * s3 represents configuration that uses Amazon Simple Storage Service.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigSpecStorageS3 implements Model {


  /**
   * bucket is the bucket name in which you want to store the registry's data. Optional, will be generated if not provided.
   */
  @JsonProperty("bucket")
  private String bucket;

  @JsonProperty("cloudFront")
  private ConfigSpecStorageS3CloudFront cloudFront;

  /**
   * encrypt specifies whether the registry stores the image in encrypted format or not. Optional, defaults to false.
   */
  @JsonProperty("encrypt")
  private Boolean encrypt;

  /**
   * keyID is the KMS key ID to use for encryption. Optional, Encrypt must be true, or this parameter is ignored.
   */
  @JsonProperty("keyID")
  private String keyID;

  /**
   * region is the AWS region in which your bucket exists. Optional, will be set based on the installed AWS Region.
   */
  @JsonProperty("region")
  private String region;

  /**
   * regionEndpoint is the endpoint for S3 compatible storage services. Optional, defaults based on the Region that is provided.
   */
  @JsonProperty("regionEndpoint")
  private String regionEndpoint;

}

