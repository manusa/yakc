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

package com.marcnuri.yakc.model.io.openshift.operator.samples.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ConfigStatus contains the actual configuration in effect, as well as various details that describe the state of the Samples Operator.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ConfigStatus implements Model {


  /**
   * architectures determine which hardware architecture(s) to install, where x86_64 and ppc64le are the supported choices.
   */
  @JsonProperty("architectures")
  @Singular(value = "addToArchitectures", ignoreNullCollections = true)
  private List<String> architectures;

  /**
   * conditions represents the available maintenance status of the sample imagestreams and templates.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ConfigStatusConditions> conditions;

  /**
   * managementState reflects the current operational status of the on/off switch for the operator.  This operator compares the ManagementState as part of determining that we are turning the operator back on (i.e. "Managed") when it was previously "Unmanaged".
   */
  @JsonProperty("managementState")
  private String managementState;

  /**
   * samplesRegistry allows for the specification of which registry is accessed by the ImageStreams for their image content.  Defaults on the content in https://github.com/openshift/library that are pulled into this github repository, but based on our pulling only ocp content it typically defaults to registry.redhat.io.
   */
  @JsonProperty("samplesRegistry")
  private String samplesRegistry;

  /**
   * skippedImagestreams specifies names of image streams that should NOT be created/updated.  Admins can use this to allow them to delete content they don’t want.  They will still have to manually delete the content but the operator will not recreate(or update) anything listed here.
   */
  @JsonProperty("skippedImagestreams")
  @Singular(value = "addToSkippedImagestreams", ignoreNullCollections = true)
  private List<String> skippedImagestreams;

  /**
   * skippedTemplates specifies names of templates that should NOT be created/updated.  Admins can use this to allow them to delete content they don’t want.  They will still have to manually delete the content but the operator will not recreate(or update) anything listed here.
   */
  @JsonProperty("skippedTemplates")
  @Singular(value = "addToSkippedTemplates", ignoreNullCollections = true)
  private List<String> skippedTemplates;

  /**
   * version is the value of the operator's payload based version indicator when it was last successfully processed
   */
  @JsonProperty("version")
  private String version;

}

