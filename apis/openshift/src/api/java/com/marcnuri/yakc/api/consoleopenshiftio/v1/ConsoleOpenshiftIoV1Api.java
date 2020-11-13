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

package com.marcnuri.yakc.api.consoleopenshiftio.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleCLIDownload;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleCLIDownloadList;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleExternalLogLink;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleExternalLogLinkList;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleLink;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleLinkList;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleNotification;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleNotificationList;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleYAMLSample;
import com.marcnuri.yakc.model.io.openshift.console.v1.ConsoleYAMLSampleList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface ConsoleOpenshiftIoV1Api extends Api {
  /**
   * delete collection of ConsoleCLIDownload
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleclidownloads"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleCLIDownload();

  /**
   * delete collection of ConsoleCLIDownload
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleclidownloads"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleCLIDownload(
    @QueryMap DeleteCollectionConsoleCLIDownload queryParameters);

  
  final class DeleteCollectionConsoleCLIDownload extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionConsoleCLIDownload pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionConsoleCLIDownload allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionConsoleCLIDownload continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionConsoleCLIDownload fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionConsoleCLIDownload labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionConsoleCLIDownload limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionConsoleCLIDownload resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionConsoleCLIDownload timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionConsoleCLIDownload watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ConsoleCLIDownload
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleclidownloads"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleCLIDownloadList, ConsoleCLIDownload> listConsoleCLIDownload();

  /**
   * list objects of kind ConsoleCLIDownload
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleclidownloads"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleCLIDownloadList, ConsoleCLIDownload> listConsoleCLIDownload(
    @QueryMap ListConsoleCLIDownload queryParameters);

  
  final class ListConsoleCLIDownload extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListConsoleCLIDownload pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListConsoleCLIDownload allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListConsoleCLIDownload continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListConsoleCLIDownload fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListConsoleCLIDownload labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListConsoleCLIDownload limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListConsoleCLIDownload resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListConsoleCLIDownload timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListConsoleCLIDownload watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ConsoleCLIDownload
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consoleclidownloads",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> createConsoleCLIDownload(
    @Body ConsoleCLIDownload body);

  /**
   * create a ConsoleCLIDownload
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consoleclidownloads",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> createConsoleCLIDownload(
    @Body ConsoleCLIDownload body, 
    @QueryMap CreateConsoleCLIDownload queryParameters);

  
  final class CreateConsoleCLIDownload extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateConsoleCLIDownload pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateConsoleCLIDownload dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateConsoleCLIDownload fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleCLIDownload(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleCLIDownload(
    @Path("name") String name);

  /**
   * delete a ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleCLIDownload(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteConsoleCLIDownload queryParameters);

  /**
   * delete a ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleCLIDownload(
    @Path("name") String name, 
    @QueryMap DeleteConsoleCLIDownload queryParameters);

  
  final class DeleteConsoleCLIDownload extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteConsoleCLIDownload pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteConsoleCLIDownload dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteConsoleCLIDownload gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteConsoleCLIDownload orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteConsoleCLIDownload propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> readConsoleCLIDownload(
    @Path("name") String name);

  /**
   * read the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> readConsoleCLIDownload(
    @Path("name") String name, 
    @QueryMap ReadConsoleCLIDownload queryParameters);

  
  final class ReadConsoleCLIDownload extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleCLIDownload pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleCLIDownload resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> patchConsoleCLIDownload(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body);

  /**
   * partially update the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> patchConsoleCLIDownload(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body, 
    @QueryMap PatchConsoleCLIDownload queryParameters);

  
  final class PatchConsoleCLIDownload extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleCLIDownload pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleCLIDownload dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleCLIDownload fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> replaceConsoleCLIDownload(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body);

  /**
   * replace the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> replaceConsoleCLIDownload(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body, 
    @QueryMap ReplaceConsoleCLIDownload queryParameters);

  
  final class ReplaceConsoleCLIDownload extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleCLIDownload pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleCLIDownload dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleCLIDownload fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> readConsoleCLIDownloadStatus(
    @Path("name") String name);

  /**
   * read status of the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> readConsoleCLIDownloadStatus(
    @Path("name") String name, 
    @QueryMap ReadConsoleCLIDownloadStatus queryParameters);

  
  final class ReadConsoleCLIDownloadStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleCLIDownloadStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleCLIDownloadStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> patchConsoleCLIDownloadStatus(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body);

  /**
   * partially update status of the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> patchConsoleCLIDownloadStatus(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body, 
    @QueryMap PatchConsoleCLIDownloadStatus queryParameters);

  
  final class PatchConsoleCLIDownloadStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleCLIDownloadStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleCLIDownloadStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleCLIDownloadStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> replaceConsoleCLIDownloadStatus(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body);

  /**
   * replace status of the specified ConsoleCLIDownload
   *
   * @param name name of the ConsoleCLIDownload
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleclidownloads/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleCLIDownload> replaceConsoleCLIDownloadStatus(
    @Path("name") String name, 
    @Body ConsoleCLIDownload body, 
    @QueryMap ReplaceConsoleCLIDownloadStatus queryParameters);

  
  final class ReplaceConsoleCLIDownloadStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleCLIDownloadStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleCLIDownloadStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleCLIDownloadStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ConsoleExternalLogLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleExternalLogLink();

  /**
   * delete collection of ConsoleExternalLogLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleExternalLogLink(
    @QueryMap DeleteCollectionConsoleExternalLogLink queryParameters);

  
  final class DeleteCollectionConsoleExternalLogLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionConsoleExternalLogLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionConsoleExternalLogLink allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionConsoleExternalLogLink continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionConsoleExternalLogLink fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionConsoleExternalLogLink labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionConsoleExternalLogLink limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionConsoleExternalLogLink resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionConsoleExternalLogLink timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionConsoleExternalLogLink watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ConsoleExternalLogLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleExternalLogLinkList, ConsoleExternalLogLink> listConsoleExternalLogLink();

  /**
   * list objects of kind ConsoleExternalLogLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleExternalLogLinkList, ConsoleExternalLogLink> listConsoleExternalLogLink(
    @QueryMap ListConsoleExternalLogLink queryParameters);

  
  final class ListConsoleExternalLogLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListConsoleExternalLogLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListConsoleExternalLogLink allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListConsoleExternalLogLink continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListConsoleExternalLogLink fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListConsoleExternalLogLink labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListConsoleExternalLogLink limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListConsoleExternalLogLink resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListConsoleExternalLogLink timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListConsoleExternalLogLink watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ConsoleExternalLogLink
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> createConsoleExternalLogLink(
    @Body ConsoleExternalLogLink body);

  /**
   * create a ConsoleExternalLogLink
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> createConsoleExternalLogLink(
    @Body ConsoleExternalLogLink body, 
    @QueryMap CreateConsoleExternalLogLink queryParameters);

  
  final class CreateConsoleExternalLogLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateConsoleExternalLogLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateConsoleExternalLogLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateConsoleExternalLogLink fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleExternalLogLink(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleExternalLogLink(
    @Path("name") String name);

  /**
   * delete a ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleExternalLogLink(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteConsoleExternalLogLink queryParameters);

  /**
   * delete a ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleExternalLogLink(
    @Path("name") String name, 
    @QueryMap DeleteConsoleExternalLogLink queryParameters);

  
  final class DeleteConsoleExternalLogLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteConsoleExternalLogLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteConsoleExternalLogLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteConsoleExternalLogLink gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteConsoleExternalLogLink orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteConsoleExternalLogLink propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> readConsoleExternalLogLink(
    @Path("name") String name);

  /**
   * read the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> readConsoleExternalLogLink(
    @Path("name") String name, 
    @QueryMap ReadConsoleExternalLogLink queryParameters);

  
  final class ReadConsoleExternalLogLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleExternalLogLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleExternalLogLink resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> patchConsoleExternalLogLink(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body);

  /**
   * partially update the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> patchConsoleExternalLogLink(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body, 
    @QueryMap PatchConsoleExternalLogLink queryParameters);

  
  final class PatchConsoleExternalLogLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleExternalLogLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleExternalLogLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleExternalLogLink fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> replaceConsoleExternalLogLink(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body);

  /**
   * replace the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> replaceConsoleExternalLogLink(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body, 
    @QueryMap ReplaceConsoleExternalLogLink queryParameters);

  
  final class ReplaceConsoleExternalLogLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleExternalLogLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleExternalLogLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleExternalLogLink fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> readConsoleExternalLogLinkStatus(
    @Path("name") String name);

  /**
   * read status of the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> readConsoleExternalLogLinkStatus(
    @Path("name") String name, 
    @QueryMap ReadConsoleExternalLogLinkStatus queryParameters);

  
  final class ReadConsoleExternalLogLinkStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleExternalLogLinkStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleExternalLogLinkStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> patchConsoleExternalLogLinkStatus(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body);

  /**
   * partially update status of the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> patchConsoleExternalLogLinkStatus(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body, 
    @QueryMap PatchConsoleExternalLogLinkStatus queryParameters);

  
  final class PatchConsoleExternalLogLinkStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleExternalLogLinkStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleExternalLogLinkStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleExternalLogLinkStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> replaceConsoleExternalLogLinkStatus(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body);

  /**
   * replace status of the specified ConsoleExternalLogLink
   *
   * @param name name of the ConsoleExternalLogLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleexternalloglinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleExternalLogLink> replaceConsoleExternalLogLinkStatus(
    @Path("name") String name, 
    @Body ConsoleExternalLogLink body, 
    @QueryMap ReplaceConsoleExternalLogLinkStatus queryParameters);

  
  final class ReplaceConsoleExternalLogLinkStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleExternalLogLinkStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleExternalLogLinkStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleExternalLogLinkStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ConsoleLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolelinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleLink();

  /**
   * delete collection of ConsoleLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolelinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleLink(
    @QueryMap DeleteCollectionConsoleLink queryParameters);

  
  final class DeleteCollectionConsoleLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionConsoleLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionConsoleLink allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionConsoleLink continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionConsoleLink fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionConsoleLink labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionConsoleLink limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionConsoleLink resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionConsoleLink timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionConsoleLink watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ConsoleLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolelinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleLinkList, ConsoleLink> listConsoleLink();

  /**
   * list objects of kind ConsoleLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolelinks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleLinkList, ConsoleLink> listConsoleLink(
    @QueryMap ListConsoleLink queryParameters);

  
  final class ListConsoleLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListConsoleLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListConsoleLink allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListConsoleLink continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListConsoleLink fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListConsoleLink labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListConsoleLink limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListConsoleLink resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListConsoleLink timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListConsoleLink watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ConsoleLink
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consolelinks",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> createConsoleLink(
    @Body ConsoleLink body);

  /**
   * create a ConsoleLink
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consolelinks",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> createConsoleLink(
    @Body ConsoleLink body, 
    @QueryMap CreateConsoleLink queryParameters);

  
  final class CreateConsoleLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateConsoleLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateConsoleLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateConsoleLink fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleLink(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleLink(
    @Path("name") String name);

  /**
   * delete a ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleLink(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteConsoleLink queryParameters);

  /**
   * delete a ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleLink(
    @Path("name") String name, 
    @QueryMap DeleteConsoleLink queryParameters);

  
  final class DeleteConsoleLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteConsoleLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteConsoleLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteConsoleLink gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteConsoleLink orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteConsoleLink propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> readConsoleLink(
    @Path("name") String name);

  /**
   * read the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> readConsoleLink(
    @Path("name") String name, 
    @QueryMap ReadConsoleLink queryParameters);

  
  final class ReadConsoleLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleLink resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> patchConsoleLink(
    @Path("name") String name, 
    @Body ConsoleLink body);

  /**
   * partially update the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> patchConsoleLink(
    @Path("name") String name, 
    @Body ConsoleLink body, 
    @QueryMap PatchConsoleLink queryParameters);

  
  final class PatchConsoleLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleLink fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> replaceConsoleLink(
    @Path("name") String name, 
    @Body ConsoleLink body);

  /**
   * replace the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> replaceConsoleLink(
    @Path("name") String name, 
    @Body ConsoleLink body, 
    @QueryMap ReplaceConsoleLink queryParameters);

  
  final class ReplaceConsoleLink extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleLink pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleLink dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleLink fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> readConsoleLinkStatus(
    @Path("name") String name);

  /**
   * read status of the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> readConsoleLinkStatus(
    @Path("name") String name, 
    @QueryMap ReadConsoleLinkStatus queryParameters);

  
  final class ReadConsoleLinkStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleLinkStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleLinkStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> patchConsoleLinkStatus(
    @Path("name") String name, 
    @Body ConsoleLink body);

  /**
   * partially update status of the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> patchConsoleLinkStatus(
    @Path("name") String name, 
    @Body ConsoleLink body, 
    @QueryMap PatchConsoleLinkStatus queryParameters);

  
  final class PatchConsoleLinkStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleLinkStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleLinkStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleLinkStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> replaceConsoleLinkStatus(
    @Path("name") String name, 
    @Body ConsoleLink body);

  /**
   * replace status of the specified ConsoleLink
   *
   * @param name name of the ConsoleLink
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolelinks/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleLink> replaceConsoleLinkStatus(
    @Path("name") String name, 
    @Body ConsoleLink body, 
    @QueryMap ReplaceConsoleLinkStatus queryParameters);

  
  final class ReplaceConsoleLinkStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleLinkStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleLinkStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleLinkStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ConsoleNotification
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolenotifications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleNotification();

  /**
   * delete collection of ConsoleNotification
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolenotifications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleNotification(
    @QueryMap DeleteCollectionConsoleNotification queryParameters);

  
  final class DeleteCollectionConsoleNotification extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionConsoleNotification pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionConsoleNotification allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionConsoleNotification continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionConsoleNotification fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionConsoleNotification labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionConsoleNotification limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionConsoleNotification resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionConsoleNotification timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionConsoleNotification watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ConsoleNotification
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolenotifications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleNotificationList, ConsoleNotification> listConsoleNotification();

  /**
   * list objects of kind ConsoleNotification
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolenotifications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleNotificationList, ConsoleNotification> listConsoleNotification(
    @QueryMap ListConsoleNotification queryParameters);

  
  final class ListConsoleNotification extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListConsoleNotification pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListConsoleNotification allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListConsoleNotification continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListConsoleNotification fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListConsoleNotification labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListConsoleNotification limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListConsoleNotification resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListConsoleNotification timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListConsoleNotification watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ConsoleNotification
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consolenotifications",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> createConsoleNotification(
    @Body ConsoleNotification body);

  /**
   * create a ConsoleNotification
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consolenotifications",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> createConsoleNotification(
    @Body ConsoleNotification body, 
    @QueryMap CreateConsoleNotification queryParameters);

  
  final class CreateConsoleNotification extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateConsoleNotification pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateConsoleNotification dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateConsoleNotification fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleNotification(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleNotification(
    @Path("name") String name);

  /**
   * delete a ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleNotification(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteConsoleNotification queryParameters);

  /**
   * delete a ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleNotification(
    @Path("name") String name, 
    @QueryMap DeleteConsoleNotification queryParameters);

  
  final class DeleteConsoleNotification extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteConsoleNotification pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteConsoleNotification dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteConsoleNotification gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteConsoleNotification orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteConsoleNotification propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> readConsoleNotification(
    @Path("name") String name);

  /**
   * read the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> readConsoleNotification(
    @Path("name") String name, 
    @QueryMap ReadConsoleNotification queryParameters);

  
  final class ReadConsoleNotification extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleNotification pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleNotification resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> patchConsoleNotification(
    @Path("name") String name, 
    @Body ConsoleNotification body);

  /**
   * partially update the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> patchConsoleNotification(
    @Path("name") String name, 
    @Body ConsoleNotification body, 
    @QueryMap PatchConsoleNotification queryParameters);

  
  final class PatchConsoleNotification extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleNotification pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleNotification dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleNotification fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> replaceConsoleNotification(
    @Path("name") String name, 
    @Body ConsoleNotification body);

  /**
   * replace the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> replaceConsoleNotification(
    @Path("name") String name, 
    @Body ConsoleNotification body, 
    @QueryMap ReplaceConsoleNotification queryParameters);

  
  final class ReplaceConsoleNotification extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleNotification pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleNotification dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleNotification fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> readConsoleNotificationStatus(
    @Path("name") String name);

  /**
   * read status of the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> readConsoleNotificationStatus(
    @Path("name") String name, 
    @QueryMap ReadConsoleNotificationStatus queryParameters);

  
  final class ReadConsoleNotificationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleNotificationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleNotificationStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> patchConsoleNotificationStatus(
    @Path("name") String name, 
    @Body ConsoleNotification body);

  /**
   * partially update status of the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> patchConsoleNotificationStatus(
    @Path("name") String name, 
    @Body ConsoleNotification body, 
    @QueryMap PatchConsoleNotificationStatus queryParameters);

  
  final class PatchConsoleNotificationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleNotificationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleNotificationStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleNotificationStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> replaceConsoleNotificationStatus(
    @Path("name") String name, 
    @Body ConsoleNotification body);

  /**
   * replace status of the specified ConsoleNotification
   *
   * @param name name of the ConsoleNotification
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consolenotifications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleNotification> replaceConsoleNotificationStatus(
    @Path("name") String name, 
    @Body ConsoleNotification body, 
    @QueryMap ReplaceConsoleNotificationStatus queryParameters);

  
  final class ReplaceConsoleNotificationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleNotificationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleNotificationStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleNotificationStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ConsoleYAMLSample
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleYAMLSample();

  /**
   * delete collection of ConsoleYAMLSample
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsoleYAMLSample(
    @QueryMap DeleteCollectionConsoleYAMLSample queryParameters);

  
  final class DeleteCollectionConsoleYAMLSample extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionConsoleYAMLSample pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionConsoleYAMLSample allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionConsoleYAMLSample continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionConsoleYAMLSample fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionConsoleYAMLSample labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionConsoleYAMLSample limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionConsoleYAMLSample resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionConsoleYAMLSample timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionConsoleYAMLSample watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ConsoleYAMLSample
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleYAMLSampleList, ConsoleYAMLSample> listConsoleYAMLSample();

  /**
   * list objects of kind ConsoleYAMLSample
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleYAMLSampleList, ConsoleYAMLSample> listConsoleYAMLSample(
    @QueryMap ListConsoleYAMLSample queryParameters);

  
  final class ListConsoleYAMLSample extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListConsoleYAMLSample pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListConsoleYAMLSample allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListConsoleYAMLSample continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListConsoleYAMLSample fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListConsoleYAMLSample labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListConsoleYAMLSample limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListConsoleYAMLSample resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListConsoleYAMLSample timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListConsoleYAMLSample watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ConsoleYAMLSample
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> createConsoleYAMLSample(
    @Body ConsoleYAMLSample body);

  /**
   * create a ConsoleYAMLSample
   */
  @HTTP(
    method = "POST",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> createConsoleYAMLSample(
    @Body ConsoleYAMLSample body, 
    @QueryMap CreateConsoleYAMLSample queryParameters);

  
  final class CreateConsoleYAMLSample extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateConsoleYAMLSample pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateConsoleYAMLSample dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateConsoleYAMLSample fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleYAMLSample(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleYAMLSample(
    @Path("name") String name);

  /**
   * delete a ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleYAMLSample(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteConsoleYAMLSample queryParameters);

  /**
   * delete a ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsoleYAMLSample(
    @Path("name") String name, 
    @QueryMap DeleteConsoleYAMLSample queryParameters);

  
  final class DeleteConsoleYAMLSample extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteConsoleYAMLSample pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteConsoleYAMLSample dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteConsoleYAMLSample gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteConsoleYAMLSample orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteConsoleYAMLSample propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> readConsoleYAMLSample(
    @Path("name") String name);

  /**
   * read the specified ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "GET",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> readConsoleYAMLSample(
    @Path("name") String name, 
    @QueryMap ReadConsoleYAMLSample queryParameters);

  
  final class ReadConsoleYAMLSample extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleYAMLSample pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleYAMLSample resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> patchConsoleYAMLSample(
    @Path("name") String name, 
    @Body ConsoleYAMLSample body);

  /**
   * partially update the specified ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> patchConsoleYAMLSample(
    @Path("name") String name, 
    @Body ConsoleYAMLSample body, 
    @QueryMap PatchConsoleYAMLSample queryParameters);

  
  final class PatchConsoleYAMLSample extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleYAMLSample pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleYAMLSample dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleYAMLSample fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> replaceConsoleYAMLSample(
    @Path("name") String name, 
    @Body ConsoleYAMLSample body);

  /**
   * replace the specified ConsoleYAMLSample
   *
   * @param name name of the ConsoleYAMLSample
   */
  @HTTP(
    method = "PUT",
    path = "/apis/console.openshift.io/v1/consoleyamlsamples/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ConsoleYAMLSample> replaceConsoleYAMLSample(
    @Path("name") String name, 
    @Body ConsoleYAMLSample body, 
    @QueryMap ReplaceConsoleYAMLSample queryParameters);

  
  final class ReplaceConsoleYAMLSample extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleYAMLSample pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleYAMLSample dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleYAMLSample fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
}
