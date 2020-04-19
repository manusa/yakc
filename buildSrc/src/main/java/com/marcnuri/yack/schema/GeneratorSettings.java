/*
 * GeneratorSettings.java
 *
 * Created on 2020-04-12, 8:58
 */
package com.marcnuri.yack.schema;

import io.swagger.v3.oas.models.OpenAPI;
import lombok.Builder;
import lombok.Data;
import org.gradle.api.logging.Logger;

import java.nio.file.Path;

/**
 * Created by Marc Nuri on 2020-04-12.
 */
@Builder
@Data
public class GeneratorSettings {
  private final Logger logger;
  private final String packageName;
  private final Path schema;
  private final Path templatesDir;
  private final Path outputDirectory;
  private final Path sourceDirectory;
  private final OpenAPI openAPI;
}
