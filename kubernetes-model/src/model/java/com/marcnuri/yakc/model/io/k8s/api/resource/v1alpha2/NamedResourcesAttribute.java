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

package com.marcnuri.yakc.model.io.k8s.api.resource.v1alpha2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * NamedResourcesAttribute is a combination of an attribute name and its value.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NamedResourcesAttribute implements Model {


  /**
   * BoolValue is a true/false value.
   */
  @JsonProperty("bool")
  private Boolean bool;

  /**
   * IntValue is a 64-bit integer.
   */
  @JsonProperty("int")
  private Number int32;

  @JsonProperty("intSlice")
  private NamedResourcesIntSlice intSlice;

  /**
   * Name is unique identifier among all resource instances managed by the driver on the node. It must be a DNS subdomain.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("quantity")
  private String quantity;

  /**
   * StringValue is a string.
   */
  @JsonProperty("string")
  private String string;

  @JsonProperty("stringSlice")
  private NamedResourcesStringSlice stringSlice;

  /**
   * VersionValue is a semantic version according to semver.org spec 2.0.0.
   */
  @JsonProperty("version")
  private String version;

}

