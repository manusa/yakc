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
 * RuntimeClassStrategyOptions define the strategy that will dictate the allowable RuntimeClasses for a pod.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RuntimeClassStrategyOptions implements Model {


  /**
   * allowedRuntimeClassNames is a whitelist of RuntimeClass names that may be specified on a pod. A value of "&#42;" means that any RuntimeClass name is allowed, and must be the only item in the list. An empty list requires the RuntimeClassName field to be unset.
   */
  @NonNull
  @JsonProperty("allowedRuntimeClassNames")
  @Singular(value = "addToAllowedRuntimeClassNames", ignoreNullCollections = true)
  private List<String> allowedRuntimeClassNames;

  /**
   * defaultRuntimeClassName is the default RuntimeClassName to set on the pod. The default MUST be allowed by the allowedRuntimeClassNames list. A value of nil does not mutate the Pod.
   */
  @JsonProperty("defaultRuntimeClassName")
  private String defaultRuntimeClassName;

}

