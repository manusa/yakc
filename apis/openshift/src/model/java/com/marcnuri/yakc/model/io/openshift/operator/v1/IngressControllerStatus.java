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
import com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1.ConfigStatusConditions;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * status is the most recently observed status of the IngressController.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerStatus implements Model {


  /**
   * availableReplicas is number of observed available replicas according to the ingress controller deployment.
   */
  @JsonProperty("availableReplicas")
  private Number availableReplicas;

  /**
   * conditions is a list of conditions and their status. <br><p>  Available means the ingress controller deployment is available and servicing route and ingress resources (i.e, .status.availableReplicas equals .spec.replicas) <br><p>  There are additional conditions which indicate the status of other ingress controller features and capabilities. <br><p>    &#42; LoadBalancerManaged   - True if the following conditions are met:     &#42; The endpoint publishing strategy requires a service load balancer.   - False if any of those conditions are unsatisfied. <br><p>    &#42; LoadBalancerReady   - True if the following conditions are met:     &#42; A load balancer is managed.     &#42; The load balancer is ready.   - False if any of those conditions are unsatisfied. <br><p>    &#42; DNSManaged   - True if the following conditions are met:     &#42; The endpoint publishing strategy and platform support DNS.     &#42; The ingress controller domain is set.     &#42; dns.config.openshift.io/cluster configures DNS zones.   - False if any of those conditions are unsatisfied. <br><p>    &#42; DNSReady   - True if the following conditions are met:     &#42; DNS is managed.     &#42; DNS records have been successfully created.   - False if any of those conditions are unsatisfied.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ConfigStatusConditions> conditions;

  /**
   * domain is the actual domain in use.
   */
  @JsonProperty("domain")
  private String domain;

  @JsonProperty("endpointPublishingStrategy")
  private IngressControllerStatusEndpointPublishingStrategy endpointPublishingStrategy;

  /**
   * observedGeneration is the most recent generation observed.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * selector is a label selector, in string format, for ingress controller pods corresponding to the IngressController. The number of matching pods should equal the value of availableReplicas.
   */
  @JsonProperty("selector")
  private String selector;

  @JsonProperty("tlsProfile")
  private IngressControllerStatusTlsProfile tlsProfile;

}

