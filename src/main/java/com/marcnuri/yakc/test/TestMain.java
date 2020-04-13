/*
 * TestMain.java
 *
 * Created on 2020-04-05, 19:23
 */
package com.marcnuri.yakc.test;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
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
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import retrofit2.Response;

import java.util.Collections;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class TestMain {

  public static void main(String[] args) throws Exception {
    final KubernetesClient kubernetesClient = new KubernetesClient();
    final String deploymentName = "java-test";
    final PodList podList = kubernetesClient.<CoreV1Api, PodList>body(CoreV1Api.class).execute(c ->
        c.listPodForAllNamespaces(new ListPodForAllNamespaces().labelSelector("app = test-java")));
    for (Pod p : podList.getItems()) {
      final Pod deletedPod = kubernetesClient.create(CoreV1Api.class).deleteNamespacedPod(
          p.getMetadata().getName(),
          p.getMetadata().getNamespace(),
          DeleteOptions.builder().gracePeriodSeconds(10).propagationPolicy("Foreground").build()
      ).execute(Pod.class).body();
      // new Scanner(value.byteStream(), StandardCharsets.UTF_8.name()).useDelimiter("\\A").next()
    }
    final Response<Status> status = kubernetesClient.execute(AppsV1Api.class, a ->
        a.deleteNamespacedDeployment(deploymentName, "default"));
    System.out.printf("Was deleted: %s%n", status.isSuccessful());
    final Deployment deployment = kubernetesClient.body(AppsV1Api.class, a ->
        a.createNamespacedDeployment("default", Deployment.builder()
            .metadata(ObjectMeta.builder().name(deploymentName).build())
            .spec(DeploymentSpec.builder()
                .replicas(1)
                .selector(LabelSelector.builder().matchLabels(Collections.singletonMap("app", "test-java")).build())
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
            .build()));
    System.out.println(deployment);
    final PodList allPods = kubernetesClient.<CoreV1Api, PodList>body(CoreV1Api.class)
        .execute(CoreV1Api::listPodForAllNamespaces);
    System.out.println(allPods.toString());
    final PodList selectedPodList = kubernetesClient.<CoreV1Api, PodList>body(CoreV1Api.class)
        .execute(c -> c.listPodForAllNamespaces(new ListPodForAllNamespaces().labelSelector("k8s-app=test-pod")));
    System.out.println(selectedPodList);
    final APIResourceList arl = kubernetesClient.body(CoreV1Api.class, CoreV1Api::getAPIResources);
    System.out.println(arl.toString());
    final SecretList secretList = kubernetesClient.body(CoreV1Api.class, CoreV1Api::listSecretForAllNamespaces);
    System.out.println(secretList.toString());
  }

}
