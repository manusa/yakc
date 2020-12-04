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

package com.marcnuri.yakc.model.org.chaosmesh.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Script represents the detail about JVM chaos action of Java or Groovy scripts
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JVMChaosSpecScript implements Model {


  /**
   * After represents method execution is completed before the injection failure is returned.
   */
  @JsonProperty("after")
  private Boolean after;

  /**
   * Classname represents specify the class name, which must be an implementation class with a full package name, such as com.xxx.xxx.XController. required
   */
  @NonNull
  @JsonProperty("classname")
  private String classname;

  /**
   * Content represents the script content is Base64 encoded content. Note that it cannot be used with file
   */
  @JsonProperty("content")
  private String content;

  /**
   * File represents script file, absolute path to file Note that it cannot be used with content
   */
  @JsonProperty("file")
  private String file;

  /**
   * Methodname represents specify the method name. Note that methods with the same method name will be injected with the same fault. required
   */
  @NonNull
  @JsonProperty("methodname")
  private String methodname;

  /**
   * Name represents script name, use for logging
   */
  @JsonProperty("name")
  private String name;

  /**
   * Type represents script type, java or groovy, default to java
   */
  @JsonProperty("type")
  private String type;

}

