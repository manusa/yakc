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
 * Created on 2021-01-08, 19:30
 */
package com.marcnuri.yakc.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KubeConfigResolverTest {

  @DisplayName("getKubeConfig, file doesn't exist, returns empty Optional")
  @Test
  void getKubeConfigNotExists(@TempDir File tempDir) throws IOException {
    // Given
    final File nonExistentFile = new File(tempDir, "config");
    // When
    final Optional<KubeConfig> kubeConfig = new KubeConfigResolver(() -> nonExistentFile).getKubeConfig();
    // Then
    assertThat(kubeConfig).isEmpty();
  }

  @DisplayName("getKubeConfig, empty File, should throw JsonProcessingException")
  @Test
  void getKubeConfigInvalid(@TempDir File tempDir) throws IOException {
    // Given
    final File emptyFile = new File(tempDir, "config");
    assertThat(emptyFile.createNewFile()).isTrue();
    final KubeConfigResolver kcr = new KubeConfigResolver(() -> emptyFile);
    // When - Then
    assertThrows(JsonProcessingException.class, kcr::getKubeConfig);
  }

  @DisplayName("getKubeConfig, valid config, should return Optional with Config")
  @Test
  void getKubeConfigInvalid() throws Exception {
    // Given
    final File validConfig = Paths.get(KubeConfigResolverTest.class.getResource("/config/valid-kube-config.yaml")
      .toURI()).toFile();
    // When
    final Optional<KubeConfig> kubeConfig = new KubeConfigResolver(() -> validConfig).getKubeConfig();
    // Then
    assertThat(kubeConfig)
      .isNotEmpty()
      .get()
      .hasFieldOrPropertyWithValue("currentContext", "yakc");
  }
}