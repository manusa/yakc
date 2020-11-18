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
import lombok.ToString;

/**
 * spec is the specification of the desired behavior of the IngressController.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerSpec implements Model {


  @JsonProperty("defaultCertificate")
  private IngressControllerSpecDefaultCertificate defaultCertificate;

  /**
   * domain is a DNS name serviced by the ingress controller and is used to configure multiple features: <br><p>  &#42; For the LoadBalancerService endpoint publishing strategy, domain is   used to configure DNS records. See endpointPublishingStrategy. <br><p>  &#42; When using a generated default certificate, the certificate will be valid   for domain and its subdomains. See defaultCertificate. <br><p>  &#42; The value is published to individual Route statuses so that end-users   know where to target external DNS records. <br><p>  domain must be unique among all IngressControllers, and cannot be updated. <br><p>  If empty, defaults to ingress.config.openshift.io/cluster .spec.domain.
   */
  @JsonProperty("domain")
  private String domain;

  @JsonProperty("endpointPublishingStrategy")
  private IngressControllerSpecEndpointPublishingStrategy endpointPublishingStrategy;

  @JsonProperty("namespaceSelector")
  private IngressControllerSpecNamespaceSelector namespaceSelector;

  @JsonProperty("nodePlacement")
  private IngressControllerSpecNodePlacement nodePlacement;

  /**
   * replicas is the desired number of ingress controller replicas. If unset, defaults to 2.
   */
  @JsonProperty("replicas")
  private Number replicas;

  @JsonProperty("routeAdmission")
  private IngressControllerSpecRouteAdmission routeAdmission;

  @JsonProperty("routeSelector")
  private IngressControllerSpecRouteSelector routeSelector;

  @JsonProperty("tlsSecurityProfile")
  private IngressControllerSpecTlsSecurityProfile tlsSecurityProfile;

}

