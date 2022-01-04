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
 * Created on 2022-01-04, 16:02
 */
package com.marcnuri.yakc.schema.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.gradle.api.GradleException;

import java.io.IOException;

public class CrdModelGeneratorTask extends ModelGeneratorTask {
  private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());
  public CrdModelGeneratorTask() {
    super(crd -> {
      try {
        final JsonNode parsed = YAML_MAPPER.readTree(crd);
        final ArrayNode versions = (ArrayNode) parsed.get("spec").get("versions");
        final JsonNode openAPIV3Schema = versions.get(0).get("schema").get("openAPIV3Schema");
        final var result = new OpenAPIV3Parser().readContents(YAML_MAPPER.writeValueAsString(openAPIV3Schema));
        System.out.println(result);
      } catch (IOException e) {
        throw new GradleException(e.getMessage(), e);
      }
      throw new UnsupportedOperationException("TODO");
    });
  }
}
