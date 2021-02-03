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
 * Created on 2020-05-11, 19:33
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.NotFoundException;
import com.marcnuri.yakc.api.WatchEvent.Type;
import com.marcnuri.yakc.api.apiextensions.v1.ApiextensionsV1Api;
import com.marcnuri.yakc.api.core.v1.CoreV1Api;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Namespace;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinition;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionNames;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionSpec;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceDefinitionVersion;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.CustomResourceValidation;
import com.marcnuri.yakc.model.io.k8s.apiextensionsapiserver.pkg.apis.apiextensions.v1.JSONSchemaProps;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.DeleteOptions;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static com.marcnuri.yakc.quickstarts.ShowsV1Api.API_VERSION;
import static com.marcnuri.yakc.quickstarts.ShowsV1Api.CRD_GROUP;
import static com.marcnuri.yakc.quickstarts.ShowsV1Api.CRD_NAME;

/**
 * Created by Marc Nuri on 2020-05-11.
 */
public class CrdQuickstart {

  private static final String NAMESPACE = "yakc-namespace";

  public static void main(String[] args) {
    System.out.println("Complete Custom Resource Definition (CRD) example:\n"
      + " - Creates a namespace\n"
      + " - Deletes CRD if exists\n"
      + " - Creates CRD\n"
      + " - Creates custom resource - TV Show\n"
      + " - List entries for custom resource - TV Show\n"
      + " - Patch entry for custom resource - TV Show\n"
      + " - List patched entries for custom resource - TV Show\n"
      + "Starting...\n");
    try (KubernetesClient kc = new KubernetesClient()) {
      final CoreV1Api core = kc.create(CoreV1Api.class);
      final ApiextensionsV1Api extensions = kc.create(ApiextensionsV1Api.class);
      final ShowsV1Api shows = kc.create(ShowsV1Api.class);
      createNamespace(core);
      deleteCrdIfExists(extensions);
      createCrd(extensions);
      createShows(shows);
      listShows(shows);
      patchShow(shows);
      listShows(shows);
      deleteCrd(extensions);
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }

  private static void createNamespace(CoreV1Api api) throws IOException {
    try {
      api.readNamespace(NAMESPACE).get();
      System.out.printf("Namespace with name %s is available%n", NAMESPACE);
    } catch (NotFoundException ex) {
      System.out.printf("No existing Namespace with name %s, creating a new one%n", NAMESPACE);
      api.createNamespace(Namespace.builder()
        .metadata(ObjectMeta.builder().name(NAMESPACE).build())
        .build()
      ).get();
      api.listNamespace().watch()
        .filter(we -> we.getObject().getMetadata().getName().equals(NAMESPACE))
        .takeUntil(we -> we.getType() == Type.ADDED)
        .subscribe();
    }
  }

  private static void deleteCrd(ApiextensionsV1Api api) throws IOException {
    api.deleteCustomResourceDefinition(CRD_NAME,
      DeleteOptions.builder().propagationPolicy("Background").gracePeriodSeconds(10).build())
      .get(CustomResourceDefinition.class); // Swagger/OpenAPI is wrong
  }

  private static void deleteCrdIfExists(ApiextensionsV1Api api) throws IOException {
    try {
      if (api.listCustomResourceDefinition().stream().noneMatch(crd -> crd.getMetadata().getName().equals(CRD_NAME))){
        return;
      }
      System.out.printf("Waiting for pre-existing CRD %s to be deleted%n", CRD_NAME);
      api.listCustomResourceDefinition().watch()
        .doOnSubscribe(s -> deleteCrd(api))
        .filter(we -> we.getObject().getMetadata().getName().equals(CRD_NAME))
        .takeUntil(we -> we.getType() == Type.DELETED)
        .subscribe();
      System.out.printf("Existing CRD %s was deleted%n", CRD_NAME);
    } catch (NotFoundException ex) {
      System.out.printf("No existing CRDs with name %s%n", CRD_NAME);
    }
  }

  private static void createCrd(ApiextensionsV1Api api) throws IOException {
    api.createCustomResourceDefinition(
      CustomResourceDefinition.builder()
        .metadata(ObjectMeta.builder()
          .name(CRD_NAME)
          .build())
        .spec(CustomResourceDefinitionSpec.builder()
          .group(CRD_GROUP)
          .addToVersions(CustomResourceDefinitionVersion.builder()
            .name(API_VERSION)
            .served(true)
            .storage(true)
            .schema(CustomResourceValidation.builder()
              .openAPIV3Schema(JSONSchemaProps.builder()
                .type("object")
                .addToRequired("spec")
                .putInProperties("spec", JSONSchemaProps.builder()
                  .type("object")
                  .addToRequired("name")
                  .addToRequired("releaseDate")
                  .putInProperties("name", JSONSchemaProps.builder()
                    .type("string")
                    .minimum(1)
                    .build())
                  .putInProperties("releaseDate", JSONSchemaProps.builder()
                    .type("string")
                    .format("date")
                    .minimum(1)
                    .build())
                  .putInProperties("score", JSONSchemaProps.builder()
                    .type("number")
                    .format("double")
                    .build())
                  .putInProperties("imdb", JSONSchemaProps.builder()
                    .type("string")
                    .format("uri")
                    .build())
                  .build())
                .build())
              .build())
            .build())
          .scope("Namespaced")
          .names(CustomResourceDefinitionNames.builder()
            .kind("Show")
            .singular("show")
            .plural("shows")
            .build())
          .build())
        .build()).get();
  }

  private static void createShows(ShowsV1Api api) throws IOException {
    api.createNamespacedShow(NAMESPACE, Show.builder()
      .metadata(ObjectMeta.builder()
        .name("house-of-cards")
        .putInLabels("app", "shows")
        .build())
      .spec(ShowSpec.builder()
        .name("House of Cards")
        .releaseDate(LocalDate.of(2013, Month.FEBRUARY, 1))
        .imdb(new URL("https://www.imdb.com/title/tt1856010/"))
        .build())
      .build()
    ).get();
    api.createNamespacedShow(NAMESPACE, Show.builder()
      .metadata(ObjectMeta.builder()
        .name("breaking-bad")
        .putInLabels("app", "shows")
        .build())
      .spec(ShowSpec.builder()
        .name("Breaking Bad")
        .releaseDate(LocalDate.of(2008, Month.JANUARY, 20))
        .score(9.5)
        .imdb(new URL("https://www.imdb.com/title/tt0903747/"))
        .build())
      .build()
    ).get();
    api.createNamespacedShow(NAMESPACE, Show.builder()
      .metadata(ObjectMeta.builder()
        .name("band-of-brothers")
        .putInLabels("app", "shows")
        .build())
      .spec(ShowSpec.builder()
        .name("Band of Brothers")
        .releaseDate(LocalDate.of(2001, Month.SEPTEMBER, 9))
        .imdb(new URL("https://www.imdb.com/title/tt0903747/"))
        .build())
      .build()
    ).get();
  }

  private static void listShows(ShowsV1Api api) throws IOException {
    final String format = "%-30.30s %-10.10s %-5.5s %-45.45s%n";
    System.out.printf(format, "SHOW", " AIR DATE ", "SCORE", "IMDB URL");
    System.out.printf(format, "====", "==========", "=====", "========");
    api.listNamespacedShow(NAMESPACE).stream()
      .map(Show::getSpec)
      .forEach(show -> System.out.printf(format,
        show.getName(), show.getReleaseDate().toString(),
        Optional.ofNullable(show.getScore()).map(Object::toString).orElse(""),
        show.getImdb()));
    System.out.printf("%n");
  }

  private static void patchShow(ShowsV1Api api) throws IOException {
    System.out.println("Patching show scores...\n");
    api.patchNamespacedShow("breaking-bad", NAMESPACE, Show.builder()
      .spec(ShowSpec.builder().score(10D).build()).build())
      .get();
    api.patchNamespacedShow("house-of-cards", NAMESPACE, Show.builder()
      .spec(ShowSpec.builder().score(8.7).build()).build())
      .get();
  }
}
