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
 * Created on 2020-05-16, 8:58
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.model.io.k8s.api.apps.v1.Deployment;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Pod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marc Nuri on 2020-05-16.
 */
@RestController
@RequestMapping("/")
public class ClusterResource {

  private final ClusterService clusterService;

  public ClusterResource(ClusterService clusterService) {
    this.clusterService = clusterService;
  }

  @GetMapping("namespace")
  public String getNamespace() {
    return clusterService.getNamespace();
  }

  @GetMapping("deployments")
  public List<Deployment> getDeployments() {
    return clusterService.getDeployments();
  }

  @GetMapping("pods")
  public List<Pod> getPods() {
    return clusterService.getPods();
  }

  @GetMapping("deployments/{deployment}/logs")
  public String getDeploymentLogs(@PathVariable("deployment") String deployment) {
    return clusterService.getDeploymentLogs(deployment);
  }
}
