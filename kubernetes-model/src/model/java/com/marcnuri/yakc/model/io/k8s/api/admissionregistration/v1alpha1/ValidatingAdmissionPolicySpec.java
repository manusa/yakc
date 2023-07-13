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

package com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1alpha1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * ValidatingAdmissionPolicySpec is the specification of the desired behavior of the AdmissionPolicy.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ValidatingAdmissionPolicySpec implements Model {


  /**
   * auditAnnotations contains CEL expressions which are used to produce audit annotations for the audit event of the API request. validations and auditAnnotations may not both be empty; a least one of validations or auditAnnotations is required.
   */
  @JsonProperty("auditAnnotations")
  @Singular(value = "addToAuditAnnotations", ignoreNullCollections = true)
  private List<AuditAnnotation> auditAnnotations;

  /**
   * failurePolicy defines how to handle failures for the admission policy. Failures can occur from CEL expression parse errors, type check errors, runtime errors and invalid or mis-configured policy definitions or bindings.<br><p> <br><p> A policy is invalid if spec.paramKind refers to a non-existent Kind. A binding is invalid if spec.paramRef.name refers to a non-existent resource.<br><p> <br><p> failurePolicy does not define how validations that evaluate to false are handled.<br><p> <br><p> When failurePolicy is set to Fail, ValidatingAdmissionPolicyBinding validationActions define how failures are enforced.<br><p> <br><p> Allowed values are Ignore or Fail. Defaults to Fail.
   */
  @JsonProperty("failurePolicy")
  private String failurePolicy;

  /**
   * MatchConditions is a list of conditions that must be met for a request to be validated. Match conditions filter requests that have already been matched by the rules, namespaceSelector, and objectSelector. An empty list of matchConditions matches all requests. There are a maximum of 64 match conditions allowed.<br><p> <br><p> If a parameter object is provided, it can be accessed via the `params` handle in the same manner as validation expressions.<br><p> <br><p> The exact matching logic is (in order):<br><p>   1. If ANY matchCondition evaluates to FALSE, the policy is skipped.<br><p>   2. If ALL matchConditions evaluate to TRUE, the policy is evaluated.<br><p>   3. If any matchCondition evaluates to an error (but none are FALSE):<br><p>      - If failurePolicy=Fail, reject the request<br><p>      - If failurePolicy=Ignore, the policy is skipped
   */
  @JsonProperty("matchConditions")
  @Singular(value = "addToMatchConditions", ignoreNullCollections = true)
  private List<MatchCondition> matchConditions;

  @JsonProperty("matchConstraints")
  private MatchResources matchConstraints;

  @JsonProperty("paramKind")
  private ParamKind paramKind;

  /**
   * Validations contain CEL expressions which is used to apply the validation. Validations and AuditAnnotations may not both be empty; a minimum of one Validations or AuditAnnotations is required.
   */
  @JsonProperty("validations")
  @Singular(value = "addToValidations", ignoreNullCollections = true)
  private List<Validation> validations;

}

