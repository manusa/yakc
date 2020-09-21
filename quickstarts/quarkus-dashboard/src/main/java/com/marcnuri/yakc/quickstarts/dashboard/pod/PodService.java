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
 * Created on 2020-09-06, 8:36
 */
package com.marcnuri.yakc.quickstarts.dashboard.pod;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api.ReadNamespacedPodLog;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

@Singleton
public class PodService {

  private static final Logger LOG = LoggerFactory.getLogger(PodService.class);

  private final KubernetesClient kubernetesClient;

  @Inject
  public PodService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  public Observable<WatchEvent<Pod>> getPods() throws KubernetesException {
    return kubernetesClient.create(CoreV1Api.class).listPodForAllNamespaces().watch();
  }

  public Pod getPod(String name, String namespace) throws IOException {
    return kubernetesClient.create(CoreV1Api.class).readNamespacedPod(name, namespace).get();
  }

  public Pod deletePod(String name, String namespace) throws IOException {
    return kubernetesClient.create(CoreV1Api.class).deleteNamespacedPod(name, namespace).get();
  }

  public Observable<String> getPodLog(String name, String namespace) {
    final KubernetesCall<String> podLogCall = kubernetesClient.create(CoreV1Api.class)
      .readNamespacedPodLog(name, namespace, new ReadNamespacedPodLog()
        .follow(true).pretty("true").timestamps(true));
    return Observable.create(new LogReader(podLogCall))
      .doOnError(ex -> LOG.error("Error when reading Pod logs {} - {}", namespace, name, ex));
  }

  private static final class LogReader implements ObservableOnSubscribe<String> {

    private final KubernetesCall<String> podLogCall;

    LogReader(KubernetesCall<String> podLogCall) {
      this.podLogCall = podLogCall;
    }

    @Override
    public void subscribe(ObservableEmitter<String> emitter)
      throws Exception {
      try (
        final Response response = podLogCall.executeRaw();
        final InputStream is = Objects.requireNonNull(response.body()).byteStream();
        final InputStreamReader isr = new InputStreamReader(is);
        final BufferedReader br = new BufferedReader(isr);
      ) {
        if (!response.isSuccessful()) {
          emitter.tryOnError(KubernetesException.forResponse("Error reading logs", response));
        }
        String line;
        while ((line = br.readLine()) != null) {
          emitter.onNext(line);
        }
        emitter.onComplete();
      }
    }
  }
}
