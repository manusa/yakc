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
 * Cross-Origin Resource Sharing policy (CORS).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VirtualServiceSpecCorsPolicy implements Model {


  @JsonProperty("allowCredentials")
  private Object allowCredentials;

  @JsonProperty("allowHeaders")
  @Singular(value = "addToAllowHeaders", ignoreNullCollections = true)
  private List<String> allowHeaders;

  /**
   * List of HTTP methods allowed to access the resource.
   */
  @JsonProperty("allowMethods")
  @Singular(value = "addToAllowMethods", ignoreNullCollections = true)
  private List<String> allowMethods;

  /**
   * The list of origins that are allowed to perform CORS requests.
   */
  @JsonProperty("allowOrigin")
  @Singular(value = "addToAllowOrigin", ignoreNullCollections = true)
  private List<String> allowOrigin;

  /**
   * String patterns that match allowed origins.
   */
  @JsonProperty("allowOrigins")
  @Singular(value = "addToAllowOrigins", ignoreNullCollections = true)
  private List<VirtualServiceSpecCorsPolicyAllowOrigins> allowOrigins;

  @JsonProperty("exposeHeaders")
  @Singular(value = "addToExposeHeaders", ignoreNullCollections = true)
  private List<String> exposeHeaders;

  @JsonProperty("maxAge")
  private String maxAge;

}

