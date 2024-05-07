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

package com.marcnuri.yakc.model.io.k8s.api.resource.v1alpha2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.runtime.RawExtension;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * StructuredResourceHandle is the in-tree representation of the allocation result.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StructuredResourceHandle implements Model {


  /**
   * NodeName is the name of the node providing the necessary resources if the resources are local to a node.
   */
  @JsonProperty("nodeName")
  private String nodeName;

  /**
   * Results lists all allocated driver resources.
   */
  @NonNull
  @JsonProperty("results")
  @Singular(value = "addToResults", ignoreNullCollections = true)
  private List<DriverAllocationResult> results;

  @JsonProperty("vendorClaimParameters")
  private RawExtension vendorClaimParameters;

  @JsonProperty("vendorClassParameters")
  private RawExtension vendorClassParameters;

}

