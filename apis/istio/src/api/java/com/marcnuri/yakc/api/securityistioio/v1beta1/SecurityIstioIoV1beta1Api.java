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

package com.marcnuri.yakc.api.securityistioio.v1beta1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.istio.security.v1beta1.AuthorizationPolicy;
import com.marcnuri.yakc.model.io.istio.security.v1beta1.AuthorizationPolicyList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface SecurityIstioIoV1beta1Api extends Api {
  /**
   * list objects of kind AuthorizationPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/authorizationpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AuthorizationPolicyList, AuthorizationPolicy> listAuthorizationPolicyForAllNamespaces();

  /**
   * list objects of kind AuthorizationPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/authorizationpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AuthorizationPolicyList, AuthorizationPolicy> listAuthorizationPolicyForAllNamespaces(
    @QueryMap ListAuthorizationPolicyForAllNamespaces queryParameters);

  
  final class ListAuthorizationPolicyForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListAuthorizationPolicyForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListAuthorizationPolicyForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListAuthorizationPolicyForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListAuthorizationPolicyForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListAuthorizationPolicyForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListAuthorizationPolicyForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListAuthorizationPolicyForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListAuthorizationPolicyForAllNamespaces resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListAuthorizationPolicyForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListAuthorizationPolicyForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of AuthorizationPolicy
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedAuthorizationPolicy(
    @Path("namespace") String namespace);

  /**
   * delete collection of AuthorizationPolicy
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedAuthorizationPolicy(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedAuthorizationPolicy queryParameters);

  
  final class DeleteCollectionNamespacedAuthorizationPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedAuthorizationPolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedAuthorizationPolicy resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedAuthorizationPolicy watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind AuthorizationPolicy
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AuthorizationPolicyList, AuthorizationPolicy> listNamespacedAuthorizationPolicy(
    @Path("namespace") String namespace);

  /**
   * list objects of kind AuthorizationPolicy
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AuthorizationPolicyList, AuthorizationPolicy> listNamespacedAuthorizationPolicy(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedAuthorizationPolicy queryParameters);

  
  final class ListNamespacedAuthorizationPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedAuthorizationPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedAuthorizationPolicy allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedAuthorizationPolicy continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedAuthorizationPolicy fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedAuthorizationPolicy labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedAuthorizationPolicy limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedAuthorizationPolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedAuthorizationPolicy resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedAuthorizationPolicy timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedAuthorizationPolicy watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an AuthorizationPolicy
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> createNamespacedAuthorizationPolicy(
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body);

  /**
   * create an AuthorizationPolicy
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> createNamespacedAuthorizationPolicy(
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body, 
    @QueryMap CreateNamespacedAuthorizationPolicy queryParameters);

  
  final class CreateNamespacedAuthorizationPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedAuthorizationPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedAuthorizationPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedAuthorizationPolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body);

    /**
   * delete an AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete an AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body, 
    @QueryMap DeleteNamespacedAuthorizationPolicy queryParameters);

  /**
   * delete an AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedAuthorizationPolicy queryParameters);

  
  final class DeleteNamespacedAuthorizationPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedAuthorizationPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedAuthorizationPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedAuthorizationPolicy gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedAuthorizationPolicy orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedAuthorizationPolicy propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> readNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> readNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedAuthorizationPolicy queryParameters);

  
  final class ReadNamespacedAuthorizationPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedAuthorizationPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedAuthorizationPolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> patchNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body);

  /**
   * partially update the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> patchNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body, 
    @QueryMap PatchNamespacedAuthorizationPolicy queryParameters);

  
  final class PatchNamespacedAuthorizationPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedAuthorizationPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedAuthorizationPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedAuthorizationPolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> replaceNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body);

  /**
   * replace the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> replaceNamespacedAuthorizationPolicy(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body, 
    @QueryMap ReplaceNamespacedAuthorizationPolicy queryParameters);

  
  final class ReplaceNamespacedAuthorizationPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedAuthorizationPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedAuthorizationPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedAuthorizationPolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> readNamespacedAuthorizationPolicyStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> readNamespacedAuthorizationPolicyStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedAuthorizationPolicyStatus queryParameters);

  
  final class ReadNamespacedAuthorizationPolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedAuthorizationPolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedAuthorizationPolicyStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> patchNamespacedAuthorizationPolicyStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body);

  /**
   * partially update status of the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> patchNamespacedAuthorizationPolicyStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body, 
    @QueryMap PatchNamespacedAuthorizationPolicyStatus queryParameters);

  
  final class PatchNamespacedAuthorizationPolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedAuthorizationPolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedAuthorizationPolicyStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedAuthorizationPolicyStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> replaceNamespacedAuthorizationPolicyStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body);

  /**
   * replace status of the specified AuthorizationPolicy
   *
   * @param name name of the AuthorizationPolicy
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/security.istio.io/v1beta1/namespaces/{namespace}/authorizationpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<AuthorizationPolicy> replaceNamespacedAuthorizationPolicyStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body AuthorizationPolicy body, 
    @QueryMap ReplaceNamespacedAuthorizationPolicyStatus queryParameters);

  
  final class ReplaceNamespacedAuthorizationPolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedAuthorizationPolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedAuthorizationPolicyStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedAuthorizationPolicyStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
}
