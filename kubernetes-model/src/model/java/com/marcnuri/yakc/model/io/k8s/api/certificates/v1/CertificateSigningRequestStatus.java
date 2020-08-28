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

package com.marcnuri.yakc.model.io.k8s.api.certificates.v1;

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
 * CertificateSigningRequestStatus contains conditions used to indicate approved/denied/failed status of the request, and the issued certificate.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateSigningRequestStatus implements Model {


  /**
   * certificate is populated with an issued certificate by the signer after an Approved condition is present. This field is set via the /status subresource. Once populated, this field is immutable.<br><p> <br><p> If the certificate signing request is denied, a condition of type "Denied" is added and this field remains empty. If the signer cannot issue the certificate, a condition of type "Failed" is added and this field remains empty.<br><p> <br><p> Validation requirements:<br><p>  1. certificate must contain one or more PEM blocks.<br><p>  2. All PEM blocks must have the "CERTIFICATE" label, contain no headers, and the encoded data<br><p>   must be a BER-encoded ASN.1 Certificate structure as described in section 4 of RFC5280.<br><p>  3. Non-PEM content may appear before or after the "CERTIFICATE" PEM blocks and is unvalidated,<br><p>   to allow for explanatory text as described in section 5.2 of RFC7468.<br><p> <br><p> If more than one PEM block is present, and the definition of the requested spec.signerName does not indicate otherwise, the first block is the issued certificate, and subsequent blocks should be treated as intermediate certificates and presented in TLS handshakes.<br><p> <br><p> The certificate is encoded in PEM format.<br><p> <br><p> When serialized as JSON or YAML, the data is additionally base64-encoded, so it consists of:<br><p> <br><p>     base64(<br><p>     -----BEGIN CERTIFICATE-----<br><p>     ...<br><p>     -----END CERTIFICATE-----<br><p>     )
   */
  @JsonProperty("certificate")
  private String certificate;

  /**
   * conditions applied to the request. Known conditions are "Approved", "Denied", and "Failed".
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<CertificateSigningRequestCondition> conditions;

}

