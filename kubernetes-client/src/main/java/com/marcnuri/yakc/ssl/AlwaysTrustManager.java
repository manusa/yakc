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
 * Created on 2020-04-17, 5:45
 */
package com.marcnuri.yakc.ssl;

import javax.net.ssl.X509TrustManager;

import java.security.cert.X509Certificate;

/**
 * Created by Marc Nuri on 2020-04-17.
 */
@SuppressWarnings({"squid:S1168", "squid:S4424"})
public class AlwaysTrustManager implements X509TrustManager {

  @Override
  public void checkClientTrusted(X509Certificate[] xcs, String string) {
    // All clients trusted, no exceptions thrown
  }

  @Override
  public void checkServerTrusted(X509Certificate[] xcs, String string) {
    // All servers trusted, no exceptions thrown
  }

  @Override
  public X509Certificate[] getAcceptedIssuers() {
    return null;
  }
}
