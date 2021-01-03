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
 * Created on 2021-01-02, 17:30
 */
package com.marcnuri.yakc.quickstarts.dashboard.cronjobs;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.api.batch.v1beta1.BatchV1beta1Api;
import com.marcnuri.yakc.model.io.k8s.api.batch.v1beta1.CronJob;
import com.marcnuri.yakc.quickstarts.dashboard.watch.Watchable;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.Optional;

@Singleton
public class CronJobService implements Watchable<CronJob> {

  private final KubernetesClient kubernetesClient;

  @Inject
  public CronJobService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  @Override
  public Optional<Observable<WatchEvent<CronJob>>> watch() throws IOException {
    final BatchV1beta1Api batch = kubernetesClient.create(BatchV1beta1Api.class);
    try {
      batch.listCronJobForAllNamespaces(new BatchV1beta1Api.ListCronJobForAllNamespaces().limit(1)).get();
      return Optional.of(batch.listCronJobForAllNamespaces().watch());
    } catch (ClientErrorException ex) {
      return Optional.of(batch.listNamespacedCronJob(kubernetesClient.getConfiguration().getNamespace()).watch());
    }
  }

  public CronJob delete(String name, String namespace) throws IOException {
    return kubernetesClient.create(BatchV1beta1Api.class).deleteNamespacedCronJob(name, namespace).get(CronJob.class);
  }

  public CronJob update(String name, String namespace, CronJob cronJob) throws IOException {
    return kubernetesClient.create(BatchV1beta1Api.class).replaceNamespacedCronJob(name, namespace, cronJob).get();
  }

}
