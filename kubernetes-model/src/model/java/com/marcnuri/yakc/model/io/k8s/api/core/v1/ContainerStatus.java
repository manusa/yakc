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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ContainerStatus contains details for the current status of this container.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ContainerStatus implements Model {


  /**
   * Container's ID in the format 'docker://&lt;container_id&gt;'.
   */
  @JsonProperty("containerID")
  private String containerID;

  /**
   * The image the container is running. More info: https://kubernetes.io/docs/concepts/containers/images
   */
  @NonNull
  @JsonProperty("image")
  private String image;

  /**
   * ImageID of the container's image.
   */
  @NonNull
  @JsonProperty("imageID")
  private String imageID;

  @JsonProperty("lastState")
  private ContainerState lastState;

  /**
   * This must be a DNS_LABEL. Each container in a pod must have a unique name. Cannot be updated.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Specifies whether the container has passed its readiness probe.
   */
  @NonNull
  @JsonProperty("ready")
  private Boolean ready;

  /**
   * The number of times the container has been restarted, currently based on the number of dead containers that have not yet been removed. Note that this is calculated from dead containers. But those containers are subject to garbage collection. This value will get capped at 5 by GC.
   */
  @NonNull
  @JsonProperty("restartCount")
  private Integer restartCount;

  /**
   * Specifies whether the container has passed its startup probe. Initialized as false, becomes true after startupProbe is considered successful. Resets to false when the container is restarted, or if kubelet loses state temporarily. Is always true when no startupProbe is defined.
   */
  @JsonProperty("started")
  private Boolean started;

  @JsonProperty("state")
  private ContainerState state;

}

