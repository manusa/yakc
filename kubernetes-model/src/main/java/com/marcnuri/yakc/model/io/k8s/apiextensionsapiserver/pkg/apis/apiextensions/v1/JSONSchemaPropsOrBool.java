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
 * Created on 2020-06-13, 17:28
 */
package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.serialization.ObjectOrBool;
import com.marcnuri.yakc.model.serialization.ObjectOrBoolDeserializer;
import com.marcnuri.yakc.model.serialization.ObjectOrBoolSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * JSONSchemaPropsOrBool represents JSONSchemaProps or a boolean value. Defaults to true for the boolean property.
 */
@SuppressWarnings({"squid:S1192", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@ToString
@JsonSerialize(using = ObjectOrBoolSerializer.class)
@JsonDeserialize(using = JSONSchemaPropsOrBool.Deserializer.class)
public class JSONSchemaPropsOrBool implements Model, ObjectOrBool<JSONSchemaProps> {

  private JSONSchemaProps object;
  @Accessors(fluent = true)
  private boolean bool;

  public static final class Deserializer extends ObjectOrBoolDeserializer<JSONSchemaProps, JSONSchemaPropsOrBool> {

    public Deserializer() {
      super(JSONSchemaProps.class);
    }

    @Override
    public JSONSchemaPropsOrBool instantiate(JSONSchemaProps object) {
      return JSONSchemaPropsOrBool.builder().object(object).build();
    }

    @Override
    public JSONSchemaPropsOrBool instantiate(boolean bool) {
      return JSONSchemaPropsOrBool.builder().bool(bool).build();
    }
  }
}
