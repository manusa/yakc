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
 * ExternalAccountBinding is a reference to a CA external account of the ACME server. If set, upon registration cert-manager will attempt to associate the given external account credentials with the registered ACME account.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeExternalAccountBinding implements Model {


  /**
   * keyAlgorithm is the MAC key algorithm that the key is used for. Valid values are "HS256", "HS384" and "HS512".
   */
  @NonNull
  @JsonProperty("keyAlgorithm")
  private String keyAlgorithm;

  /**
   * keyID is the ID of the CA key that the External Account is bound to.
   */
  @NonNull
  @JsonProperty("keyID")
  private String keyID;

  @NonNull
  @JsonProperty("keySecretRef")
  private ClusterIssuerSpecAcmeExternalAccountBindingKeySecretRef keySecretRef;

}

