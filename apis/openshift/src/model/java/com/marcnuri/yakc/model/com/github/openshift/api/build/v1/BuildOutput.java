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
import lombok.Singular;
import lombok.ToString;

/**
 * BuildOutput is input to a build strategy and describes the container image that the strategy should produce.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildOutput implements Model {


  /**
   * imageLabels define a list of labels that are applied to the resulting image. If there are multiple labels with the same name then the last one in the list is used.
   */
  @JsonProperty("imageLabels")
  @Singular(value = "addToImageLabels", ignoreNullCollections = true)
  private List<ImageLabel> imageLabels;

  @JsonProperty("pushSecret")
  private LocalObjectReference pushSecret;

  @JsonProperty("to")
  private ObjectReference to;

}

