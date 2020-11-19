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

package com.marcnuri.yakc.api.messagingknativedev.v1beta1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.dev.knative.messaging.v1beta1.Channel;
import com.marcnuri.yakc.model.dev.knative.messaging.v1beta1.ChannelList;
import com.marcnuri.yakc.model.dev.knative.messaging.v1beta1.Subscription;
import com.marcnuri.yakc.model.dev.knative.messaging.v1beta1.SubscriptionList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface MessagingKnativeDevV1beta1Api extends Api {
  /**
   * list objects of kind Channel
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/channels"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ChannelList, Channel> listChannelForAllNamespaces();

  /**
   * list objects of kind Channel
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/channels"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ChannelList, Channel> listChannelForAllNamespaces(
    @QueryMap ListChannelForAllNamespaces queryParameters);

  
  final class ListChannelForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListChannelForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListChannelForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListChannelForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListChannelForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListChannelForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListChannelForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListChannelForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListChannelForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListChannelForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of Channel
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedChannel(
    @Path("namespace") String namespace);

  /**
   * delete collection of Channel
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedChannel(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedChannel queryParameters);

  
  final class DeleteCollectionNamespacedChannel extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedChannel pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedChannel allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedChannel continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedChannel fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedChannel labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedChannel limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedChannel resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedChannel timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedChannel watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Channel
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ChannelList, Channel> listNamespacedChannel(
    @Path("namespace") String namespace);

  /**
   * list objects of kind Channel
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ChannelList, Channel> listNamespacedChannel(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedChannel queryParameters);

  
  final class ListNamespacedChannel extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedChannel pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedChannel allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedChannel continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedChannel fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedChannel labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedChannel limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedChannel resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedChannel timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedChannel watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a Channel
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Channel> createNamespacedChannel(
    @Path("namespace") String namespace, 
    @Body Channel body);

  /**
   * create a Channel
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Channel> createNamespacedChannel(
    @Path("namespace") String namespace, 
    @Body Channel body, 
    @QueryMap CreateNamespacedChannel queryParameters);

  
  final class CreateNamespacedChannel extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedChannel pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedChannel dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedChannel fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedChannel queryParameters);

  /**
   * delete a Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedChannel queryParameters);

  
  final class DeleteNamespacedChannel extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedChannel pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedChannel dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedChannel gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedChannel orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedChannel propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Channel> readNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Channel> readNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedChannel queryParameters);

  
  final class ReadNamespacedChannel extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedChannel pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedChannel resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Channel> patchNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body);

  /**
   * partially update the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Channel> patchNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body, 
    @QueryMap PatchNamespacedChannel queryParameters);

  
  final class PatchNamespacedChannel extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedChannel pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedChannel dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedChannel fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Channel> replaceNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body);

  /**
   * replace the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Channel> replaceNamespacedChannel(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body, 
    @QueryMap ReplaceNamespacedChannel queryParameters);

  
  final class ReplaceNamespacedChannel extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedChannel pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedChannel dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedChannel fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Channel> readNamespacedChannelStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Channel> readNamespacedChannelStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedChannelStatus queryParameters);

  
  final class ReadNamespacedChannelStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedChannelStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedChannelStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Channel> patchNamespacedChannelStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body);

  /**
   * partially update status of the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Channel> patchNamespacedChannelStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body, 
    @QueryMap PatchNamespacedChannelStatus queryParameters);

  
  final class PatchNamespacedChannelStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedChannelStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedChannelStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedChannelStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Channel> replaceNamespacedChannelStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body);

  /**
   * replace status of the specified Channel
   *
   * @param name name of the Channel
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/channels/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Channel> replaceNamespacedChannelStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Channel body, 
    @QueryMap ReplaceNamespacedChannelStatus queryParameters);

  
  final class ReplaceNamespacedChannelStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedChannelStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedChannelStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedChannelStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of Subscription
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedSubscription(
    @Path("namespace") String namespace);

  /**
   * delete collection of Subscription
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedSubscription(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedSubscription queryParameters);

  
  final class DeleteCollectionNamespacedSubscription extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedSubscription pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedSubscription allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedSubscription continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedSubscription fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedSubscription labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedSubscription limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedSubscription resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedSubscription timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedSubscription watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Subscription
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SubscriptionList, Subscription> listNamespacedSubscription(
    @Path("namespace") String namespace);

  /**
   * list objects of kind Subscription
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SubscriptionList, Subscription> listNamespacedSubscription(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedSubscription queryParameters);

  
  final class ListNamespacedSubscription extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedSubscription pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedSubscription allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedSubscription continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedSubscription fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedSubscription labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedSubscription limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedSubscription resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedSubscription timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedSubscription watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a Subscription
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> createNamespacedSubscription(
    @Path("namespace") String namespace, 
    @Body Subscription body);

  /**
   * create a Subscription
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> createNamespacedSubscription(
    @Path("namespace") String namespace, 
    @Body Subscription body, 
    @QueryMap CreateNamespacedSubscription queryParameters);

  
  final class CreateNamespacedSubscription extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedSubscription pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedSubscription dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedSubscription fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedSubscription queryParameters);

  /**
   * delete a Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedSubscription queryParameters);

  
  final class DeleteNamespacedSubscription extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedSubscription pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedSubscription dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedSubscription gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedSubscription orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedSubscription propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Subscription> readNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Subscription> readNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedSubscription queryParameters);

  
  final class ReadNamespacedSubscription extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedSubscription pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedSubscription resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> patchNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body);

  /**
   * partially update the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> patchNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body, 
    @QueryMap PatchNamespacedSubscription queryParameters);

  
  final class PatchNamespacedSubscription extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedSubscription pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedSubscription dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedSubscription fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> replaceNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body);

  /**
   * replace the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> replaceNamespacedSubscription(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body, 
    @QueryMap ReplaceNamespacedSubscription queryParameters);

  
  final class ReplaceNamespacedSubscription extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedSubscription pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedSubscription dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedSubscription fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Subscription> readNamespacedSubscriptionStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Subscription> readNamespacedSubscriptionStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedSubscriptionStatus queryParameters);

  
  final class ReadNamespacedSubscriptionStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedSubscriptionStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedSubscriptionStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> patchNamespacedSubscriptionStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body);

  /**
   * partially update status of the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> patchNamespacedSubscriptionStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body, 
    @QueryMap PatchNamespacedSubscriptionStatus queryParameters);

  
  final class PatchNamespacedSubscriptionStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedSubscriptionStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedSubscriptionStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedSubscriptionStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> replaceNamespacedSubscriptionStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body);

  /**
   * replace status of the specified Subscription
   *
   * @param name name of the Subscription
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/messaging.knative.dev/v1beta1/namespaces/{namespace}/subscriptions/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Subscription> replaceNamespacedSubscriptionStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Subscription body, 
    @QueryMap ReplaceNamespacedSubscriptionStatus queryParameters);

  
  final class ReplaceNamespacedSubscriptionStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedSubscriptionStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedSubscriptionStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedSubscriptionStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * list objects of kind Subscription
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/subscriptions"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SubscriptionList, Subscription> listSubscriptionForAllNamespaces();

  /**
   * list objects of kind Subscription
   */
  @HTTP(
    method = "GET",
    path = "/apis/messaging.knative.dev/v1beta1/subscriptions"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<SubscriptionList, Subscription> listSubscriptionForAllNamespaces(
    @QueryMap ListSubscriptionForAllNamespaces queryParameters);

  
  final class ListSubscriptionForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListSubscriptionForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListSubscriptionForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListSubscriptionForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListSubscriptionForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListSubscriptionForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListSubscriptionForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListSubscriptionForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListSubscriptionForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListSubscriptionForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
