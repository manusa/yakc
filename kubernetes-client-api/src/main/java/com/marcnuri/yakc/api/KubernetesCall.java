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
 * Created on 2020-04-12, 19:23
 */
package com.marcnuri.yakc.api;

import retrofit2.Call;

import java.io.IOException;

/**
 * {@inheritDoc}
 */
public interface KubernetesCall<T> extends Call<T> {

  /**
   * Synchronously send the request and return its decoded response body.
   *
   * @throws IOException if a problem occurred talking to the server.
   */
  T get() throws IOException;

  /**
   * Kubernetes OpenAPI spec has some issues, and for some resources, the documented return
   * type doesn't match with the response object provided by the server.
   *
   * <p><i>e.g. DELETE /api/v1/namespaces/{namespace}/pods/{name} returns Pod instead of Status</i>
   *
   * <p>This method should be used when the regular {@link KubernetesCall#get()} fails due to a conversion
   * problem because the response type doesn't match the one provided in the API.
   *
   * @see <a href="https://github.com/kubernetes/kubernetes/issues/59501">https://github.com/kubernetes/kubernetes/issues/59501</a>
   * @see <a href="https://github.com/kubernetes-client/csharp/issues/145">https://github.com/kubernetes-client/csharp/issues/145</a>
   * @see <a href="https://github.com/kubernetes-client/csharp/issues/44">https://github.com/kubernetes-client/csharp/issues/44</a>
   * @see <a href="https://github.com/kubernetes-client/csharp/pull/46">https://github.com/kubernetes-client/csharp/pull/46</a>
   * @param returnType Class of the expected return type.
   * @param <O> type parameter for the instance object to be returned.
   * @return an instance of the type being retrieved.
   * @throws IOException if a problem occurred talking to the server.
   */
  <O> O get(Class<O> returnType) throws IOException;

}
