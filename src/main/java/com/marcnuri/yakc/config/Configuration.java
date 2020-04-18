/*
 * Configuration.java
 *
 * Created on 2020-04-11, 12:44
 */
package com.marcnuri.yakc.config;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.time.Duration;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-11.
 */
@Builder(toBuilder = true)
@Data
public class Configuration {
  private String server;
  private String namespace;
  private boolean insecureSkipTlsVerify;
  private String certificateAuthorityData;
  private File certificateAuthority;
  private String clientCertificateData;
  private File clientCertificate;
  private String clientKeyData;
  private File clientKey;
  private String token;
  private String username;
  private String password;
  private Duration connectTimeout;
  private Duration readTimeout;
}
