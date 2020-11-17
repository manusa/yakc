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
 * tlsSecurityProfile specifies settings for TLS connections for ingresscontrollers. <br><p>  If unset, the default is based on the apiservers.config.openshift.io/cluster resource. <br><p>  Note that when using the Old, Intermediate, and Modern profile types, the effective profile configuration is subject to change between releases. For example, given a specification to use the Intermediate profile deployed on release X.Y.Z, an upgrade to release X.Y.Z+1 may cause a new profile configuration to be applied to the ingress controller, resulting in a rollout. <br><p>  Note that the minimum TLS version for ingress controllers is 1.1, and the maximum TLS version is 1.2.  An implication of this restriction is that the Modern TLS profile type cannot be used because it requires TLS 1.3.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerSpecTlsSecurityProfile implements Model {


  /**
   * custom is a user-defined TLS security profile. Be extremely careful using a custom profile as invalid configurations can be catastrophic. An example custom profile looks like this: <br><p>    ciphers:     - ECDHE-ECDSA-CHACHA20-POLY1305     - ECDHE-RSA-CHACHA20-POLY1305     - ECDHE-RSA-AES128-GCM-SHA256     - ECDHE-ECDSA-AES128-GCM-SHA256   minTLSVersion: TLSv1.1
   */
  @JsonProperty("custom")
  private Object custom;

  /**
   * intermediate is a TLS security profile based on: <br><p>  https://wiki.mozilla.org/Security/Server_Side_TLS#Intermediate_compatibility_.28recommended.29 <br><p>  and looks like this (yaml): <br><p>    ciphers:     - TLS_AES_128_GCM_SHA256     - TLS_AES_256_GCM_SHA384     - TLS_CHACHA20_POLY1305_SHA256     - ECDHE-ECDSA-AES128-GCM-SHA256     - ECDHE-RSA-AES128-GCM-SHA256     - ECDHE-ECDSA-AES256-GCM-SHA384     - ECDHE-RSA-AES256-GCM-SHA384     - ECDHE-ECDSA-CHACHA20-POLY1305     - ECDHE-RSA-CHACHA20-POLY1305     - DHE-RSA-AES128-GCM-SHA256     - DHE-RSA-AES256-GCM-SHA384   minTLSVersion: TLSv1.2
   */
  @JsonProperty("intermediate")
  private Object intermediate;

  /**
   * modern is a TLS security profile based on: <br><p>  https://wiki.mozilla.org/Security/Server_Side_TLS#Modern_compatibility <br><p>  and looks like this (yaml): <br><p>    ciphers:     - TLS_AES_128_GCM_SHA256     - TLS_AES_256_GCM_SHA384     - TLS_CHACHA20_POLY1305_SHA256   minTLSVersion: TLSv1.3 <br><p>  NOTE: Currently unsupported.
   */
  @JsonProperty("modern")
  private Object modern;

  /**
   * old is a TLS security profile based on: <br><p>  https://wiki.mozilla.org/Security/Server_Side_TLS#Old_backward_compatibility <br><p>  and looks like this (yaml): <br><p>    ciphers:     - TLS_AES_128_GCM_SHA256     - TLS_AES_256_GCM_SHA384     - TLS_CHACHA20_POLY1305_SHA256     - ECDHE-ECDSA-AES128-GCM-SHA256     - ECDHE-RSA-AES128-GCM-SHA256     - ECDHE-ECDSA-AES256-GCM-SHA384     - ECDHE-RSA-AES256-GCM-SHA384     - ECDHE-ECDSA-CHACHA20-POLY1305     - ECDHE-RSA-CHACHA20-POLY1305     - DHE-RSA-AES128-GCM-SHA256     - DHE-RSA-AES256-GCM-SHA384     - DHE-RSA-CHACHA20-POLY1305     - ECDHE-ECDSA-AES128-SHA256     - ECDHE-RSA-AES128-SHA256     - ECDHE-ECDSA-AES128-SHA     - ECDHE-RSA-AES128-SHA     - ECDHE-ECDSA-AES256-SHA384     - ECDHE-RSA-AES256-SHA384     - ECDHE-ECDSA-AES256-SHA     - ECDHE-RSA-AES256-SHA     - DHE-RSA-AES128-SHA256     - DHE-RSA-AES256-SHA256     - AES128-GCM-SHA256     - AES256-GCM-SHA384     - AES128-SHA256     - AES256-SHA256     - AES128-SHA     - AES256-SHA     - DES-CBC3-SHA   minTLSVersion: TLSv1.0
   */
  @JsonProperty("old")
  private Object old;

  /**
   * type is one of Old, Intermediate, Modern or Custom. Custom provides the ability to specify individual TLS security profile parameters. Old, Intermediate and Modern are TLS security profiles based on: <br><p>  https://wiki.mozilla.org/Security/Server_Side_TLS#Recommended_configurations <br><p>  The profiles are intent based, so they may change over time as new ciphers are developed and existing ciphers are found to be insecure.  Depending on precisely which ciphers are available to a process, the list may be reduced. <br><p>  Note that the Modern profile is currently not supported because it is not yet well adopted by common software libraries.
   */
  @JsonProperty("type")
  private String type;

}

