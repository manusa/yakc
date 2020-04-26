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

package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * CustomResourceConversion describes how to convert different versions of a CR.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomResourceConversion implements Model {


  /**
   * conversionReviewVersions is an ordered list of preferred `ConversionReview` versions the Webhook expects. The API server will use the first version in the list which it supports. If none of the versions specified in this list are supported by API server, conversion will fail for the custom resource. If a persisted Webhook configuration specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will fail. Defaults to `["v1beta1"]`.
   */
  @JsonProperty("conversionReviewVersions")
  @Singular(value = "addToConversionReviewVersions", ignoreNullCollections = true)
  private List<String> conversionReviewVersions;

  /**
   * strategy specifies how custom resources are converted between versions. Allowed values are: - `None`: The converter only change the apiVersion and would not touch any other field in the custom resource. - `Webhook`: API Server will call to an external webhook to do the conversion. Additional information<br><p>   is needed for this option. This requires spec.preserveUnknownFields to be false, and spec.conversion.webhookClientConfig to be set.
   */
  @NonNull
  @JsonProperty("strategy")
  private String strategy;

  @JsonProperty("webhookClientConfig")
  private WebhookClientConfig webhookClientConfig;

}

