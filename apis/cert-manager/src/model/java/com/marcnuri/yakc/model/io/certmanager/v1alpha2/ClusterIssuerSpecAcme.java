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
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeExternalAccountBinding;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmePrivateKeySecretRef;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * ACME configures this issuer to communicate with a RFC8555 (ACME) server to obtain signed x509 certificates.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcme implements Model {


  /**
   * Enables or disables generating a new ACME account key. If true, the Issuer resource will &#42;not&#42; request a new account but will expect the account key to be supplied via an existing secret. If false, the cert-manager system will generate a new ACME account key for the Issuer. Defaults to false.
   */
  @JsonProperty("disableAccountKeyGeneration")
  private Boolean disableAccountKeyGeneration;

  /**
   * Email is the email address to be associated with the ACME account. This field is optional, but it is strongly recommended to be set. It will be used to contact you in case of issues with your account or certificates, including expiry notification emails. This field may be updated after the account is initially registered.
   */
  @JsonProperty("email")
  private String email;

  @JsonProperty("externalAccountBinding")
  private ClusterIssuerSpecAcmeExternalAccountBinding externalAccountBinding;

  /**
   * PreferredChain is the chain to use if the ACME server outputs multiple. PreferredChain is no guarantee that this one gets delivered by the ACME endpoint. For example, for Let's Encrypt's DST crosssign you would use: "DST Root CA X3" or "ISRG Root X1" for the newer Let's Encrypt root CA. This value picks the first certificate bundle in the ACME alternative chains that has a certificate with this value as its issuer's CN
   */
  @JsonProperty("preferredChain")
  private String preferredChain;

  @NonNull
  @JsonProperty("privateKeySecretRef")
  private ClusterIssuerSpecAcmePrivateKeySecretRef privateKeySecretRef;

  /**
   * Server is the URL used to access the ACME server's 'directory' endpoint. For example, for Let's Encrypt's staging endpoint, you would use: "https://acme-staging-v02.api.letsencrypt.org/directory". Only ACME v2 endpoints (i.e. RFC 8555) are supported.
   */
  @NonNull
  @JsonProperty("server")
  private String server;

  /**
   * Enables or disables validation of the ACME server TLS certificate. If true, requests to the ACME server will not have their TLS certificate validated (i.e. insecure connections will be allowed). Only enable this option in development environments. The cert-manager system installed roots will be used to verify connections to the ACME server if this is false. Defaults to false.
   */
  @JsonProperty("skipTLSVerify")
  private Boolean skipTLSVerify;

  /**
   * Solvers is a list of challenge solvers that will be used to solve ACME challenges for the matching domains. Solver configurations must be provided in order to obtain certificates from an ACME server. For more information, see: https://cert-manager.io/docs/configuration/acme/
   */
  @JsonProperty("solvers")
  @Singular(value = "addToSolvers", ignoreNullCollections = true)
  private List<ClusterIssuerSpecAcmeSolvers> solvers;

}

