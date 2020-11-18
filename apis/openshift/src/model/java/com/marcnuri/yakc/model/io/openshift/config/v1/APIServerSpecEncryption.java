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
 * encryption allows the configuration of encryption of resources at the datastore layer.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class APIServerSpecEncryption implements Model {


  /**
   * type defines what encryption type should be used to encrypt resources at the datastore layer. When this field is unset (i.e. when it is set to the empty string), identity is implied. The behavior of unset can and will change over time.  Even if encryption is enabled by default, the meaning of unset may change to a different encryption type based on changes in best practices. <br><p>  When encryption is enabled, all sensitive resources shipped with the platform are encrypted. This list of sensitive resources can and will change over time.  The current authoritative list is: <br><p>    1. secrets   2. configmaps   3. routes.route.openshift.io   4. oauthaccesstokens.oauth.openshift.io   5. oauthauthorizetokens.oauth.openshift.io
   */
  @JsonProperty("type")
  private String type;

}

