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
 * Created on 2020-05-03, 15:27
 */
package com.marcnuri.yakc;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

/**
 * Created by Marc Nuri on 2020-05-03.
 */
public class ClusterExecutionCondition implements ExecutionCondition {

  private static Integer[] extractComponents(String version) {
    return Stream.of(version.replaceAll("[^0-9.]", "").split("\\."))
      .map(Integer::valueOf).toArray(Integer[]::new);
  }

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    final Integer[] kubernetesVersionComponents = extractComponents(
      System.getenv().getOrDefault("K8S_VERSION", Integer.MAX_VALUE + ".0.0"));
    final Integer[] minVersionComponents = extractComponents(
      context.getTestClass()
        .orElseThrow(() -> new IllegalArgumentException("@ClusterMinVersion must be used on a Class"))
        .getAnnotation(ClusterMinVersion.class).minVersion()
    );
    if (minVersionComponents.length != kubernetesVersionComponents.length) {
      throw new IllegalArgumentException(String.format("Versions must be formatted as x.x.x found %s / %s",
        kubernetesVersionComponents, minVersionComponents));
    }
    for(int it = 0; it < kubernetesVersionComponents.length; it++){
      if (kubernetesVersionComponents[it] > minVersionComponents[it]) {
        break;
      }
      if (kubernetesVersionComponents[it] < minVersionComponents[it]) {
        return ConditionEvaluationResult.disabled("Current cluster is not supported by the Test Suite");
      }
    }
    return ConditionEvaluationResult.enabled("Current cluster is supported by the Test Suite");
  }

  @Retention(RetentionPolicy.RUNTIME)
  @ExtendWith(ClusterExecutionCondition.class)
  @Target(ElementType.TYPE)
  public @interface ClusterMinVersion {
    String minVersion() default "0.0.0";
  }
}

