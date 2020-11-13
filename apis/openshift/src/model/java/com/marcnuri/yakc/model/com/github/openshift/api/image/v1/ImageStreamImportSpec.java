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
 * ImageStreamImportSpec defines what images should be imported.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageStreamImportSpec implements Model {


  /**
   * Images are a list of individual images to import.
   */
  @JsonProperty("images")
  @Singular(value = "addToImages", ignoreNullCollections = true)
  private List<ImageImportSpec> images;

  /**
   * Import indicates whether to perform an import - if so, the specified tags are set on the spec and status of the image stream defined by the type meta.
   */
  @NonNull
  @JsonProperty("import")
  private Boolean imports;

  @JsonProperty("repository")
  private RepositoryImportSpec repository;

}

