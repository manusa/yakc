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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ContainerPort represents a network port in a single container.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpecPorts implements Model {


  /**
   * Number of port to expose on the pod's IP address. This must be a valid port number, 0 &lt; x &lt; 65536.
   */
  @NonNull
  @JsonProperty("containerPort")
  private Number containerPort;

  /**
   * What host IP to bind the external port to.
   */
  @JsonProperty("hostIP")
  private String hostIP;

  /**
   * Number of port to expose on the host. If specified, this must be a valid port number, 0 &lt; x &lt; 65536. If HostNetwork is specified, this must match ContainerPort. Most containers do not need this.
   */
  @JsonProperty("hostPort")
  private Number hostPort;

  /**
   * If specified, this must be an IANA_SVC_NAME and unique within the pod. Each named port in a pod must have a unique name. Name for the port that can be referred to by services.
   */
  @JsonProperty("name")
  private String name;

  /**
   * Protocol for port. Must be UDP, TCP, or SCTP. Defaults to "TCP".
   */
  @JsonProperty("protocol")
  private String protocol;

}

