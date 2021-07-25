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
 * Replace is a rule to replace some contents in target.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HTTPChaosSpecReplace implements Model {


  /**
   * Body is a rule to replace http message body in target.
   */
  @JsonProperty("body")
  private String body;

  /**
   * Code is a rule to replace http status code in response.
   */
  @JsonProperty("code")
  private Number code;

  /**
   * Headers is a rule to replace http headers of target. The key-value pairs represent header name and header value pairs.
   */
  @JsonProperty("headers")
  @Singular(value = "putInHeaders", ignoreNullCollections = true)
  private Map<String, String> headers;

  /**
   * Method is a rule to replace http method in request.
   */
  @JsonProperty("method")
  private String method;

  /**
   * Path is rule to to replace uri path in http request.
   */
  @JsonProperty("path")
  private String path;

  /**
   * Queries is a rule to replace uri queries in http request. For example, with value `{ "foo": "unknown" }`, the `/?foo=bar` will be altered to `/?foo=unknown`,
   */
  @JsonProperty("queries")
  @Singular(value = "putInQueries", ignoreNullCollections = true)
  private Map<String, String> queries;

}

