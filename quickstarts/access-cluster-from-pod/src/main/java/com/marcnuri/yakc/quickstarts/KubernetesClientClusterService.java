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
 * Created on 2020-05-16, 12:13
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ListNamespacedPod;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ReadNamespacedPodLog;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.Deployment;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri on 2020-05-16.
 */
@Service
public class KubernetesClientClusterService implements ClusterService {

  private final KubernetesClient kubernetesClient;

  @Autowired
  public KubernetesClientClusterService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  @Override
  public String getNamespace() {
    return kubernetesClient.getConfiguration().getNamespace();
  }

  @Override
  public List<Deployment> getDeployments() {
    try {
      return kubernetesClient.create(AppsV1Api.class)
        .listNamespacedDeployment(getNamespace()).get().getItems();
    } catch (IOException e) {
      throw new ServerErrorException(e.getMessage(), e);
    }
  }

  @Override
  public String getDeploymentLogs(String deploymentName) {
    try {
      final Deployment deployment = kubernetesClient.create(AppsV1Api.class)
        .readNamespacedDeployment(deploymentName, getNamespace()).get();
      return kubernetesClient.create(CoreV1Api.class).listNamespacedPod(getNamespace(),
        new ListNamespacedPod().labelSelector(
          deployment.getSpec().getSelector().getMatchLabels().entrySet().stream()
            .map(e -> String.format("%s=%s", e.getKey(), e.getValue())).collect(
            Collectors.joining(","))
        )).stream()
        .flatMap(this::getPodLog)
        .sorted()
        .collect(Collectors.joining("\n"));
    } catch(NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (IOException e) {
      throw new ServerErrorException(e.getMessage(), e);
    }
  }

  @Override
  public List<Pod> getPods() {
    try {
      return kubernetesClient.create(CoreV1Api.class).listNamespacedPod(getNamespace()).get().getItems();
    } catch (IOException e) {
      throw new ServerErrorException(e.getMessage(), e);
    }
  }

  private Stream<String> getPodLog(Pod pod) {
    try {
      return Stream.of(kubernetesClient.create(CoreV1Api.class)
        .readNamespacedPodLog(pod.getMetadata().getName(), getNamespace(), new ReadNamespacedPodLog().timestamps(true))
        .get().split("\n")
      ).map(logLine -> {
        final String[] splitLine = logLine.split("\\s", 2);
        return String.format("%s [%s] - %s", splitLine[0], pod.getMetadata().getName(),
          splitLine.length > 1 ? splitLine[1] : "");
      });
    } catch (IOException e) {
      throw new ServerErrorException("Cannot retrieve log", e);
    }
  }
}
