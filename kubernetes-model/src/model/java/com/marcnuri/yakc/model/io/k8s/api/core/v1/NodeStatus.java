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
import lombok.Singular;
import lombok.ToString;

/**
 * NodeStatus is information about the current status of a node.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NodeStatus implements Model {


  /**
   * List of addresses reachable to the node. Queried from cloud provider, if available. More info: https://kubernetes.io/docs/concepts/nodes/node/#addresses Note: This field is declared as mergeable, but the merge key is not sufficiently unique, which can cause data corruption when it is merged. Callers should instead use a full-replacement patch. See https://pr.k8s.io/79391 for an example. Consumers should assume that addresses can change during the lifetime of a Node. However, there are some exceptions where this may not be possible, such as Pods that inherit a Node's address in its own status or consumers of the downward API (status.hostIP).
   */
  @JsonProperty("addresses")
  @Singular(value = "addToAddresses", ignoreNullCollections = true)
  private List<NodeAddress> addresses;

  /**
   * Allocatable represents the resources of a node that are available for scheduling. Defaults to Capacity.
   */
  @JsonProperty("allocatable")
  @Singular(value = "putInAllocatable", ignoreNullCollections = true)
  private Map<String, String> allocatable;

  /**
   * Capacity represents the total resources of a node. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#capacity
   */
  @JsonProperty("capacity")
  @Singular(value = "putInCapacity", ignoreNullCollections = true)
  private Map<String, String> capacity;

  /**
   * Conditions is an array of current observed node conditions. More info: https://kubernetes.io/docs/concepts/nodes/node/#condition
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<NodeCondition> conditions;

  @JsonProperty("config")
  private NodeConfigStatus config;

  @JsonProperty("daemonEndpoints")
  private NodeDaemonEndpoints daemonEndpoints;

  /**
   * List of container images on this node
   */
  @JsonProperty("images")
  @Singular(value = "addToImages", ignoreNullCollections = true)
  private List<ContainerImage> images;

  @JsonProperty("nodeInfo")
  private NodeSystemInfo nodeInfo;

  /**
   * NodePhase is the recently observed lifecycle phase of the node. More info: https://kubernetes.io/docs/concepts/nodes/node/#phase The field is never populated, and now is deprecated.
   */
  @JsonProperty("phase")
  private String phase;

  /**
   * List of volumes that are attached to the node.
   */
  @JsonProperty("volumesAttached")
  @Singular(value = "addToVolumesAttached", ignoreNullCollections = true)
  private List<AttachedVolume> volumesAttached;

  /**
   * List of attachable volumes in use (mounted) by the node.
   */
  @JsonProperty("volumesInUse")
  @Singular(value = "addToVolumesInUse", ignoreNullCollections = true)
  private List<String> volumesInUse;

}

