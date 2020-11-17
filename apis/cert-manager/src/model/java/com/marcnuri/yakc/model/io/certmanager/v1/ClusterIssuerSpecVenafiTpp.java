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
import lombok.NonNull;
import lombok.ToString;

/**
 * TPP specifies Trust Protection Platform configuration settings. Only one of TPP or Cloud may be specified.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecVenafiTpp implements Model {


  /**
   * CABundle is a PEM encoded TLS certificate to use to verify connections to the TPP instance. If specified, system roots will not be used and the issuing CA for the TPP instance must be verifiable using the provided root. If not specified, the connection will be verified using the cert-manager system root certificates.
   */
  @JsonProperty("caBundle")
  private String caBundle;

  @NonNull
  @JsonProperty("credentialsRef")
  private ClusterIssuerSpecVenafiTppCredentialsRef credentialsRef;

  /**
   * URL is the base URL for the vedsdk endpoint of the Venafi TPP instance, for example: "https://tpp.example.com/vedsdk".
   */
  @NonNull
  @JsonProperty("url")
  private String url;

}

