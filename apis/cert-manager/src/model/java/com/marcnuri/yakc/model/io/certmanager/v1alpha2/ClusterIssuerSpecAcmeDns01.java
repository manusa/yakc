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

package com.marcnuri.yakc.model.io.certmanager.v1alpha2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01AcmeDNS;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01Akamai;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01AzureDNS;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01CloudDNS;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01Cloudflare;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01Digitalocean;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01Rfc2136;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01Route53;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01Webhook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Configures cert-manager to attempt to complete authorizations by performing the DNS01 challenge flow.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeDns01 implements Model {


  @JsonProperty("acmedns")
  private ClusterIssuerSpecAcmeDns01AcmeDNS acmedns;

  @JsonProperty("akamai")
  private ClusterIssuerSpecAcmeDns01Akamai akamai;

  @JsonProperty("azuredns")
  private ClusterIssuerSpecAcmeDns01AzureDNS azuredns;

  @JsonProperty("clouddns")
  private ClusterIssuerSpecAcmeDns01CloudDNS clouddns;

  @JsonProperty("cloudflare")
  private ClusterIssuerSpecAcmeDns01Cloudflare cloudflare;

  /**
   * CNAMEStrategy configures how the DNS01 provider should handle CNAME records when found in DNS zones.
   */
  @JsonProperty("cnameStrategy")
  private String cnameStrategy;

  @JsonProperty("digitalocean")
  private ClusterIssuerSpecAcmeDns01Digitalocean digitalocean;

  @JsonProperty("rfc2136")
  private ClusterIssuerSpecAcmeDns01Rfc2136 rfc2136;

  @JsonProperty("route53")
  private ClusterIssuerSpecAcmeDns01Route53 route53;

  @JsonProperty("webhook")
  private ClusterIssuerSpecAcmeDns01Webhook webhook;

}

