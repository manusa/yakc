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
import lombok.ToString;

/**
 * Thanos configuration allows configuring various aspects of a Prometheus server in a Thanos environment. <br><p>  This section is experimental, it may change significantly without deprecation notice in any release. <br><p>  This is experimental and may change significantly without backward compatibility in any release.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PrometheusSpecThanos implements Model {


  /**
   * Thanos base image if other than default.
   */
  @JsonProperty("baseImage")
  private String baseImage;

  /**
   * Image if specified has precedence over baseImage, tag and sha combinations. Specifying the version is still necessary to ensure the Prometheus Operator knows what version of Thanos is being configured.
   */
  @JsonProperty("image")
  private String image;

  /**
   * ListenLocal makes the Thanos sidecar listen on loopback, so that it does not bind against the Pod IP.
   */
  @JsonProperty("listenLocal")
  private Boolean listenLocal;

  @JsonProperty("objectStorageConfig")
  private PrometheusSpecThanosObjectStorageConfig objectStorageConfig;

  @JsonProperty("resources")
  private PrometheusSpecThanosResources resources;

  /**
   * SHA of Thanos container image to be deployed. Defaults to the value of `version`. Similar to a tag, but the SHA explicitly deploys an immutable container image. Version and Tag are ignored if SHA is set.
   */
  @JsonProperty("sha")
  private String sha;

  /**
   * Tag of Thanos sidecar container image to be deployed. Defaults to the value of `version`. Version is ignored if Tag is set.
   */
  @JsonProperty("tag")
  private String tag;

  /**
   * Version describes the version of Thanos to use.
   */
  @JsonProperty("version")
  private String version;

}

