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

package com.marcnuri.yakc.model.com.github.openshift.api.image.v1;

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
 * ImageStreamStatus contains information about the state of this image stream.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageStreamStatus implements Model {


  /**
   * DockerImageRepository represents the effective location this stream may be accessed at. May be empty until the server determines where the repository is located
   */
  @NonNull
  @JsonProperty("dockerImageRepository")
  private String dockerImageRepository;

  /**
   * PublicDockerImageRepository represents the public location from where the image can be pulled outside the cluster. This field may be empty if the administrator has not exposed the integrated registry externally.
   */
  @JsonProperty("publicDockerImageRepository")
  private String publicDockerImageRepository;

  /**
   * Tags are a historical record of images associated with each tag. The first entry in the TagEvent array is the currently tagged image.
   */
  @JsonProperty("tags")
  @Singular(value = "addToTags", ignoreNullCollections = true)
  private List<NamedTagEventList> tags;

}

