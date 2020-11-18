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

package com.marcnuri.yakc.model.io.openshift.network.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * HostSubnet describes the container subnet network on a node. The HostSubnet object must have the same name as the Node object it corresponds to.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HostSubnet implements Model {


  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * EgressCIDRs is the list of CIDR ranges available for automatically assigning egress IPs to this node from. If this field is set then EgressIPs should be treated as read-only.
   */
  @JsonProperty("egressCIDRs")
  @Singular(value = "addToEgressCIDRs", ignoreNullCollections = true)
  private List<String> egressCIDRs;

  /**
   * EgressIPs is the list of automatic egress IP addresses currently hosted by this node. If EgressCIDRs is empty, this can be set by hand; if EgressCIDRs is set then the master will overwrite the value here with its own allocation of egress IPs.
   */
  @JsonProperty("egressIPs")
  @Singular(value = "addToEgressIPs", ignoreNullCollections = true)
  private List<String> egressIPs;

  /**
   * Host is the name of the node. (This is the same as the object's name, but both fields must be set.)
   */
  @NonNull
  @JsonProperty("host")
  private String host;

  /**
   * HostIP is the IP address to be used as a VTEP by other nodes in the overlay network
   */
  @NonNull
  @JsonProperty("hostIP")
  private String hostIP;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  /**
   * Subnet is the CIDR range of the overlay network assigned to the node for its pods
   */
  @JsonProperty("subnet")
  private String subnet;

}

