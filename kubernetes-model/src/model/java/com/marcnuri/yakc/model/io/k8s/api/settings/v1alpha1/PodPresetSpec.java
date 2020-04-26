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

package com.marcnuri.yakc.model.io.k8s.api.settings.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.EnvFromSource;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.EnvVar;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Volume;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.VolumeMount;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.LabelSelector;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * PodPresetSpec is a description of a pod preset.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodPresetSpec implements Model {


  /**
   * Env defines the collection of EnvVar to inject into containers.
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<EnvVar> env;

  /**
   * EnvFrom defines the collection of EnvFromSource to inject into containers.
   */
  @JsonProperty("envFrom")
  @Singular(value = "addToEnvFrom", ignoreNullCollections = true)
  private List<EnvFromSource> envFrom;

  @JsonProperty("selector")
  private LabelSelector selector;

  /**
   * VolumeMounts defines the collection of VolumeMount to inject into containers.
   */
  @JsonProperty("volumeMounts")
  @Singular(value = "addToVolumeMounts", ignoreNullCollections = true)
  private List<VolumeMount> volumeMounts;

  /**
   * Volumes defines the collection of Volume to inject into the pod.
   */
  @JsonProperty("volumes")
  @Singular(value = "addToVolumes", ignoreNullCollections = true)
  private List<Volume> volumes;

}

