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

package com.marcnuri.yakc.model.io.k8s.api.networking.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * HTTPIngressPath associates a path with a backend. Incoming urls matching the path are forwarded to the backend.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HTTPIngressPath implements Model {


  @NonNull
  @JsonProperty("backend")
  private IngressBackend backend;

  /**
   * Path is matched against the path of an incoming request. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. When unspecified, all paths from incoming requests are matched.
   */
  @JsonProperty("path")
  private String path;

  /**
   * PathType determines the interpretation of the Path matching. PathType can be one of the following values: &#42; Exact: Matches the URL path exactly. &#42; Prefix: Matches based on a URL path prefix split by '/'. Matching is<br><p>   done on a path element by element basis. A path element refers is the<br><p>   list of labels in the path split by the '/' separator. A request is a<br><p>   match for path p if every p is an element-wise prefix of p of the<br><p>   request path. Note that if the last element of the path is a substring<br><p>   of the last element in request path, it is not a match (e.g. /foo/bar<br><p>   matches /foo/bar/baz, but does not match /foo/barbaz).<br><p> &#42; ImplementationSpecific: Interpretation of the Path matching is up to<br><p>   the IngressClass. Implementations can treat this as a separate PathType<br><p>   or treat it identically to Prefix or Exact path types.<br><p> Implementations are required to support all path types.
   */
  @JsonProperty("pathType")
  private String pathType;

}

