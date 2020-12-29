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
 * Created on 2020-04-12, 8:49
 */
package com.marcnuri.yack.schema.model;

import com.marcnuri.yack.schema.GeneratorException;
import com.marcnuri.yack.schema.GeneratorSettings;
import com.marcnuri.yack.schema.GeneratorUtils;
import com.marcnuri.yack.schema.SchemaUtils;
import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.TemplateLoader;
import com.samskivert.mustache.Template;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import static com.marcnuri.yack.schema.SchemaUtils.isArray;
import static com.marcnuri.yack.schema.SchemaUtils.isMap;
import static com.marcnuri.yack.schema.SchemaUtils.removeUnnecessaryImports;
import static com.marcnuri.yack.schema.SchemaUtils.sanitizeDescription;
import static com.marcnuri.yack.schema.SchemaUtils.sanitizePackageName;
import static com.marcnuri.yack.schema.SchemaUtils.sanitizeVariable;
import static com.marcnuri.yack.schema.SchemaUtils.serializerForSchema;
import static java.util.function.Predicate.not;

/**
 * Created by Marc Nuri on 2020-04-12.
 */
class ModelGenerator {

  private final GeneratorSettings settings;
  private final SchemaUtils utils;
  private final GeneratorUtils generatorUtils;
  private final TemplateLoader templateLoader;
  private final Template modelTemplate;

  ModelGenerator(GeneratorSettings settings, OpenAPI openAPI) {
    this.settings = settings;
    this.utils = new SchemaUtils(settings);
    this.generatorUtils = new GeneratorUtils(settings);
    this.templateLoader = name -> new StringReader(utils.readTemplate(name));
    this.modelTemplate = Mustache.compiler()
        .withLoader(templateLoader)
        .defaultValue("")
        .withEscaper(Escapers.NONE)
        .compile(utils.readTemplate("model"));
  }

  void generate() {
    final Map<String, Schema> schemas = ModelExtractor.extractSchemas(settings.getOpenAPI());
    settings.getLogger().lifecycle("Found {} schemas", schemas.size());
    schemas.entrySet().stream()
      .filter(GeneratorUtils.filter(settings))
      .filter(entry -> entry.getValue() instanceof ObjectSchema)
      .filter(not(this::hasOverride))
      .map(this::mkPackageDirectories)
      .forEach(entry -> {
          final String key = entry.getKey();
          settings.getLogger().lifecycle("Generating {}.{}", resolvePackageName(key), resolveClassName(key));
          final Map<String, Object> templateContext = templateContext(entry);
          final String fileContents = modelTemplate.execute(templateContext);
          writeFile(key, fileContents);
        });
    settings.getLogger().lifecycle("Generated {} model entries", schemas.size());
  }

  private Map<String, Object> templateContext(Entry<String, Schema> entry) {
    final Map<String, Object> ret = new HashMap<>();
    final String key = entry.getKey();
    final Schema schema = entry.getValue();
    final Set<String> imports = initDefaultImports();
    final List<Map<String, Object>> templateFields = templateFields(imports, schema);
    ret.put("package", resolvePackageName(key));
    ret.put("description", sanitizeDescription(schema.getDescription()));
    ret.put("kubernetesListType", Optional.ofNullable(utils.kubernetesListType(imports, schema))
      .map(klt -> {
        imports.add(settings.getPackageName().concat(".model.ListModel"));
        return klt;
      }).orElse(null));
    ret.put("className", resolveClassName(key));
    ret.put("fields", templateFields);
    if (!templateFields.isEmpty()) {
      ret.put("hasFields", true);
      imports.add("lombok.NoArgsConstructor");
      imports.add("com.fasterxml.jackson.annotation.JsonProperty");
    }
    ret.put("imports", removeUnnecessaryImports(resolvePackageName(key), imports));
    return ret;
  }

  private Set<String> initDefaultImports() {
    return new TreeSet<>(Arrays.asList(
        settings.getPackageName().concat(".model.Model"),
        "lombok.Builder",
        "lombok.AllArgsConstructor",
        "lombok.Data",
        "lombok.ToString"
    ));
  }

  private List<Map<String, Object>> templateFields(Set<String> imports, Schema schema) {
    final List<Map<String, Object>> properties = new ArrayList<>();
    final Set<Entry<String,Schema>> entries = Optional.ofNullable(schema.getProperties())
        .map(m -> (Set<Entry<String,Schema>>)m.entrySet()).orElse(Collections.emptySet());
    for (Entry<String, Schema> property : entries) {
      final Map<String, Object> templateProp = new HashMap<>();
      final Schema propertySchema = property.getValue();
      properties.add(templateProp);
      if (Optional.ofNullable(schema.getRequired()).orElse(Collections.emptyList()).contains(property.getKey())) {
        imports.add("lombok.NonNull");
        templateProp.put("required", true);
      }
      templateProp.put("hasDescription",
          !StringUtils.isBlank(sanitizeDescription(propertySchema.getDescription())));
      templateProp.put("description", sanitizeDescription(propertySchema.getDescription()));
      templateProp.put("propertyName", property.getKey());
      final String variableName = sanitizeVariable(property.getKey());
      if (isArray(propertySchema)) {
        imports.add("lombok.Singular");
        templateProp.put("singular", "addTo".concat(StringUtils.capitalize(variableName)));
      }
      if (isMap(propertySchema)) {
        imports.add("lombok.Singular");
        templateProp.put("singular", "putIn".concat(StringUtils.capitalize(variableName)));
      }
      final String serializeUsing = serializerForSchema(propertySchema);
      if(serializeUsing != null) {
        imports.add("com.fasterxml.jackson.databind.annotation.JsonSerialize");
        templateProp.put("serializeUsing", serializeUsing);
      }
      templateProp.put("type", utils.schemaToClassName(imports, propertySchema));
      templateProp.put("name", variableName);
    }
    return properties;
  }

  private Entry<String, Schema> mkPackageDirectories(Entry<String, Schema> schemaEntry){
    try {
      FileUtils.forceMkdir(resolvePackageDirectory(schemaEntry.getKey()).toFile());
    } catch (IOException e) {
      throw new GeneratorException("Can't generate package directory for " + schemaEntry.getKey());
    }
    return schemaEntry;
  }

  private boolean hasOverride(Entry<String, Schema> schemaEntry) {
    return settings.getOverridesDirectory()
      .resolve(resolvePackageName(schemaEntry.getKey()).replace('.', File.separatorChar))
      .resolve(resolveClassName(schemaEntry.getKey()).concat(".java"))
      .toFile().exists();
  }

  private String resolvePackageName(String key) {
    return sanitizePackageName(utils.toModelPackage(key.substring(0, key.lastIndexOf('.'))));
  }

  private Path resolvePackageDirectory(String tag) {
    return settings.getSourceDirectory().resolve(
        resolvePackageName(tag).replace('.', File.separatorChar)
    );
  }

  private String resolveClassName(String key){
    return SchemaUtils.refToClassName(key);
  }

  private void writeFile(String key, String fileContents) {
    final Path file = resolvePackageDirectory(key).resolve(resolveClassName(key).concat(".java"));
    generatorUtils.writeFile(file, fileContents);
  }
}
