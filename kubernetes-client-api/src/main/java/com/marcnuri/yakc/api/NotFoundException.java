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
 * Created on 2020-04-13, 7:41
 */
package com.marcnuri.yakc.api;

import okhttp3.Response;

/**
 * Exception thrown while performing a cluster operation against a resource that wasn't found.
 */
public class NotFoundException extends ClientErrorException {

  public NotFoundException(String message, Response rawResponse) {
    super(message, rawResponse);
  }
}
