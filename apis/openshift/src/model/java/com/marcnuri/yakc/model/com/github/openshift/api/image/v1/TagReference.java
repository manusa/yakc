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
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * TagReference specifies optional annotations for images using this tag and an optional reference to an ImageStreamTag, ImageStreamImage, or DockerImage this tag should track.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TagReference implements Model {


  /**
   * Optional; if specified, annotations that are applied to images retrieved via ImageStreamTags.
   */
  @JsonProperty("annotations")
  @Singular(value = "putInAnnotations", ignoreNullCollections = true)
  private Map<String, String> annotations;

  @JsonProperty("from")
  private ObjectReference from;

  /**
   * Generation is a counter that tracks mutations to the spec tag (user intent). When a tag reference is changed the generation is set to match the current stream generation (which is incremented every time spec is changed). Other processes in the system like the image importer observe that the generation of spec tag is newer than the generation recorded in the status and use that as a trigger to import the newest remote tag. To trigger a new import, clients may set this value to zero which will reset the generation to the latest stream generation. Legacy clients will send this value as nil which will be merged with the current tag generation.
   */
  @JsonProperty("generation")
  private Number generation;

  @JsonProperty("importPolicy")
  private TagImportPolicy importPolicy;

  /**
   * Name of the tag
   */
  @NonNull
  @JsonProperty("name")
  private String name;

  /**
   * Reference states if the tag will be imported. Default value is false, which means the tag will be imported.
   */
  @JsonProperty("reference")
  private Boolean reference;

  @JsonProperty("referencePolicy")
  private TagReferencePolicy referencePolicy;

}

