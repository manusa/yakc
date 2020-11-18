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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * APIServerNamedServingCert maps a server DNS name, as understood by a client, to a certificate.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class APIServerSpecServingCertsNamedCertificates implements Model {


  /**
   * names is a optional list of explicit DNS names (leading wildcards allowed) that should use this certificate to serve secure traffic. If no names are provided, the implicit names will be extracted from the certificates. Exact names trump over wildcard names. Explicit names defined here trump over extracted implicit names.
   */
  @JsonProperty("names")
  @Singular(value = "addToNames", ignoreNullCollections = true)
  private List<String> names;

  @JsonProperty("servingCertificate")
  private APIServerSpecServingCertsServingCertificate servingCertificate;

}

