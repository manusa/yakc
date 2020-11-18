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
 * spec holds user settable values for configuration
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SchedulerSpec implements Model {


  /**
   * defaultNodeSelector helps set the cluster-wide default node selector to restrict pod placement to specific nodes. This is applied to the pods created in all namespaces without a specified nodeSelector value. For example, defaultNodeSelector: "type=user-node,region=east" would set nodeSelector field in pod spec to "type=user-node,region=east" to all pods created in all namespaces. Namespaces having project-wide node selectors won't be impacted even if this field is set. This adds an annotation section to the namespace. For example, if a new namespace is created with node-selector='type=user-node,region=east', the annotation openshift.io/node-selector: type=user-node,region=east gets added to the project. When the openshift.io/node-selector annotation is set on the project the value is used in preference to the value we are setting for defaultNodeSelector field. For instance, openshift.io/node-selector: "type=user-node,region=west" means that the default of "type=user-node,region=east" set in defaultNodeSelector would not be applied.
   */
  @JsonProperty("defaultNodeSelector")
  private String defaultNodeSelector;

  /**
   * MastersSchedulable allows masters nodes to be schedulable. When this flag is turned on, all the master nodes in the cluster will be made schedulable, so that workload pods can run on them. The default value for this field is false, meaning none of the master nodes are schedulable. Important Note: Once the workload pods start running on the master nodes, extreme care must be taken to ensure that cluster-critical control plane components are not impacted. Please turn on this field after doing due diligence.
   */
  @JsonProperty("mastersSchedulable")
  private Boolean mastersSchedulable;

  @JsonProperty("policy")
  private SchedulerSpecPolicy policy;

}

