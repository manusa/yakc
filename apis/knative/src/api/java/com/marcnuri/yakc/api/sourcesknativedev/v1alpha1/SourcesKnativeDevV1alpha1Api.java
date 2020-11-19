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

package com.marcnuri.yakc.api.sourcesknativedev.v1alpha1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.dev.knative.sources.v1alpha1.ApiServerSource;
import com.marcnuri.yakc.model.dev.knative.sources.v1alpha1.ApiServerSourceList;
import com.marcnuri.yakc.model.dev.knative.sources.v1alpha1.SinkBinding;
import com.marcnuri.yakc.model.dev.knative.sources.v1alpha1.SinkBindingList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface SourcesKnativeDevV1alpha1Api extends Api {
  /**
   * list objects of kind ApiServerSource
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/apiserversources"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ApiServerSourceList, ApiServerSource> listApiServerSourceForAllNamespaces();

  /**
   * list objects of kind ApiServerSource
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/apiserversources"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ApiServerSourceList, ApiServerSource> listApiServerSourceForAllNamespaces(
    @QueryMap ListApiServerSourceForAllNamespaces queryParameters);

  
  final class ListApiServerSourceForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListApiServerSourceForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListApiServerSourceForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListApiServerSourceForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListApiServerSourceForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListApiServerSourceForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListApiServerSourceForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListApiServerSourceForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListApiServerSourceForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListApiServerSourceForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of ApiServerSource
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedApiServerSource(
    @Path("namespace") String namespace);

  /**
   * delete collection of ApiServerSource
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedApiServerSource(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedApiServerSource queryParameters);

  
  final class DeleteCollectionNamespacedApiServerSource extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedApiServerSource pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedApiServerSource allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedApiServerSource continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedApiServerSource fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedApiServerSource labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedApiServerSource limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedApiServerSource resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedApiServerSource timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedApiServerSource watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ApiServerSource
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ApiServerSourceList, ApiServerSource> listNamespacedApiServerSource(
    @Path("namespace") String namespace);

  /**
   * list objects of kind ApiServerSource
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ApiServerSourceList, ApiServerSource> listNamespacedApiServerSource(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedApiServerSource queryParameters);

  
  final class ListNamespacedApiServerSource extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedApiServerSource pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedApiServerSource allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedApiServerSource continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedApiServerSource fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedApiServerSource labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedApiServerSource limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedApiServerSource resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedApiServerSource timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedApiServerSource watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an ApiServerSource
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> createNamespacedApiServerSource(
    @Path("namespace") String namespace, 
    @Body ApiServerSource body);

  /**
   * create an ApiServerSource
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> createNamespacedApiServerSource(
    @Path("namespace") String namespace, 
    @Body ApiServerSource body, 
    @QueryMap CreateNamespacedApiServerSource queryParameters);

  
  final class CreateNamespacedApiServerSource extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedApiServerSource pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedApiServerSource dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedApiServerSource fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete an ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete an ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedApiServerSource queryParameters);

  /**
   * delete an ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedApiServerSource queryParameters);

  
  final class DeleteNamespacedApiServerSource extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedApiServerSource pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedApiServerSource dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedApiServerSource gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedApiServerSource orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedApiServerSource propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> readNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> readNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedApiServerSource queryParameters);

  
  final class ReadNamespacedApiServerSource extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedApiServerSource pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedApiServerSource resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> patchNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body);

  /**
   * partially update the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> patchNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body, 
    @QueryMap PatchNamespacedApiServerSource queryParameters);

  
  final class PatchNamespacedApiServerSource extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedApiServerSource pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedApiServerSource dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedApiServerSource fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> replaceNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body);

  /**
   * replace the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> replaceNamespacedApiServerSource(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body, 
    @QueryMap ReplaceNamespacedApiServerSource queryParameters);

  
  final class ReplaceNamespacedApiServerSource extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedApiServerSource pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedApiServerSource dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedApiServerSource fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> readNamespacedApiServerSourceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> readNamespacedApiServerSourceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedApiServerSourceStatus queryParameters);

  
  final class ReadNamespacedApiServerSourceStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedApiServerSourceStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedApiServerSourceStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> patchNamespacedApiServerSourceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body);

  /**
   * partially update status of the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> patchNamespacedApiServerSourceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body, 
    @QueryMap PatchNamespacedApiServerSourceStatus queryParameters);

  
  final class PatchNamespacedApiServerSourceStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedApiServerSourceStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedApiServerSourceStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedApiServerSourceStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> replaceNamespacedApiServerSourceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body);

  /**
   * replace status of the specified ApiServerSource
   *
   * @param name name of the ApiServerSource
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/apiserversources/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ApiServerSource> replaceNamespacedApiServerSourceStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body ApiServerSource body, 
    @QueryMap ReplaceNamespacedApiServerSourceStatus queryParameters);

  
  final class ReplaceNamespacedApiServerSourceStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedApiServerSourceStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedApiServerSourceStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedApiServerSourceStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of SinkBinding
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedSinkBinding(
    @Path("namespace") String namespace);

  /**
   * delete collection of SinkBinding
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedSinkBinding(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedSinkBinding queryParameters);

  
  final class DeleteCollectionNamespacedSinkBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedSinkBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedSinkBinding allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedSinkBinding continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedSinkBinding fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedSinkBinding labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedSinkBinding limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedSinkBinding resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedSinkBinding timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedSinkBinding watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind SinkBinding
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SinkBindingList, SinkBinding> listNamespacedSinkBinding(
    @Path("namespace") String namespace);

  /**
   * list objects of kind SinkBinding
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SinkBindingList, SinkBinding> listNamespacedSinkBinding(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedSinkBinding queryParameters);

  
  final class ListNamespacedSinkBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedSinkBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedSinkBinding allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedSinkBinding continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedSinkBinding fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedSinkBinding labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedSinkBinding limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedSinkBinding resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedSinkBinding timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedSinkBinding watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a SinkBinding
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> createNamespacedSinkBinding(
    @Path("namespace") String namespace, 
    @Body SinkBinding body);

  /**
   * create a SinkBinding
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> createNamespacedSinkBinding(
    @Path("namespace") String namespace, 
    @Body SinkBinding body, 
    @QueryMap CreateNamespacedSinkBinding queryParameters);

  
  final class CreateNamespacedSinkBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedSinkBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedSinkBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedSinkBinding fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedSinkBinding queryParameters);

  /**
   * delete a SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedSinkBinding queryParameters);

  
  final class DeleteNamespacedSinkBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedSinkBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedSinkBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedSinkBinding gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedSinkBinding orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedSinkBinding propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> readNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> readNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedSinkBinding queryParameters);

  
  final class ReadNamespacedSinkBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedSinkBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedSinkBinding resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> patchNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body);

  /**
   * partially update the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> patchNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body, 
    @QueryMap PatchNamespacedSinkBinding queryParameters);

  
  final class PatchNamespacedSinkBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedSinkBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedSinkBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedSinkBinding fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> replaceNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body);

  /**
   * replace the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> replaceNamespacedSinkBinding(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body, 
    @QueryMap ReplaceNamespacedSinkBinding queryParameters);

  
  final class ReplaceNamespacedSinkBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedSinkBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedSinkBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedSinkBinding fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> readNamespacedSinkBindingStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> readNamespacedSinkBindingStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedSinkBindingStatus queryParameters);

  
  final class ReadNamespacedSinkBindingStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedSinkBindingStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedSinkBindingStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> patchNamespacedSinkBindingStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body);

  /**
   * partially update status of the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> patchNamespacedSinkBindingStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body, 
    @QueryMap PatchNamespacedSinkBindingStatus queryParameters);

  
  final class PatchNamespacedSinkBindingStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedSinkBindingStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedSinkBindingStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedSinkBindingStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> replaceNamespacedSinkBindingStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body);

  /**
   * replace status of the specified SinkBinding
   *
   * @param name name of the SinkBinding
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/sources.knative.dev/v1alpha1/namespaces/{namespace}/sinkbindings/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<SinkBinding> replaceNamespacedSinkBindingStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body SinkBinding body, 
    @QueryMap ReplaceNamespacedSinkBindingStatus queryParameters);

  
  final class ReplaceNamespacedSinkBindingStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedSinkBindingStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedSinkBindingStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedSinkBindingStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * list objects of kind SinkBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/sinkbindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SinkBindingList, SinkBinding> listSinkBindingForAllNamespaces();

  /**
   * list objects of kind SinkBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/sources.knative.dev/v1alpha1/sinkbindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SinkBindingList, SinkBinding> listSinkBindingForAllNamespaces(
    @QueryMap ListSinkBindingForAllNamespaces queryParameters);

  
  final class ListSinkBindingForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListSinkBindingForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListSinkBindingForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListSinkBindingForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListSinkBindingForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListSinkBindingForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListSinkBindingForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListSinkBindingForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListSinkBindingForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListSinkBindingForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
