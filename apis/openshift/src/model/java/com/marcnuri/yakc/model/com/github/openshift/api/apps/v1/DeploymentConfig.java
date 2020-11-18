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
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Deployment Configs define the template for a pod and manages deploying new images or configuration changes. A single deployment configuration is usually analogous to a single micro-service. Can support many different deployment patterns, including full restart, customizable rolling updates, and  fully custom behaviors, as well as pre- and post- deployment hooks. Each individual deployment is represented as a replication controller.<br><p> <br><p> A deployment is "triggered" when its configuration is changed or a tag in an Image Stream is changed. Triggers can be disabled to allow manual control over a deployment. The "strategy" determines how the deployment is carried out and may be changed at any time. The `latestVersion` field is updated when a new deployment is triggered by any means.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DeploymentConfig implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  @NonNull
  @JsonProperty("spec")
  private DeploymentConfigSpec spec;

  @JsonProperty("status")
  private DeploymentConfigStatus status;

}

