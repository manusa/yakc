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

package com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.version;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Info contains versioning information. how we'll want to distribute that information.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Info implements Model {


  @NonNull
  @JsonProperty("buildDate")
  private String buildDate;

  @NonNull
  @JsonProperty("compiler")
  private String compiler;

  @NonNull
  @JsonProperty("gitCommit")
  private String gitCommit;

  @NonNull
  @JsonProperty("gitTreeState")
  private String gitTreeState;

  @NonNull
  @JsonProperty("gitVersion")
  private String gitVersion;

  @NonNull
  @JsonProperty("goVersion")
  private String goVersion;

  @NonNull
  @JsonProperty("major")
  private String major;

  @NonNull
  @JsonProperty("minor")
  private String minor;

  @NonNull
  @JsonProperty("platform")
  private String platform;

}

