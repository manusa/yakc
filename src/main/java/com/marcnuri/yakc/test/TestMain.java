/*
 * TestMain.java
 *
 * Created on 2020-04-05, 19:23
 */
package com.marcnuri.yakc.test;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodList;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.SecretList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class TestMain {

  public static void main(String[] args){
    final KubernetesClient kubernetesClient = new KubernetesClient();
    final PodList podList = kubernetesClient.target(CoreV1Api.class).listCoreV1PodForAllNamespaces();
    System.out.println(podList);
    final APIResourceList arl = kubernetesClient.target(CoreV1Api.class).getCoreV1APIResources();
    System.out.println(arl.toString());
    final SecretList secretList = kubernetesClient.target(CoreV1Api.class).listCoreV1SecretForAllNamespaces();
    System.out.println(secretList.toString());
  }

}
