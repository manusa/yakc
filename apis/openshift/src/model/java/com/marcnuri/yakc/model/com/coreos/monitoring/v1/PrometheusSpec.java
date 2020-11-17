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
 * Specification of the desired behavior of the Prometheus cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpec implements Model {


  @JsonProperty("additionalAlertManagerConfigs")
  private PrometheusSpecAdditionalAlertManagerConfigs additionalAlertManagerConfigs;

  @JsonProperty("additionalAlertRelabelConfigs")
  private PrometheusSpecAdditionalAlertRelabelConfigs additionalAlertRelabelConfigs;

  @JsonProperty("additionalScrapeConfigs")
  private PrometheusSpecAdditionalScrapeConfigs additionalScrapeConfigs;

  @JsonProperty("affinity")
  private AlertmanagerSpecAffinity affinity;

  @JsonProperty("alerting")
  private PrometheusSpecAlerting alerting;

  @JsonProperty("apiserverConfig")
  private PrometheusSpecApiserverConfig apiserverConfig;

  @JsonProperty("arbitraryFSAccessThroughSMs")
  private PrometheusSpecArbitraryFSAccessThroughSMs arbitraryFSAccessThroughSMs;

  /**
   * Base image to use for a Prometheus deployment.
   */
  @JsonProperty("baseImage")
  private String baseImage;

  /**
   * ConfigMaps is a list of ConfigMaps in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. The ConfigMaps are mounted into /etc/prometheus/configmaps/&lt;configmap-name&gt;.
   */
  @JsonProperty("configMaps")
  @Singular(value = "addToConfigMaps", ignoreNullCollections = true)
  private List<String> configMaps;

  /**
   * Containers allows injecting additional containers or modifying operator generated containers. This can be used to allow adding an authentication proxy to a Prometheus pod or to change the behavior of an operator generated container. Containers described here modify an operator generated container if they share the same name and modifications are done via a strategic merge patch. The current container names are: `prometheus`, `prometheus-config-reloader`, `rules-configmap-reloader`, and `thanos-sidecar`. Overriding containers is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.
   */
  @JsonProperty("containers")
  @Singular(value = "addToContainers", ignoreNullCollections = true)
  private List<AlertmanagerSpecContainers> containers;

  /**
   * Disable prometheus compaction.
   */
  @JsonProperty("disableCompaction")
  private Boolean disableCompaction;

  /**
   * Enable access to prometheus web admin API. Defaults to the value of `false`. WARNING: Enabling the admin APIs enables mutating endpoints, to delete data, shutdown Prometheus, and more. Enabling this should be done with care and the user is advised to add additional authentication authorization via a proxy to ensure only clients authorized to perform these actions can do so. For more information see https://prometheus.io/docs/prometheus/latest/querying/api/#tsdb-admin-apis
   */
  @JsonProperty("enableAdminAPI")
  private Boolean enableAdminAPI;

  /**
   * EnforcedNamespaceLabel enforces adding a namespace label of origin for each alert and metric that is user created. The label value will always be the namespace of the object that is being created.
   */
  @JsonProperty("enforcedNamespaceLabel")
  private String enforcedNamespaceLabel;

  /**
   * Interval between consecutive evaluations.
   */
  @JsonProperty("evaluationInterval")
  private String evaluationInterval;

  /**
   * The labels to add to any time series or alerts when communicating with external systems (federation, remote storage, Alertmanager).
   */
  @JsonProperty("externalLabels")
  @Singular(value = "putInExternalLabels", ignoreNullCollections = true)
  private Map<String, String> externalLabels;

  /**
   * The external URL the Prometheus instances will be available under. This is necessary to generate correct URLs. This is necessary if Prometheus is not served from root of a DNS name.
   */
  @JsonProperty("externalUrl")
  private String externalUrl;

  /**
   * IgnoreNamespaceSelectors if set to true will ignore NamespaceSelector settings from the podmonitor and servicemonitor configs, and they will only discover endpoints within their current namespace.  Defaults to false.
   */
  @JsonProperty("ignoreNamespaceSelectors")
  private Boolean ignoreNamespaceSelectors;

  /**
   * Image if specified has precedence over baseImage, tag and sha combinations. Specifying the version is still necessary to ensure the Prometheus Operator knows what version of Prometheus is being configured.
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
   * InitContainers allows adding initContainers to the pod definition. Those can be used to e.g. fetch secrets for injection into the Prometheus configuration from external sources. Any errors during the execution of an initContainer will lead to a restart of the Pod. More info: https://kubernetes.io/docs/concepts/workloads/pods/init-containers/ Using initContainers for any use case other then secret fetching is entirely outside the scope of what the maintainers will support and by doing so, you accept that this behaviour may break at any time without notice.
   */
  @JsonProperty("initContainers")
  @Singular(value = "addToInitContainers", ignoreNullCollections = true)
  private List<AlertmanagerSpecContainers> initContainers;

  /**
   * ListenLocal makes the Prometheus server listen on loopback, so that it does not bind against the Pod IP.
   */
  @JsonProperty("listenLocal")
  private Boolean listenLocal;

  /**
   * Log format for Prometheus to be configured with.
   */
  @JsonProperty("logFormat")
  private String logFormat;

  /**
   * Log level for Prometheus to be configured with.
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
   * OverrideHonorLabels if set to true overrides all user configured honor_labels. If HonorLabels is set in ServiceMonitor or PodMonitor to true, this overrides honor_labels to false.
   */
  @JsonProperty("overrideHonorLabels")
  private Boolean overrideHonorLabels;

  /**
   * OverrideHonorTimestamps allows to globally enforce honoring timestamps in all scrape configs.
   */
  @JsonProperty("overrideHonorTimestamps")
  private Boolean overrideHonorTimestamps;

  /**
   * When a Prometheus deployment is paused, no actions except for deletion will be performed on the underlying objects.
   */
  @JsonProperty("paused")
  private Boolean paused;

  /**
   * Standard object’s metadata. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#metadata Metadata Labels and Annotations gets propagated to the prometheus pods.
   */
  @JsonProperty("podMetadata")
  private Object podMetadata;

  @JsonProperty("podMonitorNamespaceSelector")
  private PrometheusSpecPodMonitorNamespaceSelector podMonitorNamespaceSelector;

  @JsonProperty("podMonitorSelector")
  private PrometheusSpecPodMonitorSelector podMonitorSelector;

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
   * Name of Prometheus external label used to denote Prometheus instance name. Defaults to the value of `prometheus`. External label will _not_ be added when value is set to empty string (`""`).
   */
  @JsonProperty("prometheusExternalLabelName")
  private String prometheusExternalLabelName;

  @JsonProperty("query")
  private PrometheusSpecQuery query;

  /**
   * If specified, the remote_read spec. This is an experimental feature, it may change in any upcoming release in a breaking way.
   */
  @JsonProperty("remoteRead")
  @Singular(value = "addToRemoteRead", ignoreNullCollections = true)
  private List<PrometheusSpecRemoteRead> remoteRead;

  /**
   * If specified, the remote_write spec. This is an experimental feature, it may change in any upcoming release in a breaking way.
   */
  @JsonProperty("remoteWrite")
  @Singular(value = "addToRemoteWrite", ignoreNullCollections = true)
  private List<PrometheusSpecRemoteWrite> remoteWrite;

  /**
   * Name of Prometheus external label used to denote replica name. Defaults to the value of `prometheus_replica`. External label will _not_ be added when value is set to empty string (`""`).
   */
  @JsonProperty("replicaExternalLabelName")
  private String replicaExternalLabelName;

  /**
   * Number of instances to deploy for a Prometheus deployment.
   */
  @JsonProperty("replicas")
  private Number replicas;

  @JsonProperty("resources")
  private AlertmanagerSpecResources_1 resources;

  /**
   * Time duration Prometheus shall retain data for. Default is '24h', and must match the regular expression `[0-9]+(ms|s|m|h|d|w|y)` (milliseconds seconds minutes hours days weeks years).
   */
  @JsonProperty("retention")
  private String retention;

  /**
   * Maximum amount of disk space used by blocks.
   */
  @JsonProperty("retentionSize")
  private String retentionSize;

  /**
   * The route prefix Prometheus registers HTTP handlers for. This is useful, if using ExternalURL and a proxy is rewriting HTTP routes of a request, and the actual ExternalURL is still true, but the server serves requests under a different route prefix. For example for use with `kubectl proxy`.
   */
  @JsonProperty("routePrefix")
  private String routePrefix;

  @JsonProperty("ruleNamespaceSelector")
  private PrometheusSpecRuleNamespaceSelector ruleNamespaceSelector;

  @JsonProperty("ruleSelector")
  private PrometheusSpecRuleSelector ruleSelector;

  @JsonProperty("rules")
  private PrometheusSpecRules rules;

  /**
   * Interval between consecutive scrapes.
   */
  @JsonProperty("scrapeInterval")
  private String scrapeInterval;

  /**
   * Secrets is a list of Secrets in the same namespace as the Prometheus object, which shall be mounted into the Prometheus Pods. The Secrets are mounted into /etc/prometheus/secrets/&lt;secret-name&gt;.
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

  @JsonProperty("serviceMonitorNamespaceSelector")
  private PrometheusSpecServiceMonitorNamespaceSelector serviceMonitorNamespaceSelector;

  @JsonProperty("serviceMonitorSelector")
  private PrometheusSpecServiceMonitorSelector serviceMonitorSelector;

  /**
   * SHA of Prometheus container image to be deployed. Defaults to the value of `version`. Similar to a tag, but the SHA explicitly deploys an immutable container image. Version and Tag are ignored if SHA is set.
   */
  @JsonProperty("sha")
  private String sha;

  @JsonProperty("storage")
  private PrometheusSpecStorage storage;

  /**
   * Tag of Prometheus container image to be deployed. Defaults to the value of `version`. Version is ignored if Tag is set.
   */
  @JsonProperty("tag")
  private String tag;

  @JsonProperty("thanos")
  private PrometheusSpecThanos thanos;

  /**
   * If specified, the pod's tolerations.
   */
  @JsonProperty("tolerations")
  @Singular(value = "addToTolerations", ignoreNullCollections = true)
  private List<AlertmanagerSpecTolerations> tolerations;

  /**
   * Version of Prometheus to be deployed.
   */
  @JsonProperty("version")
  private String version;

  /**
   * Volumes allows configuration of additional volumes on the output StatefulSet definition. Volumes specified will be appended to other volumes that are generated as a result of StorageSpec objects.
   */
  @JsonProperty("volumes")
  @Singular(value = "addToVolumes", ignoreNullCollections = true)
  private List<AlertmanagerSpecVolumes> volumes;

  /**
   * Enable compression of the write-ahead log using Snappy. This flag is only available in versions of Prometheus &gt;= 2.11.0.
   */
  @JsonProperty("walCompression")
  private Boolean walCompression;

}

