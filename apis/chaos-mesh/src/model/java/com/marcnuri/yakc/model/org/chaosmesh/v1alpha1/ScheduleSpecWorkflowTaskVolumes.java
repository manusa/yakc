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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

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
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScheduleSpecWorkflowTaskVolumes implements Model {


  @JsonProperty("awsElasticBlockStore")
  private ScheduleSpecWorkflowTaskAwsElasticBlockStore awsElasticBlockStore;

  @JsonProperty("azureDisk")
  private ScheduleSpecWorkflowTaskAzureDisk azureDisk;

  @JsonProperty("azureFile")
  private ScheduleSpecWorkflowTaskAzureFile azureFile;

  @JsonProperty("cephfs")
  private ScheduleSpecWorkflowTaskCephfs cephfs;

  @JsonProperty("cinder")
  private ScheduleSpecWorkflowTaskCinder cinder;

  @JsonProperty("configMap")
  private ScheduleSpecWorkflowTaskConfigMap configMap;

  @JsonProperty("csi")
  private ScheduleSpecWorkflowTaskCsi csi;

  @JsonProperty("downwardAPI")
  private ScheduleSpecWorkflowTaskDownwardAPI downwardAPI;

  @JsonProperty("emptyDir")
  private ScheduleSpecWorkflowTaskEmptyDir emptyDir;

  @JsonProperty("fc")
  private ScheduleSpecWorkflowTaskFc fc;

  @JsonProperty("flexVolume")
  private ScheduleSpecWorkflowTaskFlexVolume flexVolume;

  @JsonProperty("flocker")
  private ScheduleSpecWorkflowTaskFlocker flocker;

  @JsonProperty("gcePersistentDisk")
  private ScheduleSpecWorkflowTaskGcePersistentDisk gcePersistentDisk;

  @JsonProperty("gitRepo")
  private ScheduleSpecWorkflowTaskGitRepo gitRepo;

  @JsonProperty("glusterfs")
  private ScheduleSpecWorkflowTaskGlusterfs glusterfs;

  @JsonProperty("hostPath")
  private ScheduleSpecWorkflowTaskHostPath hostPath;

  @JsonProperty("iscsi")
  private ScheduleSpecWorkflowTaskIscsi iscsi;

  /**
   * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("nfs")
  private ScheduleSpecWorkflowTaskNfs nfs;

  @JsonProperty("persistentVolumeClaim")
  private ScheduleSpecWorkflowTaskPersistentVolumeClaim persistentVolumeClaim;

  @JsonProperty("photonPersistentDisk")
  private ScheduleSpecWorkflowTaskPhotonPersistentDisk photonPersistentDisk;

  @JsonProperty("portworxVolume")
  private ScheduleSpecWorkflowTaskPortworxVolume portworxVolume;

  @JsonProperty("projected")
  private ScheduleSpecWorkflowTaskProjected projected;

  @JsonProperty("quobyte")
  private ScheduleSpecWorkflowTaskQuobyte quobyte;

  @JsonProperty("rbd")
  private ScheduleSpecWorkflowTaskRbd rbd;

  @JsonProperty("scaleIO")
  private ScheduleSpecWorkflowTaskScaleIO scaleIO;

  @JsonProperty("secret")
  private ScheduleSpecWorkflowTaskSecret secret;

  @JsonProperty("storageos")
  private ScheduleSpecWorkflowTaskStorageos storageos;

  @JsonProperty("vsphereVolume")
  private ScheduleSpecWorkflowTaskVsphereVolume vsphereVolume;

}

