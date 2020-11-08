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
 */
package com.marcnuri.yakc.quickstarts.dashboard.watch;

import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.quickstarts.dashboard.clusterroles.ClusterRoleService;
import com.marcnuri.yakc.quickstarts.dashboard.configmaps.ConfigMapService;
import com.marcnuri.yakc.quickstarts.dashboard.deployment.DeploymentService;
import com.marcnuri.yakc.quickstarts.dashboard.events.EventService;
import com.marcnuri.yakc.quickstarts.dashboard.node.NodeService;
import com.marcnuri.yakc.quickstarts.dashboard.pod.PodService;
import com.marcnuri.yakc.quickstarts.dashboard.replicaset.ReplicaSetService;
import com.marcnuri.yakc.quickstarts.dashboard.roles.RoleService;
import com.marcnuri.yakc.quickstarts.dashboard.secrets.SecretService;
import com.marcnuri.yakc.quickstarts.dashboard.service.ServiceService;
import com.marcnuri.yakc.quickstarts.dashboard.statefulsets.StatefulSetService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class WatchService {

  private static final Logger LOG = LoggerFactory.getLogger(WatchService.class);

  private final List<Watchable<? extends Model>> watchables;

  @SuppressWarnings("java:S107")
  @Inject
  public WatchService(
    ClusterRoleService clusterRoleService,
    ConfigMapService configMapService,
    DeploymentService deploymentService,
    EventService eventService, NodeService nodeService,
    PodService podService,
    ReplicaSetService replicaSetService,
    RoleService roleService,
    SecretService secretService,
    ServiceService serviceService,
    StatefulSetService statefulSetService) {
    this.watchables = Arrays.asList(
      clusterRoleService,
      configMapService,
      deploymentService,
      eventService,
      nodeService,
      podService,
      replicaSetService,
      roleService,
      secretService,
      serviceService,
      statefulSetService
    );
  }

  public Observable<WatchEvent<? extends Model>> getWatch() throws IOException {
    final List<Observable<? extends WatchEvent<? extends Model>>> watchers = new ArrayList<>();
    for (Watchable<? extends Model> watchable : watchables) {
      watchers.add(watchable.watch().subscribeOn(Schedulers.newThread()));
    }
    return Observable.merge(watchers)
      .doOnError(e -> LOG.error("Exception on Watcher", e))
      .onErrorReturn(DashboardError::watchEvent);
  }
}
