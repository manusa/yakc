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
 * Created on 2020-04-11, 12:45
 */
package com.marcnuri.yakc;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.config.Configuration;
import com.marcnuri.yakc.config.ConfigurationResolver;
import com.marcnuri.yakc.retrofit.KubernetesCallAdapterFactory;
import com.marcnuri.yakc.serialization.GoCompatibleTimeModule;
import lombok.Getter;
import lombok.extern.java.Log;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

import static com.marcnuri.yakc.config.OkHttpClientConfigurator.initOkHttpClient;

/**
 * The KubernetesClient class is the main entry point to use YAKC.
 *
 * <p> An instance of this class will take care of the cluster access configuration and creating the
 * API specific Retrofit2 clients.
 *
 * <p> You can use the client as follows:
 * <pre>{@code
 *   try (KubernetesClient kc = new KubernetesClient()) {
 *    kc.create(CoreV1Api.class).listPodForAllNamespaces().stream().forEach(p ->
 *       System.out.printf("%-15s %s%n", p.getMetadata().getNamespace(), p.getMetadata().getName())
 *     );
 *   }
 * }</pre>
 *
 * <p> In order to take advantage of this class you'll need to include any of the
 * <a href="https://github.com/manusa/yakc#apis">provided API modules</a>,
 * or build your own.
 * <ul>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-api">
 *     com.marcnuri.yakc:kubernetes-api</a>
*    </li>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:cert-manager">
 *     com.marcnuri.yakc.apis:cert-manager</a>
 *   </li>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:chaos-mesh">
 *     com.marcnuri.yakc.apis:chaos-mesh</a>
 *   </li>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:istio">
 *     com.marcnuri.yakc.apis:istio</a>
 *   </li>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:knative">
 *     com.marcnuri.yakc.apis:knative</a>
 *   </li>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:kudo">
 *     com.marcnuri.yakc.apis:kudo</a>
 *   </li>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:metrics-server">
 *     com.marcnuri.yakc.apis:metrics-server</a>
 *   </li>
 *   <li><a href="https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:openshift">
 *     com.marcnuri.yakc.apis:openshift</a>
 *   </li>
 * </ul>
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
        ret = ConfigurationResolver.resolveConfig();
      } catch(IOException ex) {
        log.warning(String.format("Error while loading autodetected Configuration: %s", ex.getMessage()));
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
    objectMapper.setSerializationInclusion(Include.NON_NULL);
    objectMapper.setSerializationInclusion(Include.NON_EMPTY);
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.registerModule(new GoCompatibleTimeModule());
    return objectMapper;
  }

  @Override
  public void close() {
    Optional.ofNullable(getOkHttpClient()).map(OkHttpClient::dispatcher)
        .map(Dispatcher::executorService).ifPresent(ExecutorService::shutdownNow);
    Optional.ofNullable(getOkHttpClient()).map(OkHttpClient::connectionPool)
        .ifPresent(ConnectionPool::evictAll);
  }
}
