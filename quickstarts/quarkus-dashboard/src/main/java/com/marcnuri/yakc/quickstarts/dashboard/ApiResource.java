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

import com.marcnuri.yakc.quickstarts.dashboard.clusterroles.ClusterRoleResource;
import com.marcnuri.yakc.quickstarts.dashboard.configmaps.ConfigMapResource;
import com.marcnuri.yakc.quickstarts.dashboard.deployment.DeploymentResource;
import com.marcnuri.yakc.quickstarts.dashboard.events.EventResource;
import com.marcnuri.yakc.quickstarts.dashboard.ingresses.IngressResource;
import com.marcnuri.yakc.quickstarts.dashboard.namespaces.NamespaceResource;
import com.marcnuri.yakc.quickstarts.dashboard.node.NodeResource;
import com.marcnuri.yakc.quickstarts.dashboard.persistentvolumeclaims.PersistentVolumeClaimResource;
import com.marcnuri.yakc.quickstarts.dashboard.persistentvolumes.PersistentVolumeResource;
import com.marcnuri.yakc.quickstarts.dashboard.pod.PodResource;
import com.marcnuri.yakc.quickstarts.dashboard.replicaset.ReplicaSetResource;
import com.marcnuri.yakc.quickstarts.dashboard.roles.RoleResource;
import com.marcnuri.yakc.quickstarts.dashboard.secrets.SecretResource;
import com.marcnuri.yakc.quickstarts.dashboard.service.ServiceResource;
import com.marcnuri.yakc.quickstarts.dashboard.statefulsets.StatefulSetResource;
import com.marcnuri.yakc.quickstarts.dashboard.watch.WatchResource;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

@Singleton
@RegisterForReflection // Quarkus doesn't generate constructors for JAX-RS Subresources
public class ApiResource {

  private final ClusterRoleResource clusterRoleResource;
  private final ConfigMapResource configMapResource;
  private final DeploymentResource deploymentResource;
  private final EventResource eventResource;
  private final IngressResource ingressResource;
  private final NamespaceResource namespaceResource;
  private final NodeResource nodeResource;
  private final PersistentVolumeClaimResource persistentVolumeClaimResource;
  private final PersistentVolumeResource persistentVolumeResource;
  private final PodResource podResource;
  private final ReplicaSetResource replicaSetResource;
  private final RoleResource roleResource;
  private final SecretResource secretResource;
  private final ServiceResource serviceResource;
  private final StatefulSetResource statefulSetResource;
  private final WatchResource watchResource;

  @SuppressWarnings("java:S107")
  @Inject
  public ApiResource(
    ClusterRoleResource clusterRoleResource,
    ConfigMapResource configMapResource,
    DeploymentResource deploymentResource,
    EventResource eventResource,
    IngressResource ingressResource,
    NamespaceResource namespaceResource,
    NodeResource nodeResource,
    PersistentVolumeClaimResource persistentVolumeClaimResource,
    PersistentVolumeResource persistentVolumeResource,
    PodResource podResource,
    ReplicaSetResource replicaSetResource,
    RoleResource roleResource,
    SecretResource secretResource,
    ServiceResource serviceResource,
    StatefulSetResource statefulSetResource,
    WatchResource watchResource) {
    this.clusterRoleResource = clusterRoleResource;
    this.configMapResource = configMapResource;
    this.deploymentResource = deploymentResource;
    this.eventResource = eventResource;
    this.ingressResource = ingressResource;
    this.namespaceResource = namespaceResource;
    this.nodeResource = nodeResource;
    this.persistentVolumeClaimResource = persistentVolumeClaimResource;
    this.persistentVolumeResource = persistentVolumeResource;
    this.podResource = podResource;
    this.replicaSetResource = replicaSetResource;
    this.roleResource = roleResource;
    this.secretResource = secretResource;
    this.serviceResource = serviceResource;
    this.statefulSetResource = statefulSetResource;
    this.watchResource = watchResource;
  }

  @Path("/clusterroles")
  public ClusterRoleResource getClusterRoleResource() {
    return clusterRoleResource;
  }

  @Path("/configmaps")
  public ConfigMapResource getConfigMapResource() {
    return configMapResource;
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

  @Path("/namespaces")
  public NamespaceResource getNamespaceResource() {
    return namespaceResource;
  }

  @Path("/nodes")
  public NodeResource getNodeResource() {
    return nodeResource;
  }

  @Path("/persistentvolumeclaims")
  public PersistentVolumeClaimResource getPer() {
    return persistentVolumeClaimResource;
  }

  @Path("/persistentvolumes")
  public PersistentVolumeResource getPersistentVolumeResource() {
    return persistentVolumeResource;
  }

  @Path("/pods")
  public PodResource getPodResource() {
    return podResource;
  }

  @Path("/replicasets")
  public ReplicaSetResource getReplicaSetResource() {
    return replicaSetResource;
  }

  @Path("/roles")
  public RoleResource getRoleResource() {
    return roleResource;
  }

  @Path("/secrets")
  public SecretResource getSecretResource() {
    return secretResource;
  }

  @Path("/services")
  public ServiceResource getServiceResource() {
    return serviceResource;
  }

  @Path("/statefulsets")
  public StatefulSetResource getStatefulSetResource() {
    return statefulSetResource;
  }

  @Path("/watch")
  public WatchResource getWatchResource() {
    return watchResource;
  }
}
