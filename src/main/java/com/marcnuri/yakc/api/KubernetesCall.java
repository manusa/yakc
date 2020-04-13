/*
 * KubernetesCall.java
 *
 * Created on 2020-04-12, 19:23
 */
package com.marcnuri.yakc.api;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * {@inheritDoc}
 */
public interface KubernetesCall<T> extends Call<T> {

  /**
   * Kubernetes OpenAPI spec has some issues and for some resources, the documented return
   * type doesn't match with the response object provided by the server.
   *
   * <p><i>e.g. DELETE /api/v1/namespaces/{namespace}/pods/{name}</i>
   *
   * <p>This method should be used when the regular {@link Call#execute()} fails due to a conversion
   * problem because the response type doesn't match the one provided in the API.
   *
   * @see <a href="https://github.com/kubernetes/kubernetes/issues/59501">https://github.com/kubernetes/kubernetes/issues/59501</a>
   * @see <a href="https://github.com/kubernetes-client/csharp/issues/145">https://github.com/kubernetes-client/csharp/issues/145</a>
   * @see <a href="https://github.com/kubernetes-client/csharp/issues/44">https://github.com/kubernetes-client/csharp/issues/44</a>
   * @see <a href="https://github.com/kubernetes-client/csharp/pull/46">https://github.com/kubernetes-client/csharp/pull/46</a>
   * @param returnType Class of the expected return type for the Response.
   * @param <O> type parameter for the instance object of the Response.
   * @return a Response with a ResponseBody instance of the provided return type.
   * @throws IOException if a problem occurred talking to the server.
   */
  <O> Response<O> execute(Class<O> returnType) throws IOException;

}
