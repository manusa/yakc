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
 * Created on 2020-09-06, 8:36
 */
package com.marcnuri.yakc.quickstarts.dashboard.replicaset;


import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api.ListReplicaSetForAllNamespaces;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.ReplicaSet;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.quickstarts.dashboard.watch.Watchable;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

import java.io.IOException;
import java.util.Optional;

@Singleton
public class ReplicaSetService implements Watchable<ReplicaSet> {

  private final KubernetesClient kubernetesClient;

  @Inject
  public ReplicaSetService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  @Override
  public Optional<Observable<WatchEvent<ReplicaSet>>> watch() throws IOException {
    final AppsV1Api apps = kubernetesClient.create(AppsV1Api.class);
    try {
      apps.listReplicaSetForAllNamespaces(new ListReplicaSetForAllNamespaces().limit(1)).get();
      return Optional.of(apps.listReplicaSetForAllNamespaces().watch());
    } catch (ClientErrorException ex) {
      return Optional.of(apps.listNamespacedReplicaSet(kubernetesClient.getConfiguration().getNamespace()).watch());
    }
  }

  public Status deleteReplicaSet(String name, String namespace) throws IOException {
    return kubernetesClient.create(AppsV1Api.class).deleteNamespacedReplicaSet(name, namespace).get();
  }

}
