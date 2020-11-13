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
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * TagEvent is used by ImageStreamStatus to keep a historical record of images associated with a tag.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TagEvent implements Model {


  @NonNull
  @JsonProperty("created")
  private OffsetDateTime created;

  /**
   * DockerImageReference is the string that can be used to pull this image
   */
  @NonNull
  @JsonProperty("dockerImageReference")
  private String dockerImageReference;

  /**
   * Generation is the spec tag generation that resulted in this tag being updated
   */
  @NonNull
  @JsonProperty("generation")
  private Number generation;

  /**
   * Image is the image
   */
  @NonNull
  @JsonProperty("image")
  private String image;

}

