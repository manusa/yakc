/*
 * SSLResolver.java
 *
 * Created on 2020-04-17, 5:47
 */
package com.marcnuri.yakc.ssl;

import com.marcnuri.yakc.config.Configuration;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import static okio.ByteString.decodeBase64;

/**
 * Created by Marc Nuri on 2020-04-17.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SSLResolver {

  public static final String TLS_V_1_2 = "TLSv1.2";
  private static final String JKS_TYPE = "JKS";
  private static final String X509_TYPE = "X509";
  private static final String RSA_ALGO = "RSA";
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
        || isNotNullOrEmpty(configuration.getClientCertificateData());
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
      final X509Certificate cert = (X509Certificate) certFactory.generateCertificate(certIS);
      final KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGO);
      final byte[] decodedPem = new PemReader(keyISR).readPemObject().getContent();
      final PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decodedPem);
      final PrivateKey privateKey = keyFactory.generatePrivate(spec);
      final KeyStore keyStore = KeyStore.getInstance("JKS");
      keyStore.load(javaIS, DEFAULT_JAVA_TRUSTSTORE_P455W0RD.toCharArray());
      final String alias = cert.getSubjectX500Principal().getName();
      keyStore.setKeyEntry(alias, privateKey, DEFAULT_JAVA_TRUSTSTORE_P455W0RD.toCharArray(), new Certificate[]{cert});
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
      trustStore.load(javaTrustStoreIS, DEFAULT_JAVA_TRUSTSTORE_P455W0RD.toCharArray());
      if (hasCertificateAuthority(configuration)) {
        CertificateFactory certFactory = CertificateFactory.getInstance(X509_TYPE);
        final X509Certificate caCert = (X509Certificate)certFactory.generateCertificate(caIS);
        trustStore.setCertificateEntry(caCert.getSubjectX500Principal().getName(), caCert);
      }
    }
    return trustStore;
  }

  private static InputStream loadJavaTrustStore() throws IOException {
    final File javaTrustStore = new File(System.getProperty("java.home")).toPath()
        .resolve("lib").resolve("security").resolve("cacerts").toFile();
    if (javaTrustStore.exists() && javaTrustStore.length() > 0) {
      return new FileInputStream(javaTrustStore);
    }
    throw new IOException(
        String.format("Java System trust store was not found: '%s'", javaTrustStore.getAbsolutePath()));
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
