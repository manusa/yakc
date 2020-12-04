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
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HTTPChaosSpecHeaders implements Model {


  @JsonProperty("exact_match")
  private String exact_match;

  @JsonProperty("invert_match")
  private String invert_match;

  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("prefix_match")
  private String prefix_match;

  @JsonProperty("present_match")
  private String present_match;

  @JsonProperty("range_match")
  private String range_match;

  @JsonProperty("regex_match")
  private String regex_match;

  @JsonProperty("safe_regex_match")
  private String safe_regex_match;

  @JsonProperty("suffix_match")
  private String suffix_match;

}

