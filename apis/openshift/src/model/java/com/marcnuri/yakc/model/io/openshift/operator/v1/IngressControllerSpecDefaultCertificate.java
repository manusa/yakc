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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * defaultCertificate is a reference to a secret containing the default certificate served by the ingress controller. When Routes don't specify their own certificate, defaultCertificate is used. <br><p>  The secret must contain the following keys and data: <br><p>    tls.crt: certificate file contents   tls.key: key file contents <br><p>  If unset, a wildcard certificate is automatically generated and used. The certificate is valid for the ingress controller domain (and subdomains) and the generated certificate's CA will be automatically integrated with the cluster's trust store. <br><p>  The in-use certificate (whether generated or user-specified) will be automatically integrated with OpenShift's built-in OAuth server.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerSpecDefaultCertificate implements Model {


  /**
   * Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names TODO: Add other useful fields. apiVersion, kind, uid?
   */
  @JsonProperty("name")
  private String name;

}

