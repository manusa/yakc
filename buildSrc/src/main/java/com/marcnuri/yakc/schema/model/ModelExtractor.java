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
 * Created on 2020-04-12, 8:51
 */
package com.marcnuri.yakc.schema.model;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

import java.util.Map;

/**
 * Created by Marc Nuri on 2020-04-12.
 */
class ModelExtractor {

  private ModelExtractor() {}

  static Map<String, Schema> extractSchemas(OpenAPI openAPI) {
    return openAPI.getComponents().getSchemas();
  }

}
