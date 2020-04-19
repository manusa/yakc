/*
 * Kubernetes.java
 *
 * Created on 2020-04-13, 7:33
 */
package com.marcnuri.yakc.api;

import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marc Nuri on 2020-04-13.
 */
public class KubernetesException extends IOException {

  private static final Map<Integer, Class<? extends KubernetesException>> EXCEPTIONS = new HashMap<>();
  static {
    EXCEPTIONS.put(404, NotFoundException.class);
  }

  private final Response rawResponse;

  public KubernetesException(String message, Response rawResponse) {
    super(message);
    this.rawResponse = rawResponse;
  }

  public int getCode() {
    return rawResponse.code();
  }

  public static KubernetesException forResponse(String message, Response rawResponse) {
    final int statusCode = rawResponse.code();
    if (EXCEPTIONS.containsKey(rawResponse.code())) {
      try {
        return EXCEPTIONS.get(rawResponse.code()).getConstructor(String.class, Response.class)
            .newInstance(message, rawResponse);
      } catch (ReflectiveOperationException e) {
        throw new IllegalArgumentException("Problem when generating KuberentesException", e);
      }
    }
    if (statusCode >= 400 && statusCode <500) {
      return new ClientErrorException(message, rawResponse);
    }
    return new KubernetesException(message, rawResponse);
  }
}
