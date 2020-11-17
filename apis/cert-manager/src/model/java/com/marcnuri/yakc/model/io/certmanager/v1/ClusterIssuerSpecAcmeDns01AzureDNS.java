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

package com.marcnuri.yakc.model.io.certmanager.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Use the Microsoft Azure DNS API to manage DNS01 challenge records.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeDns01AzureDNS implements Model {


  /**
   * if both this and ClientSecret are left unset MSI will be used
   */
  @JsonProperty("clientID")
  private String clientID;

  @JsonProperty("clientSecretSecretRef")
  private ClusterIssuerSpecAcmeDns01AzureDNSClientSecretSecretRef clientSecretSecretRef;

  @JsonProperty("environment")
  private String environment;

  @JsonProperty("hostedZoneName")
  private String hostedZoneName;

  @NonNull
  @JsonProperty("resourceGroupName")
  private String resourceGroupName;

  @NonNull
  @JsonProperty("subscriptionID")
  private String subscriptionID;

  /**
   * when specifying ClientID and ClientSecret then this field is also needed
   */
  @JsonProperty("tenantID")
  private String tenantID;

}

