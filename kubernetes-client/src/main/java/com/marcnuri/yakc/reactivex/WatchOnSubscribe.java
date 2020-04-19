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
 * Created on 2020-04-13, 16:37
 */
package com.marcnuri.yakc.reactivex;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.api.WatchException;
import com.marcnuri.yakc.model.ListModel;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Marc Nuri on 2020-04-13.
 */
public class WatchOnSubscribe<T> implements ObservableOnSubscribe<WatchEvent<T>> {

  private final OkHttpClient noTimeoutClient;
  private final Request request;
  private final Converter<ResponseBody, WatchEvent<T>> converter;
  private final ExecutorService executorService;

  public WatchOnSubscribe(Type responseType, Request request, KubernetesClient kubernetesClient) throws KubernetesException {
    converter = kubernetesClient.getRetrofit().responseBodyConverter(
        parametrizedWatchEventType(resolveListModelParameterType(responseType)), new Annotation[0]);
    this.request = request;
    this.noTimeoutClient = kubernetesClient.getOkHttpClient().newBuilder()
        .readTimeout(Duration.ZERO)
        .build();
    executorService = Executors.newSingleThreadExecutor();
  }

  @Override
  public void subscribe(ObservableEmitter<WatchEvent<T>> emitter) {
    final Future<Void> readerTask = executorService.submit(() -> {

      final HttpUrl updatedUrl = request.url().newBuilder()
          .addQueryParameter("watch", "true")
          .build();
      final Request updatedRequest = request.newBuilder().url(updatedUrl).build();
      try (
          final okhttp3.Response response = noTimeoutClient.newCall(updatedRequest).execute();
          final InputStream is = Optional.ofNullable(response.body()).map(ResponseBody::source)
              .orElseThrow(() -> new WatchException("Response contains no body", response)).inputStream();
          final BufferedReader br = new BufferedReader(new InputStreamReader(is))
      ) {
        String line;
        while (!emitter.isDisposed() && (line = br.readLine()) != null) {
          final WatchEvent<T> next = converter.convert(ResponseBody.create(MediaType.get("application/json"), line));
          emitter.onNext(next);
        }
      } catch (IOException ex) {
        emitter.tryOnError(ex);
      }
      emitter.onComplete();
      return null;
    });
    try {
      while (!emitter.isDisposed()) {
        Thread.sleep(1000L);
      }
    } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    } finally {
      readerTask.cancel(true);
      executorService.shutdownNow();
    }
  }

  private static JavaType parametrizedWatchEventType(JavaType listParameterModelType) {
    return TypeFactory.defaultInstance().constructParametricType(
        WatchEvent.class, listParameterModelType
    );
  }

  private static JavaType resolveListModelParameterType(Type responseType) throws KubernetesException {
    return TypeFactory.defaultInstance().constructType(responseType).getInterfaces().stream()
        .filter(t -> t.getRawClass() == ListModel.class)
        .findFirst()
        .map(listModelInterface -> listModelInterface.containedType(0))
        .orElseThrow(() ->
            new WatchException("Watch is intended to be run for endpoints returning a ListModel instance", null));
  }
}
