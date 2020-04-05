package com.marcnuri.yack.schema;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
class QualifiedName {

  private static final String NAME_REGEX = "(^.*)\\.+(.*$)";
  private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

  final String packageName;
  final String className;

  private QualifiedName(String packageName, String className) {
    this.packageName = sanitizePackageName(packageName);
    this.className = className;
  }

  private static String sanitizePackageName(String packageName) {
    return packageName.toLowerCase().replace("-", "");
  }

  static QualifiedName qualifiedName(String name) {
    final Matcher nameMatcher = NAME_PATTERN.matcher(name);
    if (!nameMatcher.find()) {
      throw new IllegalArgumentException(String.format("Illegal Qualified Name: %s", name));
    }
    return new QualifiedName(nameMatcher.group(1), nameMatcher.group(2));
  }
}
