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
 * Created on 2020-04-05, 19:33
 */
package com.marcnuri.yack.schema.api;

import com.marcnuri.yack.schema.GeneratorSettings;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri on 2020-04-05.
 */
public class ApiGeneratorTask extends DefaultTask {
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

  @TaskAction
  public void run() {
    Stream.of(schemas).forEach(this::generateApi);
    getLogger().lifecycle("Api generation completed");
  }

  private void generateApi(File schema) {
    getLogger().lifecycle("Generating API for schema {}", schema.getName());
    final OpenAPI openAPI = new OpenAPIV3Parser().read(schema.getAbsolutePath());
    final GeneratorSettings settings = GeneratorSettings.builder()
      .openAPI(openAPI)
      .logger(getLogger())
      .packageName(packageName)
      .schema(schema.toPath())
      .templatesDir(templatesDir.toPath())
      .outputDirectory(outputDirectory.toPath())
      .sourceDirectory(outputDirectory.toPath().resolve("src").resolve("api").resolve("java"))
      .overridesDirectory(outputDirectory.toPath().resolve("src").resolve("main").resolve("java"))
      .skipGenerationRegexes(Optional.ofNullable(skipGenerationRegexes).map(Arrays::asList).map(HashSet::new)
        .orElse(new HashSet<>()))
      .includeGenerationRegexes(Optional.ofNullable(includeGenerationRegexes).map(Arrays::asList).map(HashSet::new)
        .orElse(new HashSet<>()))
      .build();
    new ApiGenerator(settings).generate();
  }

}
