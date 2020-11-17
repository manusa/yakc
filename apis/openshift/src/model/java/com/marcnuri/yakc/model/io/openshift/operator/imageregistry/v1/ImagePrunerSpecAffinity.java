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

package com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecAffinityNodeAffinity;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecAffinityPodAffinity;
import com.marcnuri.yakc.model.com.coreos.monitoring.v1.AlertmanagerSpecAffinityPodAntiAffinity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * affinity is a group of node affinity scheduling rules for the image pruner pod.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImagePrunerSpecAffinity implements Model {


  @JsonProperty("nodeAffinity")
  private AlertmanagerSpecAffinityNodeAffinity nodeAffinity;

  @JsonProperty("podAffinity")
  private AlertmanagerSpecAffinityPodAffinity podAffinity;

  @JsonProperty("podAntiAffinity")
  private AlertmanagerSpecAffinityPodAntiAffinity podAntiAffinity;

}

