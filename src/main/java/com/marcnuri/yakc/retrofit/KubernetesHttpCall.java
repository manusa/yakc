/*
 * KubernetesHttpCall.java
 *
 * Created on 2020-04-12, 19:33
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.reactivex.WatchOnSubscribe;
import io.reactivex.Observable;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-12.
 */
public class KubernetesHttpCall<T> implements KubernetesCall<T> {

  private final Type responseType;
  private final Call<T> delegate;
  private final Retrofit retrofit;

  KubernetesHttpCall(Type responseType, Call<T> delegate, Retrofit retrofit) {
    this.responseType = responseType;
    this.delegate = delegate;
    this.retrofit = retrofit;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T get() throws IOException {
    return get((Class<T>)responseType);
  }

  @Override
  public <O> O get(Class<O> returnType) throws IOException {
    final okhttp3.Response response = retrofit.callFactory().newCall(request()).execute();
    if (response.isSuccessful()) {
      return retrofit.<O>responseBodyConverter(returnType, new Annotation[0]).convert(response.body());
    }
    throw KubernetesException.forResponse(
        response.body() == null ? "" : response.body().string(),
        response);
  }

  @Override
  public <O> Observable<WatchEvent<O>> watch() throws KubernetesException {
    return Observable.create(new WatchOnSubscribe<>(responseType, retrofit, request()));
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

  @Override
  public KubernetesHttpCall<T> clone() {
    return new KubernetesHttpCall<>(responseType, delegate.clone(), retrofit);
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
