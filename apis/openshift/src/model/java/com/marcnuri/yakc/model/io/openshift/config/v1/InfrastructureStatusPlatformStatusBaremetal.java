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
 * BareMetal contains settings specific to the BareMetal platform.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InfrastructureStatusPlatformStatusBaremetal implements Model {


  /**
   * apiServerInternalIP is an IP address to contact the Kubernetes API server that can be used by components inside the cluster, like kubelets using the infrastructure rather than Kubernetes networking. It is the IP that the Infrastructure.status.apiServerInternalURI points to. It is the IP for a self-hosted load balancer in front of the API servers.
   */
  @JsonProperty("apiServerInternalIP")
  private String apiServerInternalIP;

  /**
   * ingressIP is an external IP which routes to the default ingress controller. The IP is a suitable target of a wildcard DNS record used to resolve default route host names.
   */
  @JsonProperty("ingressIP")
  private String ingressIP;

  /**
   * nodeDNSIP is the IP address for the internal DNS used by the nodes. Unlike the one managed by the DNS operator, `NodeDNSIP` provides name resolution for the nodes themselves. There is no DNS-as-a-service for BareMetal deployments. In order to minimize necessary changes to the datacenter DNS, a DNS service is hosted as a static pod to serve those hostnames to the nodes in the cluster.
   */
  @JsonProperty("nodeDNSIP")
  private String nodeDNSIP;

}

