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
 * Created on 2020-04-24, 19:21
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ListPodForAllNamespaces;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Node;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-24.
 */
public class TopNodes {

  private static final String LOG_FORMAT = "%-60.60s %15s %20s%n";
  public static void main(String[] args) {
    try (KubernetesClient kc = new KubernetesClient()) {
      final Node node = kc.create(CoreV1Api.class).listNode().stream()
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("No nodes found in cluster"));
      final Map<String, String> nodeAllocatable = node.getStatus().getAllocatable();
      final double allocatableCpu = Resource.CPU.get(nodeAllocatable);
      final double allocatableMemory = Resource.MEMORY.get(nodeAllocatable);
      final double allocatablePods = Resource.PODS.get(nodeAllocatable);
      System.out.printf("Node %s allocatable resources, cpu: %s, memory: %s, pods %s%n",
        node.getMetadata().getName(),
        allocatableCpu,
        bytesToHumanReadable(allocatableMemory),
        (int)allocatablePods);
      System.out.printf(LOG_FORMAT, "POD (CONTAINER)", "CPU / LIMIT", "MEM / LIMIT");
      logSeparator();
      double totalCpu = 0D;
      double totalCpuLimit = 0D;
      double totalMemory = 0D;
      double totalMemoryLimit = 0D;
      final List<PodContainer> containers = kc.create(CoreV1Api.class).listPodForAllNamespaces(
        new ListPodForAllNamespaces().fieldSelector("spec.nodeName="+node.getMetadata().getName())
      )
        .stream()
        .flatMap(p -> p.getSpec().getContainers().stream().map(c -> new PodContainer(p, c)))
        .collect(Collectors.toList());
      for (PodContainer c : containers) {
        final Map<String, String> containerRequests = c.container.getResources().getRequests();
        final double cpu = Resource.CPU.get(containerRequests);
        final double memory = Resource.MEMORY.get(containerRequests);
        final Map<String, String> containerLimits = c.container.getResources().getLimits();
        final double cpuLimit = Resource.CPU.get(containerLimits);
        final double memoryLimit = Resource.MEMORY.get(containerLimits);
        System.out.printf(LOG_FORMAT,
          String.format("%s (%s)", c.pod.getMetadata().getName(), c.container.getName()),
          cpu + " / " + cpuLimit,
          bytesToHumanReadable(memory) + " / " + bytesToHumanReadable(memoryLimit));
        totalCpu += cpu;
        totalMemory += memory;
        totalCpuLimit += cpuLimit;
        totalMemoryLimit += memoryLimit;
      }
      logSeparator();
      System.out.printf(LOG_FORMAT, "TOTAL",
        totalCpu + " / " + totalCpuLimit,
        bytesToHumanReadable(totalMemory) + " / " + bytesToHumanReadable(totalMemoryLimit));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void logSeparator() {
    System.out.printf(LOG_FORMAT,
      "============================================================", "===========", "===========");
  }
  private static double quantityToScalar(String quantity) {
    quantity = Optional.ofNullable(quantity).orElse("0");
    if (quantity.endsWith("m")) {
      return Integer.parseInt(quantity.substring(0, quantity.length() - 1)) / 1000D;
    }
    if (quantity.endsWith("Ki")) {
      return Integer.parseInt(quantity.substring(0, quantity.length() - 2)) * 1024D;
    }
    if (quantity.endsWith("Mi")) {
      return Integer.parseInt(quantity.substring(0, quantity.length() - 2)) * Math.pow(1024d, 2);
    }
    return Double.parseDouble(quantity);
  }

  private static String bytesToHumanReadable(double bytes) {
    if (bytes > Math.pow(1024d, 3)) {
      return String.format(Locale.ENGLISH, "%.3fGiB", bytes / Math.pow(1024d, 3));
    } else if (bytes > Math.pow(1024d, 2)) {
      return String.format(Locale.ENGLISH, "%dMiB", (long)(bytes / Math.pow(1024d, 2)));
    } else if (bytes > 1024) {
      return String.format(Locale.ENGLISH, "%dKiB", (long)(bytes / 1024));
    }
    return String.format("%s", bytes);
  }

  public enum Resource {
    CPU("cpu"),
    MEMORY("memory"),
    PODS("pods");
    private final String name;
    Resource(String name) {
      this.name = name;
    }
    @Override
    public String toString() {
      return name;
    }
    double get(Map<String, String> resource) {
      return quantityToScalar(Optional.ofNullable(resource).orElse(Collections.emptyMap())
        .getOrDefault(toString(), "0"));
    }
  }
  public static class PodContainer {
    private final Pod pod;
    private final Container container;

    public PodContainer(Pod pod, Container container) {
      this.pod = pod;
      this.container = container;
    }
  }
}
