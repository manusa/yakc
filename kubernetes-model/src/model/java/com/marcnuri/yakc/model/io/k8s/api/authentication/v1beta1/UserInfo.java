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

package com.marcnuri.yakc.model.io.k8s.api.authentication.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * UserInfo holds the information about the user needed to implement the user.Info interface.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserInfo implements Model {


  /**
   * Any additional information provided by the authenticator.
   */
  @JsonProperty("extra")
  @Singular(value = "putInExtra", ignoreNullCollections = true)
  private Map<String, List<String>> extra;

  /**
   * The names of groups this user is a part of.
   */
  @JsonProperty("groups")
  @Singular(value = "addToGroups", ignoreNullCollections = true)
  private List<String> groups;

  /**
   * A unique value that identifies this user across time. If this user is deleted and another user by the same name is added, they will have different UIDs.
   */
  @JsonProperty("uid")
  private String uid;

  /**
   * The name that uniquely identifies this user among all active users.
   */
  @JsonProperty("username")
  private String username;

}

