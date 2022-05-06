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
 * ContainerStateTerminated is a terminated state of a container.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ContainerStateTerminated implements Model {


  /**
   * Container's ID in the format '&lt;type&gt;://&lt;container_id&gt;'
   */
  @JsonProperty("containerID")
  private String containerID;

  /**
   * Exit status from the last termination of the container
   */
  @NonNull
  @JsonProperty("exitCode")
  private Number exitCode;

  @JsonProperty("finishedAt")
  private OffsetDateTime finishedAt;

  /**
   * Message regarding the last termination of the container
   */
  @JsonProperty("message")
  private String message;

  /**
   * (brief) reason from the last termination of the container
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * Signal from the last termination of the container
   */
  @JsonProperty("signal")
  private Number signal;

  @JsonProperty("startedAt")
  private OffsetDateTime startedAt;

}

