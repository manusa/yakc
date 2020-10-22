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
import md from '../metadata';

const selectors = {};

const toObjectReducer = (acc, [key, configMap]) => {
  acc[key] = configMap;
  return acc;
};

selectors.resourcesBy = (resources = [], {
  namespace,
  ownerId
} = undefined) => Object.entries(resources)
.filter(([, resource]) => {
  if (namespace && md.selectors.namespace(resource) !== namespace) {
    return false;
  }
  if (ownerId && !md.selectors.ownerReferencesUids(resource).includes(ownerId)) {
    return false;
  }
  return true;
})
.reduce(toObjectReducer, {});

export default selectors;
