/*
 * MapConfigurator.java
 *
 * Created on 2020-04-05, 16:56
 */
package com.marcnuri.yack.schema.model;

import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.utils.ModelUtils;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class MapConfigurator implements ModelGeneratorListener {

  @Override
  public void initSettings(ModelGenerator modelGenerator) {
    modelGenerator.getImportMapping().put("Map", "java.util.Map");
    modelGenerator.getImportMapping().put("HashMap", "java.util.HashMap");
    modelGenerator.getTypeMapping().put("map", "java.util.Map");
    modelGenerator.getInstantiationTypes().put("map", "java.util.HashMap");
  }

  @Override
  public String toDefaultValue(Schema schema) {
    if (ModelUtils.isMapSchema(schema)) {
      return "new HashMap<>()";
    }
    return null;
  }

  @Override
  public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
    if ("map".equals(property.containerType)) {
      model.imports.add("Map");
      if (property.getDefaultValue() != null || property.getDefaultValueWithParam() != null) {
        model.imports.add("HashMap");
      }
    }
  }
}
