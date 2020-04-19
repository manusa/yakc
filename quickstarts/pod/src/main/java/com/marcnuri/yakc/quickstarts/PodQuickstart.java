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
 * Created on 2020-04-19, 13:24
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-19.
 */
public class PodQuickstart {

  public static void main(String[] args) {
    try (KubernetesClient kc = new KubernetesClient()) {
      final CountDownLatch cdl = new CountDownLatch(2);
      final Disposable d = kc.create(CoreV1Api.class)
          .listNamespacedPod("default")
          .watch()
          .subscribeOn(Schedulers.newThread())
          .doOnComplete(() ->
              System.out.println("This won't happen unless the InputStream from k8s is closed")
          )
          .subscribe(we -> {
            System.out.printf("++ New Watch Event %-15s - %s/%s (%s)%n",
                we.getType(),
                we.getObject().getMetadata().getNamespace(),
                we.getObject().getMetadata().getName(),
                we.getObject().getMetadata().getCreationTimestamp()
            );
            cdl.countDown();
          }, e -> System.out.println("Received error: " + e));
      cdl.await(5, TimeUnit.SECONDS);
      d.dispose();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
