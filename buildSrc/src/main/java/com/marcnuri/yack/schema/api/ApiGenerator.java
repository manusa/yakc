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
 * Created on 2020-04-10, 8:32
 */
package com.marcnuri.yack.schema.api;

import com.marcnuri.yack.schema.GeneratorException;
import com.marcnuri.yack.schema.GeneratorSettings;
import com.marcnuri.yack.schema.GeneratorUtils;
import com.marcnuri.yack.schema.SchemaUtils;
import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.marcnuri.yack.schema.SchemaUtils.removeUnnecessaryImports;
import static com.marcnuri.yack.schema.SchemaUtils.sanitizePackageName;
import static com.marcnuri.yack.schema.api.TemplateContextResolver.resolveClassName;

/**
 * Created by Marc Nuri on 2020-04-10.
 */
class ApiGenerator {

  private final GeneratorSettings settings;
  private final SchemaUtils utils;
  private final TemplateContextResolver templateContextResolver;
  private final Template apiTemplate;

  ApiGenerator(GeneratorSettings settings) {
    this.settings = settings;
    utils = new SchemaUtils(settings);
    this.templateContextResolver = new TemplateContextResolver(settings);
    this.apiTemplate = Mustache.compiler()
        .withLoader(name -> new StringReader(utils.readTemplate(name)))
        .defaultValue("")
        .withEscaper(Escapers.NONE)
        .compile(utils.readTemplate("api"));
  }

  void generate() {
    final Map<String, List<ApiOperation>> operationTags = ApiExtractor.extractOperationTags(settings);
    settings.getLogger().lifecycle("Found {} operation tags", operationTags.size());
    operationTags.entrySet().stream()
        .filter(GeneratorUtils.filter(settings))
        .map(this::mkPackageDirectories)
        .forEach(entry -> {
          final String tag = entry.getKey();
          settings.getLogger().lifecycle("Generating {}.{}", resolvePackageName(tag), resolveClassName(tag));
          final Map<String, Object> templateContext = templateContext(entry);
          final String fileContents = apiTemplate.execute(templateContext);
          writeFile(entry.getKey(), fileContents);
        });
    settings.getLogger().lifecycle("Generated {} api entries", operationTags.size());
  }

  private Map<String, Object> templateContext(Entry<String, List<ApiOperation>> entry) {
    final Map<String, Object> ret = new HashMap<>();
    final String tag = entry.getKey();
    final Set<String> imports = initDefaultImports();
    ret.put("package", resolvePackageName(tag));
    ret.put("className", resolveClassName(tag));
    ret.put("operations", entry.getValue().stream()
        .map(apiOperation -> templateContextResolver.templateContext(imports, apiOperation))
        .filter(Objects::nonNull)
        .collect(Collectors.toList()));
    ret.put("imports", removeUnnecessaryImports(resolvePackageName(tag), imports));
    return ret;
  }

  private Set<String> initDefaultImports() {
    return new TreeSet<>(Collections.singletonList(
      settings.getPackageName().concat(".api.Api")
    ));
  }

  private Entry<String, List<ApiOperation>> mkPackageDirectories(Entry<String, List<ApiOperation>> entry){
    try {
      FileUtils.forceMkdir(resolvePackageDirectory(entry.getKey()).toFile());
    } catch (IOException e) {
      throw new GeneratorException("Can't generate package directory for " + entry.getKey());
    }
    return entry;
  }

  private String resolvePackageName(String tag) {
    return sanitizePackageName(settings.getPackageName().concat(".api.").concat(tag));
  }

  private Path resolvePackageDirectory(String tag) {
    return settings.getSourceDirectory().resolve(
        resolvePackageName(tag).replace('.', File.separatorChar)
    );
  }

  private void writeFile(String tag, String fileContents) {
    final Path file = resolvePackageDirectory(tag).resolve(resolveClassName(tag).concat(".java"));
    try {
      Files.writeString(file, fileContents,
          StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException ex) {
      settings.getLogger().error(ex.getMessage());
      throw new GeneratorException("Can't write java generated class " + file.toString());
    }
  }
}
