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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * Represents a Ceph Filesystem mount that lasts the lifetime of a pod Cephfs volumes do not support ownership management or SELinux relabeling.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CephFSPersistentVolumeSource implements Model {


  /**
   * Required: Monitors is a collection of Ceph monitors More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
   */
  @NonNull
  @JsonProperty("monitors")
  @Singular(value = "addToMonitors", ignoreNullCollections = true)
  private List<String> monitors;

  /**
   * Optional: Used as the mounted root, rather than the full Ceph tree, default is /
   */
  @JsonProperty("path")
  private String path;

  /**
   * Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts. More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  /**
   * Optional: SecretFile is the path to key ring for User, default is /etc/ceph/user.secret More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("secretFile")
  private String secretFile;

  @JsonProperty("secretRef")
  private SecretReference secretRef;

  /**
   * Optional: User is the rados user name, default is admin More info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
   */
  @JsonProperty("user")
  private String user;

}

