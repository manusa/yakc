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
 * Created on 2020-11-08, 8:13
 */
package com.marcnuri.yakc.quickstarts.dashboard.watch;

import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.model.Model;
import io.reactivex.Observable;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.time.Duration;
import java.util.Arrays;

public interface Watchable<T extends Model> {

  /**
   * TODO: Document better
   *
   * <p> If an Empty Optional is returned, the subscription will not be retried.
   *
   * @return an Optional of an Observable WatchEvent
   * @throws IOException if there are IO problems when opening the watch
   */
  Observable<WatchEvent<T>> watch() throws IOException;

  default String getType() {
    return Arrays.stream(getClass().getGenericInterfaces())
      .filter(ParameterizedType.class::isInstance)
      .map(ParameterizedType.class::cast)
      .map(pt -> pt.getActualTypeArguments()[0])
      .map(Class.class::cast)
      .map(Class::getSimpleName)
      .findFirst()
      .orElse("");
  }

  /**
   * Should the watch subscription be retried in case of failure.
   *
   * <p> Defaults to {@code true}. Override in case the watch subscription
   * shouldn't be retried in case of failure (e.g. we know that specific
   * resource won't ever be available in this cluster).
   *
   * @return true if the watch subscription should be retried.
   */
  default boolean isRetrySubscription() {
    return true;
  }

  default Duration getRetrySubscriptionDelay() {
    return Duration.ofSeconds(30);
  }

  default Duration getSelfHealingDelay() {
    return Duration.ofSeconds(5);
  }

  /**
   * Is the current resource available in the cluster.
   *
   * @return true if the resource API is available in the cluster.
   */
  default boolean isAvailable() {
    return true;
  }
}
