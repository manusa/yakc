/*
 * ApiGenerator.java
 *
 * Created on 2020-04-10, 8:32
 */
package com.marcnuri.yack.schema.api;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.TemplateLoader;
import io.swagger.v3.oas.models.OpenAPI;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-10.
 */
class ApiGenerator {

  private final ApiGeneratorSettings settings;
  private final OpenAPI openAPI;
  private final TemplateLoader templateLoader;
  private final TemplateContextResolver templateContextResolver;

  ApiGenerator(ApiGeneratorSettings settings, OpenAPI openAPI) {
    this.settings = settings;
    this.openAPI = openAPI;
    this.templateLoader = name -> new StringReader(readTemplate(name));
    this.templateContextResolver = new TemplateContextResolver(settings);
  }

  void generate() {
    final Map<String, List<ApiOperation>> operationTags = ApiExtractor.extractOperationTags(openAPI);
    settings.getLogger().lifecycle("Found {} operation tags", operationTags.size());
    operationTags.entrySet().stream()
        .map(this::mkPackageDirectories)
        .forEach(entry -> {
          final String tag = entry.getKey();
          settings.getLogger().lifecycle("Generating {}.{}", resolvePackageName(tag), resolveClassName(tag));
          final Map<String, Object> templateContext = templateContext(entry);
          final String fileContents = compileAndExecuteTemplate(templateContext);
          writeFile(entry.getKey(), fileContents);
        });
    settings.getLogger().lifecycle("Generated {} api entries", operationTags.size());
  }

  private String compileAndExecuteTemplate(Map<String, Object> templateContext) {
    return Mustache.compiler().withLoader(templateLoader).defaultValue("")
        .compile(readTemplate("api")).execute(templateContext);
  }

  private Map<String, Object> templateContext(Entry<String, List<ApiOperation>> entry) {
    final Map<String, Object> ret = new HashMap<>();
    final String tag = entry.getKey();
    final Set<String> imports = initDefaultImports();
    ret.put("package", resolvePackageName(tag));
    ret.put("imports", imports);
    ret.put("className", resolveClassName(tag));
    ret.put("operations", entry.getValue().stream()
        .map(apiOperation -> templateContextResolver.templateContext(imports, apiOperation))
        .filter(Objects::nonNull)
        .collect(Collectors.toList()));
    return ret;
  }

  private static Set<String> initDefaultImports() {
    return new HashSet<>(Arrays.asList(
        "feign.Headers",
        "feign.RequestLine"
    ));
  }

  private Entry<String, List<ApiOperation>> mkPackageDirectories(Entry<String, List<ApiOperation>> entry){
    try {
      FileUtils.forceMkdir(resolvePackageDirectory(entry.getKey()).toFile());
    } catch (IOException e) {
      throw new RuntimeException("Can't generate package directory for " + entry.getKey());
    }
    return entry;
  }

  private static String resolveClassName(String tag) {
    return Stream.concat(Stream.of(tag.split("\\.")), Stream.of("Api"))
        .map(StringUtils::capitalize)
        .collect(Collectors.joining());
  }

  private String resolvePackageName(String tag) {
    return settings.getPackageName().concat(".api.").concat(tag);
  }

  private Path resolvePackageDirectory(String tag) {
    return settings.getSourceDirectory().resolve(
        resolvePackageName(tag).replace('.', File.separatorChar)
    );
  }

  private String readTemplate(String name) {
    final Path template = settings.getTemplatesDir().resolve(name.concat(".mustache"));
    try {
      return Files.readString(template, StandardCharsets.UTF_8);
    } catch (IOException ex) {
      settings.getLogger().error(ex.getMessage());
      throw new RuntimeException("Can't load template " + name);
    }
  }

  private void writeFile(String tag, String fileContents) {
    final Path file = resolvePackageDirectory(tag).resolve(resolveClassName(tag).concat(".java"));
    try {
      Files.writeString(file, fileContents,
          StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException ex) {
      settings.getLogger().error(ex.getMessage());
      throw new RuntimeException("Can't write java generated class " + file.toString());
    }
  }
}
