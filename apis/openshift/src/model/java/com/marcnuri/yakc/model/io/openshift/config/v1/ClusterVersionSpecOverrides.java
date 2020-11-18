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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ComponentOverride allows overriding cluster version operator's behavior for a component.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterVersionSpecOverrides implements Model {


  /**
   * group identifies the API group that the kind is in.
   */
  @NonNull
  @JsonProperty("group")
  private String group;

  /**
   * kind indentifies which object to override.
   */
  @NonNull
  @JsonProperty("kind")
  private String kind;

  /**
   * name is the component's name.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * namespace is the component's namespace. If the resource is cluster scoped, the namespace should be empty.
   */
  @NonNull
  @JsonProperty("namespace")
  private String namespace;

  /**
   * unmanaged controls if cluster version operator should stop managing the resources in this cluster. Default: false
   */
  @NonNull
  @JsonProperty("unmanaged")
  private Boolean unmanaged;

}

