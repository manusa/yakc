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
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * OperatorVersionSpec defines the desired state of OperatorVersion.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OperatorVersionSpec implements Model {


  @JsonProperty("appVersion")
  private String appVersion;

  /**
   * ConnectionString defines a templated string that can be used to connect to an instance of the Operator.
   */
  @JsonProperty("connectionString")
  private String connectionString;

  @JsonProperty("operator")
  private OperatorVersionSpecOperator operator;

  @JsonProperty("parameters")
  @Singular(value = "addToParameters", ignoreNullCollections = true)
  private List<OperatorVersionSpecParameters> parameters;

  /**
   * Plans maps a plan name to a plan.
   */
  @JsonProperty("plans")
  private Object plans;

  /**
   * List of all tasks available in this OperatorVersion.
   */
  @JsonProperty("tasks")
  @Singular(value = "addToTasks", ignoreNullCollections = true)
  private List<OperatorVersionSpecTasks> tasks;

  /**
   * Templates is a list of references to YAML templates located in the templates folder and later referenced from tasks.
   */
  @JsonProperty("templates")
  @Singular(value = "putInTemplates", ignoreNullCollections = true)
  private Map<String, String> templates;

  /**
   * UpgradableFrom lists all OperatorVersions that can upgrade to this OperatorVersion.
   */
  @JsonProperty("upgradableFrom")
  @Singular(value = "addToUpgradableFrom", ignoreNullCollections = true)
  private List<OperatorVersionSpecOperator> upgradableFrom;

  @JsonProperty("version")
  private String version;

}

