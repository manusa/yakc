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

package com.marcnuri.yakc.model.dev.knative.messaging.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Reference to a channel that will be used to create the subscription You can specify only the following fields of the ObjectReference: - Kind - APIVersion - Name The resource pointed by this ObjectReference must meet the contract to the ChannelableSpec duck type. If the resource does not meet this contract it will be reflected in the Subscription's status.  This field is immutable. We have no good answer on what happens to the events that are currently in the channel being consumed from and what the semantics there should be. For now, you can always delete the Subscription and recreate it to point to a different channel, giving the user more control over what semantics should be used (drain the channel first, possibly have events dropped, etc.)
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SubscriptionSpecChannel implements Model {


  /**
   * API version of the referent.
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * If referring to a piece of an object instead of an entire object, this string should contain a valid JSON/Go field access statement, such as desiredState.manifest.containers[2]. For example, if the object reference is to a container within a pod, this would take on a value like: "spec.containers{name}" (where "name" refers to the name of the container that triggered the event) or if no container name is specified "spec.containers[2]" (container with index 2 in this pod). This syntax is chosen only to have some well-defined way of referencing a part of an object.
   */
  @JsonProperty("fieldPath")
  private String fieldPath;

  /**
   * Kind of the referent. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  /**
   * Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
   */
  @JsonProperty("name")
  private String name;

  /**
   * Namespace of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/namespaces/
   */
  @JsonProperty("namespace")
  private String namespace;

  /**
   * Specific resourceVersion to which this reference is made, if any. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#concurrency-control-and-consistency
   */
  @JsonProperty("resourceVersion")
  private String resourceVersion;

  /**
   * UID of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#uids
   */
  @JsonProperty("uid")
  private String uid;

}

