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

package com.marcnuri.yakc.model.com.github.openshift.api.route.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * TLSConfig defines config used to secure a route and provide termination
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TLSConfig implements Model {


  /**
   * caCertificate provides the cert authority certificate contents
   */
  @JsonProperty("caCertificate")
  private String caCertificate;

  /**
   * certificate provides certificate contents
   */
  @JsonProperty("certificate")
  private String certificate;

  /**
   * destinationCACertificate provides the contents of the ca certificate of the final destination.  When using reencrypt termination this file should be provided in order to have routers use it for health checks on the secure connection. If this field is not specified, the router may provide its own destination CA and perform hostname validation using the short service name (service.namespace.svc), which allows infrastructure generated certificates to automatically verify.
   */
  @JsonProperty("destinationCACertificate")
  private String destinationCACertificate;

  /**
   * insecureEdgeTerminationPolicy indicates the desired behavior for insecure connections to a route. While each router may make its own decisions on which ports to expose, this is normally port 80.<br><p> <br><p> &#42; Allow - traffic is sent to the server on the insecure port (default) &#42; Disable - no traffic is allowed on the insecure port. &#42; Redirect - clients are redirected to the secure port.
   */
  @JsonProperty("insecureEdgeTerminationPolicy")
  private String insecureEdgeTerminationPolicy;

  /**
   * key provides key file contents
   */
  @JsonProperty("key")
  private String key;

  /**
   * termination indicates termination type.
   */
  @NonNull
  @JsonProperty("termination")
  private String termination;

}

