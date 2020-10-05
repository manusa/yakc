/*
 * ClientUtil.java
 *
 * Created on 2020-10-05, 19:28
 */
package com.marcnuri.yakc.quickstarts.dashboard;


import com.marcnuri.yakc.api.ClientErrorException;

import java.io.IOException;

/**
 * Created by Marc Nuri on 2020-10-05.
 */
public class ClientUtil {

  @SafeVarargs
  public static <T> T tryWithFallback(RetryFunction<T>... functions) throws IOException {
    IOException exception = new IOException(
      "This exception should be replaced if caught and finally thrown");
    for(RetryFunction<T> func : functions) {
      try {
        return func.call();
      } catch(ClientErrorException ex) {
        exception = ex;
      }
    }
    throw exception;
  }

  @FunctionalInterface
  public interface RetryFunction<T> {
    T call() throws IOException;
  }
}
