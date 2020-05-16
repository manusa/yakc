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
 * Created on 2020-05-16, 8:57
 */
package com.marcnuri.yakc.quickstarts;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.marcnuri.yakc.KubernetesClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Marc Nuri on 2020-05-16.
 */
@SpringBootApplication
public class AccessClusterFromPodApplication {

  public static void main(String...  args) {
    SpringApplication.run(AccessClusterFromPodApplication.class, args);
  }

  @Bean
  public ObjectMapper objectMapper() {
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    return objectMapper;
  }

  @Bean(destroyMethod = "close")
  public KubernetesClient kubernetesClient() {
    return new KubernetesClient();
  }
}
