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

package com.marcnuri.yakc.model.io.certmanager.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Use the AWS Route53 API to manage DNS01 challenge records.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeDns01Route53 implements Model {


  /**
   * The AccessKeyID is used for authentication. If not set we fall-back to using env vars, shared credentials file or AWS Instance metadata see: https://docs.aws.amazon.com/sdk-for-go/v1/developer-guide/configuring-sdk.html#specifying-credentials
   */
  @JsonProperty("accessKeyID")
  private String accessKeyID;

  /**
   * If set, the provider will manage only this zone in Route53 and will not do an lookup using the route53:ListHostedZonesByName api call.
   */
  @JsonProperty("hostedZoneID")
  private String hostedZoneID;

  /**
   * Always set the region when using AccessKeyID and SecretAccessKey
   */
  @NonNull
  @JsonProperty("region")
  private String region;

  /**
   * Role is a Role ARN which the Route53 provider will assume using either the explicit credentials AccessKeyID/SecretAccessKey or the inferred credentials from environment variables, shared credentials file or AWS Instance metadata
   */
  @JsonProperty("role")
  private String role;

  @JsonProperty("secretAccessKeySecretRef")
  private ClusterIssuerSpecAcmeDns01Route53SecretAccessKeySecretRef secretAccessKeySecretRef;

}

