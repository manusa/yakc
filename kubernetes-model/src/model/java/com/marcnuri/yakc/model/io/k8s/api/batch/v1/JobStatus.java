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

package com.marcnuri.yakc.model.io.k8s.api.batch.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * JobStatus represents the current state of a Job.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JobStatus implements Model {


  /**
   * The number of pending and running pods.
   */
  @JsonProperty("active")
  private Number active;

  /**
   * completedIndexes holds the completed indexes when .spec.completionMode = "Indexed" in a text format. The indexes are represented as decimal integers separated by commas. The numbers are listed in increasing order. Three or more consecutive numbers are compressed and represented by the first and last element of the series, separated by a hyphen. For example, if the completed indexes are 1, 3, 4, 5 and 7, they are represented as "1,3-5,7".
   */
  @JsonProperty("completedIndexes")
  private String completedIndexes;

  @JsonProperty("completionTime")
  private OffsetDateTime completionTime;

  /**
   * The latest available observations of an object's current state. When a Job fails, one of the conditions will have type "Failed" and status true. When a Job is suspended, one of the conditions will have type "Suspended" and status true; when the Job is resumed, the status of this condition will become false. When a Job is completed, one of the conditions will have type "Complete" and status true. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<JobCondition> conditions;

  /**
   * The number of pods which reached phase Failed.
   */
  @JsonProperty("failed")
  private Number failed;

  /**
   * FailedIndexes holds the failed indexes when backoffLimitPerIndex=true. The indexes are represented in the text format analogous as for the `completedIndexes` field, ie. they are kept as decimal integers separated by commas. The numbers are listed in increasing order. Three or more consecutive numbers are compressed and represented by the first and last element of the series, separated by a hyphen. For example, if the failed indexes are 1, 3, 4, 5 and 7, they are represented as "1,3-5,7". This field is beta-level. It can be used when the `JobBackoffLimitPerIndex` feature gate is enabled (enabled by default).
   */
  @JsonProperty("failedIndexes")
  private String failedIndexes;

  /**
   * The number of pods which have a Ready condition.
   */
  @JsonProperty("ready")
  private Number ready;

  @JsonProperty("startTime")
  private OffsetDateTime startTime;

  /**
   * The number of pods which reached phase Succeeded.
   */
  @JsonProperty("succeeded")
  private Number succeeded;

  /**
   * The number of pods which are terminating (in phase Pending or Running and have a deletionTimestamp).<br><p> <br><p> This field is beta-level. The job controller populates the field when the feature gate JobPodReplacementPolicy is enabled (enabled by default).
   */
  @JsonProperty("terminating")
  private Number terminating;

  @JsonProperty("uncountedTerminatedPods")
  private UncountedTerminatedPods uncountedTerminatedPods;

}

