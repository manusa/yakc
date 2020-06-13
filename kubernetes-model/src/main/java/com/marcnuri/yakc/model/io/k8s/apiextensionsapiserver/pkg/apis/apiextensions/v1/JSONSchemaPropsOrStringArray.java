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
 * Created on 2020-06-13, 9:24
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
 * JSONSchemaPropsOrStringArray represents a JSONSchemaProps or a string array.
 */
@SuppressWarnings({"squid:S1192", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@ToString
@JsonSerialize(using = ObjectOrArraySerializer.class)
@JsonDeserialize(using = JSONSchemaPropsOrStringArray.Deserializer.class)
public class JSONSchemaPropsOrStringArray implements Model, ObjectOrArray<JSONSchemaProps, String> {

  private JSONSchemaProps object;
  @Singular
  private List<String> strings;

  @Override
  public List<String> getArray() {
    return getStrings();
  }

  public static final class Deserializer extends
    ObjectOrArrayDeserializer<JSONSchemaProps, String, JSONSchemaPropsOrStringArray> {

    public Deserializer() {
      super(JSONSchemaProps.class, String.class);
    }

    @Override
    public JSONSchemaPropsOrStringArray instantiate(List<String> deserializedItems) {
      return JSONSchemaPropsOrStringArray.builder().strings(deserializedItems).build();
    }

    @Override
    public JSONSchemaPropsOrStringArray instantiate(JSONSchemaProps object) {
      return JSONSchemaPropsOrStringArray.builder().object(object).build();
    }
  }
}
