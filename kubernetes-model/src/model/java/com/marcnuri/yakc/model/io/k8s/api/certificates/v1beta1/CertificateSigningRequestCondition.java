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

package com.marcnuri.yakc.model.io.k8s.api.certificates.v1beta1;

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
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CertificateSigningRequestCondition implements Model {


  @JsonProperty("lastTransitionTime")
  private OffsetDateTime lastTransitionTime;

  @JsonProperty("lastUpdateTime")
  private OffsetDateTime lastUpdateTime;

  /**
   * human readable message with details about the request state
   */
  @JsonProperty("message")
  private String message;

  /**
   * brief reason for the request state
   */
  @JsonProperty("reason")
  private String reason;

  /**
   * Status of the condition, one of True, False, Unknown. Approved, Denied, and Failed conditions may not be "False" or "Unknown". Defaults to "True". If unset, should be treated as "True".
   */
  @JsonProperty("status")
  private String status;

  /**
   * type of the condition. Known conditions include "Approved", "Denied", and "Failed".
   */
  @NonNull
  @JsonProperty("type")
  private String type;

}

