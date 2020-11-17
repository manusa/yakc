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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecAffinityPodAffinityPodAffinityTermLabelSelectorMatchExpressions;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * nodeSelector is the node selector applied to ingress controller deployments. <br><p>  If unset, the default is: <br><p>    beta.kubernetes.io/os: linux   node-role.kubernetes.io/worker: '' <br><p>  If set, the specified selector is used and replaces the default.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerSpecNodePlacementNodeSelector implements Model {


  /**
   * matchExpressions is a list of label selector requirements. The requirements are ANDed.
   */
  @JsonProperty("matchExpressions")
  @Singular(value = "addToMatchExpressions", ignoreNullCollections = true)
  private List<AlertmanagerSpecAffinityPodAffinityPodAffinityTermLabelSelectorMatchExpressions> matchExpressions;

  /**
   * matchLabels is a map of {key,value} pairs. A single {key,value} in the matchLabels map is equivalent to an element of matchExpressions, whose key field is "key", the operator is "In", and the values array contains only "value". The requirements are ANDed.
   */
  @JsonProperty("matchLabels")
  @Singular(value = "putInMatchLabels", ignoreNullCollections = true)
  private Map<String, String> matchLabels;

}

