/*
 * WipIT.java
 *
 * Created on 2020-04-18, 17:07
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ListNamespacedPod;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ListPodForAllNamespaces;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.Deployment;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.DeploymentSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodList;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodTemplateSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.SecretList;
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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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
    kc.close();
    kc = null;
  }

  @Test
  void watch() throws Exception {
    final CountDownLatch cdl = new CountDownLatch(2);
    final Disposable d = kc.create(CoreV1Api.class)
        .listNamespacedPod("default", new ListNamespacedPod().watch(true))
        .<Pod>watch()
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
    final String deploymentName = "java-test";
    try {
      kc.create(AppsV1Api.class).deleteNamespacedDeployment(deploymentName, "default")
          .get();
    } catch (NotFoundException ex) {
      System.out.println("Deployment not found, deletion not needed");
    }
    final Deployment deployment = kc.create(AppsV1Api.class)
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
    final PodList selectedPodList = kc.create(CoreV1Api.class)
        .listPodForAllNamespaces(new ListPodForAllNamespaces().labelSelector("k8s-app=test-pod"))
        .get();
    System.out.println(selectedPodList);
  }

  @Test
  void other() throws IOException {
    final APIResourceList arl = kc.create(CoreV1Api.class).getAPIResources().get();
    System.out.println(arl.toString());
    final SecretList secretList = kc.create(CoreV1Api.class).listSecretForAllNamespaces().get();
    System.out.println(secretList.toString());
  }

  @Test
  void printAllPods() throws IOException {
    System.out.println("\nPods in all namespaces:");
    printUnderline();
    System.out.printf("%-15s %s%n", "Namespace", "Name");
    System.out.println("---------       ----");
    kc.create(CoreV1Api.class).listPodForAllNamespaces().get().getItems().forEach(p ->
        System.out.printf("%-15s %s%n", p.getMetadata().getNamespace(), p.getMetadata().getName())
    );
  }

  private static void printUnderline() {
    System.out.println("=====================================");
  }
}
