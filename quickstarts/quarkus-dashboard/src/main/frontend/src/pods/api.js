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
import metadata from '../metadata';
import {toJson} from '../fetch';

const api = {};

api.logs = (namespace, name) => new EventSource(
  `${getApiURL()}/pods/${namespace}/${name}/logs`
);

api.requestDelete = async pod => {
  await fetch(
    `${getApiURL()}/pods/${metadata.selectors.namespace(pod)}/${metadata.selectors.name(pod)}`,
    {method: 'DELETE'}
    );
};

api.update = async pod => {
  const headers = new Headers();
  headers.set('Content-Type', 'application/json');
  const response = await fetch(
    `${getApiURL()}/pods/${metadata.selectors.namespace(pod)}/${metadata.selectors.name(pod)}`,
    {
      method: 'PUT',
      headers,
      body: JSON.stringify(pod)
    }
  );
  return await toJson(response);
};

export default api;
