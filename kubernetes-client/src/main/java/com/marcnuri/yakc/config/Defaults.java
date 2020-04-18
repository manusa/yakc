/*
 * Defaults.java
 *
 * Created on 2020-04-13, 17:53
 */
package com.marcnuri.yakc.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Optional;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-13.
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
