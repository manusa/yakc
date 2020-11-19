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

package com.marcnuri.yakc.model.dev.knative.eventing.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Spec defines the desired state of the EventType.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EventTypeSpec implements Model {


  @JsonProperty("broker")
  private String broker;

  /**
   * Description is an optional field used to describe the EventType, in any meaningful way.
   */
  @JsonProperty("description")
  private String description;

  /**
   * Schema is a URI, it represents the CloudEvents schemaurl extension attribute. It may be a JSON schema, a protobuf schema, etc. It is optional.
   */
  @JsonProperty("schema")
  private String schema;

  /**
   * SchemaData allows the CloudEvents schema to be stored directly in the EventType. Content is dependent on the encoding. Optional attribute. The contents are not validated or manipulated by the system.
   */
  @JsonProperty("schemaData")
  private String schemaData;

  /**
   * Source is a URI, it represents the CloudEvents source.
   */
  @JsonProperty("source")
  private String source;

  /**
   * Type represents the CloudEvents type. It is authoritative.
   */
  @JsonProperty("type")
  private String type;

}

