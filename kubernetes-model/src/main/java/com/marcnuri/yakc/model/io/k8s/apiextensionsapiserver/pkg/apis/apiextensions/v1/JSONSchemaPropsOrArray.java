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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.serialization.ObjectOrArray;
import com.marcnuri.yakc.model.serialization.ObjectOrArrayDeserializer;
import com.marcnuri.yakc.model.serialization.ObjectOrArraySerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;

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
@JsonSerialize(using = ObjectOrArraySerializer.class)
@JsonDeserialize(using = JSONSchemaPropsOrArray.Deserializer.class)
public class JSONSchemaPropsOrArray implements Model, ObjectOrArray<JSONSchemaProps, JSONSchemaProps> {

  @Singular
  private List<JSONSchemaProps> jsonSchemaProps;

  @Override
  public JSONSchemaProps getObject() {
    return getJsonSchemaProps().size() == 1 ? getJsonSchemaProps().iterator().next() : null;
  }

  @Override
  public List<JSONSchemaProps> getArray() {
    return getJsonSchemaProps().size() == 1 ? null : getJsonSchemaProps();
  }

  public static final class Deserializer extends
    ObjectOrArrayDeserializer<JSONSchemaProps, JSONSchemaProps, JSONSchemaPropsOrArray> {

    public Deserializer() {
      super(JSONSchemaProps.class, JSONSchemaProps.class);
    }

    @Override
    public JSONSchemaPropsOrArray instantiate(List<JSONSchemaProps> deserializedItems) {
      return JSONSchemaPropsOrArray.builder().jsonSchemaProps(deserializedItems).build();
    }

    @Override
    public JSONSchemaPropsOrArray instantiate(JSONSchemaProps object) {
      return JSONSchemaPropsOrArray.builder().jsonSchemaProp(object).build();
    }
  }
}

