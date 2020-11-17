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
 * ConsoleExternalLogLinkSpec is the desired log link configuration. The log link will appear on the logs tab of the pod details page.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConsoleExternalLogLinkSpec implements Model {


  /**
   * hrefTemplate is an absolute secure URL (must use https) for the log link including variables to be replaced. Variables are specified in the URL with the format ${variableName}, for instance, ${containerName} and will be replaced with the corresponding values from the resource. Resource is a pod. Supported variables are: - ${resourceName} - name of the resource which containes the logs - ${resourceUID} - UID of the resource which contains the logs               - e.g. `11111111-2222-3333-4444-555555555555` - ${containerName} - name of the resource's container that contains the logs - ${resourceNamespace} - namespace of the resource that contains the logs - ${resourceNamespaceUID} - namespace UID of the resource that contains the logs - ${podLabels} - JSON representation of labels matching the pod with the logs             - e.g. `{"key1":"value1","key2":"value2"}` <br><p>  e.g., https://example.com/logs?resourceName=${resourceName}&amp;containerName=${containerName}&amp;resourceNamespace=${resourceNamespace}&amp;podLabels=${podLabels}
   */
  @NonNull
  @JsonProperty("hrefTemplate")
  private String hrefTemplate;

  /**
   * namespaceFilter is a regular expression used to restrict a log link to a matching set of namespaces (e.g., `^openshift-`). The string is converted into a regular expression using the JavaScript RegExp constructor. If not specified, links will be displayed for all the namespaces.
   */
  @JsonProperty("namespaceFilter")
  private String namespaceFilter;

  /**
   * text is the display text for the link
   */
  @NonNull
  @JsonProperty("text")
  private String text;

}

