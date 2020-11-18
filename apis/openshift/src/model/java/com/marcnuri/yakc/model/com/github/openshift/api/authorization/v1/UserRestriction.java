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

package com.marcnuri.yakc.model.com.github.openshift.api.authorization.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.LabelSelector;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * UserRestriction matches a user either by a string match on the user name, a string match on the name of a group to which the user belongs, or a label selector applied to the user labels.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserRestriction implements Model {


  /**
   * Groups specifies a list of literal group names.
   */
  @NonNull
  @JsonProperty("groups")
  @Singular(value = "addToGroups", ignoreNullCollections = true)
  private List<String> groups;

  /**
   * Selectors specifies a list of label selectors over user labels.
   */
  @NonNull
  @JsonProperty("labels")
  @Singular(value = "addToLabels", ignoreNullCollections = true)
  private List<LabelSelector> labels;

  /**
   * Users specifies a list of literal user names.
   */
  @NonNull
  @JsonProperty("users")
  @Singular(value = "addToUsers", ignoreNullCollections = true)
  private List<String> users;

}

