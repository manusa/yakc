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

package com.marcnuri.yakc.model.dev.knative.sources.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ContainerSourceSpecTemplateManagedFields implements Model {


  /**
   * APIVersion defines the version of this resource that this field set applies to. The format is "group/version" just like the top-level APIVersion field. It is necessary to track the version of a field set because it cannot be automatically converted.
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * FieldsType is the discriminator for the different fields format and version. There is currently only one possible value: "FieldsV1"
   */
  @JsonProperty("fieldsType")
  private String fieldsType;

  /**
   * FieldsV1 holds the first JSON version format as described in the "FieldsV1" type.
   */
  @JsonProperty("fieldsV1")
  private String fieldsV1;

  /**
   * Manager is an identifier of the workflow managing these fields.
   */
  @JsonProperty("manager")
  private String manager;

  /**
   * Operation is the type of operation which lead to this ManagedFieldsEntry being created. The only valid values for this field are "Apply" and "Update".
   */
  @JsonProperty("operation")
  private String operation;

  /**
   * Time is timestamp of when these fields were set. It should always be empty if Operation is "Apply"
   */
  @JsonProperty("time")
  private String time;

}

