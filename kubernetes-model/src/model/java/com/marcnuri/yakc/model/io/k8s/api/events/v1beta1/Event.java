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

package com.marcnuri.yakc.model.io.k8s.api.events.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.EventSource;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Event implements Model {


  /**
   * What action was taken/failed regarding to the regarding object.
   */
  @JsonProperty("action")
  private String action;

  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * Deprecated field assuring backward compatibility with core.v1 Event type
   */
  @JsonProperty("deprecatedCount")
  private Integer deprecatedCount;

  @JsonProperty("deprecatedFirstTimestamp")
  private OffsetDateTime deprecatedFirstTimestamp;

  @JsonProperty("deprecatedLastTimestamp")
  private OffsetDateTime deprecatedLastTimestamp;

  @JsonProperty("deprecatedSource")
  private EventSource deprecatedSource;

  @NonNull
  @JsonProperty("eventTime")
  private OffsetDateTime eventTime;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  /**
   * Optional. A human-readable description of the status of this operation. Maximal length of the note is 1kB, but libraries should be prepared to handle values up to 64kB.
   */
  @JsonProperty("note")
  private String note;

  /**
   * Why the action was taken.
   */
  @JsonProperty("reason")
  private String reason;

  @JsonProperty("regarding")
  private ObjectReference regarding;

  @JsonProperty("related")
  private ObjectReference related;

  /**
   * Name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`.
   */
  @JsonProperty("reportingController")
  private String reportingController;

  /**
   * ID of the controller instance, e.g. `kubelet-xyzf`.
   */
  @JsonProperty("reportingInstance")
  private String reportingInstance;

  @JsonProperty("series")
  private EventSeries series;

  /**
   * Type of this event (Normal, Warning), new types could be added in the future.
   */
  @JsonProperty("type")
  private String type;

}

