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
 * applicationMenu holds information about section and icon used for the link in the application menu, and it is applicable only when location is set to ApplicationMenu.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsoleLinkSpecApplicationMenu implements Model {


  /**
   * imageUrl is the URL for the icon used in front of the link in the application menu. The URL must be an HTTPS URL or a Data URI. The image should be square and will be shown at 24x24 pixels.
   */
  @JsonProperty("imageURL")
  private String imageURL;

  /**
   * section is the section of the application menu in which the link should appear. This can be any text that will appear as a subheading in the application menu dropdown. A new section will be created if the text does not match text of an existing section.
   */
  @NonNull
  @JsonProperty("section")
  private String section;

}

