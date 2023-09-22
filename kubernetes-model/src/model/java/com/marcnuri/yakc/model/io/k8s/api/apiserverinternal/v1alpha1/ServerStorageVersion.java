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

package com.marcnuri.yakc.model.io.k8s.api.apiserverinternal.v1alpha1;

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
 * An API server instance reports the version it can decode and the version it encodes objects to when persisting objects in the backend.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ServerStorageVersion implements Model {


  /**
   * The ID of the reporting API server.
   */
  @JsonProperty("apiServerID")
  private String apiServerID;

  /**
   * The API server can decode objects encoded in these versions. The encodingVersion must be included in the decodableVersions.
   */
  @JsonProperty("decodableVersions")
  @Singular(value = "addToDecodableVersions", ignoreNullCollections = true)
  private List<String> decodableVersions;

  /**
   * The API server encodes the object to this version when persisting it in the backend (e.g., etcd).
   */
  @JsonProperty("encodingVersion")
  private String encodingVersion;

  /**
   * The API server can serve these versions. DecodableVersions must include all ServedVersions.
   */
  @JsonProperty("servedVersions")
  @Singular(value = "addToServedVersions", ignoreNullCollections = true)
  private List<String> servedVersions;

}

