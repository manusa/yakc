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
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * OperatorGroupStatus is the status for an OperatorGroupResource.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OperatorGroupStatus implements Model {


  /**
   * LastUpdated is a timestamp of the last time the OperatorGroup's status was Updated.
   */
  @NonNull
  @JsonProperty("lastUpdated")
  private OffsetDateTime lastUpdated;

  /**
   * Namespaces is the set of target namespaces for the OperatorGroup.
   */
  @JsonProperty("namespaces")
  @Singular(value = "addToNamespaces", ignoreNullCollections = true)
  private List<String> namespaces;

  @JsonProperty("serviceAccountRef")
  private OperatorGroupStatusServiceAccountRef serviceAccountRef;

}

