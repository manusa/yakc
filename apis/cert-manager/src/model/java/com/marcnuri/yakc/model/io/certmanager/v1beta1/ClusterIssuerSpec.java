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
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecCa;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecSelfSigned;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecVault;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecVenafi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Desired state of the ClusterIssuer resource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpec implements Model {


  @JsonProperty("acme")
  private ClusterIssuerSpecAcme acme;

  @JsonProperty("ca")
  private ClusterIssuerSpecCa ca;

  @JsonProperty("selfSigned")
  private ClusterIssuerSpecSelfSigned selfSigned;

  @JsonProperty("vault")
  private ClusterIssuerSpecVault vault;

  @JsonProperty("venafi")
  private ClusterIssuerSpecVenafi venafi;

}

