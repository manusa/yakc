/*
 * TestMain.java
 *
 * Created on 2020-04-05, 19:23
 */
package com.marcnuri.yakc.test;

import com.marcnuri.yakc.KubernetesClient;
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

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class TestMain {

  public static void main(String[] args) throws Exception {
    final KubernetesClient kc = new KubernetesClient();
    final CountDownLatch cdl = new CountDownLatch(2);
    final Disposable d = kc.create(CoreV1Api.class)
        .listNamespacedPod("default", new ListNamespacedPod().watch(true))
        .<Pod>watch()
        .subscribeOn(Schedulers.newThread())
        .doOnComplete(() ->
          System.out.println("This won't happen unless the inputstream from k8s is closed")
        )
        .subscribe(we -> {
          System.out.println(we);
          cdl.countDown();
        });
    cdl.await();
    d.dispose();
    printAllPods(kc);
    final String deploymentName = "java-test";
    final PodList podList = kc.create(CoreV1Api.class)
        .listPodForAllNamespaces(new ListPodForAllNamespaces().labelSelector("app = test-java")).get();
    for (Pod p : podList.getItems()) {
      final Pod deletedPod = kc.create(CoreV1Api.class).deleteNamespacedPod(
          p.getMetadata().getName(),
          p.getMetadata().getNamespace(),
          DeleteOptions.builder().gracePeriodSeconds(10).propagationPolicy("Foreground").build()
      ).get(Pod.class);
    }
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
                    .matchLabels(Collections.singletonMap("app", "test-java")).build())
                .template(PodTemplateSpec.builder()
                    .metadata(ObjectMeta.builder()
                        .name("java-test-pod")
                        .labels(Collections.singletonMap("app", "test-java"))
                        .build())
                    .spec(PodSpec.builder()
                        .containers(Collections.singletonList(Container.builder()
                            .image("containous/whoami")
                            .name("java-test-pod")
                            .build()))
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
    final APIResourceList arl = kc.create(CoreV1Api.class).getAPIResources().get();
    System.out.println(arl.toString());
    final SecretList secretList = kc.create(CoreV1Api.class).listSecretForAllNamespaces().get();
    System.out.println(secretList.toString());
  }

  private static void printAllPods(KubernetesClient kc) throws IOException {
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
