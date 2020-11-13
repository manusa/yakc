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

package com.marcnuri.yakc.model.com.github.openshift.api.security.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * RunAsUserStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RunAsUserStrategyOptions implements Model {


  /**
   * Type is the strategy that will dictate what RunAsUser is used in the SecurityContext.
   */
  @JsonProperty("type")
  private String type;

  /**
   * UID is the user id that containers must run as.  Required for the MustRunAs strategy if not using namespace/service account allocated uids.
   */
  @JsonProperty("uid")
  private Number uid;

  /**
   * UIDRangeMax defines the max value for a strategy that allocates by range.
   */
  @JsonProperty("uidRangeMax")
  private Number uidRangeMax;

  /**
   * UIDRangeMin defines the min value for a strategy that allocates by range.
   */
  @JsonProperty("uidRangeMin")
  private Number uidRangeMin;

}

