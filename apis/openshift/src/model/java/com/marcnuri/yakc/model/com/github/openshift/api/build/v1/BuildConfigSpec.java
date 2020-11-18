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
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ResourceRequirements;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * BuildConfigSpec describes when and how builds are created
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildConfigSpec implements Model {


  /**
   * completionDeadlineSeconds is an optional duration in seconds, counted from the time when a build pod gets scheduled in the system, that the build may be active on a node before the system actively tries to terminate the build; value must be positive integer
   */
  @JsonProperty("completionDeadlineSeconds")
  private Number completionDeadlineSeconds;

  /**
   * failedBuildsHistoryLimit is the number of old failed builds to retain. When a BuildConfig is created, the 5 most recent failed builds are retained unless this value is set. If removed after the BuildConfig has been created, all failed builds are retained.
   */
  @JsonProperty("failedBuildsHistoryLimit")
  private Number failedBuildsHistoryLimit;

  /**
   * nodeSelector is a selector which must be true for the build pod to fit on a node If nil, it can be overridden by default build nodeselector values for the cluster. If set to an empty map or a map with any values, default build nodeselector values are ignored.
   */
  @JsonProperty("nodeSelector")
  @Singular(value = "putInNodeSelector", ignoreNullCollections = true)
  private Map<String, String> nodeSelector;

  @JsonProperty("output")
  private BuildOutput output;

  @JsonProperty("postCommit")
  private BuildPostCommitSpec postCommit;

  @JsonProperty("resources")
  private ResourceRequirements resources;

  @JsonProperty("revision")
  private SourceRevision revision;

  /**
   * RunPolicy describes how the new build created from this build configuration will be scheduled for execution. This is optional, if not specified we default to "Serial".
   */
  @JsonProperty("runPolicy")
  private String runPolicy;

  /**
   * serviceAccount is the name of the ServiceAccount to use to run the pod created by this build. The pod will be allowed to use secrets referenced by the ServiceAccount
   */
  @JsonProperty("serviceAccount")
  private String serviceAccount;

  @JsonProperty("source")
  private BuildSource source;

  @NonNull
  @JsonProperty("strategy")
  private BuildStrategy strategy;

  /**
   * successfulBuildsHistoryLimit is the number of old successful builds to retain. When a BuildConfig is created, the 5 most recent successful builds are retained unless this value is set. If removed after the BuildConfig has been created, all successful builds are retained.
   */
  @JsonProperty("successfulBuildsHistoryLimit")
  private Number successfulBuildsHistoryLimit;

  /**
   * triggers determine how new Builds can be launched from a BuildConfig. If no triggers are defined, a new build can only occur as a result of an explicit client build creation.
   */
  @NonNull
  @JsonProperty("triggers")
  @Singular(value = "addToTriggers", ignoreNullCollections = true)
  private List<BuildTriggerPolicy> triggers;

}

