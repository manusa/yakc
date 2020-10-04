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
 * Created on 2020-09-04, 7:19
 */
package com.marcnuri.yakc.quickstarts.dashboard;

import com.marcnuri.yakc.quickstarts.dashboard.deployment.DeploymentResource;
import com.marcnuri.yakc.quickstarts.dashboard.events.EventResource;
import com.marcnuri.yakc.quickstarts.dashboard.ingresses.IngressResource;
import com.marcnuri.yakc.quickstarts.dashboard.node.NodeResource;
import com.marcnuri.yakc.quickstarts.dashboard.pod.PodResource;
import com.marcnuri.yakc.quickstarts.dashboard.service.ServiceResource;
import com.marcnuri.yakc.quickstarts.dashboard.watch.WatchResource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

@Singleton
public class ApiResource {

  private final DeploymentResource deploymentResource;
  private final EventResource eventResource;
  private final IngressResource ingressResource;
  private final NodeResource nodeResource;
  private final PodResource podResource;
  private final ServiceResource serviceResource;
  private final WatchResource watchResource;

  @Inject
  public ApiResource(
    DeploymentResource deploymentResource,
    EventResource eventResource,
    IngressResource ingressResource,
    NodeResource nodeResource, PodResource podResource,
    ServiceResource serviceResource,
    WatchResource watchResource) {
    this.deploymentResource = deploymentResource;
    this.eventResource = eventResource;
    this.ingressResource = ingressResource;
    this.nodeResource = nodeResource;
    this.podResource = podResource;
    this.serviceResource = serviceResource;
    this.watchResource = watchResource;
  }

  @Path("/deployments")
  public DeploymentResource getDeploymentResource() {
    return deploymentResource;
  }

  @Path("/events")
  public EventResource getEventResource() {
    return eventResource;
  }

  @Path("/ingresses")
  public IngressResource getIngressResource() {
    return ingressResource;
  }

  @Path("/nodes")
  public NodeResource getNodeResource() {
    return nodeResource;
  }

  @Path("/pods")
  public PodResource getPodResource() {
    return podResource;
  }

  @Path("/services")
  public ServiceResource getServiceResource() {
    return serviceResource;
  }

  @Path("/watch")
  public WatchResource getWatchResource() {
    return watchResource;
  }
}
