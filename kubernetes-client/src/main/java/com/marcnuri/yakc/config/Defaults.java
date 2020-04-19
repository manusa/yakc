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
 * Created on 2020-04-13, 17:53
 */
package com.marcnuri.yakc.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Optional;

/**
 * Created by Marc Nuri on 2020-04-13.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Defaults {

  private static final Duration CONNECT_TIMEOUT = Duration.ofSeconds(10L);
  private static final Duration READ_TIMEOUT = Duration.ofSeconds(60L);

  static Duration getConnectTimeout(Configuration configuration) {
    return Optional.ofNullable(configuration.getConnectTimeout()).orElse(CONNECT_TIMEOUT);
  }

  static Duration getReadTimeout(Configuration configuration) {
    return Optional.ofNullable(configuration.getReadTimeout()).orElse(READ_TIMEOUT);
  }
}
