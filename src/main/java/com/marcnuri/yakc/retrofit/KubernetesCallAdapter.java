/*
 * KubernetesCallAdapter.java
 *
 * Created on 2020-04-12, 19:41
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.api.KubernetesCall;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.reflect.Type;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-12.
 */
public class KubernetesCallAdapter<T> implements CallAdapter<T, KubernetesCall<T>> {

  private final Type responseType;
  private final Retrofit retrofit;

  public KubernetesCallAdapter(Type responseType, Retrofit retrofit) {
    this.responseType = responseType;
    this.retrofit = retrofit;
  }

  @Override
  public Type responseType() {
    return responseType;
  }

  @Override
  public KubernetesCall<T> adapt(Call<T> call) {
    return new KubernetesHttpCall<>(call, retrofit);
  }
}
