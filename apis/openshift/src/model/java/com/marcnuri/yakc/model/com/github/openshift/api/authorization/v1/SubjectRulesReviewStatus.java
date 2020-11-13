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

package com.marcnuri.yakc.model.com.github.openshift.api.authorization.v1;

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
 * SubjectRulesReviewStatus is contains the result of a rules check
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SubjectRulesReviewStatus implements Model {


  /**
   * EvaluationError can appear in combination with Rules.  It means some error happened during evaluation that may have prevented additional rules from being populated.
   */
  @JsonProperty("evaluationError")
  private String evaluationError;

  /**
   * Rules is the list of rules (no particular sort) that are allowed for the subject
   */
  @NonNull
  @JsonProperty("rules")
  @Singular(value = "addToRules", ignoreNullCollections = true)
  private List<PolicyRule> rules;

}

