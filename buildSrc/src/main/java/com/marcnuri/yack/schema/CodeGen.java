/*
 * CodeGen.java
 *
 * Created on 2020-04-04, 17:31
 */
package com.marcnuri.yack.schema;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.config.CodegenConfigurator;
import org.openapitools.codegen.config.GlobalSettings;

import java.io.File;

import static org.openapitools.codegen.CodegenConstants.SERIALIZABLE_MODEL;
import static org.openapitools.codegen.languages.AbstractJavaCodegen.DATE_LIBRARY;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-04.
 */
public class CodeGen extends DefaultTask {

  @Input
  public File schema;
  @Input
  public File templatesDir;
  @Input
  public File outputDirectory;
  @Input
  public String dateLibrary = "java8";
  @Input
  public boolean serializableModel = true;

  @TaskAction
  public void run() {
//    GlobalSettings.setProperty(CodegenConstants.APIS, "false");
    GlobalSettings.setProperty(CodegenConstants.MODEL_DOCS, "false");
//    GlobalSettings.setProperty(CodegenConstants.SUPPORTING_FILES, "false");
    final CodegenConfigurator configurator = new CodegenConfigurator();
    configurator.setInputSpec(schema.getAbsolutePath());
    configurator.setTemplateDir(templatesDir.getAbsolutePath());
    configurator.addAdditionalProperty(DATE_LIBRARY, dateLibrary);
    configurator.addAdditionalProperty(SERIALIZABLE_MODEL, serializableModel);
    configurator.setGeneratorName(ModelGenerator.class.getCanonicalName());
    configurator.setOutputDir(outputDirectory.getAbsolutePath());
    new DefaultGenerator().opts(configurator.toClientOptInput()).generate();
  }
}
