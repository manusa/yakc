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
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;
import java.util.stream.Stream;

import static com.marcnuri.yakc.ssl.SSLResolver.hasCertificateAuthority;
import static com.marcnuri.yakc.ssl.SSLResolver.hasClientCertificate;
import static com.marcnuri.yakc.ssl.SSLResolver.isTrustAllCertificates;
import static com.marcnuri.yakc.ssl.SSLResolver.keyManagers;
import static com.marcnuri.yakc.ssl.SSLResolver.trustManagers;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Marc Nuri on 2020-04-18.
 */
@SuppressWarnings("InnerClassMayBeStatic")
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
      boolean result = isTrustAllCertificates(c);
      // Then
      assertThat(result).isTrue();
    }
    @DisplayName("default configuration, should be false")
    @Test
    void configurationDefault() {
      // Given
      final Configuration c = Configuration.builder().build();
      // When
      boolean result = isTrustAllCertificates(c);
      // Then
      assertThat(result).isFalse();
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
      boolean result = hasCertificateAuthority(c);
      // Then
      assertThat(result).isTrue();
    }
    @DisplayName("configuration with certificate authority data, should return true")
    @Test
    void hasCertificateAuthorityData() {
      // Given
      final Configuration c = Configuration.builder()
          .certificateAuthorityData("This would be a valid certificate").build();
      // When
      boolean result = hasCertificateAuthority(c);
      // Then
      assertThat(result).isTrue();
    }
    @DisplayName("configuration with no authority, should return false")
    @Test
    void hasNotCertificateAuthorityData() {
      // Given
      final Configuration c = Configuration.builder().certificateAuthorityData("").build();
      // When
      boolean result = hasCertificateAuthority(c);
      // Then
      assertThat(result).isFalse();
    }
  }
  @Nested
  @DisplayName("hasClientCertificate")
  class HasClientCertificate {
    @DisplayName("configuration with client certificate and client key, should return true")
    @Test
    void hasCertificateAndKey() {
      // Given
      final Configuration c = Configuration.builder()
        .clientCertificate(new File(""))
        .clientKey(new File(""))
        .build();
      // When
      boolean result = hasClientCertificate(c);
      // Then
      assertThat(result).isTrue();
    }
    @DisplayName("configuration with client certificate and NO client key, should return false")
    @Test
    void hasCertificateAndNoKey() {
      // Given
      final Configuration c = Configuration.builder()
        .clientCertificateData("This would be a valid certificate")
        .build();
      // When
      boolean result = hasClientCertificate(c);
      // Then
      assertThat(result).isFalse();
    }
    @DisplayName("configuration with NO client certificate and client key, should return false")
    @Test
    void hasNoCertificateAndKey() {
      // Given
      final Configuration c = Configuration.builder()
        .clientKeyData("This would be a valid certificate")
        .build();
      // When
      boolean result = hasClientCertificate(c);
      // Then
      assertThat(result).isFalse();
    }
    @DisplayName("configuration with NO client certificate and NO client key, should return false")
    @Test
    void hasNoCertificateAndNoKey() {
      // Given
      final Configuration c = Configuration.builder().build();
      // When
      boolean result = hasClientCertificate(c);
      // Then
      assertThat(result).isFalse();
    }
  }
  @Nested
  @DisplayName("trustManagers")
  class TrustManagers {

    private File rootCA;

    @BeforeEach
    void setUp() throws URISyntaxException {
      rootCA = new File(SSLResolverTest.class.getResource("/certificate/cert.pem").toURI());
    }

    @DisplayName("configuration with valid CA and NOT trustAll, should return TrustManager[] with CA")
    @Test
    void trustManagerValidCANoTrustAll() throws Exception {
      // Given
      final Configuration c = Configuration.builder().certificateAuthority(rootCA).build();
      // When
      final TrustManager[] result = trustManagers(c);
      // Then
      assertThat(result).hasSize(1);
      assertThat(result[0]).isInstanceOf(X509TrustManager.class);
      assertThat(result[0]).isNotInstanceOf(AlwaysTrustManager.class);
      final X500Name yakcCA = Stream.of(((X509TrustManager)result[0]).getAcceptedIssuers())
        .map(X509Certificate::getSubjectX500Principal)
        .filter(Objects::nonNull)
        .map(X500Principal::getName)
        .map(X500Name::new)
        .filter(n -> n.getRDNs(BCStyle.CN).length > 0)
        .filter(n -> "com.marcnuri.yakc".equals(IETFUtils.valueToString(n.getRDNs(BCStyle.CN)[0].getFirst().getValue())))
        .findAny()
        .orElse(null);
      assertCertificate(yakcCA);
    }

    @DisplayName("configuration with valid CA and trustAll, should return TrustManager[] with AlwaysTrustManager")
    @Test
    void trustManagerValidCAAndTrustAll() throws Exception {
      // Given
      final Configuration c = Configuration.builder()
        .insecureSkipTlsVerify(true)
        .certificateAuthority(rootCA)
        .build();
      // When
      final TrustManager[] result = trustManagers(c);
      // Then
      assertThat(result).hasSize(1);
      assertThat(result[0]).isInstanceOf(X509TrustManager.class);
      assertThat(result[0]).isInstanceOf(AlwaysTrustManager.class);
    }
  }
  @Nested
  @DisplayName("keyManagers")
  class KeyManagers {

    private File key;
    private File cert;

    @BeforeEach
    void setUp() throws URISyntaxException {
      key = new File(SSLResolverTest.class.getResource("/certificate/key.pem").toURI());
      cert = new File(SSLResolverTest.class.getResource("/certificate/cert.pem").toURI());
    }


    @DisplayName("configuration with valid certificate and key, should return KeyManager[] with certificate")
    @Test
    void keyManagersValidCertificateAndKey() throws Exception {
      // Given
      final Configuration c = Configuration.builder()
        .clientKey(key)
        .clientCertificate(cert)
        .build();
      // When
      final KeyManager[] result = keyManagers(c);
      // Then
      final X509Certificate caCertificate = (X509Certificate)CertificateFactory.getInstance("X509")
        .generateCertificate(new FileInputStream(cert));
      assertThat(result).hasSize(1);
      assertThat(result[0]).isInstanceOf(X509KeyManager.class);
      final X509Certificate[] certChain = ((X509KeyManager)result[0])
        .getCertificateChain(caCertificate.getSubjectX500Principal().getName().toLowerCase());
      assertThat(certChain).hasSize(1);
      assertCertificate(new X500Name(certChain[0].getSubjectX500Principal().getName()));
    }
  }

  private static void assertCertificate(X500Name yakcCert) {
    assertThat(IETFUtils.valueToString(yakcCert.getRDNs(BCStyle.CN)[0].getFirst().getValue()))
      .isEqualTo("com.marcnuri.yakc");
    assertThat(IETFUtils.valueToString(yakcCert.getRDNs(BCStyle.C)[0].getFirst().getValue()))
      .isEqualTo("RU");
    assertThat(IETFUtils.valueToString(yakcCert.getRDNs(BCStyle.ST)[0].getFirst().getValue()))
      .isEqualTo("Kamchatka");
    assertThat(IETFUtils.valueToString(yakcCert.getRDNs(BCStyle.O)[0].getFirst().getValue()))
      .isEqualTo("The Happy Company 1337\\, Inc.");
    assertThat(IETFUtils.valueToString(yakcCert.getRDNs(BCStyle.E)[0].getFirst().getValue()))
      .isEqualTo("yakc@example.com");
  }
}