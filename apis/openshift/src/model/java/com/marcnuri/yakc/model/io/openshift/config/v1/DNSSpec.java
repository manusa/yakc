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
import lombok.ToString;

/**
 * spec holds user settable values for configuration
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DNSSpec implements Model {


  /**
   * baseDomain is the base domain of the cluster. All managed DNS records will be sub-domains of this base. <br><p>  For example, given the base domain `openshift.example.com`, an API server DNS record may be created for `cluster-api.openshift.example.com`. <br><p>  Once set, this field cannot be changed.
   */
  @JsonProperty("baseDomain")
  private String baseDomain;

  @JsonProperty("privateZone")
  private DNSSpecPrivateZone privateZone;

  @JsonProperty("publicZone")
  private DNSSpecPublicZone publicZone;

}

