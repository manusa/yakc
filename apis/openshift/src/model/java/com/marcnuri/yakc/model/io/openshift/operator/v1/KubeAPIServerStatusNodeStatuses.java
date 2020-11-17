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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * NodeStatus provides information about the current state of a particular node managed by this operator.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class KubeAPIServerStatusNodeStatuses implements Model {


  /**
   * currentRevision is the generation of the most recently successful deployment
   */
  @JsonProperty("currentRevision")
  private Number currentRevision;

  /**
   * lastFailedRevision is the generation of the deployment we tried and failed to deploy.
   */
  @JsonProperty("lastFailedRevision")
  private Number lastFailedRevision;

  /**
   * lastFailedRevisionErrors is a list of the errors during the failed deployment referenced in lastFailedRevision
   */
  @JsonProperty("lastFailedRevisionErrors")
  @Singular(value = "addToLastFailedRevisionErrors", ignoreNullCollections = true)
  private List<String> lastFailedRevisionErrors;

  /**
   * nodeName is the name of the node
   */
  @JsonProperty("nodeName")
  private String nodeName;

  /**
   * targetRevision is the generation of the deployment we're trying to apply
   */
  @JsonProperty("targetRevision")
  private Number targetRevision;

}

