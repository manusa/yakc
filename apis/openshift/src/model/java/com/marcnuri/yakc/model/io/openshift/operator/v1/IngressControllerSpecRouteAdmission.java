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

package com.marcnuri.yakc.model.io.openshift.operator.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * routeAdmission defines a policy for handling new route claims (for example, to allow or deny claims across namespaces). <br><p>  If empty, defaults will be applied. See specific routeAdmission fields for details about their defaults.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressControllerSpecRouteAdmission implements Model {


  /**
   * namespaceOwnership describes how host name claims across namespaces should be handled. <br><p>  Value must be one of: <br><p>  - Strict: Do not allow routes in different namespaces to claim the same host. <br><p>  - InterNamespaceAllowed: Allow routes to claim different paths of the same   host name across namespaces. <br><p>  If empty, the default is Strict.
   */
  @JsonProperty("namespaceOwnership")
  private String namespaceOwnership;

}

