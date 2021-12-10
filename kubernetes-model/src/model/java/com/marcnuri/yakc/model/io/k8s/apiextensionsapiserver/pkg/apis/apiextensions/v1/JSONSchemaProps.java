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
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

/**
 * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/).
 */
@SuppressWarnings({"squid:S1192", "WeakerAccess", "unused"})
@Builder(toBuilder = true, builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JSONSchemaProps implements Model {


  @JsonProperty("$ref")
  private String $ref;

  @JsonProperty("$schema")
  private String $schema;

  @JsonProperty("additionalItems")
  private JSONSchemaPropsOrBool additionalItems;

  @JsonProperty("additionalProperties")
  private JSONSchemaPropsOrBool additionalProperties;

  @JsonProperty("allOf")
  @Singular(value = "addToAllOf", ignoreNullCollections = true)
  private List<JSONSchemaProps> allOf;

  @JsonProperty("anyOf")
  @Singular(value = "addToAnyOf", ignoreNullCollections = true)
  private List<JSONSchemaProps> anyOf;

  @JsonProperty("default")
  private Object defaults;

  @JsonProperty("definitions")
  @Singular(value = "putInDefinitions", ignoreNullCollections = true)
  private Map<String, JSONSchemaProps> definitions;

  @JsonProperty("dependencies")
  @Singular(value = "putInDependencies", ignoreNullCollections = true)
  private Map<String, JSONSchemaPropsOrStringArray> dependencies;

  @JsonProperty("description")
  private String description;

  @JsonProperty("enum")
  @Singular(value = "addToEnumeration", ignoreNullCollections = true)
  private List<Object> enumeration;

  @JsonProperty("example")
  private Object example;

  @JsonProperty("exclusiveMaximum")
  private Boolean exclusiveMaximum;

  @JsonProperty("exclusiveMinimum")
  private Boolean exclusiveMinimum;

  @JsonProperty("externalDocs")
  private ExternalDocumentation externalDocs;

  /**
   * format is an OpenAPI v3 format string. Unknown formats are ignored. The following formats are validated:<br><p> <br><p> - bsonobjectid: a bson object ID, i.e. a 24 characters hex string - uri: an URI as parsed by Golang net/url.ParseRequestURI - email: an email address as parsed by Golang net/mail.ParseAddress - hostname: a valid representation for an Internet host name, as defined by RFC 1034, section 3.1 [RFC1034]. - ipv4: an IPv4 IP as parsed by Golang net.ParseIP - ipv6: an IPv6 IP as parsed by Golang net.ParseIP - cidr: a CIDR as parsed by Golang net.ParseCIDR - mac: a MAC address as parsed by Golang net.ParseMAC - uuid: an UUID that allows uppercase defined by the regex (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?[0-9a-f]{4}-?[0-9a-f]{4}-?[0-9a-f]{12}$ - uuid3: an UUID3 that allows uppercase defined by the regex (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?3[0-9a-f]{3}-?[0-9a-f]{4}-?[0-9a-f]{12}$ - uuid4: an UUID4 that allows uppercase defined by the regex (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?4[0-9a-f]{3}-?[89ab][0-9a-f]{3}-?[0-9a-f]{12}$ - uuid5: an UUID5 that allows uppercase defined by the regex (?i)^[0-9a-f]{8}-?[0-9a-f]{4}-?5[0-9a-f]{3}-?[89ab][0-9a-f]{3}-?[0-9a-f]{12}$ - isbn: an ISBN10 or ISBN13 number string like "0321751043" or "978-0321751041" - isbn10: an ISBN10 number string like "0321751043" - isbn13: an ISBN13 number string like "978-0321751041" - creditcard: a credit card number defined by the regex ^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$ with any non digit characters mixed in - ssn: a U.S. social security number following the regex ^\d{3}[- ]?\d{2}[- ]?\d{4}$ - hexcolor: an hexadecimal color code like "#FFFFFF: following the regex ^#?([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$ - rgbcolor: an RGB color code like rgb like "rgb(255,255,2559" - byte: base64 encoded binary data - password: any kind of string - date: a date string like "2006-01-02" as defined by full-date in RFC3339 - duration: a duration string like "22 ns" as parsed by Golang time.ParseDuration or compatible with Scala duration format - datetime: a date time string like "2014-12-15T19:30:20.000Z" as defined by date-time in RFC3339.
   */
  @JsonProperty("format")
  private String format;

  @JsonProperty("id")
  private String id;

  @JsonProperty("items")
  private JSONSchemaPropsOrArray items;

  @JsonProperty("maxItems")
  private Number maxItems;

  @JsonProperty("maxLength")
  private Number maxLength;

  @JsonProperty("maxProperties")
  private Number maxProperties;

  @JsonProperty("maximum")
  private Number maximum;

  @JsonProperty("minItems")
  private Number minItems;

  @JsonProperty("minLength")
  private Number minLength;

  @JsonProperty("minProperties")
  private Number minProperties;

  @JsonProperty("minimum")
  private Number minimum;

  @JsonProperty("multipleOf")
  private Number multipleOf;

  @JsonProperty("not")
  private JSONSchemaProps not;

  @JsonProperty("nullable")
  private Boolean nullable;

  @JsonProperty("oneOf")
  @Singular(value = "addToOneOf", ignoreNullCollections = true)
  private List<JSONSchemaProps> oneOf;

  @JsonProperty("pattern")
  private String pattern;

  @JsonProperty("patternProperties")
  @Singular(value = "putInPatternProperties", ignoreNullCollections = true)
  private Map<String, JSONSchemaProps> patternProperties;

  @JsonProperty("properties")
  @Singular(value = "putInProperties", ignoreNullCollections = true)
  private Map<String, JSONSchemaProps> properties;

  @JsonProperty("required")
  @Singular(value = "addToRequired", ignoreNullCollections = true)
  private List<String> required;

  @JsonProperty("title")
  private String title;

  @JsonProperty("type")
  private String type;

  @JsonProperty("uniqueItems")
  private Boolean uniqueItems;

  /**
   * x-kubernetes-embedded-resource defines that the value is an embedded Kubernetes runtime.Object, with TypeMeta and ObjectMeta. The type must be object. It is allowed to further restrict the embedded object. kind, apiVersion and metadata are validated automatically. x-kubernetes-preserve-unknown-fields is allowed to be true, but does not have to be if the object is fully specified (up to kind, apiVersion, metadata).
   */
  @JsonProperty("x-kubernetes-embedded-resource")
  private Boolean xKubernetesEmbeddedResource;

  /**
   * x-kubernetes-int-or-string specifies that this value is either an integer or a string. If this is true, an empty type is allowed and type as child of anyOf is permitted if following one of the following patterns:<br><p> <br><p> 1) anyOf:<br><p>    - type: integer<br><p>    - type: string<br><p> 2) allOf:<br><p>    - anyOf:<br><p>      - type: integer<br><p>      - type: string<br><p>    - ... zero or more
   */
  @JsonProperty("x-kubernetes-int-or-string")
  private Boolean xKubernetesIntOrString;

  /**
   * x-kubernetes-list-map-keys annotates an array with the x-kubernetes-list-type `map` by specifying the keys used as the index of the map.<br><p> <br><p> This tag MUST only be used on lists that have the "x-kubernetes-list-type" extension set to "map". Also, the values specified for this attribute must be a scalar typed field of the child structure (no nesting is supported).<br><p> <br><p> The properties specified must either be required or have a default value, to ensure those properties are present for all list items.
   */
  @JsonProperty("x-kubernetes-list-map-keys")
  @Singular(value = "addToXKubernetesListMapKeys", ignoreNullCollections = true)
  private List<String> xKubernetesListMapKeys;

  /**
   * x-kubernetes-list-type annotates an array to further describe its topology. This extension must only be used on lists and may have 3 possible values:<br><p> <br><p> 1) `atomic`: the list is treated as a single entity, like a scalar.<br><p>      Atomic lists will be entirely replaced when updated. This extension<br><p>      may be used on any type of list (struct, scalar, ...).<br><p> 2) `set`:<br><p>      Sets are lists that must not have multiple items with the same value. Each<br><p>      value must be a scalar, an object with x-kubernetes-map-type `atomic` or an<br><p>      array with x-kubernetes-list-type `atomic`.<br><p> 3) `map`:<br><p>      These lists are like maps in that their elements have a non-index key<br><p>      used to identify them. Order is preserved upon merge. The map tag<br><p>      must only be used on a list with elements of type object.<br><p> Defaults to atomic for arrays.
   */
  @JsonProperty("x-kubernetes-list-type")
  private String xKubernetesListType;

  /**
   * x-kubernetes-map-type annotates an object to further describe its topology. This extension must only be used when type is object and may have 2 possible values:<br><p> <br><p> 1) `granular`:<br><p>      These maps are actual maps (key-value pairs) and each fields are independent<br><p>      from each other (they can each be manipulated by separate actors). This is<br><p>      the default behaviour for all maps.<br><p> 2) `atomic`: the list is treated as a single entity, like a scalar.<br><p>      Atomic maps will be entirely replaced when updated.
   */
  @JsonProperty("x-kubernetes-map-type")
  private String xKubernetesMapType;

  /**
   * x-kubernetes-preserve-unknown-fields stops the API server decoding step from pruning fields which are not specified in the validation schema. This affects fields recursively, but switches back to normal pruning behaviour if nested properties or additionalProperties are specified in the schema. This can either be true or undefined. False is forbidden.
   */
  @JsonProperty("x-kubernetes-preserve-unknown-fields")
  private Boolean xKubernetesPreserveUnknownFields;

  /**
   * x-kubernetes-validations describes a list of validation rules written in the CEL expression language. This field is an alpha-level. Using this field requires the feature gate `CustomResourceValidationExpressions` to be enabled.
   */
  @JsonProperty("x-kubernetes-validations")
  @Singular(value = "addToXKubernetesValidations", ignoreNullCollections = true)
  private List<ValidationRule> xKubernetesValidations;

}

