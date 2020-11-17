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

package com.marcnuri.yakc.model.io.openshift.operator.ingress.v1;

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
 * spec is the specification of the desired behavior of the dnsecord.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DNSRecordSpec implements Model {


  /**
   * dnsName is the hostname of the DNS record
   */
  @NonNull
  @JsonProperty("dnsName")
  private String dnsName;

  /**
   * recordTTL is the record TTL in seconds. If zero, the default is 30.
   */
  @NonNull
  @JsonProperty("recordTTL")
  private Number recordTTL;

  /**
   * recordType is the DNS record type. For example, "A" or "CNAME".
   */
  @NonNull
  @JsonProperty("recordType")
  private String recordType;

  /**
   * targets are record targets.
   */
  @NonNull
  @JsonProperty("targets")
  @Singular(value = "addToTargets", ignoreNullCollections = true)
  private List<String> targets;

}

