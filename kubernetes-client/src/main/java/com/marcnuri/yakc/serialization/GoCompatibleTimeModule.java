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
 * Created on 2020-08-29, 11:04
 */
package com.marcnuri.yakc.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.NANO_OF_SECOND;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;

/**
 * Created by Marc Nuri on 2020-08-29.
 */
public class GoCompatibleTimeModule extends SimpleModule {
  private static final DateTimeFormatter ISO_LOCAL_TIME;
  static {
    ISO_LOCAL_TIME = new DateTimeFormatterBuilder()
      .appendValue(HOUR_OF_DAY, 2)
      .appendLiteral(':')
      .appendValue(MINUTE_OF_HOUR, 2)
      .optionalStart()
      .appendLiteral(':')
      .appendValue(SECOND_OF_MINUTE, 2)
      .optionalStart()
      // Go supports a max precision of 6 digits for nanoseconds -> 2006-01-02T15:04:05.000000Z07:00
      .appendFraction(NANO_OF_SECOND, 6, 6, true)
      .toFormatter();
  }
  private static final DateTimeFormatter ISO_OFFSET_DATE_TIME;
  static {
    ISO_OFFSET_DATE_TIME = new DateTimeFormatterBuilder()
      .parseCaseInsensitive()
      .append(ISO_LOCAL_DATE)
      .appendLiteral('T')
      .append(ISO_LOCAL_TIME)
      .parseLenient()
      .appendOffsetId()
      .parseStrict()
      .toFormatter();
  }

  public GoCompatibleTimeModule() {
    addSerializer(OffsetDateTime.class, new JsonSerializer<OffsetDateTime>() {
      @Override
      public void serialize(OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException  {
        jsonGenerator.writeString(ISO_OFFSET_DATE_TIME.format(offsetDateTime));
      }
    });
  }
}
