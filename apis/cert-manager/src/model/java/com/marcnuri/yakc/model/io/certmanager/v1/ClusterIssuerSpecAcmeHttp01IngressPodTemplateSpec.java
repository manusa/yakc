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

package com.marcnuri.yakc.model.io.certmanager.v1;

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
 * PodSpec defines overrides for the HTTP01 challenge solver pod. Only the 'priorityClassName', 'nodeSelector', 'affinity', 'serviceAccountName' and 'tolerations' fields are supported currently. All other fields will be ignored.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpec implements Model {


  @JsonProperty("affinity")
  private ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpecAffinity affinity;

  /**
   * NodeSelector is a selector which must be true for the pod to fit on a node. Selector which must match a node's labels for the pod to be scheduled on that node. More info: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/
   */
  @JsonProperty("nodeSelector")
  @Singular(value = "putInNodeSelector", ignoreNullCollections = true)
  private Map<String, String> nodeSelector;

  /**
   * If specified, the pod's priorityClassName.
   */
  @JsonProperty("priorityClassName")
  private String priorityClassName;

  /**
   * If specified, the pod's service account
   */
  @JsonProperty("serviceAccountName")
  private String serviceAccountName;

  /**
   * If specified, the pod's tolerations.
   */
  @JsonProperty("tolerations")
  @Singular(value = "addToTolerations", ignoreNullCollections = true)
  private List<ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpecTolerations> tolerations;

}

