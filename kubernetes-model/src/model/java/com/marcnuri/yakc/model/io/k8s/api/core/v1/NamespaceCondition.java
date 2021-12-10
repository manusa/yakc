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
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * NamespaceCondition contains details about state of namespace.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NamespaceCondition implements Model {


  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  @JsonProperty("message")
  private String message;

  @JsonProperty("reason")
  private String reason;

  /**
   * Status of the condition, one of True, False, Unknown.
   */
  @NonNull
  @JsonProperty("status")
  private String status;

  /**
   * Type of namespace controller condition.<br><p> <br><p> Possible enum values:<br><p>  - `"NamespaceContentRemaining"` contains information about resources remaining in a namespace.<br><p>  - `"NamespaceDeletionContentFailure"` contains information about namespace deleter errors during deletion of resources.<br><p>  - `"NamespaceDeletionDiscoveryFailure"` contains information about namespace deleter errors during resource discovery.<br><p>  - `"NamespaceDeletionGroupVersionParsingFailure"` contains information about namespace deleter errors parsing GV for legacy types.<br><p>  - `"NamespaceFinalizersRemaining"` contains information about which finalizers are on resources remaining in a namespace.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

