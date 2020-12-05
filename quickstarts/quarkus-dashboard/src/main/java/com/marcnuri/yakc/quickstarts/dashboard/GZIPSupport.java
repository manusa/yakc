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
 * Created on 2020-12-05, 10:00
 */
package com.marcnuri.yakc.quickstarts.dashboard;

import io.vertx.core.http.HttpServerRequest;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.zip.GZIPOutputStream;

/**
 * https://github.com/quarkusio/quarkus/issues/9671#issuecomment-704050467
 * Custom gzip support, workaround for https://github.com/quarkusio/quarkus/issues/9671
 *
 * NB: must be deleted when quarkus will have proper gzip support.
 *
 */
@Provider
public class GZIPSupport implements WriterInterceptor {

  @Context
  HttpServerRequest request;

  private boolean isGZIPSupported() {
    return Optional.ofNullable(request)
      .map(r -> r.getHeader(HttpHeaders.ACCEPT_ENCODING))
      .map(s -> s.split(","))
      .map(encodings -> Arrays.stream(encodings).anyMatch("gzip"::equals))
      .orElse(false);
  }

  @Override
  public void aroundWriteTo(WriterInterceptorContext context) throws IOException {
    if (isGZIPSupported()) {
      MultivaluedMap<String, Object> headers = context.getHeaders();
      headers.add(HttpHeaders.CONTENT_ENCODING, "gzip");
      OutputStream outputStream = context.getOutputStream();
      context.setOutputStream(new GZIPOutputStream(outputStream));
    }
    context.proceed();
  }
}
