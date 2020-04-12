/*
 * ApiGenerator.java
 *
 * Created on 2020-04-10, 8:32
 */
package com.marcnuri.yack.schema.api;

import com.marcnuri.yack.schema.GeneratorSettings;
import com.marcnuri.yack.schema.SchemaUtils;
import com.samskivert.mustache.Escapers;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.TemplateLoader;
import com.samskivert.mustache.Template;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
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

import static com.marcnuri.yack.schema.api.TemplateContextResolver.resolveClassName;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-10.
 */
class ApiGenerator {

  private final GeneratorSettings settings;
  private final SchemaUtils utils;
  private final TemplateLoader templateLoader;
  private final TemplateContextResolver templateContextResolver;
  private final Template apiTemplate;

  ApiGenerator(GeneratorSettings settings) {
    this.settings = settings;
    utils = new SchemaUtils(settings);
    this.templateLoader = name -> new StringReader(utils.readTemplate(name));
    this.templateContextResolver = new TemplateContextResolver(settings);
    this.apiTemplate = Mustache.compiler()
        .withLoader(templateLoader)
        .defaultValue("")
        .withEscaper(Escapers.NONE)
        .compile(utils.readTemplate("api"));
  }

  void generate() {
    final Map<String, List<ApiOperation>> operationTags = ApiExtractor.extractOperationTags(settings);
    settings.getLogger().lifecycle("Found {} operation tags", operationTags.size());
    operationTags.entrySet().stream()
        .map(this::mkPackageDirectories)
        .forEach(entry -> {
          final String tag = entry.getKey();
          settings.getLogger().lifecycle("Generating {}.{}", resolvePackageName(tag), resolveClassName(tag));
          final Map<String, Object> templateContext = templateContext(entry);
          final String fileContents = apiTemplate.execute(templateContext);
          writeFile(entry.getKey(), fileContents);
        });
    settings.getLogger().lifecycle("Generated {} api entries", operationTags.size());
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

  private Set<String> initDefaultImports() {
    return new HashSet<>(Arrays.asList(
        settings.getPackageName().concat(".api.Api"),
        "retrofit2.Call"
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

  private String resolvePackageName(String tag) {
    return settings.getPackageName().concat(".api.").concat(tag);
  }

  private Path resolvePackageDirectory(String tag) {
    return settings.getSourceDirectory().resolve(
        resolvePackageName(tag).replace('.', File.separatorChar)
    );
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
