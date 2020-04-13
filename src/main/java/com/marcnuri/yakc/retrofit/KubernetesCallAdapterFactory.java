/*
 * KubernetesCallAdapterFactory.java
 *
 * Created on 2020-04-12, 19:44
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.api.KubernetesCall;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-12.
 */
public class KubernetesCallAdapterFactory extends CallAdapter.Factory {

  private static KubernetesCallAdapterFactory instance = null;

  private KubernetesCallAdapterFactory() {}

  public static synchronized KubernetesCallAdapterFactory getInstance() {
    if (instance == null) {
      instance = new KubernetesCallAdapterFactory();
    }
    return instance;
  }

  @Override
  public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
    Class<?> rawType = getRawType(returnType);
    if (rawType == KubernetesCall.class && returnType instanceof ParameterizedType) {
      Type callReturnType = getParameterUpperBound(0, (ParameterizedType) returnType);
      return new KubernetesCallAdapter<>(callReturnType, retrofit);
    }
    return null;
  }
}