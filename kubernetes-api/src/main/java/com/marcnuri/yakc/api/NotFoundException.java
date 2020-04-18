/*
 * NotFoundException.java
 *
 * Created on 2020-04-13, 7:41
 */
package com.marcnuri.yakc.api;

import okhttp3.Response;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-13.
 */
public class NotFoundException extends ClientErrorException {

  public NotFoundException(String message, Response rawResponse) {
    super(message, rawResponse);
  }
}
