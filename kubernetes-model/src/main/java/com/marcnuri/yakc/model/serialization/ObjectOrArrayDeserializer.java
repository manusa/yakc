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
 * Created on 2020-06-13, 8:08
 */
package com.marcnuri.yakc.model.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marc Nuri on 2020-06-13.
 */
public abstract class ObjectOrArrayDeserializer<T, L extends ObjectOrArray<T>> extends JsonDeserializer<L> {

  private final Class<T> targetClazz;

  public ObjectOrArrayDeserializer(Class<T> targetClazz) {
    this.targetClazz = targetClazz;
  }

  public abstract L instantiate(List<T> deserializedItems);

  @Override
  public final L deserialize(
    JsonParser p, DeserializationContext ctxt) throws IOException {
    final List<T> ret;
    if (p.isExpectedStartArrayToken()) {
      ret = ctxt.readValue(p,
        ctxt.getTypeFactory().constructCollectionType(List.class, targetClazz));
    } else {
      ret = Collections.singletonList(ctxt.readValue(p, targetClazz));
    }
    return instantiate(ret);
  }
}