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
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * BuildStatus contains the status of a build
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildStatus implements Model {


  /**
   * cancelled describes if a cancel event was triggered for the build.
   */
  @JsonProperty("cancelled")
  private Boolean cancelled;

  @JsonProperty("completionTimestamp")
  private OffsetDateTime completionTimestamp;

  /**
   * Conditions represents the latest available observations of a build's current state.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<BuildCondition> conditions;

  @JsonProperty("config")
  private ObjectReference config;

  /**
   * duration contains time.Duration object describing build time.
   */
  @JsonProperty("duration")
  private Number duration;

  /**
   * logSnippet is the last few lines of the build log.  This value is only set for builds that failed.
   */
  @JsonProperty("logSnippet")
  private String logSnippet;

  /**
   * message is a human-readable message indicating details about why the build has this status.
   */
  @JsonProperty("message")
  private String message;

  @JsonProperty("output")
  private BuildStatusOutput output;

  /**
   * outputDockerImageReference contains a reference to the container image that will be built by this build. Its value is computed from Build.Spec.Output.To, and should include the registry address, so that it can be used to push and pull the image.
   */
  @JsonProperty("outputDockerImageReference")
  private String outputDockerImageReference;

  /**
   * phase is the point in the build lifecycle. Possible values are "New", "Pending", "Running", "Complete", "Failed", "Error", and "Cancelled".
   */
  @NonNull
  @JsonProperty("phase")
  private String phase;

  /**
   * reason is a brief CamelCase string that describes any failure and is meant for machine parsing and tidy display in the CLI.
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * stages contains details about each stage that occurs during the build including start time, duration (in milliseconds), and the steps that occured within each stage.
   */
  @JsonProperty("stages")
  @Singular(value = "addToStages", ignoreNullCollections = true)
  private List<StageInfo> stages;

  @JsonProperty("startTimestamp")
  private OffsetDateTime startTimestamp;

}

