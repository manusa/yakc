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
 * Created on 2020-09-04, 15:57
 */
package com.marcnuri.yakc.quickstarts.dashboard.node;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.WatchEvent;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Node;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Singleton
public class NodeService {

  private static final Logger LOG = LoggerFactory.getLogger(NodeService.class);

  private final KubernetesClient kubernetesClient;

  @Inject
  public NodeService(KubernetesClient kubernetesClient) {
    this.kubernetesClient = kubernetesClient;
  }

  public  Observable<WatchEvent<Node>> getNodes() throws IOException {
    final CoreV1Api core = kubernetesClient.create(CoreV1Api.class);
    try {
      core.listNode().get();
      return core.listNode().watch();
    } catch (ClientErrorException ex) {
      if (ex.getCode() == 403) {
        LOG.warn("Access to Node information is forbidden: {}", ex.getMessage());
        return Observable.empty();
      }
      throw ex;
    }
  }

}
