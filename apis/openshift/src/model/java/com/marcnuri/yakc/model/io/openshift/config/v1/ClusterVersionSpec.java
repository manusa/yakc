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
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * spec is the desired state of the cluster version - the operator will work to ensure that the desired version is applied to the cluster.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterVersionSpec implements Model {


  /**
   * channel is an identifier for explicitly requesting that a non-default set of updates be applied to this cluster. The default channel will be contain stable updates that are appropriate for production clusters.
   */
  @JsonProperty("channel")
  private String channel;

  /**
   * clusterID uniquely identifies this cluster. This is expected to be an RFC4122 UUID value (xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx in hexadecimal values). This is a required field.
   */
  @NonNull
  @JsonProperty("clusterID")
  private String clusterID;

  @JsonProperty("desiredUpdate")
  private ClusterVersionSpecDesiredUpdate desiredUpdate;

  /**
   * overrides is list of overides for components that are managed by cluster version operator. Marking a component unmanaged will prevent the operator from creating or updating the object.
   */
  @JsonProperty("overrides")
  @Singular(value = "addToOverrides", ignoreNullCollections = true)
  private List<ClusterVersionSpecOverrides> overrides;

  /**
   * upstream may be used to specify the preferred update server. By default it will use the appropriate update server for the cluster and region.
   */
  @JsonProperty("upstream")
  private String upstream;

}

