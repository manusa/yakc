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

package com.marcnuri.yakc.model.io.openshift.console.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ConsoleYAMLSampleSpec is the desired YAML sample configuration. Samples will appear with their descriptions in a samples sidebar when creating a resources in the web console.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsoleYAMLSampleSpec implements Model {


  /**
   * description of the YAML sample.
   */
  @NonNull
  @JsonProperty("description")
  private String description;

  /**
   * snippet indicates that the YAML sample is not the full YAML resource definition, but a fragment that can be inserted into the existing YAML document at the user's cursor.
   */
  @JsonProperty("snippet")
  private Boolean snippet;

  @NonNull
  @JsonProperty("targetResource")
  private ConsoleYAMLSampleSpecTargetResource targetResource;

  /**
   * title of the YAML sample.
   */
  @NonNull
  @JsonProperty("title")
  private String title;

  /**
   * yaml is the YAML sample to display.
   */
  @NonNull
  @JsonProperty("yaml")
  private String yaml;

}

