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
 * Created on 2020-04-13, 9:36
 */
package com.marcnuri.yakc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Marc Nuri on 2020-04-13.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WatchEvent<T> {
  public enum Type {
    ADDED, MODIFIED, DELETED, BOOKMARK, ERROR
  }
  private Type type;
  private T object;
}


