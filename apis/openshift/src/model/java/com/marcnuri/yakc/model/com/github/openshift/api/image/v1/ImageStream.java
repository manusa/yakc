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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * An ImageStream stores a mapping of tags to images, metadata overrides that are applied when images are tagged in a stream, and an optional reference to a container image repository on a registry. Users typically update the spec.tags field to point to external images which are imported from container registries using credentials in your namespace with the pull secret type, or to existing image stream tags and images which are immediately accessible for tagging or pulling. The history of images applied to a tag is visible in the status.tags field and any user who can view an image stream is allowed to tag that image into their own image streams. Access to pull images from the integrated registry is granted by having the "get imagestreams/layers" permission on a given image stream. Users may remove a tag by deleting the imagestreamtag resource, which causes both spec and status for that tag to be removed. Image stream history is retained until an administrator runs the prune operation, which removes references that are no longer in use. To preserve a historical image, ensure there is a tag in spec pointing to that image by its digest.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageStream implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  @JsonProperty("spec")
  private ImageStreamSpec spec;

  @JsonProperty("status")
  private ImageStreamStatus status;

}

