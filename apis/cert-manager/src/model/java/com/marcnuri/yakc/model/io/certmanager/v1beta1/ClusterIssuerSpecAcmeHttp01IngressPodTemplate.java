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
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeHttp01IngressPodTemplateMetadata;
import com.marcnuri.yakc.model.io.certmanager.v1.ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Optional pod template used to configure the ACME challenge solver pods used for HTTP01 challenges
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeHttp01IngressPodTemplate implements Model {


  @JsonProperty("metadata")
  private ClusterIssuerSpecAcmeHttp01IngressPodTemplateMetadata metadata;

  @JsonProperty("spec")
  private ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpec spec;

}
