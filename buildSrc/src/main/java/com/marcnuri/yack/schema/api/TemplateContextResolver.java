/*
 * ApiOperationTemplateContext.java
 *
 * Created on 2020-04-10, 18:44
 */
package com.marcnuri.yack.schema.api;

import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-10.
 */
class TemplateContextResolver {

  private static final Map<String, String> TYPE_MAP = Map.of(
      "string", "String"
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
    operation.put("description", apiOperation.getOperation().getDescription());
    operation.put("headers", Collections.singletonList("Accept: ".concat(APPLICATION_JSON)));
    operation.put("method", apiOperation.getMethod());
    operation.put("path", apiOperation.getPath());
    operation.put("methodName", apiOperation.getOperation().getOperationId());
    operation.put("returnType", schemaToClassName(imports, jsonResponse.getSchema()));
    return operation;
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
}
