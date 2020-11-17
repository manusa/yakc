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
import lombok.ToString;

/**
 * spec holds user settable values for configuration
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngressSpec implements Model {


  /**
   * domain is used to generate a default host name for a route when the route's host name is empty. The generated host name will follow this pattern: "&lt;route-name&gt;.&lt;route-namespace&gt;.&lt;domain&gt;". <br><p>  It is also used as the default wildcard domain suffix for ingress. The default ingresscontroller domain will follow this pattern: "&#42;.&lt;domain&gt;". <br><p>  Once set, changing domain is not currently supported.
   */
  @JsonProperty("domain")
  private String domain;

}

