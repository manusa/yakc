/*
 * ClientErrorException.java
 *
 * Created on 2020-04-13, 7:41
 */
package com.marcnuri.yakc.api;

import okhttp3.Response;

/**
 * Created by Marc Nuri on 2020-04-13.
 */
public class ClientErrorException extends KubernetesException {

  public ClientErrorException(String message, Response rawResponse) {
    super(message, rawResponse);
  }
}
