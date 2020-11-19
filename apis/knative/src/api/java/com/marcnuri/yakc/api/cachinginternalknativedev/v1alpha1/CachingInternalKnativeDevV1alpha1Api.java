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

package com.marcnuri.yakc.api.cachinginternalknativedev.v1alpha1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.dev.knative.internal.caching.v1alpha1.Image;
import com.marcnuri.yakc.model.dev.knative.internal.caching.v1alpha1.ImageList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface CachingInternalKnativeDevV1alpha1Api extends Api {
  /**
   * list objects of kind Image
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/images"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ImageList, Image> listImageForAllNamespaces();

  /**
   * list objects of kind Image
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/images"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ImageList, Image> listImageForAllNamespaces(
    @QueryMap ListImageForAllNamespaces queryParameters);

  
  final class ListImageForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListImageForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListImageForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListImageForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListImageForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListImageForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListImageForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListImageForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListImageForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListImageForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of Image
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedImage(
    @Path("namespace") String namespace);

  /**
   * delete collection of Image
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedImage(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedImage queryParameters);

  
  final class DeleteCollectionNamespacedImage extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedImage pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedImage allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedImage continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedImage fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedImage labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedImage limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedImage resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedImage timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedImage watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Image
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ImageList, Image> listNamespacedImage(
    @Path("namespace") String namespace);

  /**
   * list objects of kind Image
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ImageList, Image> listNamespacedImage(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedImage queryParameters);

  
  final class ListNamespacedImage extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedImage pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedImage allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedImage continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedImage fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedImage labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedImage limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedImage resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedImage timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedImage watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an Image
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Image> createNamespacedImage(
    @Path("namespace") String namespace, 
    @Body Image body);

  /**
   * create an Image
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Image> createNamespacedImage(
    @Path("namespace") String namespace, 
    @Body Image body, 
    @QueryMap CreateNamespacedImage queryParameters);

  
  final class CreateNamespacedImage extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedImage pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedImage dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedImage fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete an Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete an Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedImage queryParameters);

  /**
   * delete an Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedImage queryParameters);

  
  final class DeleteNamespacedImage extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedImage pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedImage dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedImage gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedImage orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedImage propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Image> readNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Image> readNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedImage queryParameters);

  
  final class ReadNamespacedImage extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedImage pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedImage resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Image> patchNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body);

  /**
   * partially update the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Image> patchNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body, 
    @QueryMap PatchNamespacedImage queryParameters);

  
  final class PatchNamespacedImage extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedImage pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedImage dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedImage fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Image> replaceNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body);

  /**
   * replace the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Image> replaceNamespacedImage(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body, 
    @QueryMap ReplaceNamespacedImage queryParameters);

  
  final class ReplaceNamespacedImage extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedImage pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedImage dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedImage fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Image> readNamespacedImageStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Image> readNamespacedImageStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedImageStatus queryParameters);

  
  final class ReadNamespacedImageStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedImageStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedImageStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Image> patchNamespacedImageStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body);

  /**
   * partially update status of the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Image> patchNamespacedImageStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body, 
    @QueryMap PatchNamespacedImageStatus queryParameters);

  
  final class PatchNamespacedImageStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedImageStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedImageStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedImageStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Image> replaceNamespacedImageStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body);

  /**
   * replace status of the specified Image
   *
   * @param name name of the Image
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/caching.internal.knative.dev/v1alpha1/namespaces/{namespace}/images/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Image> replaceNamespacedImageStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Image body, 
    @QueryMap ReplaceNamespacedImageStatus queryParameters);

  
  final class ReplaceNamespacedImageStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedImageStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedImageStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedImageStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
}
