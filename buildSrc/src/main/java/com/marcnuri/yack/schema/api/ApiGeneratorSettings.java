/*
 * ApiGeneratorSettings.java
 *
 * Created on 2020-04-11, 7:51
 */
package com.marcnuri.yack.schema.api;

import lombok.Builder;
import lombok.Data;
import org.gradle.api.logging.Logger;

import java.nio.file.Path;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-11.
 */
@Builder
@Data
class ApiGeneratorSettings {
  private final Logger logger;
  private final String packageName;
  private final Path schema;
  private final Path templatesDir;
  private final Path outputDirectory;
  private final Path sourceDirectory;
}
