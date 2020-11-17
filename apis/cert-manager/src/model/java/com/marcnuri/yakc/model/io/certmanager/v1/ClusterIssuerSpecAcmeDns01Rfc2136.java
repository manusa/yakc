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

package com.marcnuri.yakc.model.io.certmanager.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Use RFC2136 ("Dynamic Updates in the Domain Name System") (https://datatracker.ietf.org/doc/rfc2136/) to manage DNS01 challenge records.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClusterIssuerSpecAcmeDns01Rfc2136 implements Model {


  /**
   * The IP address or hostname of an authoritative DNS server supporting RFC2136 in the form host:port. If the host is an IPv6 address it must be enclosed in square brackets (e.g [2001:db8::1]) ; port is optional. This field is required.
   */
  @NonNull
  @JsonProperty("nameserver")
  private String nameserver;

  /**
   * The TSIG Algorithm configured in the DNS supporting RFC2136. Used only when ``tsigSecretSecretRef`` and ``tsigKeyName`` are defined. Supported values are (case-insensitive): ``HMACMD5`` (default), ``HMACSHA1``, ``HMACSHA256`` or ``HMACSHA512``.
   */
  @JsonProperty("tsigAlgorithm")
  private String tsigAlgorithm;

  /**
   * The TSIG Key name configured in the DNS. If ``tsigSecretSecretRef`` is defined, this field is required.
   */
  @JsonProperty("tsigKeyName")
  private String tsigKeyName;

  @JsonProperty("tsigSecretSecretRef")
  private ClusterIssuerSpecAcmeDns01Rfc2136TsigSecretSecretRef tsigSecretSecretRef;

}

