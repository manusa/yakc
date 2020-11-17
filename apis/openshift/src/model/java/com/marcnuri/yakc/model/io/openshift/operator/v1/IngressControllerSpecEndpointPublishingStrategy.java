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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * endpointPublishingStrategy is used to publish the ingress controller endpoints to other networks, enable load balancer integrations, etc. <br><p>  If unset, the default is based on infrastructure.config.openshift.io/cluster .status.platform: <br><p>    AWS:      LoadBalancerService (with External scope)   Azure:    LoadBalancerService (with External scope)   GCP:      LoadBalancerService (with External scope)   IBMCloud: LoadBalancerService (with External scope)   Libvirt:  HostNetwork <br><p>  Any other platform types (including None) default to HostNetwork. <br><p>  endpointPublishingStrategy cannot be updated.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerSpecEndpointPublishingStrategy implements Model {


  /**
   * hostNetwork holds parameters for the HostNetwork endpoint publishing strategy. Present only if type is HostNetwork.
   */
  @JsonProperty("hostNetwork")
  private Object hostNetwork;

  @JsonProperty("loadBalancer")
  private IngressControllerSpecEndpointPublishingStrategyLoadBalancer loadBalancer;

  /**
   * nodePort holds parameters for the NodePortService endpoint publishing strategy. Present only if type is NodePortService.
   */
  @JsonProperty("nodePort")
  private Object nodePort;

  /**
   * private holds parameters for the Private endpoint publishing strategy. Present only if type is Private.
   */
  @JsonProperty("private")
  private Object privates;

  /**
   * type is the publishing strategy to use. Valid values are: <br><p>  &#42; LoadBalancerService <br><p>  Publishes the ingress controller using a Kubernetes LoadBalancer Service. <br><p>  In this configuration, the ingress controller deployment uses container networking. A LoadBalancer Service is created to publish the deployment. <br><p>  See: https://kubernetes.io/docs/concepts/services-networking/service/#loadbalancer <br><p>  If domain is set, a wildcard DNS record will be managed to point at the LoadBalancer Service's external name. DNS records are managed only in DNS zones defined by dns.config.openshift.io/cluster .spec.publicZone and .spec.privateZone. <br><p>  Wildcard DNS management is currently supported only on the AWS, Azure, and GCP platforms. <br><p>  &#42; HostNetwork <br><p>  Publishes the ingress controller on node ports where the ingress controller is deployed. <br><p>  In this configuration, the ingress controller deployment uses host networking, bound to node ports 80 and 443. The user is responsible for configuring an external load balancer to publish the ingress controller via the node ports. <br><p>  &#42; Private <br><p>  Does not publish the ingress controller. <br><p>  In this configuration, the ingress controller deployment uses container networking, and is not explicitly published. The user must manually publish the ingress controller. <br><p>  &#42; NodePortService <br><p>  Publishes the ingress controller using a Kubernetes NodePort Service. <br><p>  In this configuration, the ingress controller deployment uses container networking. A NodePort Service is created to publish the deployment. The specific node ports are dynamically allocated by OpenShift; however, to support static port allocations, user changes to the node port field of the managed NodePort Service will preserved.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

