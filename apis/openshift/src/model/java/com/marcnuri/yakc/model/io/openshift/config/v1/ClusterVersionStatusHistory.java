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

package com.marcnuri.yakc.model.io.openshift.config.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * UpdateHistory is a single attempted update to the cluster.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterVersionStatusHistory implements Model {


  /**
   * completionTime, if set, is when the update was fully applied. The update that is currently being applied will have a null completion time. Completion time will always be set for entries that are not the current update (usually to the started time of the next update).
   */
  @JsonProperty("completionTime")
  private Object completionTime;

  /**
   * image is a container image location that contains the update. This value is always populated.
   */
  @NonNull
  @JsonProperty("image")
  private String image;

  /**
   * startedTime is the time at which the update was started.
   */
  @NonNull
  @JsonProperty("startedTime")
  private OffsetDateTime startedTime;

  /**
   * state reflects whether the update was fully applied. The Partial state indicates the update is not fully applied, while the Completed state indicates the update was successfully rolled out at least once (all parts of the update successfully applied).
   */
  @NonNull
  @JsonProperty("state")
  private String state;

  /**
   * verified indicates whether the provided update was properly verified before it was installed. If this is false the cluster may not be trusted.
   */
  @NonNull
  @JsonProperty("verified")
  private Boolean verified;

  /**
   * version is a semantic versioning identifying the update version. If the requested image does not define a version, or if a failure occurs retrieving the image, this value may be empty.
   */
  @JsonProperty("version")
  private String version;

}

