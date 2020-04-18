/*
 * ConfigMain.java
 *
 * Created on 2020-04-13, 19:34
 */
package com.marcnuri.yakc.test;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodList;

import java.io.IOException;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-13.
 */
public class ConfigMain {

  public static void main(String[] args) throws IOException {
    final KubernetesClient kc = new KubernetesClient();
    final PodList pl = kc.create(CoreV1Api.class).listPodForAllNamespaces().get();
    System.out.println(pl);
    kc.getOkHttpClient().connectionPool().evictAll();
  }
}
