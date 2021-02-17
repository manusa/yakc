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

package com.marcnuri.yakc.model.io.certmanager.v1alpha3;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.certmanager.v1.CertificateSpecIssuerRef;
import com.marcnuri.yakc.model.io.certmanager.v1.CertificateSpecSubject;
import com.marcnuri.yakc.model.io.certmanager.v1alpha2.CertificateSpecPrivateKey;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * Desired state of the Certificate resource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateSpec implements Model {


  /**
   * CommonName is a common name to be used on the Certificate. The CommonName should have a length of 64 characters or fewer to avoid generating invalid CSRs. This value is ignored by TLS clients when any subject alt name is set. This is x509 behaviour: https://tools.ietf.org/html/rfc6125#section-6.4.4
   */
  @JsonProperty("commonName")
  private String commonName;

  /**
   * DNSNames is a list of DNS subjectAltNames to be set on the Certificate.
   */
  @JsonProperty("dnsNames")
  @Singular(value = "addToDnsNames", ignoreNullCollections = true)
  private List<String> dnsNames;

  /**
   * The requested 'duration' (i.e. lifetime) of the Certificate. This option may be ignored/overridden by some issuer types. If overridden and `renewBefore` is greater than the actual certificate duration, the certificate will be automatically renewed 2/3rds of the way through the certificate's duration.
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * EmailSANs is a list of email subjectAltNames to be set on the Certificate.
   */
  @JsonProperty("emailSANs")
  @Singular(value = "addToEmailSANs", ignoreNullCollections = true)
  private List<String> emailSANs;

  /**
   * EncodeUsagesInRequest controls whether key usages should be present in the CertificateRequest
   */
  @JsonProperty("encodeUsagesInRequest")
  private Boolean encodeUsagesInRequest;

  /**
   * IPAddresses is a list of IP address subjectAltNames to be set on the Certificate.
   */
  @JsonProperty("ipAddresses")
  @Singular(value = "addToIpAddresses", ignoreNullCollections = true)
  private List<String> ipAddresses;

  /**
   * IsCA will mark this Certificate as valid for certificate signing. This will automatically add the `cert sign` usage to the list of `usages`.
   */
  @JsonProperty("isCA")
  private Boolean isCA;

  @NonNull
  @JsonProperty("issuerRef")
  private CertificateSpecIssuerRef issuerRef;

  /**
   * KeyAlgorithm is the private key algorithm of the corresponding private key for this certificate. If provided, allowed values are either `rsa` or `ecdsa` If `keyAlgorithm` is specified and `keySize` is not provided, key size of 256 will be used for `ecdsa` key algorithm and key size of 2048 will be used for `rsa` key algorithm.
   */
  @JsonProperty("keyAlgorithm")
  private String keyAlgorithm;

  /**
   * KeyEncoding is the private key cryptography standards (PKCS) for this certificate's private key to be encoded in. If provided, allowed values are `pkcs1` and `pkcs8` standing for PKCS#1 and PKCS#8, respectively. If KeyEncoding is not specified, then `pkcs1` will be used by default.
   */
  @JsonProperty("keyEncoding")
  private String keyEncoding;

  /**
   * KeySize is the key bit size of the corresponding private key for this certificate. If `keyAlgorithm` is set to `rsa`, valid values are `2048`, `4096` or `8192`, and will default to `2048` if not specified. If `keyAlgorithm` is set to `ecdsa`, valid values are `256`, `384` or `521`, and will default to `256` if not specified. No other values are allowed.
   */
  @JsonProperty("keySize")
  private Number keySize;

  @JsonProperty("keystores")
  private CertificateSpecKeystores keystores;

  @JsonProperty("privateKey")
  private CertificateSpecPrivateKey privateKey;

  /**
   * The amount of time before the currently issued certificate's `notAfter` time that cert-manager will begin to attempt to renew the certificate. If this value is greater than the total duration of the certificate (i.e. notAfter - notBefore), it will be automatically renewed 2/3rds of the way through the certificate's duration.
   */
  @JsonProperty("renewBefore")
  private String renewBefore;

  /**
   * SecretName is the name of the secret resource that will be automatically created and managed by this Certificate resource. It will be populated with a private key and certificate, signed by the denoted issuer.
   */
  @NonNull
  @JsonProperty("secretName")
  private String secretName;

  @JsonProperty("subject")
  private CertificateSpecSubject subject;

  /**
   * URISANs is a list of URI subjectAltNames to be set on the Certificate.
   */
  @JsonProperty("uriSANs")
  @Singular(value = "addToUriSANs", ignoreNullCollections = true)
  private List<String> uriSANs;

  /**
   * Usages is the set of x509 usages that are requested for the certificate. Defaults to `digital signature` and `key encipherment` if not specified.
   */
  @JsonProperty("usages")
  @Singular(value = "addToUsages", ignoreNullCollections = true)
  private List<String> usages;

}

