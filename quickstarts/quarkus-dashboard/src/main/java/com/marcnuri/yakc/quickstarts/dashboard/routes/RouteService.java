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
 * Created on 2020-11-21, 9:32
 */
package com.marcnuri.yakc.quickstarts.dashboard.routes;

import static com.marcnuri.yakc.quickstarts.dashboard.ClientUtil.tryWithFallback;

import java.io.IOException;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.api.routeopenshiftio.v1.RouteOpenshiftIoV1Api;
import com.marcnuri.yakc.model.com.github.openshift.api.route.v1.Route;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.quickstarts.dashboard.watch.Watchable;

import io.reactivex.Observable;

@Singleton
public class RouteService implements Watchable<Route> {

  private final KubernetesClient kubernetesClient;

  @Inject
  public RouteService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  @Override
  public Optional<Observable<WatchEvent<Route>>> watch() throws IOException {
    final RouteOpenshiftIoV1Api routes = kubernetesClient.create(RouteOpenshiftIoV1Api.class);
    return tryWithFallback(
      () -> {
        routes.listRouteForAllNamespaces(new RouteOpenshiftIoV1Api.ListRouteForAllNamespaces().limit(1))
          .get();
        return Optional.of(routes.listRouteForAllNamespaces().watch());
      },
      () -> Optional.of(routes.listNamespacedRoute(kubernetesClient.getConfiguration().getNamespace()).watch()),
      Optional::empty
    );
  }

  public Status delete(String name, String namespace) throws IOException {
    return kubernetesClient.create(RouteOpenshiftIoV1Api.class).deleteNamespacedRoute(name, namespace).get();
  }

  public Route update(String name, String namespace, Route route) throws IOException {
    return kubernetesClient.create(RouteOpenshiftIoV1Api.class).replaceNamespacedRoute(name, namespace, route).get();
  }
}
