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
 * Created on 2020-04-12, 19:33
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.ExecMessage;
import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.KubernetesExecCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.model.ListModel;
import com.marcnuri.yakc.reactivex.ExecOnSubscribe;
import com.marcnuri.yakc.reactivex.WatchOnSubscribe;
import io.reactivex.Observable;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri on 2020-04-12.
 */
public class KubernetesHttpCall<T, W> implements KubernetesListCall<T, W>, KubernetesExecCall<T> {

  private static final String HEADER_CONTENT_TYPE = "Content-Type";
  private final Type responseType;
  private final Call<T> delegate;
  private final KubernetesClient kubernetesClient;

  KubernetesHttpCall(Type responseType, Call<T> delegate, KubernetesClient kubernetesClient) {
    this.responseType = responseType;
    this.delegate = delegate;
    this.kubernetesClient = kubernetesClient;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T get() throws IOException {
    return get((Class<T>)responseType);
  }

  @Override
  public <O> O get(Class<O> returnType) throws IOException {
    final okhttp3.Response response = executeRaw();
    if (response.isSuccessful()) {
      final String contentType = Optional.ofNullable(response.header(HEADER_CONTENT_TYPE))
        .orElseThrow(() -> KubernetesException.forResponse("Response with no Content-Type", response));
      if (contentType.startsWith("text/") && returnType == String.class) {
        return returnType.cast(response.body() != null ? response.body().string() : "");
      } else if (contentType.equalsIgnoreCase("application/json")) {
        return kubernetesClient.getRetrofit().<O>responseBodyConverter(returnType, new Annotation[0]).convert(response.body());
      }
      throw KubernetesException.forResponse("Unprocessable response body", response);
    }
    throw KubernetesException.forResponse(
        response.body() == null ? "" : response.body().string(),
        response);
  }

  @Override
  public Observable<WatchEvent<W>> watch() throws KubernetesException {
    return Observable.create(new WatchOnSubscribe<>(responseType, request(), kubernetesClient));
  }

  @Override
  @SuppressWarnings("unchecked")
  public Stream<W> stream() throws IOException {
    return ((ListModel<W>)get()).getItems().stream();
  }

  @Override
  public Observable<ExecMessage> exec() {
    return Observable.create(new ExecOnSubscribe(request(), kubernetesClient));
  }

  @Override
  public WebSocket exec(WebSocketListener webSocketListener) {
    return kubernetesClient.getOkHttpClient().newWebSocket(request(), webSocketListener);
  }

  @Override
  public okhttp3.Response executeRaw() throws IOException {
    return kubernetesClient.getRetrofit().callFactory().newCall(request()).execute();
  }


  @Override
  public Response<T> execute() throws IOException {
    return delegate.execute();
  }

  @Override
  public void enqueue(final Callback<T> callback) {
    delegate.enqueue(callback);
  }

  @Override
  public boolean isExecuted() {
    return delegate.isExecuted();
  }

  @Override
  public void cancel() {
    delegate.cancel();
  }

  @Override
  public boolean isCanceled() {
    return delegate.isCanceled();
  }

  @SuppressWarnings({"CloneDoesntCallSuperClone", "squid:S1182", "squid:S2975"})
  @Override
  public KubernetesHttpCall<T, W> clone() {
    return new KubernetesHttpCall<>(responseType, delegate.clone(), kubernetesClient);
  }

  @Override
  public Request request() {
    return delegate.request();
  }

  @Override
  public Timeout timeout() {
    return delegate.timeout();
  }
}
