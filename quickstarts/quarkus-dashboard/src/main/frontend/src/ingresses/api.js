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
import {fixKind, toJson, updateNamespacedResource} from '../fetch';
import metadata from '../metadata';

const api = {};

api.list = async () => {
  const response = await fetch(
    `${getApiURL()}/ingresses`
  );
  const rawList =  await toJson(response);
  return fixKind('Ingress')(rawList);
};

api.requestDelete = async ingress => {
  await fetch(
    `${getApiURL()}/ingresses/${metadata.selectors.namespace(ingress)}/${metadata.selectors.name(ingress)}`,
    {method: 'DELETE'}
  );
};

api.update = updateNamespacedResource('ingresses');

export default api;
