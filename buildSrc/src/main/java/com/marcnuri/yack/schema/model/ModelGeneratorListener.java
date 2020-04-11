package com.marcnuri.yack.schema.model;

import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public interface ModelGeneratorListener {
  default void initSettings(ModelGenerator modelGenerator) {}
  default String toDefaultValue(Schema schema) {
    return null;
  }
  default void postProcessModelProperty(CodegenModel model, CodegenProperty property) {}
}
