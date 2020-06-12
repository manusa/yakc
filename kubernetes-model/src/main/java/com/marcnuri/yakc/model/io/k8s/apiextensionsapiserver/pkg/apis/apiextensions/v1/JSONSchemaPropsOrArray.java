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
 * Created on 2020-06-12, 8:30
 */
package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * JSONSchemaPropsOrArray represents a value that can either be a JSONSchemaProps or an array of JSONSchemaProps.
 * Mainly here for serialization purposes.
 */
@SuppressWarnings({"squid:S1192", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@ToString
@JsonSerialize(using = JSONSchemaPropsOrArray.Serializer.class)
@JsonDeserialize(using = JSONSchemaPropsOrArray.Deserializer.class)
public class JSONSchemaPropsOrArray implements Model {

  @Singular
  private List<JSONSchemaProps> jsonSchemaProps;

  public static final class Deserializer extends JsonDeserializer<JSONSchemaPropsOrArray> {

    @Override
    public JSONSchemaPropsOrArray deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      final List<JSONSchemaProps> ret;
      if (p.isExpectedStartArrayToken()) {
        ret = ctxt.readValue(p,
          ctxt.getTypeFactory().constructCollectionType(List.class, JSONSchemaProps.class));
      } else {
        ret = Collections.singletonList(ctxt.readValue(p, JSONSchemaProps.class));
      }
      return JSONSchemaPropsOrArray.builder().jsonSchemaProps(ret).build();
    }
  }

  public static final class Serializer extends JsonSerializer<JSONSchemaPropsOrArray> {

    @Override
    public void serialize(JSONSchemaPropsOrArray value, JsonGenerator gen,
      SerializerProvider serializers) throws IOException {
      if (value.getJsonSchemaProps().size() == 1) {
        gen.writeObject(value.getJsonSchemaProps().iterator().next());
      } else {
        gen.writeObject(value.getJsonSchemaProps());
      }
    }
  }
}

