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
 * NodeSystemInfo is a set of ids/uuids to uniquely identify the node.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NodeSystemInfo implements Model {


  /**
   * The Architecture reported by the node
   */
  @NonNull
  @JsonProperty("architecture")
  private String architecture;

  /**
   * Boot ID reported by the node.
   */
  @NonNull
  @JsonProperty("bootID")
  private String bootID;

  /**
   * ContainerRuntime Version reported by the node through runtime remote API (e.g. docker://1.5.0).
   */
  @NonNull
  @JsonProperty("containerRuntimeVersion")
  private String containerRuntimeVersion;

  /**
   * Kernel Version reported by the node from 'uname -r' (e.g. 3.16.0-0.bpo.4-amd64).
   */
  @NonNull
  @JsonProperty("kernelVersion")
  private String kernelVersion;

  /**
   * KubeProxy Version reported by the node.
   */
  @NonNull
  @JsonProperty("kubeProxyVersion")
  private String kubeProxyVersion;

  /**
   * Kubelet Version reported by the node.
   */
  @NonNull
  @JsonProperty("kubeletVersion")
  private String kubeletVersion;

  /**
   * MachineID reported by the node. For unique machine identification in the cluster this field is preferred. Learn more from man(5) machine-id: http://man7.org/linux/man-pages/man5/machine-id.5.html
   */
  @NonNull
  @JsonProperty("machineID")
  private String machineID;

  /**
   * The Operating System reported by the node
   */
  @NonNull
  @JsonProperty("operatingSystem")
  private String operatingSystem;

  /**
   * OS Image reported by the node from /etc/os-release (e.g. Debian GNU/Linux 7 (wheezy)).
   */
  @NonNull
  @JsonProperty("osImage")
  private String osImage;

  /**
   * SystemUUID reported by the node. For unique machine identification MachineID is preferred. This field is specific to Red Hat hosts https://access.redhat.com/documentation/en-us/red_hat_subscription_management/1/html/rhsm/uuid
   */
  @NonNull
  @JsonProperty("systemUUID")
  private String systemUUID;

}

