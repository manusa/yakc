/*
 * TestClient.java
 *
 * Created on 2020-04-05, 19:15
 */
package com.marcnuri.yakc.test;

import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodList;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public interface TestClient {

  @RequestLine("GET /api/v1/namespaces/{namespace}/pods")
  @Headers({
      "Accept: */*",
  })
  PodList getPods(@Param("namespace")String namespace);
}
