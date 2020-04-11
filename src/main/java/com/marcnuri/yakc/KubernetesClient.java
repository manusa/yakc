/*
 * Yakc.java
 *
 * Created on 2020-04-11, 12:45
 */
package com.marcnuri.yakc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.config.Configuration;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;

import java.util.Optional;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-11.
 */
public class KubernetesClient {

  private final Configuration configuration;
  private final Feign.Builder feignBuilder;

  public KubernetesClient() {
   this(Configuration.builder().build());
  }

  public KubernetesClient(Configuration configuration) {
    this.configuration = configuration;
    this.feignBuilder = initFeignBuilder();
  }

  private Feign.Builder initFeignBuilder() {
    final ObjectMapper objectMapper = initObjectMapper();
    return Feign.builder()
        .client(new OkHttpClient())
        .decoder(new JacksonDecoder(objectMapper))
        .encoder(new JacksonEncoder(objectMapper));
  }

  public <T extends Api> T target(Class<T> clazz) {
    return feignBuilder.target(clazz, getUrl());
  }

  private String getUrl() {
    final String defaultUrl = "http://localhost:8080"; // TODO -> Configuration to be retrieved from system
    return Optional.ofNullable(configuration.getUrl()).orElse(defaultUrl);
  }

  private static ObjectMapper initObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.registerModule(new JavaTimeModule());
//    objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
//    objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
//    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//    objectMapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
//    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    objectMapper.setDateFormat(new RFC3339DateFormat());
//    ThreeTenModule module = new ThreeTenModule();
//    module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
//    module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
//    module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
//    objectMapper.registerModule(module);
//    JsonNullableModule jnm = new JsonNullableModule();
//    objectMapper.registerModule(jnm);
    return objectMapper;
  }
}
