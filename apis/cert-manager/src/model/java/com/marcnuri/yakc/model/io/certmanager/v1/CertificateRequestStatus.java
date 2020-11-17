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
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Status of the CertificateRequest. This is set and managed automatically.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateRequestStatus implements Model {


  /**
   * The PEM encoded x509 certificate of the signer, also known as the CA (Certificate Authority). This is set on a best-effort basis by different issuers. If not set, the CA is assumed to be unknown/not available.
   */
  @JsonProperty("ca")
  private String ca;

  /**
   * The PEM encoded x509 certificate resulting from the certificate signing request. If not set, the CertificateRequest has either not been completed or has failed. More information on failure can be found by checking the `conditions` field.
   */
  @JsonProperty("certificate")
  private String certificate;

  /**
   * List of status conditions to indicate the status of a CertificateRequest. Known condition types are `Ready` and `InvalidRequest`.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<CertificateRequestStatusConditions> conditions;

  /**
   * FailureTime stores the time that this CertificateRequest failed. This is used to influence garbage collection and back-off.
   */
  @JsonProperty("failureTime")
  private OffsetDateTime failureTime;

}

