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

package com.marcnuri.yakc.model.dev.kudo.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TaskSpec embeds all possible task specs. This allows us to avoid writing custom un/marshallers that would only parse certain fields depending on the task Kind. The downside of this approach is, that embedded types can not have fields with the same json names as it would become ambiguous for the default parser. We might revisit this approach in the future should this become an issue.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OperatorVersionSpecSpec implements Model {


  /**
   * a specific app version in the official repo, defaults to the most recent
   */
  @JsonProperty("appVersion")
  private String appVersion;

  @JsonProperty("done")
  private Boolean done;

  @JsonProperty("fatal")
  private Boolean fatal;

  @JsonProperty("instanceName")
  private String instanceName;

  /**
   * a specific operator version in the official repo, defaults to the most recent one
   */
  @JsonProperty("operatorVersion")
  private String operatorVersion;

  /**
   * either repo package name, local package folder or an URL to package tarball. during operator installation, kudoctl will resolve the package and override this field with the resolved operator name.
   */
  @JsonProperty("package")
  private String packages;

  @JsonProperty("parameter")
  private String parameter;

  /**
   * name of the template file (located in the `templates` folder) from which the &#42;parent&#42; instance generates a parameter file used to populate the &#42;child&#42; Instance.Spec.Parameters
   */
  @JsonProperty("parameterFile")
  private String parameterFile;

  @JsonProperty("pipe")
  private Object pipe;

  @JsonProperty("pod")
  private String pod;

  @JsonProperty("resources")
  private Object resources;

  @JsonProperty("wantErr")
  private Boolean wantErr;

}

