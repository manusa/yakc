/*
 * ApiExtractor.java
 *
 * Created on 2020-04-10, 9:13
 */
package com.marcnuri.yack.schema.api;

import com.marcnuri.yack.schema.GeneratorSettings;
import com.marcnuri.yack.schema.api.ApiOperation.Method;
import io.swagger.v3.oas.models.PathItem;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-10.
 */
class ApiExtractor {

  private ApiExtractor() {}

  static Map<String, List<ApiOperation>> extractOperationTags(GeneratorSettings settings) {
    return settings.getOpenAPI().getPaths().entrySet().stream()
        .flatMap(ApiExtractor::extractOperations)
        .flatMap(ApiExtractor::taggedOperation)
        .collect(Collectors.toMap(
            Entry::getKey,
            Entry::getValue,
            (l1, l2) -> Stream.of(l1, l2).flatMap(List::stream).collect(Collectors.toList()))
        );
  }

  private static Stream<Entry<String, List<ApiOperation>>> taggedOperation(ApiOperation apiOperation) {
    return apiOperation.getOperation().getTags().stream()
        .map(tag -> tag.replace('_', '.'))
        .map(tag -> apiOperation.toBuilder().tag(tag).build())
        .collect(Collectors.toMap(ApiOperation::getTag, Collections::singletonList))
        .entrySet()
        .stream();
  }

  private static Stream<ApiOperation> extractOperations(Entry<String, PathItem> pathEntry) {
    final PathItem pathItem = pathEntry.getValue();
    return Stream.of(
        ApiOperation.builder().operation(pathItem.getDelete()).method(Method.DELETE).build(),
        ApiOperation.builder().operation(pathItem.getGet()).method(Method.GET).build(),
        ApiOperation.builder().operation(pathItem.getHead()).method(Method.HEAD).build(),
        ApiOperation.builder().operation(pathItem.getOptions()).method(Method.OPTIONS).build(),
        ApiOperation.builder().operation(pathItem.getPatch()).method(Method.PATCH).build(),
        ApiOperation.builder().operation(pathItem.getPost()).method(Method.POST).build(),
        ApiOperation.builder().operation(pathItem.getPut()).method(Method.PUT).build(),
        ApiOperation.builder().operation(pathItem.getTrace()).method(Method.TRACE).build()
    )
        .filter(apiOperation -> apiOperation.getOperation() != null)
        .map(apiOperation -> apiOperation.toBuilder().path(pathEntry.getKey()).build());
  }
}
