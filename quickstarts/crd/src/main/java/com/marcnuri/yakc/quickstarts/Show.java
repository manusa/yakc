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
 * Created on 2020-05-11, 19:36
 */
package com.marcnuri.yakc.quickstarts;

import com.marcnuri.yakc.model.Model;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDate;

import static com.marcnuri.yakc.quickstarts.ShowsV1Api.API_VERSION;
import static com.marcnuri.yakc.quickstarts.ShowsV1Api.CRD_GROUP;

/**
 * Created by Marc Nuri on 2020-05-11.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Show implements Model {

  private ObjectMeta metadata;
  private String name;
  private Double score;
  private LocalDate releaseDate;
  private URL imdb;
  public String getApiVersion() {
    return String.format("%s/%s", CRD_GROUP, API_VERSION);
  }
  public String getKind() {
    return "Show";
  }
}
