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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Spec holds user-settable values for the proxy configuration
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProxySpec implements Model {


  /**
   * httpProxy is the URL of the proxy for HTTP requests.  Empty means unset and will not result in an env var.
   */
  @JsonProperty("httpProxy")
  private String httpProxy;

  /**
   * httpsProxy is the URL of the proxy for HTTPS requests.  Empty means unset and will not result in an env var.
   */
  @JsonProperty("httpsProxy")
  private String httpsProxy;

  /**
   * noProxy is a comma-separated list of hostnames and/or CIDRs for which the proxy should not be used. Empty means unset and will not result in an env var.
   */
  @JsonProperty("noProxy")
  private String noProxy;

  /**
   * readinessEndpoints is a list of endpoints used to verify readiness of the proxy.
   */
  @JsonProperty("readinessEndpoints")
  @Singular(value = "addToReadinessEndpoints", ignoreNullCollections = true)
  private List<String> readinessEndpoints;

  @JsonProperty("trustedCA")
  private BuildSpecBuildDefaultsDefaultProxyTrustedCA trustedCA;

}

