package com.marcnuri.yakc.quickstarts.dashboard.watch;

import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.quickstarts.dashboard.deployment.DeploymentService;
import com.marcnuri.yakc.quickstarts.dashboard.events.EventService;
import com.marcnuri.yakc.quickstarts.dashboard.node.NodeService;
import com.marcnuri.yakc.quickstarts.dashboard.pod.PodService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WatchService {

  private final DeploymentService deploymentService;
  private final EventService eventService;
  private final NodeService nodeService;
  private final PodService podService;

  @Inject
  public WatchService(
    DeploymentService deploymentService,
    EventService eventService, NodeService nodeService,
    PodService podService) {
    this.deploymentService = deploymentService;
    this.eventService = eventService;
    this.nodeService = nodeService;
    this.podService = podService;
  }

  public Observable<WatchEvent<? extends Model>> getWatch() throws KubernetesException {
    return Observable.merge(
      eventService.getEvents().subscribeOn(Schedulers.newThread()),
      deploymentService.getDeployments().subscribeOn(Schedulers.newThread()),
      nodeService.getNodes().subscribeOn(Schedulers.newThread()),
      podService.getPods().subscribeOn(Schedulers.newThread())
    );
  }
}
