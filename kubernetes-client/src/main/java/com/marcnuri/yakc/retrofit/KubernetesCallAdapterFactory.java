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
 * Created on 2020-04-12, 19:44
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.KubernetesCall;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Marc Nuri on 2020-04-12.
 */
public class KubernetesCallAdapterFactory extends CallAdapter.Factory {

  private static KubernetesCallAdapterFactory instance = null;

  private final KubernetesClient kubernetesClient;

  private KubernetesCallAdapterFactory(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  public static synchronized KubernetesCallAdapterFactory getInstance(KubernetesClient kubernetesClient) {
    if (instance == null) {
      instance = new KubernetesCallAdapterFactory(kubernetesClient);
    }
    return instance;
  }

  @Override
  public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
    Class<?> rawType = getRawType(returnType);
    if (KubernetesCall.class.isAssignableFrom(rawType) && returnType instanceof ParameterizedType) {
      Type callReturnType = getParameterUpperBound(0, (ParameterizedType) returnType);
      return new KubernetesCallAdapter<>(callReturnType, kubernetesClient);
    }
    return null;
  }
}