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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * customLogoFile replaces the default OpenShift logo in the masthead and about dialog. It is a reference to a ConfigMap in the openshift-config namespace. This can be created with a command like 'oc create configmap custom-logo --from-file=/path/to/file -n openshift-config'. Image size must be less than 1 MB due to constraints on the ConfigMap size. The ConfigMap key should include a file extension so that the console serves the file with the correct MIME type. Recommended logo specifications: Dimensions: Max height of 68px and max width of 200px SVG format preferred
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsoleSpecCustomizationCustomLogoFile implements Model {


  /**
   * Key allows pointing to a specific key/value inside of the configmap.  This is useful for logical file references.
   */
  @JsonProperty("key")
  private String key;

  @JsonProperty("name")
  private String name;

}

