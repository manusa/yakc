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
 * StrategyDetailsDeployment represents the parsed details of a Deployment InstallStrategy.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterServiceVersionSpecInstallSpec implements Model {


  @JsonProperty("clusterPermissions")
  @Singular(value = "addToClusterPermissions", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecInstallSpecClusterPermissions> clusterPermissions;

  @NonNull
  @JsonProperty("deployments")
  @Singular(value = "addToDeployments", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecInstallSpecDeployments> deployments;

  @JsonProperty("permissions")
  @Singular(value = "addToPermissions", ignoreNullCollections = true)
  private List<ClusterServiceVersionSpecInstallSpecClusterPermissions> permissions;

}

