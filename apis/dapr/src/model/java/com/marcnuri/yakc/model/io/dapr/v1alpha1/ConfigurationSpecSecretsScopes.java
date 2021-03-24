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

package com.marcnuri.yakc.model.io.dapr.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * SecretsScope defines the scope for secrets
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigurationSpecSecretsScopes implements Model {


  @JsonProperty("allowedSecrets")
  @Singular(value = "addToAllowedSecrets", ignoreNullCollections = true)
  private List<String> allowedSecrets;

  @JsonProperty("defaultAccess")
  private String defaultAccess;

  @JsonProperty("deniedSecrets")
  @Singular(value = "addToDeniedSecrets", ignoreNullCollections = true)
  private List<String> deniedSecrets;

  @NonNull
  @JsonProperty("storeName")
  private String storeName;

}

