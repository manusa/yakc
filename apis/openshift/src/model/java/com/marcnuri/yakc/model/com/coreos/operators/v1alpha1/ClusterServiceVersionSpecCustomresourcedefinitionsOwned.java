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

package com.marcnuri.yakc.model.com.coreos.operators.v1alpha1;

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
 * CRDDescription provides details to OLM about the CRDs
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterServiceVersionSpecCustomresourcedefinitionsOwned implements Model {


  @JsonProperty("actionDescriptors")
  @Singular(value = "addToActionDescriptors", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecApiservicedefinitionsActionDescriptors> actionDescriptors;

  @JsonProperty("description")
  private String description;

  @JsonProperty("displayName")
  private String displayName;

  @NonNull
  @JsonProperty("kind")
  private String kind;

  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("resources")
  @Singular(value = "addToResources", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecApiservicedefinitionsResources> resources;

  @JsonProperty("specDescriptors")
  @Singular(value = "addToSpecDescriptors", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecApiservicedefinitionsSpecDescriptors> specDescriptors;

  @JsonProperty("statusDescriptors")
  @Singular(value = "addToStatusDescriptors", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecApiservicedefinitionsStatusDescriptors> statusDescriptors;

  @NonNull
  @JsonProperty("version")
  private String version;

}

