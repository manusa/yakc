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

package com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marcnuri.yakc.model.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ValidationRule describes a validation rule written in the CEL expression language.
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ValidationRule implements Model {


  /**
   * Message represents the message displayed when validation fails. The message is required if the Rule contains line breaks. The message must not contain line breaks. If unset, the message is "failed rule: {Rule}". e.g. "must be a URL with the host matching spec.host"
   */
  @JsonProperty("message")
  private String message;

  /**
   * Rule represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec The Rule is scoped to the location of the x-kubernetes-validations extension in the schema. The `self` variable in the CEL expression is bound to the scoped value. Example: - Rule scoped to the root of a resource with a status subresource: {"rule": "self.status.actual &lt;= self.spec.maxDesired"}<br><p> <br><p> If the Rule is scoped to an object with properties, the accessible properties of the object are field selectable via `self.field` and field presence can be checked via `has(self.field)`. Null valued fields are treated as absent fields in CEL expressions. If the Rule is scoped to an object with additionalProperties (i.e. a map) the value of the map are accessible via `self[mapKey]`, map containment can be checked via `mapKey in self` and all entries of the map are accessible via CEL macros and functions such as `self.all(...)`. If the Rule is scoped to an array, the elements of the array are accessible via `self[i]` and also by macros and functions. If the Rule is scoped to a scalar, `self` is bound to the scalar value. Examples: - Rule scoped to a map of objects: {"rule": "self.components['Widget'].priority &lt; 10"} - Rule scoped to a list of integers: {"rule": "self.values.all(value, value &gt;= 0 &amp;&amp; value &lt; 100)"} - Rule scoped to a string value: {"rule": "self.startsWith('kube')"}<br><p> <br><p> The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object and from any x-kubernetes-embedded-resource annotated objects. No other metadata properties are accessible.<br><p> <br><p> Unknown data preserved in custom resources via x-kubernetes-preserve-unknown-fields is not accessible in CEL expressions. This includes: - Unknown field values that are preserved by object schemas with x-kubernetes-preserve-unknown-fields. - Object properties where the property schema is of an "unknown type". An "unknown type" is recursively defined as:<br><p>   - A schema with no type and x-kubernetes-preserve-unknown-fields set to true<br><p>   - An array where the items schema is of an "unknown type"<br><p>   - An object where the additionalProperties schema is of an "unknown type"<br><p> <br><p> Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]&#42;` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - '__' escapes to '__underscores__' - '.' escapes to '__dot__' - '-' escapes to '__dash__' - '/' escapes to '__slash__' - Property names that exactly match a CEL RESERVED keyword escape to '__{keyword}__'. The keywords are:<br><p> 	  "true", "false", "null", "in", "as", "break", "const", "continue", "else", "for", "function", "if",<br><p> 	  "import", "let", "loop", "package", "namespace", "return".<br><p> Examples:<br><p>   - Rule accessing a property named "namespace": {"rule": "self.__namespace__ &gt; 0"}<br><p>   - Rule accessing a property named "x-prop": {"rule": "self.x__dash__prop &gt; 0"}<br><p>   - Rule accessing a property named "redact__d": {"rule": "self.redact__underscores__d &gt; 0"}<br><p> <br><p> Equality on arrays with x-kubernetes-list-type of 'set' or 'map' ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:<br><p>   - 'set': `X + Y` performs a union where the array positions of all elements in `X` are preserved and<br><p>     non-intersecting elements in `Y` are appended, retaining their partial order.<br><p>   - 'map': `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values<br><p>     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with<br><p>     non-intersecting keys are appended, retaining their partial order.
   */
  @NonNull
  @JsonProperty("rule")
  private String rule;

}

