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

package com.marcnuri.yakc.api.certificates.v1;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.api.KubernetesListCall;
import com.marcnuri.yakc.model.io.k8s.api.certificates.v1.CertificateSigningRequest;
import com.marcnuri.yakc.model.io.k8s.api.certificates.v1.CertificateSigningRequestList;
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
public interface CertificatesV1Api extends Api {
  /**
   * get available resources
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<APIResourceList> getAPIResources();

  /**
   * delete collection of CertificateSigningRequest
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionCertificateSigningRequest(
    @Body DeleteOptions body);

    /**
   * delete collection of CertificateSigningRequest
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionCertificateSigningRequest();

  /**
   * delete collection of CertificateSigningRequest
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionCertificateSigningRequest(
    @Body DeleteOptions body, 
    @QueryMap DeleteCollectionCertificateSigningRequest queryParameters);

  /**
   * delete collection of CertificateSigningRequest
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCollectionCertificateSigningRequest(
    @QueryMap DeleteCollectionCertificateSigningRequest queryParameters);

  
  final class DeleteCollectionCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCollectionCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public DeleteCollectionCertificateSigningRequest continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCollectionCertificateSigningRequest dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public DeleteCollectionCertificateSigningRequest fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCollectionCertificateSigningRequest gracePeriodSeconds(Integer gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public DeleteCollectionCertificateSigningRequest labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public DeleteCollectionCertificateSigningRequest limit(Integer limit) {
      put("limit", limit);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCollectionCertificateSigningRequest orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCollectionCertificateSigningRequest propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionCertificateSigningRequest resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public DeleteCollectionCertificateSigningRequest resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public DeleteCollectionCertificateSigningRequest timeoutSeconds(Integer timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }
  } 
  /**
   * list or watch objects of kind CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CertificateSigningRequestList, CertificateSigningRequest> listCertificateSigningRequest();

  /**
   * list or watch objects of kind CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesListCall<CertificateSigningRequestList, CertificateSigningRequest> listCertificateSigningRequest(
    @QueryMap ListCertificateSigningRequest queryParameters);

  
  final class ListCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ListCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public ListCertificateSigningRequest allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public ListCertificateSigningRequest continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public ListCertificateSigningRequest fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public ListCertificateSigningRequest labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public ListCertificateSigningRequest limit(Integer limit) {
      put("limit", limit);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListCertificateSigningRequest resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public ListCertificateSigningRequest resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public ListCertificateSigningRequest timeoutSeconds(Integer timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public ListCertificateSigningRequest watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * create a CertificateSigningRequest
   */
  @HTTP(
    method = "POST",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> createCertificateSigningRequest(
    @Body CertificateSigningRequest body);

  /**
   * create a CertificateSigningRequest
   */
  @HTTP(
    method = "POST",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> createCertificateSigningRequest(
    @Body CertificateSigningRequest body, 
    @QueryMap CreateCertificateSigningRequest queryParameters);

  
  final class CreateCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public CreateCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public CreateCertificateSigningRequest dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public CreateCertificateSigningRequest fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * delete a CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCertificateSigningRequest(
    @Path("name") String name, 
    @Body DeleteOptions body);

    /**
   * delete a CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
    @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCertificateSigningRequest(
    @Path("name") String name);

  /**
   * delete a CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCertificateSigningRequest(
    @Path("name") String name, 
    @Body DeleteOptions body, 
    @QueryMap DeleteCertificateSigningRequest queryParameters);

  /**
   * delete a CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "DELETE",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<Status> deleteCertificateSigningRequest(
    @Path("name") String name, 
    @QueryMap DeleteCertificateSigningRequest queryParameters);

  
  final class DeleteCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public DeleteCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public DeleteCertificateSigningRequest dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
     */
    public DeleteCertificateSigningRequest gracePeriodSeconds(Integer gracePeriodSeconds) {
      put("gracePeriodSeconds", gracePeriodSeconds);
      return this;
    }

    /**
     * Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the "orphan" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
     */
    public DeleteCertificateSigningRequest orphanDependents(Boolean orphanDependents) {
      put("orphanDependents", orphanDependents);
      return this;
    }

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes all dependents in the foreground.
     */
    public DeleteCertificateSigningRequest propagationPolicy(String propagationPolicy) {
      put("propagationPolicy", propagationPolicy);
      return this;
    }
  } 
  /**
   * read the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> readCertificateSigningRequest(
    @Path("name") String name);

  /**
   * read the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> readCertificateSigningRequest(
    @Path("name") String name, 
    @QueryMap ReadCertificateSigningRequest queryParameters);

  
  final class ReadCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * Should the export be exact.  Exact export maintains cluster-specific fields like 'Namespace'. Deprecated. Planned for removal in 1.18.
     */
    public ReadCertificateSigningRequest exact(Boolean exact) {
      put("exact", exact);
      return this;
    }

    /**
     * Should this value be exported.  Export strips fields that a user can not specify. Deprecated. Planned for removal in 1.18.
     */
    public ReadCertificateSigningRequest export(Boolean export) {
      put("export", export);
      return this;
    }
  } 
  /**
   * partially update the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> patchCertificateSigningRequest(
    @Path("name") String name, 
    @Body CertificateSigningRequest body);

  /**
   * partially update the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> patchCertificateSigningRequest(
    @Path("name") String name, 
    @Body CertificateSigningRequest body, 
    @QueryMap PatchCertificateSigningRequest queryParameters);

  
  final class PatchCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchCertificateSigningRequest dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchCertificateSigningRequest fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchCertificateSigningRequest force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PUT",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> replaceCertificateSigningRequest(
    @Path("name") String name, 
    @Body CertificateSigningRequest body);

  /**
   * replace the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PUT",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> replaceCertificateSigningRequest(
    @Path("name") String name, 
    @Body CertificateSigningRequest body, 
    @QueryMap ReplaceCertificateSigningRequest queryParameters);

  
  final class ReplaceCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceCertificateSigningRequest dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceCertificateSigningRequest fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read approval of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/approval"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> readCertificateSigningRequestApproval(
    @Path("name") String name);

  /**
   * read approval of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/approval"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> readCertificateSigningRequestApproval(
    @Path("name") String name, 
    @QueryMap ReadCertificateSigningRequestApproval queryParameters);

  
  final class ReadCertificateSigningRequestApproval extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadCertificateSigningRequestApproval pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update approval of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/approval",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> patchCertificateSigningRequestApproval(
    @Path("name") String name, 
    @Body CertificateSigningRequest body);

  /**
   * partially update approval of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/approval",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> patchCertificateSigningRequestApproval(
    @Path("name") String name, 
    @Body CertificateSigningRequest body, 
    @QueryMap PatchCertificateSigningRequestApproval queryParameters);

  
  final class PatchCertificateSigningRequestApproval extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchCertificateSigningRequestApproval pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchCertificateSigningRequestApproval dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchCertificateSigningRequestApproval fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchCertificateSigningRequestApproval force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace approval of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PUT",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/approval",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> replaceCertificateSigningRequestApproval(
    @Path("name") String name, 
    @Body CertificateSigningRequest body);

  /**
   * replace approval of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PUT",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/approval",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> replaceCertificateSigningRequestApproval(
    @Path("name") String name, 
    @Body CertificateSigningRequest body, 
    @QueryMap ReplaceCertificateSigningRequestApproval queryParameters);

  
  final class ReplaceCertificateSigningRequestApproval extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceCertificateSigningRequestApproval pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceCertificateSigningRequestApproval dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceCertificateSigningRequestApproval fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * read status of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> readCertificateSigningRequestStatus(
    @Path("name") String name);

  /**
   * read status of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/status"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> readCertificateSigningRequestStatus(
    @Path("name") String name, 
    @QueryMap ReadCertificateSigningRequestStatus queryParameters);

  
  final class ReadCertificateSigningRequestStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReadCertificateSigningRequestStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }
  } 
  /**
   * partially update status of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> patchCertificateSigningRequestStatus(
    @Path("name") String name, 
    @Body CertificateSigningRequest body);

  /**
   * partially update status of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PATCH",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/merge-patch+json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> patchCertificateSigningRequestStatus(
    @Path("name") String name, 
    @Body CertificateSigningRequest body, 
    @QueryMap PatchCertificateSigningRequestStatus queryParameters);

  
  final class PatchCertificateSigningRequestStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public PatchCertificateSigningRequestStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public PatchCertificateSigningRequestStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    public PatchCertificateSigningRequestStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people. Force flag must be unset for non-apply patch requests.
     */
    public PatchCertificateSigningRequestStatus force(Boolean force) {
      put("force", force);
      return this;
    }
  } 
  /**
   * replace status of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PUT",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> replaceCertificateSigningRequestStatus(
    @Path("name") String name, 
    @Body CertificateSigningRequest body);

  /**
   * replace status of the specified CertificateSigningRequest
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "PUT",
    path = "/apis/certificates.k8s.io/v1/certificatesigningrequests/{name}/status",
    hasBody = true
  )
  @Headers({ 
    "Content-Type: application/json",
    "Accept: */*"
  })
  KubernetesCall<CertificateSigningRequest> replaceCertificateSigningRequestStatus(
    @Path("name") String name, 
    @Body CertificateSigningRequest body, 
    @QueryMap ReplaceCertificateSigningRequestStatus queryParameters);

  
  final class ReplaceCertificateSigningRequestStatus extends HashMap<String, Object> { 
    /**
     * If 'true', then the output is pretty printed.
     */
    public ReplaceCertificateSigningRequestStatus pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive will result in an error response and no further processing of the request. Valid values are: - All: all dry run stages will be processed
     */
    public ReplaceCertificateSigningRequestStatus dryRun(String dryRun) {
      put("dryRun", dryRun);
      return this;
    }

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less than or 128 characters long, and only contain printable characters, as defined by https://golang.org/pkg/unicode/#IsPrint.
     */
    public ReplaceCertificateSigningRequestStatus fieldManager(String fieldManager) {
      put("fieldManager", fieldManager);
      return this;
    }
  } 
  /**
   * watch individual changes to a list of CertificateSigningRequest. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/watch/certificatesigningrequests"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchCertificateSigningRequestList();

  /**
   * watch individual changes to a list of CertificateSigningRequest. deprecated: use the 'watch' parameter with a list operation instead.
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/watch/certificatesigningrequests"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchCertificateSigningRequestList(
    @QueryMap WatchCertificateSigningRequestList queryParameters);

  
  final class WatchCertificateSigningRequestList extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public WatchCertificateSigningRequestList allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchCertificateSigningRequestList continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchCertificateSigningRequestList fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchCertificateSigningRequestList labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchCertificateSigningRequestList limit(Integer limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchCertificateSigningRequestList pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchCertificateSigningRequestList resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchCertificateSigningRequestList resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchCertificateSigningRequestList timeoutSeconds(Integer timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchCertificateSigningRequestList watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
  /**
   * watch changes to an object of kind CertificateSigningRequest. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/watch/certificatesigningrequests/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchCertificateSigningRequest(
    @Path("name") String name);

  /**
   * watch changes to an object of kind CertificateSigningRequest. deprecated: use the 'watch' parameter with a list operation instead, filtered to a single item with the 'fieldSelector' parameter.
   *
   * @param name name of the CertificateSigningRequest
   */
  @HTTP(
    method = "GET",
    path = "/apis/certificates.k8s.io/v1/watch/certificatesigningrequests/{name}"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<WatchEvent> watchCertificateSigningRequest(
    @Path("name") String name, 
    @QueryMap WatchCertificateSigningRequest queryParameters);

  
  final class WatchCertificateSigningRequest extends HashMap<String, Object> { 
    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session. If this is not a watch, this field is ignored. If the feature gate WatchBookmarks is not enabled in apiserver, this field is ignored.
     */
    public WatchCertificateSigningRequest allowWatchBookmarks(Boolean allowWatchBookmarks) {
      put("allowWatchBookmarks", allowWatchBookmarks);
      return this;
    }

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the "next key".<br><p> <br><p> This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
     */
    public WatchCertificateSigningRequest continues(String continues) {
      put("continue", continues);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    public WatchCertificateSigningRequest fieldSelector(String fieldSelector) {
      put("fieldSelector", fieldSelector);
      return this;
    }

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    public WatchCertificateSigningRequest labelSelector(String labelSelector) {
      put("labelSelector", labelSelector);
      return this;
    }

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.<br><p> <br><p> The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
     */
    public WatchCertificateSigningRequest limit(Integer limit) {
      put("limit", limit);
      return this;
    }

    /**
     * If 'true', then the output is pretty printed.
     */
    public WatchCertificateSigningRequest pretty(String pretty) {
      put("pretty", pretty);
      return this;
    }

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchCertificateSigningRequest resourceVersion(String resourceVersion) {
      put("resourceVersion", resourceVersion);
      return this;
    }

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that resourceVersionMatch be set for list calls where resourceVersion is set See https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details.<br><p> <br><p> Defaults to unset
     */
    public WatchCertificateSigningRequest resourceVersionMatch(String resourceVersionMatch) {
      put("resourceVersionMatch", resourceVersionMatch);
      return this;
    }

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    public WatchCertificateSigningRequest timeoutSeconds(Integer timeoutSeconds) {
      put("timeoutSeconds", timeoutSeconds);
      return this;
    }

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove notifications. Specify resourceVersion.
     */
    public WatchCertificateSigningRequest watch(Boolean watch) {
      put("watch", watch);
      return this;
    }
  } 
}
