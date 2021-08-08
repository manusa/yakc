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
 * ConfigMapNodeConfigSource contains the information to reference a ConfigMap as a config source for the Node. This API is deprecated since 1.22: https://git.k8s.io/enhancements/keps/sig-node/281-dynamic-kubelet-configuration
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigMapNodeConfigSource implements Model {


  /**
   * KubeletConfigKey declares which key of the referenced ConfigMap corresponds to the KubeletConfiguration structure This field is required in all cases.
   */
  @NonNull
  @JsonProperty("kubeletConfigKey")
  private String kubeletConfigKey;

  /**
   * Name is the metadata.name of the referenced ConfigMap. This field is required in all cases.
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Namespace is the metadata.namespace of the referenced ConfigMap. This field is required in all cases.
   */
  @NonNull
  @JsonProperty("namespace")
  private String namespace;

  /**
   * ResourceVersion is the metadata.ResourceVersion of the referenced ConfigMap. This field is forbidden in Node.Spec, and required in Node.Status.
   */
  @JsonProperty("resourceVersion")
  private String resourceVersion;

  /**
   * UID is the metadata.UID of the referenced ConfigMap. This field is forbidden in Node.Spec, and required in Node.Status.
   */
  @JsonProperty("uid")
  private String uid;

}

