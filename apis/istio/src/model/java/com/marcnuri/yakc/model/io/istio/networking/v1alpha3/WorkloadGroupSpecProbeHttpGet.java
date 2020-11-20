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

package com.marcnuri.yakc.model.io.istio.networking.v1alpha3;

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
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WorkloadGroupSpecProbeHttpGet implements Model {


  /**
   * Host name to connect to, defaults to the pod IP.
   */
  @JsonProperty("host")
  private String host;

  /**
   * headers the proxy will pass on to make the request.
   */
  @JsonProperty("httpHeaders")
  @Singular(value = "addToHttpHeaders", ignoreNullCollections = true)
  private List<WorkloadGroupSpecProbeHttpGetHttpHeaders> httpHeaders;

  /**
   * Path to access on the HTTP server.
   */
  @JsonProperty("path")
  private String path;

  /**
   * port on which the endpoint lives.
   */
  @JsonProperty("port")
  private Number port;

  @JsonProperty("scheme")
  private String scheme;

}

