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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * CertificateSigningRequestSpec contains the certificate request.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateSigningRequestSpec implements Model {


  /**
   * extra contains extra attributes of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
   */
  @JsonProperty("extra")
  @Singular(value = "putInExtra", ignoreNullCollections = true)
  private Map<String, List<String>> extra;

  /**
   * groups contains group membership of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
   */
  @JsonProperty("groups")
  @Singular(value = "addToGroups", ignoreNullCollections = true)
  private List<String> groups;

  /**
   * request contains an x509 certificate signing request encoded in a "CERTIFICATE REQUEST" PEM block. When serialized as JSON or YAML, the data is additionally base64-encoded.
   */
  @NonNull
  @JsonProperty("request")
  private String request;

  /**
   * signerName indicates the requested signer, and is a qualified name.<br><p> <br><p> List/watch requests for CertificateSigningRequests can filter on this field using a "spec.signerName=NAME" fieldSelector.<br><p> <br><p> Well-known Kubernetes signers are:<br><p>  1. "kubernetes.io/kube-apiserver-client": issues client certificates that can be used to authenticate to kube-apiserver.<br><p>   Requests for this signer are never auto-approved by kube-controller-manager, can be issued by the "csrsigning" controller in kube-controller-manager.<br><p>  2. "kubernetes.io/kube-apiserver-client-kubelet": issues client certificates that kubelets use to authenticate to kube-apiserver.<br><p>   Requests for this signer can be auto-approved by the "csrapproving" controller in kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.<br><p>  3. "kubernetes.io/kubelet-serving" issues serving certificates that kubelets use to serve TLS endpoints, which kube-apiserver can connect to securely.<br><p>   Requests for this signer are never auto-approved by kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.<br><p> <br><p> More details are available at https://k8s.io/docs/reference/access-authn-authz/certificate-signing-requests/#kubernetes-signers<br><p> <br><p> Custom signerNames can also be specified. The signer defines:<br><p>  1. Trust distribution: how trust (CA bundles) are distributed.<br><p>  2. Permitted subjects: and behavior when a disallowed subject is requested.<br><p>  3. Required, permitted, or forbidden x509 extensions in the request (including whether subjectAltNames are allowed, which types, restrictions on allowed values) and behavior when a disallowed extension is requested.<br><p>  4. Required, permitted, or forbidden key usages / extended key usages.<br><p>  5. Expiration/certificate lifetime: whether it is fixed by the signer, configurable by the admin.<br><p>  6. Whether or not requests for CA certificates are allowed.
   */
  @NonNull
  @JsonProperty("signerName")
  private String signerName;

  /**
   * uid contains the uid of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
   */
  @JsonProperty("uid")
  private String uid;

  /**
   * usages specifies a set of key usages requested in the issued certificate.<br><p> <br><p> Requests for TLS client certificates typically request: "digital signature", "key encipherment", "client auth".<br><p> <br><p> Requests for TLS serving certificates typically request: "key encipherment", "digital signature", "server auth".<br><p> <br><p> Valid values are:<br><p>  "signing", "digital signature", "content commitment",<br><p>  "key encipherment", "key agreement", "data encipherment",<br><p>  "cert sign", "crl sign", "encipher only", "decipher only", "any",<br><p>  "server auth", "client auth",<br><p>  "code signing", "email protection", "s/mime",<br><p>  "ipsec end system", "ipsec tunnel", "ipsec user",<br><p>  "timestamping", "ocsp signing", "microsoft sgc", "netscape sgc"
   */
  @JsonProperty("usages")
  @Singular(value = "addToUsages", ignoreNullCollections = true)
  private List<String> usages;

  /**
   * username contains the name of the user that created the CertificateSigningRequest. Populated by the API server on creation and immutable.
   */
  @JsonProperty("username")
  private String username;

}

