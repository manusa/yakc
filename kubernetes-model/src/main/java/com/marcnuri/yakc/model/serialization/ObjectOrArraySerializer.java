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
 * Created on 2020-06-13, 7:56
 */
package com.marcnuri.yakc.model.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * Created by Marc Nuri on 2020-06-13.
 */
public class ObjectOrArraySerializer<T, L, D extends ObjectOrArray<T, L>> extends JsonSerializer<D> {

  @Override
  public final void serialize(D value, JsonGenerator gen,
    SerializerProvider serializers) throws IOException {
    if (value.getArray() != null && !value.getArray().isEmpty() && value.getObject() != null) {
      throw new IllegalArgumentException("Invalid object, only one of array or object is allowed");
    }
    if (value.getObject() != null) {
      gen.writeObject(value.getObject());
    } else {
      gen.writeObject(value.getArray());
    }
  }
}