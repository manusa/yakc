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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Volume represents a named volume in a pod that may be accessed by any container in the pod.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AlertmanagerSpecVolumes implements Model {


  @JsonProperty("awsElasticBlockStore")
  private AlertmanagerSpecAwsElasticBlockStore awsElasticBlockStore;

  @JsonProperty("azureDisk")
  private AlertmanagerSpecAzureDisk azureDisk;

  @JsonProperty("azureFile")
  private AlertmanagerSpecAzureFile azureFile;

  @JsonProperty("cephfs")
  private AlertmanagerSpecCephfs cephfs;

  @JsonProperty("cinder")
  private AlertmanagerSpecCinder cinder;

  @JsonProperty("configMap")
  private AlertmanagerSpecConfigMap configMap;

  @JsonProperty("csi")
  private AlertmanagerSpecCsi csi;

  @JsonProperty("downwardAPI")
  private AlertmanagerSpecDownwardAPI downwardAPI;

  @JsonProperty("emptyDir")
  private AlertmanagerSpecEmptyDir emptyDir;

  @JsonProperty("fc")
  private AlertmanagerSpecFc fc;

  @JsonProperty("flexVolume")
  private AlertmanagerSpecFlexVolume flexVolume;

  @JsonProperty("flocker")
  private AlertmanagerSpecFlocker flocker;

  @JsonProperty("gcePersistentDisk")
  private AlertmanagerSpecGcePersistentDisk gcePersistentDisk;

  @JsonProperty("gitRepo")
  private AlertmanagerSpecGitRepo gitRepo;

  @JsonProperty("glusterfs")
  private AlertmanagerSpecGlusterfs glusterfs;

  @JsonProperty("hostPath")
  private AlertmanagerSpecHostPath hostPath;

  @JsonProperty("iscsi")
  private AlertmanagerSpecIscsi iscsi;

  /**
   * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("nfs")
  private AlertmanagerSpecNfs nfs;

  @JsonProperty("persistentVolumeClaim")
  private AlertmanagerSpecPersistentVolumeClaim persistentVolumeClaim;

  @JsonProperty("photonPersistentDisk")
  private AlertmanagerSpecPhotonPersistentDisk photonPersistentDisk;

  @JsonProperty("portworxVolume")
  private AlertmanagerSpecPortworxVolume portworxVolume;

  @JsonProperty("projected")
  private AlertmanagerSpecProjected projected;

  @JsonProperty("quobyte")
  private AlertmanagerSpecQuobyte quobyte;

  @JsonProperty("rbd")
  private AlertmanagerSpecRbd rbd;

  @JsonProperty("scaleIO")
  private AlertmanagerSpecScaleIO scaleIO;

  @JsonProperty("secret")
  private AlertmanagerSpecSecret secret;

  @JsonProperty("storageos")
  private AlertmanagerSpecStorageos storageos;

  @JsonProperty("vsphereVolume")
  private AlertmanagerSpecVsphereVolume vsphereVolume;

}

