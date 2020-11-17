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

package com.marcnuri.yakc.model.io.openshift.operator.ingress.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * dnsZone is the zone where the record is published.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DNSRecordStatusDnsZone implements Model {


  /**
   * id is the identifier that can be used to find the DNS hosted zone. <br><p>  on AWS zone can be fetched using `ID` as id in [1] on Azure zone can be fetched using `ID` as a pre-determined name in [2], on GCP zone can be fetched using `ID` as a pre-determined name in [3]. <br><p>  [1]: https://docs.aws.amazon.com/cli/latest/reference/route53/get-hosted-zone.html#options [2]: https://docs.microsoft.com/en-us/cli/azure/network/dns/zone?view=azure-cli-latest#az-network-dns-zone-show [3]: https://cloud.google.com/dns/docs/reference/v1/managedZones/get
   */
  @JsonProperty("id")
  private String id;

  /**
   * tags can be used to query the DNS hosted zone. <br><p>  on AWS, resourcegroupstaggingapi [1] can be used to fetch a zone using `Tags` as tag-filters, <br><p>  [1]: https://docs.aws.amazon.com/cli/latest/reference/resourcegroupstaggingapi/get-resources.html#options
   */
  @JsonProperty("tags")
  @Singular(value = "putInTags", ignoreNullCollections = true)
  private Map<String, String> tags;

}

