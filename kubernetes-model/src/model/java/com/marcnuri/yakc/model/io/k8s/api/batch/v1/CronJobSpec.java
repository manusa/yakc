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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * CronJobSpec describes how the job execution will look like and when it will actually run.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CronJobSpec implements Model {


  /**
   * Specifies how to treat concurrent executions of a Job. Valid values are: - "Allow" (default): allows CronJobs to run concurrently; - "Forbid": forbids concurrent runs, skipping next run if previous run hasn't finished yet; - "Replace": cancels currently running job and replaces it with a new one<br><p> <br><p> Possible enum values:<br><p>  - `"Allow"` allows CronJobs to run concurrently.<br><p>  - `"Forbid"` forbids concurrent runs, skipping next run if previous hasn't finished yet.<br><p>  - `"Replace"` cancels currently running job and replaces it with a new one.
   */
  @JsonProperty("concurrencyPolicy")
  private String concurrencyPolicy;

  /**
   * The number of failed finished jobs to retain. Value must be non-negative integer. Defaults to 1.
   */
  @JsonProperty("failedJobsHistoryLimit")
  private Number failedJobsHistoryLimit;

  @NonNull
  @JsonProperty("jobTemplate")
  private JobTemplateSpec jobTemplate;

  /**
   * The schedule in Cron format, see https://en.wikipedia.org/wiki/Cron.
   */
  @NonNull
  @JsonProperty("schedule")
  private String schedule;

  /**
   * Optional deadline in seconds for starting the job if it misses scheduled time for any reason.  Missed jobs executions will be counted as failed ones.
   */
  @JsonProperty("startingDeadlineSeconds")
  private Number startingDeadlineSeconds;

  /**
   * The number of successful finished jobs to retain. Value must be non-negative integer. Defaults to 3.
   */
  @JsonProperty("successfulJobsHistoryLimit")
  private Number successfulJobsHistoryLimit;

  /**
   * This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.  Defaults to false.
   */
  @JsonProperty("suspend")
  private Boolean suspend;

}

