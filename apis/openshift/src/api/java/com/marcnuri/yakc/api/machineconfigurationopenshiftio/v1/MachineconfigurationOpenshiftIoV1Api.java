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

package com.marcnuri.yakc.api.machineconfigurationopenshiftio.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.ContainerRuntimeConfig;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.ContainerRuntimeConfigList;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.ControllerConfig;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.ControllerConfigList;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.KubeletConfig;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.KubeletConfigList;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.MachineConfig;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.MachineConfigList;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.MachineConfigPool;
import com.marcnuri.yakc.model.io.openshift.machineconfiguration.v1.MachineConfigPoolList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface MachineconfigurationOpenshiftIoV1Api extends Api {
  /**
   * delete collection of ContainerRuntimeConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionContainerRuntimeConfig();

  /**
   * delete collection of ContainerRuntimeConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionContainerRuntimeConfig(
    @QueryMap DeleteCollectionContainerRuntimeConfig queryParameters);

  
  final class DeleteCollectionContainerRuntimeConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionContainerRuntimeConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionContainerRuntimeConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionContainerRuntimeConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionContainerRuntimeConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionContainerRuntimeConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionContainerRuntimeConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionContainerRuntimeConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionContainerRuntimeConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionContainerRuntimeConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ContainerRuntimeConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ContainerRuntimeConfigList, ContainerRuntimeConfig> listContainerRuntimeConfig();

  /**
   * list objects of kind ContainerRuntimeConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ContainerRuntimeConfigList, ContainerRuntimeConfig> listContainerRuntimeConfig(
    @QueryMap ListContainerRuntimeConfig queryParameters);

  
  final class ListContainerRuntimeConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListContainerRuntimeConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListContainerRuntimeConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListContainerRuntimeConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListContainerRuntimeConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListContainerRuntimeConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListContainerRuntimeConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListContainerRuntimeConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListContainerRuntimeConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListContainerRuntimeConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ContainerRuntimeConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> createContainerRuntimeConfig(
    @Body ContainerRuntimeConfig body);

  /**
   * create a ContainerRuntimeConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> createContainerRuntimeConfig(
    @Body ContainerRuntimeConfig body, 
    @QueryMap CreateContainerRuntimeConfig queryParameters);

  
  final class CreateContainerRuntimeConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateContainerRuntimeConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateContainerRuntimeConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateContainerRuntimeConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteContainerRuntimeConfig(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteContainerRuntimeConfig(
    @Path("name") String name);

  /**
   * delete a ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteContainerRuntimeConfig(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteContainerRuntimeConfig queryParameters);

  /**
   * delete a ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteContainerRuntimeConfig(
    @Path("name") String name, 
    @QueryMap DeleteContainerRuntimeConfig queryParameters);

  
  final class DeleteContainerRuntimeConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteContainerRuntimeConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteContainerRuntimeConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteContainerRuntimeConfig gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteContainerRuntimeConfig orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteContainerRuntimeConfig propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> readContainerRuntimeConfig(
    @Path("name") String name);

  /**
   * read the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> readContainerRuntimeConfig(
    @Path("name") String name, 
    @QueryMap ReadContainerRuntimeConfig queryParameters);

  
  final class ReadContainerRuntimeConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadContainerRuntimeConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadContainerRuntimeConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> patchContainerRuntimeConfig(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body);

  /**
   * partially update the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> patchContainerRuntimeConfig(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body, 
    @QueryMap PatchContainerRuntimeConfig queryParameters);

  
  final class PatchContainerRuntimeConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchContainerRuntimeConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchContainerRuntimeConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchContainerRuntimeConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> replaceContainerRuntimeConfig(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body);

  /**
   * replace the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> replaceContainerRuntimeConfig(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body, 
    @QueryMap ReplaceContainerRuntimeConfig queryParameters);

  
  final class ReplaceContainerRuntimeConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceContainerRuntimeConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceContainerRuntimeConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceContainerRuntimeConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> readContainerRuntimeConfigStatus(
    @Path("name") String name);

  /**
   * read status of the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> readContainerRuntimeConfigStatus(
    @Path("name") String name, 
    @QueryMap ReadContainerRuntimeConfigStatus queryParameters);

  
  final class ReadContainerRuntimeConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadContainerRuntimeConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadContainerRuntimeConfigStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> patchContainerRuntimeConfigStatus(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body);

  /**
   * partially update status of the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> patchContainerRuntimeConfigStatus(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body, 
    @QueryMap PatchContainerRuntimeConfigStatus queryParameters);

  
  final class PatchContainerRuntimeConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchContainerRuntimeConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchContainerRuntimeConfigStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchContainerRuntimeConfigStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> replaceContainerRuntimeConfigStatus(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body);

  /**
   * replace status of the specified ContainerRuntimeConfig
   *
   * @param name name of the ContainerRuntimeConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/containerruntimeconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ContainerRuntimeConfig> replaceContainerRuntimeConfigStatus(
    @Path("name") String name, 
    @Body ContainerRuntimeConfig body, 
    @QueryMap ReplaceContainerRuntimeConfigStatus queryParameters);

  
  final class ReplaceContainerRuntimeConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceContainerRuntimeConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceContainerRuntimeConfigStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceContainerRuntimeConfigStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of ControllerConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionControllerConfig();

  /**
   * delete collection of ControllerConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionControllerConfig(
    @QueryMap DeleteCollectionControllerConfig queryParameters);

  
  final class DeleteCollectionControllerConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionControllerConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionControllerConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionControllerConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionControllerConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionControllerConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionControllerConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionControllerConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionControllerConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionControllerConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind ControllerConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ControllerConfigList, ControllerConfig> listControllerConfig();

  /**
   * list objects of kind ControllerConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<ControllerConfigList, ControllerConfig> listControllerConfig(
    @QueryMap ListControllerConfig queryParameters);

  
  final class ListControllerConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListControllerConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListControllerConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListControllerConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListControllerConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListControllerConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListControllerConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListControllerConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListControllerConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListControllerConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a ControllerConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> createControllerConfig(
    @Body ControllerConfig body);

  /**
   * create a ControllerConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> createControllerConfig(
    @Body ControllerConfig body, 
    @QueryMap CreateControllerConfig queryParameters);

  
  final class CreateControllerConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateControllerConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateControllerConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateControllerConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteControllerConfig(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteControllerConfig(
    @Path("name") String name);

  /**
   * delete a ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteControllerConfig(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteControllerConfig queryParameters);

  /**
   * delete a ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteControllerConfig(
    @Path("name") String name, 
    @QueryMap DeleteControllerConfig queryParameters);

  
  final class DeleteControllerConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteControllerConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteControllerConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteControllerConfig gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteControllerConfig orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteControllerConfig propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> readControllerConfig(
    @Path("name") String name);

  /**
   * read the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> readControllerConfig(
    @Path("name") String name, 
    @QueryMap ReadControllerConfig queryParameters);

  
  final class ReadControllerConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadControllerConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadControllerConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> patchControllerConfig(
    @Path("name") String name, 
    @Body ControllerConfig body);

  /**
   * partially update the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> patchControllerConfig(
    @Path("name") String name, 
    @Body ControllerConfig body, 
    @QueryMap PatchControllerConfig queryParameters);

  
  final class PatchControllerConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchControllerConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchControllerConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchControllerConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> replaceControllerConfig(
    @Path("name") String name, 
    @Body ControllerConfig body);

  /**
   * replace the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> replaceControllerConfig(
    @Path("name") String name, 
    @Body ControllerConfig body, 
    @QueryMap ReplaceControllerConfig queryParameters);

  
  final class ReplaceControllerConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceControllerConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceControllerConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceControllerConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> readControllerConfigStatus(
    @Path("name") String name);

  /**
   * read status of the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> readControllerConfigStatus(
    @Path("name") String name, 
    @QueryMap ReadControllerConfigStatus queryParameters);

  
  final class ReadControllerConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadControllerConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadControllerConfigStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> patchControllerConfigStatus(
    @Path("name") String name, 
    @Body ControllerConfig body);

  /**
   * partially update status of the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> patchControllerConfigStatus(
    @Path("name") String name, 
    @Body ControllerConfig body, 
    @QueryMap PatchControllerConfigStatus queryParameters);

  
  final class PatchControllerConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchControllerConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchControllerConfigStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchControllerConfigStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> replaceControllerConfigStatus(
    @Path("name") String name, 
    @Body ControllerConfig body);

  /**
   * replace status of the specified ControllerConfig
   *
   * @param name name of the ControllerConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/controllerconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<ControllerConfig> replaceControllerConfigStatus(
    @Path("name") String name, 
    @Body ControllerConfig body, 
    @QueryMap ReplaceControllerConfigStatus queryParameters);

  
  final class ReplaceControllerConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceControllerConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceControllerConfigStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceControllerConfigStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of KubeletConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeletConfig();

  /**
   * delete collection of KubeletConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionKubeletConfig(
    @QueryMap DeleteCollectionKubeletConfig queryParameters);

  
  final class DeleteCollectionKubeletConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionKubeletConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionKubeletConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionKubeletConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionKubeletConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionKubeletConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionKubeletConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionKubeletConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionKubeletConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionKubeletConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind KubeletConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeletConfigList, KubeletConfig> listKubeletConfig();

  /**
   * list objects of kind KubeletConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<KubeletConfigList, KubeletConfig> listKubeletConfig(
    @QueryMap ListKubeletConfig queryParameters);

  
  final class ListKubeletConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListKubeletConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListKubeletConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListKubeletConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListKubeletConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListKubeletConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListKubeletConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListKubeletConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListKubeletConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListKubeletConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a KubeletConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> createKubeletConfig(
    @Body KubeletConfig body);

  /**
   * create a KubeletConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> createKubeletConfig(
    @Body KubeletConfig body, 
    @QueryMap CreateKubeletConfig queryParameters);

  
  final class CreateKubeletConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateKubeletConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateKubeletConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateKubeletConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeletConfig(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeletConfig(
    @Path("name") String name);

  /**
   * delete a KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeletConfig(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteKubeletConfig queryParameters);

  /**
   * delete a KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteKubeletConfig(
    @Path("name") String name, 
    @QueryMap DeleteKubeletConfig queryParameters);

  
  final class DeleteKubeletConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteKubeletConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteKubeletConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteKubeletConfig gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteKubeletConfig orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteKubeletConfig propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> readKubeletConfig(
    @Path("name") String name);

  /**
   * read the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> readKubeletConfig(
    @Path("name") String name, 
    @QueryMap ReadKubeletConfig queryParameters);

  
  final class ReadKubeletConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeletConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeletConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> patchKubeletConfig(
    @Path("name") String name, 
    @Body KubeletConfig body);

  /**
   * partially update the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> patchKubeletConfig(
    @Path("name") String name, 
    @Body KubeletConfig body, 
    @QueryMap PatchKubeletConfig queryParameters);

  
  final class PatchKubeletConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeletConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeletConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeletConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> replaceKubeletConfig(
    @Path("name") String name, 
    @Body KubeletConfig body);

  /**
   * replace the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> replaceKubeletConfig(
    @Path("name") String name, 
    @Body KubeletConfig body, 
    @QueryMap ReplaceKubeletConfig queryParameters);

  
  final class ReplaceKubeletConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeletConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeletConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeletConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> readKubeletConfigStatus(
    @Path("name") String name);

  /**
   * read status of the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> readKubeletConfigStatus(
    @Path("name") String name, 
    @QueryMap ReadKubeletConfigStatus queryParameters);

  
  final class ReadKubeletConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadKubeletConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadKubeletConfigStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> patchKubeletConfigStatus(
    @Path("name") String name, 
    @Body KubeletConfig body);

  /**
   * partially update status of the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> patchKubeletConfigStatus(
    @Path("name") String name, 
    @Body KubeletConfig body, 
    @QueryMap PatchKubeletConfigStatus queryParameters);

  
  final class PatchKubeletConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchKubeletConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchKubeletConfigStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchKubeletConfigStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> replaceKubeletConfigStatus(
    @Path("name") String name, 
    @Body KubeletConfig body);

  /**
   * replace status of the specified KubeletConfig
   *
   * @param name name of the KubeletConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/kubeletconfigs/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<KubeletConfig> replaceKubeletConfigStatus(
    @Path("name") String name, 
    @Body KubeletConfig body, 
    @QueryMap ReplaceKubeletConfigStatus queryParameters);

  
  final class ReplaceKubeletConfigStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceKubeletConfigStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceKubeletConfigStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceKubeletConfigStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of MachineConfigPool
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMachineConfigPool();

  /**
   * delete collection of MachineConfigPool
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMachineConfigPool(
    @QueryMap DeleteCollectionMachineConfigPool queryParameters);

  
  final class DeleteCollectionMachineConfigPool extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionMachineConfigPool pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionMachineConfigPool allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionMachineConfigPool continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionMachineConfigPool fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionMachineConfigPool labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionMachineConfigPool limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionMachineConfigPool resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionMachineConfigPool timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionMachineConfigPool watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind MachineConfigPool
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MachineConfigPoolList, MachineConfigPool> listMachineConfigPool();

  /**
   * list objects of kind MachineConfigPool
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MachineConfigPoolList, MachineConfigPool> listMachineConfigPool(
    @QueryMap ListMachineConfigPool queryParameters);

  
  final class ListMachineConfigPool extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListMachineConfigPool pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListMachineConfigPool allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListMachineConfigPool continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListMachineConfigPool fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListMachineConfigPool labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListMachineConfigPool limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListMachineConfigPool resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListMachineConfigPool timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListMachineConfigPool watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a MachineConfigPool
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> createMachineConfigPool(
    @Body MachineConfigPool body);

  /**
   * create a MachineConfigPool
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> createMachineConfigPool(
    @Body MachineConfigPool body, 
    @QueryMap CreateMachineConfigPool queryParameters);

  
  final class CreateMachineConfigPool extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateMachineConfigPool pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateMachineConfigPool dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateMachineConfigPool fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfigPool(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfigPool(
    @Path("name") String name);

  /**
   * delete a MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfigPool(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteMachineConfigPool queryParameters);

  /**
   * delete a MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfigPool(
    @Path("name") String name, 
    @QueryMap DeleteMachineConfigPool queryParameters);

  
  final class DeleteMachineConfigPool extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteMachineConfigPool pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteMachineConfigPool dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteMachineConfigPool gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteMachineConfigPool orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteMachineConfigPool propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> readMachineConfigPool(
    @Path("name") String name);

  /**
   * read the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> readMachineConfigPool(
    @Path("name") String name, 
    @QueryMap ReadMachineConfigPool queryParameters);

  
  final class ReadMachineConfigPool extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadMachineConfigPool pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadMachineConfigPool resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> patchMachineConfigPool(
    @Path("name") String name, 
    @Body MachineConfigPool body);

  /**
   * partially update the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> patchMachineConfigPool(
    @Path("name") String name, 
    @Body MachineConfigPool body, 
    @QueryMap PatchMachineConfigPool queryParameters);

  
  final class PatchMachineConfigPool extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchMachineConfigPool pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchMachineConfigPool dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchMachineConfigPool fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> replaceMachineConfigPool(
    @Path("name") String name, 
    @Body MachineConfigPool body);

  /**
   * replace the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> replaceMachineConfigPool(
    @Path("name") String name, 
    @Body MachineConfigPool body, 
    @QueryMap ReplaceMachineConfigPool queryParameters);

  
  final class ReplaceMachineConfigPool extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceMachineConfigPool pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceMachineConfigPool dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceMachineConfigPool fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> readMachineConfigPoolStatus(
    @Path("name") String name);

  /**
   * read status of the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> readMachineConfigPoolStatus(
    @Path("name") String name, 
    @QueryMap ReadMachineConfigPoolStatus queryParameters);

  
  final class ReadMachineConfigPoolStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadMachineConfigPoolStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadMachineConfigPoolStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> patchMachineConfigPoolStatus(
    @Path("name") String name, 
    @Body MachineConfigPool body);

  /**
   * partially update status of the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> patchMachineConfigPoolStatus(
    @Path("name") String name, 
    @Body MachineConfigPool body, 
    @QueryMap PatchMachineConfigPoolStatus queryParameters);

  
  final class PatchMachineConfigPoolStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchMachineConfigPoolStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchMachineConfigPoolStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchMachineConfigPoolStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> replaceMachineConfigPoolStatus(
    @Path("name") String name, 
    @Body MachineConfigPool body);

  /**
   * replace status of the specified MachineConfigPool
   *
   * @param name name of the MachineConfigPool
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigpools/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfigPool> replaceMachineConfigPoolStatus(
    @Path("name") String name, 
    @Body MachineConfigPool body, 
    @QueryMap ReplaceMachineConfigPoolStatus queryParameters);

  
  final class ReplaceMachineConfigPoolStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceMachineConfigPoolStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceMachineConfigPoolStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceMachineConfigPoolStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of MachineConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMachineConfig();

  /**
   * delete collection of MachineConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionMachineConfig(
    @QueryMap DeleteCollectionMachineConfig queryParameters);

  
  final class DeleteCollectionMachineConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionMachineConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionMachineConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionMachineConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionMachineConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionMachineConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionMachineConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public DeleteCollectionMachineConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionMachineConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionMachineConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind MachineConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MachineConfigList, MachineConfig> listMachineConfig();

  /**
   * list objects of kind MachineConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<MachineConfigList, MachineConfig> listMachineConfig(
    @QueryMap ListMachineConfig queryParameters);

  
  final class ListMachineConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListMachineConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListMachineConfig allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListMachineConfig continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListMachineConfig fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListMachineConfig labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListMachineConfig limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ListMachineConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListMachineConfig timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListMachineConfig watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a MachineConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> createMachineConfig(
    @Body MachineConfig body);

  /**
   * create a MachineConfig
   */
  @HTTP(
    method = "POST",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> createMachineConfig(
    @Body MachineConfig body, 
    @QueryMap CreateMachineConfig queryParameters);

  
  final class CreateMachineConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateMachineConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateMachineConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateMachineConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfig(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a MachineConfig
   *
   * @param name name of the MachineConfig
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfig(
    @Path("name") String name);

  /**
   * delete a MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfig(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteMachineConfig queryParameters);

  /**
   * delete a MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteMachineConfig(
    @Path("name") String name, 
    @QueryMap DeleteMachineConfig queryParameters);

  
  final class DeleteMachineConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteMachineConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteMachineConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteMachineConfig gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteMachineConfig orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteMachineConfig propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> readMachineConfig(
    @Path("name") String name);

  /**
   * read the specified MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "GET",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> readMachineConfig(
    @Path("name") String name, 
    @QueryMap ReadMachineConfig queryParameters);

  
  final class ReadMachineConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadMachineConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When specified: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
     */
    public ReadMachineConfig resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> patchMachineConfig(
    @Path("name") String name, 
    @Body MachineConfig body);

  /**
   * partially update the specified MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> patchMachineConfig(
    @Path("name") String name, 
    @Body MachineConfig body, 
    @QueryMap PatchMachineConfig queryParameters);

  
  final class PatchMachineConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchMachineConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchMachineConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchMachineConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> replaceMachineConfig(
    @Path("name") String name, 
    @Body MachineConfig body);

  /**
   * replace the specified MachineConfig
   *
   * @param name name of the MachineConfig
   */
  @HTTP(
    method = "PUT",
    path = "/apis/machineconfiguration.openshift.io/v1/machineconfigs/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<MachineConfig> replaceMachineConfig(
    @Path("name") String name, 
    @Body MachineConfig body, 
    @QueryMap ReplaceMachineConfig queryParameters);

  
  final class ReplaceMachineConfig extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceMachineConfig pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceMachineConfig dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceMachineConfig fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
}
