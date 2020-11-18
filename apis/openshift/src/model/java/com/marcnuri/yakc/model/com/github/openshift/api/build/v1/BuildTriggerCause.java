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
import lombok.ToString;

/**
 * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BuildTriggerCause implements Model {


  @JsonProperty("bitbucketWebHook")
  private BitbucketWebHookCause bitbucketWebHook;

  @JsonProperty("genericWebHook")
  private GenericWebHookCause genericWebHook;

  @JsonProperty("githubWebHook")
  private GitHubWebHookCause githubWebHook;

  @JsonProperty("gitlabWebHook")
  private GitLabWebHookCause gitlabWebHook;

  @JsonProperty("imageChangeBuild")
  private ImageChangeCause imageChangeBuild;

  /**
   * message is used to store a human readable message for why the build was triggered. E.g.: "Manually triggered by user", "Configuration change",etc.
   */
  @JsonProperty("message")
  private String message;

}

