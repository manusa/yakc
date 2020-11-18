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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * customization is used to optionally provide a small set of customization options to the web console.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsoleSpecCustomization implements Model {


  /**
   * brand is the default branding of the web console which can be overridden by providing the brand field.  There is a limited set of specific brand options. This field controls elements of the console such as the logo. Invalid value will prevent a console rollout.
   */
  @JsonProperty("brand")
  private String brand;

  @JsonProperty("customLogoFile")
  private ConsoleSpecCustomizationCustomLogoFile customLogoFile;

  /**
   * customProductName is the name that will be displayed in page titles, logo alt text, and the about dialog instead of the normal OpenShift product name.
   */
  @JsonProperty("customProductName")
  private String customProductName;

  /**
   * documentationBaseURL links to external documentation are shown in various sections of the web console.  Providing documentationBaseURL will override the default documentation URL. Invalid value will prevent a console rollout.
   */
  @JsonProperty("documentationBaseURL")
  private String documentationBaseURL;

}

