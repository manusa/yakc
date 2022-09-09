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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * An EphemeralContainer is a temporary container that you may add to an existing Pod for user-initiated activities such as debugging. Ephemeral containers have no resource or scheduling guarantees, and they will not be restarted when they exit or when a Pod is removed or restarted. The kubelet may evict a Pod if an ephemeral container causes the Pod to exceed its resource allocation.<br><p> <br><p> To add an ephemeral container, use the ephemeralcontainers subresource of an existing Pod. Ephemeral containers may not be removed or restarted.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EphemeralContainer implements Model {


  /**
   * Arguments to the entrypoint. The image's CMD is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
   */
  @JsonProperty("args")
  @Singular(value = "addToArgs", ignoreNullCollections = true)
  private List<String> args;

  /**
   * Entrypoint array. Not executed within a shell. The image's ENTRYPOINT is used if this is not provided. Variable references $(VAR_NAME) are expanded using the container's environment. If a variable cannot be resolved, the reference in the input string will be unchanged. Double $$ are reduced to a single $, which allows for escaping the $(VAR_NAME) syntax: i.e. "$$(VAR_NAME)" will produce the string literal "$(VAR_NAME)". Escaped references will never be expanded, regardless of whether the variable exists or not. Cannot be updated. More info: https://kubernetes.io/docs/tasks/inject-data-application/define-command-argument-container/#running-a-command-in-a-shell
   */
  @JsonProperty("command")
  @Singular(value = "addToCommand", ignoreNullCollections = true)
  private List<String> command;

  /**
   * List of environment variables to set in the container. Cannot be updated.
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<EnvVar> env;

  /**
   * List of sources to populate environment variables in the container. The keys defined within a source must be a C_IDENTIFIER. All invalid keys will be reported as an event when the container is starting. When a key exists in multiple sources, the value associated with the last source will take precedence. Values defined by an Env with a duplicate key will take precedence. Cannot be updated.
   */
  @JsonProperty("envFrom")
  @Singular(value = "addToEnvFrom", ignoreNullCollections = true)
  private List<EnvFromSource> envFrom;

  /**
   * Container image name. More info: https://kubernetes.io/docs/concepts/containers/images
   */
  @JsonProperty("image")
  private String image;

  /**
   * Image pull policy. One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise. Cannot be updated. More info: https://kubernetes.io/docs/concepts/containers/images#updating-images<br><p> <br><p> 
   */
  @JsonProperty("imagePullPolicy")
  private String imagePullPolicy;

  @JsonProperty("lifecycle")
  private Lifecycle lifecycle;

  @JsonProperty("livenessProbe")
  private Probe livenessProbe;

  /**
   * Name of the ephemeral container specified as a DNS_LABEL. This name must be unique among all containers, init containers and ephemeral containers.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Ports are not allowed for ephemeral containers.
   */
  @JsonProperty("ports")
  @Singular(value = "addToPorts", ignoreNullCollections = true)
  private List<ContainerPort> ports;

  @JsonProperty("readinessProbe")
  private Probe readinessProbe;

  @JsonProperty("resources")
  private ResourceRequirements resources;

  @JsonProperty("securityContext")
  private SecurityContext securityContext;

  @JsonProperty("startupProbe")
  private Probe startupProbe;

  /**
   * Whether this container should allocate a buffer for stdin in the container runtime. If this is not set, reads from stdin in the container will always result in EOF. Default is false.
   */
  @JsonProperty("stdin")
  private Boolean stdin;

  /**
   * Whether the container runtime should close the stdin channel after it has been opened by a single attach. When stdin is true the stdin stream will remain open across multiple attach sessions. If stdinOnce is set to true, stdin is opened on container start, is empty until the first client attaches to stdin, and then remains open and accepts data until the client disconnects, at which time stdin is closed and remains closed until the container is restarted. If this flag is false, a container processes that reads from stdin will never receive an EOF. Default is false
   */
  @JsonProperty("stdinOnce")
  private Boolean stdinOnce;

  /**
   * If set, the name of the container from PodSpec that this ephemeral container targets. The ephemeral container will be run in the namespaces (IPC, PID, etc) of this container. If not set then the ephemeral container uses the namespaces configured in the Pod spec.<br><p> <br><p> The container runtime must implement support for this feature. If the runtime does not support namespace targeting then the result of setting this field is undefined.
   */
  @JsonProperty("targetContainerName")
  private String targetContainerName;

  /**
   * Optional: Path at which the file to which the container's termination message will be written is mounted into the container's filesystem. Message written is intended to be brief final status, such as an assertion failure message. Will be truncated by the node if greater than 4096 bytes. The total message length across all containers will be limited to 12kb. Defaults to /dev/termination-log. Cannot be updated.
   */
  @JsonProperty("terminationMessagePath")
  private String terminationMessagePath;

  /**
   * Indicate how the termination message should be populated. File will use the contents of terminationMessagePath to populate the container status message on both success and failure. FallbackToLogsOnError will use the last chunk of container log output if the termination message file is empty and the container exited with an error. The log output is limited to 2048 bytes or 80 lines, whichever is smaller. Defaults to File. Cannot be updated.<br><p> <br><p> 
   */
  @JsonProperty("terminationMessagePolicy")
  private String terminationMessagePolicy;

  /**
   * Whether this container should allocate a TTY for itself, also requires 'stdin' to be true. Default is false.
   */
  @JsonProperty("tty")
  private Boolean tty;

  /**
   * volumeDevices is the list of block devices to be used by the container.
   */
  @JsonProperty("volumeDevices")
  @Singular(value = "addToVolumeDevices", ignoreNullCollections = true)
  private List<VolumeDevice> volumeDevices;

  /**
   * Pod volumes to mount into the container's filesystem. Subpath mounts are not allowed for ephemeral containers. Cannot be updated.
   */
  @JsonProperty("volumeMounts")
  @Singular(value = "addToVolumeMounts", ignoreNullCollections = true)
  private List<VolumeMount> volumeMounts;

  /**
   * Container's working directory. If not specified, the container runtime's default will be used, which might be configured in the container image. Cannot be updated.
   */
  @JsonProperty("workingDir")
  private String workingDir;

}

