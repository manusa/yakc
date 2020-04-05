/*
 * ModelGenerator.java
 *
 * Created on 2020-04-05, 7:18
 */
package com.marcnuri.yack.schema;

import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.languages.AbstractJavaCodegen;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class ModelGenerator extends AbstractJavaCodegen {

  private static final String NAME_REGEX = "(^.*)\\.+(.*$)";
  private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

  @Override
  public String modelPackage() {
    return "com.marcnuri.yakc.model";
  }

  @Override
  public String getLicenseName() {
    return "Apache-2.0";
  }

  @Override
  public String toModelName(String name) {
    return name;
  }

  @Override
  public String toModelFilename(String name) {
    final QualifiedName qualifiedName = qualifiedName(name);
    return String.format("%s%s%s",
      qualifiedName.packageName.replace('.', File.separatorChar),
      File.separator,
      qualifiedName.className
    );
  }

  @Override
  public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
    super.postProcessModelProperty(model, property);
    if (!property.isPrimitiveType && property.isModel && !property.isContainer) {
      final QualifiedName qualifiedName = qualifiedName(property.getBaseType());
      final String datatype = String.format("%s.%s.%s",
        modelPackage(), qualifiedName.packageName, qualifiedName.className);
      property.setDatatype(datatype);
      property.setDatatypeWithEnum(datatype);
    } else if (!property.isPrimitiveType && property.isContainer
        && property.complexType.startsWith("io.k8s.")) { // TODO: Find something more elegant
      final QualifiedName qualifiedName = qualifiedName(property.getComplexType());
      final String complexType = String.format("%s.%s.%s",
        modelPackage(), qualifiedName.packageName, qualifiedName.className);
      final String datatype = property.getDataType().replace(property.getComplexType(), complexType);
      property.setDatatype(datatype);
      property.setDatatypeWithEnum(datatype);
      property.setDefaultValue(property.getDefaultValue().replace(property.getComplexType(), ""));
    }
  }

  @Override
  public CodegenModel fromModel(String name, Schema model) {
    final CodegenModel codegenModel = super.fromModel(name, model);
    if (getSerializableModel()) {
      final Map<String, Object> vendorExtensions =
          Optional.ofNullable(codegenModel.getVendorExtensions()).orElse(new TreeMap<>());
      vendorExtensions.put("x-implements", "Serializable");
      codegenModel.setVendorExtensions(vendorExtensions);
    }
    return codegenModel;
  }

  @Override
  public Map<String, Object> postProcessAllModels(Map<String, Object> models) {
    for(Entry<String, Object> modelEntry : models.entrySet()) {
      final String modelName = modelEntry.getKey();
      if (!(modelEntry.getValue() instanceof Map)) {
        throw new IllegalArgumentException(String.format("Invalid model for: %s", modelName));
      }
      @SuppressWarnings("unchecked")
      final Map<String, Object> model = (Map<String, Object>)modelEntry.getValue();
      replaceQualifiedNames(modelName, model);
    }
    return super.postProcessAllModels(models);
  }

  private void replaceQualifiedNames(String modelName, Map<String, Object> model) {
    final QualifiedName qualifiedName = qualifiedName(modelName);
    model.put("qualifiedClassName", qualifiedName.className);
    model.put("package",
      String.format("%s.%s", modelPackage(), qualifiedName.packageName));
    model.put("apiPackage",
      String.format("%s.%s", modelPackage(), qualifiedName.packageName));
    model.put("modelPackage",
      String.format("%s.%s", modelPackage(), qualifiedName.packageName));
    model.put("packageName",
      String.format("%s.%s", modelPackage(), qualifiedName.packageName));
  }

  private static QualifiedName qualifiedName(String name) {
    final Matcher nameMatcher = NAME_PATTERN.matcher(name);
    if (!nameMatcher.find()) {
      throw new IllegalArgumentException(String.format("Illegal Qualified Name: %s", name));
    }
    return new QualifiedName(nameMatcher.group(1), nameMatcher.group(2));
  }

  private static final class QualifiedName {
    private final String packageName;
    private final String className;

    private QualifiedName(String packageName, String className) {
      this.packageName = sanitizePackageName(packageName);
      this.className = className;
    }
    private static String sanitizePackageName(String packageName) {
      return packageName.toLowerCase().replace("-", "");
    }
  }
}
