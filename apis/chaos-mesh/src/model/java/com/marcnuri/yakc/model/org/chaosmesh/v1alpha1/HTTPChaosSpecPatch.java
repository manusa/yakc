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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

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
 * Patch is a rule to patch some contents in target.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HTTPChaosSpecPatch implements Model {


  @JsonProperty("body")
  private HTTPChaosSpecPatchBody body;

  /**
   * Headers is a rule to append http headers of target. For example: `[["Set-Cookie", "&lt;one cookie&gt;"], ["Set-Cookie", "&lt;another cookie&gt;"]]`.
   */
  @JsonProperty("headers")
  @Singular(value = "addToHeaders", ignoreNullCollections = true)
  private List<List<String>> headers;

  /**
   * Queries is a rule to append uri queries of target(Request only). For example: `[["foo", "bar"], ["foo", "unknown"]]`.
   */
  @JsonProperty("queries")
  @Singular(value = "addToQueries", ignoreNullCollections = true)
  private List<List<String>> queries;

}

