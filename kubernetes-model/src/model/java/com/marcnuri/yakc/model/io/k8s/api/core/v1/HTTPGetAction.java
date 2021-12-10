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

package com.marcnuri.yakc.model.io.k8s.api.core.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * HTTPGetAction describes an action based on HTTP Get requests.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HTTPGetAction implements Model {


  /**
   * Host name to connect to, defaults to the pod IP. You probably want to set "Host" in httpHeaders instead.
   */
  @JsonProperty("host")
  private String host;

  /**
   * Custom headers to set in the request. HTTP allows repeated headers.
   */
  @JsonProperty("httpHeaders")
  @Singular(value = "addToHttpHeaders", ignoreNullCollections = true)
  private List<HTTPHeader> httpHeaders;

  /**
   * Path to access on the HTTP server.
   */
  @JsonProperty("path")
  private String path;

  @NonNull
  @JsonProperty("port")
  @JsonSerialize(using = com.marcnuri.yakc.model.serialization.IntOrStringSerializer.class)
  private String port;

  /**
   * Scheme to use for connecting to the host. Defaults to HTTP.<br><p> <br><p> Possible enum values:<br><p>  - `"HTTP"` means that the scheme used will be http://<br><p>  - `"HTTPS"` means that the scheme used will be https://
   */
  @JsonProperty("scheme")
  private String scheme;

}

