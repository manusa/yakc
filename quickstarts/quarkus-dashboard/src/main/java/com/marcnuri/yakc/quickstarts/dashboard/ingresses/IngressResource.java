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
 * Created on 2020-10-04, 7:43
 */
package com.marcnuri.yakc.quickstarts.dashboard.ingresses;


import com.marcnuri.yakc.model.io.k8s.api.networking.v1.Ingress;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

@Singleton
public class IngressResource {

  private final IngressService ingressService;

  @Inject
  public IngressResource(IngressService ingressService) {
    this.ingressService = ingressService;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Ingress> get() throws IOException {
    return ingressService.get();
  }
  @DELETE
  @Path("/{namespace}/{name}")
  public Response delete(@PathParam("namespace") String namespace, @PathParam("name") String name)
    throws IOException {

    ingressService.deleteIngress(name, namespace);
    return Response.noContent().build();
  }
}
