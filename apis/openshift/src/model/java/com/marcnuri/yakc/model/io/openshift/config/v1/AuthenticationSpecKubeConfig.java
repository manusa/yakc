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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * kubeConfig contains kube config file data which describes how to access the remote webhook service. For further details, see: https://kubernetes.io/docs/reference/access-authn-authz/authentication/#webhook-token-authentication The key "kubeConfig" is used to locate the data. If the secret or expected key is not found, the webhook is not honored. If the specified kube config data is not valid, the webhook is not honored. The namespace for this secret is determined by the point of use.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuthenticationSpecKubeConfig implements Model {


  /**
   * name is the metadata.name of the referenced secret
   */
  @NonNull
  @JsonProperty("name")
  private String name;

}

