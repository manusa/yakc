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
import lombok.NonNull;
import lombok.ToString;

/**
 * cloudFront configures Amazon Cloudfront as the storage middleware in a registry.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigSpecStorageS3CloudFront implements Model {


  /**
   * baseURL contains the SCHEME://HOST[/PATH] at which Cloudfront is served.
   */
  @NonNull
  @JsonProperty("baseURL")
  private String baseURL;

  /**
   * duration is the duration of the Cloudfront session.
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * keypairID is key pair ID provided by AWS.
   */
  @NonNull
  @JsonProperty("keypairID")
  private String keypairID;

  @NonNull
  @JsonProperty("privateKey")
  private ConfigSpecStorageS3CloudFrontPrivateKey privateKey;

}

