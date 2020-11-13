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

package com.marcnuri.yakc.model.com.github.operatorframework.operatorlifecyclemanager.pkg.packageserver.apis.operators.v1;

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
 * PackageManifestStatus represents the current status of the PackageManifest
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageManifestStatus implements Model {


  /**
   * CatalogSource is the name of the CatalogSource this package belongs to
   */
  @NonNull
  @JsonProperty("catalogSource")
  private String catalogSource;

  @NonNull
  @JsonProperty("catalogSourceDisplayName")
  private String catalogSourceDisplayName;

  /**
   * <br><p>  CatalogSourceNamespace is the namespace of the owning CatalogSource
   */
  @NonNull
  @JsonProperty("catalogSourceNamespace")
  private String catalogSourceNamespace;

  @NonNull
  @JsonProperty("catalogSourcePublisher")
  private String catalogSourcePublisher;

  /**
   * Channels are the declared channels for the package, ala `stable` or `alpha`.
   */
  @NonNull
  @JsonProperty("channels")
  @Singular(value = "addToChannels", ignoreNullCollections = true)
  private List<PackageChannel> channels;

  /**
   * DefaultChannel is, if specified, the name of the default channel for the package. The default channel will be installed if no other channel is explicitly given. If the package has a single channel, then that channel is implicitly the default.
   */
  @NonNull
  @JsonProperty("defaultChannel")
  private String defaultChannel;

  /**
   * PackageName is the name of the overall package, ala `etcd`.
   */
  @NonNull
  @JsonProperty("packageName")
  private String packageName;

  @JsonProperty("provider")
  private AppLink provider;

}

