/*
 * KubernetesCallAdapter.java
 *
 * Created on 2020-04-12, 19:41
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.KubernetesCall;
import retrofit2.Call;
import retrofit2.CallAdapter;

import java.lang.reflect.Type;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-12.
 */
public class KubernetesCallAdapter<T> implements CallAdapter<T, KubernetesCall<T>> {

  private final Type responseType;
  private final KubernetesClient kubernetesClient;

  KubernetesCallAdapter(Type responseType, KubernetesClient kubernetesClient) {
    this.responseType = responseType;
    this.kubernetesClient = kubernetesClient;
  }

  @Override
  public Type responseType() {
    return responseType;
  }

  @Override
  public KubernetesCall<T> adapt(Call<T> call) {
    return new KubernetesHttpCall<>(responseType, call, kubernetesClient);
  }
}
