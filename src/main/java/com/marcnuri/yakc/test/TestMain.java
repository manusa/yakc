/*
 * TestMain.java
 *
 * Created on 2020-04-05, 19:23
 */
package com.marcnuri.yakc.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodList;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.SecretList;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.APIResourceList;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;

/**
 * Created by Marc Nuri <marc@marcnuri.com> on 2020-04-05.
 */
public class TestMain {

  public static void main(String[] args){
    final ObjectMapper objectMapper = createObjectMapper();
    final Feign.Builder builder = Feign.builder()
        .client(new OkHttpClient())
        .decoder(new JacksonDecoder(objectMapper))
        .encoder(new JacksonEncoder(objectMapper));
    final PodList podList = builder.target(CoreV1Api.class, "http://localhost:8080")
            .listCoreV1PodForAllNamespaces();
    System.out.println(podList);
    final APIResourceList arl = builder.target(CoreV1Api.class, "http://localhost:8080")
        .getCoreV1APIResources();
    System.out.println(arl.toString());
    final SecretList secretList = builder.target(CoreV1Api.class, "http://localhost:8080")
        .listCoreV1SecretForAllNamespaces();
    System.out.println(secretList.toString());
  }


  private static ObjectMapper createObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
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
