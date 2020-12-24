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
 * Created on 2020-04-25, 17:21
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.node.v1.NodeV1Api;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

@ClusterExecutionCondition.ClusterMinVersion(minVersion = "1.20.0")
@ExtendWith(KubernetesClientExtension.class)
class NodeV1IT {

  @Test
  @DisplayName("getAPIResources, cluster contains resources for this API version")
  void getAPIResources() throws IOException {
    // When
    final APIResourceList result = KC.create(NodeV1Api.class).getAPIResources().get();
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("groupVersion","node.k8s.io/v1")
      .hasFieldOrPropertyWithValue("apiVersion", "v1")
      .extracting(APIResourceList::getResources).asList().isNotEmpty();
  }

}
