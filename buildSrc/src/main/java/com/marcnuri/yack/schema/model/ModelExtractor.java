/*
 * ModelExtractor.java
 *
 * Created on 2020-04-12, 8:51
 */
package com.marcnuri.yack.schema.model;

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
