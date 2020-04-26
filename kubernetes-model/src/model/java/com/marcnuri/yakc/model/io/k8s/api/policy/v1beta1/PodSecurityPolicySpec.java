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

package com.marcnuri.yakc.model.io.k8s.api.policy.v1beta1;

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
 * PodSecurityPolicySpec defines the policy enforced.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodSecurityPolicySpec implements Model {


  /**
   * allowPrivilegeEscalation determines if a pod can request to allow privilege escalation. If unspecified, defaults to true.
   */
  @JsonProperty("allowPrivilegeEscalation")
  private Boolean allowPrivilegeEscalation;

  /**
   * AllowedCSIDrivers is a whitelist of inline CSI drivers that must be explicitly set to be embedded within a pod spec. An empty value indicates that any CSI driver can be used for inline ephemeral volumes. This is an alpha field, and is only honored if the API server enables the CSIInlineVolume feature gate.
   */
  @JsonProperty("allowedCSIDrivers")
  @Singular(value = "addToAllowedCSIDrivers", ignoreNullCollections = true)
  private List<AllowedCSIDriver> allowedCSIDrivers;

  /**
   * allowedCapabilities is a list of capabilities that can be requested to add to the container. Capabilities in this field may be added at the pod author's discretion. You must not list a capability in both allowedCapabilities and requiredDropCapabilities.
   */
  @JsonProperty("allowedCapabilities")
  @Singular(value = "addToAllowedCapabilities", ignoreNullCollections = true)
  private List<String> allowedCapabilities;

  /**
   * allowedFlexVolumes is a whitelist of allowed Flexvolumes.  Empty or nil indicates that all Flexvolumes may be used.  This parameter is effective only when the usage of the Flexvolumes is allowed in the "volumes" field.
   */
  @JsonProperty("allowedFlexVolumes")
  @Singular(value = "addToAllowedFlexVolumes", ignoreNullCollections = true)
  private List<AllowedFlexVolume> allowedFlexVolumes;

  /**
   * allowedHostPaths is a white list of allowed host paths. Empty indicates that all host paths may be used.
   */
  @JsonProperty("allowedHostPaths")
  @Singular(value = "addToAllowedHostPaths", ignoreNullCollections = true)
  private List<AllowedHostPath> allowedHostPaths;

  /**
   * AllowedProcMountTypes is a whitelist of allowed ProcMountTypes. Empty or nil indicates that only the DefaultProcMountType may be used. This requires the ProcMountType feature flag to be enabled.
   */
  @JsonProperty("allowedProcMountTypes")
  @Singular(value = "addToAllowedProcMountTypes", ignoreNullCollections = true)
  private List<String> allowedProcMountTypes;

  /**
   * allowedUnsafeSysctls is a list of explicitly allowed unsafe sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of allowed sysctls. Single &#42; means all unsafe sysctls are allowed. Kubelet has to whitelist all allowed unsafe sysctls explicitly to avoid rejection.<br><p> <br><p> Examples: e.g. "foo/&#42;" allows "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" allows "foo.bar", "foo.baz", etc.
   */
  @JsonProperty("allowedUnsafeSysctls")
  @Singular(value = "addToAllowedUnsafeSysctls", ignoreNullCollections = true)
  private List<String> allowedUnsafeSysctls;

  /**
   * defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.  You may not list a capability in both defaultAddCapabilities and requiredDropCapabilities. Capabilities added here are implicitly allowed, and need not be included in the allowedCapabilities list.
   */
  @JsonProperty("defaultAddCapabilities")
  @Singular(value = "addToDefaultAddCapabilities", ignoreNullCollections = true)
  private List<String> defaultAddCapabilities;

  /**
   * defaultAllowPrivilegeEscalation controls the default setting for whether a process can gain more privileges than its parent process.
   */
  @JsonProperty("defaultAllowPrivilegeEscalation")
  private Boolean defaultAllowPrivilegeEscalation;

  /**
   * forbiddenSysctls is a list of explicitly forbidden sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of forbidden sysctls. Single &#42; means all sysctls are forbidden.<br><p> <br><p> Examples: e.g. "foo/&#42;" forbids "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" forbids "foo.bar", "foo.baz", etc.
   */
  @JsonProperty("forbiddenSysctls")
  @Singular(value = "addToForbiddenSysctls", ignoreNullCollections = true)
  private List<String> forbiddenSysctls;

  @NonNull
  @JsonProperty("fsGroup")
  private FSGroupStrategyOptions fsGroup;

  /**
   * hostIPC determines if the policy allows the use of HostIPC in the pod spec.
   */
  @JsonProperty("hostIPC")
  private Boolean hostIPC;

  /**
   * hostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
   */
  @JsonProperty("hostNetwork")
  private Boolean hostNetwork;

  /**
   * hostPID determines if the policy allows the use of HostPID in the pod spec.
   */
  @JsonProperty("hostPID")
  private Boolean hostPID;

  /**
   * hostPorts determines which host port ranges are allowed to be exposed.
   */
  @JsonProperty("hostPorts")
  @Singular(value = "addToHostPorts", ignoreNullCollections = true)
  private List<HostPortRange> hostPorts;

  /**
   * privileged determines if a pod can request to be run as privileged.
   */
  @JsonProperty("privileged")
  private Boolean privileged;

  /**
   * readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.  If the container specifically requests to run with a non-read only root file system the PSP should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
   */
  @JsonProperty("readOnlyRootFilesystem")
  private Boolean readOnlyRootFilesystem;

  /**
   * requiredDropCapabilities are the capabilities that will be dropped from the container.  These are required to be dropped and cannot be added.
   */
  @JsonProperty("requiredDropCapabilities")
  @Singular(value = "addToRequiredDropCapabilities", ignoreNullCollections = true)
  private List<String> requiredDropCapabilities;

  @JsonProperty("runAsGroup")
  private RunAsGroupStrategyOptions runAsGroup;

  @NonNull
  @JsonProperty("runAsUser")
  private RunAsUserStrategyOptions runAsUser;

  @JsonProperty("runtimeClass")
  private RuntimeClassStrategyOptions runtimeClass;

  @NonNull
  @JsonProperty("seLinux")
  private SELinuxStrategyOptions seLinux;

  @NonNull
  @JsonProperty("supplementalGroups")
  private SupplementalGroupsStrategyOptions supplementalGroups;

  /**
   * volumes is a white list of allowed volume plugins. Empty indicates that no volumes may be used. To allow all volumes you may use '&#42;'.
   */
  @JsonProperty("volumes")
  @Singular(value = "addToVolumes", ignoreNullCollections = true)
  private List<String> volumes;

}

