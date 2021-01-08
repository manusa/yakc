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
 * Created on 2021-01-08, 7:43
 */
package com.marcnuri.yakc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class KubeConfigResolver {

  private static final ObjectMapper MAPPER = new ObjectMapper(new YAMLFactory());
  private final Supplier<File> kubeConfigFileResolver;
  private final AtomicLong lastModified;
  private final AtomicReference<KubeConfig> currentConfig;
  private final AtomicReference<KubeConfig.NamedContext> selectedContext;

  KubeConfigResolver() {
    this(() -> new File(System.getProperty("user.home")).toPath().resolve(".kube").resolve("config").toFile());
  }

  KubeConfigResolver(Supplier<File> kubeConfigFileResolver) {
    this.kubeConfigFileResolver = kubeConfigFileResolver;
    lastModified = new AtomicLong(0L);
    currentConfig = new AtomicReference<>(null);
    selectedContext = new AtomicReference<>(null);
  }

  Optional<KubeConfig> getKubeConfig() throws IOException {
    final File kubeConfigFile = kubeConfigFileResolver.get();
    if (!kubeConfigFile.exists()) {
      return Optional.empty();
    }
    if (kubeConfigFile.lastModified() != lastModified.get() || currentConfig.get() == null) {
      lastModified.set(kubeConfigFile.lastModified());
      currentConfig.set(MAPPER.readValue(kubeConfigFile, KubeConfig.class));
    }
    return Optional.of(currentConfig.get());
  }

  Optional<KubeConfig.NamedContext> getCurrentContext() throws IOException {
    if (selectedContext.get() != null) {
      return Optional.of(selectedContext.get());
    }
    final KubeConfig kubeConfig = getKubeConfig().orElse(null);
    if (kubeConfig != null) {
      return kubeConfig.getContexts().stream()
        .filter(c -> c.getName().equals(kubeConfig.getCurrentContext()))
        .findFirst()
        .map(nc -> {
          selectedContext.set(nc);
          return nc;
        });
    }
    return  Optional.empty();
  }

  Optional<KubeConfig.NamedCluster> getCurrentCluster() throws IOException {
    final KubeConfig kubeConfig = getKubeConfig().orElse(null);
    final String currentCluster = getCurrentContext()
      .map(KubeConfig.NamedContext::getContext).map(KubeConfig.Context::getCluster).orElse(null);
    if (kubeConfig != null && currentCluster != null) {
      return Optional.ofNullable(kubeConfig.getClusters())
        .orElse(Collections.emptyList()).stream()
        .filter(c -> c.getName().equals(currentCluster))
        .findFirst();
    }
    return Optional.empty();
  }

  Optional<KubeConfig.NamedAuthInfo> getCurrentNamedAuthInfo() throws IOException {
    final KubeConfig kubeConfig = getKubeConfig().orElse(null);
    final String currentUser = getCurrentContext()
      .map(KubeConfig.NamedContext::getContext).map(KubeConfig.Context::getUser).orElse(null);
    if (kubeConfig != null && currentUser != null) {
      return Optional.ofNullable(kubeConfig.getUsers())
        .orElse(Collections.emptyList()).stream()
        .filter(c -> c.getName().equals(currentUser))
        .findFirst();
    }
    return Optional.empty();
  }

  Optional<KubeConfig.AuthInfo> getCurrentAuthInfo() throws IOException {
    return getCurrentNamedAuthInfo().map(KubeConfig.NamedAuthInfo::getUser);
  }
}
