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

package com.marcnuri.yakc.model.com.coreos.operators.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecSecurityContext1SeLinuxOptions;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecSecurityContext1Sysctls;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecSecurityContext1WindowsOptions;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * SecurityContext holds pod-level security attributes and common container settings. Optional: Defaults to empty.  See type description for default values of each field.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterServiceVersionSpecInstallSpecSpecTemplateSpecSecurityContext_1 implements Model {


  /**
   * A special supplemental group that applies to all containers in a pod. Some volume types allow the Kubelet to change the ownership of that volume to be owned by the pod: <br><p>  1. The owning GID will be the FSGroup 2. The setgid bit is set (new files created in the volume will be owned by FSGroup) 3. The permission bits are OR'd with rw-rw---- <br><p>  If unset, the Kubelet will not modify the ownership and permissions of any volume.
   */
  @JsonProperty("fsGroup")
  private Number fsGroup;

  /**
   * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container.
   */
  @JsonProperty("runAsGroup")
  private Number runAsGroup;

  /**
   * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
   */
  @JsonProperty("runAsNonRoot")
  private Boolean runAsNonRoot;

  /**
   * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence for that container.
   */
  @JsonProperty("runAsUser")
  private Number runAsUser;

  @JsonProperty("seLinuxOptions")
  private AlertmanagerSpecSecurityContext1SeLinuxOptions seLinuxOptions;

  /**
   * A list of groups applied to the first process run in each container, in addition to the container's primary GID.  If unspecified, no groups will be added to any container.
   */
  @JsonProperty("supplementalGroups")
  @Singular(value = "addToSupplementalGroups", ignoreNullCollections = true)
  private List<Number> supplementalGroups;

  /**
   * Sysctls hold a list of namespaced sysctls used for the pod. Pods with unsupported sysctls (by the container runtime) might fail to launch.
   */
  @JsonProperty("sysctls")
  @Singular(value = "addToSysctls", ignoreNullCollections = true)
  private List<AlertmanagerSpecSecurityContext1Sysctls> sysctls;

  @JsonProperty("windowsOptions")
  private AlertmanagerSpecSecurityContext1WindowsOptions windowsOptions;

}

