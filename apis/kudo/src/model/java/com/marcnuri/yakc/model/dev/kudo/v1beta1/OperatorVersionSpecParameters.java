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

package com.marcnuri.yakc.model.dev.kudo.v1beta1;

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
 * Parameter captures the variability of an OperatorVersion being instantiated in an instance.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OperatorVersionSpecParameters implements Model {


  /**
   * Default is a default value if no parameter is provided by the instance.
   */
  @JsonProperty("default")
  private String defaults;

  /**
   * Description captures a longer description of how the parameter will be used.
   */
  @JsonProperty("description")
  private String description;

  /**
   * DisplayName can be used by UIs.
   */
  @JsonProperty("displayName")
  private String displayName;

  /**
   * Defines a list of allowed values. If Default is set and Enum is not nil, the value must be in this list as well
   */
  @JsonProperty("enum")
  @Singular(value = "addToEnumeration", ignoreNullCollections = true)
  private List<String> enumeration;

  /**
   * Specifies if the parameter can be changed after the initial installation of the operator
   */
  @JsonProperty("immutable")
  private Boolean immutable;

  /**
   * Name is the string that should be used in the template file for example, if `name: COUNT` then using the variable in a spec like: <br><p>  spec:   replicas:  {{ .Params.COUNT }}
   */
  @JsonProperty("name")
  private String name;

  /**
   * Required specifies if the parameter is required to be provided by all instances, or whether a default can suffice.
   */
  @JsonProperty("required")
  private Boolean required;

  /**
   * Trigger identifies the plan that gets executed when this parameter changes in the Instance object. Default is `update` if a plan with that name exists, otherwise it's `deploy`.
   */
  @JsonProperty("trigger")
  private String trigger;

  /**
   * Type specifies the value type. Defaults to `string`.
   */
  @JsonProperty("value-type")
  private String valueType;

}

