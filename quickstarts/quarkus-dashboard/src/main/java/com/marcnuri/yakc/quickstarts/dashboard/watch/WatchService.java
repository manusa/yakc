package com.marcnuri.yakc.quickstarts.dashboard.watch;

import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.quickstarts.dashboard.deployment.DeploymentService;
import com.marcnuri.yakc.quickstarts.dashboard.events.EventService;
import com.marcnuri.yakc.quickstarts.dashboard.node.NodeService;
import com.marcnuri.yakc.quickstarts.dashboard.pod.PodService;
import com.marcnuri.yakc.quickstarts.dashboard.replicaset.ReplicaSetService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Singleton
public class WatchService {

  private static final Logger LOG = LoggerFactory.getLogger(WatchService.class);

  private final DeploymentService deploymentService;
  private final EventService eventService;
  private final NodeService nodeService;
  private final PodService podService;
  private final ReplicaSetService replicaSetService;

  @Inject
  public WatchService(
    DeploymentService deploymentService,
    EventService eventService, NodeService nodeService,
    PodService podService,
    ReplicaSetService replicaSetService) {
    this.deploymentService = deploymentService;
    this.eventService = eventService;
    this.nodeService = nodeService;
    this.podService = podService;
    this.replicaSetService = replicaSetService;
  }

  public Observable<WatchEvent<? extends Model>> getWatch() throws KubernetesException {
    return Observable.merge(Arrays.asList(
      eventService.getEvents().subscribeOn(Schedulers.newThread()),
      deploymentService.getDeployments().subscribeOn(Schedulers.newThread()),
      nodeService.getNodes().subscribeOn(Schedulers.newThread()),
      podService.getPods().subscribeOn(Schedulers.newThread()),
      replicaSetService.getReplicaSets().subscribeOn(Schedulers.newThread())
    )).doOnError(e -> LOG.error("Exception on Watcher", e));
  }
}
