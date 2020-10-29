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
 * Created on 2020-04-17, 5:47
 */
package com.marcnuri.yakc.ssl;

import com.marcnuri.yakc.config.Configuration;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.auth.x500.X500Principal;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static okio.ByteString.decodeBase64;

@Log
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SSLResolver {

  public static final String TLS_V_1_2 = "TLSv1.2";
  private static final String JKS_TYPE = "JKS";
  private static final String X509_TYPE = "X509";
  private static final String DEFAULT_JAVA_TRUSTSTORE_P455W0RD = "changeit";

  public static boolean isTrustAllCertificates(Configuration configuration) {
    return configuration.isInsecureSkipTlsVerify();
  }

  public static boolean hasCertificateAuthority(Configuration configuration) {
    return configuration.getCertificateAuthority() != null
        || isNotNullOrEmpty(configuration.getCertificateAuthorityData());
  }

  public static boolean hasClientCertificate(Configuration configuration) {
    boolean hasCert = configuration.getClientCertificate() != null
        || isNotNullOrEmpty(configuration.getClientCertificateData());
    boolean hasKey = configuration.getClientKey() != null
        || isNotNullOrEmpty(configuration.getClientKeyData());
    return hasCert && hasKey;
  }

  public static TrustManager[] trustManagers(Configuration configuration)
      throws IOException, GeneralSecurityException {

    if (isTrustAllCertificates(configuration)) {
      return new TrustManager[]{new AlwaysTrustManager()};
    }
    TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    tmf.init(initTrustStore(configuration));
    return tmf.getTrustManagers();
  }

  public static KeyManager[] keyManagers(Configuration configuration)
      throws IOException, GeneralSecurityException {
    CertificateFactory certFactory = CertificateFactory.getInstance(X509_TYPE);
    final KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    try (
        final InputStream certIS = certInputStream(configuration.getClientCertificateData(), configuration.getClientCertificate());
        final InputStreamReader keyISR = new InputStreamReader(certInputStream(configuration.getClientKeyData(), configuration.getClientKey()));
        final InputStream javaIS = loadJavaTrustStore()
    ) {
      Security.addProvider(new BouncyCastleProvider());
      final Collection<? extends Certificate> certs = certFactory.generateCertificates(certIS);
      final KeyStore keyStore = KeyStore.getInstance("JKS");
      if (javaIS != null) {
        keyStore.load(javaIS, DEFAULT_JAVA_TRUSTSTORE_P455W0RD.toCharArray());
      } else {
        keyStore.load(null);
      }
      final String alias = certs.stream()
        .map(X509Certificate.class::cast)
        .map(X509Certificate::getIssuerX500Principal)
        .map(X500Principal::getName)
        .collect(Collectors.joining("_"));
      keyStore.setKeyEntry(alias, decodePrivateKey(keyISR), DEFAULT_JAVA_TRUSTSTORE_P455W0RD.toCharArray(),
        certs.toArray(new Certificate[0]));
      kmf.init(keyStore, DEFAULT_JAVA_TRUSTSTORE_P455W0RD.toCharArray());
    }
    return kmf.getKeyManagers();
  }

  private static KeyStore initTrustStore(Configuration configuration) throws IOException, GeneralSecurityException {
    final KeyStore trustStore = KeyStore.getInstance(JKS_TYPE);
    try (
        InputStream caIS = certInputStream(configuration.getCertificateAuthorityData(), configuration.getCertificateAuthority());
        InputStream javaTrustStoreIS = loadJavaTrustStore()
    ) {
      if (javaTrustStoreIS != null) {
        trustStore.load(javaTrustStoreIS, DEFAULT_JAVA_TRUSTSTORE_P455W0RD.toCharArray());
      } else {
        trustStore.load(null);
      }
      if (hasCertificateAuthority(configuration)) {
        CertificateFactory certFactory = CertificateFactory.getInstance(X509_TYPE);
        final X509Certificate caCert = (X509Certificate)certFactory.generateCertificate(caIS);
        trustStore.setCertificateEntry(caCert.getSubjectX500Principal().getName(), caCert);
      }
    }
    return trustStore;
  }

  private static InputStream loadJavaTrustStore() throws IOException {
    final File javaTrustStore = Optional.ofNullable(System.getProperty("java.home"))
      .map(File::new)
      .map(f -> f.toPath().resolve("lib").resolve("security").resolve("cacerts").toFile())
      .filter(File::exists)
      .filter(f -> f.length() > 0)
      .orElse(null);
    if (javaTrustStore != null) {
      return new FileInputStream(javaTrustStore);
    }
    log.warning("Java System trust store was not found");
    return null;
  }

  private static PrivateKey decodePrivateKey(InputStreamReader keyISR) throws IOException {
    PrivateKey privateKey;
    final Object readKey = new PEMParser(keyISR).readObject();
    final JcaPEMKeyConverter jcaConverter = new JcaPEMKeyConverter();
    if (readKey instanceof PEMKeyPair) {
      privateKey = jcaConverter.getPrivateKey(((PEMKeyPair)readKey).getPrivateKeyInfo());
    } else if (readKey instanceof PrivateKeyInfo) {
      privateKey = jcaConverter.getPrivateKey(((PrivateKeyInfo)readKey));
    } else {
      throw new IOException("Invalid private key");
    }
    return privateKey;
  }

  private static InputStream certInputStream(String certData, File certFile) throws IOException {
    return Optional.ofNullable(certInputStream(certData)).orElse(certInputStream(certFile));
  }

  private static InputStream certInputStream(String certData) {
    if (!isNotNullOrEmpty(certData)) {
      return null;
    }
    return new ByteArrayInputStream(Objects.requireNonNull(decodeBase64(certData)).toByteArray());
  }

  private static boolean isNotNullOrEmpty(String string) {
    return Optional.ofNullable(string)
        .filter(((Predicate<String>)String::isEmpty).negate())
        .isPresent();
  }

  private static InputStream certInputStream(File certFile) throws IOException {
    return certFile == null ? null : new FileInputStream(certFile);
  }

}
