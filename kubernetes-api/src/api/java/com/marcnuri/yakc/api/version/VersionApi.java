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
 */

package com.marcnuri.yakc.api.version;

import com.marcnuri.yakc.api.Api;
import com.marcnuri.yakc.api.KubernetesCall;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.version.Info;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;

@SuppressWarnings({"squid:S1192", "unused"})
public interface VersionApi extends Api {
  /**
   * get the code version
   */
  @HTTP(
    method = "GET",
    path = "/version/"
  )
  @Headers({ 
    "Accept: */*"
  })
  KubernetesCall<Info> getCode();

}
