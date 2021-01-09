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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Selector is used to select pods that are used to inject chaos action.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DNSChaosSpecSelector implements Model {


  /**
   * Map of string keys and values that can be used to select objects. A selector based on annotations.
   */
  @JsonProperty("annotationSelectors")
  @Singular(value = "putInAnnotationSelectors", ignoreNullCollections = true)
  private Map<String, String> annotationSelectors;

  /**
   * a slice of label selector expressions that can be used to select objects. A list of selectors based on set-based label expressions.
   */
  @JsonProperty("expressionSelectors")
  @Singular(value = "addToExpressionSelectors", ignoreNullCollections = true)
  private List<DNSChaosSpecSelectorExpressionSelectors> expressionSelectors;

  /**
   * Map of string keys and values that can be used to select objects. A selector based on fields.
   */
  @JsonProperty("fieldSelectors")
  @Singular(value = "putInFieldSelectors", ignoreNullCollections = true)
  private Map<String, String> fieldSelectors;

  /**
   * Map of string keys and values that can be used to select objects. A selector based on labels.
   */
  @JsonProperty("labelSelectors")
  @Singular(value = "putInLabelSelectors", ignoreNullCollections = true)
  private Map<String, String> labelSelectors;

  /**
   * Namespaces is a set of namespace to which objects belong.
   */
  @JsonProperty("namespaces")
  @Singular(value = "addToNamespaces", ignoreNullCollections = true)
  private List<String> namespaces;

  /**
   * Map of string keys and values that can be used to select nodes. Selector which must match a node's labels, and objects must belong to these selected nodes.
   */
  @JsonProperty("nodeSelectors")
  @Singular(value = "putInNodeSelectors", ignoreNullCollections = true)
  private Map<String, String> nodeSelectors;

  /**
   * Nodes is a set of node name and objects must belong to these nodes.
   */
  @JsonProperty("nodes")
  @Singular(value = "addToNodes", ignoreNullCollections = true)
  private List<String> nodes;

  /**
   * PodPhaseSelectors is a set of condition of a pod at the current time. supported value: Pending / Running / Succeeded / Failed / Unknown
   */
  @JsonProperty("podPhaseSelectors")
  @Singular(value = "addToPodPhaseSelectors", ignoreNullCollections = true)
  private List<String> podPhaseSelectors;

  /**
   * Pods is a map of string keys and a set values that used to select pods. The key defines the namespace which pods belong, and the each values is a set of pod names.
   */
  @JsonProperty("pods")
  @Singular(value = "putInPods", ignoreNullCollections = true)
  private Map<String, List<String>> pods;

}

