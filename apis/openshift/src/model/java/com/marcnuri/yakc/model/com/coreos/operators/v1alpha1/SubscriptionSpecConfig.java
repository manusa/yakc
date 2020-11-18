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
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecEnv;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecEnvFrom;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecTolerations;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecVolumeMounts;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecVolumes;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * SubscriptionConfig contains configuration specified for a subscription.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SubscriptionSpecConfig implements Model {


  /**
   * Env is a list of environment variables to set in the container. Cannot be updated.
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<AlertmanagerSpecEnv> env;

  /**
   * EnvFrom is a list of sources to populate environment variables in the container. The keys defined within a source must be a C_IDENTIFIER. All invalid keys will be reported as an event when the container is starting. When a key exists in multiple sources, the value associated with the last source will take precedence. Values defined by an Env with a duplicate key will take precedence. Immutable.
   */
  @JsonProperty("envFrom")
  @Singular(value = "addToEnvFrom", ignoreNullCollections = true)
  private List<AlertmanagerSpecEnvFrom> envFrom;

  /**
   * NodeSelector is a selector which must be true for the pod to fit on a node. Selector which must match a node's labels for the pod to be scheduled on that node. More info: https://kubernetes.io/docs/concepts/configuration/assign-pod-node/
   */
  @JsonProperty("nodeSelector")
  @Singular(value = "putInNodeSelector", ignoreNullCollections = true)
  private Map<String, String> nodeSelector;

  @JsonProperty("resources")
  private SubscriptionSpecConfigResources resources;

  @JsonProperty("selector")
  private SubscriptionSpecConfigSelector selector;

  /**
   * Tolerations are the pod's tolerations.
   */
  @JsonProperty("tolerations")
  @Singular(value = "addToTolerations", ignoreNullCollections = true)
  private List<AlertmanagerSpecTolerations> tolerations;

  /**
   * List of VolumeMounts to set in the container.
   */
  @JsonProperty("volumeMounts")
  @Singular(value = "addToVolumeMounts", ignoreNullCollections = true)
  private List<AlertmanagerSpecVolumeMounts> volumeMounts;

  /**
   * List of Volumes to set in the podSpec.
   */
  @JsonProperty("volumes")
  @Singular(value = "addToVolumes", ignoreNullCollections = true)
  private List<AlertmanagerSpecVolumes> volumes;

}

