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

package com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ControllerConfigSpec is the spec for ControllerConfig resource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ControllerConfigSpec implements Model {


  /**
   * additionalTrustBundle is a certificate bundle that will be added to the nodes trusted certificate store.
   */
  @JsonProperty("additionalTrustBundle")
  private Object additionalTrustBundle;

  /**
   * cloudProvider specifies the cloud provider CA data
   */
  @JsonProperty("cloudProviderCAData")
  private Object cloudProviderCAData;

  /**
   * cloudProviderConfig is the configuration for the given cloud provider
   */
  @JsonProperty("cloudProviderConfig")
  private String cloudProviderConfig;

  /**
   * clusterDNSIP is the cluster DNS IP address
   */
  @JsonProperty("clusterDNSIP")
  private String clusterDNSIP;

  /**
   * etcdCAData specifies the etcd CA data
   */
  @JsonProperty("etcdCAData")
  private String etcdCAData;

  /**
   * etcdDiscoveryDomain specifies the etcd discovery domain
   */
  @JsonProperty("etcdDiscoveryDomain")
  private String etcdDiscoveryDomain;

  /**
   * etcdMetricData specifies the etcd metric CA data
   */
  @JsonProperty("etcdMetricCAData")
  private String etcdMetricCAData;

  /**
   * images is map of images that are used by the controller to render templates under ./templates/
   */
  @JsonProperty("images")
  @Singular(value = "putInImages", ignoreNullCollections = true)
  private Map<String, String> images;

  /**
   * infra holds the infrastructure details TODO this makes platform redundant as everything is contained inside Infra.Status
   */
  @JsonProperty("infra")
  private Object infra;

  /**
   * kubeAPIServerServingCAData managed Kubelet to API Server Cert... Rotated automatically
   */
  @JsonProperty("kubeAPIServerServingCAData")
  private String kubeAPIServerServingCAData;

  /**
   * kubeletIPv6 is true to force a single-stack IPv6 kubelet config
   */
  @JsonProperty("kubeletIPv6")
  private Boolean kubeletIPv6;

  /**
   * osImageURL is the location of the container image that contains the OS update payload. Its value is taken from the data.osImageURL field on the machine-config-osimageurl ConfigMap.
   */
  @JsonProperty("osImageURL")
  private String osImageURL;

  /**
   * The openshift platform, e.g. "libvirt", "openstack", "gcp", "baremetal", "aws", or "none"
   */
  @JsonProperty("platform")
  private String platform;

  /**
   * proxy holds the current proxy configuration for the nodes
   */
  @JsonProperty("proxy")
  private Object proxy;

  @JsonProperty("pullSecret")
  private ControllerConfigSpecPullSecret pullSecret;

  /**
   * rootCAData specifies the root CA data
   */
  @JsonProperty("rootCAData")
  private String rootCAData;

}

