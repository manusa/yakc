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

package com.marcnuri.yakc.model.com.coreos.operators.v1alpha1;

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
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CatalogSourceSpec implements Model {


  /**
   * Address is a host that OLM can use to connect to a pre-existing registry. Format: &lt;registry-host or ip&gt;:&lt;port&gt; Only used when SourceType = SourceTypeGrpc. Ignored when the Image field is set.
   */
  @JsonProperty("address")
  private String address;

  /**
   * ConfigMap is the name of the ConfigMap to be used to back a configmap-server registry. Only used when SourceType = SourceTypeConfigmap or SourceTypeInternal.
   */
  @JsonProperty("configMap")
  private String configMap;

  @JsonProperty("description")
  private String description;

  /**
   * Metadata
   */
  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("icon")
  private CatalogSourceSpecIcon icon;

  /**
   * Image is an operator-registry container image to instantiate a registry-server with. Only used when SourceType = SourceTypeGrpc. If present, the address field is ignored.
   */
  @JsonProperty("image")
  private String image;

  @JsonProperty("publisher")
  private String publisher;

  /**
   * Secrets represent set of secrets that can be used to access the contents of the catalog. It is best to keep this list small, since each will need to be tried for every catalog entry.
   */
  @JsonProperty("secrets")
  @Singular(value = "addToSecrets", ignoreNullCollections = true)
  private List<String> secrets;

  /**
   * SourceType is the type of source
   */
  @NonNull
  @JsonProperty("sourceType")
  private String sourceType;

  @JsonProperty("updateStrategy")
  private CatalogSourceSpecUpdateStrategy updateStrategy;

}

