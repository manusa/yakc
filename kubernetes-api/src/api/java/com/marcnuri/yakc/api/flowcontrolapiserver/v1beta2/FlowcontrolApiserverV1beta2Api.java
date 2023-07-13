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

package com.marcnuri.yakc.api.flowcontrolapiserver.v1beta2;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.api.flowcontrol.v1beta2.FlowSchema;
import com.marcnuri.yakc.model.io.k8s.api.flowcontrol.v1beta2.FlowSchemaList;
import com.marcnuri.yakc.model.io.k8s.api.flowcontrol.v1beta2.PriorityLevelConfiguration;
import com.marcnuri.yakc.model.io.k8s.api.flowcontrol.v1beta2.PriorityLevelConfigurationList;
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
public interface FlowcontrolApiserverV1beta2Api extends Api {
  /**
   * get available resources
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<APIResourceList> getAPIResources();

  /**
   * delete collection of FlowSchema
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionFlowSchema(
    @Body DeleteOptions body);

    /**
   * delete collection of FlowSchema
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionFlowSchema();

  /**
   * delete collection of FlowSchema
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionFlowSchema(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionFlowSchema queryParameters);

  /**
   * delete collection of FlowSchema
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionFlowSchema(
    @QueryMap DeleteCollectionFlowSchema queryParameters);

  
  final class DeleteCollectionFlowSchema extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionFlowSchema continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionFlowSchema dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionFlowSchema fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionFlowSchema gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionFlowSchema labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionFlowSchema limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionFlowSchema orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionFlowSchema propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionFlowSchema resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionFlowSchema resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionFlowSchema sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionFlowSchema timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<FlowSchemaList, FlowSchema> listFlowSchema();

  /**
   * list or watch objects of kind FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<FlowSchemaList, FlowSchema> listFlowSchema(
    @QueryMap ListFlowSchema queryParameters);

  
  final class ListFlowSchema extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListFlowSchema allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListFlowSchema continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListFlowSchema fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListFlowSchema labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListFlowSchema limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListFlowSchema resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListFlowSchema resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListFlowSchema sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListFlowSchema timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListFlowSchema watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a FlowSchema
   */
  @HTTP(
    method = "POST",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> createFlowSchema(
    @Body FlowSchema body);

  /**
   * create a FlowSchema
   */
  @HTTP(
    method = "POST",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> createFlowSchema(
    @Body FlowSchema body, 
    @QueryMap CreateFlowSchema queryParameters);

  
  final class CreateFlowSchema extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateFlowSchema dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateFlowSchema fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreateFlowSchema fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteFlowSchema(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a FlowSchema
   *
   * @param name name of the FlowSchema
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteFlowSchema(
    @Path("name") String name);

  /**
   * delete a FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteFlowSchema(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteFlowSchema queryParameters);

  /**
   * delete a FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteFlowSchema(
    @Path("name") String name, 
    @QueryMap DeleteFlowSchema queryParameters);

  
  final class DeleteFlowSchema extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteFlowSchema dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteFlowSchema gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteFlowSchema orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteFlowSchema propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> readFlowSchema(
    @Path("name") String name);

  /**
   * read the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> readFlowSchema(
    @Path("name") String name, 
    @QueryMap ReadFlowSchema queryParameters);

  
  final class ReadFlowSchema extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> patchFlowSchema(
    @Path("name") String name, 
    @Body FlowSchema body);

  /**
   * partially update the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> patchFlowSchema(
    @Path("name") String name, 
    @Body FlowSchema body, 
    @QueryMap PatchFlowSchema queryParameters);

  
  final class PatchFlowSchema extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchFlowSchema dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchFlowSchema fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchFlowSchema fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchFlowSchema force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> replaceFlowSchema(
    @Path("name") String name, 
    @Body FlowSchema body);

  /**
   * replace the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> replaceFlowSchema(
    @Path("name") String name, 
    @Body FlowSchema body, 
    @QueryMap ReplaceFlowSchema queryParameters);

  
  final class ReplaceFlowSchema extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceFlowSchema dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceFlowSchema fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceFlowSchema fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * read status of the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> readFlowSchemaStatus(
    @Path("name") String name);

  /**
   * read status of the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> readFlowSchemaStatus(
    @Path("name") String name, 
    @QueryMap ReadFlowSchemaStatus queryParameters);

  
  final class ReadFlowSchemaStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadFlowSchemaStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update status of the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> patchFlowSchemaStatus(
    @Path("name") String name, 
    @Body FlowSchema body);

  /**
   * partially update status of the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> patchFlowSchemaStatus(
    @Path("name") String name, 
    @Body FlowSchema body, 
    @QueryMap PatchFlowSchemaStatus queryParameters);

  
  final class PatchFlowSchemaStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchFlowSchemaStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchFlowSchemaStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchFlowSchemaStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchFlowSchemaStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchFlowSchemaStatus force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace status of the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> replaceFlowSchemaStatus(
    @Path("name") String name, 
    @Body FlowSchema body);

  /**
   * replace status of the specified FlowSchema
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/flowschemas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<FlowSchema> replaceFlowSchemaStatus(
    @Path("name") String name, 
    @Body FlowSchema body, 
    @QueryMap ReplaceFlowSchemaStatus queryParameters);

  
  final class ReplaceFlowSchemaStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceFlowSchemaStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceFlowSchemaStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceFlowSchemaStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceFlowSchemaStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete collection of PriorityLevelConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionPriorityLevelConfiguration(
    @Body DeleteOptions body);

    /**
   * delete collection of PriorityLevelConfiguration
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionPriorityLevelConfiguration();

  /**
   * delete collection of PriorityLevelConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionPriorityLevelConfiguration(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionPriorityLevelConfiguration queryParameters);

  /**
   * delete collection of PriorityLevelConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionPriorityLevelConfiguration(
    @QueryMap DeleteCollectionPriorityLevelConfiguration queryParameters);

  
  final class DeleteCollectionPriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionPriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionPriorityLevelConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionPriorityLevelConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionPriorityLevelConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionPriorityLevelConfiguration gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionPriorityLevelConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionPriorityLevelConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionPriorityLevelConfiguration orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionPriorityLevelConfiguration propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionPriorityLevelConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionPriorityLevelConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionPriorityLevelConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionPriorityLevelConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PriorityLevelConfigurationList, PriorityLevelConfiguration> listPriorityLevelConfiguration();

  /**
   * list or watch objects of kind PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<PriorityLevelConfigurationList, PriorityLevelConfiguration> listPriorityLevelConfiguration(
    @QueryMap ListPriorityLevelConfiguration queryParameters);

  
  final class ListPriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListPriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListPriorityLevelConfiguration allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListPriorityLevelConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListPriorityLevelConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListPriorityLevelConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListPriorityLevelConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListPriorityLevelConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListPriorityLevelConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListPriorityLevelConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListPriorityLevelConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListPriorityLevelConfiguration watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a PriorityLevelConfiguration
   */
  @HTTP(
    method = "POST",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> createPriorityLevelConfiguration(
    @Body PriorityLevelConfiguration body);

  /**
   * create a PriorityLevelConfiguration
   */
  @HTTP(
    method = "POST",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> createPriorityLevelConfiguration(
    @Body PriorityLevelConfiguration body, 
    @QueryMap CreatePriorityLevelConfiguration queryParameters);

  
  final class CreatePriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreatePriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreatePriorityLevelConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreatePriorityLevelConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreatePriorityLevelConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deletePriorityLevelConfiguration(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deletePriorityLevelConfiguration(
    @Path("name") String name);

  /**
   * delete a PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deletePriorityLevelConfiguration(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeletePriorityLevelConfiguration queryParameters);

  /**
   * delete a PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deletePriorityLevelConfiguration(
    @Path("name") String name, 
    @QueryMap DeletePriorityLevelConfiguration queryParameters);

  
  final class DeletePriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeletePriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeletePriorityLevelConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeletePriorityLevelConfiguration gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeletePriorityLevelConfiguration orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeletePriorityLevelConfiguration propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> readPriorityLevelConfiguration(
    @Path("name") String name);

  /**
   * read the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> readPriorityLevelConfiguration(
    @Path("name") String name, 
    @QueryMap ReadPriorityLevelConfiguration queryParameters);

  
  final class ReadPriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadPriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> patchPriorityLevelConfiguration(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body);

  /**
   * partially update the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> patchPriorityLevelConfiguration(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body, 
    @QueryMap PatchPriorityLevelConfiguration queryParameters);

  
  final class PatchPriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchPriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchPriorityLevelConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchPriorityLevelConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchPriorityLevelConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchPriorityLevelConfiguration force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> replacePriorityLevelConfiguration(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body);

  /**
   * replace the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> replacePriorityLevelConfiguration(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body, 
    @QueryMap ReplacePriorityLevelConfiguration queryParameters);

  
  final class ReplacePriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplacePriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplacePriorityLevelConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplacePriorityLevelConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplacePriorityLevelConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * read status of the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> readPriorityLevelConfigurationStatus(
    @Path("name") String name);

  /**
   * read status of the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> readPriorityLevelConfigurationStatus(
    @Path("name") String name, 
    @QueryMap ReadPriorityLevelConfigurationStatus queryParameters);

  
  final class ReadPriorityLevelConfigurationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadPriorityLevelConfigurationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update status of the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> patchPriorityLevelConfigurationStatus(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body);

  /**
   * partially update status of the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> patchPriorityLevelConfigurationStatus(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body, 
    @QueryMap PatchPriorityLevelConfigurationStatus queryParameters);

  
  final class PatchPriorityLevelConfigurationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchPriorityLevelConfigurationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchPriorityLevelConfigurationStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchPriorityLevelConfigurationStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchPriorityLevelConfigurationStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchPriorityLevelConfigurationStatus force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace status of the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> replacePriorityLevelConfigurationStatus(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body);

  /**
   * replace status of the specified PriorityLevelConfiguration
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/prioritylevelconfigurations/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<PriorityLevelConfiguration> replacePriorityLevelConfigurationStatus(
    @Path("name") String name, 
    @Body PriorityLevelConfiguration body, 
    @QueryMap ReplacePriorityLevelConfigurationStatus queryParameters);

  
  final class ReplacePriorityLevelConfigurationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplacePriorityLevelConfigurationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplacePriorityLevelConfigurationStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplacePriorityLevelConfigurationStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplacePriorityLevelConfigurationStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of FlowSchema. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/flowschemas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchFlowSchemaList();

  /**
   * watch individual changes to a list of FlowSchema. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/flowschemas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchFlowSchemaList(
    @QueryMap WatchFlowSchemaList queryParameters);

  
  final class WatchFlowSchemaList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchFlowSchemaList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchFlowSchemaList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchFlowSchemaList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchFlowSchemaList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchFlowSchemaList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchFlowSchemaList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchFlowSchemaList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchFlowSchemaList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchFlowSchemaList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchFlowSchemaList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchFlowSchemaList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind FlowSchema. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/flowschemas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchFlowSchema(
    @Path("name") String name);

  /**
   * watch changes to an object of kind FlowSchema. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the FlowSchema
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/flowschemas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchFlowSchema(
    @Path("name") String name, 
    @QueryMap WatchFlowSchema queryParameters);

  
  final class WatchFlowSchema extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchFlowSchema allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchFlowSchema continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchFlowSchema fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchFlowSchema labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchFlowSchema limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchFlowSchema pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchFlowSchema resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchFlowSchema resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchFlowSchema sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchFlowSchema timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchFlowSchema watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of PriorityLevelConfiguration. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/prioritylevelconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchPriorityLevelConfigurationList();

  /**
   * watch individual changes to a list of PriorityLevelConfiguration. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/prioritylevelconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchPriorityLevelConfigurationList(
    @QueryMap WatchPriorityLevelConfigurationList queryParameters);

  
  final class WatchPriorityLevelConfigurationList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchPriorityLevelConfigurationList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchPriorityLevelConfigurationList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchPriorityLevelConfigurationList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchPriorityLevelConfigurationList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchPriorityLevelConfigurationList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchPriorityLevelConfigurationList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchPriorityLevelConfigurationList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchPriorityLevelConfigurationList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchPriorityLevelConfigurationList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchPriorityLevelConfigurationList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchPriorityLevelConfigurationList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind PriorityLevelConfiguration. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/prioritylevelconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchPriorityLevelConfiguration(
    @Path("name") String name);

  /**
   * watch changes to an object of kind PriorityLevelConfiguration. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the PriorityLevelConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/flowcontrol.apiserver.k8s.io/v1beta2/watch/prioritylevelconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchPriorityLevelConfiguration(
    @Path("name") String name, 
    @QueryMap WatchPriorityLevelConfiguration queryParameters);

  
  final class WatchPriorityLevelConfiguration extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchPriorityLevelConfiguration allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchPriorityLevelConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchPriorityLevelConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchPriorityLevelConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchPriorityLevelConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchPriorityLevelConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchPriorityLevelConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchPriorityLevelConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchPriorityLevelConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchPriorityLevelConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchPriorityLevelConfiguration watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
