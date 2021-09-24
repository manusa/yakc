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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * CPUStressor stresses CPU out
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleSpecStressChaosStressorsCpu implements Model {


  /**
   * Load specifies P percent loading per CPU worker. 0 is effectively a sleep (no load) and 100 is full loading.
   */
  @JsonProperty("load")
  private Number load;

  /**
   * extend stress-ng options
   */
  @JsonProperty("options")
  @Singular(value = "addToOptions", ignoreNullCollections = true)
  private List<String> options;

  /**
   * Workers specifies N workers to apply the stressor. Maximum 8192 workers can run by stress-ng
   */
  @NonNull
  @JsonProperty("workers")
  private Number workers;

}
