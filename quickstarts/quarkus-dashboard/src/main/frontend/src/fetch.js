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
import {getApiURL} from './env';
import metadata from './metadata';

const processErroredResponse = async response => {
  const responseBody = await response.text();
  let  error = `${response.status} ${response.statusText}: ${responseBody}`;
  try {
    const responseObject = JSON.parse(responseBody);
    if (responseObject.message) {
      error = `${response.status} ${response.statusText}: ${responseObject.message}`;
    }
  } catch (e) {
    // Do nothing - Fallback to default Error
  }
  throw Error(error);
};

export const processResponse = async response => {
  if (!response.ok) {
    await processErroredResponse(response);
  }
  return response;
};

export const toJson = async response => (await processResponse(response)).json();

export const fixKind = kind => resources =>
  resources.map(resource => ({kind, ...resource}));

export const updateNamespacedResource = path => async resource => {
  const headers = new Headers();
  headers.set('Content-Type', 'application/json');
  const response = await fetch(
    `${getApiURL()}/${path}/${metadata.selectors.namespace(resource)}/${metadata.selectors.name(resource)}`,
    {
      method: 'PUT',
      headers,
      body: JSON.stringify(resource)
    }
  );
  return await toJson(response);
};

export default {};