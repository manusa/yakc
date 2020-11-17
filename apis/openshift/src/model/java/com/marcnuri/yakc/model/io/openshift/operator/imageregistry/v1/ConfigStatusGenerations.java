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

package com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * GenerationStatus keeps track of the generation for a given resource so that decisions about forced updates can be made.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigStatusGenerations implements Model {


  /**
   * group is the group of the thing you're tracking
   */
  @JsonProperty("group")
  private String group;

  /**
   * hash is an optional field set for resources without generation that are content sensitive like secrets and configmaps
   */
  @JsonProperty("hash")
  private String hash;

  /**
   * lastGeneration is the last generation of the workload controller involved
   */
  @JsonProperty("lastGeneration")
  private Number lastGeneration;

  /**
   * name is the name of the thing you're tracking
   */
  @JsonProperty("name")
  private String name;

  /**
   * namespace is where the thing you're tracking is
   */
  @JsonProperty("namespace")
  private String namespace;

  /**
   * resource is the resource type of the thing you're tracking
   */
  @JsonProperty("resource")
  private String resource;

}

