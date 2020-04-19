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
 * Created on 2020-04-18, 07:00
 */
package com.marcnuri.yakc.ssl;

import com.marcnuri.yakc.config.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.marcnuri.yakc.ssl.SSLResolver.hasCertificateAuthority;
import static com.marcnuri.yakc.ssl.SSLResolver.isTrustAllCertificates;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-04-18.
 */
class SSLResolverTest {
  @Nested
  @DisplayName("isTrustAllCertificates")
  class IsTrustAllCertificates {
    @DisplayName("configuration has isInsecureSkipTlsVerify true, should always be true")
    @Test
    void configurationHasIsInsecureSkipTlsVerify() {
      // Given
      final Configuration c = Configuration.builder()
          .insecureSkipTlsVerify(true)
          .certificateAuthorityData("This would be a valid certificate")
          .build();
      // When
      boolean ret = isTrustAllCertificates(c);
      // Then
      assertThat(ret).isTrue();
    }
    @DisplayName("default configuration, should be false")
    @Test
    void configurationDefault() {
      // Given
      final Configuration c = Configuration.builder().build();
      // When
      boolean ret = isTrustAllCertificates(c);
      // Then
      assertThat(ret).isFalse();
    }
  }
  @Nested
  @DisplayName("hasCertificateAuthority")
  class HasCertificateAuthority {
    @DisplayName("configuration with certificate authority file, should return true")
    @Test
    void hasCertificateAuthorityFile() {
      // Given
      final Configuration c = Configuration.builder()
          .certificateAuthority(new File(""))
          .build();
      // When
      boolean ret = hasCertificateAuthority(c);
      // Then
      assertThat(ret).isTrue();
    }
    @DisplayName("configuration with certificate authority data, should return true")
    @Test
    void hasCertificateAuthorityData() {
      // Given
      final Configuration c = Configuration.builder()
          .certificateAuthorityData("This would be a valid certificate").build();
      // When
      boolean ret = hasCertificateAuthority(c);
      // Then
      assertThat(ret).isTrue();
    }
    @DisplayName("configuration with no authority, should return false")
    @Test
    void hasNotCertificateAuthorityData() {
      // Given
      final Configuration c = Configuration.builder().certificateAuthorityData("").build();
      // When
      boolean ret = hasCertificateAuthority(c);
      // Then
      assertThat(ret).isFalse();
    }
  }
}