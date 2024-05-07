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

package com.marcnuri.yakc.model.io.k8s.api.networking.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ParentReference describes a reference to a parent object.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ParentReference implements Model {


  /**
   * Group is the group of the object being referenced.
   */
  @JsonProperty("group")
  private String group;

  /**
   * Name is the name of the object being referenced.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Namespace is the namespace of the object being referenced.
   */
  @JsonProperty("namespace")
  private String namespace;

  /**
   * Resource is the resource of the object being referenced.
   */
  @NonNull
  @JsonProperty("resource")
  private String resource;

}

