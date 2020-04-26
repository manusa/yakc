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
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JobStatus implements Model {


  /**
   * The number of actively running pods.
   */
  @JsonProperty("active")
  private Integer active;

  @JsonProperty("completionTime")
  private OffsetDateTime completionTime;

  /**
   * The latest available observations of an object's current state. More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<JobCondition> conditions;

  /**
   * The number of pods which reached phase Failed.
   */
  @JsonProperty("failed")
  private Integer failed;

  @JsonProperty("startTime")
  private OffsetDateTime startTime;

  /**
   * The number of pods which reached phase Succeeded.
   */
  @JsonProperty("succeeded")
  private Integer succeeded;

}

