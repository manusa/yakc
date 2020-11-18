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
 * status holds observed values from the cluster. They may not be overridden.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InfrastructureStatus implements Model {


  /**
   * apiServerInternalURL is a valid URI with scheme(http/https), address and port.  apiServerInternalURL can be used by components like kubelets, to contact the Kubernetes API server using the infrastructure provider rather than Kubernetes networking.
   */
  @JsonProperty("apiServerInternalURI")
  private String apiServerInternalURI;

  /**
   * apiServerURL is a valid URI with scheme(http/https), address and port.  apiServerURL can be used by components like the web console to tell users where to find the Kubernetes API.
   */
  @JsonProperty("apiServerURL")
  private String apiServerURL;

  /**
   * etcdDiscoveryDomain is the domain used to fetch the SRV records for discovering etcd servers and clients. For more info: https://github.com/etcd-io/etcd/blob/329be66e8b3f9e2e6af83c123ff89297e49ebd15/Documentation/op-guide/clustering.md#dns-discovery
   */
  @JsonProperty("etcdDiscoveryDomain")
  private String etcdDiscoveryDomain;

  /**
   * infrastructureName uniquely identifies a cluster with a human friendly name. Once set it should not be changed. Must be of max length 27 and must have only alphanumeric or hyphen characters.
   */
  @JsonProperty("infrastructureName")
  private String infrastructureName;

  /**
   * platform is the underlying infrastructure provider for the cluster. <br><p>  Deprecated: Use platformStatus.type instead.
   */
  @JsonProperty("platform")
  private String platform;

  @JsonProperty("platformStatus")
  private InfrastructureStatusPlatformStatus platformStatus;

}

