/*
 * AlwaysTrustManager.java
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
