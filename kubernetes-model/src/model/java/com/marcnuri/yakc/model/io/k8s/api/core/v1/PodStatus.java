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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * PodStatus represents information about the status of a pod. Status may trail the actual state of a system, especially if the node that hosts the pod cannot contact the control plane.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodStatus implements Model {


  /**
   * Current service state of pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-conditions
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<PodCondition> conditions;

  /**
   * The list has one entry per container in the manifest. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-and-container-status
   */
  @JsonProperty("containerStatuses")
  @Singular(value = "addToContainerStatuses", ignoreNullCollections = true)
  private List<ContainerStatus> containerStatuses;

  /**
   * Status for any ephemeral containers that have run in this pod.
   */
  @JsonProperty("ephemeralContainerStatuses")
  @Singular(value = "addToEphemeralContainerStatuses", ignoreNullCollections = true)
  private List<ContainerStatus> ephemeralContainerStatuses;

  /**
   * IP address of the host to which the pod is assigned. Empty if not yet scheduled.
   */
  @JsonProperty("hostIP")
  private String hostIP;

  /**
   * The list has one entry per init container in the manifest. The most recent successful init container will have ready = true, the most recently started container will have startTime set. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-and-container-status
   */
  @JsonProperty("initContainerStatuses")
  @Singular(value = "addToInitContainerStatuses", ignoreNullCollections = true)
  private List<ContainerStatus> initContainerStatuses;

  /**
   * A human readable message indicating details about why the pod is in this condition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * nominatedNodeName is set only when this pod preempts other pods on the node, but it cannot be scheduled right away as preemption victims receive their graceful termination periods. This field does not guarantee that the pod will be scheduled on this node. Scheduler may decide to place the pod elsewhere if other nodes become available sooner. Scheduler may also decide to give the resources on this node to a higher priority pod that is created after preemption. As a result, this field may be different than PodSpec.nodeName when the pod is scheduled.
   */
  @JsonProperty("nominatedNodeName")
  private String nominatedNodeName;

  /**
   * The phase of a Pod is a simple, high-level summary of where the Pod is in its lifecycle. The conditions array, the reason and message fields, and the individual container status arrays contain more detail about the pod's status. There are five possible phase values:<br><p> <br><p> Pending: The pod has been accepted by the Kubernetes system, but one or more of the container images has not been created. This includes time before being scheduled as well as time spent downloading images over the network, which could take a while. Running: The pod has been bound to a node, and all of the containers have been created. At least one container is still running, or is in the process of starting or restarting. Succeeded: All containers in the pod have terminated in success, and will not be restarted. Failed: All containers in the pod have terminated, and at least one container has terminated in failure. The container either exited with non-zero status or was terminated by the system. Unknown: For some reason the state of the pod could not be obtained, typically due to an error in communicating with the host of the pod.<br><p> <br><p> More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-phase<br><p> <br><p> 
   */
  @JsonProperty("phase")
  private String phase;

  /**
   * IP address allocated to the pod. Routable at least within the cluster. Empty if not yet allocated.
   */
  @JsonProperty("podIP")
  private String podIP;

  /**
   * podIPs holds the IP addresses allocated to the pod. If this field is specified, the 0th entry must match the podIP field. Pods may be allocated at most 1 value for each of IPv4 and IPv6. This list is empty if no IPs have been allocated yet.
   */
  @JsonProperty("podIPs")
  @Singular(value = "addToPodIPs", ignoreNullCollections = true)
  private List<PodIP> podIPs;

  /**
   * The Quality of Service (QOS) classification assigned to the pod based on resource requirements See PodQOSClass type for available QOS classes More info: https://git.k8s.io/community/contributors/design-proposals/node/resource-qos.md<br><p> <br><p> 
   */
  @JsonProperty("qosClass")
  private String qosClass;

  /**
   * A brief CamelCase message indicating details about why the pod is in this state. e.g. 'Evicted'
   */
  @JsonProperty("reason")
  private String reason;

  @JsonProperty("startTime")
  private OffsetDateTime startTime;

}

