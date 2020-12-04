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
 * Exception represents the detail about JVM chaos action of throwing custom exceptions
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JVMChaosSpecTce implements Model {


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
   * Exception represents the Exception class, with the full package name, must inherit from java.lang.Exception or Java.lang.Exception itself
   */
  @NonNull
  @JsonProperty("exception")
  private String exception;

  /**
   * Message represents specifies the exception class information.
   */
  @JsonProperty("message")
  private String message;

  /**
   * Methodname represents specify the method name. Note that methods with the same method name will be injected with the same fault. required
   */
  @NonNull
  @JsonProperty("methodname")
  private String methodname;

}

