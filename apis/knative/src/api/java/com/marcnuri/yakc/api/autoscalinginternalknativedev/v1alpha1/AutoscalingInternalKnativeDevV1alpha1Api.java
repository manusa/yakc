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

package com.marcnuri.yakc.api.autoscalinginternalknativedev.v1alpha1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.dev.knative.internal.autoscaling.v1alpha1.Metric;
import com.marcnuri.yakc.model.dev.knative.internal.autoscaling.v1alpha1.MetricList;
import com.marcnuri.yakc.model.dev.knative.internal.autoscaling.v1alpha1.PodAutoscaler;
import com.marcnuri.yakc.model.dev.knative.internal.autoscaling.v1alpha1.PodAutoscalerList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface AutoscalingInternalKnativeDevV1alpha1Api extends Api {
  /**
   * list objects of kind Metric
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/metrics"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MetricList, Metric> listMetricForAllNamespaces();

  /**
   * list objects of kind Metric
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/metrics"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MetricList, Metric> listMetricForAllNamespaces(
    @QueryMap ListMetricForAllNamespaces queryParameters);

  
  final class ListMetricForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListMetricForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListMetricForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListMetricForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListMetricForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListMetricForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListMetricForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListMetricForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListMetricForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListMetricForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of Metric
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedMetric(
    @Path("namespace") String namespace);

  /**
   * delete collection of Metric
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedMetric(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedMetric queryParameters);

  
  final class DeleteCollectionNamespacedMetric extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedMetric pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedMetric allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedMetric continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedMetric fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedMetric labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedMetric limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedMetric resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedMetric timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedMetric watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Metric
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MetricList, Metric> listNamespacedMetric(
    @Path("namespace") String namespace);

  /**
   * list objects of kind Metric
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MetricList, Metric> listNamespacedMetric(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedMetric queryParameters);

  
  final class ListNamespacedMetric extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedMetric pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedMetric allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedMetric continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedMetric fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedMetric labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedMetric limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedMetric resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedMetric timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedMetric watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a Metric
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Metric> createNamespacedMetric(
    @Path("namespace") String namespace, 
    @Body Metric body);

  /**
   * create a Metric
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Metric> createNamespacedMetric(
    @Path("namespace") String namespace, 
    @Body Metric body, 
    @QueryMap CreateNamespacedMetric queryParameters);

  
  final class CreateNamespacedMetric extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedMetric pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedMetric dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedMetric fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedMetric queryParameters);

  /**
   * delete a Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedMetric queryParameters);

  
  final class DeleteNamespacedMetric extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedMetric pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedMetric dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedMetric gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedMetric orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedMetric propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Metric> readNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Metric> readNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedMetric queryParameters);

  
  final class ReadNamespacedMetric extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedMetric pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedMetric resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Metric> patchNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body);

  /**
   * partially update the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Metric> patchNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body, 
    @QueryMap PatchNamespacedMetric queryParameters);

  
  final class PatchNamespacedMetric extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedMetric pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedMetric dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedMetric fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Metric> replaceNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body);

  /**
   * replace the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Metric> replaceNamespacedMetric(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body, 
    @QueryMap ReplaceNamespacedMetric queryParameters);

  
  final class ReplaceNamespacedMetric extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedMetric pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedMetric dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedMetric fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Metric> readNamespacedMetricStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Metric> readNamespacedMetricStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedMetricStatus queryParameters);

  
  final class ReadNamespacedMetricStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedMetricStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedMetricStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Metric> patchNamespacedMetricStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body);

  /**
   * partially update status of the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Metric> patchNamespacedMetricStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body, 
    @QueryMap PatchNamespacedMetricStatus queryParameters);

  
  final class PatchNamespacedMetricStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedMetricStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedMetricStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedMetricStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Metric> replaceNamespacedMetricStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body);

  /**
   * replace status of the specified Metric
   *
   * @param name name of the Metric
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/metrics/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Metric> replaceNamespacedMetricStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Metric body, 
    @QueryMap ReplaceNamespacedMetricStatus queryParameters);

  
  final class ReplaceNamespacedMetricStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedMetricStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedMetricStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedMetricStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of PodAutoscaler
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedPodAutoscaler(
    @Path("namespace") String namespace);

  /**
   * delete collection of PodAutoscaler
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedPodAutoscaler(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedPodAutoscaler queryParameters);

  
  final class DeleteCollectionNamespacedPodAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedPodAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedPodAutoscaler allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedPodAutoscaler continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedPodAutoscaler fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedPodAutoscaler labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedPodAutoscaler limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedPodAutoscaler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedPodAutoscaler timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedPodAutoscaler watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind PodAutoscaler
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodAutoscalerList, PodAutoscaler> listNamespacedPodAutoscaler(
    @Path("namespace") String namespace);

  /**
   * list objects of kind PodAutoscaler
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodAutoscalerList, PodAutoscaler> listNamespacedPodAutoscaler(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedPodAutoscaler queryParameters);

  
  final class ListNamespacedPodAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedPodAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedPodAutoscaler allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedPodAutoscaler continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedPodAutoscaler fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedPodAutoscaler labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedPodAutoscaler limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedPodAutoscaler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedPodAutoscaler timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedPodAutoscaler watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a PodAutoscaler
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> createNamespacedPodAutoscaler(
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body);

  /**
   * create a PodAutoscaler
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> createNamespacedPodAutoscaler(
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body, 
    @QueryMap CreateNamespacedPodAutoscaler queryParameters);

  
  final class CreateNamespacedPodAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedPodAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedPodAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedPodAutoscaler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedPodAutoscaler queryParameters);

  /**
   * delete a PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedPodAutoscaler queryParameters);

  
  final class DeleteNamespacedPodAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedPodAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedPodAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedPodAutoscaler gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedPodAutoscaler orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedPodAutoscaler propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> readNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> readNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedPodAutoscaler queryParameters);

  
  final class ReadNamespacedPodAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedPodAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedPodAutoscaler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> patchNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body);

  /**
   * partially update the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> patchNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body, 
    @QueryMap PatchNamespacedPodAutoscaler queryParameters);

  
  final class PatchNamespacedPodAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedPodAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedPodAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedPodAutoscaler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> replaceNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body);

  /**
   * replace the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> replaceNamespacedPodAutoscaler(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body, 
    @QueryMap ReplaceNamespacedPodAutoscaler queryParameters);

  
  final class ReplaceNamespacedPodAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedPodAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedPodAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedPodAutoscaler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> readNamespacedPodAutoscalerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> readNamespacedPodAutoscalerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedPodAutoscalerStatus queryParameters);

  
  final class ReadNamespacedPodAutoscalerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedPodAutoscalerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedPodAutoscalerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> patchNamespacedPodAutoscalerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body);

  /**
   * partially update status of the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> patchNamespacedPodAutoscalerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body, 
    @QueryMap PatchNamespacedPodAutoscalerStatus queryParameters);

  
  final class PatchNamespacedPodAutoscalerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedPodAutoscalerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedPodAutoscalerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedPodAutoscalerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> replaceNamespacedPodAutoscalerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body);

  /**
   * replace status of the specified PodAutoscaler
   *
   * @param name name of the PodAutoscaler
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/namespaces/{namespace}/podautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodAutoscaler> replaceNamespacedPodAutoscalerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodAutoscaler body, 
    @QueryMap ReplaceNamespacedPodAutoscalerStatus queryParameters);

  
  final class ReplaceNamespacedPodAutoscalerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedPodAutoscalerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedPodAutoscalerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedPodAutoscalerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * list objects of kind PodAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/podautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodAutoscalerList, PodAutoscaler> listPodAutoscalerForAllNamespaces();

  /**
   * list objects of kind PodAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.internal.knative.dev/v1alpha1/podautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodAutoscalerList, PodAutoscaler> listPodAutoscalerForAllNamespaces(
    @QueryMap ListPodAutoscalerForAllNamespaces queryParameters);

  
  final class ListPodAutoscalerForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListPodAutoscalerForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListPodAutoscalerForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListPodAutoscalerForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListPodAutoscalerForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListPodAutoscalerForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListPodAutoscalerForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListPodAutoscalerForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListPodAutoscalerForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListPodAutoscalerForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
