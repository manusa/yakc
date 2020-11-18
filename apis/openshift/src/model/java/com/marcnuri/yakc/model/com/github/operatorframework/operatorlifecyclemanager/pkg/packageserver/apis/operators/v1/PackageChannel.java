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

package com.marcnuri.yakc.model.com.github.operatorframework.operatorlifecyclemanager.pkg.packageserver.apis.operators.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * PackageChannel defines a single channel under a package, pointing to a version of that package.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageChannel implements Model {


  /**
   * CurrentCSV defines a reference to the CSV holding the version of this package currently for the channel.
   */
  @NonNull
  @JsonProperty("currentCSV")
  private String currentCSV;

  @JsonProperty("currentCSVDesc")
  private CSVDescription currentCSVDesc;

  /**
   * Name is the name of the channel, e.g. `alpha` or `stable`
   */
  @NonNull
  @JsonProperty("name")
  private String name;

}

