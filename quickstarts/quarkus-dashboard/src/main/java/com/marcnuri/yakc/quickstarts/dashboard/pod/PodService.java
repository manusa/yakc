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
package com.marcnuri.yakc.quickstarts.dashboard.pod;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class PodService {

  private final KubernetesClient kubernetesClient;

  @Inject
  public PodService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  public Observable<WatchEvent<Pod>> getPods() throws KubernetesException {
    return kubernetesClient.create(CoreV1Api.class).listPodForAllNamespaces().watch();
  }

  public Pod deletePod(String name, String namespace) throws IOException {
    return kubernetesClient.create(CoreV1Api.class).deleteNamespacedPod(name, namespace).get();
  }
}
