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
 * IoChaosAction defines an possible action of IoChaos
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PodIoChaosSpecActions implements Model {


  @JsonProperty("atime")
  private IoChaosSpecAttrAtime atime;

  @JsonProperty("blocks")
  private Number blocks;

  @JsonProperty("ctime")
  private IoChaosSpecAttrAtime ctime;

  /**
   * Faults represents the fault to inject
   */
  @JsonProperty("faults")
  @Singular(value = "addToFaults", ignoreNullCollections = true)
  private List<PodIoChaosSpecFaults> faults;

  @JsonProperty("gid")
  private Number gid;

  @JsonProperty("ino")
  private Number ino;

  /**
   * FileType represents type of a file
   */
  @JsonProperty("kind")
  private String kind;

  /**
   * Latency represents the latency to inject
   */
  @JsonProperty("latency")
  private String latency;

  /**
   * Methods represents the method that the action will inject in
   */
  @JsonProperty("methods")
  @Singular(value = "addToMethods", ignoreNullCollections = true)
  private List<String> methods;

  @JsonProperty("mistake")
  private PodIoChaosSpecMistake mistake;

  @JsonProperty("mtime")
  private IoChaosSpecAttrAtime mtime;

  @JsonProperty("nlink")
  private Number nlink;

  /**
   * Path represents a glob of injecting path
   */
  @NonNull
  @JsonProperty("path")
  private String path;

  /**
   * Percent represents the percent probability of injecting this action
   */
  @NonNull
  @JsonProperty("percent")
  private Number percent;

  @JsonProperty("perm")
  private Number perm;

  @JsonProperty("rdev")
  private Number rdev;

  @JsonProperty("size")
  private Number size;

  /**
   * Source represents the source of current rules
   */
  @JsonProperty("source")
  private String source;

  /**
   * IoChaosType represents the type of an IoChaos Action
   */
  @NonNull
  @JsonProperty("type")
  private String type;

  @JsonProperty("uid")
  private Number uid;

}

