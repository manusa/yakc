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
 * Created on 2020-06-07, 16:48
 */
package com.marcnuri.yakc;

import com.marcnuri.yakc.api.rbacauthorization.v1.RbacAuthorizationV1Api;
import com.marcnuri.yakc.model.io.k8s.api.rbac.v1.ClusterRole;
import com.marcnuri.yakc.model.io.k8s.api.rbac.v1.RoleList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.stream.Stream;

import static com.marcnuri.yakc.KubernetesClientExtension.KC;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(KubernetesClientExtension.class)
class RbacAuthorizationV1IT {

  @Test
  @DisplayName("getAPIResources, cluster contains resources for this API version")
  void getAPIResources() throws IOException {
    // When
    final APIResourceList result = KC.create(RbacAuthorizationV1Api.class).getAPIResources().get();
    // Then
    assertThat(result)
      .hasFieldOrPropertyWithValue("groupVersion","rbac.authorization.k8s.io/v1")
      .hasFieldOrPropertyWithValue("apiVersion", "v1")
      .extracting(APIResourceList::getResources).asList().isNotEmpty();
  }

  @Test
  @DisplayName("listClusterRole, cluster contains default cluster-admin role")
  void listClusterRole() throws IOException {
    // When
    final Stream<ClusterRole> result = KC.create(RbacAuthorizationV1Api.class).listClusterRole().stream();
    // Then
    final ClusterRole clusterAdmin = result
      .filter(cr -> cr.getMetadata().getName().equals("cluster-admin"))
      .findAny().orElse(null);
    assertThat(clusterAdmin).isNotNull();
    assertThat(clusterAdmin.getRules().stream()
      .filter(r -> r.getApiGroups() != null)
      .filter(r -> r.getApiGroups().contains("*"))
      .filter(r -> r.getResources() != null)
      .filter(r -> r.getResources().contains("*"))
      .filter(r -> r.getVerbs() != null)
      .filter(r -> r.getVerbs().contains("*"))
      .count()
    ).isGreaterThanOrEqualTo(1L);
  }

  @Test
  @DisplayName("listRoleForAllNamespaces, cluster contains system roles")
  void listRoleForAllNamespaces() throws IOException {
    // When
    final RoleList result = KC.create(RbacAuthorizationV1Api.class).listRoleForAllNamespaces().get();
    // Then
    assertThat(result.getItems()).isNotEmpty();
  }
}
