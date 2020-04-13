/*
 * KubernetesHttpCall.java
 *
 * Created on 2020-04-12, 19:33
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.api.KubernetesCall;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-12.
 */
public class KubernetesHttpCall<T> implements KubernetesCall<T> {

  private final Call<T> delegate;
  private final Retrofit retrofit;

  KubernetesHttpCall(Call<T> delegate, Retrofit retrofit) {
    this.delegate = delegate;
    this.retrofit = retrofit;
  }

  @Override
  public <O> Response<O> execute(Class<O> returnType) throws IOException {
    final Request request = request();
    final okhttp3.Response response = retrofit.callFactory().newCall(request).execute();
    if (response.isSuccessful()) {
      final O body = retrofit.<O>responseBodyConverter(returnType, new Annotation[0]).convert(response.body());
      return Response.success(body, response);
    }
    return Response.error(response.code(), response.body());
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
    return new KubernetesHttpCall<>(delegate.clone(), retrofit);
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
