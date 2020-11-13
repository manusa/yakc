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

package com.marcnuri.yakc.model.com.github.openshift.api.build.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * WebHookTrigger is a trigger that gets invoked using a webhook type of post
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WebHookTrigger implements Model {


  /**
   * allowEnv determines whether the webhook can set environment variables; can only be set to true for GenericWebHook.
   */
  @JsonProperty("allowEnv")
  private Boolean allowEnv;

  /**
   * secret used to validate requests. Deprecated: use SecretReference instead.
   */
  @JsonProperty("secret")
  private String secret;

  @JsonProperty("secretReference")
  private SecretLocalReference secretReference;

}

