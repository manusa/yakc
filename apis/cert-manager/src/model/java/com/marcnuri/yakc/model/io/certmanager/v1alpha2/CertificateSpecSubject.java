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

package com.marcnuri.yakc.model.io.certmanager.v1alpha2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Full X509 name specification (https://golang.org/pkg/crypto/x509/pkix/#Name).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateSpecSubject implements Model {


  /**
   * Countries to be used on the Certificate.
   */
  @JsonProperty("countries")
  @Singular(value = "addToCountries", ignoreNullCollections = true)
  private List<String> countries;

  /**
   * Cities to be used on the Certificate.
   */
  @JsonProperty("localities")
  @Singular(value = "addToLocalities", ignoreNullCollections = true)
  private List<String> localities;

  /**
   * Organizational Units to be used on the Certificate.
   */
  @JsonProperty("organizationalUnits")
  @Singular(value = "addToOrganizationalUnits", ignoreNullCollections = true)
  private List<String> organizationalUnits;

  /**
   * Postal codes to be used on the Certificate.
   */
  @JsonProperty("postalCodes")
  @Singular(value = "addToPostalCodes", ignoreNullCollections = true)
  private List<String> postalCodes;

  /**
   * State/Provinces to be used on the Certificate.
   */
  @JsonProperty("provinces")
  @Singular(value = "addToProvinces", ignoreNullCollections = true)
  private List<String> provinces;

  /**
   * Serial number to be used on the Certificate.
   */
  @JsonProperty("serialNumber")
  private String serialNumber;

  /**
   * Street addresses to be used on the Certificate.
   */
  @JsonProperty("streetAddresses")
  @Singular(value = "addToStreetAddresses", ignoreNullCollections = true)
  private List<String> streetAddresses;

}

