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

package com.marcnuri.yakc.model.com.coreos.monitoring.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * HTTPGet specifies the http request to perform.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpecLifecyclePostStartHttpGet implements Model {


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
  private List<AlertmanagerSpecLifecyclePostStartHttpGetHttpHeaders> httpHeaders;

  /**
   * Path to access on the HTTP server.
   */
  @JsonProperty("path")
  private String path;

  /**
   * Name or number of the port to access on the container. Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
   */
  @NonNull
  @JsonProperty("port")
  private Object port;

  /**
   * Scheme to use for connecting to the host. Defaults to HTTP.
   */
  @JsonProperty("scheme")
  private String scheme;

}

