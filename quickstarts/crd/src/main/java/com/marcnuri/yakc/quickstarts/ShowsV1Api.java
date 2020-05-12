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
 * Created on 2020-05-11, 19:41
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Marc Nuri on 2020-05-11.
 */
public interface ShowsV1Api extends Api {

  String API_VERSION = "v1";
  String CRD_GROUP = "yakc.marcnuri.com";
  String CRD_NAME = "shows." + CRD_GROUP;
  String API_PATH = "/apis/" +  CRD_GROUP  + "/" + API_VERSION + "/namespaces/{namespace}/shows";

  @HTTP(
    method = "POST",
    path = API_PATH,
    hasBody = true
  )
  @Headers({
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Show> createNamespacedShow(
    @Path("namespace") String namespace,
    @Body Show body);

  @HTTP(
    method = "GET",
    path = API_PATH
  )
  @Headers({
    "Accept: */*"
  })
  KubernetesListCall<ShowList, Show> listNamespacedShow(
    @Path("namespace") String namespace);

  @HTTP(
    method = "DELETE",
    path = API_PATH + "/{name}"
  )
  @Headers({
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedShow(
    @Path("name") String name,
    @Path("namespace") String namespace);

  @HTTP(
    method = "GET",
    path = API_PATH + "/{name}"
  )
  @Headers({
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> readNamespacedShow(
    @Path("name") String name,
    @Path("namespace") String namespace);

  @HTTP(
    method = "PATCH",
    path = API_PATH + "/{name}",
    hasBody = true
  )
  @Headers({
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Show> patchNamespacedShow(
    @Path("name") String name,
    @Path("namespace") String namespace,
    @Body Show body);
}
