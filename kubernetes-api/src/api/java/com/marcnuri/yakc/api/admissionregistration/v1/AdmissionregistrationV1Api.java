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

package com.marcnuri.yakc.api.admissionregistration.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.MutatingWebhookConfiguration;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.MutatingWebhookConfigurationList;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.ValidatingAdmissionPolicy;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.ValidatingAdmissionPolicyBinding;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.ValidatingAdmissionPolicyBindingList;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.ValidatingAdmissionPolicyList;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.ValidatingWebhookConfiguration;
import com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1.ValidatingWebhookConfigurationList;
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
public interface AdmissionregistrationV1Api extends Api {
  /**
   * get available resources
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<APIResourceList> getAPIResources();

  /**
   * delete collection of MutatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMutatingWebhookConfiguration(
    @Body DeleteOptions body);

    /**
   * delete collection of MutatingWebhookConfiguration
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMutatingWebhookConfiguration();

  /**
   * delete collection of MutatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMutatingWebhookConfiguration(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionMutatingWebhookConfiguration queryParameters);

  /**
   * delete collection of MutatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMutatingWebhookConfiguration(
    @QueryMap DeleteCollectionMutatingWebhookConfiguration queryParameters);

  
  final class DeleteCollectionMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteCollectionMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionMutatingWebhookConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionMutatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionMutatingWebhookConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionMutatingWebhookConfiguration gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionMutatingWebhookConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionMutatingWebhookConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionMutatingWebhookConfiguration orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionMutatingWebhookConfiguration propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionMutatingWebhookConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionMutatingWebhookConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionMutatingWebhookConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionMutatingWebhookConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind MutatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MutatingWebhookConfigurationList, MutatingWebhookConfiguration> listMutatingWebhookConfiguration();

  /**
   * list or watch objects of kind MutatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MutatingWebhookConfigurationList, MutatingWebhookConfiguration> listMutatingWebhookConfiguration(
    @QueryMap ListMutatingWebhookConfiguration queryParameters);

  
  final class ListMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ListMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListMutatingWebhookConfiguration allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListMutatingWebhookConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListMutatingWebhookConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListMutatingWebhookConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListMutatingWebhookConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListMutatingWebhookConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListMutatingWebhookConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListMutatingWebhookConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListMutatingWebhookConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListMutatingWebhookConfiguration watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a MutatingWebhookConfiguration
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> createMutatingWebhookConfiguration(
    @Body MutatingWebhookConfiguration body);

  /**
   * create a MutatingWebhookConfiguration
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> createMutatingWebhookConfiguration(
    @Body MutatingWebhookConfiguration body, 
    @QueryMap CreateMutatingWebhookConfiguration queryParameters);

  
  final class CreateMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public CreateMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateMutatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateMutatingWebhookConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreateMutatingWebhookConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMutatingWebhookConfiguration(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMutatingWebhookConfiguration(
    @Path("name") String name);

  /**
   * delete a MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMutatingWebhookConfiguration(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteMutatingWebhookConfiguration queryParameters);

  /**
   * delete a MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMutatingWebhookConfiguration(
    @Path("name") String name, 
    @QueryMap DeleteMutatingWebhookConfiguration queryParameters);

  
  final class DeleteMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteMutatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteMutatingWebhookConfiguration gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteMutatingWebhookConfiguration orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteMutatingWebhookConfiguration propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> readMutatingWebhookConfiguration(
    @Path("name") String name);

  /**
   * read the specified MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> readMutatingWebhookConfiguration(
    @Path("name") String name, 
    @QueryMap ReadMutatingWebhookConfiguration queryParameters);

  
  final class ReadMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReadMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> patchMutatingWebhookConfiguration(
    @Path("name") String name, 
    @Body MutatingWebhookConfiguration body);

  /**
   * partially update the specified MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> patchMutatingWebhookConfiguration(
    @Path("name") String name, 
    @Body MutatingWebhookConfiguration body, 
    @QueryMap PatchMutatingWebhookConfiguration queryParameters);

  
  final class PatchMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public PatchMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchMutatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchMutatingWebhookConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchMutatingWebhookConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchMutatingWebhookConfiguration force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> replaceMutatingWebhookConfiguration(
    @Path("name") String name, 
    @Body MutatingWebhookConfiguration body);

  /**
   * replace the specified MutatingWebhookConfiguration
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/mutatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MutatingWebhookConfiguration> replaceMutatingWebhookConfiguration(
    @Path("name") String name, 
    @Body MutatingWebhookConfiguration body, 
    @QueryMap ReplaceMutatingWebhookConfiguration queryParameters);

  
  final class ReplaceMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReplaceMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceMutatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceMutatingWebhookConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceMutatingWebhookConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete collection of ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicy(
    @Body DeleteOptions body);

    /**
   * delete collection of ValidatingAdmissionPolicy
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicy();

  /**
   * delete collection of ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicy(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionValidatingAdmissionPolicy queryParameters);

  /**
   * delete collection of ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicy(
    @QueryMap DeleteCollectionValidatingAdmissionPolicy queryParameters);

  
  final class DeleteCollectionValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteCollectionValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionValidatingAdmissionPolicy continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionValidatingAdmissionPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionValidatingAdmissionPolicy fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionValidatingAdmissionPolicy gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionValidatingAdmissionPolicy labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionValidatingAdmissionPolicy limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionValidatingAdmissionPolicy orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionValidatingAdmissionPolicy propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionValidatingAdmissionPolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionValidatingAdmissionPolicy resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionValidatingAdmissionPolicy sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionValidatingAdmissionPolicy timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ValidatingAdmissionPolicyList, ValidatingAdmissionPolicy> listValidatingAdmissionPolicy();

  /**
   * list or watch objects of kind ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ValidatingAdmissionPolicyList, ValidatingAdmissionPolicy> listValidatingAdmissionPolicy(
    @QueryMap ListValidatingAdmissionPolicy queryParameters);

  
  final class ListValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ListValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListValidatingAdmissionPolicy allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListValidatingAdmissionPolicy continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListValidatingAdmissionPolicy fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListValidatingAdmissionPolicy labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListValidatingAdmissionPolicy limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListValidatingAdmissionPolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListValidatingAdmissionPolicy resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListValidatingAdmissionPolicy sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListValidatingAdmissionPolicy timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListValidatingAdmissionPolicy watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> createValidatingAdmissionPolicy(
    @Body ValidatingAdmissionPolicy body);

  /**
   * create a ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> createValidatingAdmissionPolicy(
    @Body ValidatingAdmissionPolicy body, 
    @QueryMap CreateValidatingAdmissionPolicy queryParameters);

  
  final class CreateValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public CreateValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateValidatingAdmissionPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateValidatingAdmissionPolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreateValidatingAdmissionPolicy fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicy(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicy(
    @Path("name") String name);

  /**
   * delete a ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicy(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteValidatingAdmissionPolicy queryParameters);

  /**
   * delete a ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicy(
    @Path("name") String name, 
    @QueryMap DeleteValidatingAdmissionPolicy queryParameters);

  
  final class DeleteValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteValidatingAdmissionPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteValidatingAdmissionPolicy gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteValidatingAdmissionPolicy orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteValidatingAdmissionPolicy propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> readValidatingAdmissionPolicy(
    @Path("name") String name);

  /**
   * read the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> readValidatingAdmissionPolicy(
    @Path("name") String name, 
    @QueryMap ReadValidatingAdmissionPolicy queryParameters);

  
  final class ReadValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReadValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> patchValidatingAdmissionPolicy(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body);

  /**
   * partially update the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> patchValidatingAdmissionPolicy(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body, 
    @QueryMap PatchValidatingAdmissionPolicy queryParameters);

  
  final class PatchValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public PatchValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchValidatingAdmissionPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchValidatingAdmissionPolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchValidatingAdmissionPolicy fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchValidatingAdmissionPolicy force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> replaceValidatingAdmissionPolicy(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body);

  /**
   * replace the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> replaceValidatingAdmissionPolicy(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body, 
    @QueryMap ReplaceValidatingAdmissionPolicy queryParameters);

  
  final class ReplaceValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReplaceValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceValidatingAdmissionPolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceValidatingAdmissionPolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceValidatingAdmissionPolicy fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * read status of the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> readValidatingAdmissionPolicyStatus(
    @Path("name") String name);

  /**
   * read status of the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> readValidatingAdmissionPolicyStatus(
    @Path("name") String name, 
    @QueryMap ReadValidatingAdmissionPolicyStatus queryParameters);

  
  final class ReadValidatingAdmissionPolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReadValidatingAdmissionPolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update status of the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> patchValidatingAdmissionPolicyStatus(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body);

  /**
   * partially update status of the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> patchValidatingAdmissionPolicyStatus(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body, 
    @QueryMap PatchValidatingAdmissionPolicyStatus queryParameters);

  
  final class PatchValidatingAdmissionPolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public PatchValidatingAdmissionPolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchValidatingAdmissionPolicyStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchValidatingAdmissionPolicyStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchValidatingAdmissionPolicyStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchValidatingAdmissionPolicyStatus force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace status of the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> replaceValidatingAdmissionPolicyStatus(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body);

  /**
   * replace status of the specified ValidatingAdmissionPolicy
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicy> replaceValidatingAdmissionPolicyStatus(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicy body, 
    @QueryMap ReplaceValidatingAdmissionPolicyStatus queryParameters);

  
  final class ReplaceValidatingAdmissionPolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReplaceValidatingAdmissionPolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceValidatingAdmissionPolicyStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceValidatingAdmissionPolicyStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceValidatingAdmissionPolicyStatus fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete collection of ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicyBinding(
    @Body DeleteOptions body);

    /**
   * delete collection of ValidatingAdmissionPolicyBinding
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicyBinding();

  /**
   * delete collection of ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicyBinding(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionValidatingAdmissionPolicyBinding queryParameters);

  /**
   * delete collection of ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingAdmissionPolicyBinding(
    @QueryMap DeleteCollectionValidatingAdmissionPolicyBinding queryParameters);

  
  final class DeleteCollectionValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionValidatingAdmissionPolicyBinding timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ValidatingAdmissionPolicyBindingList, ValidatingAdmissionPolicyBinding> listValidatingAdmissionPolicyBinding();

  /**
   * list or watch objects of kind ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ValidatingAdmissionPolicyBindingList, ValidatingAdmissionPolicyBinding> listValidatingAdmissionPolicyBinding(
    @QueryMap ListValidatingAdmissionPolicyBinding queryParameters);

  
  final class ListValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ListValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListValidatingAdmissionPolicyBinding allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListValidatingAdmissionPolicyBinding continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListValidatingAdmissionPolicyBinding fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListValidatingAdmissionPolicyBinding labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListValidatingAdmissionPolicyBinding limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListValidatingAdmissionPolicyBinding resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListValidatingAdmissionPolicyBinding resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListValidatingAdmissionPolicyBinding sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListValidatingAdmissionPolicyBinding timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListValidatingAdmissionPolicyBinding watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> createValidatingAdmissionPolicyBinding(
    @Body ValidatingAdmissionPolicyBinding body);

  /**
   * create a ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> createValidatingAdmissionPolicyBinding(
    @Body ValidatingAdmissionPolicyBinding body, 
    @QueryMap CreateValidatingAdmissionPolicyBinding queryParameters);

  
  final class CreateValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public CreateValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateValidatingAdmissionPolicyBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateValidatingAdmissionPolicyBinding fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreateValidatingAdmissionPolicyBinding fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicyBinding(
    @Path("name") String name);

  /**
   * delete a ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteValidatingAdmissionPolicyBinding queryParameters);

  /**
   * delete a ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @QueryMap DeleteValidatingAdmissionPolicyBinding queryParameters);

  
  final class DeleteValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteValidatingAdmissionPolicyBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteValidatingAdmissionPolicyBinding gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteValidatingAdmissionPolicyBinding orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteValidatingAdmissionPolicyBinding propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> readValidatingAdmissionPolicyBinding(
    @Path("name") String name);

  /**
   * read the specified ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> readValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @QueryMap ReadValidatingAdmissionPolicyBinding queryParameters);

  
  final class ReadValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReadValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> patchValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicyBinding body);

  /**
   * partially update the specified ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> patchValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicyBinding body, 
    @QueryMap PatchValidatingAdmissionPolicyBinding queryParameters);

  
  final class PatchValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public PatchValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchValidatingAdmissionPolicyBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchValidatingAdmissionPolicyBinding fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchValidatingAdmissionPolicyBinding fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchValidatingAdmissionPolicyBinding force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> replaceValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicyBinding body);

  /**
   * replace the specified ValidatingAdmissionPolicyBinding
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingadmissionpolicybindings/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingAdmissionPolicyBinding> replaceValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @Body ValidatingAdmissionPolicyBinding body, 
    @QueryMap ReplaceValidatingAdmissionPolicyBinding queryParameters);

  
  final class ReplaceValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReplaceValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceValidatingAdmissionPolicyBinding dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceValidatingAdmissionPolicyBinding fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceValidatingAdmissionPolicyBinding fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete collection of ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingWebhookConfiguration(
    @Body DeleteOptions body);

    /**
   * delete collection of ValidatingWebhookConfiguration
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingWebhookConfiguration();

  /**
   * delete collection of ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingWebhookConfiguration(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionValidatingWebhookConfiguration queryParameters);

  /**
   * delete collection of ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionValidatingWebhookConfiguration(
    @QueryMap DeleteCollectionValidatingWebhookConfiguration queryParameters);

  
  final class DeleteCollectionValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteCollectionValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionValidatingWebhookConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionValidatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionValidatingWebhookConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionValidatingWebhookConfiguration gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionValidatingWebhookConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionValidatingWebhookConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionValidatingWebhookConfiguration orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionValidatingWebhookConfiguration propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionValidatingWebhookConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionValidatingWebhookConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public DeleteCollectionValidatingWebhookConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionValidatingWebhookConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ValidatingWebhookConfigurationList, ValidatingWebhookConfiguration> listValidatingWebhookConfiguration();

  /**
   * list or watch objects of kind ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ValidatingWebhookConfigurationList, ValidatingWebhookConfiguration> listValidatingWebhookConfiguration(
    @QueryMap ListValidatingWebhookConfiguration queryParameters);

  
  final class ListValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ListValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public ListValidatingWebhookConfiguration allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListValidatingWebhookConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListValidatingWebhookConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListValidatingWebhookConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListValidatingWebhookConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListValidatingWebhookConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListValidatingWebhookConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public ListValidatingWebhookConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListValidatingWebhookConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListValidatingWebhookConfiguration watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> createValidatingWebhookConfiguration(
    @Body ValidatingWebhookConfiguration body);

  /**
   * create a ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "POST",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> createValidatingWebhookConfiguration(
    @Body ValidatingWebhookConfiguration body, 
    @QueryMap CreateValidatingWebhookConfiguration queryParameters);

  
  final class CreateValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public CreateValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateValidatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateValidatingWebhookConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public CreateValidatingWebhookConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * delete a ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingWebhookConfiguration(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingWebhookConfiguration(
    @Path("name") String name);

  /**
   * delete a ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingWebhookConfiguration(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteValidatingWebhookConfiguration queryParameters);

  /**
   * delete a ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteValidatingWebhookConfiguration(
    @Path("name") String name, 
    @QueryMap DeleteValidatingWebhookConfiguration queryParameters);

  
  final class DeleteValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public DeleteValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteValidatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteValidatingWebhookConfiguration gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteValidatingWebhookConfiguration orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteValidatingWebhookConfiguration propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> readValidatingWebhookConfiguration(
    @Path("name") String name);

  /**
   * read the specified ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> readValidatingWebhookConfiguration(
    @Path("name") String name, 
    @QueryMap ReadValidatingWebhookConfiguration queryParameters);

  
  final class ReadValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReadValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update the specified ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> patchValidatingWebhookConfiguration(
    @Path("name") String name, 
    @Body ValidatingWebhookConfiguration body);

  /**
   * partially update the specified ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> patchValidatingWebhookConfiguration(
    @Path("name") String name, 
    @Body ValidatingWebhookConfiguration body, 
    @QueryMap PatchValidatingWebhookConfiguration queryParameters);

  
  final class PatchValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public PatchValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchValidatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchValidatingWebhookConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public PatchValidatingWebhookConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchValidatingWebhookConfiguration force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> replaceValidatingWebhookConfiguration(
    @Path("name") String name, 
    @Body ValidatingWebhookConfiguration body);

  /**
   * replace the specified ValidatingWebhookConfiguration
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "PUT",
    path = "/apis/admissionregistration.k8s.io/v1/validatingwebhookconfigurations/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ValidatingWebhookConfiguration> replaceValidatingWebhookConfiguration(
    @Path("name") String name, 
    @Body ValidatingWebhookConfiguration body, 
    @QueryMap ReplaceValidatingWebhookConfiguration queryParameters);

  
  final class ReplaceValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public ReplaceValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceValidatingWebhookConfiguration dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceValidatingWebhookConfiguration fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * fieldValidation instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields. Valid values are: - Ignore: This will ignore any unknown fields that are silently dropped from the object, and will ignore all but the last duplicate field that the decoder encounters. This is the default behavior prior to v1.23. - Warn: This will send a warning via the standard warning response header for each unknown field that is dropped from the object, and for each duplicate field that is encountered. The request will still succeed if there are no other errors, and will only persist the last of any duplicate fields. This is the default in v1.23+ - Strict: This will fail the request with a BadRequest error if any unknown fields would be dropped from the object, or if any duplicate fields are present. The error returned from the server will contain all unknown and duplicate fields encountered.
     */
    public ReplaceValidatingWebhookConfiguration fieldValidation(String fieldValidation) {
      put("fieldValidation", fieldValidation);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of MutatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/mutatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchMutatingWebhookConfigurationList();

  /**
   * watch individual changes to a list of MutatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/mutatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchMutatingWebhookConfigurationList(
    @QueryMap WatchMutatingWebhookConfigurationList queryParameters);

  
  final class WatchMutatingWebhookConfigurationList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchMutatingWebhookConfigurationList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchMutatingWebhookConfigurationList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchMutatingWebhookConfigurationList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchMutatingWebhookConfigurationList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchMutatingWebhookConfigurationList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchMutatingWebhookConfigurationList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchMutatingWebhookConfigurationList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchMutatingWebhookConfigurationList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchMutatingWebhookConfigurationList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchMutatingWebhookConfigurationList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchMutatingWebhookConfigurationList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind MutatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/mutatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchMutatingWebhookConfiguration(
    @Path("name") String name);

  /**
   * watch changes to an object of kind MutatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the MutatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/mutatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchMutatingWebhookConfiguration(
    @Path("name") String name, 
    @QueryMap WatchMutatingWebhookConfiguration queryParameters);

  
  final class WatchMutatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchMutatingWebhookConfiguration allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchMutatingWebhookConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchMutatingWebhookConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchMutatingWebhookConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchMutatingWebhookConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchMutatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchMutatingWebhookConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchMutatingWebhookConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchMutatingWebhookConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchMutatingWebhookConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchMutatingWebhookConfiguration watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of ValidatingAdmissionPolicy. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicyList();

  /**
   * watch individual changes to a list of ValidatingAdmissionPolicy. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicyList(
    @QueryMap WatchValidatingAdmissionPolicyList queryParameters);

  
  final class WatchValidatingAdmissionPolicyList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchValidatingAdmissionPolicyList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchValidatingAdmissionPolicyList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicyList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicyList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchValidatingAdmissionPolicyList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchValidatingAdmissionPolicyList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicyList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicyList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchValidatingAdmissionPolicyList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchValidatingAdmissionPolicyList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchValidatingAdmissionPolicyList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind ValidatingAdmissionPolicy. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicy(
    @Path("name") String name);

  /**
   * watch changes to an object of kind ValidatingAdmissionPolicy. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ValidatingAdmissionPolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicy(
    @Path("name") String name, 
    @QueryMap WatchValidatingAdmissionPolicy queryParameters);

  
  final class WatchValidatingAdmissionPolicy extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchValidatingAdmissionPolicy allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchValidatingAdmissionPolicy continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicy fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicy labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchValidatingAdmissionPolicy limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchValidatingAdmissionPolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicy resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchValidatingAdmissionPolicy sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchValidatingAdmissionPolicy timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchValidatingAdmissionPolicy watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of ValidatingAdmissionPolicyBinding. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicybindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicyBindingList();

  /**
   * watch individual changes to a list of ValidatingAdmissionPolicyBinding. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicybindings"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicyBindingList(
    @QueryMap WatchValidatingAdmissionPolicyBindingList queryParameters);

  
  final class WatchValidatingAdmissionPolicyBindingList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchValidatingAdmissionPolicyBindingList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchValidatingAdmissionPolicyBindingList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicyBindingList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicyBindingList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchValidatingAdmissionPolicyBindingList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchValidatingAdmissionPolicyBindingList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicyBindingList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicyBindingList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchValidatingAdmissionPolicyBindingList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchValidatingAdmissionPolicyBindingList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchValidatingAdmissionPolicyBindingList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind ValidatingAdmissionPolicyBinding. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicybindings/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicyBinding(
    @Path("name") String name);

  /**
   * watch changes to an object of kind ValidatingAdmissionPolicyBinding. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ValidatingAdmissionPolicyBinding
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingadmissionpolicybindings/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingAdmissionPolicyBinding(
    @Path("name") String name, 
    @QueryMap WatchValidatingAdmissionPolicyBinding queryParameters);

  
  final class WatchValidatingAdmissionPolicyBinding extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchValidatingAdmissionPolicyBinding allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchValidatingAdmissionPolicyBinding continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicyBinding fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchValidatingAdmissionPolicyBinding labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchValidatingAdmissionPolicyBinding limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchValidatingAdmissionPolicyBinding pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicyBinding resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingAdmissionPolicyBinding resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchValidatingAdmissionPolicyBinding sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchValidatingAdmissionPolicyBinding timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchValidatingAdmissionPolicyBinding watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of ValidatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingWebhookConfigurationList();

  /**
   * watch individual changes to a list of ValidatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingwebhookconfigurations"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingWebhookConfigurationList(
    @QueryMap WatchValidatingWebhookConfigurationList queryParameters);

  
  final class WatchValidatingWebhookConfigurationList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchValidatingWebhookConfigurationList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchValidatingWebhookConfigurationList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchValidatingWebhookConfigurationList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchValidatingWebhookConfigurationList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchValidatingWebhookConfigurationList limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchValidatingWebhookConfigurationList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingWebhookConfigurationList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingWebhookConfigurationList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchValidatingWebhookConfigurationList sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchValidatingWebhookConfigurationList timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchValidatingWebhookConfigurationList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind ValidatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingWebhookConfiguration(
    @Path("name") String name);

  /**
   * watch changes to an object of kind ValidatingWebhookConfiguration. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the ValidatingWebhookConfiguration
   */
  @HTTP(
    method = "GET",
    path = "/apis/admissionregistration.k8s.io/v1/watch/validatingwebhookconfigurations/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchValidatingWebhookConfiguration(
    @Path("name") String name, 
    @QueryMap WatchValidatingWebhookConfiguration queryParameters);

  
  final class WatchValidatingWebhookConfiguration extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored.
     */
    public WatchValidatingWebhookConfiguration allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchValidatingWebhookConfiguration continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchValidatingWebhookConfiguration fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchValidatingWebhookConfiguration labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchValidatingWebhookConfiguration limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed. Defaults to 'false' unless the user-agent indicates a browser or command-line HTTP tool (curl and wget).
     */
    public WatchValidatingWebhookConfiguration pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingWebhookConfiguration resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchValidatingWebhookConfiguration resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * `sendInitialEvents=true` may be set together with `watch=true`. In that case, the watch stream will begin with synthetic events to produce the current state of objects in the collection. Once all such events have been sent, a synthetic "Bookmark" event  will be sent. The bookmark will report the ResourceVersion (RV) corresponding to the set of objects, and be marked with `"k8s.io/initial-events-end": "true"` annotation. Afterwards, the watch stream will proceed as usual, sending watch events corresponding to changes (subsequent to the RV) to objects watched.<br><p> <br><p> When `sendInitialEvents` option is set, we require `resourceVersionMatch` option to also be set. The semantic of the watch request is as following: - `resourceVersionMatch` = NotOlderThan<br><p>   is interpreted as "data at least as new as the provided `resourceVersion`"<br><p>   and the bookmark event is send when the state is synced<br><p>   to a `resourceVersion` at least as fresh as the one provided by the ListOptions.<br><p>   If `resourceVersion` is unset, this is interpreted as "consistent read" and the<br><p>   bookmark event is send when the state is synced at least to the moment<br><p>   when request started being processed.<br><p> - `resourceVersionMatch` set to any other value or unset<br><p>   Invalid error is returned.<br><p> <br><p> Defaults to true if `resourceVersion=""` or `resourceVersion="0"` (for backward compatibility reasons) and to false otherwise.
     */
    public WatchValidatingWebhookConfiguration sendInitialEvents(Boolean sendInitialEvents) {
      put("sendInitialEvents", sendInitialEvents);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchValidatingWebhookConfiguration timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchValidatingWebhookConfiguration watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
