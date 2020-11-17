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
 * ConsoleNotificationSpec is the desired console notification configuration.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsoleNotificationSpec implements Model {


  /**
   * backgroundColor is the color of the background for the notification as CSS data type color.
   */
  @JsonProperty("backgroundColor")
  private String backgroundColor;

  /**
   * color is the color of the text for the notification as CSS data type color.
   */
  @JsonProperty("color")
  private String color;

  @JsonProperty("link")
  private ConsoleNotificationSpecLink link;

  /**
   * location is the location of the notification in the console.
   */
  @JsonProperty("location")
  private String location;

  /**
   * text is the visible text of the notification.
   */
  @NonNull
  @JsonProperty("text")
  private String text;

}

