/*
 * ApiGeneratorTask.java
 *
 * Created on 2020-04-05, 19:33
 */
package com.marcnuri.yack.schema.api;

import io.swagger.v3.oas.models.OpenAPI;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.openapitools.codegen.config.CodegenConfigurator;

import java.io.File;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class ApiGeneratorTask extends DefaultTask {
  @Input
  public String packageName;
  @Input
  public File schema;
  @Input
  public File templatesDir;
  @Input
  public File outputDirectory;

  @TaskAction
  public void run() {
    final CodegenConfigurator configurator = new CodegenConfigurator();
    configurator.setInputSpec(schema.getAbsolutePath());
    configurator.setGeneratorName("java");
    final OpenAPI openAPI = (OpenAPI)configurator.toContext().getSpecDocument();
    final ApiGeneratorSettings settings = ApiGeneratorSettings.builder()
        .logger(getLogger())
        .packageName(packageName)
        .schema(schema.toPath())
        .templatesDir(templatesDir.toPath())
        .outputDirectory(outputDirectory.toPath())
        .sourceDirectory(outputDirectory.toPath().resolve("src").resolve("api").resolve("java"))
        .build();
    new ApiGenerator(settings, openAPI).generate();
    getLogger().lifecycle("Generation completed");
  }

}
