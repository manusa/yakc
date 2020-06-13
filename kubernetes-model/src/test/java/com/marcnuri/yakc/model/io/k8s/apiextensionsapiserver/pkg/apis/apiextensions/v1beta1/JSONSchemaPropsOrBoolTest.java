/*
 * JSONSchemaPropsOrStringArrayTest.java
 *
 * Created on 2020-06-13, 17:45
 */
package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1beta1;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
class JSONSchemaPropsOrBoolTest {

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
    final JSONSchemaPropsOrBool input = JSONSchemaPropsOrBool.builder()
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
  @DisplayName("serializer, with bool, should serialize as boolean")
  void serializerWithBool() throws IOException {
    // Given
    final JSONSchemaPropsOrBool input = JSONSchemaPropsOrBool.builder()
      .bool(false)
      .build();
    // When
    final String result = mapper.writeValueAsString(input);
    // Then
    assertThat(result).isEqualTo("false");
  }

  @Test
  @DisplayName("serializer, with object and bool, should serialize as an object")
  void serializerWithObjectAndBool() throws IOException {
    // Given
    final JSONSchemaPropsOrBool input = JSONSchemaPropsOrBool.builder()
      .object(JSONSchemaProps.builder().type("integer").build())
      .bool(true)
      .build();
    // When
    final String result = mapper.writeValueAsString(input);
    // Then
    assertThat(result).isEqualTo("{\"type\":\"integer\"}");
  }

  @Test
  @DisplayName("deserializer, with object, should deserialize an object into the object")
  void deserializerWithObject() throws IOException {
    // When
    final JSONSchemaPropsOrBool result = mapper.readValue("{\"type\":\"string\"}", JSONSchemaPropsOrBool.class);
    // Then
    assertAll("Should return an instance with an object",
      () -> assertThat(result.bool()).isFalse(),
      () -> assertThat(result.getObject().getType()).isEqualTo("string")
    );
  }

  @Test
  @DisplayName("deserializer, with boolean, should deserialize a bool")
  void deserializerWithBool() throws IOException {
    // When
    final JSONSchemaPropsOrBool result = mapper.readValue("true", JSONSchemaPropsOrBool.class);
    // Then
    assertAll("Should return an instance with a list of strings",
      () -> assertThat(result.getObject()).isNull(),
      () -> assertThat(result.bool()).isTrue()
    );
  }
}
