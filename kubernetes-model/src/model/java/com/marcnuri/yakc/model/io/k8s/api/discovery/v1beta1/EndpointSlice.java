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

package com.marcnuri.yakc.model.io.k8s.api.discovery.v1beta1;

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
 * EndpointSlice represents a subset of the endpoints that implement a service. For a given service there may be multiple EndpointSlice objects, selected by labels, which must be joined to produce the full set of endpoints.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EndpointSlice implements Model {


  /**
   * addressType specifies the type of address carried by this EndpointSlice. All addresses in this slice must be the same type. This field is immutable after creation. The following address types are currently supported: &#42; IPv4: Represents an IPv4 Address. &#42; IPv6: Represents an IPv6 Address. &#42; FQDN: Represents a Fully Qualified Domain Name.
   */
  @NonNull
  @JsonProperty("addressType")
  private String addressType;

  /**
   * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
   */
  @JsonProperty("apiVersion")
  private String apiVersion;

  /**
   * endpoints is a list of unique endpoints in this slice. Each slice may include a maximum of 1000 endpoints.
   */
  @NonNull
  @JsonProperty("endpoints")
  @Singular(value = "addToEndpoints", ignoreNullCollections = true)
  private List<Endpoint> endpoints;

  /**
   * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
   */
  @JsonProperty("kind")
  private String kind;

  @JsonProperty("metadata")
  private ObjectMeta metadata;

  /**
   * ports specifies the list of network ports exposed by each endpoint in this slice. Each port must have a unique name. When ports is empty, it indicates that there are no defined ports. When a port is defined with a nil port value, it indicates "all ports". Each slice may include a maximum of 100 ports.
   */
  @JsonProperty("ports")
  @Singular(value = "addToPorts", ignoreNullCollections = true)
  private List<EndpointPort> ports;

}

