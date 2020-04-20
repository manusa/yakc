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

package com.marcnuri.yakc.model.io.k8s.api.coordination.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * LeaseSpec is a specification of a Lease.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LeaseSpec implements Model {


  @JsonProperty("acquireTime")
  private OffsetDateTime acquireTime;

  /**
   * holderIdentity contains the identity of the holder of a current lease.
   */
  @JsonProperty("holderIdentity")
  private String holderIdentity;

  /**
   * leaseDurationSeconds is a duration that candidates for a lease need to wait to force acquire it. This is measure against time of last observed RenewTime.
   */
  @JsonProperty("leaseDurationSeconds")
  private Integer leaseDurationSeconds;

  /**
   * leaseTransitions is the number of transitions of a lease between holders.
   */
  @JsonProperty("leaseTransitions")
  private Integer leaseTransitions;

  @JsonProperty("renewTime")
  private OffsetDateTime renewTime;

}

