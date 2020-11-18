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

package com.marcnuri.yakc.model.com.coreos.operators.v1;

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
 * OperatorGroupSpec is the spec for an OperatorGroup resource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OperatorGroupSpec implements Model {


  @JsonProperty("selector")
  private OperatorGroupSpecSelector selector;

  /**
   * ServiceAccountName is the admin specified service account which will be used to deploy operator(s) in this operator group.
   */
  @JsonProperty("serviceAccountName")
  private String serviceAccountName;

  /**
   * Static tells OLM not to update the OperatorGroup's providedAPIs annotation
   */
  @JsonProperty("staticProvidedAPIs")
  private Boolean staticProvidedAPIs;

  /**
   * TargetNamespaces is an explicit set of namespaces to target. If it is set, Selector is ignored.
   */
  @JsonProperty("targetNamespaces")
  @Singular(value = "addToTargetNamespaces", ignoreNullCollections = true)
  private List<String> targetNamespaces;

}

