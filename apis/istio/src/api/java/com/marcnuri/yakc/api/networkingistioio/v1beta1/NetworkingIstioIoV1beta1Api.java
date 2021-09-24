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

package com.marcnuri.yakc.api.networkingistioio.v1beta1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.istio.networking.v1beta1.DestinationRule;
import com.marcnuri.yakc.model.io.istio.networking.v1beta1.DestinationRuleList;
import com.marcnuri.yakc.model.io.istio.networking.v1beta1.Gateway;
import com.marcnuri.yakc.model.io.istio.networking.v1beta1.GatewayList;
import com.marcnuri.yakc.model.io.istio.networking.v1beta1.WorkloadEntry;
import com.marcnuri.yakc.model.io.istio.networking.v1beta1.WorkloadEntryList;
import java.util.HashMap;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

@SuppressWarnings({"squid:S1192", "unused"})
public interface NetworkingIstioIoV1beta1Api extends Api {
  /**
   * list objects of kind DestinationRule
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/destinationrules"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<DestinationRuleList, DestinationRule> listDestinationRuleForAllNamespaces();

  /**
   * list objects of kind DestinationRule
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/destinationrules"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<DestinationRuleList, DestinationRule> listDestinationRuleForAllNamespaces(
    @QueryMap ListDestinationRuleForAllNamespaces queryParameters);

  
  final class ListDestinationRuleForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListDestinationRuleForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListDestinationRuleForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListDestinationRuleForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListDestinationRuleForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListDestinationRuleForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListDestinationRuleForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListDestinationRuleForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListDestinationRuleForAllNamespaces resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListDestinationRuleForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListDestinationRuleForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Gateway
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/gateways"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<GatewayList, Gateway> listGatewayForAllNamespaces();

  /**
   * list objects of kind Gateway
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/gateways"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<GatewayList, Gateway> listGatewayForAllNamespaces(
    @QueryMap ListGatewayForAllNamespaces queryParameters);

  
  final class ListGatewayForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListGatewayForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListGatewayForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListGatewayForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListGatewayForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListGatewayForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListGatewayForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListGatewayForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListGatewayForAllNamespaces resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListGatewayForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListGatewayForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * delete collection of DestinationRule
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedDestinationRule(
    @Path("namespace") String namespace);

  /**
   * delete collection of DestinationRule
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedDestinationRule(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedDestinationRule queryParameters);

  
  final class DeleteCollectionNamespacedDestinationRule extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedDestinationRule pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedDestinationRule allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedDestinationRule continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedDestinationRule fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedDestinationRule labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedDestinationRule limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedDestinationRule resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedDestinationRule resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedDestinationRule timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedDestinationRule watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind DestinationRule
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<DestinationRuleList, DestinationRule> listNamespacedDestinationRule(
    @Path("namespace") String namespace);

  /**
   * list objects of kind DestinationRule
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<DestinationRuleList, DestinationRule> listNamespacedDestinationRule(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedDestinationRule queryParameters);

  
  final class ListNamespacedDestinationRule extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedDestinationRule pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedDestinationRule allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedDestinationRule continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedDestinationRule fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedDestinationRule labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedDestinationRule limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedDestinationRule resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedDestinationRule resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedDestinationRule timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedDestinationRule watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a DestinationRule
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> createNamespacedDestinationRule(
    @Path("namespace") String namespace, 
    @Body DestinationRule body);

  /**
   * create a DestinationRule
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> createNamespacedDestinationRule(
    @Path("namespace") String namespace, 
    @Body DestinationRule body, 
    @QueryMap CreateNamespacedDestinationRule queryParameters);

  
  final class CreateNamespacedDestinationRule extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedDestinationRule pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedDestinationRule dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedDestinationRule fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body);

    /**
   * delete a DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body, 
    @QueryMap DeleteNamespacedDestinationRule queryParameters);

  /**
   * delete a DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedDestinationRule queryParameters);

  
  final class DeleteNamespacedDestinationRule extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedDestinationRule pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedDestinationRule dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedDestinationRule gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedDestinationRule orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedDestinationRule propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> readNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> readNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedDestinationRule queryParameters);

  
  final class ReadNamespacedDestinationRule extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedDestinationRule pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedDestinationRule resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> patchNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body);

  /**
   * partially update the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> patchNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body, 
    @QueryMap PatchNamespacedDestinationRule queryParameters);

  
  final class PatchNamespacedDestinationRule extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedDestinationRule pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedDestinationRule dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedDestinationRule fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> replaceNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body);

  /**
   * replace the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> replaceNamespacedDestinationRule(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body, 
    @QueryMap ReplaceNamespacedDestinationRule queryParameters);

  
  final class ReplaceNamespacedDestinationRule extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedDestinationRule pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedDestinationRule dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedDestinationRule fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> readNamespacedDestinationRuleStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> readNamespacedDestinationRuleStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedDestinationRuleStatus queryParameters);

  
  final class ReadNamespacedDestinationRuleStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedDestinationRuleStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedDestinationRuleStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> patchNamespacedDestinationRuleStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body);

  /**
   * partially update status of the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> patchNamespacedDestinationRuleStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body, 
    @QueryMap PatchNamespacedDestinationRuleStatus queryParameters);

  
  final class PatchNamespacedDestinationRuleStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedDestinationRuleStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedDestinationRuleStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedDestinationRuleStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> replaceNamespacedDestinationRuleStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body);

  /**
   * replace status of the specified DestinationRule
   *
   * @param name name of the DestinationRule
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/destinationrules/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<DestinationRule> replaceNamespacedDestinationRuleStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body DestinationRule body, 
    @QueryMap ReplaceNamespacedDestinationRuleStatus queryParameters);

  
  final class ReplaceNamespacedDestinationRuleStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedDestinationRuleStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedDestinationRuleStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedDestinationRuleStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of Gateway
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedGateway(
    @Path("namespace") String namespace);

  /**
   * delete collection of Gateway
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedGateway(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedGateway queryParameters);

  
  final class DeleteCollectionNamespacedGateway extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedGateway pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedGateway allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedGateway continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedGateway fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedGateway labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedGateway limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedGateway resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedGateway resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedGateway timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedGateway watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind Gateway
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<GatewayList, Gateway> listNamespacedGateway(
    @Path("namespace") String namespace);

  /**
   * list objects of kind Gateway
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<GatewayList, Gateway> listNamespacedGateway(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedGateway queryParameters);

  
  final class ListNamespacedGateway extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedGateway pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedGateway allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedGateway continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedGateway fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedGateway labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedGateway limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedGateway resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedGateway resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedGateway timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedGateway watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a Gateway
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> createNamespacedGateway(
    @Path("namespace") String namespace, 
    @Body Gateway body);

  /**
   * create a Gateway
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> createNamespacedGateway(
    @Path("namespace") String namespace, 
    @Body Gateway body, 
    @QueryMap CreateNamespacedGateway queryParameters);

  
  final class CreateNamespacedGateway extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedGateway pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedGateway dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedGateway fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body);

    /**
   * delete a Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body, 
    @QueryMap DeleteNamespacedGateway queryParameters);

  /**
   * delete a Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedGateway queryParameters);

  
  final class DeleteNamespacedGateway extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedGateway pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedGateway dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedGateway gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedGateway orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedGateway propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Gateway> readNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Gateway> readNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedGateway queryParameters);

  
  final class ReadNamespacedGateway extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedGateway pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedGateway resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> patchNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body);

  /**
   * partially update the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> patchNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body, 
    @QueryMap PatchNamespacedGateway queryParameters);

  
  final class PatchNamespacedGateway extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedGateway pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedGateway dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedGateway fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> replaceNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body);

  /**
   * replace the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> replaceNamespacedGateway(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body, 
    @QueryMap ReplaceNamespacedGateway queryParameters);

  
  final class ReplaceNamespacedGateway extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedGateway pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedGateway dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedGateway fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Gateway> readNamespacedGatewayStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Gateway> readNamespacedGatewayStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedGatewayStatus queryParameters);

  
  final class ReadNamespacedGatewayStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedGatewayStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedGatewayStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> patchNamespacedGatewayStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body);

  /**
   * partially update status of the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> patchNamespacedGatewayStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body, 
    @QueryMap PatchNamespacedGatewayStatus queryParameters);

  
  final class PatchNamespacedGatewayStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedGatewayStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedGatewayStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedGatewayStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> replaceNamespacedGatewayStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body);

  /**
   * replace status of the specified Gateway
   *
   * @param name name of the Gateway
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/gateways/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Gateway> replaceNamespacedGatewayStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body Gateway body, 
    @QueryMap ReplaceNamespacedGatewayStatus queryParameters);

  
  final class ReplaceNamespacedGatewayStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedGatewayStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedGatewayStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedGatewayStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete collection of WorkloadEntry
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedWorkloadEntry(
    @Path("namespace") String namespace);

  /**
   * delete collection of WorkloadEntry
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteCollectionNamespacedWorkloadEntry(
    @Path("namespace") String namespace, 
    @QueryMap DeleteCollectionNamespacedWorkloadEntry queryParameters);

  
  final class DeleteCollectionNamespacedWorkloadEntry extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionNamespacedWorkloadEntry pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public DeleteCollectionNamespacedWorkloadEntry allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionNamespacedWorkloadEntry continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionNamespacedWorkloadEntry fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionNamespacedWorkloadEntry labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionNamespacedWorkloadEntry limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedWorkloadEntry resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionNamespacedWorkloadEntry resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionNamespacedWorkloadEntry timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public DeleteCollectionNamespacedWorkloadEntry watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * list objects of kind WorkloadEntry
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<WorkloadEntryList, WorkloadEntry> listNamespacedWorkloadEntry(
    @Path("namespace") String namespace);

  /**
   * list objects of kind WorkloadEntry
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<WorkloadEntryList, WorkloadEntry> listNamespacedWorkloadEntry(
    @Path("namespace") String namespace, 
    @QueryMap ListNamespacedWorkloadEntry queryParameters);

  
  final class ListNamespacedWorkloadEntry extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListNamespacedWorkloadEntry pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListNamespacedWorkloadEntry allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListNamespacedWorkloadEntry continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListNamespacedWorkloadEntry fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListNamespacedWorkloadEntry labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListNamespacedWorkloadEntry limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedWorkloadEntry resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListNamespacedWorkloadEntry resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListNamespacedWorkloadEntry timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListNamespacedWorkloadEntry watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a WorkloadEntry
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> createNamespacedWorkloadEntry(
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body);

  /**
   * create a WorkloadEntry
   *
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "POST",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> createNamespacedWorkloadEntry(
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body, 
    @QueryMap CreateNamespacedWorkloadEntry queryParameters);

  
  final class CreateNamespacedWorkloadEntry extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateNamespacedWorkloadEntry pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateNamespacedWorkloadEntry dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateNamespacedWorkloadEntry fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body);

    /**
   * delete a WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * delete a WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions body, 
    @QueryMap DeleteNamespacedWorkloadEntry queryParameters);

  /**
   * delete a WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.Status> deleteNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap DeleteNamespacedWorkloadEntry queryParameters);

  
  final class DeleteNamespacedWorkloadEntry extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteNamespacedWorkloadEntry pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteNamespacedWorkloadEntry dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteNamespacedWorkloadEntry gracePeriodSeconds(Number gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteNamespacedWorkloadEntry orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteNamespacedWorkloadEntry propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> readNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> readNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedWorkloadEntry queryParameters);

  
  final class ReadNamespacedWorkloadEntry extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedWorkloadEntry pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedWorkloadEntry resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> patchNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body);

  /**
   * partially update the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> patchNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body, 
    @QueryMap PatchNamespacedWorkloadEntry queryParameters);

  
  final class PatchNamespacedWorkloadEntry extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedWorkloadEntry pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedWorkloadEntry dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedWorkloadEntry fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> replaceNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body);

  /**
   * replace the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> replaceNamespacedWorkloadEntry(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body, 
    @QueryMap ReplaceNamespacedWorkloadEntry queryParameters);

  
  final class ReplaceNamespacedWorkloadEntry extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedWorkloadEntry pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedWorkloadEntry dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedWorkloadEntry fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> readNamespacedWorkloadEntryStatus(
    @Path("name") String name,
    @Path("namespace") String namespace);

  /**
   * read status of the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> readNamespacedWorkloadEntryStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @QueryMap ReadNamespacedWorkloadEntryStatus queryParameters);

  
  final class ReadNamespacedWorkloadEntryStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadNamespacedWorkloadEntryStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ReadNamespacedWorkloadEntryStatus resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }
  } 
  /**
   * partially update status of the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> patchNamespacedWorkloadEntryStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body);

  /**
   * partially update status of the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> patchNamespacedWorkloadEntryStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body, 
    @QueryMap PatchNamespacedWorkloadEntryStatus queryParameters);

  
  final class PatchNamespacedWorkloadEntryStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchNamespacedWorkloadEntryStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchNamespacedWorkloadEntryStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public PatchNamespacedWorkloadEntryStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * replace status of the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> replaceNamespacedWorkloadEntryStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body);

  /**
   * replace status of the specified WorkloadEntry
   *
   * @param name name of the WorkloadEntry
   * @param namespace object name and auth scope, such as for teams and projects
   */
  @HTTP(
    method = "PUT",
    path = "/apis/networking.istio.io/v1beta1/namespaces/{namespace}/workloadentries/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<WorkloadEntry> replaceNamespacedWorkloadEntryStatus(
    @Path("name") String name,
    @Path("namespace") String namespace, 
    @Body WorkloadEntry body, 
    @QueryMap ReplaceNamespacedWorkloadEntryStatus queryParameters);

  
  final class ReplaceNamespacedWorkloadEntryStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceNamespacedWorkloadEntryStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceNamespacedWorkloadEntryStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceNamespacedWorkloadEntryStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * list objects of kind WorkloadEntry
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/workloadentries"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<WorkloadEntryList, WorkloadEntry> listWorkloadEntryForAllNamespaces();

  /**
   * list objects of kind WorkloadEntry
   */
  @HTTP(
    method = "GET",
    path = "/apis/networking.istio.io/v1beta1/workloadentries"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<WorkloadEntryList, WorkloadEntry> listWorkloadEntryForAllNamespaces(
    @QueryMap ListWorkloadEntryForAllNamespaces queryParameters);

  
  final class ListWorkloadEntryForAllNamespaces extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListWorkloadEntryForAllNamespaces allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListWorkloadEntryForAllNamespaces continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListWorkloadEntryForAllNamespaces fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListWorkloadEntryForAllNamespaces labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListWorkloadEntryForAllNamespaces limit(Number limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public ListWorkloadEntryForAllNamespaces pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListWorkloadEntryForAllNamespaces resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListWorkloadEntryForAllNamespaces resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListWorkloadEntryForAllNamespaces timeoutSeconds(Number timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListWorkloadEntryForAllNamespaces watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
