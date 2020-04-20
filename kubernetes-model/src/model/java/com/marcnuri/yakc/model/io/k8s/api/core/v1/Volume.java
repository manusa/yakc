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
 * Volume represents a named volume in a pod that may be accessed by any container in the pod.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Volume implements Model {


  @JsonProperty("awsElasticBlockStore")
  private AWSElasticBlockStoreVolumeSource awsElasticBlockStore;

  @JsonProperty("azureDisk")
  private AzureDiskVolumeSource azureDisk;

  @JsonProperty("azureFile")
  private AzureFileVolumeSource azureFile;

  @JsonProperty("cephfs")
  private CephFSVolumeSource cephfs;

  @JsonProperty("cinder")
  private CinderVolumeSource cinder;

  @JsonProperty("configMap")
  private ConfigMapVolumeSource configMap;

  @JsonProperty("csi")
  private CSIVolumeSource csi;

  @JsonProperty("downwardAPI")
  private DownwardAPIVolumeSource downwardAPI;

  @JsonProperty("emptyDir")
  private EmptyDirVolumeSource emptyDir;

  @JsonProperty("fc")
  private FCVolumeSource fc;

  @JsonProperty("flexVolume")
  private FlexVolumeSource flexVolume;

  @JsonProperty("flocker")
  private FlockerVolumeSource flocker;

  @JsonProperty("gcePersistentDisk")
  private GCEPersistentDiskVolumeSource gcePersistentDisk;

  @JsonProperty("gitRepo")
  private GitRepoVolumeSource gitRepo;

  @JsonProperty("glusterfs")
  private GlusterfsVolumeSource glusterfs;

  @JsonProperty("hostPath")
  private HostPathVolumeSource hostPath;

  @JsonProperty("iscsi")
  private ISCSIVolumeSource iscsi;

  /**
   * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("nfs")
  private NFSVolumeSource nfs;

  @JsonProperty("persistentVolumeClaim")
  private PersistentVolumeClaimVolumeSource persistentVolumeClaim;

  @JsonProperty("photonPersistentDisk")
  private PhotonPersistentDiskVolumeSource photonPersistentDisk;

  @JsonProperty("portworxVolume")
  private PortworxVolumeSource portworxVolume;

  @JsonProperty("projected")
  private ProjectedVolumeSource projected;

  @JsonProperty("quobyte")
  private QuobyteVolumeSource quobyte;

  @JsonProperty("rbd")
  private RBDVolumeSource rbd;

  @JsonProperty("scaleIO")
  private ScaleIOVolumeSource scaleIO;

  @JsonProperty("secret")
  private SecretVolumeSource secret;

  @JsonProperty("storageos")
  private StorageOSVolumeSource storageos;

  @JsonProperty("vsphereVolume")
  private VsphereVirtualDiskVolumeSource vsphereVolume;

}

