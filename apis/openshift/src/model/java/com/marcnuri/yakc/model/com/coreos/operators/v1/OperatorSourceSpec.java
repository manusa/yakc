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

package com.marcnuri.yakc.model.com.coreos.operators.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * OperatorSourceSpec defines the desired state of OperatorSource
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OperatorSourceSpec implements Model {


  @JsonProperty("authorizationToken")
  private OperatorSourceSpecAuthorizationToken authorizationToken;

  /**
   * DisplayName is passed along to the CatalogSourceConfig to be used by the resulting CatalogSource to be used as a pretty name.
   */
  @JsonProperty("displayName")
  private String displayName;

  /**
   * Endpoint points to the remote app registry server from where operator manifests can be fetched.
   */
  @NonNull
  @JsonProperty("endpoint")
  private String endpoint;

  /**
   * Publisher is passed along to the CatalogSourceConfig to be used by the resulting CatalogSource that defines what entity published the artifacts from the OperatorSource.
   */
  @JsonProperty("publisher")
  private String publisher;

  /**
   * RegistryNamespace refers to the namespace in app registry. Only operator manifests under this namespace will be visible. Please note that this is not a k8s namespace.
   */
  @NonNull
  @JsonProperty("registryNamespace")
  private String registryNamespace;

  /**
   * Type of operator source.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

