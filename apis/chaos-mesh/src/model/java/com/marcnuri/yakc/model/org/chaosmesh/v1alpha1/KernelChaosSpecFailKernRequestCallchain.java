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
import lombok.ToString;

/**
 * Frame defines the function signature and predicate in function's body
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class KernelChaosSpecFailKernRequestCallchain implements Model {


  /**
   * Funcname can be find from kernel source or `/proc/kallsyms`, such as `ext4_mount`
   */
  @JsonProperty("funcname")
  private String funcname;

  /**
   * Parameters is used with predicate, for example, if you want to inject slab error in `d_alloc_parallel(struct dentry &#42;parent, const struct qstr &#42;name)` with a special name `bananas`, you need to set it to `struct dentry &#42;parent, const struct qstr &#42;name` otherwise omit it.
   */
  @JsonProperty("parameters")
  private String parameters;

  /**
   * Predicate will access the arguments of this Frame, example with Parameters's, you can set it to `STRNCMP(name-&gt;name, "bananas", 8)` to make inject only with it, or omit it to inject for all d_alloc_parallel call chain.
   */
  @JsonProperty("predicate")
  private String predicate;

}

