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
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * PersistentVolumeSpec is the specification of a persistent volume.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PersistentVolumeSpec implements Model {


  /**
   * AccessModes contains all ways the volume can be mounted. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes
   */
  @JsonProperty("accessModes")
  @Singular(value = "addToAccessModes", ignoreNullCollections = true)
  private List<String> accessModes;

  @JsonProperty("awsElasticBlockStore")
  private AWSElasticBlockStoreVolumeSource awsElasticBlockStore;

  @JsonProperty("azureDisk")
  private AzureDiskVolumeSource azureDisk;

  @JsonProperty("azureFile")
  private AzureFilePersistentVolumeSource azureFile;

  /**
   * A description of the persistent volume's resources and capacity. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#capacity
   */
  @JsonProperty("capacity")
  @Singular(value = "putInCapacity", ignoreNullCollections = true)
  private Map<String, String> capacity;

  @JsonProperty("cephfs")
  private CephFSPersistentVolumeSource cephfs;

  @JsonProperty("cinder")
  private CinderPersistentVolumeSource cinder;

  @JsonProperty("claimRef")
  private ObjectReference claimRef;

  @JsonProperty("csi")
  private CSIPersistentVolumeSource csi;

  @JsonProperty("fc")
  private FCVolumeSource fc;

  @JsonProperty("flexVolume")
  private FlexPersistentVolumeSource flexVolume;

  @JsonProperty("flocker")
  private FlockerVolumeSource flocker;

  @JsonProperty("gcePersistentDisk")
  private GCEPersistentDiskVolumeSource gcePersistentDisk;

  @JsonProperty("glusterfs")
  private GlusterfsPersistentVolumeSource glusterfs;

  @JsonProperty("hostPath")
  private HostPathVolumeSource hostPath;

  @JsonProperty("iscsi")
  private ISCSIPersistentVolumeSource iscsi;

  @JsonProperty("local")
  private LocalVolumeSource local;

  /**
   * A list of mount options, e.g. ["ro", "soft"]. Not validated - mount will simply fail if one is invalid. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes/#mount-options
   */
  @JsonProperty("mountOptions")
  @Singular(value = "addToMountOptions", ignoreNullCollections = true)
  private List<String> mountOptions;

  @JsonProperty("nfs")
  private NFSVolumeSource nfs;

  @JsonProperty("nodeAffinity")
  private VolumeNodeAffinity nodeAffinity;

  /**
   * What happens to a persistent volume when released from its claim. Valid options are Retain (default for manually created PersistentVolumes), Delete (default for dynamically provisioned PersistentVolumes), and Recycle (deprecated). Recycle must be supported by the volume plugin underlying this PersistentVolume. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#reclaiming
   */
  @JsonProperty("persistentVolumeReclaimPolicy")
  private String persistentVolumeReclaimPolicy;

  @JsonProperty("photonPersistentDisk")
  private PhotonPersistentDiskVolumeSource photonPersistentDisk;

  @JsonProperty("portworxVolume")
  private PortworxVolumeSource portworxVolume;

  @JsonProperty("quobyte")
  private QuobyteVolumeSource quobyte;

  @JsonProperty("rbd")
  private RBDPersistentVolumeSource rbd;

  @JsonProperty("scaleIO")
  private ScaleIOPersistentVolumeSource scaleIO;

  /**
   * Name of StorageClass to which this persistent volume belongs. Empty value means that this volume does not belong to any StorageClass.
   */
  @JsonProperty("storageClassName")
  private String storageClassName;

  @JsonProperty("storageos")
  private StorageOSPersistentVolumeSource storageos;

  /**
   * volumeMode defines if a volume is intended to be used with a formatted filesystem or to remain in raw block state. Value of Filesystem is implied when not included in spec.
   */
  @JsonProperty("volumeMode")
  private String volumeMode;

  @JsonProperty("vsphereVolume")
  private VsphereVirtualDiskVolumeSource vsphereVolume;

}

