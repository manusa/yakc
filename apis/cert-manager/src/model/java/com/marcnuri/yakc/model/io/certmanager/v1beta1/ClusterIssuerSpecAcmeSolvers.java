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

package com.marcnuri.yakc.model.io.certmanager.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeDns01;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeSelector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Configures an issuer to solve challenges using the specified options. Only one of HTTP01 or DNS01 may be provided.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeSolvers implements Model {


  @JsonProperty("dns01")
  private ClusterIssuerSpecAcmeDns01 dns01;

  @JsonProperty("http01")
  private ClusterIssuerSpecAcmeHttp01 http01;

  @JsonProperty("selector")
  private ClusterIssuerSpecAcmeSelector selector;

}

