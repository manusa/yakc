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

package com.marcnuri.yakc.model.io.k8s.api.apps.v1beta1;

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
 * StatefulSetStatus represents the current state of a StatefulSet.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StatefulSetStatus implements Model {


  /**
   * collisionCount is the count of hash collisions for the StatefulSet. The StatefulSet controller uses this field as a collision avoidance mechanism when it needs to create the name for the newest ControllerRevision.
   */
  @JsonProperty("collisionCount")
  private Number collisionCount;

  /**
   * Represents the latest available observations of a statefulset's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<StatefulSetCondition> conditions;

  /**
   * currentReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version indicated by currentRevision.
   */
  @JsonProperty("currentReplicas")
  private Number currentReplicas;

  /**
   * currentRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence [0,currentReplicas).
   */
  @JsonProperty("currentRevision")
  private String currentRevision;

  /**
   * observedGeneration is the most recent generation observed for this StatefulSet. It corresponds to the StatefulSet's generation, which is updated on mutation by the API Server.
   */
  @JsonProperty("observedGeneration")
  private Number observedGeneration;

  /**
   * readyReplicas is the number of Pods created by the StatefulSet controller that have a Ready Condition.
   */
  @JsonProperty("readyReplicas")
  private Number readyReplicas;

  /**
   * replicas is the number of Pods created by the StatefulSet controller.
   */
  @NonNull
  @JsonProperty("replicas")
  private Number replicas;

  /**
   * updateRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence [replicas-updatedReplicas,replicas)
   */
  @JsonProperty("updateRevision")
  private String updateRevision;

  /**
   * updatedReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version indicated by updateRevision.
   */
  @JsonProperty("updatedReplicas")
  private Number updatedReplicas;

}

