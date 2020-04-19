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
 * Created on 2020-04-12, 19:41
 */
package com.marcnuri.yakc.retrofit;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.KubernetesCall;
import retrofit2.Call;
import retrofit2.CallAdapter;

import java.lang.reflect.Type;

/**
 * Created by Marc Nuri on 2020-04-12.
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
