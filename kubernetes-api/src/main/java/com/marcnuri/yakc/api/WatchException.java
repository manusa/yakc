/*
 * WatchException.java
 *
 * Created on 2020-04-13, 16:17
 */
package com.marcnuri.yakc.api;

import okhttp3.Response;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-13.
 */
public class WatchException extends KubernetesException {

  public WatchException(String message, Response rawResponse) {
    super(message, rawResponse);
  }
}
