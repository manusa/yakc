/*
 * RbacAuthorizationV1IT.java
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

/**
 * Created by Marc Nuri on 2020-06-07.
 */
@ExtendWith(KubernetesClientExtension.class)
class RbacAuthorizationV1IT {

  @Test
  @DisplayName("getAPIResources, cluster contains resources for this API version")
  void getAPIResources() throws IOException {
    // When
    final APIResourceList result = KC.create(RbacAuthorizationV1Api.class).getAPIResources().get();
    // Then
    assertThat(result.getGroupVersion()).isEqualTo("rbac.authorization.k8s.io/v1");
    assertThat(result.getApiVersion()).isEqualTo("v1");
    assertThat(result.getResources()).isNotEmpty();
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
