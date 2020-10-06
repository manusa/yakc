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

package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ServiceReference holds a reference to Service.legacy.k8s.io
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ServiceReference implements Model {


  /**
   * name is the name of the service. Required
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * namespace is the namespace of the service. Required
   */
  @NonNull
  @JsonProperty("namespace")
  private String namespace;

  /**
   * path is an optional URL path at which the webhook will be contacted.
   */
  @JsonProperty("path")
  private String path;

  /**
   * port is an optional service port at which the webhook will be contacted. `port` should be a valid port number (1-65535, inclusive). Defaults to 443 for backward compatibility.
   */
  @JsonProperty("port")
  private Number port;

}

