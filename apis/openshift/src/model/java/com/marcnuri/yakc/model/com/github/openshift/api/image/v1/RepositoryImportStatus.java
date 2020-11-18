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
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * RepositoryImportStatus describes the result of an image repository import
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RepositoryImportStatus implements Model {


  /**
   * AdditionalTags are tags that exist in the repository but were not imported because a maximum limit of automatic imports was applied.
   */
  @JsonProperty("additionalTags")
  @Singular(value = "addToAdditionalTags", ignoreNullCollections = true)
  private List<String> additionalTags;

  /**
   * Images is a list of images successfully retrieved by the import of the repository.
   */
  @JsonProperty("images")
  @Singular(value = "addToImages", ignoreNullCollections = true)
  private List<ImageImportStatus> images;

  @JsonProperty("status")
  private Status status;

}

