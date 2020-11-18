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

package com.marcnuri.yakc.model.com.github.openshift.api.route.v1;

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
 * RouteIngress holds information about the places where a route is exposed.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RouteIngress implements Model {


  /**
   * Conditions is the state of the route, may be empty.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<RouteIngressCondition> conditions;

  /**
   * Host is the host string under which the route is exposed; this value is required
   */
  @JsonProperty("host")
  private String host;

  /**
   * CanonicalHostname is the external host name for the router that can be used as a CNAME for the host requested for this route. This value is optional and may not be set in all cases.
   */
  @JsonProperty("routerCanonicalHostname")
  private String routerCanonicalHostname;

  /**
   * Name is a name chosen by the router to identify itself; this value is required
   */
  @JsonProperty("routerName")
  private String routerName;

  /**
   * Wildcard policy is the wildcard policy that was allowed where this route is exposed.
   */
  @JsonProperty("wildcardPolicy")
  private String wildcardPolicy;

}

