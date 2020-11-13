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

package com.marcnuri.yakc.api.operatoropenshiftio.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.api.autoscaling.v1.Scale;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.model.io.openshift.operator.v1.Authentication;
import com.marcnuri.yakc.model.io.openshift.operator.v1.AuthenticationList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.CSISnapshotController;
import com.marcnuri.yakc.model.io.openshift.operator.v1.CSISnapshotControllerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.Console;
import com.marcnuri.yakc.model.io.openshift.operator.v1.ConsoleList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.DNS;
import com.marcnuri.yakc.model.io.openshift.operator.v1.DNSList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.Etcd;
import com.marcnuri.yakc.model.io.openshift.operator.v1.EtcdList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.IngressController;
import com.marcnuri.yakc.model.io.openshift.operator.v1.IngressControllerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeAPIServer;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeAPIServerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeControllerManager;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeControllerManagerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeScheduler;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeSchedulerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeStorageVersionMigrator;
import com.marcnuri.yakc.model.io.openshift.operator.v1.KubeStorageVersionMigratorList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.Network;
import com.marcnuri.yakc.model.io.openshift.operator.v1.NetworkList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.OpenShiftAPIServer;
import com.marcnuri.yakc.model.io.openshift.operator.v1.OpenShiftAPIServerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.OpenShiftControllerManager;
import com.marcnuri.yakc.model.io.openshift.operator.v1.OpenShiftControllerManagerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.ServiceCA;
import com.marcnuri.yakc.model.io.openshift.operator.v1.ServiceCAList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.ServiceCatalogAPIServer;
import com.marcnuri.yakc.model.io.openshift.operator.v1.ServiceCatalogAPIServerList;
import com.marcnuri.yakc.model.io.openshift.operator.v1.ServiceCatalogControllerManager;
import com.marcnuri.yakc.model.io.openshift.operator.v1.ServiceCatalogControllerManagerList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface OperatorOpenshiftIoV1Api extends Api {
  /**
   * delete collection of Authentication
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/authentications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionAuthentication();

  /**
   * delete collection of Authentication
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/authentications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionAuthentication(
    @QueryMap DeleteCollectionAuthentication queryParameters);

  
  final class DeleteCollectionAuthentication extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionAuthentication pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionAuthentication allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionAuthentication continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionAuthentication fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionAuthentication labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionAuthentication limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionAuthentication resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionAuthentication timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionAuthentication watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Authentication
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/authentications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AuthenticationList, Authentication> listAuthentication();

  /**
   * list objects of kind Authentication
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/authentications"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<AuthenticationList, Authentication> listAuthentication(
    @QueryMap ListAuthentication queryParameters);

  
  final class ListAuthentication extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListAuthentication pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListAuthentication allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListAuthentication continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListAuthentication fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListAuthentication labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListAuthentication limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListAuthentication resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListAuthentication timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListAuthentication watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an Authentication
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/authentications",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> createAuthentication(
    @Body Authentication body);

  /**
   * create an Authentication
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/authentications",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> createAuthentication(
    @Body Authentication body, 
    @QueryMap CreateAuthentication queryParameters);

  
  final class CreateAuthentication extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateAuthentication pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateAuthentication dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateAuthentication fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteAuthentication(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete an Authentication
   *
   * @param name name of the Authentication
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteAuthentication(
    @Path("name") String name);

  /**
   * delete an Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteAuthentication(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteAuthentication queryParameters);

  /**
   * delete an Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteAuthentication(
    @Path("name") String name, 
    @QueryMap DeleteAuthentication queryParameters);

  
  final class DeleteAuthentication extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteAuthentication pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteAuthentication dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteAuthentication gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteAuthentication orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteAuthentication propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/authentications/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Authentication> readAuthentication(
    @Path("name") String name);

  /**
   * read the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/authentications/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Authentication> readAuthentication(
    @Path("name") String name, 
    @QueryMap ReadAuthentication queryParameters);

  
  final class ReadAuthentication extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadAuthentication pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadAuthentication resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> patchAuthentication(
    @Path("name") String name, 
    @Body Authentication body);

  /**
   * partially update the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> patchAuthentication(
    @Path("name") String name, 
    @Body Authentication body, 
    @QueryMap PatchAuthentication queryParameters);

  
  final class PatchAuthentication extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchAuthentication pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchAuthentication dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchAuthentication fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> replaceAuthentication(
    @Path("name") String name, 
    @Body Authentication body);

  /**
   * replace the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/authentications/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> replaceAuthentication(
    @Path("name") String name, 
    @Body Authentication body, 
    @QueryMap ReplaceAuthentication queryParameters);

  
  final class ReplaceAuthentication extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceAuthentication pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceAuthentication dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceAuthentication fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/authentications/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Authentication> readAuthenticationStatus(
    @Path("name") String name);

  /**
   * read status of the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/authentications/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Authentication> readAuthenticationStatus(
    @Path("name") String name, 
    @QueryMap ReadAuthenticationStatus queryParameters);

  
  final class ReadAuthenticationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadAuthenticationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadAuthenticationStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/authentications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> patchAuthenticationStatus(
    @Path("name") String name, 
    @Body Authentication body);

  /**
   * partially update status of the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/authentications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> patchAuthenticationStatus(
    @Path("name") String name, 
    @Body Authentication body, 
    @QueryMap PatchAuthenticationStatus queryParameters);

  
  final class PatchAuthenticationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchAuthenticationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchAuthenticationStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchAuthenticationStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/authentications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> replaceAuthenticationStatus(
    @Path("name") String name, 
    @Body Authentication body);

  /**
   * replace status of the specified Authentication
   *
   * @param name name of the Authentication
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/authentications/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Authentication> replaceAuthenticationStatus(
    @Path("name") String name, 
    @Body Authentication body, 
    @QueryMap ReplaceAuthenticationStatus queryParameters);

  
  final class ReplaceAuthenticationStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceAuthenticationStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceAuthenticationStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceAuthenticationStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of Console
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/consoles"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsole();

  /**
   * delete collection of Console
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/consoles"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionConsole(
    @QueryMap DeleteCollectionConsole queryParameters);

  
  final class DeleteCollectionConsole extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionConsole pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionConsole allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionConsole continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionConsole fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionConsole labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionConsole limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionConsole resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionConsole timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionConsole watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Console
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/consoles"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleList, Console> listConsole();

  /**
   * list objects of kind Console
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/consoles"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ConsoleList, Console> listConsole(
    @QueryMap ListConsole queryParameters);

  
  final class ListConsole extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListConsole pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListConsole allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListConsole continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListConsole fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListConsole labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListConsole limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListConsole resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListConsole timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListConsole watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a Console
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/consoles",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Console> createConsole(
    @Body Console body);

  /**
   * create a Console
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/consoles",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Console> createConsole(
    @Body Console body, 
    @QueryMap CreateConsole queryParameters);

  
  final class CreateConsole extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateConsole pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateConsole dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateConsole fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsole(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a Console
   *
   * @param name name of the Console
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsole(
    @Path("name") String name);

  /**
   * delete a Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsole(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteConsole queryParameters);

  /**
   * delete a Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteConsole(
    @Path("name") String name, 
    @QueryMap DeleteConsole queryParameters);

  
  final class DeleteConsole extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteConsole pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteConsole dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteConsole gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteConsole orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteConsole propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/consoles/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Console> readConsole(
    @Path("name") String name);

  /**
   * read the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/consoles/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Console> readConsole(
    @Path("name") String name, 
    @QueryMap ReadConsole queryParameters);

  
  final class ReadConsole extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsole pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsole resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Console> patchConsole(
    @Path("name") String name, 
    @Body Console body);

  /**
   * partially update the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Console> patchConsole(
    @Path("name") String name, 
    @Body Console body, 
    @QueryMap PatchConsole queryParameters);

  
  final class PatchConsole extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsole pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsole dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsole fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Console> replaceConsole(
    @Path("name") String name, 
    @Body Console body);

  /**
   * replace the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/consoles/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Console> replaceConsole(
    @Path("name") String name, 
    @Body Console body, 
    @QueryMap ReplaceConsole queryParameters);

  
  final class ReplaceConsole extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsole pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsole dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsole fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/consoles/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Console> readConsoleStatus(
    @Path("name") String name);

  /**
   * read status of the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/consoles/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Console> readConsoleStatus(
    @Path("name") String name, 
    @QueryMap ReadConsoleStatus queryParameters);

  
  final class ReadConsoleStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadConsoleStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadConsoleStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/consoles/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Console> patchConsoleStatus(
    @Path("name") String name, 
    @Body Console body);

  /**
   * partially update status of the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/consoles/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Console> patchConsoleStatus(
    @Path("name") String name, 
    @Body Console body, 
    @QueryMap PatchConsoleStatus queryParameters);

  
  final class PatchConsoleStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchConsoleStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchConsoleStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchConsoleStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/consoles/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Console> replaceConsoleStatus(
    @Path("name") String name, 
    @Body Console body);

  /**
   * replace status of the specified Console
   *
   * @param name name of the Console
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/consoles/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Console> replaceConsoleStatus(
    @Path("name") String name, 
    @Body Console body, 
    @QueryMap ReplaceConsoleStatus queryParameters);

  
  final class ReplaceConsoleStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceConsoleStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceConsoleStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceConsoleStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of CSISnapshotController
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionCSISnapshotController();

  /**
   * delete collection of CSISnapshotController
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionCSISnapshotController(
    @QueryMap DeleteCollectionCSISnapshotController queryParameters);

  
  final class DeleteCollectionCSISnapshotController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionCSISnapshotController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionCSISnapshotController allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionCSISnapshotController continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionCSISnapshotController fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionCSISnapshotController labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionCSISnapshotController limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionCSISnapshotController resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionCSISnapshotController timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionCSISnapshotController watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind CSISnapshotController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CSISnapshotControllerList, CSISnapshotController> listCSISnapshotController();

  /**
   * list objects of kind CSISnapshotController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CSISnapshotControllerList, CSISnapshotController> listCSISnapshotController(
    @QueryMap ListCSISnapshotController queryParameters);

  
  final class ListCSISnapshotController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListCSISnapshotController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListCSISnapshotController allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListCSISnapshotController continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListCSISnapshotController fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListCSISnapshotController labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListCSISnapshotController limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListCSISnapshotController resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListCSISnapshotController timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListCSISnapshotController watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a CSISnapshotController
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> createCSISnapshotController(
    @Body CSISnapshotController body);

  /**
   * create a CSISnapshotController
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> createCSISnapshotController(
    @Body CSISnapshotController body, 
    @QueryMap CreateCSISnapshotController queryParameters);

  
  final class CreateCSISnapshotController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateCSISnapshotController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateCSISnapshotController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateCSISnapshotController fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCSISnapshotController(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCSISnapshotController(
    @Path("name") String name);

  /**
   * delete a CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCSISnapshotController(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteCSISnapshotController queryParameters);

  /**
   * delete a CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCSISnapshotController(
    @Path("name") String name, 
    @QueryMap DeleteCSISnapshotController queryParameters);

  
  final class DeleteCSISnapshotController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCSISnapshotController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCSISnapshotController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCSISnapshotController gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCSISnapshotController orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCSISnapshotController propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> readCSISnapshotController(
    @Path("name") String name);

  /**
   * read the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> readCSISnapshotController(
    @Path("name") String name, 
    @QueryMap ReadCSISnapshotController queryParameters);

  
  final class ReadCSISnapshotController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadCSISnapshotController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadCSISnapshotController resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> patchCSISnapshotController(
    @Path("name") String name, 
    @Body CSISnapshotController body);

  /**
   * partially update the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> patchCSISnapshotController(
    @Path("name") String name, 
    @Body CSISnapshotController body, 
    @QueryMap PatchCSISnapshotController queryParameters);

  
  final class PatchCSISnapshotController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchCSISnapshotController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchCSISnapshotController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchCSISnapshotController fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> replaceCSISnapshotController(
    @Path("name") String name, 
    @Body CSISnapshotController body);

  /**
   * replace the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> replaceCSISnapshotController(
    @Path("name") String name, 
    @Body CSISnapshotController body, 
    @QueryMap ReplaceCSISnapshotController queryParameters);

  
  final class ReplaceCSISnapshotController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceCSISnapshotController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceCSISnapshotController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceCSISnapshotController fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> readCSISnapshotControllerStatus(
    @Path("name") String name);

  /**
   * read status of the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> readCSISnapshotControllerStatus(
    @Path("name") String name, 
    @QueryMap ReadCSISnapshotControllerStatus queryParameters);

  
  final class ReadCSISnapshotControllerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadCSISnapshotControllerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadCSISnapshotControllerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> patchCSISnapshotControllerStatus(
    @Path("name") String name, 
    @Body CSISnapshotController body);

  /**
   * partially update status of the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> patchCSISnapshotControllerStatus(
    @Path("name") String name, 
    @Body CSISnapshotController body, 
    @QueryMap PatchCSISnapshotControllerStatus queryParameters);

  
  final class PatchCSISnapshotControllerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchCSISnapshotControllerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchCSISnapshotControllerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchCSISnapshotControllerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> replaceCSISnapshotControllerStatus(
    @Path("name") String name, 
    @Body CSISnapshotController body);

  /**
   * replace status of the specified CSISnapshotController
   *
   * @param name name of the CSISnapshotController
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/csisnapshotcontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CSISnapshotController> replaceCSISnapshotControllerStatus(
    @Path("name") String name, 
    @Body CSISnapshotController body, 
    @QueryMap ReplaceCSISnapshotControllerStatus queryParameters);

  
  final class ReplaceCSISnapshotControllerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceCSISnapshotControllerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceCSISnapshotControllerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceCSISnapshotControllerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of DNS
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/dnses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionDNS();

  /**
   * delete collection of DNS
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/dnses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionDNS(
    @QueryMap DeleteCollectionDNS queryParameters);

  
  final class DeleteCollectionDNS extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionDNS pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionDNS allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionDNS continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionDNS fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionDNS labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionDNS limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionDNS resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionDNS timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionDNS watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind DNS
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/dnses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<DNSList, DNS> listDNS();

  /**
   * list objects of kind DNS
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/dnses"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<DNSList, DNS> listDNS(
    @QueryMap ListDNS queryParameters);

  
  final class ListDNS extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListDNS pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListDNS allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListDNS continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListDNS fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListDNS labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListDNS limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListDNS resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListDNS timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListDNS watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a DNS
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/dnses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DNS> createDNS(
    @Body DNS body);

  /**
   * create a DNS
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/dnses",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DNS> createDNS(
    @Body DNS body, 
    @QueryMap CreateDNS queryParameters);

  
  final class CreateDNS extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateDNS pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateDNS dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateDNS fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteDNS(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a DNS
   *
   * @param name name of the DNS
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteDNS(
    @Path("name") String name);

  /**
   * delete a DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteDNS(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteDNS queryParameters);

  /**
   * delete a DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteDNS(
    @Path("name") String name, 
    @QueryMap DeleteDNS queryParameters);

  
  final class DeleteDNS extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteDNS pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteDNS dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteDNS gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteDNS orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteDNS propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/dnses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DNS> readDNS(
    @Path("name") String name);

  /**
   * read the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/dnses/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DNS> readDNS(
    @Path("name") String name, 
    @QueryMap ReadDNS queryParameters);

  
  final class ReadDNS extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadDNS pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadDNS resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DNS> patchDNS(
    @Path("name") String name, 
    @Body DNS body);

  /**
   * partially update the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DNS> patchDNS(
    @Path("name") String name, 
    @Body DNS body, 
    @QueryMap PatchDNS queryParameters);

  
  final class PatchDNS extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchDNS pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchDNS dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchDNS fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DNS> replaceDNS(
    @Path("name") String name, 
    @Body DNS body);

  /**
   * replace the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/dnses/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DNS> replaceDNS(
    @Path("name") String name, 
    @Body DNS body, 
    @QueryMap ReplaceDNS queryParameters);

  
  final class ReplaceDNS extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceDNS pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceDNS dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceDNS fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/dnses/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DNS> readDNSStatus(
    @Path("name") String name);

  /**
   * read status of the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/dnses/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DNS> readDNSStatus(
    @Path("name") String name, 
    @QueryMap ReadDNSStatus queryParameters);

  
  final class ReadDNSStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadDNSStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadDNSStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/dnses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DNS> patchDNSStatus(
    @Path("name") String name, 
    @Body DNS body);

  /**
   * partially update status of the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/dnses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DNS> patchDNSStatus(
    @Path("name") String name, 
    @Body DNS body, 
    @QueryMap PatchDNSStatus queryParameters);

  
  final class PatchDNSStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchDNSStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchDNSStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchDNSStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/dnses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DNS> replaceDNSStatus(
    @Path("name") String name, 
    @Body DNS body);

  /**
   * replace status of the specified DNS
   *
   * @param name name of the DNS
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/dnses/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DNS> replaceDNSStatus(
    @Path("name") String name, 
    @Body DNS body, 
    @QueryMap ReplaceDNSStatus queryParameters);

  
  final class ReplaceDNSStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceDNSStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceDNSStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceDNSStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of Etcd
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/etcds"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionEtcd();

  /**
   * delete collection of Etcd
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/etcds"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionEtcd(
    @QueryMap DeleteCollectionEtcd queryParameters);

  
  final class DeleteCollectionEtcd extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionEtcd pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionEtcd allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionEtcd continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionEtcd fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionEtcd labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionEtcd limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionEtcd resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionEtcd timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionEtcd watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Etcd
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/etcds"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<EtcdList, Etcd> listEtcd();

  /**
   * list objects of kind Etcd
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/etcds"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<EtcdList, Etcd> listEtcd(
    @QueryMap ListEtcd queryParameters);

  
  final class ListEtcd extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListEtcd pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListEtcd allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListEtcd continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListEtcd fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListEtcd labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListEtcd limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListEtcd resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListEtcd timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListEtcd watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an Etcd
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/etcds",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> createEtcd(
    @Body Etcd body);

  /**
   * create an Etcd
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/etcds",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> createEtcd(
    @Body Etcd body, 
    @QueryMap CreateEtcd queryParameters);

  
  final class CreateEtcd extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateEtcd pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateEtcd dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateEtcd fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteEtcd(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete an Etcd
   *
   * @param name name of the Etcd
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteEtcd(
    @Path("name") String name);

  /**
   * delete an Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteEtcd(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteEtcd queryParameters);

  /**
   * delete an Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteEtcd(
    @Path("name") String name, 
    @QueryMap DeleteEtcd queryParameters);

  
  final class DeleteEtcd extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteEtcd pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteEtcd dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteEtcd gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteEtcd orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteEtcd propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/etcds/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Etcd> readEtcd(
    @Path("name") String name);

  /**
   * read the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/etcds/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Etcd> readEtcd(
    @Path("name") String name, 
    @QueryMap ReadEtcd queryParameters);

  
  final class ReadEtcd extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadEtcd pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadEtcd resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> patchEtcd(
    @Path("name") String name, 
    @Body Etcd body);

  /**
   * partially update the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> patchEtcd(
    @Path("name") String name, 
    @Body Etcd body, 
    @QueryMap PatchEtcd queryParameters);

  
  final class PatchEtcd extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchEtcd pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchEtcd dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchEtcd fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> replaceEtcd(
    @Path("name") String name, 
    @Body Etcd body);

  /**
   * replace the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/etcds/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> replaceEtcd(
    @Path("name") String name, 
    @Body Etcd body, 
    @QueryMap ReplaceEtcd queryParameters);

  
  final class ReplaceEtcd extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceEtcd pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceEtcd dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceEtcd fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/etcds/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Etcd> readEtcdStatus(
    @Path("name") String name);

  /**
   * read status of the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/etcds/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Etcd> readEtcdStatus(
    @Path("name") String name, 
    @QueryMap ReadEtcdStatus queryParameters);

  
  final class ReadEtcdStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadEtcdStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadEtcdStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/etcds/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> patchEtcdStatus(
    @Path("name") String name, 
    @Body Etcd body);

  /**
   * partially update status of the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/etcds/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> patchEtcdStatus(
    @Path("name") String name, 
    @Body Etcd body, 
    @QueryMap PatchEtcdStatus queryParameters);

  
  final class PatchEtcdStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchEtcdStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchEtcdStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchEtcdStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/etcds/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> replaceEtcdStatus(
    @Path("name") String name, 
    @Body Etcd body);

  /**
   * replace status of the specified Etcd
   *
   * @param name name of the Etcd
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/etcds/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Etcd> replaceEtcdStatus(
    @Path("name") String name, 
    @Body Etcd body, 
    @QueryMap ReplaceEtcdStatus queryParameters);

  
  final class ReplaceEtcdStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceEtcdStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceEtcdStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceEtcdStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * list objects of kind IngressController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/ingresscontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressControllerList, IngressController> listIngressControllerForAllNamespaces();

  /**
   * list objects of kind IngressController
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/ingresscontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressControllerList, IngressController> listIngressControllerForAllNamespaces(
    @QueryMap ListIngressControllerForAllNamespaces queryParameters);

  
  final class ListIngressControllerForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListIngressControllerForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListIngressControllerForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListIngressControllerForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListIngressControllerForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListIngressControllerForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListIngressControllerForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListIngressControllerForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListIngressControllerForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListIngressControllerForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of KubeAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeAPIServer();

  /**
   * delete collection of KubeAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeAPIServer(
    @QueryMap DeleteCollectionKubeAPIServer queryParameters);

  
  final class DeleteCollectionKubeAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionKubeAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionKubeAPIServer allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionKubeAPIServer continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionKubeAPIServer fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionKubeAPIServer labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionKubeAPIServer limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionKubeAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionKubeAPIServer timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionKubeAPIServer watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind KubeAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeAPIServerList, KubeAPIServer> listKubeAPIServer();

  /**
   * list objects of kind KubeAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeAPIServerList, KubeAPIServer> listKubeAPIServer(
    @QueryMap ListKubeAPIServer queryParameters);

  
  final class ListKubeAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListKubeAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListKubeAPIServer allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListKubeAPIServer continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListKubeAPIServer fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListKubeAPIServer labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListKubeAPIServer limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListKubeAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListKubeAPIServer timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListKubeAPIServer watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a KubeAPIServer
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubeapiservers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> createKubeAPIServer(
    @Body KubeAPIServer body);

  /**
   * create a KubeAPIServer
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubeapiservers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> createKubeAPIServer(
    @Body KubeAPIServer body, 
    @QueryMap CreateKubeAPIServer queryParameters);

  
  final class CreateKubeAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateKubeAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateKubeAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateKubeAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeAPIServer(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeAPIServer(
    @Path("name") String name);

  /**
   * delete a KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeAPIServer(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteKubeAPIServer queryParameters);

  /**
   * delete a KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeAPIServer(
    @Path("name") String name, 
    @QueryMap DeleteKubeAPIServer queryParameters);

  
  final class DeleteKubeAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteKubeAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteKubeAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteKubeAPIServer gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteKubeAPIServer orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteKubeAPIServer propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> readKubeAPIServer(
    @Path("name") String name);

  /**
   * read the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> readKubeAPIServer(
    @Path("name") String name, 
    @QueryMap ReadKubeAPIServer queryParameters);

  
  final class ReadKubeAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> patchKubeAPIServer(
    @Path("name") String name, 
    @Body KubeAPIServer body);

  /**
   * partially update the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> patchKubeAPIServer(
    @Path("name") String name, 
    @Body KubeAPIServer body, 
    @QueryMap PatchKubeAPIServer queryParameters);

  
  final class PatchKubeAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> replaceKubeAPIServer(
    @Path("name") String name, 
    @Body KubeAPIServer body);

  /**
   * replace the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> replaceKubeAPIServer(
    @Path("name") String name, 
    @Body KubeAPIServer body, 
    @QueryMap ReplaceKubeAPIServer queryParameters);

  
  final class ReplaceKubeAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> readKubeAPIServerStatus(
    @Path("name") String name);

  /**
   * read status of the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> readKubeAPIServerStatus(
    @Path("name") String name, 
    @QueryMap ReadKubeAPIServerStatus queryParameters);

  
  final class ReadKubeAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeAPIServerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> patchKubeAPIServerStatus(
    @Path("name") String name, 
    @Body KubeAPIServer body);

  /**
   * partially update status of the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> patchKubeAPIServerStatus(
    @Path("name") String name, 
    @Body KubeAPIServer body, 
    @QueryMap PatchKubeAPIServerStatus queryParameters);

  
  final class PatchKubeAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeAPIServerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeAPIServerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> replaceKubeAPIServerStatus(
    @Path("name") String name, 
    @Body KubeAPIServer body);

  /**
   * replace status of the specified KubeAPIServer
   *
   * @param name name of the KubeAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeAPIServer> replaceKubeAPIServerStatus(
    @Path("name") String name, 
    @Body KubeAPIServer body, 
    @QueryMap ReplaceKubeAPIServerStatus queryParameters);

  
  final class ReplaceKubeAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeAPIServerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeAPIServerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of KubeControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeControllerManager();

  /**
   * delete collection of KubeControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeControllerManager(
    @QueryMap DeleteCollectionKubeControllerManager queryParameters);

  
  final class DeleteCollectionKubeControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionKubeControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionKubeControllerManager allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionKubeControllerManager continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionKubeControllerManager fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionKubeControllerManager labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionKubeControllerManager limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionKubeControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionKubeControllerManager timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionKubeControllerManager watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind KubeControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeControllerManagerList, KubeControllerManager> listKubeControllerManager();

  /**
   * list objects of kind KubeControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeControllerManagerList, KubeControllerManager> listKubeControllerManager(
    @QueryMap ListKubeControllerManager queryParameters);

  
  final class ListKubeControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListKubeControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListKubeControllerManager allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListKubeControllerManager continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListKubeControllerManager fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListKubeControllerManager labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListKubeControllerManager limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListKubeControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListKubeControllerManager timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListKubeControllerManager watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a KubeControllerManager
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> createKubeControllerManager(
    @Body KubeControllerManager body);

  /**
   * create a KubeControllerManager
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> createKubeControllerManager(
    @Body KubeControllerManager body, 
    @QueryMap CreateKubeControllerManager queryParameters);

  
  final class CreateKubeControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateKubeControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateKubeControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateKubeControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeControllerManager(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeControllerManager(
    @Path("name") String name);

  /**
   * delete a KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeControllerManager(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteKubeControllerManager queryParameters);

  /**
   * delete a KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeControllerManager(
    @Path("name") String name, 
    @QueryMap DeleteKubeControllerManager queryParameters);

  
  final class DeleteKubeControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteKubeControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteKubeControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteKubeControllerManager gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteKubeControllerManager orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteKubeControllerManager propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> readKubeControllerManager(
    @Path("name") String name);

  /**
   * read the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> readKubeControllerManager(
    @Path("name") String name, 
    @QueryMap ReadKubeControllerManager queryParameters);

  
  final class ReadKubeControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> patchKubeControllerManager(
    @Path("name") String name, 
    @Body KubeControllerManager body);

  /**
   * partially update the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> patchKubeControllerManager(
    @Path("name") String name, 
    @Body KubeControllerManager body, 
    @QueryMap PatchKubeControllerManager queryParameters);

  
  final class PatchKubeControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> replaceKubeControllerManager(
    @Path("name") String name, 
    @Body KubeControllerManager body);

  /**
   * replace the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> replaceKubeControllerManager(
    @Path("name") String name, 
    @Body KubeControllerManager body, 
    @QueryMap ReplaceKubeControllerManager queryParameters);

  
  final class ReplaceKubeControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> readKubeControllerManagerStatus(
    @Path("name") String name);

  /**
   * read status of the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> readKubeControllerManagerStatus(
    @Path("name") String name, 
    @QueryMap ReadKubeControllerManagerStatus queryParameters);

  
  final class ReadKubeControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeControllerManagerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> patchKubeControllerManagerStatus(
    @Path("name") String name, 
    @Body KubeControllerManager body);

  /**
   * partially update status of the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> patchKubeControllerManagerStatus(
    @Path("name") String name, 
    @Body KubeControllerManager body, 
    @QueryMap PatchKubeControllerManagerStatus queryParameters);

  
  final class PatchKubeControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeControllerManagerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeControllerManagerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> replaceKubeControllerManagerStatus(
    @Path("name") String name, 
    @Body KubeControllerManager body);

  /**
   * replace status of the specified KubeControllerManager
   *
   * @param name name of the KubeControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubecontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeControllerManager> replaceKubeControllerManagerStatus(
    @Path("name") String name, 
    @Body KubeControllerManager body, 
    @QueryMap ReplaceKubeControllerManagerStatus queryParameters);

  
  final class ReplaceKubeControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeControllerManagerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeControllerManagerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of KubeScheduler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeschedulers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeScheduler();

  /**
   * delete collection of KubeScheduler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeschedulers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeScheduler(
    @QueryMap DeleteCollectionKubeScheduler queryParameters);

  
  final class DeleteCollectionKubeScheduler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionKubeScheduler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionKubeScheduler allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionKubeScheduler continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionKubeScheduler fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionKubeScheduler labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionKubeScheduler limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionKubeScheduler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionKubeScheduler timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionKubeScheduler watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind KubeScheduler
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeschedulers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeSchedulerList, KubeScheduler> listKubeScheduler();

  /**
   * list objects of kind KubeScheduler
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeschedulers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeSchedulerList, KubeScheduler> listKubeScheduler(
    @QueryMap ListKubeScheduler queryParameters);

  
  final class ListKubeScheduler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListKubeScheduler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListKubeScheduler allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListKubeScheduler continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListKubeScheduler fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListKubeScheduler labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListKubeScheduler limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListKubeScheduler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListKubeScheduler timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListKubeScheduler watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a KubeScheduler
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubeschedulers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> createKubeScheduler(
    @Body KubeScheduler body);

  /**
   * create a KubeScheduler
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubeschedulers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> createKubeScheduler(
    @Body KubeScheduler body, 
    @QueryMap CreateKubeScheduler queryParameters);

  
  final class CreateKubeScheduler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateKubeScheduler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateKubeScheduler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateKubeScheduler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeScheduler(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeScheduler(
    @Path("name") String name);

  /**
   * delete a KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeScheduler(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteKubeScheduler queryParameters);

  /**
   * delete a KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeScheduler(
    @Path("name") String name, 
    @QueryMap DeleteKubeScheduler queryParameters);

  
  final class DeleteKubeScheduler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteKubeScheduler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteKubeScheduler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteKubeScheduler gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteKubeScheduler orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteKubeScheduler propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> readKubeScheduler(
    @Path("name") String name);

  /**
   * read the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> readKubeScheduler(
    @Path("name") String name, 
    @QueryMap ReadKubeScheduler queryParameters);

  
  final class ReadKubeScheduler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeScheduler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeScheduler resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> patchKubeScheduler(
    @Path("name") String name, 
    @Body KubeScheduler body);

  /**
   * partially update the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> patchKubeScheduler(
    @Path("name") String name, 
    @Body KubeScheduler body, 
    @QueryMap PatchKubeScheduler queryParameters);

  
  final class PatchKubeScheduler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeScheduler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeScheduler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeScheduler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> replaceKubeScheduler(
    @Path("name") String name, 
    @Body KubeScheduler body);

  /**
   * replace the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> replaceKubeScheduler(
    @Path("name") String name, 
    @Body KubeScheduler body, 
    @QueryMap ReplaceKubeScheduler queryParameters);

  
  final class ReplaceKubeScheduler extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeScheduler pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeScheduler dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeScheduler fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> readKubeSchedulerStatus(
    @Path("name") String name);

  /**
   * read status of the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> readKubeSchedulerStatus(
    @Path("name") String name, 
    @QueryMap ReadKubeSchedulerStatus queryParameters);

  
  final class ReadKubeSchedulerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeSchedulerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeSchedulerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> patchKubeSchedulerStatus(
    @Path("name") String name, 
    @Body KubeScheduler body);

  /**
   * partially update status of the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> patchKubeSchedulerStatus(
    @Path("name") String name, 
    @Body KubeScheduler body, 
    @QueryMap PatchKubeSchedulerStatus queryParameters);

  
  final class PatchKubeSchedulerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeSchedulerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeSchedulerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeSchedulerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> replaceKubeSchedulerStatus(
    @Path("name") String name, 
    @Body KubeScheduler body);

  /**
   * replace status of the specified KubeScheduler
   *
   * @param name name of the KubeScheduler
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubeschedulers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeScheduler> replaceKubeSchedulerStatus(
    @Path("name") String name, 
    @Body KubeScheduler body, 
    @QueryMap ReplaceKubeSchedulerStatus queryParameters);

  
  final class ReplaceKubeSchedulerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeSchedulerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeSchedulerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeSchedulerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of KubeStorageVersionMigrator
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeStorageVersionMigrator();

  /**
   * delete collection of KubeStorageVersionMigrator
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeStorageVersionMigrator(
    @QueryMap DeleteCollectionKubeStorageVersionMigrator queryParameters);

  
  final class DeleteCollectionKubeStorageVersionMigrator extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionKubeStorageVersionMigrator pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionKubeStorageVersionMigrator allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionKubeStorageVersionMigrator continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionKubeStorageVersionMigrator fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionKubeStorageVersionMigrator labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionKubeStorageVersionMigrator limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionKubeStorageVersionMigrator resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionKubeStorageVersionMigrator timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionKubeStorageVersionMigrator watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind KubeStorageVersionMigrator
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeStorageVersionMigratorList, KubeStorageVersionMigrator> listKubeStorageVersionMigrator();

  /**
   * list objects of kind KubeStorageVersionMigrator
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeStorageVersionMigratorList, KubeStorageVersionMigrator> listKubeStorageVersionMigrator(
    @QueryMap ListKubeStorageVersionMigrator queryParameters);

  
  final class ListKubeStorageVersionMigrator extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListKubeStorageVersionMigrator pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListKubeStorageVersionMigrator allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListKubeStorageVersionMigrator continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListKubeStorageVersionMigrator fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListKubeStorageVersionMigrator labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListKubeStorageVersionMigrator limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListKubeStorageVersionMigrator resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListKubeStorageVersionMigrator timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListKubeStorageVersionMigrator watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a KubeStorageVersionMigrator
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> createKubeStorageVersionMigrator(
    @Body KubeStorageVersionMigrator body);

  /**
   * create a KubeStorageVersionMigrator
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> createKubeStorageVersionMigrator(
    @Body KubeStorageVersionMigrator body, 
    @QueryMap CreateKubeStorageVersionMigrator queryParameters);

  
  final class CreateKubeStorageVersionMigrator extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateKubeStorageVersionMigrator pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateKubeStorageVersionMigrator dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateKubeStorageVersionMigrator fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeStorageVersionMigrator(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeStorageVersionMigrator(
    @Path("name") String name);

  /**
   * delete a KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeStorageVersionMigrator(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteKubeStorageVersionMigrator queryParameters);

  /**
   * delete a KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeStorageVersionMigrator(
    @Path("name") String name, 
    @QueryMap DeleteKubeStorageVersionMigrator queryParameters);

  
  final class DeleteKubeStorageVersionMigrator extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteKubeStorageVersionMigrator pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteKubeStorageVersionMigrator dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteKubeStorageVersionMigrator gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteKubeStorageVersionMigrator orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteKubeStorageVersionMigrator propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> readKubeStorageVersionMigrator(
    @Path("name") String name);

  /**
   * read the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> readKubeStorageVersionMigrator(
    @Path("name") String name, 
    @QueryMap ReadKubeStorageVersionMigrator queryParameters);

  
  final class ReadKubeStorageVersionMigrator extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeStorageVersionMigrator pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeStorageVersionMigrator resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> patchKubeStorageVersionMigrator(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body);

  /**
   * partially update the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> patchKubeStorageVersionMigrator(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body, 
    @QueryMap PatchKubeStorageVersionMigrator queryParameters);

  
  final class PatchKubeStorageVersionMigrator extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeStorageVersionMigrator pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeStorageVersionMigrator dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeStorageVersionMigrator fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> replaceKubeStorageVersionMigrator(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body);

  /**
   * replace the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> replaceKubeStorageVersionMigrator(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body, 
    @QueryMap ReplaceKubeStorageVersionMigrator queryParameters);

  
  final class ReplaceKubeStorageVersionMigrator extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeStorageVersionMigrator pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeStorageVersionMigrator dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeStorageVersionMigrator fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> readKubeStorageVersionMigratorStatus(
    @Path("name") String name);

  /**
   * read status of the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> readKubeStorageVersionMigratorStatus(
    @Path("name") String name, 
    @QueryMap ReadKubeStorageVersionMigratorStatus queryParameters);

  
  final class ReadKubeStorageVersionMigratorStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeStorageVersionMigratorStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeStorageVersionMigratorStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> patchKubeStorageVersionMigratorStatus(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body);

  /**
   * partially update status of the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> patchKubeStorageVersionMigratorStatus(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body, 
    @QueryMap PatchKubeStorageVersionMigratorStatus queryParameters);

  
  final class PatchKubeStorageVersionMigratorStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeStorageVersionMigratorStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeStorageVersionMigratorStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeStorageVersionMigratorStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> replaceKubeStorageVersionMigratorStatus(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body);

  /**
   * replace status of the specified KubeStorageVersionMigrator
   *
   * @param name name of the KubeStorageVersionMigrator
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/kubestorageversionmigrators/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeStorageVersionMigrator> replaceKubeStorageVersionMigratorStatus(
    @Path("name") String name, 
    @Body KubeStorageVersionMigrator body, 
    @QueryMap ReplaceKubeStorageVersionMigratorStatus queryParameters);

  
  final class ReplaceKubeStorageVersionMigratorStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeStorageVersionMigratorStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeStorageVersionMigratorStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeStorageVersionMigratorStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of IngressController
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedIngressController(
    @Path("namespace") String namespace);

  /**
   * delete collection of IngressController
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNamespacedIngressController(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedIngressController queryParameters);

  
  final class DeleteCollectionNamespacedIngressController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedIngressController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedIngressController allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedIngressController continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedIngressController fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedIngressController labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedIngressController limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNamespacedIngressController resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedIngressController timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedIngressController watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind IngressController
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressControllerList, IngressController> listNamespacedIngressController(
    @Path("namespace") String namespace);

  /**
   * list objects of kind IngressController
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<IngressControllerList, IngressController> listNamespacedIngressController(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedIngressController queryParameters);

  
  final class ListNamespacedIngressController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedIngressController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedIngressController allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedIngressController continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedIngressController fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedIngressController labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedIngressController limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNamespacedIngressController resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedIngressController timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedIngressController watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an IngressController
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> createNamespacedIngressController(
    @Path("namespace") String namespace, 
    @Body IngressController body);

  /**
   * create an IngressController
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> createNamespacedIngressController(
    @Path("namespace") String namespace, 
    @Body IngressController body, 
    @QueryMap CreateNamespacedIngressController queryParameters);

  
  final class CreateNamespacedIngressController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedIngressController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedIngressController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedIngressController fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body);

    /**
   * delete an IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete an IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNamespacedIngressController queryParameters);

  /**
   * delete an IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedIngressController queryParameters);

  
  final class DeleteNamespacedIngressController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedIngressController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedIngressController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedIngressController gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedIngressController orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedIngressController propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<IngressController> readNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<IngressController> readNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedIngressController queryParameters);

  
  final class ReadNamespacedIngressController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedIngressController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedIngressController resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> patchNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body);

  /**
   * partially update the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> patchNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body, 
    @QueryMap PatchNamespacedIngressController queryParameters);

  
  final class PatchNamespacedIngressController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedIngressController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedIngressController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedIngressController fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> replaceNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body);

  /**
   * replace the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> replaceNamespacedIngressController(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body, 
    @QueryMap ReplaceNamespacedIngressController queryParameters);

  
  final class ReplaceNamespacedIngressController extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedIngressController pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedIngressController dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedIngressController fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read scale of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/scale"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Scale> readNamespacedIngressControllerScale(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read scale of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/scale"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Scale> readNamespacedIngressControllerScale(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedIngressControllerScale queryParameters);

  
  final class ReadNamespacedIngressControllerScale extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedIngressControllerScale pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedIngressControllerScale resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update scale of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/scale",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Scale> patchNamespacedIngressControllerScale(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Scale body);

  /**
   * partially update scale of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/scale",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Scale> patchNamespacedIngressControllerScale(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Scale body, 
    @QueryMap PatchNamespacedIngressControllerScale queryParameters);

  
  final class PatchNamespacedIngressControllerScale extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedIngressControllerScale pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedIngressControllerScale dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedIngressControllerScale fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace scale of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/scale",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Scale> replaceNamespacedIngressControllerScale(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Scale body);

  /**
   * replace scale of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/scale",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Scale> replaceNamespacedIngressControllerScale(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Scale body, 
    @QueryMap ReplaceNamespacedIngressControllerScale queryParameters);

  
  final class ReplaceNamespacedIngressControllerScale extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedIngressControllerScale pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedIngressControllerScale dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedIngressControllerScale fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<IngressController> readNamespacedIngressControllerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<IngressController> readNamespacedIngressControllerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedIngressControllerStatus queryParameters);

  
  final class ReadNamespacedIngressControllerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedIngressControllerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNamespacedIngressControllerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> patchNamespacedIngressControllerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body);

  /**
   * partially update status of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> patchNamespacedIngressControllerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body, 
    @QueryMap PatchNamespacedIngressControllerStatus queryParameters);

  
  final class PatchNamespacedIngressControllerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedIngressControllerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedIngressControllerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedIngressControllerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> replaceNamespacedIngressControllerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body);

  /**
   * replace status of the specified IngressController
   *
   * @param name name of the IngressController
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/namespaces/{namespace}/ingresscontrollers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<IngressController> replaceNamespacedIngressControllerStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body IngressController body, 
    @QueryMap ReplaceNamespacedIngressControllerStatus queryParameters);

  
  final class ReplaceNamespacedIngressControllerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedIngressControllerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedIngressControllerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedIngressControllerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of Network
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/networks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNetwork();

  /**
   * delete collection of Network
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/networks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionNetwork(
    @QueryMap DeleteCollectionNetwork queryParameters);

  
  final class DeleteCollectionNetwork extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNetwork pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNetwork allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNetwork continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNetwork fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNetwork labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNetwork limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionNetwork resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNetwork timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNetwork watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Network
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/networks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<NetworkList, Network> listNetwork();

  /**
   * list objects of kind Network
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/networks"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<NetworkList, Network> listNetwork(
    @QueryMap ListNetwork queryParameters);

  
  final class ListNetwork extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNetwork pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNetwork allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNetwork continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNetwork fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNetwork labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNetwork limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListNetwork resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNetwork timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNetwork watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a Network
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/networks",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Network> createNetwork(
    @Body Network body);

  /**
   * create a Network
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/networks",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Network> createNetwork(
    @Body Network body, 
    @QueryMap CreateNetwork queryParameters);

  
  final class CreateNetwork extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNetwork pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNetwork dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNetwork fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNetwork(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a Network
   *
   * @param name name of the Network
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNetwork(
    @Path("name") String name);

  /**
   * delete a Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNetwork(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteNetwork queryParameters);

  /**
   * delete a Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteNetwork(
    @Path("name") String name, 
    @QueryMap DeleteNetwork queryParameters);

  
  final class DeleteNetwork extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNetwork pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNetwork dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNetwork gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNetwork orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNetwork propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/networks/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Network> readNetwork(
    @Path("name") String name);

  /**
   * read the specified Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/networks/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Network> readNetwork(
    @Path("name") String name, 
    @QueryMap ReadNetwork queryParameters);

  
  final class ReadNetwork extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNetwork pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadNetwork resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Network> patchNetwork(
    @Path("name") String name, 
    @Body Network body);

  /**
   * partially update the specified Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Network> patchNetwork(
    @Path("name") String name, 
    @Body Network body, 
    @QueryMap PatchNetwork queryParameters);

  
  final class PatchNetwork extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNetwork pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNetwork dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNetwork fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Network> replaceNetwork(
    @Path("name") String name, 
    @Body Network body);

  /**
   * replace the specified Network
   *
   * @param name name of the Network
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/networks/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Network> replaceNetwork(
    @Path("name") String name, 
    @Body Network body, 
    @QueryMap ReplaceNetwork queryParameters);

  
  final class ReplaceNetwork extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNetwork pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNetwork dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNetwork fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of OpenShiftAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionOpenShiftAPIServer();

  /**
   * delete collection of OpenShiftAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionOpenShiftAPIServer(
    @QueryMap DeleteCollectionOpenShiftAPIServer queryParameters);

  
  final class DeleteCollectionOpenShiftAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionOpenShiftAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionOpenShiftAPIServer allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionOpenShiftAPIServer continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionOpenShiftAPIServer fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionOpenShiftAPIServer labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionOpenShiftAPIServer limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionOpenShiftAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionOpenShiftAPIServer timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionOpenShiftAPIServer watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind OpenShiftAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<OpenShiftAPIServerList, OpenShiftAPIServer> listOpenShiftAPIServer();

  /**
   * list objects of kind OpenShiftAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<OpenShiftAPIServerList, OpenShiftAPIServer> listOpenShiftAPIServer(
    @QueryMap ListOpenShiftAPIServer queryParameters);

  
  final class ListOpenShiftAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListOpenShiftAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListOpenShiftAPIServer allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListOpenShiftAPIServer continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListOpenShiftAPIServer fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListOpenShiftAPIServer labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListOpenShiftAPIServer limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListOpenShiftAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListOpenShiftAPIServer timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListOpenShiftAPIServer watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an OpenShiftAPIServer
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> createOpenShiftAPIServer(
    @Body OpenShiftAPIServer body);

  /**
   * create an OpenShiftAPIServer
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> createOpenShiftAPIServer(
    @Body OpenShiftAPIServer body, 
    @QueryMap CreateOpenShiftAPIServer queryParameters);

  
  final class CreateOpenShiftAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateOpenShiftAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateOpenShiftAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateOpenShiftAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftAPIServer(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete an OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftAPIServer(
    @Path("name") String name);

  /**
   * delete an OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftAPIServer(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteOpenShiftAPIServer queryParameters);

  /**
   * delete an OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftAPIServer(
    @Path("name") String name, 
    @QueryMap DeleteOpenShiftAPIServer queryParameters);

  
  final class DeleteOpenShiftAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteOpenShiftAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteOpenShiftAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteOpenShiftAPIServer gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteOpenShiftAPIServer orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteOpenShiftAPIServer propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> readOpenShiftAPIServer(
    @Path("name") String name);

  /**
   * read the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> readOpenShiftAPIServer(
    @Path("name") String name, 
    @QueryMap ReadOpenShiftAPIServer queryParameters);

  
  final class ReadOpenShiftAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadOpenShiftAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadOpenShiftAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> patchOpenShiftAPIServer(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body);

  /**
   * partially update the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> patchOpenShiftAPIServer(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body, 
    @QueryMap PatchOpenShiftAPIServer queryParameters);

  
  final class PatchOpenShiftAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchOpenShiftAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchOpenShiftAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchOpenShiftAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> replaceOpenShiftAPIServer(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body);

  /**
   * replace the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> replaceOpenShiftAPIServer(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body, 
    @QueryMap ReplaceOpenShiftAPIServer queryParameters);

  
  final class ReplaceOpenShiftAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceOpenShiftAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceOpenShiftAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceOpenShiftAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> readOpenShiftAPIServerStatus(
    @Path("name") String name);

  /**
   * read status of the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> readOpenShiftAPIServerStatus(
    @Path("name") String name, 
    @QueryMap ReadOpenShiftAPIServerStatus queryParameters);

  
  final class ReadOpenShiftAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadOpenShiftAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadOpenShiftAPIServerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> patchOpenShiftAPIServerStatus(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body);

  /**
   * partially update status of the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> patchOpenShiftAPIServerStatus(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body, 
    @QueryMap PatchOpenShiftAPIServerStatus queryParameters);

  
  final class PatchOpenShiftAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchOpenShiftAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchOpenShiftAPIServerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchOpenShiftAPIServerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> replaceOpenShiftAPIServerStatus(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body);

  /**
   * replace status of the specified OpenShiftAPIServer
   *
   * @param name name of the OpenShiftAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftAPIServer> replaceOpenShiftAPIServerStatus(
    @Path("name") String name, 
    @Body OpenShiftAPIServer body, 
    @QueryMap ReplaceOpenShiftAPIServerStatus queryParameters);

  
  final class ReplaceOpenShiftAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceOpenShiftAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceOpenShiftAPIServerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceOpenShiftAPIServerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of OpenShiftControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionOpenShiftControllerManager();

  /**
   * delete collection of OpenShiftControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionOpenShiftControllerManager(
    @QueryMap DeleteCollectionOpenShiftControllerManager queryParameters);

  
  final class DeleteCollectionOpenShiftControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionOpenShiftControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionOpenShiftControllerManager allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionOpenShiftControllerManager continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionOpenShiftControllerManager fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionOpenShiftControllerManager labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionOpenShiftControllerManager limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionOpenShiftControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionOpenShiftControllerManager timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionOpenShiftControllerManager watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind OpenShiftControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<OpenShiftControllerManagerList, OpenShiftControllerManager> listOpenShiftControllerManager();

  /**
   * list objects of kind OpenShiftControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<OpenShiftControllerManagerList, OpenShiftControllerManager> listOpenShiftControllerManager(
    @QueryMap ListOpenShiftControllerManager queryParameters);

  
  final class ListOpenShiftControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListOpenShiftControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListOpenShiftControllerManager allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListOpenShiftControllerManager continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListOpenShiftControllerManager fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListOpenShiftControllerManager labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListOpenShiftControllerManager limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListOpenShiftControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListOpenShiftControllerManager timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListOpenShiftControllerManager watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create an OpenShiftControllerManager
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> createOpenShiftControllerManager(
    @Body OpenShiftControllerManager body);

  /**
   * create an OpenShiftControllerManager
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> createOpenShiftControllerManager(
    @Body OpenShiftControllerManager body, 
    @QueryMap CreateOpenShiftControllerManager queryParameters);

  
  final class CreateOpenShiftControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateOpenShiftControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateOpenShiftControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateOpenShiftControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete an OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftControllerManager(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete an OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftControllerManager(
    @Path("name") String name);

  /**
   * delete an OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftControllerManager(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteOpenShiftControllerManager queryParameters);

  /**
   * delete an OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteOpenShiftControllerManager(
    @Path("name") String name, 
    @QueryMap DeleteOpenShiftControllerManager queryParameters);

  
  final class DeleteOpenShiftControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteOpenShiftControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteOpenShiftControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteOpenShiftControllerManager gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteOpenShiftControllerManager orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteOpenShiftControllerManager propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> readOpenShiftControllerManager(
    @Path("name") String name);

  /**
   * read the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> readOpenShiftControllerManager(
    @Path("name") String name, 
    @QueryMap ReadOpenShiftControllerManager queryParameters);

  
  final class ReadOpenShiftControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadOpenShiftControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadOpenShiftControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> patchOpenShiftControllerManager(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body);

  /**
   * partially update the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> patchOpenShiftControllerManager(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body, 
    @QueryMap PatchOpenShiftControllerManager queryParameters);

  
  final class PatchOpenShiftControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchOpenShiftControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchOpenShiftControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchOpenShiftControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> replaceOpenShiftControllerManager(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body);

  /**
   * replace the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> replaceOpenShiftControllerManager(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body, 
    @QueryMap ReplaceOpenShiftControllerManager queryParameters);

  
  final class ReplaceOpenShiftControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceOpenShiftControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceOpenShiftControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceOpenShiftControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> readOpenShiftControllerManagerStatus(
    @Path("name") String name);

  /**
   * read status of the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> readOpenShiftControllerManagerStatus(
    @Path("name") String name, 
    @QueryMap ReadOpenShiftControllerManagerStatus queryParameters);

  
  final class ReadOpenShiftControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadOpenShiftControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadOpenShiftControllerManagerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> patchOpenShiftControllerManagerStatus(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body);

  /**
   * partially update status of the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> patchOpenShiftControllerManagerStatus(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body, 
    @QueryMap PatchOpenShiftControllerManagerStatus queryParameters);

  
  final class PatchOpenShiftControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchOpenShiftControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchOpenShiftControllerManagerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchOpenShiftControllerManagerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> replaceOpenShiftControllerManagerStatus(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body);

  /**
   * replace status of the specified OpenShiftControllerManager
   *
   * @param name name of the OpenShiftControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/openshiftcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<OpenShiftControllerManager> replaceOpenShiftControllerManagerStatus(
    @Path("name") String name, 
    @Body OpenShiftControllerManager body, 
    @QueryMap ReplaceOpenShiftControllerManagerStatus queryParameters);

  
  final class ReplaceOpenShiftControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceOpenShiftControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceOpenShiftControllerManagerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceOpenShiftControllerManagerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ServiceCA
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionServiceCA();

  /**
   * delete collection of ServiceCA
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionServiceCA(
    @QueryMap DeleteCollectionServiceCA queryParameters);

  
  final class DeleteCollectionServiceCA extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionServiceCA pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionServiceCA allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionServiceCA continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionServiceCA fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionServiceCA labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionServiceCA limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionServiceCA resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionServiceCA timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionServiceCA watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ServiceCA
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServiceCAList, ServiceCA> listServiceCA();

  /**
   * list objects of kind ServiceCA
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecas"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServiceCAList, ServiceCA> listServiceCA(
    @QueryMap ListServiceCA queryParameters);

  
  final class ListServiceCA extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListServiceCA pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListServiceCA allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListServiceCA continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListServiceCA fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListServiceCA labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListServiceCA limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListServiceCA resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListServiceCA timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListServiceCA watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ServiceCA
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/servicecas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> createServiceCA(
    @Body ServiceCA body);

  /**
   * create a ServiceCA
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/servicecas",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> createServiceCA(
    @Body ServiceCA body, 
    @QueryMap CreateServiceCA queryParameters);

  
  final class CreateServiceCA extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateServiceCA pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateServiceCA dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateServiceCA fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCA(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ServiceCA
   *
   * @param name name of the ServiceCA
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCA(
    @Path("name") String name);

  /**
   * delete a ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCA(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteServiceCA queryParameters);

  /**
   * delete a ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCA(
    @Path("name") String name, 
    @QueryMap DeleteServiceCA queryParameters);

  
  final class DeleteServiceCA extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteServiceCA pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteServiceCA dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteServiceCA gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteServiceCA orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteServiceCA propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> readServiceCA(
    @Path("name") String name);

  /**
   * read the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> readServiceCA(
    @Path("name") String name, 
    @QueryMap ReadServiceCA queryParameters);

  
  final class ReadServiceCA extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadServiceCA pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadServiceCA resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> patchServiceCA(
    @Path("name") String name, 
    @Body ServiceCA body);

  /**
   * partially update the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> patchServiceCA(
    @Path("name") String name, 
    @Body ServiceCA body, 
    @QueryMap PatchServiceCA queryParameters);

  
  final class PatchServiceCA extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchServiceCA pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchServiceCA dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchServiceCA fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> replaceServiceCA(
    @Path("name") String name, 
    @Body ServiceCA body);

  /**
   * replace the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> replaceServiceCA(
    @Path("name") String name, 
    @Body ServiceCA body, 
    @QueryMap ReplaceServiceCA queryParameters);

  
  final class ReplaceServiceCA extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceServiceCA pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceServiceCA dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceServiceCA fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> readServiceCAStatus(
    @Path("name") String name);

  /**
   * read status of the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> readServiceCAStatus(
    @Path("name") String name, 
    @QueryMap ReadServiceCAStatus queryParameters);

  
  final class ReadServiceCAStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadServiceCAStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadServiceCAStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> patchServiceCAStatus(
    @Path("name") String name, 
    @Body ServiceCA body);

  /**
   * partially update status of the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> patchServiceCAStatus(
    @Path("name") String name, 
    @Body ServiceCA body, 
    @QueryMap PatchServiceCAStatus queryParameters);

  
  final class PatchServiceCAStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchServiceCAStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchServiceCAStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchServiceCAStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> replaceServiceCAStatus(
    @Path("name") String name, 
    @Body ServiceCA body);

  /**
   * replace status of the specified ServiceCA
   *
   * @param name name of the ServiceCA
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecas/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCA> replaceServiceCAStatus(
    @Path("name") String name, 
    @Body ServiceCA body, 
    @QueryMap ReplaceServiceCAStatus queryParameters);

  
  final class ReplaceServiceCAStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceServiceCAStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceServiceCAStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceServiceCAStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ServiceCatalogAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionServiceCatalogAPIServer();

  /**
   * delete collection of ServiceCatalogAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionServiceCatalogAPIServer(
    @QueryMap DeleteCollectionServiceCatalogAPIServer queryParameters);

  
  final class DeleteCollectionServiceCatalogAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionServiceCatalogAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionServiceCatalogAPIServer allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionServiceCatalogAPIServer continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionServiceCatalogAPIServer fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionServiceCatalogAPIServer labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionServiceCatalogAPIServer limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionServiceCatalogAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionServiceCatalogAPIServer timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionServiceCatalogAPIServer watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ServiceCatalogAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServiceCatalogAPIServerList, ServiceCatalogAPIServer> listServiceCatalogAPIServer();

  /**
   * list objects of kind ServiceCatalogAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServiceCatalogAPIServerList, ServiceCatalogAPIServer> listServiceCatalogAPIServer(
    @QueryMap ListServiceCatalogAPIServer queryParameters);

  
  final class ListServiceCatalogAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListServiceCatalogAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListServiceCatalogAPIServer allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListServiceCatalogAPIServer continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListServiceCatalogAPIServer fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListServiceCatalogAPIServer labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListServiceCatalogAPIServer limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListServiceCatalogAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListServiceCatalogAPIServer timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListServiceCatalogAPIServer watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ServiceCatalogAPIServer
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> createServiceCatalogAPIServer(
    @Body ServiceCatalogAPIServer body);

  /**
   * create a ServiceCatalogAPIServer
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> createServiceCatalogAPIServer(
    @Body ServiceCatalogAPIServer body, 
    @QueryMap CreateServiceCatalogAPIServer queryParameters);

  
  final class CreateServiceCatalogAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateServiceCatalogAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateServiceCatalogAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateServiceCatalogAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogAPIServer(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogAPIServer(
    @Path("name") String name);

  /**
   * delete a ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogAPIServer(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteServiceCatalogAPIServer queryParameters);

  /**
   * delete a ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogAPIServer(
    @Path("name") String name, 
    @QueryMap DeleteServiceCatalogAPIServer queryParameters);

  
  final class DeleteServiceCatalogAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteServiceCatalogAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteServiceCatalogAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteServiceCatalogAPIServer gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteServiceCatalogAPIServer orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteServiceCatalogAPIServer propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> readServiceCatalogAPIServer(
    @Path("name") String name);

  /**
   * read the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> readServiceCatalogAPIServer(
    @Path("name") String name, 
    @QueryMap ReadServiceCatalogAPIServer queryParameters);

  
  final class ReadServiceCatalogAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadServiceCatalogAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadServiceCatalogAPIServer resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> patchServiceCatalogAPIServer(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body);

  /**
   * partially update the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> patchServiceCatalogAPIServer(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body, 
    @QueryMap PatchServiceCatalogAPIServer queryParameters);

  
  final class PatchServiceCatalogAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchServiceCatalogAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchServiceCatalogAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchServiceCatalogAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> replaceServiceCatalogAPIServer(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body);

  /**
   * replace the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> replaceServiceCatalogAPIServer(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body, 
    @QueryMap ReplaceServiceCatalogAPIServer queryParameters);

  
  final class ReplaceServiceCatalogAPIServer extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceServiceCatalogAPIServer pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceServiceCatalogAPIServer dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceServiceCatalogAPIServer fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> readServiceCatalogAPIServerStatus(
    @Path("name") String name);

  /**
   * read status of the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> readServiceCatalogAPIServerStatus(
    @Path("name") String name, 
    @QueryMap ReadServiceCatalogAPIServerStatus queryParameters);

  
  final class ReadServiceCatalogAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadServiceCatalogAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadServiceCatalogAPIServerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> patchServiceCatalogAPIServerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body);

  /**
   * partially update status of the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> patchServiceCatalogAPIServerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body, 
    @QueryMap PatchServiceCatalogAPIServerStatus queryParameters);

  
  final class PatchServiceCatalogAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchServiceCatalogAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchServiceCatalogAPIServerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchServiceCatalogAPIServerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> replaceServiceCatalogAPIServerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body);

  /**
   * replace status of the specified ServiceCatalogAPIServer
   *
   * @param name name of the ServiceCatalogAPIServer
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogapiservers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogAPIServer> replaceServiceCatalogAPIServerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogAPIServer body, 
    @QueryMap ReplaceServiceCatalogAPIServerStatus queryParameters);

  
  final class ReplaceServiceCatalogAPIServerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceServiceCatalogAPIServerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceServiceCatalogAPIServerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceServiceCatalogAPIServerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ServiceCatalogControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionServiceCatalogControllerManager();

  /**
   * delete collection of ServiceCatalogControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionServiceCatalogControllerManager(
    @QueryMap DeleteCollectionServiceCatalogControllerManager queryParameters);

  
  final class DeleteCollectionServiceCatalogControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionServiceCatalogControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionServiceCatalogControllerManager allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionServiceCatalogControllerManager continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionServiceCatalogControllerManager fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionServiceCatalogControllerManager labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionServiceCatalogControllerManager limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionServiceCatalogControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionServiceCatalogControllerManager timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionServiceCatalogControllerManager watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ServiceCatalogControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServiceCatalogControllerManagerList, ServiceCatalogControllerManager> listServiceCatalogControllerManager();

  /**
   * list objects of kind ServiceCatalogControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ServiceCatalogControllerManagerList, ServiceCatalogControllerManager> listServiceCatalogControllerManager(
    @QueryMap ListServiceCatalogControllerManager queryParameters);

  
  final class ListServiceCatalogControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListServiceCatalogControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListServiceCatalogControllerManager allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListServiceCatalogControllerManager continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListServiceCatalogControllerManager fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListServiceCatalogControllerManager labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListServiceCatalogControllerManager limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListServiceCatalogControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListServiceCatalogControllerManager timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListServiceCatalogControllerManager watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ServiceCatalogControllerManager
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> createServiceCatalogControllerManager(
    @Body ServiceCatalogControllerManager body);

  /**
   * create a ServiceCatalogControllerManager
   */
  @HTTP(
    method = "POST",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> createServiceCatalogControllerManager(
    @Body ServiceCatalogControllerManager body, 
    @QueryMap CreateServiceCatalogControllerManager queryParameters);

  
  final class CreateServiceCatalogControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateServiceCatalogControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateServiceCatalogControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateServiceCatalogControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogControllerManager(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogControllerManager(
    @Path("name") String name);

  /**
   * delete a ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogControllerManager(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteServiceCatalogControllerManager queryParameters);

  /**
   * delete a ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteServiceCatalogControllerManager(
    @Path("name") String name, 
    @QueryMap DeleteServiceCatalogControllerManager queryParameters);

  
  final class DeleteServiceCatalogControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteServiceCatalogControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteServiceCatalogControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteServiceCatalogControllerManager gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteServiceCatalogControllerManager orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteServiceCatalogControllerManager propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> readServiceCatalogControllerManager(
    @Path("name") String name);

  /**
   * read the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> readServiceCatalogControllerManager(
    @Path("name") String name, 
    @QueryMap ReadServiceCatalogControllerManager queryParameters);

  
  final class ReadServiceCatalogControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadServiceCatalogControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadServiceCatalogControllerManager resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> patchServiceCatalogControllerManager(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body);

  /**
   * partially update the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> patchServiceCatalogControllerManager(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body, 
    @QueryMap PatchServiceCatalogControllerManager queryParameters);

  
  final class PatchServiceCatalogControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchServiceCatalogControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchServiceCatalogControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchServiceCatalogControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> replaceServiceCatalogControllerManager(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body);

  /**
   * replace the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> replaceServiceCatalogControllerManager(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body, 
    @QueryMap ReplaceServiceCatalogControllerManager queryParameters);

  
  final class ReplaceServiceCatalogControllerManager extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceServiceCatalogControllerManager pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceServiceCatalogControllerManager dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceServiceCatalogControllerManager fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> readServiceCatalogControllerManagerStatus(
    @Path("name") String name);

  /**
   * read status of the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "GET",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> readServiceCatalogControllerManagerStatus(
    @Path("name") String name, 
    @QueryMap ReadServiceCatalogControllerManagerStatus queryParameters);

  
  final class ReadServiceCatalogControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadServiceCatalogControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadServiceCatalogControllerManagerStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> patchServiceCatalogControllerManagerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body);

  /**
   * partially update status of the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> patchServiceCatalogControllerManagerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body, 
    @QueryMap PatchServiceCatalogControllerManagerStatus queryParameters);

  
  final class PatchServiceCatalogControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchServiceCatalogControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchServiceCatalogControllerManagerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchServiceCatalogControllerManagerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> replaceServiceCatalogControllerManagerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body);

  /**
   * replace status of the specified ServiceCatalogControllerManager
   *
   * @param name name of the ServiceCatalogControllerManager
   */
  @HTTP(
    method = "PUT",
    path = "/apis/operator.openshift.io/v1/servicecatalogcontrollermanagers/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ServiceCatalogControllerManager> replaceServiceCatalogControllerManagerStatus(
    @Path("name") String name, 
    @Body ServiceCatalogControllerManager body, 
    @QueryMap ReplaceServiceCatalogControllerManagerStatus queryParameters);

  
  final class ReplaceServiceCatalogControllerManagerStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceServiceCatalogControllerManagerStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceServiceCatalogControllerManagerStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceServiceCatalogControllerManagerStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
}
