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

  private final transient Response rawResponse;

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
