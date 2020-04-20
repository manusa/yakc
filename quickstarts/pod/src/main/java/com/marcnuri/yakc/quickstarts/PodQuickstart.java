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
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Namespace;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-19.
 */
public class PodQuickstart {

  private static final String NAMESPACE = "yakc-namespace";
  private static final String POD_NAME = "yakc-quickstart-pod";

  public static void main(String[] args) {
    System.out.println("Complete POD example:\n"
        + " - Creates a namespace\n"
        + " - Deletes POD if exists\n"
        + " - Creates POD\n"
        + " - Patches POD's labels\n"
        + " - Updates POD removing annotations and adding another label");
    try (KubernetesClient kc = new KubernetesClient()) {
      final CoreV1Api api = kc.create(CoreV1Api.class);
      createNamespace(api);
      final CountDownLatch podDelete = new CountDownLatch(1);
      final CountDownLatch podAdd = new CountDownLatch(1);
      final Disposable podAddedWatch = watchPod(api, podDelete, podAdd);
      if (deletePodIfExists(api) && !podDelete.await(20, TimeUnit.SECONDS)) {
        throw new IOException("Existing POD was not deleted");
      }
      createPod(api);
      final boolean podAdded = podAdd.await(5, TimeUnit.SECONDS);
      if (podAdded) {
        System.out.println("POD successfully added and detected in Watch");
      } else {
        podAddedWatch.dispose();
      }
      final Pod patchedPod = patchPodLabels(api);
      System.out.printf("POD labels patched [%s]%n", patchedPod.getMetadata().getLabels());
      final Pod updatedPod = replacePod(patchedPod, api);
      System.out.printf("POD replaced: annotations removed, labels modified  [%s]%n",
          updatedPod.getMetadata().getLabels());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.exit(0);
  }

  private static void createNamespace(CoreV1Api api) throws IOException {
    try {
      api.readNamespace(NAMESPACE).get();
    } catch (NotFoundException ex) {
      System.out.printf("No existing Namespace with name %s, creating a new one%n", NAMESPACE);
      api.createNamespace(Namespace.builder()
          .metadata(ObjectMeta.builder().name(NAMESPACE).build())
          .build()
      ).get();
    }
  }

  private static boolean deletePodIfExists(CoreV1Api api) throws IOException {
    try {
      api.deleteNamespacedPod(POD_NAME, NAMESPACE,
          DeleteOptions.builder().gracePeriodSeconds(1).build()).get();
      System.out.printf("Existing POD %s was deleted%n", POD_NAME);
      return true;
    } catch (NotFoundException ex) {
      System.out.printf("No existing PODs with name %s%n", POD_NAME);
    }
    return false;
  }

  private static Pod createPod(CoreV1Api api) throws IOException {
    return api.createNamespacedPod(NAMESPACE, Pod.builder()
        .metadata(ObjectMeta.builder()
            .name(POD_NAME)
            .putInLabels("app", "yakc-pod-example")
            .putInAnnotations("com.marcnuri.yakc", "pod-example")
            .build())
        .spec(PodSpec.builder()
            .addToContainers(Container.builder()
                .image("containous/whoami")
                .name("java-test-pod")
                .build())
            .build())
        .build()).get();
  }

  private static Pod patchPodLabels(CoreV1Api api) throws IOException {
    return api.patchNamespacedPod(POD_NAME, NAMESPACE, Pod.builder().metadata(
        ObjectMeta.builder()
            .putInLabels("label2", "otherlabel")
            .build()
    ).build()).get();
  }

  private static Pod replacePod(Pod pod, CoreV1Api api) throws IOException {
    return api.replaceNamespacedPod(POD_NAME, NAMESPACE, pod.toBuilder()
        .metadata(pod.getMetadata().toBuilder()
            .resourceVersion(null) // This will prevent any Optimistic Lock Exception (409 Conflict)
            .clearAnnotations()
            .putInLabels("label3", "an-extra-one")
            .build())
        .build()).get();
  }
  private static Disposable watchPod(CoreV1Api api, CountDownLatch podDelete, CountDownLatch podAdd) throws IOException {
    return api.listNamespacedPod(NAMESPACE)
        .watch()
        .subscribeOn(Schedulers.io())
        .filter(we -> we.getObject().getMetadata().getName().equals(POD_NAME))
        .doOnComplete(() ->
            System.out.println("This won't happen unless the InputStream from k8s is closed")
        )
        .subscribe(we -> {
          System.out.printf("    ++ New Watch Event %-15s - %s/%s (%s) [%s]%n",
              we.getType(),
              we.getObject().getMetadata().getNamespace(),
              we.getObject().getMetadata().getName(),
              we.getObject().getMetadata().getCreationTimestamp(),
              we.getObject().getMetadata().getLabels()
          );
          switch (we.getType()) {
            case ADDED: podAdd.countDown(); break;
            case DELETED: podDelete.countDown(); break;
          }
        }, e -> System.out.println("Received error: " + e));
  }
}
