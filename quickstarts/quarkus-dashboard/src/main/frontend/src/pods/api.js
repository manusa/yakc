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
 */
import {getApiURL} from '../env';
import {deleteNamespacedResource, toJson, updateNamespacedResource} from '../fetch';
import metadata from "../metadata";

const api = {};

api.metrics = async pod => {
  const response = await fetch(
    `${getApiURL()}/pods/${metadata.selectors.namespace(pod)}/${metadata.selectors.name(pod)}/metrics`);
  return await toJson(response);
};

api.logs = (namespace, name, container) => new EventSource(
  `${getApiURL()}/pods/${namespace}/${name}/logs/${container}`
);

api.requestDelete = deleteNamespacedResource('pods');

api.update = updateNamespacedResource('pods');

export default api;
