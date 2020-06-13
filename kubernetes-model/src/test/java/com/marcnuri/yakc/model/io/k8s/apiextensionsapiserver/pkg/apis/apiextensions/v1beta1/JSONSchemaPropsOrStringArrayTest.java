/*
 * JSONSchemaPropsOrStringArrayTest.java
 *
 * Created on 2020-06-13, 10:13
 */
package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1beta1;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Marc Nuri on 2020-06-13.
 */
class JSONSchemaPropsOrStringArrayTest {

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
  @DisplayName("serializer, with object, should serialize as an object")
  void serializerWithObject() throws IOException {
    // Given
    final JSONSchemaPropsOrStringArray input = JSONSchemaPropsOrStringArray.builder()
      .object(JSONSchemaProps.builder()
        .type("string")
        .build())
      .build();
    // When
    final String result = mapper.writeValueAsString(input);
    // Then
    assertThat(result).isEqualTo("{\"type\":\"string\"}");
  }

  @Test
  @DisplayName("serializer, with strings, should serialize as an array of strings")
  void serializerWithStrings() throws IOException {
    // Given
    final JSONSchemaPropsOrStringArray input = JSONSchemaPropsOrStringArray.builder()
      .string("one")
      .string("two")
      .build();
    // When
    final String result = mapper.writeValueAsString(input);
    // Then
    assertThat(result).isEqualTo("[\"one\",\"two\"]");
  }

  @Test
  @DisplayName("serializer, with object and strings, should throw exception")
  void serializerWithObjectAndStrings() {
    // Given
    final JSONSchemaPropsOrStringArray input = JSONSchemaPropsOrStringArray.builder()
      .object(JSONSchemaProps.builder().type("integer").build())
      .string("one")
      .string("two")
      .build();
    // When - Then
    final JsonMappingException result = assertThrows(
      JsonMappingException.class,
      () -> mapper.writeValueAsString(input)
    );
    assertAll(
      "Should be caused by IllegalArgumentException",
      () -> assertThat(result.getCause()).isInstanceOf(IllegalArgumentException.class),
      () -> assertThat(result.getCause().getMessage()).isEqualTo("Invalid object, only one of array or object is allowed")
    );
  }

  @Test
  @DisplayName("deserializer, with object, should deserialize an object into the object")
  void deserializerWithObject() throws IOException {
    // When
    final JSONSchemaPropsOrStringArray result = mapper.readValue("{\"type\":\"string\"}", JSONSchemaPropsOrStringArray.class);
    // Then
    assertAll("Should return an instance with an object",
      () -> assertThat(result.getStrings()).isEmpty(),
      () -> assertThat(result.getObject().getType()).isEqualTo("string")
    );
  }

  @Test
  @DisplayName("deserializer, with array, should deserialize a list of strings")
  void deserializerWithMultipleItems() throws IOException {
    // When
    final JSONSchemaPropsOrStringArray result = mapper.readValue("[\"one\",\"two\"]", JSONSchemaPropsOrStringArray.class);
    // Then
    final Condition<String> isOne = new Condition<>(t -> t.equals("one"), "is one");
    final Condition<String> isTwo = new Condition<>(t -> t.equals("two"), "is two");
    assertAll("Should return an instance with a list of strings",
      () -> assertThat(result.getObject()).isNull(),
      () -> assertThat(result.getStrings().size()).isEqualTo(2),
      () -> assertThat(result.getStrings()).haveExactly(1, isOne),
      () -> assertThat(result.getStrings()).haveExactly(1, isTwo)
    );
  }
}
