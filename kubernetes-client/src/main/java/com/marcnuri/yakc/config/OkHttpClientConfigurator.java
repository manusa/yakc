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
 * Created on 2020-04-17, 5:34
 */
package com.marcnuri.yakc.config;

import com.marcnuri.yakc.ssl.SSLResolver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Optional;
import java.util.logging.Level;

import static com.marcnuri.yakc.config.Defaults.getConnectTimeout;
import static com.marcnuri.yakc.config.Defaults.getReadTimeout;
import static com.marcnuri.yakc.ssl.SSLResolver.TLS_V_1_2;

/**
 * Created by Marc Nuri on 2020-04-17.
 */
@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OkHttpClientConfigurator {

  private static final String HEADER_AUTHORIZATION = "Authorization";

  @SuppressWarnings("squid:S3510")
  public static OkHttpClient initOkHttpClient(Configuration optionalConfiguration) {
    final Configuration configuration = Optional.ofNullable(optionalConfiguration)
        .orElse(Configuration.builder().build());
    final OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .connectTimeout(getConnectTimeout(configuration))
        .readTimeout(getReadTimeout(configuration))
        .followRedirects(true)
        .followSslRedirects(true);
    if (SSLResolver.isTrustAllCertificates(configuration)) {
      builder.hostnameVerifier((hostname, session) -> true);
    }
    try {
      final TrustManager[] trustManagers = SSLResolver.trustManagers(configuration);
      final KeyManager[] keyManagers;
      if (SSLResolver.hasClientCertificate(configuration)) {
        keyManagers = SSLResolver.keyManagers(configuration);
      } else {
        keyManagers = null;
      }
      SSLContext sslContext = SSLContext.getInstance(TLS_V_1_2);
      sslContext.init(keyManagers, trustManagers, new SecureRandom());
      builder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0]);
    } catch (Exception e) {
      log.log(Level.WARNING, String.format("Error while loading certificates: %s", e.getMessage()), e);
    }
    builder.addInterceptor(c -> {
      final String currentUserName = Optional.ofNullable(configuration.getUsername())
        .map(OkHttpClientConfigurator::getConfiguration).orElse(null);
      final String currentPassword = Optional.ofNullable(configuration.getPassword())
        .map(OkHttpClientConfigurator::getConfiguration).orElse(null);
      if (currentUserName != null) {
        c.proceed(c.request().newBuilder().addHeader(HEADER_AUTHORIZATION,
          Credentials.basic(currentUserName, currentPassword)).build());
      }
      return c.proceed(c.request());
    });
    builder.addInterceptor(c -> {
      final String currentToken = Optional.ofNullable(configuration.getToken())
        .map(OkHttpClientConfigurator::getConfiguration).orElse(null);
      if (currentToken != null) {
        return c.proceed(c.request().newBuilder().header(HEADER_AUTHORIZATION,
          String.format("Bearer %s", currentToken)).build());
      }
      return c.proceed(c.request());
    });
    return builder.build();
  }

  private static <T> T getConfiguration(ConfigurationSupplier<T> cs) {
    try {
      return cs.get();
    } catch (IOException e) {
      return null;
    }
  }
}
