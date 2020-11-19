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

package com.marcnuri.yakc.api.networkinginternalknativedev.v1alpha1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.dev.knative.internal.networking.v1alpha1.Certificate;
import com.marcnuri.yakc.model.dev.knative.internal.networking.v1alpha1.CertificateList;
import com.marcnuri.yakc.model.dev.knative.internal.networking.v1alpha1.Ingress;
import com.marcnuri.yakc.model.dev.knative.internal.networking.v1alpha1.IngressList;
import com.marcnuri.yakc.model.dev.knative.internal.networking.v1alpha1.ServerlessService;
import com.marcnuri.yakc.model.dev.knative.internal.networking.v1alpha1.ServerlessServiceList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface NetworkingInternalKnativeDevV1alpha1Api extends Api {
  /**
   * list objects of kind Certificate
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/certificates"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CertificateList, Certificate> listCertificateForAllNamespaces();

  /**
   * list objects of kind Certificate
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/certificates"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CertificateList, Certificate> listCertificateForAllNamespaces(
    @QueryMap ListCertificateForAllNamespaces queryParameters);

  
  final class ListCertificateForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListCertificateForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListCertificateForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListCertificateForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListCertificateForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListCertificateForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListCertificateForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListCertificateForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListCertificateForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListCertificateForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Ingress
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/ingresses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressList, Ingress> listIngressForAllNamespaces();

  /**
   * list objects of kind Ingress
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/ingresses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressList, Ingress> listIngressForAllNamespaces(
    @QueryMap ListIngressForAllNamespaces queryParameters);

  
  final class ListIngressForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListIngressForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListIngressForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListIngressForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListIngressForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListIngressForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListIngressForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListIngressForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListIngressForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListIngressForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of Certificate
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedCertificate(
    @Path("namespace") String namespace);

  /**
   * delete collection of Certificate
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedCertificate(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedCertificate queryParameters);

  
  final class DeleteCollectionNamespacedCertificate extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedCertificate pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedCertificate allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedCertificate continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedCertificate fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedCertificate labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedCertificate limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedCertificate resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedCertificate timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedCertificate watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Certificate
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CertificateList, Certificate> listNamespacedCertificate(
    @Path("namespace") String namespace);

  /**
   * list objects of kind Certificate
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CertificateList, Certificate> listNamespacedCertificate(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedCertificate queryParameters);

  
  final class ListNamespacedCertificate extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedCertificate pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedCertificate allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedCertificate continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedCertificate fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedCertificate labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedCertificate limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedCertificate resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedCertificate timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedCertificate watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a Certificate
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> createNamespacedCertificate(
    @Path("namespace") String namespace, 
    @Body Certificate body);

  /**
   * create a Certificate
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> createNamespacedCertificate(
    @Path("namespace") String namespace, 
    @Body Certificate body, 
    @QueryMap CreateNamespacedCertificate queryParameters);

  
  final class CreateNamespacedCertificate extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedCertificate pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedCertificate dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedCertificate fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedCertificate queryParameters);

  /**
   * delete a Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedCertificate queryParameters);

  
  final class DeleteNamespacedCertificate extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedCertificate pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedCertificate dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedCertificate gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedCertificate orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedCertificate propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Certificate> readNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Certificate> readNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedCertificate queryParameters);

  
  final class ReadNamespacedCertificate extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedCertificate pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedCertificate resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> patchNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body);

  /**
   * partially update the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> patchNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body, 
    @QueryMap PatchNamespacedCertificate queryParameters);

  
  final class PatchNamespacedCertificate extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedCertificate pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedCertificate dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedCertificate fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> replaceNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body);

  /**
   * replace the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> replaceNamespacedCertificate(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body, 
    @QueryMap ReplaceNamespacedCertificate queryParameters);

  
  final class ReplaceNamespacedCertificate extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedCertificate pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedCertificate dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedCertificate fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Certificate> readNamespacedCertificateStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Certificate> readNamespacedCertificateStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedCertificateStatus queryParameters);

  
  final class ReadNamespacedCertificateStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedCertificateStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedCertificateStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> patchNamespacedCertificateStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body);

  /**
   * partially update status of the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> patchNamespacedCertificateStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body, 
    @QueryMap PatchNamespacedCertificateStatus queryParameters);

  
  final class PatchNamespacedCertificateStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedCertificateStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedCertificateStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedCertificateStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> replaceNamespacedCertificateStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body);

  /**
   * replace status of the specified Certificate
   *
   * @param name name of the Certificate
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/certificates/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Certificate> replaceNamespacedCertificateStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Certificate body, 
    @QueryMap ReplaceNamespacedCertificateStatus queryParameters);

  
  final class ReplaceNamespacedCertificateStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedCertificateStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedCertificateStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedCertificateStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of Ingress
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedIngress(
    @Path("namespace") String namespace);

  /**
   * delete collection of Ingress
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedIngress(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedIngress queryParameters);

  
  final class DeleteCollectionNamespacedIngress extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedIngress pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedIngress allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedIngress continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedIngress fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedIngress labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedIngress limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedIngress resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedIngress timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedIngress watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Ingress
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressList, Ingress> listNamespacedIngress(
    @Path("namespace") String namespace);

  /**
   * list objects of kind Ingress
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressList, Ingress> listNamespacedIngress(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedIngress queryParameters);

  
  final class ListNamespacedIngress extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedIngress pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedIngress allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedIngress continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedIngress fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedIngress labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedIngress limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedIngress resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedIngress timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedIngress watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an Ingress
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> createNamespacedIngress(
    @Path("namespace") String namespace, 
    @Body Ingress body);

  /**
   * create an Ingress
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> createNamespacedIngress(
    @Path("namespace") String namespace, 
    @Body Ingress body, 
    @QueryMap CreateNamespacedIngress queryParameters);

  
  final class CreateNamespacedIngress extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedIngress pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedIngress dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedIngress fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete an Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete an Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedIngress queryParameters);

  /**
   * delete an Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedIngress queryParameters);

  
  final class DeleteNamespacedIngress extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedIngress pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedIngress dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedIngress gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedIngress orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedIngress propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Ingress> readNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Ingress> readNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedIngress queryParameters);

  
  final class ReadNamespacedIngress extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedIngress pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedIngress resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> patchNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body);

  /**
   * partially update the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> patchNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body, 
    @QueryMap PatchNamespacedIngress queryParameters);

  
  final class PatchNamespacedIngress extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedIngress pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedIngress dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedIngress fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> replaceNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body);

  /**
   * replace the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> replaceNamespacedIngress(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body, 
    @QueryMap ReplaceNamespacedIngress queryParameters);

  
  final class ReplaceNamespacedIngress extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedIngress pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedIngress dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedIngress fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Ingress> readNamespacedIngressStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Ingress> readNamespacedIngressStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedIngressStatus queryParameters);

  
  final class ReadNamespacedIngressStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedIngressStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedIngressStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> patchNamespacedIngressStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body);

  /**
   * partially update status of the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> patchNamespacedIngressStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body, 
    @QueryMap PatchNamespacedIngressStatus queryParameters);

  
  final class PatchNamespacedIngressStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedIngressStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedIngressStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedIngressStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> replaceNamespacedIngressStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body);

  /**
   * replace status of the specified Ingress
   *
   * @param name name of the Ingress
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/ingresses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Ingress> replaceNamespacedIngressStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Ingress body, 
    @QueryMap ReplaceNamespacedIngressStatus queryParameters);

  
  final class ReplaceNamespacedIngressStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedIngressStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedIngressStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedIngressStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ServerlessService
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedServerlessService(
    @Path("namespace") String namespace);

  /**
   * delete collection of ServerlessService
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedServerlessService(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedServerlessService queryParameters);

  
  final class DeleteCollectionNamespacedServerlessService extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedServerlessService pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedServerlessService allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedServerlessService continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedServerlessService fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedServerlessService labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedServerlessService limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedServerlessService resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedServerlessService timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedServerlessService watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ServerlessService
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServerlessServiceList, ServerlessService> listNamespacedServerlessService(
    @Path("namespace") String namespace);

  /**
   * list objects of kind ServerlessService
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServerlessServiceList, ServerlessService> listNamespacedServerlessService(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedServerlessService queryParameters);

  
  final class ListNamespacedServerlessService extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedServerlessService pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedServerlessService allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedServerlessService continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedServerlessService fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedServerlessService labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedServerlessService limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedServerlessService resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedServerlessService timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedServerlessService watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ServerlessService
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> createNamespacedServerlessService(
    @Path("namespace") String namespace, 
    @Body ServerlessService body);

  /**
   * create a ServerlessService
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> createNamespacedServerlessService(
    @Path("namespace") String namespace, 
    @Body ServerlessService body, 
    @QueryMap CreateNamespacedServerlessService queryParameters);

  
  final class CreateNamespacedServerlessService extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedServerlessService pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedServerlessService dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedServerlessService fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedServerlessService queryParameters);

  /**
   * delete a ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedServerlessService queryParameters);

  
  final class DeleteNamespacedServerlessService extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedServerlessService pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedServerlessService dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedServerlessService gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedServerlessService orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedServerlessService propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> readNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> readNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedServerlessService queryParameters);

  
  final class ReadNamespacedServerlessService extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedServerlessService pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedServerlessService resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> patchNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body);

  /**
   * partially update the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> patchNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body, 
    @QueryMap PatchNamespacedServerlessService queryParameters);

  
  final class PatchNamespacedServerlessService extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedServerlessService pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedServerlessService dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedServerlessService fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> replaceNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body);

  /**
   * replace the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> replaceNamespacedServerlessService(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body, 
    @QueryMap ReplaceNamespacedServerlessService queryParameters);

  
  final class ReplaceNamespacedServerlessService extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedServerlessService pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedServerlessService dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedServerlessService fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> readNamespacedServerlessServiceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> readNamespacedServerlessServiceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedServerlessServiceStatus queryParameters);

  
  final class ReadNamespacedServerlessServiceStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedServerlessServiceStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedServerlessServiceStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> patchNamespacedServerlessServiceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body);

  /**
   * partially update status of the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> patchNamespacedServerlessServiceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body, 
    @QueryMap PatchNamespacedServerlessServiceStatus queryParameters);

  
  final class PatchNamespacedServerlessServiceStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedServerlessServiceStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedServerlessServiceStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedServerlessServiceStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> replaceNamespacedServerlessServiceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body);

  /**
   * replace status of the specified ServerlessService
   *
   * @param name name of the ServerlessService
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.internal.knative.dev/v1alpha1/namespaces/{namespace}/serverlessservices/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServerlessService> replaceNamespacedServerlessServiceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ServerlessService body, 
    @QueryMap ReplaceNamespacedServerlessServiceStatus queryParameters);

  
  final class ReplaceNamespacedServerlessServiceStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedServerlessServiceStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedServerlessServiceStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedServerlessServiceStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * list objects of kind ServerlessService
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/serverlessservices"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServerlessServiceList, ServerlessService> listServerlessServiceForAllNamespaces();

  /**
   * list objects of kind ServerlessService
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.internal.knative.dev/v1alpha1/serverlessservices"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServerlessServiceList, ServerlessService> listServerlessServiceForAllNamespaces(
    @QueryMap ListServerlessServiceForAllNamespaces queryParameters);

  
  final class ListServerlessServiceForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListServerlessServiceForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListServerlessServiceForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListServerlessServiceForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListServerlessServiceForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListServerlessServiceForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListServerlessServiceForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListServerlessServiceForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListServerlessServiceForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListServerlessServiceForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
