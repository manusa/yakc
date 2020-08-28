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

package com.marcnuri.yakc.model.io.k8s.api.certificates.v1beta1;

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
 * This information is immutable after the request is created. Only the Request and Usages fields can be set on creation, other fields are derived by Kubernetes and cannot be modified by users.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateSigningRequestSpec implements Model {


  /**
   * Extra information about the requesting user. See user.Info interface for details.
   */
  @JsonProperty("extra")
  @Singular(value = "putInExtra", ignoreNullCollections = true)
  private Map<String, List<String>> extra;

  /**
   * Group information about the requesting user. See user.Info interface for details.
   */
  @JsonProperty("groups")
  @Singular(value = "addToGroups", ignoreNullCollections = true)
  private List<String> groups;

  /**
   * Base64-encoded PKCS#10 CSR data
   */
  @NonNull
  @JsonProperty("request")
  private String request;

  /**
   * Requested signer for the request. It is a qualified name in the form: `scope-hostname.io/name`. If empty, it will be defaulted:<br><p>  1. If it's a kubelet client certificate, it is assigned<br><p>     "kubernetes.io/kube-apiserver-client-kubelet".<br><p>  2. If it's a kubelet serving certificate, it is assigned<br><p>     "kubernetes.io/kubelet-serving".<br><p>  3. Otherwise, it is assigned "kubernetes.io/legacy-unknown".<br><p> Distribution of trust for signers happens out of band. You can select on this field using `spec.signerName`.
   */
  @JsonProperty("signerName")
  private String signerName;

  /**
   * UID information about the requesting user. See user.Info interface for details.
   */
  @JsonProperty("uid")
  private String uid;

  /**
   * allowedUsages specifies a set of usage contexts the key will be valid for. See: https://tools.ietf.org/html/rfc5280#section-4.2.1.3<br><p>      https://tools.ietf.org/html/rfc5280#section-4.2.1.12<br><p> Valid values are:<br><p>  "signing",<br><p>  "digital signature",<br><p>  "content commitment",<br><p>  "key encipherment",<br><p>  "key agreement",<br><p>  "data encipherment",<br><p>  "cert sign",<br><p>  "crl sign",<br><p>  "encipher only",<br><p>  "decipher only",<br><p>  "any",<br><p>  "server auth",<br><p>  "client auth",<br><p>  "code signing",<br><p>  "email protection",<br><p>  "s/mime",<br><p>  "ipsec end system",<br><p>  "ipsec tunnel",<br><p>  "ipsec user",<br><p>  "timestamping",<br><p>  "ocsp signing",<br><p>  "microsoft sgc",<br><p>  "netscape sgc"
   */
  @JsonProperty("usages")
  @Singular(value = "addToUsages", ignoreNullCollections = true)
  private List<String> usages;

  /**
   * Information about the requesting user. See user.Info interface for details.
   */
  @JsonProperty("username")
  private String username;

}

