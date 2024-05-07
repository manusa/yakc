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
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * ContainerStatus contains details for the current status of this container.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ContainerStatus implements Model {


  /**
   * AllocatedResources represents the compute resources allocated for this container by the node. Kubelet sets this value to Container.Resources.Requests upon successful pod admission and after successfully admitting desired pod resize.
   */
  @JsonProperty("allocatedResources")
  @Singular(value = "putInAllocatedResources", ignoreNullCollections = true)
  private Map<String, String> allocatedResources;

  /**
   * ContainerID is the ID of the container in the format '&lt;type&gt;://&lt;container_id&gt;'. Where type is a container runtime identifier, returned from Version call of CRI API (for example "containerd").
   */
  @JsonProperty("containerID")
  private String containerID;

  /**
   * Image is the name of container image that the container is running. The container image may not match the image used in the PodSpec, as it may have been resolved by the runtime. More info: https://kubernetes.io/docs/concepts/containers/images.
   */
  @NonNull
  @JsonProperty("image")
  private String image;

  /**
   * ImageID is the image ID of the container's image. The image ID may not match the image ID of the image used in the PodSpec, as it may have been resolved by the runtime.
   */
  @NonNull
  @JsonProperty("imageID")
  private String imageID;

  @JsonProperty("lastState")
  private ContainerState lastState;

  /**
   * Name is a DNS_LABEL representing the unique name of the container. Each container in a pod must have a unique name across all container types. Cannot be updated.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Ready specifies whether the container is currently passing its readiness check. The value will change as readiness probes keep executing. If no readiness probes are specified, this field defaults to true once the container is fully started (see Started field).<br><p> <br><p> The value is typically used to determine whether a container is ready to accept traffic.
   */
  @NonNull
  @JsonProperty("ready")
  private Boolean ready;

  @JsonProperty("resources")
  private ResourceRequirements resources;

  /**
   * RestartCount holds the number of times the container has been restarted. Kubelet makes an effort to always increment the value, but there are cases when the state may be lost due to node restarts and then the value may be reset to 0. The value is never negative.
   */
  @NonNull
  @JsonProperty("restartCount")
  private Number restartCount;

  /**
   * Started indicates whether the container has finished its postStart lifecycle hook and passed its startup probe. Initialized as false, becomes true after startupProbe is considered successful. Resets to false when the container is restarted, or if kubelet loses state temporarily. In both cases, startup probes will run again. Is always true when no startupProbe is defined and container is running and has passed the postStart lifecycle hook. The null value must be treated the same as false.
   */
  @JsonProperty("started")
  private Boolean started;

  @JsonProperty("state")
  private ContainerState state;

  /**
   * Status of volume mounts.
   */
  @JsonProperty("volumeMounts")
  @Singular(value = "addToVolumeMounts", ignoreNullCollections = true)
  private List<VolumeMountStatus> volumeMounts;

}

