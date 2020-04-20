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
 * ISCSIPersistentVolumeSource represents an ISCSI disk. ISCSI volumes can only be mounted as read/write once. ISCSI volumes support ownership management and SELinux relabeling.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ISCSIPersistentVolumeSource implements Model {


  /**
   * whether support iSCSI Discovery CHAP authentication
   */
  @JsonProperty("chapAuthDiscovery")
  private Boolean chapAuthDiscovery;

  /**
   * whether support iSCSI Session CHAP authentication
   */
  @JsonProperty("chapAuthSession")
  private Boolean chapAuthSession;

  /**
   * Filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info: https://kubernetes.io/docs/concepts/storage/volumes#iscsi
   */
  @JsonProperty("fsType")
  private String fsType;

  /**
   * Custom iSCSI Initiator Name. If initiatorName is specified with iscsiInterface simultaneously, new iSCSI interface &lt;target portal&gt;:&lt;volume name&gt; will be created for the connection.
   */
  @JsonProperty("initiatorName")
  private String initiatorName;

  /**
   * Target iSCSI Qualified Name.
   */
  @NonNull
  @JsonProperty("iqn")
  private String iqn;

  /**
   * iSCSI Interface Name that uses an iSCSI transport. Defaults to 'default' (tcp).
   */
  @JsonProperty("iscsiInterface")
  private String iscsiInterface;

  /**
   * iSCSI Target Lun number.
   */
  @NonNull
  @JsonProperty("lun")
  private Integer lun;

  /**
   * iSCSI Target Portal List. The Portal is either an IP or ip_addr:port if the port is other than default (typically TCP ports 860 and 3260).
   */
  @JsonProperty("portals")
  @Singular("addToPortals")
  private List<String> portals;

  /**
   * ReadOnly here will force the ReadOnly setting in VolumeMounts. Defaults to false.
   */
  @JsonProperty("readOnly")
  private Boolean readOnly;

  @JsonProperty("secretRef")
  private SecretReference secretRef;

  /**
   * iSCSI Target Portal. The Portal is either an IP or ip_addr:port if the port is other than default (typically TCP ports 860 and 3260).
   */
  @NonNull
  @JsonProperty("targetPortal")
  private String targetPortal;

}

