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
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-18.
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