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
 */

package com.marcnuri.yakc.api.authorization.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.model.io.k8s.api.authorization.v1.LocalSubjectAccessReview;
import com.marcnuri.yakc.model.io.k8s.api.authorization.v1.SelfSubjectAccessReview;
import com.marcnuri.yakc.model.io.k8s.api.authorization.v1.SelfSubjectRulesReview;
import com.marcnuri.yakc.model.io.k8s.api.authorization.v1.SubjectAccessReview;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface AuthorizationV1Api extends Api {
  /**
   * get available resources
   */
  @HTTP(
    method = "GET",
    path = "/apis/authorization.k8s.io/v1/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<APIResourceList> getAPIResources();

  /**
   * create a LocalSubjectAccessReview
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/namespaces/{namespace}/localsubjectaccessreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<LocalSubjectAccessReview> createNamespacedLocalSubjectAccessReview(
    @Path("namespace") String namespace, 
    @Body LocalSubjectAccessReview body);

  /**
   * create a LocalSubjectAccessReview
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/namespaces/{namespace}/localsubjectaccessreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<LocalSubjectAccessReview> createNamespacedLocalSubjectAccessReview(
    @Path("namespace") String namespace, 
    @Body LocalSubjectAccessReview body, 
    @QueryMap CreateNamespacedLocalSubjectAccessReview queryParameters);

  
  final class CreateNamespacedLocalSubjectAccessReview extends HashMap<String, Object> { 
    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedLocalSubjectAccessReview dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedLocalSubjectAccessReview fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedLocalSubjectAccessReview pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * create a SelfSubjectAccessReview
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/selfsubjectaccessreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SelfSubjectAccessReview> createSelfSubjectAccessReview(
    @Body SelfSubjectAccessReview body);

  /**
   * create a SelfSubjectAccessReview
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/selfsubjectaccessreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SelfSubjectAccessReview> createSelfSubjectAccessReview(
    @Body SelfSubjectAccessReview body, 
    @QueryMap CreateSelfSubjectAccessReview queryParameters);

  
  final class CreateSelfSubjectAccessReview extends HashMap<String, Object> { 
    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateSelfSubjectAccessReview dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateSelfSubjectAccessReview fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateSelfSubjectAccessReview pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * create a SelfSubjectRulesReview
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/selfsubjectrulesreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SelfSubjectRulesReview> createSelfSubjectRulesReview(
    @Body SelfSubjectRulesReview body);

  /**
   * create a SelfSubjectRulesReview
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/selfsubjectrulesreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SelfSubjectRulesReview> createSelfSubjectRulesReview(
    @Body SelfSubjectRulesReview body, 
    @QueryMap CreateSelfSubjectRulesReview queryParameters);

  
  final class CreateSelfSubjectRulesReview extends HashMap<String, Object> { 
    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateSelfSubjectRulesReview dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateSelfSubjectRulesReview fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateSelfSubjectRulesReview pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * create a SubjectAccessReview
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/subjectaccessreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SubjectAccessReview> createSubjectAccessReview(
    @Body SubjectAccessReview body);

  /**
   * create a SubjectAccessReview
   */
  @HTTP(
    method = "POST",
    path = "/apis/authorization.k8s.io/v1/subjectaccessreviews",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SubjectAccessReview> createSubjectAccessReview(
    @Body SubjectAccessReview body, 
    @QueryMap CreateSubjectAccessReview queryParameters);

  
  final class CreateSubjectAccessReview extends HashMap<String, Object> { 
    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateSubjectAccessReview dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateSubjectAccessReview fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateSubjectAccessReview pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
}
