package com.marcnuri.yakc.quickstarts.dashboard.watch;

import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.model.Model;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.converters.multi.MultiRxConverters;
import org.jboss.resteasy.annotations.SseElementType;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
public class WatchResource {

  private WatchService watchService;

  @Inject
  public WatchResource(WatchService watchService) {
    this.watchService = watchService;
  }

  @GET
  @Produces(MediaType.SERVER_SENT_EVENTS)
  @SseElementType(MediaType.APPLICATION_JSON)
  public Multi<WatchEvent<? extends Model>> get() throws KubernetesException {
    return Multi.createFrom().converter(MultiRxConverters.fromObservable(),
      watchService.getWatch());
  }
}
