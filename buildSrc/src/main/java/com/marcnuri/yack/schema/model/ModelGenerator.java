/*
 * ModelGeneratorV2.java
 *
 * Created on 2020-04-12, 8:49
 */
package com.marcnuri.yack.schema.model;

import com.marcnuri.yack.schema.GeneratorSettings;
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
import static com.marcnuri.yack.schema.SchemaUtils.sanitizeVariable;

/**
 * Created by Marc Nuri on 2020-04-12.
 */
class ModelGenerator {

  private final GeneratorSettings settings;
  private final SchemaUtils utils;
  private final TemplateLoader templateLoader;
  private final Template modelTemplate;

  ModelGenerator(GeneratorSettings settings, OpenAPI openAPI) {
    this.settings = settings;
    this.utils = new SchemaUtils(settings);
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
        .map(this::mkPackageDirectories)
        .filter(entry -> entry.getValue() instanceof ObjectSchema)
        .forEach(entry -> {
          final String key = entry.getKey();
          settings.getLogger().lifecycle("Generating {}.{}", resolvePackageName(key), resolveClassName(key));
          final Map<String, Object> templateContext = templateContext(entry);
          final String fileContents = modelTemplate.execute(templateContext);
          writeFile(key, fileContents);
        });
    settings.getLogger().lifecycle("Generated {} api entries", schemas.size());
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
    ret.put("hasFields", !templateFields.isEmpty());
    ret.put("imports", removeUnnecessaryImports(resolvePackageName(key), imports));
    return ret;
  }

  private Set<String> initDefaultImports() {
    return new TreeSet<>(Arrays.asList(
        settings.getPackageName().concat(".model.Model"),
        "lombok.Builder",
        "lombok.AllArgsConstructor",
        "lombok.NoArgsConstructor",
        "lombok.Data",
        "lombok.ToString",
        "com.fasterxml.jackson.annotation.JsonProperty"
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
      templateProp.put("type", utils.schemaToClassName(imports, propertySchema));
      templateProp.put("name", variableName);
    }
    return properties;
  }

  private Entry<String, Schema> mkPackageDirectories(Entry<String, Schema> schemaEntry){
    try {
      FileUtils.forceMkdir(resolvePackageDirectory(schemaEntry.getKey()).toFile());
    } catch (IOException e) {
      throw new RuntimeException("Can't generate package directory for " + schemaEntry.getKey());
    }
    return schemaEntry;
  }

  private String resolvePackageName(String key) {
    return utils.toModelPackage(key.substring(0, key.lastIndexOf('.')));
  }

  private Path resolvePackageDirectory(String tag) {
    return settings.getSourceDirectory().resolve(
        resolvePackageName(tag).replace('.', File.separatorChar)
    );
  }

  private String resolveClassName(String key){
    return key.substring(key.lastIndexOf('.') + 1);
  }

  private void writeFile(String key, String fileContents) {
    final Path file = resolvePackageDirectory(key).resolve(resolveClassName(key).concat(".java"));
    try {
      Files.writeString(file, fileContents,
          StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException ex) {
      settings.getLogger().error(ex.getMessage());
      throw new RuntimeException("Can't write java generated class " + file.toString());
    }
  }
}
