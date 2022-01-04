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
 * Created on 2020-04-04, 17:31
 */
package com.marcnuri.yakc.schema.model;

import com.marcnuri.yakc.schema.GeneratorSettings;
import com.marcnuri.yakc.schema.GeneratorUtils;
import com.marcnuri.yakc.schema.InlineModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Internal;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class ModelGeneratorTask extends DefaultTask {

  @Input
  public String packageName;
  @Input
  public File[] schemas;
  @Input
  public File templatesDir;
  @Input
  public File outputDirectory;
  @Input
  public String[] skipGenerationRegexes;
  @Input
  public String[] includeGenerationRegexes;

  private final Function<File, OpenAPI> converter;

  ModelGeneratorTask(Function<File, OpenAPI> converter) {
    this.converter = converter;
  }

  @TaskAction
  public void run() {
    GeneratorUtils.cleanSourceDirectory(resolveSourceDirectory());
    Stream.of(schemas).forEach(this::generateModel);
    getLogger().lifecycle("Model generation completed");
  }

  private void generateModel(File schema) {
    getLogger().lifecycle("Generating Model for schema {}", schema.getName());
    final OpenAPI openAPI = converter.apply(schema);
    new InlineModelResolver().flatten(openAPI);
    final GeneratorSettings settings = GeneratorSettings.builder()
      .openAPI(openAPI)
      .logger(getLogger())
      .packageName(packageName)
      .schema(schema.toPath())
      .templatesDir(templatesDir.toPath())
      .outputDirectory(outputDirectory.toPath())
      .sourceDirectory(resolveSourceDirectory())
      .overridesDirectory(outputDirectory.toPath().resolve("src").resolve("main").resolve("java"))
      .skipGenerationRegexes(Optional.ofNullable(skipGenerationRegexes).map(Arrays::asList).map(HashSet::new)
        .orElse(new HashSet<>()))
      .includeGenerationRegexes(Optional.ofNullable(includeGenerationRegexes).map(Arrays::asList).map(HashSet::new)
        .orElse(new HashSet<>()))
      .build();
    new ModelGenerator(settings, openAPI).generate();
  }

  public Path resolveSourceDirectory() {
    return outputDirectory.toPath().resolve("src").resolve("model").resolve("java");
  }
}
