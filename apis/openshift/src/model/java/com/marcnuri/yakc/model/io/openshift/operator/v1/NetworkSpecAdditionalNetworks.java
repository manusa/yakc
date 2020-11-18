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
import lombok.NonNull;
import lombok.ToString;

/**
 * AdditionalNetworkDefinition configures an extra network that is available but not created by default. Instead, pods must request them by name. type must be specified, along with exactly one "Config" that matches the type.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecAdditionalNetworks implements Model {


  /**
   * name is the name of the network. This will be populated in the resulting CRD This must be unique.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * namespace is the namespace of the network. This will be populated in the resulting CRD If not given the network will be created in the default namespace.
   */
  @JsonProperty("namespace")
  private String namespace;

  /**
   * rawCNIConfig is the raw CNI configuration json to create in the NetworkAttachmentDefinition CRD
   */
  @JsonProperty("rawCNIConfig")
  private String rawCNIConfig;

  @JsonProperty("simpleMacvlanConfig")
  private NetworkSpecSimpleMacvlanConfig simpleMacvlanConfig;

  /**
   * type is the type of network The supported values are NetworkTypeRaw, NetworkTypeSimpleMacvlan
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

