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

package com.marcnuri.yakc.model.com.github.openshift.api.apps.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodTemplateSpec;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * DeploymentConfigSpec represents the desired state of the deployment.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DeploymentConfigSpec implements Model {


  /**
   * MinReadySeconds is the minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready)
   */
  @JsonProperty("minReadySeconds")
  private Number minReadySeconds;

  /**
   * Paused indicates that the deployment config is paused resulting in no new deployments on template changes or changes in the template caused by other triggers.
   */
  @JsonProperty("paused")
  private Boolean paused;

  /**
   * Replicas is the number of desired replicas.
   */
  @JsonProperty("replicas")
  private Number replicas;

  /**
   * RevisionHistoryLimit is the number of old ReplicationControllers to retain to allow for rollbacks. This field is a pointer to allow for differentiation between an explicit zero and not specified. Defaults to 10. (This only applies to DeploymentConfigs created via the new group API resource, not the legacy resource.)
   */
  @JsonProperty("revisionHistoryLimit")
  private Number revisionHistoryLimit;

  /**
   * Selector is a label query over pods that should match the Replicas count.
   */
  @JsonProperty("selector")
  @Singular(value = "putInSelector", ignoreNullCollections = true)
  private Map<String, String> selector;

  @JsonProperty("strategy")
  private DeploymentStrategy strategy;

  @JsonProperty("template")
  private PodTemplateSpec template;

  /**
   * Test ensures that this deployment config will have zero replicas except while a deployment is running. This allows the deployment config to be used as a continuous deployment test - triggering on images, running the deployment, and then succeeding or failing. Post strategy hooks and After actions can be used to integrate successful deployment with an action.
   */
  @JsonProperty("test")
  private Boolean test;

  /**
   * Triggers determine how updates to a DeploymentConfig result in new deployments. If no triggers are defined, a new deployment can only occur as a result of an explicit client update to the DeploymentConfig with a new LatestVersion. If null, defaults to having a config change trigger.
   */
  @JsonProperty("triggers")
  @Singular(value = "addToTriggers", ignoreNullCollections = true)
  private List<DeploymentTriggerPolicy> triggers;

}

