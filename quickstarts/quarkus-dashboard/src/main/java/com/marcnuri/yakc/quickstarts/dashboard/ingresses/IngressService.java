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
package com.marcnuri.yakc.quickstarts.dashboard.ingresses;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.networking.v1.NetworkingV1Api;
import com.marcnuri.yakc.model.io.k8s.api.networking.v1.Ingress;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import javax.inject.Inject;
import javax.inject.Singleton;

import java.io.IOException;
import java.util.List;

@Singleton
public class IngressService {

  private final KubernetesClient kubernetesClient;

  @Inject
  public IngressService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  public List<Ingress> get() throws IOException {
    return kubernetesClient.create(NetworkingV1Api.class).listIngressForAllNamespaces().get().getItems();
  }

  public Status deleteIngress(String name, String namespace) throws IOException {
    return kubernetesClient.create(NetworkingV1Api.class).deleteNamespacedIngress(name, namespace).get();
  }
}
