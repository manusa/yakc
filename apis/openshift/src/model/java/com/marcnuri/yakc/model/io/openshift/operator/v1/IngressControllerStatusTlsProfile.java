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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * tlsProfile is the TLS connection configuration that is in effect.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerStatusTlsProfile implements Model {


  /**
   * ciphers is used to specify the cipher algorithms that are negotiated during the TLS handshake.  Operators may remove entries their operands do not support.  For example, to use DES-CBC3-SHA  (yaml): <br><p>    ciphers:     - DES-CBC3-SHA
   */
  @JsonProperty("ciphers")
  @Singular(value = "addToCiphers", ignoreNullCollections = true)
  private List<String> ciphers;

  /**
   * minTLSVersion is used to specify the minimal version of the TLS protocol that is negotiated during the TLS handshake. For example, to use TLS versions 1.1, 1.2 and 1.3 (yaml): <br><p>    minTLSVersion: TLSv1.1 <br><p>  NOTE: currently the highest minTLSVersion allowed is VersionTLS12
   */
  @JsonProperty("minTLSVersion")
  private String minTLSVersion;

}

