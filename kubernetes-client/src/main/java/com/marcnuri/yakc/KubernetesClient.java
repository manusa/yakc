/*
 * Yakc.java
 *
 * Created on 2020-04-11, 12:45
 */
package com.marcnuri.yakc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.config.Configuration;
import com.marcnuri.yakc.config.KubeConfigResolver;
import com.marcnuri.yakc.retrofit.KubernetesCallAdapterFactory;
import lombok.Getter;
import lombok.extern.java.Log;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import static com.marcnuri.yakc.config.OkHttpClientConfigurator.initOkHttpClient;

/**
 * Created by Marc Nuri on 2020-04-11.
 */
@Log
public class KubernetesClient implements Closeable {

  @Getter
  private Configuration configuration;
  @Getter
  private final OkHttpClient okHttpClient;
  @Getter
  private final Retrofit retrofit;

  public KubernetesClient() {
   this(null);
  }

  @SuppressWarnings("WeakerAccess")
  public KubernetesClient(Configuration configuration) {
    this.configuration = initConfiguration(configuration);
    this.okHttpClient = initOkHttpClient(this.configuration);
    this.retrofit = initRetrofit();
  }

  public <T extends Api> T create(Class<T> clazz) {
    return retrofit.create(clazz);
  }

  private static Configuration initConfiguration(Configuration configuration) {
    Configuration ret;
    if (configuration == null) {
      try {
        ret = KubeConfigResolver.resolveKubeConfig();
      } catch(IOException ex) {
        log.warning(String.format("Error while loading  .kube/config: %s", ex.getMessage()));
        ret = Configuration.builder().build();
      }
    } else {
      ret = configuration.toBuilder().build();
    }
    return ret;
  }

  private Retrofit initRetrofit() {
    final ObjectMapper objectMapper = initObjectMapper();
    return new Retrofit.Builder()
        .client(okHttpClient)
        .addCallAdapterFactory(KubernetesCallAdapterFactory.getInstance(this))
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .baseUrl(Objects.requireNonNull(configuration.getServer(), "Server URL configuration is a required"))
        .build();
  }

  private static ObjectMapper initObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper;
  }

  @Override
  public void close() {
    Optional.ofNullable(getOkHttpClient()).map(OkHttpClient::connectionPool)
        .ifPresent(ConnectionPool::evictAll);
  }
}
