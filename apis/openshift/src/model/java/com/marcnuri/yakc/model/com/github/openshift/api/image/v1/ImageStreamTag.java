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
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * ImageStreamTag represents an Image that is retrieved by tag name from an ImageStream. Use this resource to interact with the tags and images in an image stream by tag, or to see the image details for a particular tag. The image associated with this resource is the most recently successfully tagged, imported, or pushed image (as described in the image stream status.tags.items list for this tag). If an import is in progress or has failed the previous image will be shown. Deleting an image stream tag clears both the status and spec fields of an image stream. If no image can be retrieved for a given tag, a not found error will be returned.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageStreamTag implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * conditions is an array of conditions that apply to the image stream tag.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<TagEventCondition> conditions;

  /**
   * generation is the current generation of the tagged image - if tag is provided and this value is not equal to the tag generation, a user has requested an import that has not completed, or conditions will be filled out indicating any error.
   */
  @NonNull
  @JsonProperty("generation")
  private Number generation;

  @NonNull
  @JsonProperty("image")
  private Image image;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @NonNull
  @JsonProperty("lookupPolicy")
  private ImageLookupPolicy lookupPolicy;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  @NonNull
  @JsonProperty("tag")
  private TagReference tag;

}

