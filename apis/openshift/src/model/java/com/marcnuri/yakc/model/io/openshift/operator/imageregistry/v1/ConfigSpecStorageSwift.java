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
 * swift represents configuration that uses OpenStack Object Storage.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigSpecStorageSwift implements Model {


  /**
   * authURL defines the URL for obtaining an authentication token.
   */
  @JsonProperty("authURL")
  private String authURL;

  /**
   * authVersion specifies the OpenStack Auth's version.
   */
  @JsonProperty("authVersion")
  private String authVersion;

  /**
   * container defines the name of Swift container where to store the registry's data.
   */
  @JsonProperty("container")
  private String container;

  /**
   * domain specifies Openstack's domain name for Identity v3 API.
   */
  @JsonProperty("domain")
  private String domain;

  /**
   * domainID specifies Openstack's domain id for Identity v3 API.
   */
  @JsonProperty("domainID")
  private String domainID;

  /**
   * regionName defines Openstack's region in which container exists.
   */
  @JsonProperty("regionName")
  private String regionName;

  /**
   * tenant defines Openstack tenant name to be used by registry.
   */
  @JsonProperty("tenant")
  private String tenant;

  /**
   * tenant defines Openstack tenant id to be used by registry.
   */
  @JsonProperty("tenantID")
  private String tenantID;

}

