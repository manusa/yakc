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
import lombok.ToString;

/**
 * The ingress based HTTP01 challenge solver will solve challenges by creating or modifying Ingress resources in order to route requests for '/.well-known/acme-challenge/XYZ' to 'challenge solver' pods that are provisioned by cert-manager for each Challenge to be completed.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeHttp01Ingress implements Model {


  /**
   * The ingress class to use when creating Ingress resources to solve ACME challenges that use this challenge solver. Only one of 'class' or 'name' may be specified.
   */
  @JsonProperty("class")
  private String clazz;

  @JsonProperty("ingressTemplate")
  private ClusterIssuerSpecAcmeHttp01IngressIngressTemplate ingressTemplate;

  /**
   * The name of the ingress resource that should have ACME challenge solving routes inserted into it in order to solve HTTP01 challenges. This is typically used in conjunction with ingress controllers like ingress-gce, which maintains a 1:1 mapping between external IPs and ingress resources.
   */
  @JsonProperty("name")
  private String name;

  @JsonProperty("podTemplate")
  private ClusterIssuerSpecAcmeHttp01IngressPodTemplate podTemplate;

  /**
   * Optional service type for Kubernetes solver service
   */
  @JsonProperty("serviceType")
  private String serviceType;

}

