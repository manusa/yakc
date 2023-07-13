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

package com.marcnuri.yakc.api.policy.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.api.policy.v1.PodDisruptionBudget;
import com.marcnuri.yakc.model.io.k8s.api.policy.v1.PodDisruptionBudgetList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.WatchEvent;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface PolicyV1Api extends Api {
  /**
   * get available resources
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<APIResourceList> getAPIResources();

  /**
   * delete collection of PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete collection of PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace);

  /**
   * delete collection of PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionNamespacedPodDisruptionBudget queryParameters);

  /**
   * delete collection of PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedPodDisruptionBudget queryParameters);

  
  final class DeleteCollectionNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionNamespacedPodDisruptionBudget dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedPodDisruptionBudget resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedPodDisruptionBudget resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedPodDisruptionBudget timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodDisruptionBudgetList, PodDisruptionBudget> listNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace);

  /**
   * list or watch objects of kind PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodDisruptionBudgetList, PodDisruptionBudget> listNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedPodDisruptionBudget queryParameters);

  
  final class ListNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListNamespacedPodDisruptionBudget allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedPodDisruptionBudget continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedPodDisruptionBudget fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedPodDisruptionBudget labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedPodDisruptionBudget limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedPodDisruptionBudget resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedPodDisruptionBudget resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListNamespacedPodDisruptionBudget sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedPodDisruptionBudget timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedPodDisruptionBudget watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> createNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body);

  /**
   * create a PodDisruptionBudget
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> createNamespacedPodDisruptionBudget(
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body, 
    @QueryMap CreateNamespacedPodDisruptionBudget queryParameters);

  
  final class CreateNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedPodDisruptionBudget dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedPodDisruptionBudget fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreateNamespacedPodDisruptionBudget fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete a PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedPodDisruptionBudget queryParameters);

  /**
   * delete a PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedPodDisruptionBudget queryParameters);

  
  final class DeleteNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedPodDisruptionBudget dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedPodDisruptionBudget gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedPodDisruptionBudget orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedPodDisruptionBudget propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> readNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> readNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedPodDisruptionBudget queryParameters);

  
  final class ReadNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> patchNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body);

  /**
   * partially update the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> patchNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body, 
    @QueryMap PatchNamespacedPodDisruptionBudget queryParameters);

  
  final class PatchNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedPodDisruptionBudget dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchNamespacedPodDisruptionBudget fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchNamespacedPodDisruptionBudget fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchNamespacedPodDisruptionBudget force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> replaceNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body);

  /**
   * replace the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> replaceNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body, 
    @QueryMap ReplaceNamespacedPodDisruptionBudget queryParameters);

  
  final class ReplaceNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedPodDisruptionBudget dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedPodDisruptionBudget fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceNamespacedPodDisruptionBudget fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * read status of the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> readNamespacedPodDisruptionBudgetStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> readNamespacedPodDisruptionBudgetStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedPodDisruptionBudgetStatus queryParameters);

  
  final class ReadNamespacedPodDisruptionBudgetStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedPodDisruptionBudgetStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update status of the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> patchNamespacedPodDisruptionBudgetStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body);

  /**
   * partially update status of the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> patchNamespacedPodDisruptionBudgetStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body, 
    @QueryMap PatchNamespacedPodDisruptionBudgetStatus queryParameters);

  
  final class PatchNamespacedPodDisruptionBudgetStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedPodDisruptionBudgetStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedPodDisruptionBudgetStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchNamespacedPodDisruptionBudgetStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchNamespacedPodDisruptionBudgetStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchNamespacedPodDisruptionBudgetStatus force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace status of the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> replaceNamespacedPodDisruptionBudgetStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body);

  /**
   * replace status of the specified PodDisruptionBudget
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/policy/v1/namespaces/{namespace}/poddisruptionbudgets/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PodDisruptionBudget> replaceNamespacedPodDisruptionBudgetStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body PodDisruptionBudget body, 
    @QueryMap ReplaceNamespacedPodDisruptionBudgetStatus queryParameters);

  
  final class ReplaceNamespacedPodDisruptionBudgetStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedPodDisruptionBudgetStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedPodDisruptionBudgetStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedPodDisruptionBudgetStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceNamespacedPodDisruptionBudgetStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * list or watch objects of kind PodDisruptionBudget
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodDisruptionBudgetList, PodDisruptionBudget> listPodDisruptionBudgetForAllNamespaces();

  /**
   * list or watch objects of kind PodDisruptionBudget
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PodDisruptionBudgetList, PodDisruptionBudget> listPodDisruptionBudgetForAllNamespaces(
    @QueryMap ListPodDisruptionBudgetForAllNamespaces queryParameters);

  
  final class ListPodDisruptionBudgetForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListPodDisruptionBudgetForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListPodDisruptionBudgetForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListPodDisruptionBudgetForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListPodDisruptionBudgetForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListPodDisruptionBudgetForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListPodDisruptionBudgetForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListPodDisruptionBudgetForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListPodDisruptionBudgetForAllNamespaces resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListPodDisruptionBudgetForAllNamespaces sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListPodDisruptionBudgetForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListPodDisruptionBudgetForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of PodDisruptionBudget. deprecated: use the 'watch' parameter with a list operation instead.
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/watch/namespaces/{namespace}/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchNamespacedPodDisruptionBudgetList(
    @Path("namespace") String namespace);

  /**
   * watch individual changes to a list of PodDisruptionBudget. deprecated: use the 'watch' parameter with a list operation instead.
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/watch/namespaces/{namespace}/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchNamespacedPodDisruptionBudgetList(
    @Path("namespace") String namespace, 
    @QueryMap WatchNamespacedPodDisruptionBudgetList queryParameters);

  
  final class WatchNamespacedPodDisruptionBudgetList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchNamespacedPodDisruptionBudgetList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchNamespacedPodDisruptionBudgetList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchNamespacedPodDisruptionBudgetList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchNamespacedPodDisruptionBudgetList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchNamespacedPodDisruptionBudgetList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchNamespacedPodDisruptionBudgetList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchNamespacedPodDisruptionBudgetList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchNamespacedPodDisruptionBudgetList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchNamespacedPodDisruptionBudgetList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchNamespacedPodDisruptionBudgetList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchNamespacedPodDisruptionBudgetList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind PodDisruptionBudget. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/watch/namespaces/{namespace}/poddisruptionbudgets/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * watch changes to an object of kind PodDisruptionBudget. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the PodDisruptionBudget
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/watch/namespaces/{namespace}/poddisruptionbudgets/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchNamespacedPodDisruptionBudget(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap WatchNamespacedPodDisruptionBudget queryParameters);

  
  final class WatchNamespacedPodDisruptionBudget extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchNamespacedPodDisruptionBudget allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchNamespacedPodDisruptionBudget continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchNamespacedPodDisruptionBudget fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchNamespacedPodDisruptionBudget labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchNamespacedPodDisruptionBudget limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchNamespacedPodDisruptionBudget pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchNamespacedPodDisruptionBudget resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchNamespacedPodDisruptionBudget resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchNamespacedPodDisruptionBudget sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchNamespacedPodDisruptionBudget timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchNamespacedPodDisruptionBudget watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of PodDisruptionBudget. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/watch/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchPodDisruptionBudgetListForAllNamespaces();

  /**
   * watch individual changes to a list of PodDisruptionBudget. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/policy/v1/watch/poddisruptionbudgets"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchPodDisruptionBudgetListForAllNamespaces(
    @QueryMap WatchPodDisruptionBudgetListForAllNamespaces queryParameters);

  
  final class WatchPodDisruptionBudgetListForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchPodDisruptionBudgetListForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchPodDisruptionBudgetListForAllNamespaces resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchPodDisruptionBudgetListForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
