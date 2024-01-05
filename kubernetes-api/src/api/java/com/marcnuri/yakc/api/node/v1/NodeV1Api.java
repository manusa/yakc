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

package com.marcnuri.yakc.api.node.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.api.node.v1.RuntimeClass;
import com.marcnuri.yakc.model.io.k8s.api.node.v1.RuntimeClassList;
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
public interface NodeV1Api extends Api {
  /**
   * get available resources
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<APIResourceList> getAPIResources();

  /**
   * delete collection of RuntimeClass
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionRuntimeClass(
    @Body DeleteOptions body);

    /**
   * delete collection of RuntimeClass
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionRuntimeClass();

  /**
   * delete collection of RuntimeClass
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionRuntimeClass(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionRuntimeClass queryParameters);

  /**
   * delete collection of RuntimeClass
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionRuntimeClass(
    @QueryMap DeleteCollectionRuntimeClass queryParameters);

  
  final class DeleteCollectionRuntimeClass extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteCollectionRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionRuntimeClass continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionRuntimeClass dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionRuntimeClass fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionRuntimeClass gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionRuntimeClass labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionRuntimeClass limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionRuntimeClass orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionRuntimeClass propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionRuntimeClass resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionRuntimeClass resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionRuntimeClass sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionRuntimeClass timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind RuntimeClass
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/runtimeclasses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<RuntimeClassList, RuntimeClass> listRuntimeClass();

  /**
   * list or watch objects of kind RuntimeClass
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/runtimeclasses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<RuntimeClassList, RuntimeClass> listRuntimeClass(
    @QueryMap ListRuntimeClass queryParameters);

  
  final class ListRuntimeClass extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ListRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListRuntimeClass allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListRuntimeClass continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListRuntimeClass fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListRuntimeClass labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListRuntimeClass limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListRuntimeClass resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListRuntimeClass resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListRuntimeClass sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListRuntimeClass timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListRuntimeClass watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a RuntimeClass
   */
  @HTTP(
    method = "POST",
    path = "/apis/node.k8s.io/v1/runtimeclasses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> createRuntimeClass(
    @Body RuntimeClass body);

  /**
   * create a RuntimeClass
   */
  @HTTP(
    method = "POST",
    path = "/apis/node.k8s.io/v1/runtimeclasses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> createRuntimeClass(
    @Body RuntimeClass body, 
    @QueryMap CreateRuntimeClass queryParameters);

  
  final class CreateRuntimeClass extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public CreateRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateRuntimeClass dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateRuntimeClass fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreateRuntimeClass fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteRuntimeClass(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteRuntimeClass(
    @Path("name") String name);

  /**
   * delete a RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteRuntimeClass(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteRuntimeClass queryParameters);

  /**
   * delete a RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteRuntimeClass(
    @Path("name") String name, 
    @QueryMap DeleteRuntimeClass queryParameters);

  
  final class DeleteRuntimeClass extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteRuntimeClass dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteRuntimeClass gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteRuntimeClass orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteRuntimeClass propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> readRuntimeClass(
    @Path("name") String name);

  /**
   * read the specified RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> readRuntimeClass(
    @Path("name") String name, 
    @QueryMap ReadRuntimeClass queryParameters);

  
  final class ReadRuntimeClass extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReadRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> patchRuntimeClass(
    @Path("name") String name, 
    @Body RuntimeClass body);

  /**
   * partially update the specified RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> patchRuntimeClass(
    @Path("name") String name, 
    @Body RuntimeClass body, 
    @QueryMap PatchRuntimeClass queryParameters);

  
  final class PatchRuntimeClass extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public PatchRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchRuntimeClass dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchRuntimeClass fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchRuntimeClass fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchRuntimeClass force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "PUT",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> replaceRuntimeClass(
    @Path("name") String name, 
    @Body RuntimeClass body);

  /**
   * replace the specified RuntimeClass
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "PUT",
    path = "/apis/node.k8s.io/v1/runtimeclasses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<RuntimeClass> replaceRuntimeClass(
    @Path("name") String name, 
    @Body RuntimeClass body, 
    @QueryMap ReplaceRuntimeClass queryParameters);

  
  final class ReplaceRuntimeClass extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReplaceRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceRuntimeClass dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceRuntimeClass fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceRuntimeClass fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of RuntimeClass. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/watch/runtimeclasses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchRuntimeClassList();

  /**
   * watch individual changes to a list of RuntimeClass. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/watch/runtimeclasses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchRuntimeClassList(
    @QueryMap WatchRuntimeClassList queryParameters);

  
  final class WatchRuntimeClassList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchRuntimeClassList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchRuntimeClassList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchRuntimeClassList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchRuntimeClassList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchRuntimeClassList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchRuntimeClassList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchRuntimeClassList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchRuntimeClassList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchRuntimeClassList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchRuntimeClassList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchRuntimeClassList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind RuntimeClass. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/watch/runtimeclasses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchRuntimeClass(
    @Path("name") String name);

  /**
   * watch changes to an object of kind RuntimeClass. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the RuntimeClass
   */
  @HTTP(
    method = "GET",
    path = "/apis/node.k8s.io/v1/watch/runtimeclasses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchRuntimeClass(
    @Path("name") String name, 
    @QueryMap WatchRuntimeClass queryParameters);

  
  final class WatchRuntimeClass extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchRuntimeClass allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchRuntimeClass continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchRuntimeClass fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchRuntimeClass labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchRuntimeClass limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchRuntimeClass pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchRuntimeClass resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchRuntimeClass resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchRuntimeClass sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchRuntimeClass timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchRuntimeClass watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
