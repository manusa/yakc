/*
 * ClientUtil.java
 *
 * Created on 2020-10-05, 19:28
 */
package com.marcnuri.yakc.quickstarts.dashboard;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.quickstarts.dashboard.watch.RequestRestartError;
import com.marcnuri.yakc.quickstarts.dashboard.watch.Watchable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.ForbiddenException;

/**
 * Created by Marc Nuri on 2020-10-05.
 */
public class ClientUtil {

  private static final Logger LOG = LoggerFactory.getLogger(ClientUtil.class);

  private static final long OBSERVABLE_HEAL_DELAY_SECONDS = 5L;

  @SafeVarargs
  public static <T> T tryWithFallback(ClientFunction<T>... functions) throws IOException {
    IOException exception = new IOException(
      "This exception should be replaced if caught and finally thrown");
    for (ClientFunction<T> func : functions) {
      try {
        return func.call();
      } catch (ClientErrorException ex) {
        exception = ex;
      } catch (IllegalArgumentException invalidRetrofitCallSuchAsNullNamespace) {
        // TODO: improve overall behavior
      }
    }
    throw exception;
  }

  public static <T> T ignoreForbidden(ClientFunction<T> function, T defaultIfForbidden) throws IOException {
    try {
      return function.call();
    } catch (ForbiddenException ex) {
      LOG.debug("Access to resource is forbidden, ignoring:\n{}", ex.getMessage());
      return defaultIfForbidden;
    }
  }

  public static Observable<WatchEvent<? extends Model>> selfHealingObservable(Watchable<? extends Model> watchable) {
    return Observable.create(emitter -> {
      try {
        subscribe(emitter, watchable);
      } catch (Exception ex) {
        LOG.error("Error when starting subscription for {}", watchable.getClass(), ex);
        emitter.onComplete();
      }
    });
  }

  private static void subscribe(
    ObservableEmitter<WatchEvent<? extends Model>> selfHealingEmitter, Watchable<? extends Model> watchable)
    throws IOException {
    watchable.watch().ifPresent(watch -> watch.subscribe(
      selfHealingEmitter::onNext,
      error -> {
        LOG.error("Subscription error for watchable {}: {}", watchable.getClass(), error.getMessage());
        TimeUnit.SECONDS.sleep(OBSERVABLE_HEAL_DELAY_SECONDS);
        selfHealingEmitter.onNext(new WatchEvent<>(WatchEvent.Type.ERROR, new RequestRestartError(watchable, error)));
        subscribe(selfHealingEmitter, watchable);
      },
      () -> {
        LOG.warn("Subscription complete for watchable {}, reconnecting...", watchable.getClass());
        TimeUnit.SECONDS.sleep(OBSERVABLE_HEAL_DELAY_SECONDS);
        selfHealingEmitter.onNext(new WatchEvent<>(WatchEvent.Type.ERROR, new RequestRestartError(watchable, null)));
        subscribe(selfHealingEmitter, watchable);
      }
    ));
  }

  @FunctionalInterface
  public interface ClientFunction<T> {
    T call() throws IOException;
  }
}
