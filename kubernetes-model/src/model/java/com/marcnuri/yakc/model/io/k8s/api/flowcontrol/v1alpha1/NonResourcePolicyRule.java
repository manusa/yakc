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

package com.marcnuri.yakc.model.io.k8s.api.flowcontrol.v1alpha1;

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
 * NonResourcePolicyRule is a predicate that matches non-resource requests according to their verb and the target non-resource URL. A NonResourcePolicyRule matches a request if and only if both (a) at least one member of verbs matches the request and (b) at least one member of nonResourceURLs matches the request.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NonResourcePolicyRule implements Model {


  /**
   * `nonResourceURLs` is a set of url prefixes that a user should have access to and may not be empty. For example:<br><p>   - "/healthz" is legal<br><p>   - "/hea&#42;" is illegal<br><p>   - "/hea" is legal but matches nothing<br><p>   - "/hea/&#42;" also matches nothing<br><p>   - "/healthz/&#42;" matches all per-component health checks.<br><p> "&#42;" matches all non-resource urls. if it is present, it must be the only entry. Required.
   */
  @NonNull
  @JsonProperty("nonResourceURLs")
  @Singular(value = "addToNonResourceURLs", ignoreNullCollections = true)
  private List<String> nonResourceURLs;

  /**
   * `verbs` is a list of matching verbs and may not be empty. "&#42;" matches all verbs. If it is present, it must be the only entry. Required.
   */
  @NonNull
  @JsonProperty("verbs")
  @Singular(value = "addToVerbs", ignoreNullCollections = true)
  private List<String> verbs;

}

