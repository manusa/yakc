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

package com.marcnuri.yakc.model.io.k8s.api.resource.v1alpha2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ResourceClaimStatus tracks whether the resource has been allocated and what the resulting attributes are.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResourceClaimStatus implements Model {


  @JsonProperty("allocation")
  private AllocationResult allocation;

  /**
   * DeallocationRequested indicates that a ResourceClaim is to be deallocated.<br><p> <br><p> The driver then must deallocate this claim and reset the field together with clearing the Allocation field.<br><p> <br><p> While DeallocationRequested is set, no new consumers may be added to ReservedFor.
   */
  @JsonProperty("deallocationRequested")
  private Boolean deallocationRequested;

  /**
   * DriverName is a copy of the driver name from the ResourceClass at the time when allocation started.
   */
  @JsonProperty("driverName")
  private String driverName;

  /**
   * ReservedFor indicates which entities are currently allowed to use the claim. A Pod which references a ResourceClaim which is not reserved for that Pod will not be started.<br><p> <br><p> There can be at most 32 such reservations. This may get increased in the future, but not reduced.
   */
  @JsonProperty("reservedFor")
  @Singular(value = "addToReservedFor", ignoreNullCollections = true)
  private List<ResourceClaimConsumerReference> reservedFor;

}

