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

package com.marcnuri.yakc.api.autoscalingopenshiftio.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.model.io.openshift.autoscaling.v1.ClusterAutoscaler;
import com.marcnuri.yakc.model.io.openshift.autoscaling.v1.ClusterAutoscalerList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface AutoscalingOpenshiftIoV1Api extends Api {
  /**
   * delete collection of ClusterAutoscaler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionClusterAutoscaler();

  /**
   * delete collection of ClusterAutoscaler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionClusterAutoscaler(
    @QueryMap DeleteCollectionClusterAutoscaler queryParameters);

  
  final class DeleteCollectionClusterAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionClusterAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionClusterAutoscaler allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionClusterAutoscaler continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionClusterAutoscaler fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionClusterAutoscaler labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionClusterAutoscaler limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionClusterAutoscaler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionClusterAutoscaler timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionClusterAutoscaler watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ClusterAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ClusterAutoscalerList, ClusterAutoscaler> listClusterAutoscaler();

  /**
   * list objects of kind ClusterAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ClusterAutoscalerList, ClusterAutoscaler> listClusterAutoscaler(
    @QueryMap ListClusterAutoscaler queryParameters);

  
  final class ListClusterAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListClusterAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListClusterAutoscaler allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListClusterAutoscaler continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListClusterAutoscaler fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListClusterAutoscaler labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListClusterAutoscaler limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListClusterAutoscaler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListClusterAutoscaler timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListClusterAutoscaler watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ClusterAutoscaler
   */
  @HTTP(
    method = "POST",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> createClusterAutoscaler(
    @Body ClusterAutoscaler body);

  /**
   * create a ClusterAutoscaler
   */
  @HTTP(
    method = "POST",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> createClusterAutoscaler(
    @Body ClusterAutoscaler body, 
    @QueryMap CreateClusterAutoscaler queryParameters);

  
  final class CreateClusterAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateClusterAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateClusterAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateClusterAutoscaler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterAutoscaler(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterAutoscaler(
    @Path("name") String name);

  /**
   * delete a ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterAutoscaler(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteClusterAutoscaler queryParameters);

  /**
   * delete a ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterAutoscaler(
    @Path("name") String name, 
    @QueryMap DeleteClusterAutoscaler queryParameters);

  
  final class DeleteClusterAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteClusterAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteClusterAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteClusterAutoscaler gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteClusterAutoscaler orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteClusterAutoscaler propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> readClusterAutoscaler(
    @Path("name") String name);

  /**
   * read the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> readClusterAutoscaler(
    @Path("name") String name, 
    @QueryMap ReadClusterAutoscaler queryParameters);

  
  final class ReadClusterAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadClusterAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadClusterAutoscaler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> patchClusterAutoscaler(
    @Path("name") String name, 
    @Body ClusterAutoscaler body);

  /**
   * partially update the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> patchClusterAutoscaler(
    @Path("name") String name, 
    @Body ClusterAutoscaler body, 
    @QueryMap PatchClusterAutoscaler queryParameters);

  
  final class PatchClusterAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchClusterAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchClusterAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchClusterAutoscaler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> replaceClusterAutoscaler(
    @Path("name") String name, 
    @Body ClusterAutoscaler body);

  /**
   * replace the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> replaceClusterAutoscaler(
    @Path("name") String name, 
    @Body ClusterAutoscaler body, 
    @QueryMap ReplaceClusterAutoscaler queryParameters);

  
  final class ReplaceClusterAutoscaler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceClusterAutoscaler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceClusterAutoscaler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceClusterAutoscaler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> readClusterAutoscalerStatus(
    @Path("name") String name);

  /**
   * read status of the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "GET",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> readClusterAutoscalerStatus(
    @Path("name") String name, 
    @QueryMap ReadClusterAutoscalerStatus queryParameters);

  
  final class ReadClusterAutoscalerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadClusterAutoscalerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadClusterAutoscalerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> patchClusterAutoscalerStatus(
    @Path("name") String name, 
    @Body ClusterAutoscaler body);

  /**
   * partially update status of the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> patchClusterAutoscalerStatus(
    @Path("name") String name, 
    @Body ClusterAutoscaler body, 
    @QueryMap PatchClusterAutoscalerStatus queryParameters);

  
  final class PatchClusterAutoscalerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchClusterAutoscalerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchClusterAutoscalerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchClusterAutoscalerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> replaceClusterAutoscalerStatus(
    @Path("name") String name, 
    @Body ClusterAutoscaler body);

  /**
   * replace status of the specified ClusterAutoscaler
   *
   * @param name name of the ClusterAutoscaler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/autoscaling.openshift.io/v1/clusterautoscalers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterAutoscaler> replaceClusterAutoscalerStatus(
    @Path("name") String name, 
    @Body ClusterAutoscaler body, 
    @QueryMap ReplaceClusterAutoscalerStatus queryParameters);

  
  final class ReplaceClusterAutoscalerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceClusterAutoscalerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceClusterAutoscalerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceClusterAutoscalerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
}
