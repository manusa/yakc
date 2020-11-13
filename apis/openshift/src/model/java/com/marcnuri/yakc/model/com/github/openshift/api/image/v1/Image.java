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
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.runtime.RawExtension;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * Image is an immutable representation of a container image and metadata at a point in time. Images are named by taking a hash of their contents (metadata and content) and any change in format, content, or metadata results in a new name. The images resource is primarily for use by cluster administrators and integrations like the cluster image registry - end users instead access images via the imagestreamtags or imagestreamimages resources. While image metadata is stored in the API, any integration that implements the container image registry API must provide its own storage for the raw manifest data, image config, and layer contents.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Image implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * DockerImageConfig is a JSON blob that the runtime uses to set up the container. This is a part of manifest schema v2.
   */
  @JsonProperty("dockerImageConfig")
  private String dockerImageConfig;

  /**
   * DockerImageLayers represents the layers in the image. May not be set if the image does not define that data.
   */
  @NonNull
  @JsonProperty("dockerImageLayers")
  @Singular(value = "addToDockerImageLayers", ignoreNullCollections = true)
  private List<ImageLayer> dockerImageLayers;

  /**
   * DockerImageManifest is the raw JSON of the manifest
   */
  @JsonProperty("dockerImageManifest")
  private String dockerImageManifest;

  /**
   * DockerImageManifestMediaType specifies the mediaType of manifest. This is a part of manifest schema v2.
   */
  @JsonProperty("dockerImageManifestMediaType")
  private String dockerImageManifestMediaType;

  @JsonProperty("dockerImageMetadata")
  private RawExtension dockerImageMetadata;

  /**
   * DockerImageMetadataVersion conveys the version of the object, which if empty defaults to "1.0"
   */
  @JsonProperty("dockerImageMetadataVersion")
  private String dockerImageMetadataVersion;

  /**
   * DockerImageReference is the string that can be used to pull this image.
   */
  @JsonProperty("dockerImageReference")
  private String dockerImageReference;

  /**
   * DockerImageSignatures provides the signatures as opaque blobs. This is a part of manifest schema v1.
   */
  @JsonProperty("dockerImageSignatures")
  @Singular(value = "addToDockerImageSignatures", ignoreNullCollections = true)
  private List<String> dockerImageSignatures;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  /**
   * Signatures holds all signatures of the image.
   */
  @JsonProperty("signatures")
  @Singular(value = "addToSignatures", ignoreNullCollections = true)
  private List<ImageSignature> signatures;

}

