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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * Spec defines the desired characteristics of a volume requested by a pod author. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpecStorageVolumeClaimTemplateSpec implements Model {


  /**
   * AccessModes contains the desired access modes the volume should have. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
   */
  @JsonProperty("accessModes")
  @Singular(value = "addToAccessModes", ignoreNullCollections = true)
  private List<String> accessModes;

  @JsonProperty("dataSource")
  private AlertmanagerSpecStorageVolumeClaimTemplateSpecDataSource dataSource;

  @JsonProperty("resources")
  private AlertmanagerSpecStorageVolumeClaimTemplateSpecResources resources;

  @JsonProperty("selector")
  private AlertmanagerSpecStorageVolumeClaimTemplateSpecSelector selector;

  /**
   * Name of the StorageClass required by the claim. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#class-1
   */
  @JsonProperty("storageClassName")
  private String storageClassName;

  /**
   * volumeMode defines what type of volume is required by the claim. Value of Filesystem is implied when not included in claim spec. This is a beta feature.
   */
  @JsonProperty("volumeMode")
  private String volumeMode;

  /**
   * VolumeName is the binding reference to the PersistentVolume backing this claim.
   */
  @JsonProperty("volumeName")
  private String volumeName;

}

