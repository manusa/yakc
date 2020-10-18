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
 *
 * Created on 2020-04-12, 8:57
 */
package com.marcnuri.yack.schema;

import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri on 2020-04-12.
 */
public class SchemaUtils {

  public static final String APPLICATION_JSON = "application/json";

  private static final String OBJECT_PRIMITIVE = "Object";
  private static final String STRING_PRIMITIVE = "String";

  private static final Map<String, String> REF_MAP = Map.of(
    "#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1beta1.JSON", OBJECT_PRIMITIVE,
    "#/components/schemas/io.k8s.apiextensions-apiserver.pkg.apis.apiextensions.v1.JSON", OBJECT_PRIMITIVE
  );

  private static final Map<String, String> REF_SERIALIZER_MAP = Map.of(
    "#/components/schemas/io.k8s.apimachinery.pkg.util.intstr.IntOrString", "com.marcnuri.yakc.model.serialization.IntOrStringSerializer.class"
  );

  private static final Map<String, String> TYPE_MAP = Map.of(
      "boolean", "Boolean",
      "integer", "Number",
      "number", "Number",
      "object", OBJECT_PRIMITIVE,
      "string", STRING_PRIMITIVE
  );

  private static final Map<String, String> PROTECTED_WORD_MAP = Map.of(
      "continue", "continues",
      "default", "defaults",
      "enum", "enumeration",
      "class", "clazz"
  );

  private final GeneratorSettings settings;

  public SchemaUtils(GeneratorSettings settings) {
    this.settings = settings;
  }

  private static String refToClassName(String ref) {
    return ref.substring(ref.lastIndexOf('.') + 1);
  }

  private String refToModelPackage(String ref) {
    final String packageName = ref.substring(ref.lastIndexOf('/') + 1, ref.lastIndexOf('.'));
    return toModelPackage(packageName).concat(ref.substring(ref.lastIndexOf('.')));
  }

  public String toModelPackage(String packageName) {
    return settings.getPackageName().concat(".model.").concat(sanitizePackageName(packageName));
  }

  /**
   * Returns the mapped Class name associated to the provided {@link Schema} and adds
   * an import to the canonical path of the class represented by that name if necessary.
   *
   * @param imports Set containing the current processed Class imports.
   * @param schema the schema from which to retrieve the mapped Class name.
   * @return String containing the Class name mapped to the provided Schema.
   */
  public String schemaToClassName(Set<String> imports, Schema schema) {
    final String ref = schema.get$ref();
    if (isArray(schema)) {
      final ArraySchema arraySchema = (ArraySchema)schema;
      imports.add("java.util.List");
      return String.format("List<%s>", schemaToClassName(imports, arraySchema.getItems()));
    }
    if (isMap(schema)) {
      imports.add("java.util.Map");
      final String valueType;
      if (schema.getAdditionalProperties() instanceof Schema) {
        valueType = schemaToClassName(imports, (Schema)schema.getAdditionalProperties());
      } else {
        valueType = "Object";
      }
      return String.format("Map<String, %s>", valueType);
    }
    if (schema instanceof DateTimeSchema || isRefInstanceOf(ref, DateTimeSchema.class)) {
      imports.add("java.time.OffsetDateTime");
      return "OffsetDateTime";
    }
    if (schema instanceof StringSchema || isRefInstanceOf(ref, StringSchema.class)) {
      return "String";
    }
    if (StringUtils.isNotBlank(ref)) {
      return schemaRefToJavaPrimitive(schema)
        .orElseGet(() -> {
          imports.add(refToModelPackage(ref));
          return refToClassName(ref);
        });
    }
    return schemaTypeToJavaPrimitive(schema);
  }

  public static boolean isArray(Schema schema) {
    return schema instanceof ArraySchema;
  }

  public static boolean isMap(Schema schema) {
    return schema instanceof MapSchema;
  }

  public boolean isRefInstanceOf(String ref, Class clazz) {
    if (ref == null) {
      return false;
    }
    return settings.getOpenAPI().getComponents().getSchemas().entrySet().stream()
        .filter(entry -> clazz.isInstance(entry.getValue()))
        .anyMatch(entry -> ref.endsWith(entry.getKey()));
  }

  public String kubernetesListType(Set<String> imports, Schema schema) {
    if (schema == null || !isObject(schema)) {
      return null;
    }
    return Optional.ofNullable(schema.getProperties())
        .map(p -> p.get("items"))
        .filter(s -> s instanceof ArraySchema)
        .map(s -> (ArraySchema)s)
        .map(as -> schemaToClassName(imports, as.getItems()))
        .orElse(null);
  }

  public Schema resolveComponentSchema(Schema schema) {
    return Optional.ofNullable(schema.get$ref())
        .map(ref -> ref.replaceAll("^#/components/schemas/", ""))
        .map(ref -> this.settings.getOpenAPI().getComponents().getSchemas().get(ref))
        .orElse(null);
  }

  public String kubernetesCallType(Set<String> imports, Schema schema) {
    final boolean isKubernetesList = Optional.ofNullable(resolveComponentSchema(schema))
        .map(Schema::getProperties)
        .map(p -> p.get("items"))
        .filter(s -> s instanceof ArraySchema)
        .isPresent();
    final String kubernetesCallType;
    if (isKubernetesList) {
      kubernetesCallType = "KubernetesListCall";
    } else {
      kubernetesCallType = "KubernetesCall";
    }
    imports.add(settings.getPackageName().concat(".api.").concat(kubernetesCallType));
    return kubernetesCallType;
  }

  private static boolean isObject(Schema schema) {
    return Optional.ofNullable(schema.getType()).orElse("").equals("object");
  }

  public static boolean isPatch(Schema schema){
    return schema.get$ref() != null && schema.get$ref().equals("#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.Patch");
  }

  private static Optional<String> schemaRefToJavaPrimitive(Schema schema) {
    return Optional.ofNullable(REF_MAP.get(schema.get$ref()));
  }

  private static String schemaTypeToJavaPrimitive(Schema schema) {
    return Optional.ofNullable(TYPE_MAP.get(schema.getType())).orElse(schema.getType());
  }

  public static String sanitizePackageName(String packageName) {
    return packageName.replace("-", "").toLowerCase();
  }

  public static String sanitizeDescription(String description) {
    return Optional.ofNullable(description).orElse("")
        .replace("&", "&amp;")
        .replace("*", "&#42;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace('\u201C', '"')
        .replace('\u201D', '"')
        .replace("\n", "<br><p> ");
  }

  public static String sanitizeVariable(String variable) {
    return StringUtils.uncapitalize(
        Stream.of(Optional.ofNullable(PROTECTED_WORD_MAP.get(variable)).orElse(variable).split("-"))
        .map(StringUtils::capitalize)
        .collect(Collectors.joining())
    );
  }

  public static String capitalizedTagName(String tag) {
    return Stream.of(tag.split("\\."))
        .map(StringUtils::capitalize)
        .collect(Collectors.joining());
  }

  public String readTemplate(String name) {
    final Path template = settings.getTemplatesDir().resolve(name.concat(".mustache"));
    try {
      return Files.readString(template, StandardCharsets.UTF_8);
    } catch (IOException ex) {
      settings.getLogger().error(ex.getMessage());
      throw new GeneratorException("Can't load template " + name);
    }
  }

  public static Set<String> removeUnnecessaryImports(String packageName, Set<String> imports) {
    return imports.stream()
        .filter(s -> !s.substring(0, s.lastIndexOf('.')).equals(packageName))
        .collect(Collectors.toCollection(TreeSet::new));
  }

  public static String serializerForSchema(Schema schema) {
    return Optional.ofNullable(schema)
      .map(Schema::get$ref)
      .map(REF_SERIALIZER_MAP::get)
      .orElse(null);
  }
}
