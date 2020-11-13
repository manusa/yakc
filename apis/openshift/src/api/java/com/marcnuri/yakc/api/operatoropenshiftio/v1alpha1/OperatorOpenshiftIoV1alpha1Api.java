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

package com.marcnuri.yakc.api.operatoropenshiftio.v1alpha1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.model.io.openshift.operator.v1alpha1.ImageContentSourcePolicy;
import com.marcnuri.yakc.model.io.openshift.operator.v1alpha1.ImageContentSourcePolicyList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface OperatorOpenshiftIoV1alpha1Api extends Api {
  /**
   * delete collection of ImageContentSourcePolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionImageContentSourcePolicy();

  /**
   * delete collection of ImageContentSourcePolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionImageContentSourcePolicy(
    @QueryMap DeleteCollectionImageContentSourcePolicy queryParameters);

  
  final class DeleteCollectionImageContentSourcePolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionImageContentSourcePolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionImageContentSourcePolicy allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionImageContentSourcePolicy continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionImageContentSourcePolicy fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionImageContentSourcePolicy labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionImageContentSourcePolicy limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionImageContentSourcePolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionImageContentSourcePolicy timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionImageContentSourcePolicy watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ImageContentSourcePolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ImageContentSourcePolicyList, ImageContentSourcePolicy> listImageContentSourcePolicy();

  /**
   * list objects of kind ImageContentSourcePolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ImageContentSourcePolicyList, ImageContentSourcePolicy> listImageContentSourcePolicy(
    @QueryMap ListImageContentSourcePolicy queryParameters);

  
  final class ListImageContentSourcePolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListImageContentSourcePolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListImageContentSourcePolicy allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListImageContentSourcePolicy continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListImageContentSourcePolicy fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListImageContentSourcePolicy labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListImageContentSourcePolicy limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListImageContentSourcePolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListImageContentSourcePolicy timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListImageContentSourcePolicy watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an ImageContentSourcePolicy
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> createImageContentSourcePolicy(
    @Body ImageContentSourcePolicy body);

  /**
   * create an ImageContentSourcePolicy
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> createImageContentSourcePolicy(
    @Body ImageContentSourcePolicy body, 
    @QueryMap CreateImageContentSourcePolicy queryParameters);

  
  final class CreateImageContentSourcePolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateImageContentSourcePolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateImageContentSourcePolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateImageContentSourcePolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteImageContentSourcePolicy(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete an ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteImageContentSourcePolicy(
    @Path("name") String name);

  /**
   * delete an ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteImageContentSourcePolicy(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteImageContentSourcePolicy queryParameters);

  /**
   * delete an ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteImageContentSourcePolicy(
    @Path("name") String name, 
    @QueryMap DeleteImageContentSourcePolicy queryParameters);

  
  final class DeleteImageContentSourcePolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteImageContentSourcePolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteImageContentSourcePolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteImageContentSourcePolicy gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteImageContentSourcePolicy orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteImageContentSourcePolicy propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> readImageContentSourcePolicy(
    @Path("name") String name);

  /**
   * read the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> readImageContentSourcePolicy(
    @Path("name") String name, 
    @QueryMap ReadImageContentSourcePolicy queryParameters);

  
  final class ReadImageContentSourcePolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadImageContentSourcePolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadImageContentSourcePolicy resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> patchImageContentSourcePolicy(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body);

  /**
   * partially update the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> patchImageContentSourcePolicy(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body, 
    @QueryMap PatchImageContentSourcePolicy queryParameters);

  
  final class PatchImageContentSourcePolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchImageContentSourcePolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchImageContentSourcePolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchImageContentSourcePolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> replaceImageContentSourcePolicy(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body);

  /**
   * replace the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> replaceImageContentSourcePolicy(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body, 
    @QueryMap ReplaceImageContentSourcePolicy queryParameters);

  
  final class ReplaceImageContentSourcePolicy extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceImageContentSourcePolicy pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceImageContentSourcePolicy dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceImageContentSourcePolicy fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> readImageContentSourcePolicyStatus(
    @Path("name") String name);

  /**
   * read status of the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> readImageContentSourcePolicyStatus(
    @Path("name") String name, 
    @QueryMap ReadImageContentSourcePolicyStatus queryParameters);

  
  final class ReadImageContentSourcePolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadImageContentSourcePolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadImageContentSourcePolicyStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> patchImageContentSourcePolicyStatus(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body);

  /**
   * partially update status of the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> patchImageContentSourcePolicyStatus(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body, 
    @QueryMap PatchImageContentSourcePolicyStatus queryParameters);

  
  final class PatchImageContentSourcePolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchImageContentSourcePolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchImageContentSourcePolicyStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchImageContentSourcePolicyStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> replaceImageContentSourcePolicyStatus(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body);

  /**
   * replace status of the specified ImageContentSourcePolicy
   *
   * @param name name of the ImageContentSourcePolicy
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ImageContentSourcePolicy> replaceImageContentSourcePolicyStatus(
    @Path("name") String name, 
    @Body ImageContentSourcePolicy body, 
    @QueryMap ReplaceImageContentSourcePolicyStatus queryParameters);

  
  final class ReplaceImageContentSourcePolicyStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceImageContentSourcePolicyStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceImageContentSourcePolicyStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceImageContentSourcePolicyStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
}
