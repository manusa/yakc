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

package com.marcnuri.yakc.model.io.k8s.api.flowcontrol.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * LimitedPriorityLevelConfiguration specifies how to handle requests that are subject to limits. It addresses two issues:<br><p>   - How are requests for this priority level limited?<br><p>   - What should be done with requests that exceed the limit?
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LimitedPriorityLevelConfiguration implements Model {


  /**
   * `borrowingLimitPercent`, if present, configures a limit on how many seats this priority level can borrow from other priority levels. The limit is known as this level's BorrowingConcurrencyLimit (BorrowingCL) and is a limit on the total number of seats that this level may borrow at any one time. This field holds the ratio of that limit to the level's nominal concurrency limit. When this field is non-nil, it must hold a non-negative integer and the limit is calculated as follows.<br><p> <br><p> BorrowingCL(i) = round( NominalCL(i) &#42; borrowingLimitPercent(i)/100.0 )<br><p> <br><p> The value of this field can be more than 100, implying that this priority level can borrow a number of seats that is greater than its own nominal concurrency limit (NominalCL). When this field is left `nil`, the limit is effectively infinite.
   */
  @JsonProperty("borrowingLimitPercent")
  private Number borrowingLimitPercent;

  /**
   * `lendablePercent` prescribes the fraction of the level's NominalCL that can be borrowed by other priority levels. The value of this field must be between 0 and 100, inclusive, and it defaults to 0. The number of seats that other levels can borrow from this level, known as this level's LendableConcurrencyLimit (LendableCL), is defined as follows.<br><p> <br><p> LendableCL(i) = round( NominalCL(i) &#42; lendablePercent(i)/100.0 )
   */
  @JsonProperty("lendablePercent")
  private Number lendablePercent;

  @JsonProperty("limitResponse")
  private LimitResponse limitResponse;

  /**
   * `nominalConcurrencyShares` (NCS) contributes to the computation of the NominalConcurrencyLimit (NominalCL) of this level. This is the number of execution seats available at this priority level. This is used both for requests dispatched from this priority level as well as requests dispatched from other priority levels borrowing seats from this level. The server's concurrency limit (ServerCL) is divided among the Limited priority levels in proportion to their NCS values:<br><p> <br><p> NominalCL(i)  = ceil( ServerCL &#42; NCS(i) / sum_ncs ) sum_ncs = sum[priority level k] NCS(k)<br><p> <br><p> Bigger numbers mean a larger nominal concurrency limit, at the expense of every other priority level.<br><p> <br><p> If not specified, this field defaults to a value of 30.<br><p> <br><p> Setting this field to zero supports the construction of a "jail" for this priority level that is used to hold some request(s)
   */
  @JsonProperty("nominalConcurrencyShares")
  private Number nominalConcurrencyShares;

}

