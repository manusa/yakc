/*
 * ApiOperationTemplateContext.java
 *
 * Created on 2020-04-10, 18:44
 */
package com.marcnuri.yack.schema.api;

import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-10.
 */
class TemplateContextResolver {

  private static final Map<String, String> TYPE_MAP = Map.of(
      "string", "String",
      "integer", "Integer"
  );

  private static final Map<String, String> PROTECTED_WORD_MAP = Map.of(
      "continue", "continue_",
      "class", "clazz"
  );
  private static final String APPLICATION_JSON = "application/json";

  private final ApiGeneratorSettings settings;

  TemplateContextResolver(ApiGeneratorSettings settings) {
    this.settings = settings;
  }

  Map<String, Object> templateContext(Set<String> imports, ApiOperation apiOperation) {
    final ApiResponse response = apiOperation.getOperation().getResponses().get("200");
    if (response == null || !response.getContent().containsKey(APPLICATION_JSON)) {
      return null;
    }
    final MediaType jsonResponse = response.getContent().get(APPLICATION_JSON);
    final Map<String, Object> operation = new HashMap<>();
    final String methodName = apiOperation.getOperation().getOperationId()
        .replace(capitalizedTagName(apiOperation.getTag()), "");
    operation.put("description", getDescription(apiOperation));
    operation.put("descriptionParameters", apiOperation.getOperation().getDescription());
    operation.put("headers", Collections.singletonList("Accept: ".concat(APPLICATION_JSON)));
    operation.put("httpMethod", apiOperation.getMethod());
    operation.put("path", apiOperation.getPath());
    operation.put("returnType", schemaToClassName(imports, jsonResponse.getSchema()));
    operation.put("methodName", methodName);
    operation.put("pathParameters",
        templateParameters(TemplateContextResolver::getPathParameters, imports, apiOperation));
    operation.put("hasPathParameters", !getPathParameters(apiOperation).isEmpty());
    operation.put("queryParametersClassName", StringUtils.capitalize(methodName));
    operation.put("queryParameters",
        templateParameters(TemplateContextResolver::getQueryParameters, imports, apiOperation));
    operation.put("hasQueryParameters", !getQueryParameters(apiOperation).isEmpty());
    operation.put("hasRequiredQueryParameters", getQueryParameters(apiOperation).stream()
        .anyMatch(p -> Optional.ofNullable(p.getRequired()).orElse(false)));
    return operation;
  }

  private static Map<String, Object> getDescription(ApiOperation apiOperation) {
    final Map<String, Object> description = new HashMap<>();
    description.put("summary", sanitizeDescription(apiOperation.getOperation().getDescription()));
    final List<String> pathParameters = new ArrayList<>();
    description.put("pathParameters", pathParameters);
    getPathParameters(apiOperation).forEach(
        p -> pathParameters.add(String.format("@param %s %s", p.getName(), sanitizeDescription(p.getDescription())))
    );
    return description;
  }

  private List<Map<String, Object>> templateParameters(
      Function<ApiOperation, List<Parameter>> parameterProvider, Set<String> imports, ApiOperation apiOperation) {

    final List<Map<String, Object>> pathParameters = new ArrayList<>();
    parameterProvider.apply(apiOperation).forEach(p -> {
      final Map<String, Object> parameter = new HashMap<>();
      pathParameters.add(parameter);
      imports.add("feign.Param");
      imports.add("feign.QueryMap");
      imports.add("lombok.Builder");
      imports.add("lombok.Data");
      imports.add("com.fasterxml.jackson.annotation.JsonProperty");
      parameter.put("propertyName", p.getName());
      parameter.put("name", sanitizeVariable(p.getName()));
      parameter.put("description", sanitizeDescription(p.getDescription()));
      parameter.put("type", schemaToClassName(imports, p.getSchema()));
    });
    return pathParameters;
  }

  private static List<Parameter> getPathParameters(ApiOperation apiOperation) {
    return Optional.ofNullable(apiOperation.getOperation().getParameters()).orElse(Collections.emptyList())
        .stream()
        .filter(p -> Optional.ofNullable(p.getRequired()).orElse(false))
        .filter(p -> p.getIn().equals("path"))
        .collect(Collectors.toList());
  }

  private static List<Parameter> getQueryParameters(ApiOperation apiOperation) {
    return Optional.ofNullable(apiOperation.getOperation().getParameters()).orElse(Collections.emptyList())
        .stream()
        .filter(p -> p.getIn().equals("query"))
        .collect(Collectors.toList());
  }

  private String schemaToClassName(Set<String> imports, Schema schema) {
    final String ref = schema.get$ref();
    if (StringUtils.isNotBlank(ref)) {
      imports.add(refToModelPackage(ref));
      return refToClassName(ref);
    }
    return schemaTypeToJavaPrimitive(schema);
  }

  private static String schemaTypeToJavaPrimitive(Schema schema) {
    return Optional.ofNullable(TYPE_MAP.get(schema.getType())).orElse(schema.getType());
  }

  private static String refToClassName(String ref) {
    return ref.substring(ref.lastIndexOf('.') + 1);
  }

  private String refToModelPackage(String ref) {
    final String packageName = ref.substring(ref.lastIndexOf('/') + 1);
    return settings.getPackageName().concat(".model.").concat(sanitizePackageName(packageName));
  }

  private static String sanitizePackageName(String packageName) {
    return packageName.replace("-", "");
  }

  private static String sanitizeDescription(String description) {
    return description.replace("*", "&#42;").replace("\n", " ");
  }

  private static String sanitizeVariable(String variable) {
    return Optional.ofNullable(PROTECTED_WORD_MAP.get(variable)).orElse(variable);
  }

  static String resolveClassName(String tag) {
    return capitalizedTagName(tag).concat("Api");
  }

  private static String capitalizedTagName(String tag) {
    return Stream.of(tag.split("\\."))
        .map(StringUtils::capitalize)
        .collect(Collectors.joining());
  }
}
