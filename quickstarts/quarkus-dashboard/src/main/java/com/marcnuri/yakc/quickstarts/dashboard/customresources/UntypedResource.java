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
 *
 * Created on 2020-11-28, 7:35
 */
package com.marcnuri.yakc.quickstarts.dashboard.customresources;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Map;

@RegisterForReflection
public class UntypedResource {

  private String apiVersion;
  private String kind;
  private ObjectMeta metadata;
  private Map<String, String> extraProperties;

  public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public ObjectMeta getMetadata() {
    return metadata;
  }

  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }

  @JsonAnyGetter
  public Map<String, String> getExtraProperties() {
    return extraProperties;
  }

  @JsonAnySetter
  public void setExtraProperties(Map<String, String> extraProperties) {
    this.extraProperties = extraProperties;
  }
}
