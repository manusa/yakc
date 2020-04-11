/*
 * ModelGenerator.java
 *
 * Created on 2020-04-05, 7:18
 */
package com.marcnuri.yack.schema.model;

import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.DefaultCodegen;
import org.openapitools.codegen.meta.features.ClientModificationFeature;
import org.openapitools.codegen.meta.features.DocumentationFeature;
import org.openapitools.codegen.meta.features.GlobalFeature;
import org.openapitools.codegen.meta.features.SchemaSupportFeature;
import org.openapitools.codegen.meta.features.SecurityFeature;
import org.openapitools.codegen.meta.features.WireFormatFeature;
import org.openapitools.codegen.utils.ModelUtils;

import java.io.File;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

import static com.marcnuri.yack.schema.model.QualifiedName.qualifiedName;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class ModelGenerator extends DefaultCodegen implements CodegenConfig {

  private final List<ModelGeneratorListener> listeners = Arrays.asList(
      new ArraysConfigurator(),
      new MapConfigurator()
  );
  private String projectFolder = "src/model";
  private String sourceFolder = projectFolder + "/java";

  public ModelGenerator() {
    initSettings();
  }

  @Override
  public String escapeReservedWord(String name) {
    if (this.reservedWordsMappings().containsKey(name)) {
      return this.reservedWordsMappings().get(name);
    }
    return "_" + name;
  }

  @Override
  public String escapeUnsafeCharacters(String input) {
    return input
        .replace("*/", "*_/")
        .replace("/*", "/_*")
        .replace('\u201C', '"')
        .replace('\u201D', '"');
  }

  @Override
  public String modelPackage() {
    return "com.marcnuri.yakc.model";
  }

  @Override
  public String modelFileFolder() {
    return (outputFolder + File.separator + sourceFolder + File.separator + modelPackage().replace('.', File.separatorChar)).replace('/', File.separatorChar);
  }

  @Override
  public String toModelName(String name) {
    return name;
  }

  @Override
  protected boolean needToImport(String type) {
    return super.needToImport(type) && !type.contains(".");
  }

  @Override
  public String getSchemaType(Schema p) {
    String openAPIType = super.getSchemaType(p);
    if (typeMapping.containsKey(openAPIType)) {
      return typeMapping.get(openAPIType);
    }
    return toModelName(openAPIType);
  }

  @Override
  public String getTypeDeclaration(Schema p) {
    if (ModelUtils.isArraySchema(p)) {
      Schema<?> items = getSchemaItems((ArraySchema) p);
      return "List<" + getTypeDeclaration(ModelUtils.unaliasSchema(this.openAPI, items)) + ">";
    } else if (ModelUtils.isMapSchema(p) && !ModelUtils.isComposedSchema(p)) {
      // Note: ModelUtils.isMapSchema(p) returns true when p is a composed schema that also defines
      // additionalproperties: true
      Schema<?> inner = getSchemaAdditionalProperties(p);
      return "Map<String, " + getTypeDeclaration(ModelUtils.unaliasSchema(this.openAPI, inner)) + ">";
    }
    return super.getTypeDeclaration(p);
  }

  @Override
  public String toDefaultValue(Schema schema) {
    final Schema referencedSchema = ModelUtils.getReferencedSchema(this.openAPI, schema);
    return listeners.stream()
        .map(l -> l.toDefaultValue(referencedSchema))
        .filter(Objects::nonNull)
        .findAny()
        .orElseGet(() -> super.toDefaultValue(referencedSchema));
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
  public CodegenModel fromModel(String name, Schema model) {
    final CodegenModel codegenModel = super.fromModel(name, model);
    final Map<String, Object> vendorExtensions =
        Optional.ofNullable(codegenModel.getVendorExtensions()).orElse(new TreeMap<>());
    vendorExtensions.put("x-implements", "Serializable");
    codegenModel.setVendorExtensions(vendorExtensions);
    return codegenModel;
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
    }
    listeners.forEach(l -> l.postProcessModelProperty(model, property));
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
    return models;
  }

  private void replaceQualifiedNames(String modelName, Map<String, Object> model) {
    final QualifiedName qualifiedName = qualifiedName(modelName);
    final String packageName = String.format("%s.%s", modelPackage(), qualifiedName.packageName);
    model.put("qualifiedClassName", qualifiedName.className);
    Stream.of("package", "apiPackage", "modelPackage", "packageName").forEach(
        property -> model.put(property, packageName)
    );
  }

  private void initSettings() {
    modifyFeatureSet(features -> features
        .includeDocumentationFeatures(DocumentationFeature.Readme)
        .wireFormatFeatures(EnumSet.of(WireFormatFeature.JSON, WireFormatFeature.XML))
        .securityFeatures(EnumSet.noneOf(
            SecurityFeature.class
        ))
        .excludeGlobalFeatures(
            GlobalFeature.XMLStructureDefinitions,
            GlobalFeature.Callbacks,
            GlobalFeature.LinkObjects,
            GlobalFeature.ParameterStyling
        )
        .excludeSchemaSupportFeatures(
            SchemaSupportFeature.Polymorphism
        )
        .includeClientModificationFeatures(
            ClientModificationFeature.BasePath
        )
    );

    supportsInheritance = true;
    modelTemplateFiles.put("model.mustache", ".java");
    hideGenerationTimestamp = false;

    setReservedWordsLowerCase(
        Arrays.asList(
            // special words
            "object",
            // used as internal variables, can collide with parameter names
            "localVarPath", "localVarQueryParams", "localVarCollectionQueryParams",
            "localVarHeaderParams", "localVarCookieParams", "localVarFormParams", "localVarPostBody",
            "localVarAccepts", "localVarAccept", "localVarContentTypes",
            "localVarContentType", "localVarAuthNames", "localReturnType",
            "ApiClient", "ApiException", "ApiResponse", "Configuration", "StringUtil",

            // language reserved words
            "abstract", "continue", "for", "new", "switch", "assert",
            "default", "if", "package", "synchronized", "boolean", "do", "goto", "private",
            "this", "break", "double", "implements", "protected", "throw", "byte", "else",
            "import", "public", "throws", "case", "enum", "instanceof", "return", "transient",
            "catch", "extends", "int", "short", "try", "char", "final", "interface", "static",
            "void", "class", "finally", "long", "strictfp", "volatile", "const", "float",
            "native", "super", "while", "null")
    );

    languageSpecificPrimitives = new HashSet<>(
        Arrays.asList(
            "String",
            "boolean",
            "Boolean",
            "Double",
            "Integer",
            "Long",
            "Float",
            "Object",
            "byte[]")
    );

    importMapping.put("BigDecimal", "java.math.BigDecimal");
    importMapping.put("JsonProperty", "com.fasterxml.jackson.annotation.JsonProperty");
    importMapping.put("JsonSubTypes", "com.fasterxml.jackson.annotation.JsonSubTypes");
    importMapping.put("JsonTypeInfo", "com.fasterxml.jackson.annotation.JsonTypeInfo");
    importMapping.put("JsonCreator", "com.fasterxml.jackson.annotation.JsonCreator");
    importMapping.put("JsonValue", "com.fasterxml.jackson.annotation.JsonValue");
    importMapping.put("JsonIgnore", "com.fasterxml.jackson.annotation.JsonIgnore");
    importMapping.put("JsonInclude", "com.fasterxml.jackson.annotation.JsonInclude");
    importMapping.put("IOException", "java.io.IOException");
    importMapping.put("Objects", "java.util.Objects");
    typeMapping.put("date", "LocalDate");
    importMapping.put("LocalDate", "java.time.LocalDate");
    typeMapping.put("DateTime", "LocalDateTime");
    importMapping.put("LocalDateTime", "java.time.LocalDateTime");
    listeners.forEach(l -> l.initSettings(this));
  }

   Map<String, String> getImportMapping() {
    return importMapping;
  }

  Map<String, String> getTypeMapping() {
    return typeMapping;
  }

  Map<String, String> getInstantiationTypes() {
    return instantiationTypes;
  }
}
