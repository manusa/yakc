/*
 * SchemaUtils.java
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
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-12.
 */
public class SchemaUtils {

  private static final Map<String, String> TYPE_MAP = Map.of(
      "boolean", "Boolean",
      "integer", "Integer",
      "number", "Number",
      "object", "Object",
      "string", "String"
  );

  private static final Map<String, String> PROTECTED_WORD_MAP = Map.of(
      "continue", "continue_",
      "default", "default_",
      "enum", "enum_",
      "class", "clazz"
  );

  private final GeneratorSettings settings;

  public SchemaUtils(GeneratorSettings settings) {
    this.settings = settings;
  }

  public static String refToClassName(String ref) {
    return ref.substring(ref.lastIndexOf('.') + 1);
  }

  private String refToModelPackage(String ref) {
    final String packageName = ref.substring(ref.lastIndexOf('/') + 1);
    return toModelPackage(packageName);
  }

  public String toModelPackage(String packageName) {
    return settings.getPackageName().concat(".model.").concat(sanitizePackageName(packageName));
  }

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
      imports.add(refToModelPackage(ref));
      return refToClassName(ref);
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
    if (!isObject(schema)) {
      return null;
    }
    return Optional.ofNullable(schema.getProperties())
        .map(p -> p.get("items"))
        .filter(s -> s instanceof ArraySchema)
        .map(s -> (ArraySchema)s)
        .map(as -> schemaToClassName(imports, as.getItems()))
        .orElse(null);
  }

  private static boolean isObject(Schema schema) {
    return Optional.ofNullable(schema.getType()).orElse("").equals("object");
  }

  private static String schemaTypeToJavaPrimitive(Schema schema) {
    return Optional.ofNullable(TYPE_MAP.get(schema.getType())).orElse(schema.getType());
  }

  private static String sanitizePackageName(String packageName) {
    return packageName.replace("-", "");
  }

  public static String sanitizeDescription(String description) {
    return Optional.ofNullable(description).orElse("")
        .replace("*", "&#42;")
        .replace('\u201C', '"')
        .replace('\u201D', '"')
        .replace("\n", "<br/>");
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
      throw new RuntimeException("Can't load template " + name);
    }
  }

  public static Set<String> removeUnnecessaryImports(String packageName, Set<String> imports) {
    return imports.stream()
        .filter(s -> !s.substring(0, s.lastIndexOf('.')).equals(packageName))
        .collect(Collectors.toCollection(TreeSet::new));
  }
}
