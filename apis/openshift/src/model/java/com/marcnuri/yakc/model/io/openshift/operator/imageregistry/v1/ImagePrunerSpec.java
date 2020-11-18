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

package com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecTolerations;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ImagePrunerSpec defines the specs for the running image pruner.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImagePrunerSpec implements Model {


  @JsonProperty("affinity")
  private ImagePrunerSpecAffinity affinity;

  /**
   * failedJobsHistoryLimit specifies how many failed image pruner jobs to retain. Defaults to 3 if not set.
   */
  @JsonProperty("failedJobsHistoryLimit")
  private Number failedJobsHistoryLimit;

  /**
   * keepTagRevisions specifies the number of image revisions for a tag in an image stream that will be preserved. Defaults to 5.
   */
  @JsonProperty("keepTagRevisions")
  private Number keepTagRevisions;

  /**
   * keepYoungerThan specifies the minimum age of an image and its referrers for it to be considered a candidate for pruning. Defaults to 96h (96 hours).
   */
  @JsonProperty("keepYoungerThan")
  private Number keepYoungerThan;

  /**
   * nodeSelector defines the node selection constraints for the image pruner pod.
   */
  @JsonProperty("nodeSelector")
  @Singular(value = "putInNodeSelector", ignoreNullCollections = true)
  private Map<String, String> nodeSelector;

  @JsonProperty("resources")
  private ImagePrunerSpecResources resources;

  /**
   * schedule specifies when to execute the job using standard cronjob syntax: https://wikipedia.org/wiki/Cron. Defaults to `0 0 &#42; &#42; &#42;`.
   */
  @JsonProperty("schedule")
  private String schedule;

  /**
   * successfulJobsHistoryLimit specifies how many successful image pruner jobs to retain. Defaults to 3 if not set.
   */
  @JsonProperty("successfulJobsHistoryLimit")
  private Number successfulJobsHistoryLimit;

  /**
   * suspend specifies whether or not to suspend subsequent executions of this cronjob. Defaults to false.
   */
  @JsonProperty("suspend")
  private Boolean suspend;

  /**
   * tolerations defines the node tolerations for the image pruner pod.
   */
  @JsonProperty("tolerations")
  @Singular(value = "addToTolerations", ignoreNullCollections = true)
  private List<AlertmanagerSpecTolerations> tolerations;

}

