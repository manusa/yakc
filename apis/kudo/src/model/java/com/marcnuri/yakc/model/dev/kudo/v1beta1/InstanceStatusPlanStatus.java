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

package com.marcnuri.yakc.model.dev.kudo.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * PlanStatus is representing status of a plan <br><p>  These are valid states and transitions <br><p>                         | Never executed |                                |                                v |    Error    |&lt;------&gt;|    Pending     |        ^                       |        |                       v        |               +-------+--------+        |               +-------+--------+        |                       |        v                       v | Fatal error |        |    Complete    |
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class InstanceStatusPlanStatus implements Model {


  @JsonProperty("lastUpdatedTimestamp")
  private Object lastUpdatedTimestamp;

  @JsonProperty("message")
  private String message;

  @JsonProperty("name")
  private String name;

  @JsonProperty("phases")
  @Singular(value = "addToPhases", ignoreNullCollections = true)
  private List<InstanceStatusPhases> phases;

  /**
   * ExecutionStatus captures the state of the rollout.
   */
  @JsonProperty("status")
  private String status;

  /**
   * UID is a type that holds unique ID values, including UUIDs.  Because we don't ONLY use UUIDs, this is an alias to string.  Being a type captures intent and helps make sure that UIDs and names do not get conflated.
   */
  @JsonProperty("uid")
  private String uid;

}

