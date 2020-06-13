/*
 * JSONSchemaPropsOrArrayTest.java
 *
 * Created on 2020-06-13, 08:31
 */
package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1beta1;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Created by Marc Nuri on 2020-06-13.
 */
class JSONSchemaPropsOrArrayTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.setSerializationInclusion(Include.NON_EMPTY);
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
  }

  @AfterEach
  void tearDown() {
    mapper = null;
  }

  @Test
  @DisplayName("serializer, with single item, should serialize as an object")
  void serializerWithSingleItem() throws IOException {
    // Given
    final JSONSchemaPropsOrArray input = JSONSchemaPropsOrArray.builder()
      .jsonSchemaProp(JSONSchemaProps.builder()
        .type("string")
        .build())
      .build();
    // When
    final String result = mapper.writeValueAsString(input);
    // Then
    assertThat(result).isEqualTo("{\"type\":\"string\"}");
  }

  @Test
  @DisplayName("serializer, with multiple item, should serialize as an array")
  void serializerWithMultipleItems() throws IOException {
    // Given
    final JSONSchemaPropsOrArray input = JSONSchemaPropsOrArray.builder()
      .jsonSchemaProp(JSONSchemaProps.builder()
        .type("string")
        .build())
      .jsonSchemaProp(JSONSchemaProps.builder()
        .type("integer")
        .build())
      .build();
    // When
    final String result = mapper.writeValueAsString(input);
    // Then
    assertThat(result).isEqualTo("[{\"type\":\"string\"},{\"type\":\"integer\"}]");
  }

  @Test
  @DisplayName("deserializer, with single item, should deserialize an object into the list")
  void deserializerWithSingleItem() throws IOException {
    // When
    final JSONSchemaPropsOrArray result = mapper.readValue("{\"type\":\"string\"}", JSONSchemaPropsOrArray.class);
    // Then
    assertAll("Should return a singletonList",
      () -> assertThat(result.getJsonSchemaProps().size()).isEqualTo(1),
      () -> assertThat(result.getJsonSchemaProps().iterator().next().getType()).isEqualTo("string")
    );
  }
  @Test
  @DisplayName("deserializer, with multiple items, should deserializer the list")
  void deserializerWithMultipleItems() throws IOException {
    // When
    final JSONSchemaPropsOrArray result = mapper.readValue("[{\"type\":\"string\"},{\"type\":\"integer\"}]", JSONSchemaPropsOrArray.class);
    // Then
    final Condition<JSONSchemaProps> isString = new Condition<>(t -> t.getType().equals("string"), "is string");
    final Condition<JSONSchemaProps> isInteger = new Condition<>(t -> t.getType().equals("integer"), "is integer");
    assertAll("Should return a singletonList",
      () -> assertThat(result.getJsonSchemaProps().size()).isEqualTo(2),
      () -> assertThat(result.getJsonSchemaProps()).haveExactly(1, isString),
      () -> assertThat(result.getJsonSchemaProps()).haveExactly(1, isInteger)
    );
  }
}
