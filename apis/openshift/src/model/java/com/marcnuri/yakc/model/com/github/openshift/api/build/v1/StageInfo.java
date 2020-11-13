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

package com.marcnuri.yakc.model.com.github.openshift.api.build.v1;

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
 * StageInfo contains details about a build stage.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StageInfo implements Model {


  /**
   * durationMilliseconds identifies how long the stage took to complete in milliseconds. Note: the duration of a stage can exceed the sum of the duration of the steps within the stage as not all actions are accounted for in explicit build steps.
   */
  @JsonProperty("durationMilliseconds")
  private Number durationMilliseconds;

  /**
   * name is a unique identifier for each build stage that occurs.
   */
  @JsonProperty("name")
  private String name;

  @JsonProperty("startTime")
  private OffsetDateTime startTime;

  /**
   * steps contains details about each step that occurs during a build stage including start time and duration in milliseconds.
   */
  @JsonProperty("steps")
  @Singular(value = "addToSteps", ignoreNullCollections = true)
  private List<StepInfo> steps;

}

