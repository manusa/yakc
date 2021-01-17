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

package com.marcnuri.yakc.model.dev.knative.sources.v1beta2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.dev.knative.sources.v1.ApiServerSourceSpecSink;
import com.marcnuri.yakc.model.dev.knative.sources.v1alpha2.PingSourceSpecCeOverrides;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * PingSourceSpec defines the desired state of the PingSource (from the client).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PingSourceSpec implements Model {


  @JsonProperty("ceOverrides")
  private PingSourceSpecCeOverrides ceOverrides;

  /**
   * ContentType is the media type of `data` or `dataBase64`. Default is empty.
   */
  @JsonProperty("contentType")
  private String contentType;

  /**
   * Data is data used as the body of the event posted to the sink. Default is empty. Mutually exclusive with `dataBase64`.
   */
  @JsonProperty("data")
  private String data;

  /**
   * DataBase64 is base64 encoded binary data used as the body of the event posted to the sink. Default is empty. Mutually exclusive with `data`.
   */
  @JsonProperty("dataBase64")
  private String dataBase64;

  /**
   * Schedule is the cron schedule. Defaults to `&#42; &#42; &#42; &#42; &#42;`.
   */
  @JsonProperty("schedule")
  private String schedule;

  @JsonProperty("sink")
  private ApiServerSourceSpecSink sink;

  /**
   * Timezone modifies the actual time relative to the specified timezone. Defaults to the system time zone. More general information about time zones: https://www.iana.org/time-zones List of valid timezone values: https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
   */
  @JsonProperty("timezone")
  private String timezone;

}

