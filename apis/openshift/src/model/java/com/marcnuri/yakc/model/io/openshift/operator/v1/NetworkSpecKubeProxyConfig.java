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
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * kubeProxyConfig lets us configure desired proxy configuration. If not specified, sensible defaults will be chosen by OpenShift directly. Not consumed by all network providers - currently only openshift-sdn.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NetworkSpecKubeProxyConfig implements Model {


  /**
   * The address to "bind" on Defaults to 0.0.0.0
   */
  @JsonProperty("bindAddress")
  private String bindAddress;

  /**
   * The period that iptables rules are refreshed. Default: 30s
   */
  @JsonProperty("iptablesSyncPeriod")
  private String iptablesSyncPeriod;

  /**
   * Any additional arguments to pass to the kubeproxy process
   */
  @JsonProperty("proxyArguments")
  @Singular(value = "putInProxyArguments", ignoreNullCollections = true)
  private Map<String, List<String>> proxyArguments;

}

