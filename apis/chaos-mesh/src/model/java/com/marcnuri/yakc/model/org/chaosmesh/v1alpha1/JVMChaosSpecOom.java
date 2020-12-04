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
 * OOM represents the detail about JVM chaos action of OOM exception
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JVMChaosSpecOom implements Model {


  /**
   * After represents method execution is completed before the injection failure is returned.
   */
  @JsonProperty("after")
  private Boolean after;

  /**
   * Area represents JVM memory area, currently supported [HEAP, NOHEAP, OFFHEAP], required. Eden+Old is denoted by HEAP Metaspace is denoted by NOHEAP off-heap memory is denoted by OFFHEAP
   */
  @NonNull
  @JsonProperty("area")
  private String area;

  /**
   * Block represents specifies the size of the object that supports only the HEAP and OFFHEAP areas in MB
   */
  @JsonProperty("block")
  private String block;

  /**
   * Classname represents specify the class name, which must be an implementation class with a full package name, such as com.xxx.xxx.XController. required
   */
  @NonNull
  @JsonProperty("classname")
  private String classname;

  /**
   * Interval represents unit MS, default interval between 500 OOM exceptions, only in non-violent mode, can slow down the frequency of GC without worrying about the process being unresponsive
   */
  @JsonProperty("interval")
  private Number interval;

  /**
   * Methodname represents specify the method name. Note that methods with the same method name will be injected with the same fault. required
   */
  @NonNull
  @JsonProperty("methodname")
  private String methodname;

  /**
   * WildMode represents default false, whether to turn on wild mode or not. If it is wild mode, the memory created before will not be released after OOM occurrence, which may cause the application process to be unresponsive
   */
  @JsonProperty("wildmode")
  private Boolean wildmode;

}

