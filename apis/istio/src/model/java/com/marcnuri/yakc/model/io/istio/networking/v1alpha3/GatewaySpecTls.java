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

package com.marcnuri.yakc.model.io.istio.networking.v1alpha3;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Set of TLS related options that govern the server's behavior.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GatewaySpecTls implements Model {


  /**
   * REQUIRED if mode is `MUTUAL`.
   */
  @JsonProperty("caCertificates")
  private String caCertificates;

  /**
   * Optional: If specified, only support the specified cipher list.
   */
  @JsonProperty("cipherSuites")
  @Singular(value = "addToCipherSuites", ignoreNullCollections = true)
  private List<String> cipherSuites;

  @JsonProperty("credentialName")
  private String credentialName;

  @JsonProperty("httpsRedirect")
  private Boolean httpsRedirect;

  /**
   * Optional: Maximum TLS protocol version.
   */
  @JsonProperty("maxProtocolVersion")
  private String maxProtocolVersion;

  /**
   * Optional: Minimum TLS protocol version.
   */
  @JsonProperty("minProtocolVersion")
  private String minProtocolVersion;

  @JsonProperty("mode")
  private String mode;

  /**
   * REQUIRED if mode is `SIMPLE` or `MUTUAL`.
   */
  @JsonProperty("privateKey")
  private String privateKey;

  /**
   * REQUIRED if mode is `SIMPLE` or `MUTUAL`.
   */
  @JsonProperty("serverCertificate")
  private String serverCertificate;

  @JsonProperty("subjectAltNames")
  @Singular(value = "addToSubjectAltNames", ignoreNullCollections = true)
  private List<String> subjectAltNames;

  @JsonProperty("verifyCertificateHash")
  @Singular(value = "addToVerifyCertificateHash", ignoreNullCollections = true)
  private List<String> verifyCertificateHash;

  @JsonProperty("verifyCertificateSpki")
  @Singular(value = "addToVerifyCertificateSpki", ignoreNullCollections = true)
  private List<String> verifyCertificateSpki;

}

