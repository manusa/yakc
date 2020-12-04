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
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Experiment records the last experiment state.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DNSChaosStatusExperiment implements Model {


  @JsonProperty("duration")
  private String duration;

  @JsonProperty("endTime")
  private OffsetDateTime endTime;

  /**
   * ExperimentPhase is the current status of chaos experiment.
   */
  @JsonProperty("phase")
  private String phase;

  @JsonProperty("podRecords")
  @Singular(value = "addToPodRecords", ignoreNullCollections = true)
  private List<DNSChaosStatusExperimentPodRecords> podRecords;

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("startTime")
  private OffsetDateTime startTime;

}

