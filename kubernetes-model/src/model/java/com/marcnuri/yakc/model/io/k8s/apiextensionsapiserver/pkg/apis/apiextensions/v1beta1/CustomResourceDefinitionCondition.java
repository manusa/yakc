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

package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1beta1;

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
 * CustomResourceDefinitionCondition contains details for the current condition of this pod.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomResourceDefinitionCondition implements Model {


  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  /**
   * message is a human-readable message indicating details about last transition.
   */
  @JsonProperty("message")
  private String message;

  /**
   * reason is a unique, one-word, CamelCase reason for the condition's last transition.
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * status is the status of the condition. Can be True, False, Unknown.
   */
  @NonNull
  @JsonProperty("status")
  private String status;

  /**
   * type is the type of the condition. Types include Established, NamesAccepted and Terminating.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

