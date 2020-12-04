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
 * PodIoChaosSpec defines the desired state of IoChaos
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodIoChaosSpec implements Model {


  /**
   * Actions are a list of IoChaos actions
   */
  @JsonProperty("actions")
  @Singular(value = "addToActions", ignoreNullCollections = true)
  private List<PodIoChaosSpecActions> actions;

  /**
   * TODO: support multiple different container to inject in one pod
   */
  @JsonProperty("container")
  private String container;

  /**
   * Pid represents a running toda process id
   */
  @JsonProperty("pid")
  private Number pid;

  /**
   * StartTime represents the start time of a toda process
   */
  @JsonProperty("startTime")
  private Number startTime;

  /**
   * VolumeMountPath represents the target mount path It must be a root of mount path now. TODO: search the mount parent of any path automatically. TODO: support multiple different volume mount path in one pod
   */
  @NonNull
  @JsonProperty("volumeMountPath")
  private String volumeMountPath;

}

