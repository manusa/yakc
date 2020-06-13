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
 * Created on 2020-06-13, 17:34
 */
package com.marcnuri.yakc.model.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Marc Nuri on 2020-06-13.
 */
public abstract class ObjectOrBoolDeserializer<O, T extends ObjectOrBool<O>> extends JsonDeserializer<T> {

  private final Class<O> objectClazz;

  public ObjectOrBoolDeserializer(Class<O> objectClazz) {
    this.objectClazz = objectClazz;
  }

  public abstract T instantiate(O object);
  public abstract T instantiate(boolean bool);

  @Override
  public final T deserialize(
    JsonParser p, DeserializationContext ctxt) throws IOException {
    if (p.isExpectedStartObjectToken()) {
      return instantiate(ctxt.readValue(p, objectClazz));
    } else {
      return instantiate(ctxt.readValue(p, Boolean.class));
    }
  }
}