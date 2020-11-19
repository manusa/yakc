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
 * spec is the specification of the desired behavior of Tuned. More info: https://git.k8s.io/community/contributors/devel/api-conventions.md#spec-and-status
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TunedSpec implements Model {


  /**
   * Tuned profiles.
   */
  @NonNull
  @JsonProperty("profile")
  @Singular(value = "addToProfile", ignoreNullCollections = true)
  private List<TunedSpecProfile> profile;

  /**
   * Selection logic for all tuned profiles.
   */
  @NonNull
  @JsonProperty("recommend")
  @Singular(value = "addToRecommend", ignoreNullCollections = true)
  private List<TunedSpecRecommend> recommend;

}
