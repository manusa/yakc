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
 * Created on 2020-04-27, 19:33
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.apiextensions.ExtendedCoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import io.reactivex.schedulers.Schedulers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-27.
 */
public class PodExec {

  private static final String NAMESPACE = "default";
  private static final String POD_NAME = "yakc-quickstart-pod-exec";

  public static void main(String[] args) {
    try (KubernetesClient kc = new KubernetesClient()) {
      final ExtendedCoreV1Api api = kc.create(ExtendedCoreV1Api.class);
      createPod(api);
      api.execInNamespacedPod(POD_NAME, NAMESPACE, Collections.singletonList("pwd"))
        .exec()
        .skip(1)
        .subscribe(em -> System.out.printf("Current container Directory: %s", em.toString()));
      System.out.println("Running memory monitor for 5s in the background");
      api.execInNamespacedPod(POD_NAME, NAMESPACE,
        Arrays.asList("/bin/sh", "-c", "for i in $(seq 1 5); do cat /proc/meminfo | grep MemFree & sleep 1; done"))
        .exec()
        .subscribeOn(Schedulers.io())
        .skip(1)
        .subscribe(t -> System.out.printf("         ++ %s", t.toString()), Throwable::printStackTrace);
      api.execInNamespacedPod(POD_NAME, NAMESPACE,
        Arrays.asList("/bin/sh", "-c", "echo 'Waiting 5S' && sleep 5"
          + "&& echo 'Hello World in error standard stream' >> /dev/stderr"
          + "&& echo 'Container execution completed, bye!'"))
        .exec()
        .skip(1)
        .subscribe(t ->
          System.out.printf("%s: %s", t.getStandardStream(), t.toString()), Throwable::printStackTrace);
      System.out.println("Subscriptions completed, cleaning up.");
      deletePod(api);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void deletePod(CoreV1Api api) throws IOException {
    api.deleteNamespacedPod(POD_NAME, NAMESPACE,
      DeleteOptions.builder().gracePeriodSeconds(1).build()).get();
    System.out.printf("Waiting for Pod %s in namespace %s to be deleted%n", POD_NAME, NAMESPACE);
    api.listNamespacedPod(NAMESPACE).watch()
      .filter(we -> we.getObject().getMetadata().getName().equals(POD_NAME))
      .takeUntil(we -> we.getType() == Type.DELETED)
      .subscribe();
    System.out.printf("Pod %s in namespace %s was deleted%n", POD_NAME, NAMESPACE);
  }

  private static void createPod(CoreV1Api api) throws IOException {
    try {
      api.readNamespacedPod(POD_NAME, NAMESPACE).get();
      System.out.printf("Pod %s already exists in namespace %s, deleting%n", POD_NAME, NAMESPACE);
      deletePod(api);
    } catch (NotFoundException ex) {
      System.out.printf("Pod %s doesn't exist in namespace %s%n", POD_NAME, NAMESPACE);
    }
    api.createNamespacedPod(NAMESPACE, Pod.builder()
      .metadata(ObjectMeta.builder()
        .name(POD_NAME)
        .putInLabels("app", POD_NAME)
        .build())
      .spec(PodSpec.builder()
        .addToContainers(Container.builder()
          .image("busybox")
          .addToCommand("/bin/sh")
          .addToCommand("-c")
          .addToCommand("sleep 3600")
          .name("pod-exec")
          .build())
        .build())
      .build()).get();
    System.out.printf("Waiting for POD %s to be created%n", POD_NAME);
    api.listNamespacedPod(NAMESPACE).watch()
      .filter(we -> we.getType() == Type.MODIFIED)
      .takeUntil(we -> (boolean)we.getObject().getStatus().getConditions().stream()
        .anyMatch(pc -> pc.getType().equals("ContainersReady")))
      .subscribe();
    System.out.printf("POD %s was created%n", POD_NAME);
  }
}
