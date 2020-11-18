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
import com.marcnuri.yakc.model.io.openshift.operator.imageregistry.v1.ConfigStatusConditions;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * status is the most recently observed status of the DNS.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DNSStatus implements Model {


  /**
   * clusterDomain is the local cluster DNS domain suffix for DNS services. This will be a subdomain as defined in RFC 1034, section 3.5: https://tools.ietf.org/html/rfc1034#section-3.5 Example: "cluster.local" <br><p>  More info: https://kubernetes.io/docs/concepts/services-networking/dns-pod-service
   */
  @NonNull
  @JsonProperty("clusterDomain")
  private String clusterDomain;

  /**
   * clusterIP is the service IP through which this DNS is made available. <br><p>  In the case of the default DNS, this will be a well known IP that is used as the default nameserver for pods that are using the default ClusterFirst DNS policy. <br><p>  In general, this IP can be specified in a pod's spec.dnsConfig.nameservers list or used explicitly when performing name resolution from within the cluster. Example: dig foo.com @&lt;service IP&gt; <br><p>  More info: https://kubernetes.io/docs/concepts/services-networking/service/#virtual-ips-and-service-proxies
   */
  @NonNull
  @JsonProperty("clusterIP")
  private String clusterIP;

  /**
   * conditions provide information about the state of the DNS on the cluster. <br><p>  These are the supported DNS conditions: <br><p>    &#42; Available   - True if the following conditions are met:     &#42; DNS controller daemonset is available.   - False if any of those conditions are unsatisfied.
   */
  @JsonProperty("conditions")
  @Singular(value = "addToConditions", ignoreNullCollections = true)
  private List<ConfigStatusConditions> conditions;

}

