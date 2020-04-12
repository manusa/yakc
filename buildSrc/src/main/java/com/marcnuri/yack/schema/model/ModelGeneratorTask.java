/*
 * CodeGen.java
 *
 * Created on 2020-04-04, 17:31
 */
package com.marcnuri.yack.schema.model;

import com.marcnuri.yack.schema.GeneratorSettings;
import io.swagger.v3.oas.models.OpenAPI;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.openapitools.codegen.config.CodegenConfigurator;

import java.io.File;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-04.
 */
public class ModelGeneratorTask extends DefaultTask {

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
    final GeneratorSettings settings = GeneratorSettings.builder()
        .openAPI(openAPI)
        .logger(getLogger())
        .packageName(packageName)
        .schema(schema.toPath())
        .templatesDir(templatesDir.toPath())
        .outputDirectory(outputDirectory.toPath())
        .sourceDirectory(outputDirectory.toPath().resolve("src").resolve("model").resolve("java"))
        .build();
    new ModelGenerator(settings, openAPI).generate();
  }
}
