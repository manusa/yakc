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

package com.marcnuri.yakc.model.com.github.openshift.api.security.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodTemplateSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * PodSecurityPolicySubjectReviewStatus contains information/status for PodSecurityPolicySubjectReview.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodSecurityPolicySubjectReviewStatus implements Model {


  @JsonProperty("allowedBy")
  private ObjectReference allowedBy;

  /**
   * A machine-readable description of why this operation is in the "Failure" status. If this value is empty there is no information available.
   */
  @JsonProperty("reason")
  private String reason;

  @JsonProperty("template")
  private PodTemplateSpec template;

}

