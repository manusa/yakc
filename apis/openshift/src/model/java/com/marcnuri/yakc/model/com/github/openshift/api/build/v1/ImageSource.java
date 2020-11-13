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

package com.marcnuri.yakc.model.com.github.openshift.api.build.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.LocalObjectReference;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * ImageSource is used to describe build source that will be extracted from an image or used during a multi stage build. A reference of type ImageStreamTag, ImageStreamImage or DockerImage may be used. A pull secret can be specified to pull the image from an external registry or override the default service account secret if pulling from the internal registry. Image sources can either be used to extract content from an image and place it into the build context along with the repository source, or used directly during a multi-stage container image build to allow content to be copied without overwriting the contents of the repository source (see the 'paths' and 'as' fields).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageSource implements Model {


  /**
   * A list of image names that this source will be used in place of during a multi-stage container image build. For instance, a Dockerfile that uses "COPY --from=nginx:latest" will first check for an image source that has "nginx:latest" in this field before attempting to pull directly. If the Dockerfile does not reference an image source it is ignored. This field and paths may both be set, in which case the contents will be used twice.
   */
  @JsonProperty("as")
  @Singular(value = "addToAs", ignoreNullCollections = true)
  private List<String> as;

  @NonNull
  @JsonProperty("from")
  private ObjectReference from;

  /**
   * paths is a list of source and destination paths to copy from the image. This content will be copied into the build context prior to starting the build. If no paths are set, the build context will not be altered.
   */
  @JsonProperty("paths")
  @Singular(value = "addToPaths", ignoreNullCollections = true)
  private List<ImageSourcePath> paths;

  @JsonProperty("pullSecret")
  private LocalObjectReference pullSecret;

}

