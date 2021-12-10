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
 *
 * Created on 2020-08-29, 8:59
 */
package com.marcnuri.yakc;


import com.marcnuri.yakc.ClusterExecutionCondition.ClusterVersion;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.events.v1.EventsV1Api;
import com.marcnuri.yakc.api.events.v1.EventsV1Api.ListNamespacedEvent;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import com.marcnuri.yakc.model.io.k8s.api.events.v1.Event;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(KubernetesClientExtension.class)
@ClusterVersion(minVersion = "1.19.0")
class EventsV1ApiIT {

  private static final String NAMESPACE = "default";

  private String eventName;
  private Event event;

  @BeforeEach
  void setUp() throws IOException {
    eventName = UUID.randomUUID().toString();
    event = createEventForTest();
  }

  @AfterEach
  void tearDown() throws IOException {
    deleteEventForTest();
  }

  @Test
  @DisplayName("getAPIResources, cluster contains resources for this API version")
  void getAPIResources() throws IOException {
    // When
    final APIResourceList result = KC.create(EventsV1Api.class).getAPIResources().get();
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("groupVersion","events.k8s.io/v1")
      .hasFieldOrPropertyWithValue("apiVersion", "v1")
      .extracting(APIResourceList::getResources).asList().isNotEmpty();
  }

  @Test
  @DisplayName("createNamespacedEvent, should create Event in default namespace")
  void createNamespacedEvent() {
    // Then
    assertThat(event)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", eventName)
      .hasFieldOrPropertyWithValue("metadata.namespace", NAMESPACE)
      .extracting("metadata.creationTimestamp").isNotNull();
  }

  @Test
  @DisplayName("listNamespacedEvent.stream, cluster contains events")
  void listNamespacedEventStream() throws IOException {
    // TODO: Use specific event because events from cluster may come with eventTime null :O -->
    // this throws a NPE
    // When
    final Stream<Event> result = KC.create(EventsV1Api.class).listNamespacedEvent(NAMESPACE,
      new ListNamespacedEvent().fieldSelector(String.format("metadata.name=%s", eventName))
    ).stream();
    // Then
    assertThat(result)
      .hasSize(1)
      .allSatisfy(e -> assertThat(e)
        .hasFieldOrPropertyWithValue("metadata.name", eventName)
        .hasFieldOrPropertyWithValue("action", "mock-action")
      );
  }

  @Test
  @DisplayName("readNamespacedEvent, should read existing Event with provided name")
  void readNamespacedEvent() throws IOException {
    // When
    final Event result = KC.create(EventsV1Api.class).readNamespacedEvent(eventName, NAMESPACE).get();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting("metadata")
      .hasFieldOrPropertyWithValue("name", eventName)
      .hasFieldOrPropertyWithValue("creationTimestamp", event.getMetadata().getCreationTimestamp());
  }

  @Test
  @DisplayName("patchNamespacedEvent, should patch reason of Event")
  void patchNamespacedEvent() throws IOException {
    // Given
    final Event patch = new Event();
    patch.setReason("Reason has been patched");
    // When
    final Event result = KC.create(EventsV1Api.class)
      .patchNamespacedEvent(eventName, NAMESPACE, patch).get();
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("reason", "Reason has been patched")
      .extracting("metadata.resourceVersion").asString()
      .isNotEmpty()
      .isNotEqualTo(event.getMetadata().getResourceVersion());
  }

  @Test
  @DisplayName("deleteNamespacedEvent, should delete existing Event")
  void deleteNamespacedEvent() throws IOException {
    // When
    final Status result = deleteEventForTest();
    // Then
    assertThat(result)
      .isNotNull()
      .extracting(Status::getStatus)
      .isEqualTo("Success");
  }

  Event createEventForTest() throws IOException {
    return KC.create(EventsV1Api.class).createNamespacedEvent(NAMESPACE, Event.builder()
      .metadata(ObjectMeta.builder()
        .name(eventName)
        .build())
      .action("mock-action")
      .type("Normal")
      .reason("This is the mock reason")
      .eventTime(OffsetDateTime.now())
      .reportingController("kubernetes.io/kubelet")
      .reportingInstance("mock-instance")
      .regarding(ObjectReference.builder()
        .namespace(NAMESPACE)
        .name("mock/object")
        .build())
      .build()
    ).get();
  }

  Status deleteEventForTest() throws IOException {
    try {
      return KC.create(EventsV1Api.class).deleteNamespacedEvent(eventName, NAMESPACE).get();
    } catch (NotFoundException ex) {
      // Ignore, this is only clean up. Resource may have been deleted by delete test
    }
    return null;
  }
}
