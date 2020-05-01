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
 * Created on 2020-05-01, 7:21
 */
package com.marcnuri.yakc.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * Created by Marc Nuri on 2020-05-01.
 */
@SuppressWarnings("JavaDoc")
@Builder
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ExecMessage {
  @AllArgsConstructor
  @Getter
  public enum StandardStream {
    STDIN(0), STDOUT(1), STDERR(2);
    private final int standardStream;
    public static StandardStream fromByte(int byteCode) {
      return Stream.of(values()).filter(ss -> ss.getStandardStream() == byteCode).findFirst()
        .orElse(STDOUT);
    }
  }

  /**
   * Standard Stream where the message was received.
   * @return StandardStream where the message was received.
   */
  private final StandardStream standardStream;
  /**
   * Message received.
   * @return the received message.
   */
  private final String message;

  @Override
  public String toString() {
    return message;
  }
}
