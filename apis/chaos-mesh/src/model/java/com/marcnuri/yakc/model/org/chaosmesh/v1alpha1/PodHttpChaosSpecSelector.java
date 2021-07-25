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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Selector contains the rules to select target.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodHttpChaosSpecSelector implements Model {


  /**
   * Code is a rule to select target by http status code in response.
   */
  @JsonProperty("code")
  private Number code;

  /**
   * Method is a rule to select target by http method in request.
   */
  @JsonProperty("method")
  private String method;

  /**
   * Path is a rule to select target by uri path in http request.
   */
  @JsonProperty("path")
  private String path;

  /**
   * Port is a rule to select server listening on specific port.
   */
  @JsonProperty("port")
  private Number port;

  /**
   * RequestHeaders is a rule to select target by http headers in request. The key-value pairs represent header name and header value pairs.
   */
  @JsonProperty("request_headers")
  @Singular(value = "putInRequest_headers", ignoreNullCollections = true)
  private Map<String, String> request_headers;

  /**
   * ResponseHeaders is a rule to select target by http headers in response. The key-value pairs represent header name and header value pairs.
   */
  @JsonProperty("response_headers")
  @Singular(value = "putInResponse_headers", ignoreNullCollections = true)
  private Map<String, String> response_headers;

}

