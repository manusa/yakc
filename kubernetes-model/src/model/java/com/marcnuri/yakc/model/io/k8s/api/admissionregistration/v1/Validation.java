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

package com.marcnuri.yakc.model.io.k8s.api.admissionregistration.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Validation specifies the CEL expression which is used to apply the validation.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Validation implements Model {


  /**
   * Expression represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec CEL expressions have access to the contents of the API request/response, organized into CEL variables as well as some other useful variables:<br><p> <br><p> - 'object' - The object from the incoming request. The value is null for DELETE requests. - 'oldObject' - The existing object. The value is null for CREATE requests. - 'request' - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - 'params' - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - 'namespaceObject' - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - 'variables' - Map of composited variables, from its name to its lazily evaluated value.<br><p>   For example, a variable named 'foo' can be accessed as 'variables.foo'.<br><p> - 'authorizer' - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.<br><p>   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz<br><p> - 'authorizer.requestResource' - A CEL ResourceCheck constructed from the 'authorizer' and configured with the<br><p>   request resource.<br><p> <br><p> The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object. No other metadata properties are accessible.<br><p> <br><p> Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]&#42;` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - '__' escapes to '__underscores__' - '.' escapes to '__dot__' - '-' escapes to '__dash__' - '/' escapes to '__slash__' - Property names that exactly match a CEL RESERVED keyword escape to '__{keyword}__'. The keywords are:<br><p> 	  "true", "false", "null", "in", "as", "break", "const", "continue", "else", "for", "function", "if",<br><p> 	  "import", "let", "loop", "package", "namespace", "return".<br><p> Examples:<br><p>   - Expression accessing a property named "namespace": {"Expression": "object.__namespace__ &gt; 0"}<br><p>   - Expression accessing a property named "x-prop": {"Expression": "object.x__dash__prop &gt; 0"}<br><p>   - Expression accessing a property named "redact__d": {"Expression": "object.redact__underscores__d &gt; 0"}<br><p> <br><p> Equality on arrays with list type of 'set' or 'map' ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:<br><p>   - 'set': `X + Y` performs a union where the array positions of all elements in `X` are preserved and<br><p>     non-intersecting elements in `Y` are appended, retaining their partial order.<br><p>   - 'map': `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values<br><p>     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with<br><p>     non-intersecting keys are appended, retaining their partial order.<br><p> Required.
   */
  @NonNull
  @JsonProperty("expression")
  private String expression;

  /**
   * Message represents the message displayed when validation fails. The message is required if the Expression contains line breaks. The message must not contain line breaks. If unset, the message is "failed rule: {Rule}". e.g. "must be a URL with the host matching spec.host" If the Expression contains line breaks. Message is required. The message must not contain line breaks. If unset, the message is "failed Expression: {Expression}".
   */
  @JsonProperty("message")
  private String message;

  /**
   * messageExpression declares a CEL expression that evaluates to the validation failure message that is returned when this rule fails. Since messageExpression is used as a failure message, it must evaluate to a string. If both message and messageExpression are present on a validation, then messageExpression will be used if validation fails. If messageExpression results in a runtime error, the runtime error is logged, and the validation failure message is produced as if the messageExpression field were unset. If messageExpression evaluates to an empty string, a string with only spaces, or a string that contains line breaks, then the validation failure message will also be produced as if the messageExpression field were unset, and the fact that messageExpression produced an empty string/string with only spaces/string with line breaks will be logged. messageExpression has access to all the same variables as the `expression` except for 'authorizer' and 'authorizer.requestResource'. Example: "object.x must be less than max ("+string(params.max)+")"
   */
  @JsonProperty("messageExpression")
  private String messageExpression;

  /**
   * Reason represents a machine-readable description of why this validation failed. If this is the first validation in the list to fail, this reason, as well as the corresponding HTTP response code, are used in the HTTP response to the client. The currently supported reasons are: "Unauthorized", "Forbidden", "Invalid", "RequestEntityTooLarge". If not set, StatusReasonInvalid is used in the response to the client.
   */
  @JsonProperty("reason")
  private String reason;

}

