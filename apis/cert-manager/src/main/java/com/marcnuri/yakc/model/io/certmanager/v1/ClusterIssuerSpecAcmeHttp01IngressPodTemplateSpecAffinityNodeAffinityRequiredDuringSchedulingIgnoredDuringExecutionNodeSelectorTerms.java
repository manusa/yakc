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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/*
 *
 *
 * FILE OVERRIDDEN DUE TO A TOO LONG CLASS NAME
 *
 * This causes problems with Lombok's default builder name
 *
 *
 */

/**
 * A null or empty node selector term matches no objects. The requirements of them are ANDed. The TopologySelectorTerm type implements a subset of the NodeSelectorTerm.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpecAffinityNodeAffinityRequiredDuringSchedulingIgnoredDuringExecutionNodeSelectorTerms implements Model {


  /**
   * A list of node selector requirements by node's labels.
   */
  @JsonProperty("matchExpressions")
  @Singular(value = "addToMatchExpressions", ignoreNullCollections = true)
  private List<ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpecAffinityNodeAffinityPreferenceMatchExpressions> matchExpressions;

  /**
   * A list of node selector requirements by node's fields.
   */
  @JsonProperty("matchFields")
  @Singular(value = "addToMatchFields", ignoreNullCollections = true)
  private List<ClusterIssuerSpecAcmeHttp01IngressPodTemplateSpecAffinityNodeAffinityPreferenceMatchExpressions> matchFields;

}

