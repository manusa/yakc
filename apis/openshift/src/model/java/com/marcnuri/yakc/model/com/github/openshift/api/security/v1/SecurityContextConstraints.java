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

package com.marcnuri.yakc.model.com.github.openshift.api.security.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * SecurityContextConstraints governs the ability to make requests that affect the SecurityContext that will be applied to a container. For historical reasons SCC was exposed under the core Kubernetes API group. That exposure is deprecated and will be removed in a future release - users should instead use the security.openshift.io group to manage SecurityContextConstraints.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SecurityContextConstraints implements Model {


  /**
   * AllowHostDirVolumePlugin determines if the policy allow containers to use the HostDir volume plugin
   */
  @NonNull
  @JsonProperty("allowHostDirVolumePlugin")
  private Boolean allowHostDirVolumePlugin;

  /**
   * AllowHostIPC determines if the policy allows host ipc in the containers.
   */
  @NonNull
  @JsonProperty("allowHostIPC")
  private Boolean allowHostIPC;

  /**
   * AllowHostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
   */
  @NonNull
  @JsonProperty("allowHostNetwork")
  private Boolean allowHostNetwork;

  /**
   * AllowHostPID determines if the policy allows host pid in the containers.
   */
  @NonNull
  @JsonProperty("allowHostPID")
  private Boolean allowHostPID;

  /**
   * AllowHostPorts determines if the policy allows host ports in the containers.
   */
  @NonNull
  @JsonProperty("allowHostPorts")
  private Boolean allowHostPorts;

  /**
   * AllowPrivilegeEscalation determines if a pod can request to allow privilege escalation. If unspecified, defaults to true.
   */
  @JsonProperty("allowPrivilegeEscalation")
  private Boolean allowPrivilegeEscalation;

  /**
   * AllowPrivilegedContainer determines if a container can request to be run as privileged.
   */
  @NonNull
  @JsonProperty("allowPrivilegedContainer")
  private Boolean allowPrivilegedContainer;

  /**
   * AllowedCapabilities is a list of capabilities that can be requested to add to the container. Capabilities in this field maybe added at the pod author's discretion. You must not list a capability in both AllowedCapabilities and RequiredDropCapabilities. To allow all capabilities you may use '&#42;'.
   */
  @NonNull
  @JsonProperty("allowedCapabilities")
  @Singular(value = "addToAllowedCapabilities", ignoreNullCollections = true)
  private List<String> allowedCapabilities;

  /**
   * AllowedFlexVolumes is a whitelist of allowed Flexvolumes.  Empty or nil indicates that all Flexvolumes may be used.  This parameter is effective only when the usage of the Flexvolumes is allowed in the "Volumes" field.
   */
  @JsonProperty("allowedFlexVolumes")
  @Singular(value = "addToAllowedFlexVolumes", ignoreNullCollections = true)
  private List<AllowedFlexVolume> allowedFlexVolumes;

  /**
   * AllowedUnsafeSysctls is a list of explicitly allowed unsafe sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of allowed sysctls. Single &#42; means all unsafe sysctls are allowed. Kubelet has to whitelist all allowed unsafe sysctls explicitly to avoid rejection.<br><p> <br><p> Examples: e.g. "foo/&#42;" allows "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" allows "foo.bar", "foo.baz", etc.
   */
  @JsonProperty("allowedUnsafeSysctls")
  @Singular(value = "addToAllowedUnsafeSysctls", ignoreNullCollections = true)
  private List<String> allowedUnsafeSysctls;

  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * DefaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec specifically drops the capability.  You may not list a capabiility in both DefaultAddCapabilities and RequiredDropCapabilities.
   */
  @NonNull
  @JsonProperty("defaultAddCapabilities")
  @Singular(value = "addToDefaultAddCapabilities", ignoreNullCollections = true)
  private List<String> defaultAddCapabilities;

  /**
   * DefaultAllowPrivilegeEscalation controls the default setting for whether a process can gain more privileges than its parent process.
   */
  @JsonProperty("defaultAllowPrivilegeEscalation")
  private Boolean defaultAllowPrivilegeEscalation;

  /**
   * ForbiddenSysctls is a list of explicitly forbidden sysctls, defaults to none. Each entry is either a plain sysctl name or ends in "&#42;" in which case it is considered as a prefix of forbidden sysctls. Single &#42; means all sysctls are forbidden.<br><p> <br><p> Examples: e.g. "foo/&#42;" forbids "foo/bar", "foo/baz", etc. e.g. "foo.&#42;" forbids "foo.bar", "foo.baz", etc.
   */
  @JsonProperty("forbiddenSysctls")
  @Singular(value = "addToForbiddenSysctls", ignoreNullCollections = true)
  private List<String> forbiddenSysctls;

  @JsonProperty("fsGroup")
  private FSGroupStrategyOptions fsGroup;

  /**
   * The groups that have permission to use this security context constraints
   */
  @JsonProperty("groups")
  @Singular(value = "addToGroups", ignoreNullCollections = true)
  private List<String> groups;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  /**
   * Priority influences the sort order of SCCs when evaluating which SCCs to try first for a given pod request based on access in the Users and Groups fields.  The higher the int, the higher priority. An unset value is considered a 0 priority. If scores for multiple SCCs are equal they will be sorted from most restrictive to least restrictive. If both priorities and restrictions are equal the SCCs will be sorted by name.
   */
  @NonNull
  @JsonProperty("priority")
  private Number priority;

  /**
   * ReadOnlyRootFilesystem when set to true will force containers to run with a read only root file system.  If the container specifically requests to run with a non-read only root file system the SCC should deny the pod. If set to false the container may run with a read only root file system if it wishes but it will not be forced to.
   */
  @NonNull
  @JsonProperty("readOnlyRootFilesystem")
  private Boolean readOnlyRootFilesystem;

  /**
   * RequiredDropCapabilities are the capabilities that will be dropped from the container.  These are required to be dropped and cannot be added.
   */
  @NonNull
  @JsonProperty("requiredDropCapabilities")
  @Singular(value = "addToRequiredDropCapabilities", ignoreNullCollections = true)
  private List<String> requiredDropCapabilities;

  @JsonProperty("runAsUser")
  private RunAsUserStrategyOptions runAsUser;

  @JsonProperty("seLinuxContext")
  private SELinuxContextStrategyOptions seLinuxContext;

  /**
   * SeccompProfiles lists the allowed profiles that may be set for the pod or container's seccomp annotations.  An unset (nil) or empty value means that no profiles may be specifid by the pod or container.	The wildcard '&#42;' may be used to allow all profiles.  When used to generate a value for a pod the first non-wildcard profile will be used as the default.
   */
  @JsonProperty("seccompProfiles")
  @Singular(value = "addToSeccompProfiles", ignoreNullCollections = true)
  private List<String> seccompProfiles;

  @JsonProperty("supplementalGroups")
  private SupplementalGroupsStrategyOptions supplementalGroups;

  /**
   * The users who have permissions to use this security context constraints
   */
  @JsonProperty("users")
  @Singular(value = "addToUsers", ignoreNullCollections = true)
  private List<String> users;

  /**
   * Volumes is a white list of allowed volume plugins.  FSType corresponds directly with the field names of a VolumeSource (azureFile, configMap, emptyDir).  To allow all volumes you may use "&#42;". To allow no volumes, set to ["none"].
   */
  @NonNull
  @JsonProperty("volumes")
  @Singular(value = "addToVolumes", ignoreNullCollections = true)
  private List<String> volumes;

}

