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
import lombok.NonNull;
import lombok.ToString;

/**
 * clientCA references a ConfigMap containing a certificate bundle for the signers that will be recognized for incoming client certificates in addition to the operator managed signers. If this is empty, then only operator managed signers are valid. You usually only have to set this if you have your own PKI you wish to honor client certificates from. The ConfigMap must exist in the openshift-config namespace and contain the following required fields: - ConfigMap.Data["ca-bundle.crt"] - CA bundle.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class APIServerSpecClientCA implements Model {


  /**
   * name is the metadata.name of the referenced config map
   */
  @NonNull
  @JsonProperty("name")
  private String name;

}

