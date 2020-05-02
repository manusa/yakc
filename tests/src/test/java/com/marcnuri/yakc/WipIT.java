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
 * Created on 2020-04-18, 17:07
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ListPodForAllNamespaces;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.Deployment;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.DeploymentSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ConfigMap;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodList;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodTemplateSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.LabelSelector;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-04-18.
 */
class WipIT {

  private static KubernetesClient kc;

  @BeforeAll
  static void setUp() {
    kc = new KubernetesClient();
  }

  @AfterAll
  static void tearDown() {
//    kc.close(); // TODO: Enable when isolated OkHttp dispatchers and pools are available
    kc = null;
  }

  @Test
  void namespaceWatchBlocksUntilOneIsAdded() throws KubernetesException {
    final AtomicInteger count = new AtomicInteger(0);
    final Disposable namespaceWatch = kc.create(CoreV1Api.class)
        .listNamespace()
        .watch()
        .takeUntil(we -> we.getType() == Type.ADDED)
        .subscribe(we -> count.incrementAndGet());
    assertThat(namespaceWatch.isDisposed()).isEqualTo(true);
    assertThat(count.get()).isEqualTo(1);
  }

  @Test
  void watchPods() throws Exception {
    final CountDownLatch cdl = new CountDownLatch(2);
    final Disposable d = kc.create(CoreV1Api.class)
        .listNamespacedPod("default")
        .watch()
        .subscribeOn(Schedulers.io())
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
  }

  @Test
  void configMaps() throws Exception {
    final String configMapName = "test";
    final CountDownLatch cdl = new CountDownLatch(1);
    kc.create(CoreV1Api.class).listConfigMapForAllNamespaces().watch()
        .subscribeOn(Schedulers.newThread())
        .filter(we -> Stream.of(Type.ADDED, Type.DELETED).anyMatch(t -> we.getType() == t))
        .filter(we -> we.getObject().getMetadata().getName().equals(configMapName))
        .subscribe(we -> {
          cdl.countDown();
          System.out.printf("++ ConfigMap Watch %-15s - %s/%s%n",
              we.getType(),
              we.getObject().getMetadata().getNamespace(),
              we.getObject().getMetadata().getName()
          );
        });
    try {
      kc.create(CoreV1Api.class).deleteNamespacedConfigMap(configMapName, "default").get();
      System.out.println("Existing ConfigMap was deleted");
    } catch (NotFoundException ex) {
      System.out.println("ConfigMap not found, deletion not needed");
    }
    kc.create(CoreV1Api.class).createNamespacedConfigMap("default", ConfigMap.builder()
        .metadata(ObjectMeta.builder()
            .name(configMapName)
            .putInAnnotations("one-annotation-key", "annotation-value")
            .build())
        .data(Collections.singletonMap("some", "to-keep"))
        .putInData("test-key", "test-value")
        .build()).get();
    kc.create(CoreV1Api.class).patchNamespacedConfigMap(configMapName, "default",
      ConfigMap.builder().metadata(ObjectMeta.builder().putInLabels("other", "label").build()).build()).get();
    cdl.await(5, TimeUnit.SECONDS);
  }

  @Test
  void delete() throws IOException {
    final PodList podList = kc.create(CoreV1Api.class)
        .listPodForAllNamespaces(new ListPodForAllNamespaces().labelSelector("app = test-java"))
        .get();
    for (Pod p : podList.getItems()) {
      kc.create(CoreV1Api.class).deleteNamespacedPod(
          p.getMetadata().getName(),
          p.getMetadata().getNamespace(),
          DeleteOptions.builder().gracePeriodSeconds(10).propagationPolicy("Foreground").build()
      ).get(Pod.class);
    }
  }

  @Test
  void deployment() throws IOException {
    final AppsV1Api api = kc.create(AppsV1Api.class);
    final String deploymentName = "java-test";
    try {
      api.deleteNamespacedDeployment(deploymentName, "default")
          .get();
      System.out.println("Deployment created");
    } catch (NotFoundException ex) {
      System.out.println("Deployment not found, deletion not needed");
    }
    final Deployment deployment =api
        .createNamespacedDeployment("default", Deployment.builder()
            .metadata(ObjectMeta.builder().name(deploymentName).build())
            .spec(DeploymentSpec.builder()
                .replicas(1)
                .selector(LabelSelector.builder()
                    .putInMatchLabels("k8s-app", "test-java")
                    .build())
                .template(PodTemplateSpec.builder()
                    .metadata(ObjectMeta.builder()
                        .name("java-test-pod")
                        .putInLabels("k8s-app", "test-java")
                        .build())
                    .spec(PodSpec.builder()
                        .addToContainers(Container.builder()
                            .image("containous/whoami")
                            .name("java-test-pod")
                            .build())
                        .build())
                    .build()
                ).build()
            )
            .build()).get();
    System.out.println(deployment);
    api.patchNamespacedDeployment(deploymentName, "default",
        Deployment.builder().spec(deployment.getSpec().toBuilder().replicas(2).build()).build()
        ).get();
    final PodList selectedPodList = kc.create(CoreV1Api.class)
        .listPodForAllNamespaces(new ListPodForAllNamespaces().labelSelector("k8s-app=test-pod"))
        .get();
    System.out.println(selectedPodList);
  }

  @Test
  void other() throws IOException {
    final APIResourceList arl = kc.create(CoreV1Api.class).getAPIResources().get();
    System.out.println(arl.toString());
  }

}
