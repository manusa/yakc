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

package com.marcnuri.yakc.model.io.openshift.config.v1;

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
 * OperatorHubSpec defines the desired state of OperatorHub
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OperatorHubSpec implements Model {


  /**
   * disableAllDefaultSources allows you to disable all the default hub sources. If this is true, a specific entry in sources can be used to enable a default source. If this is false, a specific entry in sources can be used to disable or enable a default source.
   */
  @JsonProperty("disableAllDefaultSources")
  private Boolean disableAllDefaultSources;

  /**
   * sources is the list of default hub sources and their configuration. If the list is empty, it implies that the default hub sources are enabled on the cluster unless disableAllDefaultSources is true. If disableAllDefaultSources is true and sources is not empty, the configuration present in sources will take precedence. The list of default hub sources and their current state will always be reflected in the status block.
   */
  @JsonProperty("sources")
  @Singular(value = "addToSources", ignoreNullCollections = true)
  private List<OperatorHubSpecSources> sources;

}

