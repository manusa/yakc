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
 * Created on 2021-12-11, 17:43
 */
package com.marcnuri.yakc.quickstarts.dashboard;

import com.marcnuri.yakc.api.ForbiddenException;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class ApiChecker {

  private static final int CHECK_INTERVAL_SECONDS = 30;

  private final Supplier<KubernetesCall<APIResourceList>> apiCheckFunction;
  private LocalDateTime lastCheck;
  private volatile boolean available;
  private volatile boolean forbidden;

  public ApiChecker(Supplier<KubernetesCall<APIResourceList>> apiCheckFunction) {
    this.apiCheckFunction = apiCheckFunction;
  }

  private synchronized void check() {
    if (lastCheck == null || Duration.between(lastCheck, LocalDateTime.now()).toSeconds() > CHECK_INTERVAL_SECONDS) {
      lastCheck = LocalDateTime.now();
      try {
        apiCheckFunction.get().get();
        available = true;
      } catch (NotFoundException e) {
        available = false;
      } catch (ForbiddenException e) {
        available = false;
        forbidden = true;
      } catch (IOException e) {
        // Ignore until next call
      }
    }
  }

  public boolean isAvailable() {
    check();
    return available;
  }

  public boolean isForbidden() {
    check();
    return forbidden;
  }

  public int getCheckIntervalSeconds() {
    return CHECK_INTERVAL_SECONDS;
  }
}
