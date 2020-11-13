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

package com.marcnuri.yakc.model.com.github.openshift.api.template.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Parameter defines a name/value variable that is to be processed during the Template to Config transformation.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Parameter implements Model {


  /**
   * Description of a parameter. Optional.
   */
  @JsonProperty("description")
  private String description;

  /**
   * Optional: The name that will show in UI instead of parameter 'Name'
   */
  @JsonProperty("displayName")
  private String displayName;

  /**
   * From is an input value for the generator. Optional.
   */
  @JsonProperty("from")
  private String from;

  /**
   * generate specifies the generator to be used to generate random string from an input value specified by From field. The result string is stored into Value field. If empty, no generator is being used, leaving the result Value untouched. Optional.<br><p> <br><p> The only supported generator is "expression", which accepts a "from" value in the form of a simple regular expression containing the range expression "[a-zA-Z0-9]", and the length expression "a{length}".<br><p> <br><p> Examples:<br><p> <br><p> from             | value ----------------------------- "test[0-9]{1}x"  | "test7x" "[0-1]{8}"       | "01001100" "0x[A-F0-9]{4}"  | "0xB3AF" "[a-zA-Z0-9]{8}" | "hW4yQU5i"
   */
  @JsonProperty("generate")
  private String generate;

  /**
   * Name must be set and it can be referenced in Template Items using ${PARAMETER_NAME}. Required.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Optional: Indicates the parameter must have a value.  Defaults to false.
   */
  @JsonProperty("required")
  private Boolean required;

  /**
   * Value holds the Parameter data. If specified, the generator will be ignored. The value replaces all occurrences of the Parameter ${Name} expression during the Template to Config transformation. Optional.
   */
  @JsonProperty("value")
  private String value;

}

