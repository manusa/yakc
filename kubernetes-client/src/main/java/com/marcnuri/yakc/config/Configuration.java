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
 * Created on 2020-04-11, 12:44
 */
package com.marcnuri.yakc.config;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.time.Duration;

/**
 * Created by Marc Nuri on 2020-04-11.
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
