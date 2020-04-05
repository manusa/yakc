/*
 * ArraysConfigurator.java
 *
 * Created on 2020-04-05, 16:50
 */
package com.marcnuri.yack.schema;

import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.utils.ModelUtils;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class ArraysConfigurator implements ModelGeneratorListener {

  private static final String ARRAY = "array";

  @Override
  public void initSettings(ModelGenerator modelGenerator) {
    modelGenerator.getImportMapping().put("List", "java.util.List");
    modelGenerator.getImportMapping().put("ArrayList", "java.util.ArrayList");
    modelGenerator.getTypeMapping().put(ARRAY, "java.util.List");
    modelGenerator.getInstantiationTypes().put(ARRAY, "java.util.ArrayList");
  }

  @Override
  public String toDefaultValue(Schema schema) {
    if (ModelUtils.isArraySchema(schema)) {
      return "new ArrayList<>()";
    }
    return null;
  }

  @Override
  public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
    if (ARRAY.equals(property.containerType)) {
      model.imports.add("List");
      if (property.getDefaultValue() != null) {
        model.imports.add("ArrayList");
      }
    }
  }
}
