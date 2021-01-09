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
 * Created on 2020-04-13, 19:01
 */
package com.marcnuri.yakc.config;

import com.marcnuri.yakc.config.KubeConfig.AuthInfo;
import com.marcnuri.yakc.config.KubeConfig.Cluster;
import com.marcnuri.yakc.config.KubeConfig.Context;
import com.marcnuri.yakc.config.KubeConfig.NamedCluster;
import com.marcnuri.yakc.config.KubeConfig.NamedContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationResolver {

  private static final String SA_TOKEN_POD_FILE = "/var/run/secrets/kubernetes.io/serviceaccount/token";
  private static final String NAMESPACE_POD_FILE = "/var/run/secrets/kubernetes.io/serviceaccount/namespace";
  private static final String CA_POD_FILE = "/var/run/secrets/kubernetes.io/serviceaccount/ca.crt";

  public static Configuration resolveConfig() throws IOException {
    if (new File(SA_TOKEN_POD_FILE).exists()) {
      return resolvePodConfig();
    }
    return resolveKubeConfig();
  }

  @SuppressWarnings("WeakerAccess")
  public static Configuration resolvePodConfig() throws IOException {
    final Configuration.ConfigurationBuilder cb = Configuration.builder();
    cb.server("https://kubernetes.default.svc");
    cb.certificateAuthority(new File(CA_POD_FILE));
    cb.token(() -> readFile(new File(SA_TOKEN_POD_FILE)));
    cb.namespace(readFile(new File(NAMESPACE_POD_FILE)));
    return cb.build();
  }

  /**
   * Resolves {@link Configuration} values from "~/.kube/config" current-context. It returns an
   * empty configuration if file doesn't exist.
   *
   * @return the resolved Configuration with values from KubeConfig file empty Configuration if it doesn't exist.
   * @throws IOException if a problem occurred while reading the config file.
   */
  @SuppressWarnings("WeakerAccess")
  public static Configuration resolveKubeConfig() throws IOException {
    final KubeConfigResolver kcResolver = new KubeConfigResolver();
    if (kcResolver.getKubeConfig().isPresent()) {
      final Optional<Context> context = kcResolver.getCurrentContext().map(NamedContext::getContext);
      final Optional<Cluster> cluster = kcResolver.getCurrentCluster().map(NamedCluster::getCluster);
      final Optional<AuthInfo> authInfo = kcResolver.getCurrentAuthInfo();
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
          .username(() -> kcResolver.getCurrentAuthInfo().map(AuthInfo::getUsername).orElse(null))
          .password(() -> kcResolver.getCurrentAuthInfo().map(AuthInfo::getUsername).orElse(null))
          .token(() -> kcResolver.getCurrentAuthInfo().map(AuthInfo::getToken).orElse(null))
          .build();
    }
    return Configuration.builder().build();
  }

  private static String readFile(File file) throws IOException {
    if (file.exists() && file.isFile()) {
      return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8).trim()
        .replace("\n", "").replace("\r", "");
    }
    return null;
  }
}
