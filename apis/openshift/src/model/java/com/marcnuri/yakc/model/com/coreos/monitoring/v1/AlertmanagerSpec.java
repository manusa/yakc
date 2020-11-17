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

package com.marcnuri.yakc.model.com.coreos.monitoring.v1;

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
 * Specification of the desired behavior of the Alertmanager cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpec implements Model {


  /**
   * AdditionalPeers allows injecting a set of additional Alertmanagers to peer with to form a highly available cluster.
   */
  @JsonProperty("additionalPeers")
  @Singular(value = "addToAdditionalPeers", ignoreNullCollections = true)
  private List<String> additionalPeers;

  @JsonProperty("affinity")
  private AlertmanagerSpecAffinity affinity;

  /**
   * Base image that is used to deploy pods, without tag.
   */
  @JsonProperty("baseImage")
  private String baseImage;

  /**
   * ConfigMaps is a list of ConfigMaps in the same namespace as the Alertmanager object, which shall be mounted into the Alertmanager Pods. The ConfigMaps are mounted into /etc/alertmanager/configmaps/&lt;configmap-name&gt;.
   */
  @JsonProperty("configMaps")
  @Singular(value = "addToConfigMaps", ignoreNullCollections = true)
  private List<String> configMaps;

  /**
   * ConfigSecret is the name of a Kubernetes Secret in the same namespace as the Alertmanager object, which contains configuration for this Alertmanager instance. Defaults to 'alertmanager-&lt;alertmanager-name&gt;' The secret is mounted into /etc/alertmanager/config.
   */
  @JsonProperty("configSecret")
  private String configSecret;

  /**
   * Containers allows injecting additional containers. This is meant to allow adding an authentication proxy to an Alertmanager pod.
   */
  @JsonProperty("containers")
  @Singular(value = "addToContainers", ignoreNullCollections = true)
  private List<AlertmanagerSpecContainers> containers;

  /**
   * The external URL the Alertmanager instances will be available under. This is necessary to generate correct URLs. This is necessary if Alertmanager is not served from root of a DNS name.
   */
  @JsonProperty("externalUrl")
  private String externalUrl;

  /**
   * Image if specified has precedence over baseImage, tag and sha combinations. Specifying the version is still necessary to ensure the Prometheus Operator knows what version of Alertmanager is being configured.
   */
  @JsonProperty("image")
  private String image;

  /**
   * An optional list of references to secrets in the same namespace to use for pulling prometheus and alertmanager images from registries see http://kubernetes.io/docs/user-guide/images#specifying-imagepullsecrets-on-a-pod
   */
  @JsonProperty("imagePullSecrets")
  @Singular(value = "addToImagePullSecrets", ignoreNullCollections = true)
  private List<AlertmanagerSpecImagePullSecrets> imagePullSecrets;

  /**
   * InitContainers allows adding initContainers to the pod definition. Those can be used to e.g. fetch secrets for injection into the Alertmanager configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ Using initContainers for any use case other then secret fetching is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.
   */
  @JsonProperty("initContainers")
  @Singular(value = "addToInitContainers", ignoreNullCollections = true)
  private List<AlertmanagerSpecContainers> initContainers;

  /**
   * ListenLocal makes the Alertmanager server listen on loopback, so that it does not bind against the Pod IP. Note this is only for the Alertmanager UI, not the gossip communication.
   */
  @JsonProperty("listenLocal")
  private Boolean listenLocal;

  /**
   * Log format for Alertmanager to be configured with.
   */
  @JsonProperty("logFormat")
  private String logFormat;

  /**
   * Log level for Alertmanager to be configured with.
   */
  @JsonProperty("logLevel")
  private String logLevel;

  /**
   * Define which Nodes the Pods are scheduled on.
   */
  @JsonProperty("nodeSelector")
  @Singular(value = "putInNodeSelector", ignoreNullCollections = true)
  private Map<String, String> nodeSelector;

  /**
   * If set to true all actions on the underlaying managed objects are not goint to be performed, except for delete actions.
   */
  @JsonProperty("paused")
  private Boolean paused;

  /**
   * Standard object’s metadata. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#metadata Metadata Labels and Annotations gets propagated to the prometheus pods.
   */
  @JsonProperty("podMetadata")
  private Object podMetadata;

  /**
   * Port name used for the pods and governing service. This defaults to web
   */
  @JsonProperty("portName")
  private String portName;

  /**
   * Priority class assigned to the Pods
   */
  @JsonProperty("priorityClassName")
  private String priorityClassName;

  /**
   * Size is the expected size of the alertmanager cluster. The controller will eventually make the size of the running cluster equal to the expected size.
   */
  @JsonProperty("replicas")
  private Number replicas;

  @JsonProperty("resources")
  private AlertmanagerSpecResources_1 resources;

  /**
   * Time duration Alertmanager shall retain data for. Default is '120h', and must match the regular expression `[0-9]+(ms|s|m|h)` (milliseconds seconds minutes hours).
   */
  @JsonProperty("retention")
  private String retention;

  /**
   * The route prefix Alertmanager registers HTTP handlers for. This is useful, if using ExternalURL and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
   */
  @JsonProperty("routePrefix")
  private String routePrefix;

  /**
   * Secrets is a list of Secrets in the same namespace as the Alertmanager object, which shall be mounted into the Alertmanager Pods. The Secrets are mounted into /etc/alertmanager/secrets/&lt;secret-name&gt;.
   */
  @JsonProperty("secrets")
  @Singular(value = "addToSecrets", ignoreNullCollections = true)
  private List<String> secrets;

  @JsonProperty("securityContext")
  private AlertmanagerSpecSecurityContext_1 securityContext;

  /**
   * ServiceAccountName is the name of the ServiceAccount to use to run the Prometheus Pods.
   */
  @JsonProperty("serviceAccountName")
  private String serviceAccountName;

  /**
   * SHA of Alertmanager container image to be deployed. Defaults to the value of `version`. Similar to a tag, but the SHA explicitly deploys an immutable container image. Version and Tag are ignored if SHA is set.
   */
  @JsonProperty("sha")
  private String sha;

  @JsonProperty("storage")
  private AlertmanagerSpecStorage storage;

  /**
   * Tag of Alertmanager container image to be deployed. Defaults to the value of `version`. Version is ignored if Tag is set.
   */
  @JsonProperty("tag")
  private String tag;

  /**
   * If specified, the pod's tolerations.
   */
  @JsonProperty("tolerations")
  @Singular(value = "addToTolerations", ignoreNullCollections = true)
  private List<AlertmanagerSpecTolerations> tolerations;

  /**
   * Version the cluster should be on.
   */
  @JsonProperty("version")
  private String version;

  /**
   * VolumeMounts allows configuration of additional VolumeMounts on the output StatefulSet definition. VolumeMounts specified will be appended to other VolumeMounts in the alertmanager container, that are generated as a result of StorageSpec objects.
   */
  @JsonProperty("volumeMounts")
  @Singular(value = "addToVolumeMounts", ignoreNullCollections = true)
  private List<AlertmanagerSpecVolumeMounts> volumeMounts;

  /**
   * Volumes allows configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
   */
  @JsonProperty("volumes")
  @Singular(value = "addToVolumes", ignoreNullCollections = true)
  private List<AlertmanagerSpecVolumes> volumes;

}

