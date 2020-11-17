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

package com.marcnuri.yakc.model.com.coreos.operators.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * CatalogSourceConfigSpec defines the desired state of CatalogSourceConfig
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CatalogSourceConfigSpec implements Model {


  /**
   * DisplayName is passed along to the CatalogSource to be used as a pretty name.
   */
  @JsonProperty("csDisplayName")
  private String csDisplayName;

  /**
   * Publisher is passed along to the CatalogSource to be used to define what entity published the artifacts from the OperatorSource.
   */
  @JsonProperty("csPublisher")
  private String csPublisher;

  @NonNull
  @JsonProperty("packages")
  private String packages;

  /**
   * The name of the OperatorSource that the packages originate from
   */
  @NonNull
  @JsonProperty("source")
  private String source;

  @NonNull
  @JsonProperty("targetNamespace")
  private String targetNamespace;

}

