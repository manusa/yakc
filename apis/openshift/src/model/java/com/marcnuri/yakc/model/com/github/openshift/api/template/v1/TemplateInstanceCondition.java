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

package com.marcnuri.yakc.model.com.github.openshift.api.template.v1;

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
 * TemplateInstanceCondition contains condition information for a TemplateInstance.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TemplateInstanceCondition implements Model {


  @NonNull
  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  /**
   * Message is a human readable description of the details of the last transition, complementing reason.
   */
  @NonNull
  @JsonProperty("message")
  private String message;

  /**
   * Reason is a brief machine readable explanation for the condition's last transition.
   */
  @NonNull
  @JsonProperty("reason")
  private String reason;

  /**
   * Status of the condition, one of True, False or Unknown.
   */
  @NonNull
  @JsonProperty("status")
  private String status;

  /**
   * Type of the condition, currently Ready or InstantiateFailure.
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

