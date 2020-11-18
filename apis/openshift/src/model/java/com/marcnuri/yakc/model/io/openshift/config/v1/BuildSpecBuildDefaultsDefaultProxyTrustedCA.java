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

package com.marcnuri.yakc.model.io.openshift.config.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * trustedCA is a reference to a ConfigMap containing a CA certificate bundle. The trustedCA field should only be consumed by a proxy validator. The validator is responsible for reading the certificate bundle from the required key "ca-bundle.crt", merging it with the system default trust bundle, and writing the merged trust bundle to a ConfigMap named "trusted-ca-bundle" in the "openshift-config-managed" namespace. Clients that expect to make proxy connections must use the trusted-ca-bundle for all HTTPS requests to the proxy, and may use the trusted-ca-bundle for non-proxy HTTPS requests as well. <br><p>  The namespace for the ConfigMap referenced by trustedCA is "openshift-config". Here is an example ConfigMap (in yaml): <br><p>  apiVersion: v1 kind: ConfigMap metadata:  name: user-ca-bundle  namespace: openshift-config  data:    ca-bundle.crt: |      -----BEGIN CERTIFICATE-----      Custom CA certificate bundle.      -----END CERTIFICATE-----
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildSpecBuildDefaultsDefaultProxyTrustedCA implements Model {


  /**
   * name is the metadata.name of the referenced config map
   */
  @NonNull
  @JsonProperty("name")
  private String name;

}

