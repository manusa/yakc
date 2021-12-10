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
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
public class PortStatus implements Model {


  /**
   * Error is to record the problem with the service port The format of the error shall comply with the following rules: - built-in error values shall be specified in this file and those shall use<br><p>   CamelCase names<br><p> - cloud provider specific error values must have names that comply with the<br><p>   format foo.example.com/CamelCase.
   */
  @JsonProperty("error")
  private String error;

  /**
   * Port is the port number of the service port of which status is recorded here
   */
  @NonNull
  @JsonProperty("port")
  private Number port;

  /**
   * Protocol is the protocol of the service port of which status is recorded here The supported values are: "TCP", "UDP", "SCTP"<br><p> <br><p> Possible enum values:<br><p>  - `"SCTP"` is the SCTP protocol.<br><p>  - `"TCP"` is the TCP protocol.<br><p>  - `"UDP"` is the UDP protocol.
   */
  @NonNull
  @JsonProperty("protocol")
  private String protocol;

}

