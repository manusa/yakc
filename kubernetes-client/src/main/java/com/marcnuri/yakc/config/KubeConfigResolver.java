/*
 * KubeConfigResolver.java
 *
 * Created on 2020-04-13, 19:01
 */
package com.marcnuri.yakc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.marcnuri.yakc.config.KubeConfig.AuthInfo;
import com.marcnuri.yakc.config.KubeConfig.Cluster;
import com.marcnuri.yakc.config.KubeConfig.Context;
import com.marcnuri.yakc.config.KubeConfig.NamedAuthInfo;
import com.marcnuri.yakc.config.KubeConfig.NamedCluster;
import com.marcnuri.yakc.config.KubeConfig.NamedContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by Marc Nuri on 2020-04-13.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KubeConfigResolver {

  public static Configuration resolveKubeConfig() throws IOException {
    final Path kubeConfigPath = new File(System.getProperty("user.home")).toPath().resolve(".kube").resolve("config");
    final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    if (kubeConfigPath.toFile().exists()) {
      final KubeConfig kubeConfig = objectMapper.readValue(kubeConfigPath.toFile(), KubeConfig.class);
      final Optional<Context> context = getCurrentContext(kubeConfig).map(NamedContext::getContext);
      final Optional<Cluster> cluster = getCurrentCluster(kubeConfig).map(NamedCluster::getCluster);
      final Optional<AuthInfo> authInfo = getCurrentAuthInfo(kubeConfig).map(NamedAuthInfo::getUser);
      return Configuration.builder()
          .server(cluster.map(Cluster::getServer).orElse(null))
          .namespace(context.map(Context::getNamespace).orElse(null))
          .insecureSkipTlsVerify(cluster.map(Cluster::getInsecureSkipTlsVerify).orElse(false))
          .certificateAuthorityData(cluster.map(Cluster::getCertificateAuthorityData).orElse(null))
          .certificateAuthority(cluster.map(Cluster::getCertificateAuthority).map(File::new).filter(File::exists).orElse(null))
          .clientCertificateData(authInfo.map(AuthInfo::getClientCertificateData).orElse(null))
          .clientCertificate(authInfo.map(AuthInfo::getClientCertificate).map(File::new).filter(File::exists).orElse(null))
          .clientKeyData(authInfo.map(AuthInfo::getClientKeyData).orElse(null))
          .clientKey(authInfo.map(AuthInfo::getClientKey).map(File::new).filter(File::exists).orElse(null))
          .username(authInfo.map(AuthInfo::getUsername).orElse(null))
          .password(authInfo.map(AuthInfo::getPassword).orElse(null))
          .token(authInfo.map(AuthInfo::getToken).orElse(null))
          .build();
    }
    return Configuration.builder().build();
  }

  private static Optional<NamedContext> getCurrentContext(KubeConfig kubeConfig) {
    return Optional.ofNullable(kubeConfig)
        .map(KubeConfig::getContexts)
        .orElse(Collections.emptyList()).stream()
        .filter(c -> c.getName().equals(kubeConfig.getCurrentContext()))
        .findFirst();
  }

  private static Optional<NamedCluster> getCurrentCluster(KubeConfig kubeConfig) {
    final String currentCluster = getCurrentContext(kubeConfig)
        .map(NamedContext::getContext).map(Context::getCluster).orElse(null);
    if (currentCluster != null) {
      return Optional.ofNullable(kubeConfig.getClusters())
          .orElse(Collections.emptyList()).stream()
          .filter(c -> c.getName().equals(currentCluster))
          .findFirst();
    }
    return Optional.empty();
  }

  private static Optional<NamedAuthInfo> getCurrentAuthInfo(KubeConfig kubeConfig) {
    final String currentUser = getCurrentContext(kubeConfig)
        .map(NamedContext::getContext).map(Context::getUser).orElse(null);
    if (currentUser != null) {
      return Optional.ofNullable(kubeConfig.getUsers())
          .orElse(Collections.emptyList()).stream()
          .filter(c -> c.getName().equals(currentUser))
          .findFirst();
    }
    return Optional.empty();
  }
}
