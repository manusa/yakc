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

package com.marcnuri.yakc.model.io.openshift.console.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ConsoleLinkSpec is the desired console link configuration.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsoleLinkSpec implements Model {


  @JsonProperty("applicationMenu")
  private ConsoleLinkSpecApplicationMenu applicationMenu;

  /**
   * href is the absolute secure URL for the link (must use https)
   */
  @NonNull
  @JsonProperty("href")
  private String href;

  /**
   * location determines which location in the console the link will be appended to (ApplicationMenu, HelpMenu, UserMenu, NamespaceDashboard).
   */
  @NonNull
  @JsonProperty("location")
  private String location;

  @JsonProperty("namespaceDashboard")
  private ConsoleLinkSpecNamespaceDashboard namespaceDashboard;

  /**
   * text is the display text for the link
   */
  @NonNull
  @JsonProperty("text")
  private String text;

}

