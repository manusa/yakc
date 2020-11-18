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

package com.marcnuri.yakc.model.io.openshift.config.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * platformStatus holds status information specific to the underlying infrastructure provider.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InfrastructureStatusPlatformStatus implements Model {


  @JsonProperty("aws")
  private InfrastructureStatusPlatformStatusAws aws;

  @JsonProperty("azure")
  private InfrastructureStatusPlatformStatusAzure azure;

  @JsonProperty("baremetal")
  private InfrastructureStatusPlatformStatusBaremetal baremetal;

  @JsonProperty("gcp")
  private InfrastructureStatusPlatformStatusGcp gcp;

  @JsonProperty("openstack")
  private InfrastructureStatusPlatformStatusOpenstack openstack;

  @JsonProperty("ovirt")
  private InfrastructureStatusPlatformStatusOvirt ovirt;

  /**
   * type is the underlying infrastructure provider for the cluster. This value controls whether infrastructure automation such as service load balancers, dynamic volume provisioning, machine creation and deletion, and other integrations are enabled. If None, no infrastructure automation is enabled. Allowed values are "AWS", "Azure", "BareMetal", "GCP", "Libvirt", "OpenStack", "VSphere", "oVirt", and "None". Individual components may not support all platforms, and must handle unrecognized platforms as None if they do not support that platform.
   */
  @JsonProperty("type")
  private String type;

  @JsonProperty("vsphere")
  private InfrastructureStatusPlatformStatusVsphere vsphere;

}

