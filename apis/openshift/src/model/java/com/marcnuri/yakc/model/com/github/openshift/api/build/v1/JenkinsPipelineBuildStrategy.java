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
import com.marcnuri.yakc.model.io.k8s.api.core.v1.EnvVar;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * JenkinsPipelineBuildStrategy holds parameters specific to a Jenkins Pipeline build.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JenkinsPipelineBuildStrategy implements Model {


  /**
   * env contains additional environment variables you want to pass into a build pipeline.
   */
  @JsonProperty("env")
  @Singular(value = "addToEnv", ignoreNullCollections = true)
  private List<EnvVar> env;

  /**
   * Jenkinsfile defines the optional raw contents of a Jenkinsfile which defines a Jenkins pipeline build.
   */
  @JsonProperty("jenkinsfile")
  private String jenkinsfile;

  /**
   * JenkinsfilePath is the optional path of the Jenkinsfile that will be used to configure the pipeline relative to the root of the context (contextDir). If both JenkinsfilePath &amp; Jenkinsfile are both not specified, this defaults to Jenkinsfile in the root of the specified contextDir.
   */
  @JsonProperty("jenkinsfilePath")
  private String jenkinsfilePath;

}

