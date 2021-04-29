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
 * AwsChaosSpec is the content of the specification for an AwsChaos
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AwsChaosSpec implements Model {


  /**
   * Action defines the specific aws chaos action. Supported action: ec2-stop / ec2-restart / detach-volume Default action: ec2-stop
   */
  @NonNull
  @JsonProperty("action")
  private String action;

  /**
   * AwsRegion defines the region of aws.
   */
  @NonNull
  @JsonProperty("awsRegion")
  private String awsRegion;

  /**
   * DeviceName indicates the name of the device. Needed in detach-volume.
   */
  @JsonProperty("deviceName")
  private String deviceName;

  /**
   * Duration represents the duration of the chaos action.
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * Ec2Instance indicates the ID of the ec2 instance.
   */
  @NonNull
  @JsonProperty("ec2Instance")
  private String ec2Instance;

  /**
   * Endpoint indicates the endpoint of the aws server. Just used it in test now.
   */
  @JsonProperty("endpoint")
  private String endpoint;

  @JsonProperty("scheduler")
  private AwsChaosSpecScheduler scheduler;

  /**
   * SecretName defines the name of kubernetes secret.
   */
  @JsonProperty("secretName")
  private String secretName;

  /**
   * EbsVolume indicates the ID of the EBS volume. Needed in detach-volume.
   */
  @JsonProperty("volumeID")
  private String volumeID;

}

