/*
 * CodeGen.java
 *
 * Created on 2020-04-04, 17:31
 */
package com.marcnuri.yack.schema.model;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.config.CodegenConfigurator;

import java.io.File;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-04.
 */
public class ModelGeneratorTask extends DefaultTask {

  @Input
  public File schema;
  @Input
  public File templatesDir;
  @Input
  public File outputDirectory;

  @TaskAction
  public void run() {
//    GlobalSettings.setProperty(CodegenConstants.MODEL_DOCS, "false");
    final CodegenConfigurator configurator = new CodegenConfigurator();
    configurator.setInputSpec(schema.getAbsolutePath());
    configurator.setTemplateDir(templatesDir.getAbsolutePath());
    configurator.setGeneratorName(ModelGenerator.class.getCanonicalName());
    configurator.setOutputDir(outputDirectory.getAbsolutePath());
    final DefaultGenerator generator = new DefaultGenerator();
    generator.setGenerateMetadata(false);
    generator.opts(configurator.toClientOptInput()).generate();
  }
}
