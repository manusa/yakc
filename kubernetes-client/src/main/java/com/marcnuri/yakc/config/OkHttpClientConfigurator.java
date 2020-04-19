/*
 * OkHttpClientConfigurator.java
 *
 * Created on 2020-04-17, 5:34
 */
package com.marcnuri.yakc.config;

import com.marcnuri.yakc.ssl.SSLResolver;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;

import java.security.SecureRandom;
import java.util.Optional;

import static com.marcnuri.yakc.config.Defaults.getConnectTimeout;
import static com.marcnuri.yakc.config.Defaults.getReadTimeout;
import static com.marcnuri.yakc.ssl.SSLResolver.TLS_V_1_2;

/**
 * Created by Marc Nuri on 2020-04-17.
 */
@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OkHttpClientConfigurator {

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
      SSLContext sslContext = SSLContext.getInstance(TLS_V_1_2);
      if (SSLResolver.hasClientCertificate(configuration)) {
        sslContext.init(SSLResolver.keyManagers(configuration), trustManagers, new SecureRandom());
      }
      builder.sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustManagers[0]);
    } catch (Exception e) {
      log.warning(String.format("Error while loading certificates: %s", e.getMessage()));
    }
    if (configuration.getUsername() != null) {
      builder.authenticator((route, response) ->
          response.request().newBuilder().header("Authorization",
              Credentials.basic(configuration.getUsername(), configuration.getPassword()))
              .build());
    }
    if (configuration.getToken() != null) {
      builder.authenticator((route, response) ->
          response.request().newBuilder().header("Authorization",
              String.format("Bearer %s", configuration.getToken()))
              .build());
    }
    return builder.build();
  }
}
