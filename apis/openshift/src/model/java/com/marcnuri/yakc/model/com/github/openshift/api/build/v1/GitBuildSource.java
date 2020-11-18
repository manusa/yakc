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

package com.marcnuri.yakc.model.com.github.openshift.api.build.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * GitBuildSource defines the parameters of a Git SCM
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GitBuildSource implements Model {


  /**
   * httpProxy is a proxy used to reach the git repository over http
   */
  @JsonProperty("httpProxy")
  private String httpProxy;

  /**
   * httpsProxy is a proxy used to reach the git repository over https
   */
  @JsonProperty("httpsProxy")
  private String httpsProxy;

  /**
   * noProxy is the list of domains for which the proxy should not be used
   */
  @JsonProperty("noProxy")
  private String noProxy;

  /**
   * ref is the branch/tag/ref to build.
   */
  @JsonProperty("ref")
  private String ref;

  /**
   * uri points to the source that will be built. The structure of the source will depend on the type of build to run
   */
  @NonNull
  @JsonProperty("uri")
  private String uri;

}

