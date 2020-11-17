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

package com.marcnuri.yakc.model.io.openshift.tuned.v1;

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
 * Selection logic for a single tuned profile.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TunedSpecRecommend implements Model {


  /**
   * Rules governing application of a tuned profile connected by logical OR operator.
   */
  @JsonProperty("match")
  @Singular(value = "addToMatch", ignoreNullCollections = true)
  private List<TunedSpecMatch> match;

  /**
   * Tuned profile priority. Highest priority is 0.
   */
  @NonNull
  @JsonProperty("priority")
  private Number priority;

  /**
   * Name of the tuned profile to recommend.
   */
  @NonNull
  @JsonProperty("profile")
  private String profile;

}

