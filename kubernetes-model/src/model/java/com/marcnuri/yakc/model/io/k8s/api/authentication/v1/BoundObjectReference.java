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

package com.marcnuri.yakc.model.io.k8s.api.authentication.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * BoundObjectReference is a reference to an object that a token is bound to.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BoundObjectReference implements Model {


  /**
   * API version of the referent.
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * Kind of the referent. Valid kinds are 'Pod' and 'Secret'.
   */
  @JsonProperty("kind")
  private String kind;

  /**
   * Name of the referent.
   */
  @JsonProperty("name")
  private String name;

  /**
   * UID of the referent.
   */
  @JsonProperty("uid")
  private String uid;

}

