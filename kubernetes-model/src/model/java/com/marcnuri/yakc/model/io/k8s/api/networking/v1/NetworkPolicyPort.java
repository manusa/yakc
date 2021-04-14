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

package com.marcnuri.yakc.model.io.k8s.api.networking.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * NetworkPolicyPort describes a port to allow traffic on
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkPolicyPort implements Model {


  /**
   * If set, indicates that the range of ports from port to endPort, inclusive, should be allowed by the policy. This field cannot be defined if the port field is not defined or if the port field is defined as a named (string) port. The endPort must be equal or greater than port. This feature is in Alpha state and should be enabled using the Feature Gate "NetworkPolicyEndPort".
   */
  @JsonProperty("endPort")
  private Number endPort;

  @JsonProperty("port")
  @JsonSerialize(using = com.marcnuri.yakc.model.serialization.IntOrStringSerializer.class)
  private String port;

  /**
   * The protocol (TCP, UDP, or SCTP) which traffic must match. If not specified, this field defaults to TCP.
   */
  @JsonProperty("protocol")
  private String protocol;

}

