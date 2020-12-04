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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Bandwidth represents the detail about bandwidth control action
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkChaosSpecBandwidth implements Model {


  /**
   * Buffer is the maximum amount of bytes that tokens can be available for instantaneously.
   */
  @NonNull
  @JsonProperty("buffer")
  private Number buffer;

  /**
   * Limit is the number of bytes that can be queued waiting for tokens to become available.
   */
  @NonNull
  @JsonProperty("limit")
  private Number limit;

  /**
   * Minburst specifies the size of the peakrate bucket. For perfect accuracy, should be set to the MTU of the interface.  If a peakrate is needed, but some burstiness is acceptable, this size can be raised. A 3000 byte minburst allows around 3mbit/s of peakrate, given 1000 byte packets.
   */
  @JsonProperty("minburst")
  private Number minburst;

  /**
   * Peakrate is the maximum depletion rate of the bucket. The peakrate does not need to be set, it is only necessary if perfect millisecond timescale shaping is required.
   */
  @JsonProperty("peakrate")
  private Number peakrate;

  /**
   * Rate is the speed knob. Allows bps, kbps, mbps, gbps, tbps unit. bps means bytes per second.
   */
  @NonNull
  @JsonProperty("rate")
  private String rate;

}

