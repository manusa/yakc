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

package com.marcnuri.yakc.model.io.istio.config.v1alpha2;

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
public class HTTPAPISpecSpec implements Model {


  @JsonProperty("apiKeys")
  @Singular(value = "addToApiKeys", ignoreNullCollections = true)
  private List<HTTPAPISpecSpecApiKeys> apiKeys;

  @JsonProperty("api_keys")
  @Singular(value = "addToApi_keys", ignoreNullCollections = true)
  private List<HTTPAPISpecSpecApiKeys> api_keys;

  @JsonProperty("attributes")
  private HTTPAPISpecSpecAttributes attributes;

  /**
   * List of HTTP patterns to match.
   */
  @JsonProperty("patterns")
  @Singular(value = "addToPatterns", ignoreNullCollections = true)
  private List<HTTPAPISpecSpecPatterns> patterns;

}

