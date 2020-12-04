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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Delay4Servlet represents the detail about JVM chaos action of Servlet response delay
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JVMChaosSpecDelay4servlet implements Model {


  /**
   * Method represents HTTP request method, such as GET, POST, DELETE or PUT. Default is GET
   */
  @JsonProperty("method")
  private String method;

  /**
   * Offset represents delay fluctuation time
   */
  @JsonProperty("offset")
  private Number offset;

  /**
   * QueryString represents HTTP request query string
   */
  @JsonProperty("querystring")
  private String querystring;

  /**
   * RequestPath represents HTTP request path. The path should start with /
   */
  @NonNull
  @JsonProperty("requestpath")
  private String requestpath;

  /**
   * Time represents delay time, in milliseconds, required
   */
  @NonNull
  @JsonProperty("time")
  private Number time;

}

