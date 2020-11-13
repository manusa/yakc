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

package com.marcnuri.yakc.api.quotaopenshiftio.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.com.github.openshift.api.quota.v1.AppliedClusterResourceQuota;
import com.marcnuri.yakc.model.com.github.openshift.api.quota.v1.AppliedClusterResourceQuotaList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.WatchEvent;
import com.marcnuri.yakc.model.io.openshift.quota.v1.ClusterResourceQuota;
import com.marcnuri.yakc.model.io.openshift.quota.v1.ClusterResourceQuotaList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface QuotaOpenshiftIoV1Api extends Api {
  /**
   * get available resources
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<APIResourceList> getAPIResources();

  /**
   * list objects of kind AppliedClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/appliedclusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AppliedClusterResourceQuotaList, AppliedClusterResourceQuota> listAppliedClusterResourceQuotaForAllNamespaces();

  /**
   * list objects of kind AppliedClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/appliedclusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AppliedClusterResourceQuotaList, AppliedClusterResourceQuota> listAppliedClusterResourceQuotaForAllNamespaces(
    @QueryMap ListAppliedClusterResourceQuotaForAllNamespaces queryParameters);

  
  final class ListAppliedClusterResourceQuotaForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListAppliedClusterResourceQuotaForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of ClusterResourceQuota
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionClusterResourceQuota();

  /**
   * delete collection of ClusterResourceQuota
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionClusterResourceQuota(
    @QueryMap DeleteCollectionClusterResourceQuota queryParameters);

  
  final class DeleteCollectionClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionClusterResourceQuota allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionClusterResourceQuota continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionClusterResourceQuota fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionClusterResourceQuota labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionClusterResourceQuota limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionClusterResourceQuota resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionClusterResourceQuota timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionClusterResourceQuota watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ClusterResourceQuotaList, ClusterResourceQuota> listClusterResourceQuota();

  /**
   * list objects of kind ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ClusterResourceQuotaList, ClusterResourceQuota> listClusterResourceQuota(
    @QueryMap ListClusterResourceQuota queryParameters);

  
  final class ListClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListClusterResourceQuota allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListClusterResourceQuota continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListClusterResourceQuota fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListClusterResourceQuota labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListClusterResourceQuota limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListClusterResourceQuota resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListClusterResourceQuota timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListClusterResourceQuota watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ClusterResourceQuota
   */
  @HTTP(
    method = "POST",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> createClusterResourceQuota(
    @Body ClusterResourceQuota body);

  /**
   * create a ClusterResourceQuota
   */
  @HTTP(
    method = "POST",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> createClusterResourceQuota(
    @Body ClusterResourceQuota body, 
    @QueryMap CreateClusterResourceQuota queryParameters);

  
  final class CreateClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateClusterResourceQuota dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateClusterResourceQuota fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterResourceQuota(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterResourceQuota(
    @Path("name") String name);

  /**
   * delete a ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterResourceQuota(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteClusterResourceQuota queryParameters);

  /**
   * delete a ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteClusterResourceQuota(
    @Path("name") String name, 
    @QueryMap DeleteClusterResourceQuota queryParameters);

  
  final class DeleteClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteClusterResourceQuota dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteClusterResourceQuota gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteClusterResourceQuota orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteClusterResourceQuota propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> readClusterResourceQuota(
    @Path("name") String name);

  /**
   * read the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> readClusterResourceQuota(
    @Path("name") String name, 
    @QueryMap ReadClusterResourceQuota queryParameters);

  
  final class ReadClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadClusterResourceQuota resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> patchClusterResourceQuota(
    @Path("name") String name, 
    @Body ClusterResourceQuota body);

  /**
   * partially update the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> patchClusterResourceQuota(
    @Path("name") String name, 
    @Body ClusterResourceQuota body, 
    @QueryMap PatchClusterResourceQuota queryParameters);

  
  final class PatchClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchClusterResourceQuota dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchClusterResourceQuota fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PUT",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> replaceClusterResourceQuota(
    @Path("name") String name, 
    @Body ClusterResourceQuota body);

  /**
   * replace the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PUT",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> replaceClusterResourceQuota(
    @Path("name") String name, 
    @Body ClusterResourceQuota body, 
    @QueryMap ReplaceClusterResourceQuota queryParameters);

  
  final class ReplaceClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceClusterResourceQuota dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceClusterResourceQuota fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> readClusterResourceQuotaStatus(
    @Path("name") String name);

  /**
   * read status of the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> readClusterResourceQuotaStatus(
    @Path("name") String name, 
    @QueryMap ReadClusterResourceQuotaStatus queryParameters);

  
  final class ReadClusterResourceQuotaStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadClusterResourceQuotaStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadClusterResourceQuotaStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> patchClusterResourceQuotaStatus(
    @Path("name") String name, 
    @Body ClusterResourceQuota body);

  /**
   * partially update status of the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> patchClusterResourceQuotaStatus(
    @Path("name") String name, 
    @Body ClusterResourceQuota body, 
    @QueryMap PatchClusterResourceQuotaStatus queryParameters);

  
  final class PatchClusterResourceQuotaStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchClusterResourceQuotaStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchClusterResourceQuotaStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchClusterResourceQuotaStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PUT",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> replaceClusterResourceQuotaStatus(
    @Path("name") String name, 
    @Body ClusterResourceQuota body);

  /**
   * replace status of the specified ClusterResourceQuota
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "PUT",
    path = "/apis/quota.openshift.io/v1/clusterresourcequotas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ClusterResourceQuota> replaceClusterResourceQuotaStatus(
    @Path("name") String name, 
    @Body ClusterResourceQuota body, 
    @QueryMap ReplaceClusterResourceQuotaStatus queryParameters);

  
  final class ReplaceClusterResourceQuotaStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceClusterResourceQuotaStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceClusterResourceQuotaStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceClusterResourceQuotaStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * list objects of kind AppliedClusterResourceQuota
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/namespaces/{namespace}/appliedclusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AppliedClusterResourceQuotaList, AppliedClusterResourceQuota> listNamespacedAppliedClusterResourceQuota(
    @Path("namespace") String namespace);

  /**
   * list objects of kind AppliedClusterResourceQuota
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/namespaces/{namespace}/appliedclusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AppliedClusterResourceQuotaList, AppliedClusterResourceQuota> listNamespacedAppliedClusterResourceQuota(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedAppliedClusterResourceQuota queryParameters);

  
  final class ListNamespacedAppliedClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedAppliedClusterResourceQuota allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedAppliedClusterResourceQuota continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedAppliedClusterResourceQuota fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedAppliedClusterResourceQuota labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedAppliedClusterResourceQuota limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedAppliedClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedAppliedClusterResourceQuota resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedAppliedClusterResourceQuota timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedAppliedClusterResourceQuota watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * read the specified AppliedClusterResourceQuota
   *
   * @param name name of the AppliedClusterResourceQuota
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/namespaces/{namespace}/appliedclusterresourcequotas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<AppliedClusterResourceQuota> readNamespacedAppliedClusterResourceQuota(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified AppliedClusterResourceQuota
   *
   * @param name name of the AppliedClusterResourceQuota
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/namespaces/{namespace}/appliedclusterresourcequotas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<AppliedClusterResourceQuota> readNamespacedAppliedClusterResourceQuota(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedAppliedClusterResourceQuota queryParameters);

  
  final class ReadNamespacedAppliedClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedAppliedClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of ClusterResourceQuota. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/watch/clusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchClusterResourceQuotaList();

  /**
   * watch individual changes to a list of ClusterResourceQuota. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/watch/clusterresourcequotas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchClusterResourceQuotaList(
    @QueryMap WatchClusterResourceQuotaList queryParameters);

  
  final class WatchClusterResourceQuotaList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public WatchClusterResourceQuotaList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchClusterResourceQuotaList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchClusterResourceQuotaList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchClusterResourceQuotaList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchClusterResourceQuotaList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchClusterResourceQuotaList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public WatchClusterResourceQuotaList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchClusterResourceQuotaList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchClusterResourceQuotaList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind ClusterResourceQuota. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/watch/clusterresourcequotas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchClusterResourceQuota(
    @Path("name") String name);

  /**
   * watch changes to an object of kind ClusterResourceQuota. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ClusterResourceQuota
   */
  @HTTP(
    method = "GET",
    path = "/apis/quota.openshift.io/v1/watch/clusterresourcequotas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchClusterResourceQuota(
    @Path("name") String name, 
    @QueryMap WatchClusterResourceQuota queryParameters);

  
  final class WatchClusterResourceQuota extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public WatchClusterResourceQuota allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchClusterResourceQuota continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchClusterResourceQuota fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchClusterResourceQuota labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchClusterResourceQuota limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchClusterResourceQuota pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public WatchClusterResourceQuota resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchClusterResourceQuota timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchClusterResourceQuota watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
