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
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * Desired state of the CertificateRequest resource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateRequestSpec implements Model {


  /**
   * The requested 'duration' (i.e. lifetime) of the Certificate. This option may be ignored/overridden by some issuer types.
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * Extra contains extra attributes of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
   */
  @JsonProperty("extra")
  @Singular(value = "putInExtra", ignoreNullCollections = true)
  private Map<String, List<String>> extra;

  /**
   * Groups contains group membership of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
   */
  @JsonProperty("groups")
  @Singular(value = "addToGroups", ignoreNullCollections = true)
  private List<String> groups;

  /**
   * IsCA will request to mark the certificate as valid for certificate signing when submitting to the issuer. This will automatically add the `cert sign` usage to the list of `usages`.
   */
  @JsonProperty("isCA")
  private Boolean isCA;

  @NonNull
  @JsonProperty("issuerRef")
  private CertificateRequestSpecIssuerRef issuerRef;

  /**
   * The PEM-encoded x509 certificate signing request to be submitted to the CA for signing.
   */
  @NonNull
  @JsonProperty("request")
  private String request;

  /**
   * UID contains the uid of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
   */
  @JsonProperty("uid")
  private String uid;

  /**
   * Usages is the set of x509 usages that are requested for the certificate. If usages are set they SHOULD be encoded inside the CSR spec Defaults to `digital signature` and `key encipherment` if not specified.
   */
  @JsonProperty("usages")
  @Singular(value = "addToUsages", ignoreNullCollections = true)
  private List<String> usages;

  /**
   * Username contains the name of the user that created the CertificateRequest. Populated by the cert-manager webhook on creation and immutable.
   */
  @JsonProperty("username")
  private String username;

}

