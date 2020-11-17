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

package com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * proxy defines the proxy to be used when calling master api, upstream registries, etc.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigSpecProxy implements Model {


  /**
   * http defines the proxy to be used by the image registry when accessing HTTP endpoints.
   */
  @JsonProperty("http")
  private String http;

  /**
   * https defines the proxy to be used by the image registry when accessing HTTPS endpoints.
   */
  @JsonProperty("https")
  private String https;

  /**
   * noProxy defines a comma-separated list of host names that shouldn't go through any proxy.
   */
  @JsonProperty("noProxy")
  private String noProxy;

}

