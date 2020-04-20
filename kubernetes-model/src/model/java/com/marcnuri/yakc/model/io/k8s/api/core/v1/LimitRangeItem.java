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

package com.marcnuri.yakc.model.io.k8s.api.core.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * LimitRangeItem defines a min/max usage limit for any resource that matches on kind.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LimitRangeItem implements Model {


  /**
   * Default resource requirement limit value by resource name if resource limit is omitted.
   */
  @JsonProperty("default")
  @Singular("putInDefaults")
  private Map<String, String> defaults;

  /**
   * DefaultRequest is the default resource requirement request value by resource name if resource request is omitted.
   */
  @JsonProperty("defaultRequest")
  @Singular("putInDefaultRequest")
  private Map<String, String> defaultRequest;

  /**
   * Max usage constraints on this kind by resource name.
   */
  @JsonProperty("max")
  @Singular("putInMax")
  private Map<String, String> max;

  /**
   * MaxLimitRequestRatio if specified, the named resource must have a request and limit that are both non-zero where limit divided by request is less than or equal to the enumerated value; this represents the max burst for the named resource.
   */
  @JsonProperty("maxLimitRequestRatio")
  @Singular("putInMaxLimitRequestRatio")
  private Map<String, String> maxLimitRequestRatio;

  /**
   * Min usage constraints on this kind by resource name.
   */
  @JsonProperty("min")
  @Singular("putInMin")
  private Map<String, String> min;

  /**
   * Type of resource that this limit applies to.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

