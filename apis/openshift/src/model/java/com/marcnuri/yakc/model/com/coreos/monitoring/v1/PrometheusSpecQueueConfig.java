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

package com.marcnuri.yakc.model.com.coreos.monitoring.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * QueueConfig allows tuning of the remote write queue parameters.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecQueueConfig implements Model {


  /**
   * BatchSendDeadline is the maximum time a sample will wait in buffer.
   */
  @JsonProperty("batchSendDeadline")
  private String batchSendDeadline;

  /**
   * Capacity is the number of samples to buffer per shard before we start dropping them.
   */
  @JsonProperty("capacity")
  private Number capacity;

  /**
   * MaxBackoff is the maximum retry delay.
   */
  @JsonProperty("maxBackoff")
  private String maxBackoff;

  /**
   * MaxRetries is the maximum number of times to retry a batch on recoverable errors.
   */
  @JsonProperty("maxRetries")
  private Number maxRetries;

  /**
   * MaxSamplesPerSend is the maximum number of samples per send.
   */
  @JsonProperty("maxSamplesPerSend")
  private Number maxSamplesPerSend;

  /**
   * MaxShards is the maximum number of shards, i.e. amount of concurrency.
   */
  @JsonProperty("maxShards")
  private Number maxShards;

  /**
   * MinBackoff is the initial retry delay. Gets doubled for every retry.
   */
  @JsonProperty("minBackoff")
  private String minBackoff;

  /**
   * MinShards is the minimum number of shards, i.e. amount of concurrency.
   */
  @JsonProperty("minShards")
  private Number minShards;

}

