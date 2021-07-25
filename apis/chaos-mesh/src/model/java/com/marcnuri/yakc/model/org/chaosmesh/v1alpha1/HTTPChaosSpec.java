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
import lombok.NonNull;
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
public class HTTPChaosSpec implements Model {


  /**
   * Abort is a rule to abort a http session.
   */
  @JsonProperty("abort")
  private Boolean abort;

  /**
   * Code is a rule to select target by http status code in response.
   */
  @JsonProperty("code")
  private Number code;

  /**
   * Delay represents the delay of the target request/response. A duration string is a possibly unsigned sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
   */
  @JsonProperty("delay")
  private String delay;

  /**
   * Duration represents the duration of the chaos action.
   */
  @JsonProperty("duration")
  private String duration;

  /**
   * Method is a rule to select target by http method in request.
   */
  @JsonProperty("method")
  private String method;

  /**
   * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
   */
  @NonNull
  @JsonProperty("mode")
  private String mode;

  @JsonProperty("patch")
  private HTTPChaosSpecPatch patch;

  /**
   * Path is a rule to select target by uri path in http request.
   */
  @JsonProperty("path")
  private String path;

  /**
   * Port represents the target port to be proxy of.
   */
  @JsonProperty("port")
  private Number port;

  @JsonProperty("replace")
  private HTTPChaosSpecReplace replace;

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

  @NonNull
  @JsonProperty("selector")
  private DNSChaosSpecSelector selector;

  /**
   * Target is the object to be selected and injected.
   */
  @NonNull
  @JsonProperty("target")
  private String target;

  /**
   * Value is required when the mode is set to `FixedPodMode` / `FixedPercentPodMod` / `RandomMaxPercentPodMod`. If `FixedPodMode`, provide an integer of pods to do chaos action. If `FixedPercentPodMod`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentPodMod`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
   */
  @JsonProperty("value")
  private String value;

}

