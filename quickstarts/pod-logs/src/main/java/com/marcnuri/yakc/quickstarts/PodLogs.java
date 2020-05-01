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
 * Created on 2020-04-26, 08:14
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.DeleteCollectionNamespacedPod;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ReadNamespacedPodLog;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;


/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-26.
 */
public class PodLogs {

  private static final String NAMESPACE = "default";
  private static final String POD_NAME = "yakc-quickstart-pod-logs";

  public static void main(String[] args) {
    final boolean follow = Stream.of(args).anyMatch(s -> s.matches("-*?follow"));
    try (KubernetesClient kc = new KubernetesClient()) {
      final CoreV1Api api = kc.create(CoreV1Api.class);
      createPod(api);
      final KubernetesCall<String> podLogCall = api.readNamespacedPodLog(POD_NAME, NAMESPACE, new ReadNamespacedPodLog()
        .follow(follow).pretty("true").timestamps(true));
      if (follow) {
        final ExecutorService readLogService = Executors.newSingleThreadExecutor();
        final Future<Void> logReader = readLogService.submit(new LogReader(podLogCall));
        System.out.println("Log reading started in a parallel thread, following logs for a couple of seconds");
        Thread.sleep(10500L);
        logReader.cancel(true);
        readLogService.shutdownNow();
        System.out.println("Log thread finished");
      } else {
        System.out.println(podLogCall.get());
      }
      System.out.println("Cleaning up");
      api.deleteCollectionNamespacedPod(NAMESPACE,
        new DeleteCollectionNamespacedPod()
          .gracePeriodSeconds(0)
          .labelSelector(String.format("app=%s", POD_NAME)))
        .get();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void createPod(CoreV1Api api) throws IOException {
    try {
      api.readNamespacedPod(POD_NAME, NAMESPACE).get();
      System.out.printf("Pod %s already exists in namespace %s%n", POD_NAME, NAMESPACE);
    } catch (NotFoundException ex) {
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
            .addToCommand("for i in $(seq 1 100); do echo \"Logging message $i\" & sleep 0.1; done; echo \"No more messages!\"")
            .name("docker-hello-world")
            .build())
          .build())
        .build()).get();
      System.out.printf("Waiting for POD %s to be created%n", POD_NAME);
      api.listNamespacedPod(NAMESPACE).watch()
        .filter(we -> we.getObject().getMetadata().getName().equals(POD_NAME))
        .takeUntil(we -> we.getType() == Type.ADDED)
        .subscribe();
      System.out.printf("Waiting for POD %s to log messages%n", POD_NAME);
      api.listNamespacedPod(NAMESPACE).watch()
        .filter(we -> we.getType() == Type.MODIFIED)
        .takeUntil(we -> (boolean)we.getObject().getStatus().getConditions().stream()
          .anyMatch(pc -> pc.getType().equals("ContainersReady")))
        .subscribe();
      System.out.printf("POD %s was created%n", POD_NAME);
    }
  }

  private static final class LogReader implements Callable<Void> {
    private final KubernetesCall<String> podLogCall;

    LogReader(KubernetesCall<String> podLogCall) {
      this.podLogCall = podLogCall;
    }

    @Override
    public Void call() throws Exception {
      try (
        final Response response = podLogCall.executeRaw();
        final InputStream is = Objects.requireNonNull(response.body()).byteStream();
        final InputStreamReader isr = new InputStreamReader(is);
        final BufferedReader br = new BufferedReader(isr);
      ) {
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println(line);
        }
      }
      return null;
    }
  }
}
