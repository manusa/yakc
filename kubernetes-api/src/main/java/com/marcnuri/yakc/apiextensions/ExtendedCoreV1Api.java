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
 */
package com.marcnuri.yakc.apiextensions;

import com.marcnuri.yakc.api.KubernetesExecCall;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by Marc Nuri on 2020-04-27.
 */
public interface ExtendedCoreV1Api extends CoreV1Api {
  /**
   * Execute a command in the only container of the Pod with the provided name in the provided namespace.
   *
   * @param name name of the Pod.
   * @param namespace namespace where the Pod resides.
   * @param commands the command and args to execute in the Pod container.
   */
  @HTTP(
    method = "GET",
    path = "/api/v1/namespaces/{namespace}/pods/{name}/exec"
  )
  @Headers({
    "Accept: */*"
  })
  KubernetesExecCall<String> execInNamespacedPod(
    @Path("name") String name,
    @Path("namespace") String namespace,
    @Query("command") List<String> commands);

  /**
   * Execute a command in the provided container of the Pod with the provided name in the provided namespace.
   *
   * @param name name of the Pod.
   * @param namespace namespace where the Pod resides.
   * @param container the name of the container.
   * @param commands the command and args to execute in the Pod container.
   * @param stdin redirect the standard input stream of the pod for this call.
   * @param stdout redirect the standard output stream of the pod for this call.
   * @param stderr redirect the standard error stream of the pod for this call.
   * @param tty allocate a terminal for this exec call.
   */
  @HTTP(
    method = "GET",
    path = "/api/v1/namespaces/{namespace}/pods/{name}/exec"
  )
  @Headers({
    "Accept: */*"
  })
  KubernetesExecCall<String> execInNamespacedPod(
    @Path("name") String name,
    @Path("namespace") String namespace,
    @Query("container") String container,
    @Query("command") List<String> commands,
    @Query("stdin") boolean stdin,
    @Query("stdout") boolean stdout,
    @Query("stderr") boolean stderr,
    @Query("tty") boolean tty
  );

  /**
   * Execute a command in the provided container of the Pod with the provided name in the provided namespace.
   *
   * @param name name of the Pod.
   * @param namespace namespace where the Pod resides.
   * @param container the name of the container.
   * @param commands the command and args to execute in the Pod container.
   */
  default KubernetesExecCall<String> execInNamespacedPod(
    String name,
    String namespace,
    String container,
    List<String> commands
  ) {
    return execInNamespacedPod(name, namespace, container, commands, false, true, true,false);
  }
}
