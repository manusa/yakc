/*
 * ApiOperationTemplateContext.java
 *
 * Created on 2020-04-10, 18:44
 */
package com.marcnuri.yack.schema.api;

import com.marcnuri.yack.schema.GeneratorSettings;
import com.marcnuri.yack.schema.SchemaUtils;
import io.swagger.v3.oas.models.media.MediaType;
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

import static com.marcnuri.yack.schema.SchemaUtils.capitalizedTagName;
import static com.marcnuri.yack.schema.SchemaUtils.sanitizeDescription;
import static com.marcnuri.yack.schema.SchemaUtils.sanitizeVariable;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-10.
 */
class TemplateContextResolver {

  private static final String APPLICATION_JSON = "application/json";

  private final SchemaUtils utils;

  TemplateContextResolver(GeneratorSettings settings) {
    this.utils = new SchemaUtils(settings);
  }

  Map<String, Object> templateContext(Set<String> imports, ApiOperation apiOperation) {
    final ApiResponse response = apiOperation.getOperation().getResponses().get("200");
    if (response == null || !response.getContent().containsKey(APPLICATION_JSON)) {
      return null;
    }
    final String httpMethod = apiOperation.getMethod().name();
    final MediaType jsonResponse = response.getContent().get(APPLICATION_JSON);
    final Map<String, Object> operation = new HashMap<>();
    final String methodName = apiOperation.getOperation().getOperationId()
        .replace(capitalizedTagName(apiOperation.getTag()), "");
    imports.add(String.format("retrofit2.http.%s", httpMethod));
    operation.put("description", getDescription(apiOperation));
    operation.put("descriptionParameters", apiOperation.getOperation().getDescription());
    operation.put("headers", Collections.singletonList("Accept: ".concat(APPLICATION_JSON)));
    operation.put("httpMethod", httpMethod);
    operation.put("path", apiOperation.getPath());
    operation.put("returnType", utils.schemaToClassName(imports, jsonResponse.getSchema()));
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
    operation.put("requestBodyType", getRequestBodyType(imports, apiOperation));
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
      imports.add("retrofit2.http.Path");
      imports.add("retrofit2.http.QueryMap");
      imports.add("java.util.HashMap");
      parameter.put("propertyName", p.getName());
      parameter.put("name", sanitizeVariable(p.getName()));
      parameter.put("description", sanitizeDescription(p.getDescription()));
      parameter.put("type", utils.schemaToClassName(imports, p.getSchema()));
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

  private String getRequestBodyType(Set<String> imports, ApiOperation apiOperation) {
    return Optional.ofNullable(apiOperation.getOperation().getRequestBody())
        .map(rb -> rb.getContent().values().iterator().next().getSchema())
        .map(s -> utils.schemaToClassName(imports, s))
        .map(s -> {
          imports.add("retrofit2.http.Body");
          return s;
        })
        .orElse(null);
  }


  static String resolveClassName(String tag) {
    return capitalizedTagName(tag).concat("Api");
  }

}
