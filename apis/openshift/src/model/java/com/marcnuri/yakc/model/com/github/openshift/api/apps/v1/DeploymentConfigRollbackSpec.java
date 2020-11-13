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

package com.marcnuri.yakc.model.com.github.openshift.api.apps.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.ObjectReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * DeploymentConfigRollbackSpec represents the options for rollback generation.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DeploymentConfigRollbackSpec implements Model {


  @NonNull
  @JsonProperty("from")
  private ObjectReference from;

  /**
   * IncludeReplicationMeta specifies whether to include the replica count and selector.
   */
  @NonNull
  @JsonProperty("includeReplicationMeta")
  private Boolean includeReplicationMeta;

  /**
   * IncludeStrategy specifies whether to include the deployment Strategy.
   */
  @NonNull
  @JsonProperty("includeStrategy")
  private Boolean includeStrategy;

  /**
   * IncludeTemplate specifies whether to include the PodTemplateSpec.
   */
  @NonNull
  @JsonProperty("includeTemplate")
  private Boolean includeTemplate;

  /**
   * IncludeTriggers specifies whether to include config Triggers.
   */
  @NonNull
  @JsonProperty("includeTriggers")
  private Boolean includeTriggers;

  /**
   * Revision to rollback to. If set to 0, rollback to the last revision.
   */
  @JsonProperty("revision")
  private Number revision;

}

