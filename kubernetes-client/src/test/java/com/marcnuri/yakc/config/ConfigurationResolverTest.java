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
 * Created on 2021-01-09, 05:45
 */
package com.marcnuri.yakc.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ConfigurationResolverTest {

  @DisplayName("resolveKubeConfig, no kube config available, returns empty Configuration")
  @Test
  void resolveKubeConfigWithNoKubeConfig() throws IOException {
    try (
      // Given
      MockedConstruction<KubeConfigResolver> kcr = Mockito.mockConstruction(KubeConfigResolver.class, (mock, ctx) -> {
        when(mock.getKubeConfig()).thenReturn(Optional.empty());
      })
    ) {
      // When
      final Configuration configuration = ConfigurationResolver.resolveKubeConfig();
      // Then
      assertThat(configuration).isEqualTo(Configuration.builder().build());
    }
  }

  @DisplayName("resolveKubeConfig, kube config available, returns complete Configuration")
  @Test
  void resolveKubeConfigWithKubeConfig() throws IOException {
    try (
      // Given
      MockedConstruction<KubeConfigResolver> kcr = Mockito.mockConstruction(KubeConfigResolver.class, (mock, ctx) -> {
        mockKubeConfigResolver(mock);
      })
    ) {
      // When
      final Configuration configuration = ConfigurationResolver.resolveKubeConfig();
      // Then
      assertThat(configuration)
        .isNotNull()
        .hasFieldOrPropertyWithValue("server", "1.3.3.7");
    }
  }

  private static void mockKubeConfigResolver(KubeConfigResolver mock) throws IOException {
    when(mock.getKubeConfig()).thenReturn(Optional.of(new KubeConfig()));
    when(mock.getCurrentAuthInfo()).thenReturn(Optional.empty());
    final KubeConfig.Cluster cluster = new KubeConfig.Cluster();
    cluster.setServer("1.3.3.7");
    final KubeConfig.NamedCluster namedCluster = new KubeConfig.NamedCluster();
    namedCluster.setCluster(cluster);
    when(mock.getCurrentCluster()).thenReturn(Optional.of(namedCluster));
    when(mock.getCurrentNamedAuthInfo()).thenReturn(Optional.empty());
  }
}