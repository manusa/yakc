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
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * FailKernRequest defines the request of kernel injection
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class KernelChaosSpecFailKernRequest implements Model {


  /**
   * Callchain indicate a special call chain, such as:     ext4_mount       -&gt; mount_subtree          -&gt; ...             -&gt; should_failslab With an optional set of predicates and an optional set of parameters, which used with predicates. You can read call chan and predicate examples from https://github.com/chaos-mesh/bpfki/tree/develop/examples to learn more. If no special call chain, just keep Callchain empty, which means it will fail at any call chain with slab alloc (eg: kmalloc).
   */
  @JsonProperty("callchain")
  @Singular(value = "addToCallchain", ignoreNullCollections = true)
  private List<KernelChaosSpecFailKernRequestCallchain> callchain;

  /**
   * FailType indicates what to fail, can be set to '0' / '1' / '2' If `0`, indicates slab to fail (should_failslab) If `1`, indicates alloc_page to fail (should_fail_alloc_page) If `2`, indicates bio to fail (should_fail_bio) You can read:   1. https://www.kernel.org/doc/html/latest/fault-injection/fault-injection.html   2. http://github.com/iovisor/bcc/blob/master/tools/inject_example.txt to learn more
   */
  @NonNull
  @JsonProperty("failtype")
  private Number failtype;

  /**
   * Headers indicates the appropriate kernel headers you need. Eg: "linux/mmzone.h", "linux/blkdev.h" and so on
   */
  @JsonProperty("headers")
  @Singular(value = "addToHeaders", ignoreNullCollections = true)
  private List<String> headers;

  /**
   * Probability indicates the fails with probability. If you want 1%, please set this field with 1.
   */
  @JsonProperty("probability")
  private Number probability;

  /**
   * Times indicates the max times of fails.
   */
  @JsonProperty("times")
  private Number times;

}

