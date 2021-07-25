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
 * PodHttpChaosRule defines the injection rule for http.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodHttpChaosSpecRules implements Model {


  @NonNull
  @JsonProperty("actions")
  private PodHttpChaosSpecActions actions;

  /**
   * Port represents the target port to be proxy of.
   */
  @NonNull
  @JsonProperty("port")
  private Number port;

  @NonNull
  @JsonProperty("selector")
  private PodHttpChaosSpecSelector selector;

  /**
   * Source represents the source of current rules
   */
  @JsonProperty("source")
  private String source;

  /**
   * Target is the object to be selected and injected, &lt;Request|Response&gt;.
   */
  @NonNull
  @JsonProperty("target")
  private String target;

}

