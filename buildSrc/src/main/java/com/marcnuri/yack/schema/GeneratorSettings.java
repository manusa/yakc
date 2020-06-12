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
  private final Path overridesDirectory;
  private final OpenAPI openAPI;
}
